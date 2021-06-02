package main;

import java.math.BigInteger;
import java.util.Random;

public class TestFerma {
    private final static Random rand = new Random();

    private static BigInteger getRandomFermatBase(BigInteger n) {
        while (true) {
            final BigInteger a = new BigInteger(n.bitLength(), rand);

            if (BigInteger.ONE.compareTo(a) <= 0 && a.compareTo(n) < 0)
                return a;
        }
    }

    public static boolean checkPrime(BigInteger n, int maxIterations) {
        if (n.equals(BigInteger.ONE))
            return false;

        // Run Fermat Test for some numbers
        for (int i = 0; i < maxIterations; i++) {
            BigInteger a = getRandomFermatBase(n);
            a = a.modPow(n.subtract(BigInteger.ONE), n);    // a^(n - 1) mod n

            // If (a^(n - 1) mod n) != 1 then n is definitely not prime
            if (!a.equals(BigInteger.ONE))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("check prime 2 ? " + checkPrime(BigInteger.valueOf(2), 10));
        System.out.println("check prime 23 ? " + checkPrime(BigInteger.valueOf(23), 10));
        System.out.println("check prime 97 ? " + checkPrime(BigInteger.valueOf(97), 10));
        System.out.println("check prime 113 ? " + checkPrime(BigInteger.valueOf(113), 10));
        System.out.println("check prime 561 ? " + checkPrime(BigInteger.valueOf(561), 10));
        System.out.println("check prime 1234567907 ? " + checkPrime(BigInteger.valueOf(1234567907), 10));
    }
}
