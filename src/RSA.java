import java.math.BigInteger;

public class RSA
{
    private KeyGenerator keyGenerator;
    private BigInteger n;
    private BigInteger e;
    private BigInteger d;
    private int beaten;

    public RSA(int beaten)
    {
        this.beaten = beaten;
        keyGenerator = new KeyGenerator(beaten);
        n = keyGenerator.getN();
        e = keyGenerator.getE();
        d = keyGenerator.getD();
    }

    public BigInteger encrypt(BigInteger x)
    {
        return MillerRabin.fastPow(x, e, n, beaten);
    }

    public BigInteger decrypt(BigInteger x)
    {
        return MillerRabin.fastPow(x, d, n, beaten);
    }

    public BigInteger getN() { return n; }

    public BigInteger getE() { return e; }

    public BigInteger getD() { return d; }
}
