import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().trim();

        Map<String, String> phonebook = new LinkedHashMap<>();
        while (!line.toLowerCase().equals("search")) {
            String[] contactInfo = line.split("-");

            String name = null;
            String number = null;

            if (contactInfo.length > 1) {
                name = contactInfo[0];
                number = contactInfo[1];
                phonebook.put(name, number);
            }

            line = scanner.nextLine().trim();
        }
        String key = scanner.nextLine();
        while (!key.toLowerCase().equals("stop")) {

            if (phonebook.containsKey(key)) {
                System.out.println(key + " -> " + phonebook.get(key).toString());
            } else {
                System.out.println(String.format("Contact %s does not exist.%n", key));
            }

            key = scanner.nextLine();
        }
    }
}
