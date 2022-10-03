import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class WorkWithFiles {

    public static List<String> read(String way) throws IOException {
        List<String> list;
        try {
            list = (Files.readAllLines(Paths.get(way), StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new IOException();
        }
        return list;
    }

    public static void write(String way, List<String> list) throws IOException {

        try (FileWriter fw = new FileWriter(way)) {
            for (String i : list) {
                fw.write(i);
                fw.write("\n");
            }
        } catch (Exception e) {
            throw new IOException();

        }
    }
}