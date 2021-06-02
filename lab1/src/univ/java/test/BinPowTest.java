package test;

import main.BinPow;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

import static java.math.BigInteger.*;
import static org.junit.Assert.assertEquals;

public class BinPowTest {

    @Test
    public void binPow() {
        BigInteger exp1 = BinPow.binPow(new BigInteger("100"), new BigInteger("5"), new BigInteger("7"));
        BigInteger exp2 = BinPow.binPow(ZERO, new BigInteger("123"), new BigInteger("7"));
        BigInteger exp3 = BinPow.binPow(ONE, new BigInteger("7576234374"), new BigInteger("7"));
        BigInteger exp4 = BinPow.binPow(new BigInteger("72657634"), ZERO, new BigInteger("7"));
        BigInteger exp5 = BinPow.binPow(new BigInteger("72657635"), ONE, new BigInteger("7"));

        Assert.assertEquals(exp1, new BigInteger("4"));
        Assert.assertEquals(exp2, ZERO);
        Assert.assertEquals(exp3, ONE);
        Assert.assertEquals(exp4, ONE);
        Assert.assertEquals(exp5, ONE);
    }
}