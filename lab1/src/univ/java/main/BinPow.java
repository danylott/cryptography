package main;

import java.math.BigInteger;

import static java.math.BigInteger.*;

public class BinPow {

    public static BigInteger binPow(BigInteger a, BigInteger b, BigInteger mod) {
        if (b.equals(ZERO))
            return ONE;
        if (b.equals(ONE))
            return a.mod(mod);

        if (b.mod(TWO).equals(ONE)) {
            return a.multiply(binPow(a, b.subtract(ONE), mod)).mod(mod);
        }

        return binPow(a, b.divide(TWO), mod).pow(2).mod(mod);

    }

    public static void main(String[] args) {
        BigInteger a=ONE;
        BigInteger b=TWO;
        BigInteger c=TWO;
        for (int i = 0; i < 100; i++) {
            if (i%10==0) System.out.println(i);
            a=a.add(TWO);
            for (int j = 0; j < 100; j++) {
                b=b.add(ONE);
                for (int k = 0; k < 100; k++) {
                    c=c.add(ONE);
                }
            }
        }
        System.out.println("binPow 199^199= " + binPow(BigInteger.valueOf(199),
                BigInteger.valueOf(199), BigInteger.valueOf(100)).toString());
        System.out.println("binPow 9^2=" + binPow(TEN.subtract(ONE), TWO, TEN).toString());
        System.out.println("binPow 2^10=" + binPow(TWO, TEN, TWO).toString());
    }

}
