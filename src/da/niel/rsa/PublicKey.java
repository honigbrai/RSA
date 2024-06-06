package da.niel.rsa;

import java.math.BigInteger;

public class PublicKey {

    private final BigInteger n, e;

    public PublicKey(BigInteger n, BigInteger e) {
        this.n = n;
        this.e = e;
    }

    public BigInteger getN() {
        return this.n;
    }

    public BigInteger getE() {
        return this.e;
    }
}
