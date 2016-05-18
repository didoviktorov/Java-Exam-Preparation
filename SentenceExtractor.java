import java.util.*;
import java.util.regex.*;

public class SentenceExtractor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        String text = scanner.nextLine();

        Pattern sentenceRegex = Pattern.compile("([^.!?]+(?=[.!?])[.!?])");
        Pattern wordRegex = Pattern.compile(".*?\\b" + word + "\\b.*?");

        Matcher matcher = sentenceRegex.matcher(text);
        Matcher wordMatcher;
        while(matcher.find()){
            String sentence = matcher.group().trim();
            wordMatcher = wordRegex.matcher(sentence);

            if(wordMatcher.find()){
                System.out.println(sentence);
            }
        }

    }
}
