package javanio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

// summary of java.io vs java.nio for text data (UTF-8)
// for small files that the content can fit in memory, use nio with .readAllLines
// for large files where you need to read one line at a time, use java.io (better performance)
// for multi-threaded applications (that act on files on multiple threads), use java.nio (since it deals with it)
public class JavaNioMain {
    public static void main(String[] args) {
        // reading/writing file sequentially
        try {
//            FileInputStream file = new FileInputStream("data.txt");
//            FileChannel channel = file.getChannel();

            // above is not used because Java 8 implemented a better way (below)
            Path dataPath = FileSystems.getDefault().getPath("data.txt");
            // needs to convert string to bytes before writing, because Files.write write bytes directly
            Files.write(dataPath, "\nLine 5".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);

            List<String> lines = Files.readAllLines(dataPath, StandardCharsets.UTF_8); // utf-8 is default already, not needed
            for (String line: lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
