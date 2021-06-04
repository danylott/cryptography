package test;

import main.KarazubaMultiplication;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

public class KarazubaMultiplicationTest {

    @Test
    public void karazubaMult() {
        BigInteger num = new BigInteger("722876385");

        assertEquals(KarazubaMultiplication.karazubaMultiplication(num, BigInteger.ONE), num);
        assertEquals(KarazubaMultiplication.karazubaMultiplication(BigInteger.ZERO, BigInteger.ONE), BigInteger.ZERO);

        assertEquals(KarazubaMultiplication.karazubaMultiplication(new BigInteger("846348765834658363523376721"), new BigInteger("53423434348768")),
                new BigInteger("45214857727728692358861251840800966229728"));
        assertEquals(KarazubaMultiplication.karazubaMultiplication(new BigInteger("12341634163146136152"), new BigInteger("374672651726121212154315321132")),
                new BigInteger("4624072798539651690985560306986814303740874764064"));
    }
}