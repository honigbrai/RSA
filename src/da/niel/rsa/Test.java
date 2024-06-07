package da.niel.rsa;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAKey;
import java.util.Arrays;
import java.util.Base64;

public class Test {

    public static void main(String... args) throws Exception {
        /*System.out.println("Searching for prime");
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
        System.out.println("d= " + d);*/

        KeyPair kp = new KeyPair(1024*2);
        byte[] bi = kp.getPublicKey().encrypt("Hello World".getBytes());
        System.out.println(Base64.getEncoder().encodeToString(bi));
        System.out.println(new String(kp.getPrivateKey().decrypt(bi), StandardCharsets.UTF_8));
    }

}
