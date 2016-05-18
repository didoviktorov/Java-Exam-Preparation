import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Integer> counter = new TreeMap<>();
        for (int i = 0; i < line.length(); i++) {
            if (!counter.containsKey(line.charAt(i) + "")) {
                counter.put(line.charAt(i) + "", 1);
            } else {
                counter.put(line.charAt(i) + "", counter.get(line.charAt(i) + "") + 1);
            }
        }

        for (Map.Entry<String, Integer> pair : counter.entrySet()) {
            System.out.println(pair.getKey() + ": " + pair.getValue() + " time/s");
        }
    }
}
