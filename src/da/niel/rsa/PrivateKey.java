package da.niel.rsa;

import java.math.BigInteger;

public class PrivateKey {
    private final BigInteger n, d;

    public PrivateKey(BigInteger n, BigInteger d) {
        this.n = n;
        this.d = d;
    }
}
