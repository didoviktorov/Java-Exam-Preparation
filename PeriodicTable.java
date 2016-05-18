import java.util.*;
public class PeriodicTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfLine = Integer.parseInt(scanner.nextLine().trim());

        Set<String> compounds = new TreeSet<>();

        for (int i = 0; i < numberOfLine; i++) {
            String[] elements = scanner.nextLine().trim().split("\\s+");
            for (int j = 0; j < elements.length; j++) {
                compounds.add(elements[j]);
            }
        }

        System.out.println(String.join(" ", compounds));
    }
}
