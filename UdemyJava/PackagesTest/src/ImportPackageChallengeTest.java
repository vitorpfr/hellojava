import com.example.packagechallenge.Series;

public class ImportPackageChallengeTest {

    // Packages module was built as an artifact (JAR)
    // here we're going to import use and use its com.example.game package

    // File > Project structure > Libraries > Add > Java > select .jar file > Select modules to add

    public static void main(String[] args) {
        // com.example.packagechallenge.Series was automatically imported!

        for (int i = 0; i < 8; i++) {
            System.out.println(Series.nSum(i));
        }

        System.out.println("--------------");

        for (int i = 0; i < 8; i++) {
            System.out.println(Series.factorial(i));
        }

        System.out.println("--------------");

        for (int i = 0; i < 8; i++) {
            System.out.println(Series.fibonacci(i));
        }
    }
}
