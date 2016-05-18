import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceTag {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pattern regexOpen = Pattern.compile("(<a\\s*href=).*?>");
        Pattern regexClose = Pattern.compile("(<\\s*\\/\\s*a\\s*>)");

        StringBuilder sb = new StringBuilder();
        String line = scanner.nextLine();
        while (!line.equals("end")) {
            Matcher open = regexOpen.matcher(line);
            while(open.find()){
                line = line.replaceAll(open.group(1), "[URL href=");
            }

            Matcher close = regexClose.matcher(line);
            while(close.find()){
                line = line.replaceAll(close.group(1), "[/URL]");
            }

            for (int i = 0; i < line.length(); i++) {
                sb.append(line.charAt(i));
            }
            //System.out.println(line);
            line = scanner.nextLine();
        }

        System.out.println(sb.toString());
    }
}
