public class main {
    public static void main (String [] args) {
        System.out.println("Hello, world");
    }

    public static boolean luckyTicket (int num) {
        int firstPart = num / 1000;
        int secondPart = num % 1000;

        int firstDigit = firstPart / 100;
        int secondDigit = firstPart % 100 / 10;
        int thirdDigit = firstPart % 10;
        int firstSum = firstDigit + secondDigit + thirdDigit;

        firstDigit = secondPart / 100;
        secondDigit = secondPart % 100 / 10;
        thirdDigit = secondPart % 10;
        int secondSum = firstDigit + secondDigit + thirdDigit;

        return (firstSum == secondSum);
    }
}