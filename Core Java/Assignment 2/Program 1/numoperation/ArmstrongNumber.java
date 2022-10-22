package numoperation;

public class ArmstrongNumber {

    public static boolean isArmstrong(int n) {

        int cubeSumOfDigits = 0;
        int temp = n;
        while (n > 0) {
            cubeSumOfDigits += Math.pow(n % 10, 3);
            n /= 10;
        }
        return temp == cubeSumOfDigits;
    }

}
