import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeriesOfLetters {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<String> regexs = new ArrayList<>();

        String regex = line.charAt(0) + "";
        for (int i = 1; i < line.length(); i++) {
            if (line.charAt(i) == line.charAt(i - 1)) {
                regex += line.charAt(i);
            } else {
                if(regex.length() > 1){
                    regexs.add(regex);
                }

                regex = line.charAt(i)+ "";
            }

            if(i == line.length() - 1 && regex.length() > 1){
                regexs.add(regex);
            }
        }

        for (int i = 0; i < regexs.size(); i++) {
            String replace = regexs.get(i);
            line = line.replace(replace, replace.charAt(0) + "");
        }

        System.out.println(line);
    }
}
