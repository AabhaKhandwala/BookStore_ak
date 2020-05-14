import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Utils {
    public static void loadStringsToArray(ArrayList<String> arrList) throws IOException {
        Path path = Paths.get("C:\\Users\\aabha\\Desktop\\WIN\\JAVA\\Lab\\0514\\BookStore\\Titles.txt");
        arrList.clear();

        // The stream file will also be closed here
        try (Stream<String> lines = Files.lines(path)) {
            Object[] arr = lines.toArray();

            for (Object t : arr) {
                arrList.add(t.toString());
            }
        }
    }

}