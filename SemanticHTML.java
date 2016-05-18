import java.util.Scanner;
import java.util.regex.*;

public class SemanticHTML {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pattern openDiv = Pattern.compile("<\\s*?(div)\\s*?.*?((id|class)\\s*?=\\s*?\"\\s*?(header|main|nav|article|section|aside|footer)\\s*\")\\s*?.*>");
        Pattern closeDiv = Pattern.compile("<(\\s*\\/\\s*div\\s*)>(\\s*<\\s*!\\s*--\\s*(nav|header|main|article|section|aside|footer)\\s*--\\s*>)");

        String line = scanner.nextLine();
        while (!line.equals("END")) {
            Matcher open = openDiv.matcher(line);
            if(open.find()){
                line = line.replaceAll(open.group(1), open.group(4));
                line = line.replaceAll(open.group(2), "");
                line = line.replaceAll("\\s+", " ");
                line = line.replaceAll("\\s+\\>", ">");
            }

            Matcher close = closeDiv.matcher(line);
            if(close.find()){
                line = line.replaceAll(close.group(1), "/" + close.group(3));
                line = line.replaceAll(close.group(2), "");
            }

            System.out.println(line);
            line = scanner.nextLine();
        }

    }
}
