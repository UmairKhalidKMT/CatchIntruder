import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class IntruderDetector {

    private static final String[] ATTACK_PATTERNS = {
        "/etc/passwd",
        "/root/.ssh/id_rsa",
        "/var/www/html/index.php"
    };

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        PrintWriter printWriter = new PrintWriter(System.out);

        byte[] bytes = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(bytes)) != -1) {
            String line = new String(bytes, 0, bytesRead);

            for (String attackPattern : ATTACK_PATTERNS) {
                if (line.contains(attackPattern)) {
                    printWriter.println("Intruder detected!");
                    break;
                }
            }
        }

        printWriter.close();
    }
}
