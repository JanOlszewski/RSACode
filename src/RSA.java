import java.math.BigInteger;

public class RSA
{
    private KeyGenerator keyGenerator;
    private BigInteger n;
    private BigInteger e;
    private BigInteger d;
    private int bits;

    public RSA(int bits)
    {
        this.bits = bits;
        keyGenerator = new KeyGenerator(bits);
        n = keyGenerator.getN();
        e = keyGenerator.getE();
        d = keyGenerator.getD();
    }

    public BigInteger encrypt(BigInteger x)
    {
        return MillerRabin.fastPow(x, e, n, bits);
    }

    public BigInteger decrypt(BigInteger x)
    {
        return MillerRabin.fastPow(x, d, n, bits);
    }

    public BigInteger getN() { return n; }

    public BigInteger getE() { return e; }

    public BigInteger getD() { return d; }
}
