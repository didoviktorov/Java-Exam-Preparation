import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class ValidUsernames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pattern regex = Pattern.compile("^[A-Za-z][A-Za-z0-9_]{2,25}$");

        String line = scanner.nextLine();
        Matcher matcher = regex.matcher(line);
        String[] allNames = line.replaceAll("[\\s+\\/\\(\\)\\\\]", " ").trim().split(" ");
        List<String> validNames = new ArrayList<>();
        for (int i = 0; i < allNames.length; i++) {
            matcher = regex.matcher(allNames[i]);
           if(matcher.find()){
               validNames.add(allNames[i]);
           }
        }

        int maxLenght = 0;
        int index = 0;
        for (int i = 1; i < validNames.size(); i++) {
            int currentLenght = 0;
            currentLenght = validNames.get(i - 1).length() + validNames.get(i).length();

            if(currentLenght > maxLenght){
                maxLenght = currentLenght;
                index = i - 1;
            }
        }

        System.out.println(validNames.get(index));
        System.out.println(validNames.get(index + 1));
    }
}
