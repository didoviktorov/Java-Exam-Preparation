import java.util.Scanner;
import java.util.regex.*;

public class ExtractHyperlinks {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pattern regex = Pattern.compile("<a\\s+(?:[^>]+\\s+)?href\\s*=\\s*(?:'([^']*)'|\"([^\"\"]*)\"|([^\\s>]+))[^>]*>");
        Matcher matcher;

        String line = scanner.nextLine();
        while (!line.equals("END")) {
            matcher = regex.matcher(line);
            while (matcher.find()) {
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    System.out.println(matcher.group(i));
                }
            }
            line = scanner.nextLine();
        }
    }
}
