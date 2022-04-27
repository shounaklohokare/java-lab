public class MyNumberMain {

    public static void main(String[] args) {

        int number = Integer.parseInt(args[0]);

        MyNumber n = new MyNumber(number);

        if (n.isZero())
            System.out.println("It's a Zero");

        else {
            System.out.println(n.getNumber() + " is Positive: " + n.isPositive());
            System.out.println(n.getNumber() + " is Negative: " + n.isNegative());
            System.out.println(n.getNumber() + " is Even: " + n.isEven());
            System.out.println(n.getNumber() + " is Odd: " + n.isOdd());
        }

    }

}
