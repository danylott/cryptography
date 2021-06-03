package com.cryptology.elgamal;

import java.math.BigInteger;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Encryptors {
    private final Key key;

    public Encryptors(Key key) {
        this.key = key;
    }

    private static BigInteger bigIntPowBrute(BigInteger base, BigInteger exp) {
        BigInteger i = BigInteger.ONE;
        BigInteger product = BigInteger.ONE;
        for (; i.compareTo(exp) <= 0; i = i.add(BigInteger.ONE)) {
            product = product.multiply(base);
        }

        return product;
    }


    public List<Message> encryptString(String s) {
        List<Message> cipherTextMessages = new LinkedList<>();

        byte[] byteInput = s.getBytes();
        for (byte b : byteInput) {
            cipherTextMessages.add(this.encrypt(new byte[]{b}));
        }

        return cipherTextMessages;
    }

    public String decryptString(List<Message> cipherTextMessages) {
        StringBuilder stringBuffer = new StringBuilder();
        for (Message m : cipherTextMessages) {
            stringBuffer.append(new String(this.decrypt(m)));
        }

        return stringBuffer.toString();
    }


    public Message encrypt(byte[] message) {
        BigInteger y = key.getPublicKey().getKeyY();
        BigInteger g = key.getPublicKey().getKeyG();
        BigInteger p = key.getPublicKey().getKeyP();

        int randomK = generateRandomKByP(p);
        BigInteger messageBI = new BigInteger(message);
        BigInteger a = g.modPow(BigInteger.valueOf(randomK), p);
        BigInteger b = ((y.pow(randomK)).multiply(messageBI)).mod(p);

        return new Message(a.toByteArray(), b.toByteArray());
    }


    public byte[] decrypt(Message message) {
        BigInteger p = key.getPublicKey().getKeyP();
        BigInteger x = key.getPrivateKey().getKey();
        BigInteger a = new BigInteger(message.getA());
        BigInteger b = new BigInteger(message.getB());

        BigInteger degree = p.subtract(x).subtract(BigInteger.ONE);
        BigInteger decrypted = (b.multiply(bigIntPowBrute(a, degree))).mod(p);

        return decrypted.toByteArray();
    }

    /**
     * 1 < k < p - 1
     */
    private int generateRandomKByP(BigInteger p) {
        Random random = new Random();

        //guaranteed k > 0 (at least 2), and in range of int size
        if (p.bitLength() > 32) {
            return random.nextInt(Integer.MAX_VALUE - 2) + 2;
        } else {
            int pInt = p.intValue();
            if (pInt < 3) {
                throw new RuntimeException("LESS THAN 3");
            }
            return Math.abs(random.nextInt(pInt - 3)) + 2;
        }
    }
}
