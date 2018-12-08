package mice.util;

/**
 * NumCheck
 */
public class NumCheck {
    public static boolean IsPositive(int num) {
        return num > 0 ? true : false;
    }

    public static boolean IsNoPositive(int num) {
        return !IsPositive(num);
    }

}