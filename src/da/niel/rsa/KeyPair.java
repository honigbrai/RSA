package da.niel.rsa;

import java.math.BigInteger;

public class KeyPair {

    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    public KeyPair(int primeLen) {
        BigInteger p = Util.prime(primeLen);
        BigInteger q = Util.prime(primeLen);
        BigInteger N = p.multiply(q);
        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = BigInteger.valueOf(65537); //RFC standard
        BigInteger d = e.modInverse(phiN);
        this.privateKey = new PrivateKey(N, d);
        this.publicKey = new PublicKey(N, e);
    }

}
