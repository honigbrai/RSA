package da.niel.rsa;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

class Util {

    private static final BigInteger ZERO = BigInteger.ZERO;
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger TWO = new BigInteger("2");

    private static final int[] FIRST_PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};
    public static BigInteger prime(int n){
        BigInteger bi;
        while(!firstPrimeCheck(bi = randomUneven(n)) || !millerRabin(bi, 4));
        return bi;
    }

    public static BigInteger lcm(BigInteger a, BigInteger b){
        if (!a.gcd(b).equals(ONE)) {
            return null;
        }
        BigInteger x = ONE;
        for (; x.compareTo(b) < 0; x.add(ONE)) {
            if (a.multiply(x).mod(b).equals(ONE)) {
                break;
            }
        }
        return x;
    }

    private static boolean firstPrimeCheck(BigInteger bi){
        for (int divisor : FIRST_PRIMES){
            if (bi.mod(BigInteger.valueOf(divisor)).signum() == 0)
                return false;
        }
        return true;
    }

    private static boolean millerRabin(BigInteger bi, int n){
        int s = 0;
        BigInteger d = bi.subtract(ONE);
        while (d.mod(TWO).equals(ZERO)) {
            s++;
            d = d.divide(TWO);
        }
        for (int i = 0; i < n; i++) {
            BigInteger a = uniformRandom(TWO, bi.subtract(ONE));
            BigInteger x = a.modPow(d, bi);
            if (x.equals(ONE) || x.equals(bi.subtract(ONE)))
                continue;
            int r = 0;
            for (; r < s; r++) {
                x = x.modPow(TWO, bi);
                if (x.equals(ONE))
                    return false;
                if (x.equals(bi.subtract(ONE)))
                    break;
            }
            if (r == s)
                return false;
        }
        return true;
    }

    private static BigInteger uniformRandom(BigInteger bottom, BigInteger top) {
        BigInteger res;
        do {
            res = new BigInteger(top.bitLength(), ThreadLocalRandom.current());
        } while (res.compareTo(bottom) < 0 || res.compareTo(top) > 0);
        return res;
    }


    public static BigInteger randomUneven(int n){
        byte[] ba = new byte[n / 8];
        ThreadLocalRandom.current().nextBytes(ba);
        BigInteger b = new BigInteger(1, ba);
        return b;
    }

}
