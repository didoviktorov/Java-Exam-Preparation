import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> people = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("JOKER")) {
            String[] personHand = line.split(":");
            String name = personHand[0];
            String hand = personHand[1].trim();
            String[] handCards = hand.split(", ");

            if (!people.containsKey(name)) {
                people.put(name, new LinkedHashSet<>());
                for (int i = 0; i < handCards.length; i++) {
                    people.get(name).add(handCards[i]);
                }
            } else {
                for (int i = 0; i < handCards.length; i++) {
                    people.get(name).add(handCards[i]);
                }
            }

            line = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> peopleHand : people.entrySet()) {
            int handValue = 0;
            handValue = calculateCardValue(peopleHand.getValue());

            System.out.println(peopleHand.getKey() + ": " + handValue);
        }
    }

    private static Integer calculateCardValue(Set<String> hand) {
        int result = 0;
        for (String card : hand) {
            String value = card.substring(0, card.length() - 1);
            String type  = card.charAt(card.length() - 1) + "";

            int multiplier;
            switch (type){
                case "S":
                    multiplier = 4;
                    break;
                case "H":
                    multiplier = 3;
                    break;
                case "D":
                    multiplier = 2;
                    break;
                default:
                    multiplier = 1;
                    break;
            }

            switch (value){
                case "2":
                    result += 2 * multiplier;
                    break;
                case "3":
                    result += 3 * multiplier;
                    break;
                case "4":
                    result += 4 * multiplier;
                    break;
                case "5":
                    result += 5 * multiplier;
                    break;
                case "6":
                    result += 6 * multiplier;
                    break;
                case "7":
                    result += 7 * multiplier;
                    break;
                case "8":
                    result += 8 * multiplier;
                    break;
                case "9":
                    result += 9 * multiplier;
                    break;
                case "10":
                    result += 10 * multiplier;
                    break;
                case "J":
                    result += 11 * multiplier;
                    break;
                case "Q":
                    result += 12 * multiplier;
                    break;
                case "K":
                    result += 13 * multiplier;
                    break;
                default:
                    result += 14 * multiplier;
            }
        }

        return result;
    }
}
