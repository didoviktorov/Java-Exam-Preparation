import java.util.Scanner;
import java.util.regex.*;

public class UseYourChains {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern regex = Pattern.compile("<p>(.+?)<\\/p>");
        Matcher matcher = regex.matcher(text);

        StringBuilder finalText = new StringBuilder();
        while (matcher.find()) {
            String textToDecrypt = matcher.group(1);
            textToDecrypt = textToDecrypt.replaceAll("[^a-z0-9]+", " ");
            //textToDecrypt = textToDecrypt.replaceAll("\\s+", " ");

            for (int i = 0; i < textToDecrypt.length(); i++) {
                if (textToDecrypt.charAt(i) < 110 && textToDecrypt.charAt(i) > 96) {
                    finalText.append((char)(textToDecrypt.charAt(i) + 13));
                } else if (textToDecrypt.charAt(i) >= 110 && textToDecrypt.charAt(i) < 123) {
                    finalText.append((char)(textToDecrypt.charAt(i) - 13));
                } else {
                    finalText.append(textToDecrypt.charAt(i));
                }
            }
        }

        System.out.println(finalText.toString());
    }
}
