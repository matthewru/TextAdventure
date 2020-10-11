import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {

    public static final String[] LETTERS = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    public static final String[] INTEGERS = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    public static final String[] SPECIAL_CHARS = {"!", "@", "#", "$", "%", "&", "*", "?"};
    private int numLetters = 1;
    private int numSpecialChars = 1;
    private int numInts = 1;

    public String createPassword(int passwordLen) {
        Random rand = new Random();
        this.calcNumLetters(passwordLen);
        this.calcNumSpecialChars(passwordLen);
        this.calcNumInts(passwordLen);
        String[] password = new String[passwordLen];
        for (int i = 0; i < numLetters; i++) {
            password[i] = LETTERS[rand.nextInt(LETTERS.length)];
        }
        for (int i = 0; i < numSpecialChars; i++) {
            password[i + numLetters] = SPECIAL_CHARS[rand.nextInt(SPECIAL_CHARS.length)];
        }
        for (int i = 0; i < numInts; i++) {
            password[i + numLetters + numSpecialChars] = INTEGERS[rand.nextInt(INTEGERS.length)];
        }
        for (int i = 0; i < password.length; i++) {
            int randIndexToSwap = rand.nextInt(password.length);
            String temp = password[randIndexToSwap];
            password[randIndexToSwap] = password[i];
            password[i] = temp;
        }

        String pass = String.join("", password);
        return pass;

    }

    private void calcNumLetters(int passwordLen) {
        Random randLetter = new Random();
        this.numLetters = randLetter.nextInt(passwordLen - this.numSpecialChars - this.numInts) + 1;
    }

    private void calcNumSpecialChars(int passwordLen) {
        Random randChar = new Random();
        this.numSpecialChars = randChar.nextInt(passwordLen - this.numLetters - this.numInts) + 1;
    }

    private void calcNumInts(int passwordLen) {
        this.numInts = passwordLen - this.numLetters - this.numSpecialChars;
    }

    public static void main(String args[]) {
        PasswordGenerator passwordGen = new PasswordGenerator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How long should the password be? ");
        int passwordLength = Integer.parseInt(scanner.next());
        System.out.println("Here is your password " + passwordGen.createPassword(passwordLength));

    }

}

