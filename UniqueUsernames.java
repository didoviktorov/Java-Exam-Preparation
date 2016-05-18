import java.util.*;

public class UniqueUsernames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        int numberOfLines = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < numberOfLines; i++) {
            String nameToAdd = scanner.nextLine();
            if(!names.contains(nameToAdd)){
                names.add(nameToAdd);
            }
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}

