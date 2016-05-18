import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        Pattern pattern =
                Pattern.compile("[^.|^-]\\b([a-z]+[\\._\\-]?[a-z]+)@([a-z]+[\\.\\-]?[a-z]+[\\.]?[a-z]*[\\.]+?[a-z]+)\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
