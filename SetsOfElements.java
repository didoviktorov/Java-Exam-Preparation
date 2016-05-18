import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] lenghts = scanner.nextLine().trim().split("\\s+");
        int firstLenght = Integer.parseInt(lenghts[0]);
        int secondLenght = Integer.parseInt(lenghts[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();
        List<String> repeatingElements = new ArrayList<>();

        for (int i = 0; i < firstLenght; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < secondLenght; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        for (Integer number : firstSet) {
            if(secondSet.contains(number)){
                repeatingElements.add(number + "");
            }
        }

        System.out.println(String.join(" ", repeatingElements));
    }
}
