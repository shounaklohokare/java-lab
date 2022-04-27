import java.io.*;

import numoperation.PrimeNumber;
import numoperation.PerfectNumber;
import numoperation.ArmstrongNumber;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nEnter the value of n: ");
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter a number: ");
            int x = Integer.parseInt(br.readLine());

            if (PrimeNumber.isPrime(x)) {
                System.out.println(x + " is a Prime number.");
            } else {
                System.out.println(x + " is NOT a Prime number.");
            }

            if (ArmstrongNumber.isArmstrong(x)) {
                System.out.println(x + " is an Armstrong number.");
            } else {
                System.out.println(x + " is NOT an Armstrong number.");
            }

            if (PerfectNumber.isPerfect(x)) {
                System.out.println(x + " is a Perfect number.");
            } else {
                System.out.println(x + " is NOT a Perfect number.");
            }

        }

    }

}
