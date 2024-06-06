package da.niel.rsa;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.interfaces.RSAKey;

public class Test {

    public static void main(String... args){
        System.out.println("Searching for prime");
        BigInteger p = Util.prime(1024*2);
        System.out.println("p= " + p);
        BigInteger q = Util.prime(1024*2);
        System.out.println("q= " + q);
        BigInteger N = p.multiply(q);
        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = BigInteger.valueOf(65537); //RFC standard
        BigInteger d = e.modInverse(phiN);
        System.out.println("N= " + N);
        System.out.println("phiN= " + phiN);
        System.out.println("e= " + e);
        System.out.println("d= " + d);
    }

}