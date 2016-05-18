import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().trim();
        Map<String, Long> mine = new LinkedHashMap<>();
        String key = "";
        int currentIndex = 0;
        while (!line.equals("stop")) {
            if (currentIndex % 2 == 0) {
                key = line;
                if(!mine.containsKey(key)){
                    mine.put(key, 0l);
                }
            } else {
                mine.put(key, mine.get(key) + Long.parseLong(line.trim()));
            }

            line = scanner.nextLine();
            currentIndex++;
        }

        for (Map.Entry<String, Long> resources : mine.entrySet()) {
            System.out.println(resources.getKey() + " -> " + resources.getValue());
        }
    }
}
