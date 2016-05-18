import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SrabskoUnleashed {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pattern regex = Pattern.compile("^([A-Za-z ]+?)\\s@([A-Za-z ]+?)\\s([0-9]{1,2}|1[0-9]{1,2}|200)\\s([0-9]{1,5}|100000)$");

        LinkedHashMap<String, LinkedHashMap<String, Long>> venues = new LinkedHashMap<>();

        Matcher marcher;
        String line = scanner.nextLine();
        while (!line.equals("End")) {
            marcher = regex.matcher(line);
            if (marcher.find()) {
                String name = marcher.group(1);
                String venue = marcher.group(2);
                int price = Integer.parseInt(marcher.group(3));
                int ticketCount = Integer.parseInt(marcher.group(4));
                long totalMoney = price * ticketCount;

                if (!venues.containsKey(venue)) {
                    venues.put(venue, new LinkedHashMap<>());
                    venues.get(venue).put(name, totalMoney);
                } else if (!venues.get(venue).containsKey(name)) {
                    venues.get(venue).put(name, totalMoney);
                } else {
                    venues.get(venue).put(name, venues.get(venue).get(name) + totalMoney);
                }
            }

            line = scanner.nextLine();
        }

        for (Map.Entry<String, LinkedHashMap<String, Long>> venue : venues.entrySet()) {
            System.out.println(venue.getKey());
            LinkedHashMap<String, Long> sortedSingers = venue.getValue()
                    .entrySet()
                    .stream()
                    .sorted((money1, money2) -> {
                        long total1 = Long.valueOf(money1.getValue());
                        long total2 = Long.valueOf(money2.getValue());

                        if (total1 != total2) {
                            return Long.compare(total2, total1);
                        }

                        return Long.compare(total1, total2);
                    }).collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (x, y) -> {
                                throw new AssertionError();
                            },
                            LinkedHashMap::new
                    ));

            for (Map.Entry<String, Long> singer : sortedSingers.entrySet()) {
                System.out.println(String.format("#  %s -> %d", singer.getKey(), singer.getValue()));
            }
        }
    }
}
