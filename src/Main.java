import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Helper helper = new Helper();
        Translator translator = new Translator();

        Scanner myObj = new Scanner(System.in);
        String line = myObj.nextLine();
        String[] addings = line.split(" ");

        try {
            //examining number of operands
            if (addings.length < 3) {
                throw new Exception("Too few operands");
            } else if (addings.length > 3)
                throw new Exception("Too many operands or operations");

            //Getting values of operands, whether they are arabic or not
            int operand1 = helper.getInt(addings[0]);
            int operand2 = helper.getInt(addings[2]);

            //Really hard calculations
            int result = -100;
            switch (addings[1]) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "/":
                    result = operand1 / operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
            }

            //Printing results if everything ok
            if (helper.getRoman()) {
                System.out.println(line + " = " + translator.arabicToRoman(result));
            } else {
                System.out.println(line + " = " + result);
            }

            //Catching different errors. Actually it was possible to use only one default Exception
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } catch (DifferentSystemsException e3) {
            System.out.println(e3.getMessage());
        } catch (UnexpectedException e2) {
            System.out.println("Something went wrong. This calculator accepts numbers in range [1,10] \n" +
                    "in format \"X * X\"");
        } catch (Exception eTotal) {
            System.out.println(eTotal.getMessage());
        }
    }
}