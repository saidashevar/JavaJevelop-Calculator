import java.util.HashMap;
import java.util.Map;

//This class makes whole work
public class Helper {
    private Boolean romanSystem;
    private Translator translator = new Translator();

    //Getting value of arabic OR roman numbers in String
    public int getInt(String number) throws UnexpectedException, DifferentSystemsException, Exception {
        try {
            int value = Integer.parseInt(number);

            if (romanSystem != null) {
                if (romanSystem)
                    throw new DifferentSystemsException("Error: different number systems are used at the same time");
            }
            setRomanSystem(false);

            if (value < 1 || value > 10)
                throw new RuntimeException("Integer values must be in range 1 <= int <= 10");

            return Integer.parseInt(number);

        //In case "parseInt" didn't work. It means we have some roman letters probably
        } catch (NumberFormatException e) {
            try {
                int value = translator.romanToArabic(number);
            } catch (Exception e2) {
                throw new Exception("Only integers are supported");
            }

            if (romanSystem != null) {
                if (!romanSystem)
                    throw new DifferentSystemsException("!Error: different number systems are used at the same time");
            }
            setRomanSystem(true);

            int value = translator.romanToArabic(number);

            if (value < 1 || value > 10)
                throw new RuntimeException("Roman values must be in range I <= NUMBER <= X");

            return value;
        }
    }

    //just changing to true, if we started to use arabic numbers
    public void setRomanSystem(boolean b) {
        this.romanSystem = b;
    }

    public boolean getRoman() {
        return this.romanSystem;
    }
}
