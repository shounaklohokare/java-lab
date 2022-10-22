package numoperation;

public class PerfectNumber {

    public static boolean isPerfect(int n) {

        int sumOfDivisors = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0)
                sumOfDivisors += i;
        }
        return sumOfDivisors == n;
    }

}