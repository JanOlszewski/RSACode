import java.math.BigInteger;

public class KeyGenerator
{
    // part of the common
    private BigInteger n;

    // public key:
    private BigInteger e;

    // private key:
    private BigInteger d;

    public KeyGenerator(int beaten)
    {
        BigInteger p = BigInteger.ZERO;
        BigInteger q = BigInteger.ZERO;
        boolean b = true;

        while (b)
        {
            p = PrimeNumberGenerator.generatePrimeNumber(beaten);
            q = PrimeNumberGenerator.generatePrimeNumber(beaten);
            if(!(p.equals(q))) { b = false; }
        }

        n = p.multiply(q);
        BigInteger fE = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        BigInteger tmp1, tmp2, tmp3;
        for(BigInteger i = BigInteger.TWO; i.compareTo(fE) < 0; i = i.add(BigInteger.ONE))
        {
            tmp1 = i;
            tmp2 = fE;
            while (!(tmp2.equals(BigInteger.ZERO)))
            {
                tmp3 = tmp2;
                tmp2 = tmp1.mod(tmp2);
                tmp1 = tmp3;
            }
            if(tmp1.equals(BigInteger.ONE)) { e = i; break; }
        }

        BigInteger u, w, x, z, k;
        u = BigInteger.ONE;
        w = e;
        x = BigInteger.ZERO;
        z = fE;
        while (!(w.equals(BigInteger.ZERO)))
        {
            if(w.compareTo(z) < 0)
            {
                k = u; u = x; x = k;
                k = w; w = z; z = k;
            }
            k = w.divide(z);
            u = u.subtract((k.multiply(x)));
            w = w.subtract((k.multiply(z)));
        }
        if(z.equals(BigInteger.ONE))
        {
            if(x.compareTo(BigInteger.ZERO) < 0) { x = x.add(fE); }
            d = x;
        }
    }


    public BigInteger getD()
    {
        return d;
    }

    public BigInteger getE()
    {
        return e;
    }

    public BigInteger getN()
    {
        return n;
    }
}









