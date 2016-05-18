import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogsAggregator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfRows = Integer.parseInt(scanner.nextLine());
        Pattern regex = Pattern.compile("(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}" +
                "([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])" +
                "\\s+([A-Za-z]{1,20})\\s+([1-9][0-9]{0,2}|1000)\\b");

        TreeMap<String, Integer> aggregator = new TreeMap<>();
        LinkedHashMap<String, TreeSet<String>> ipLog = new LinkedHashMap<>();
        for (int i = 0; i < numberOfRows; i++) {
            String line = scanner.nextLine();
            Matcher matcher = regex.matcher(line);
            if(matcher.find()){
                line = line.replace("\\s+", " ");
                String[] logInfo = line.split(" ");
                String ip = logInfo[0];
                String username = logInfo[1];
                int sessionTime = Integer.parseInt(logInfo[2]);

                if(!aggregator.containsKey(username)){
                    aggregator.put(username, 0);
                    ipLog.put(username, new TreeSet<>());
                }

                aggregator.put(username, aggregator.get(username) + sessionTime);
                ipLog.get(username).add(ip);
            }
        }

        for (Map.Entry<String, Integer> user : aggregator.entrySet()) {
            System.out.println(
                    String.format("%s: %d %s", user.getKey(), user.getValue(), ipLog.get(user.getKey()).toString()));
        }
    }
}
