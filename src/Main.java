import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        int firstOperandTest = myObj.nextInt();
        if (myObj.hasNextInt()) {
            System.out.println("Here is integer!");
        } else firstOperandTest = -100;

        int firstOperand = Integer.getInteger(myObj.nextLine());
        System.out.println(firstOperandTest);
    }
}