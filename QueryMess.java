import java.util.*;
import java.util.regex.*;

public class QueryMess {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pattern regex = Pattern.compile("(.+)=(.+)");

        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String[] pairs = line.split("&");
            LinkedHashMap<String, List<String>> info = new LinkedHashMap<>();
            for (int i = 0; i < pairs.length; i++) {
                Matcher matcher = regex.matcher(pairs[i]);
                if(matcher.find()){
                    String key = matcher.group(1).replaceAll("\\+", " ")
                            .replaceAll("%20", " ").replaceAll("\\s+", " ").trim();

                    String value = matcher.group(2).replaceAll("\\+", " ")
                            .replaceAll("%20", " ").replaceAll("\\s+", " ").trim();

                    if(key.contains("?")){
                        key = key.substring(key.indexOf("?") + 1, key.length());
                    }

                    if(value.contains("?")){
                        value = value.substring(value.indexOf("?") + 1, value.length());
                    }

                    if(!info.containsKey(key)){
                        info.put(key, new ArrayList<>());
                    }

                    info.get(key).add(value);
                }
            }

            for (Map.Entry<String, List<String>> entry : info.entrySet()) {
                System.out.printf("%s=%s", entry.getKey(), entry.getValue().toString());
            }

            System.out.println();
            line = scanner.nextLine();
        }
    }
}
