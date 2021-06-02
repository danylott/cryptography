package main;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ExtendedEuclid {
    public static BigInteger[] extendedAlgorithm(BigInteger a, BigInteger b) {
        BigInteger[] ans = new BigInteger[3];   // { gcd, x, y }

        if (b.intValue() == 0) {  /*  If b = 0, then GCD is a  */
            ans[0] = a;
            ans[1] = BigInteger.valueOf(1);
            ans[2] = BigInteger.valueOf(0);
        } else {
            /*  Otherwise, make a recursive function call  */
            BigInteger q = a.divide(b);                             // a / b
            ans = extendedAlgorithm(b, a.remainder(b));             // gcd(b, a % b)

            BigInteger temp = ans[1].subtract(ans[2].multiply(q));  // temp = y1 - x1 * (b / a) = y1 - x1 * q
            ans[1] = ans[2];                                        // y = x1
            ans[2] = temp;                                          // x = temp
        }
        return ans;
    }

    public static void main(String[] args) {
        // a * x + b * y = c 43x mod19=1 43*x+k*19=1
        BigInteger a = new BigDecimal("43").toBigInteger();
        BigInteger b = new BigDecimal("19").toBigInteger();

        BigInteger[] res = extendedAlgorithm(a, b);
        System.out.println("GCD(" + a + ", " + b + ") = " + res[0]);

        System.out.println("Bezout's Identity: " + res[0] + " = " + res[1].toString() + "*" + a.toString() + " + " + res[2].toString() + "*" + b.toString() + "");
    }
}
