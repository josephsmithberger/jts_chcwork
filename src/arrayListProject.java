import java.util.ArrayList;
import java.util.Scanner;

public class arrayListProject {
    public static void main(String[] args) {
        ArrayList <String> list = new ArrayList<String>();
        int count = 5;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < count; i++){
            System.out.println("What's element " + i + "?");
            list.add(scanner.nextLine());
        }
        System.out.println("And what would the character count be?");
        int num = scanner.nextInt();
        ArrayList <String> newList = new ArrayList<String>();
        for (String word:list){
            if (word.length()== num){
                newList.add(word);
            }
        while (!newList.isEmpty()){
            System.out.println(newList.get(0));
            newList.remove(0);
        }
        }
    }
}
