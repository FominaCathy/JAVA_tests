package seminars.third.hw;

public class NumbersMetods {

    public boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    //    попадает ли переданное число в интервал (25;100)
    public boolean numberInInterval(int n) {
        if ((n > 25) && (n < 100)) {
            return true;
        } else {
            return false;
        }
    }

}
