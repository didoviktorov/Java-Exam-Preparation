import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, String> fixedEmails = new LinkedHashMap<>();

        String key = "";
        int currentIndex = 0;
        while (!line.equals("stop")){
            if (currentIndex % 2 == 0) {
                key = line;
            } else {
                if(!line.endsWith("us") && !line.endsWith("uk")){
                    fixedEmails.put(key, line);
                }

            }

            currentIndex++;
            line = scanner.nextLine();
        }

        for (Map.Entry<String, String> emails : fixedEmails.entrySet()) {
            System.out.println(emails.getKey() + " -> " + emails.getValue());
        }
    }
}

