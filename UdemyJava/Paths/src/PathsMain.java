import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

// why did java.nio introduced Path, given that java.io has File class?
    // many methods in the File class don't throw exceptions or provide specific error messages (e.g. File.delete())
    // File.rename() works differently on different platforms, which shouldn't be happening on Java
    // no support for symbolic links on File class (a file that points to another file)
    // File class does not provide way to get metadata about a file (permissions, owner, security)
    // File methods do not perform well when working with lots of data

// java.nio approach:
    // Path class deals with paths in a abstract way (mount paths, retrieve paths, etc)
    // Files class have static methods that receive paths and return data about the file in that path (e.g. Files.exists()) or change the file in that path somehow

public class PathsMain {
    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //// reading file in current work directory
        // FileSystems.getDefault() retrieve default directory (absolute), then relative path is added to form absolute path
        System.out.println("--- first file ---");
        Path path1 = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path1);

        //// reading file in subdirectory
        System.out.println("--- second file ---");
        Path path2 = FileSystems.getDefault().getPath("files", "SubdirectoryFile.txt"); // opt 1
//        Path path2 = Paths.get(".", "files", "SubdirectoryFile.txt"); // opt 2
        printFile(path2);

        //// reading file outside default directory
        System.out.println("--- third file ---");
//        Path path3 = Paths.get("/Users/vitorfreitas/dev/personal/hellojava/OutThere.txt"); // opt 1: absolute
        Path path3 = Paths.get("..", "OutThere.txt"); // opt 1: absolute
        printFile(path3);

        System.out.println("Current path:");
        Path currentPath = Paths.get(".");
        System.out.println(currentPath.toAbsolutePath());

        Path nonExistingFile = FileSystems.getDefault().getPath("thisfiledoesnotexist.txt");
        System.out.println(nonExistingFile.toAbsolutePath()); // it works because Path concept is abstract (file may not exist)

        Path path4 = Paths.get("/Volumes/Test/ING", "abcdef.txt");
        System.out.println(path4.toAbsolutePath());

        // check if a file exists in a path
        System.out.println("Exists = " + Files.exists(path1));
        System.out.println("Exists = " + Files.exists(nonExistingFile));
        System.out.println("NotExists = " + Files.notExists(nonExistingFile)); // true

        // check files permissions
        System.out.println(Files.isReadable(path1));
        System.out.println(Files.isWritable(path1));
        System.out.println(Files.isExecutable(path1));
        System.out.println(path1.getClass().getName()); // sun.nio.fs.UnixPath (showing that Path is an interface, and the actual class varies by OS)

        // file operations using Files class
        try {
            // copy file from source path to target path
            Path copyPath = FileSystems.getDefault().getPath("copy.txt");
            Files.copy(path1, copyPath, REPLACE_EXISTING);

            // move or rename file
            Path movePath = FileSystems.getDefault().getPath("copy2.txt");
            Files.move(copyPath, movePath, REPLACE_EXISTING);

            // delete file
            Files.delete(movePath);

            // deleteIfExists also tries to delete, but doesn't throw an exception if the file does not exist
            Files.copy(path1, copyPath, REPLACE_EXISTING);
            Files.deleteIfExists(copyPath);
            Files.deleteIfExists(copyPath); // doesn't throw an exception

            // create files and directories
            // (usually this would be done with writing a stream, but Files class can do it anyway
            // file
            Path fileToCreate = FileSystems.getDefault().getPath("data2.txt");
//            Files.createFile(fileToCreate);

            // directory
            Path dirToCreate = FileSystems.getDefault().getPath("files", "examplefolder");
//            Files.createDirectory(dirToCreate);

            // multiple directories - it also doesn't throw exception if already created
            String sep = FileSystems.getDefault().getSeparator(); // can be / (unix) or \ (windows)
            String newDir = "examplefolder" + sep + "1" + sep + "2" + sep + "3" + sep + "4" + sep + "5";
            Path dirToCreate2 = FileSystems.getDefault().getPath("files", newDir);
            Files.createDirectories(dirToCreate2);

            // get file properties: size (in bytes) and last modified date
            System.out.println("Size = " + Files.size(path1));
            System.out.println("Last modified = " + Files.getLastModifiedTime(path1));
            System.out.println("Owner = " + Files.getOwner(path1));

            // get all attributes at once (bulk operation)
            BasicFileAttributes attrs = Files.readAttributes(path1, BasicFileAttributes.class);
            System.out.println("Size = " + attrs.size());
            System.out.println("Last modified = " + attrs.lastModifiedTime());
            System.out.println("Created = " + attrs.creationTime());
            System.out.println("Is directory = " + attrs.isDirectory());
            System.out.println("Is regular file = " + attrs.isRegularFile());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
