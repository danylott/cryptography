package main;

import java.math.BigDecimal;
import java.math.BigInteger;

public class ExtendedEuclid {
    public static BigInteger[] extendedAlgorithm(BigInteger a, BigInteger b) {
        BigInteger[] ans = new BigInteger[3];

        if (b.intValue() == 0) {
            ans[0] = a;
            ans[1] = BigInteger.valueOf(1);
            ans[2] = BigInteger.valueOf(0);
        } else {
            BigInteger q = a.divide(b);
            ans = extendedAlgorithm(b, a.remainder(b));

            BigInteger temp = ans[1].subtract(ans[2].multiply(q));
            ans[1] = ans[2];
            ans[2] = temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        BigInteger a = new BigDecimal("43").toBigInteger();
        BigInteger b = new BigDecimal("19").toBigInteger();

        BigInteger[] res = extendedAlgorithm(a, b);
        System.out.println("GCD(" + a + ", " + b + ") = " + res[0]);

        System.out.println("Bezout's Identity: " + res[0] + " = " + res[1].toString() + "*" +
                a.toString() + " + " + res[2].toString() + "*" + b.toString() + "");
    }
}
