public class MyNumber {

    private int number;

    MyNumber(int number) {
        this.number = number;
    }

    MyNumber() {
        this(0);
    }

    public int getNumber() {
        return this.number;
    }

    public boolean isEven() {
        return this.number % 2 == 0;
    }

    public boolean isOdd() {
        return this.number % 2 != 0;
    }

    public boolean isZero() {
        return this.number == 0;
    }

    public boolean isNegative() {
        return this.number < 0;
    }

    public boolean isPositive() {
        return this.number > 0;
    }
}
