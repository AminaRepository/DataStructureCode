import java.io.IOException;
import java.util.Scanner;

public class App extends Algorithm{

    public static void main(String[] args) throws IOException {
        System.out.println("How do you wish to use the program?");
        System.out.println("1 - manually enter expression");
        System.out.println("2 - provide path to txt file");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if(choice == 1){
            System.out.println("Please enter expression correctly:");
            String expression = scan.next();
            System.out.println("The result is " + calculate(expression));
        }
        else if(choice == 2){
            System.out.println("Please enter file path:");
            String filePath = scan.next();
            System.out.println("The results are " + calculateFromFile(filePath));
        }
        else{
            System.out.println("Wrong input");
        }
    }
}