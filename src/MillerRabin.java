/*
Original code:
https://gist.github.com/lenidh/7812988
 */



import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class MillerRabin
{
    public static BigInteger fastPow(BigInteger base, BigInteger exponent, BigInteger modulo, int beaten)
    {
        int shift = beaten*2;
        BigInteger result = base;

        while(((exponent.shiftRight(shift--)).and(BigInteger.ONE)).equals(BigInteger.ZERO));

        while(shift >= 0)
        {
            result = (result.multiply(result)).mod(modulo);
            if(((exponent.shiftRight(shift--)).and(BigInteger.ONE)).equals(BigInteger.ONE)) { result = (result.multiply(base)).mod(modulo); }
        }
        return result;
    }

    public static BigInteger fastPow(BigInteger base, BigInteger exponent, int beaten)
    {
        int shift = beaten*2;
        BigInteger result = base;

        while(((exponent.shiftRight(shift--)).and(BigInteger.ONE)).equals(BigInteger.ZERO));

        while(shift >= 0)
        {
            result = result.multiply(result);
            if((exponent.shiftRight(shift--).and(BigInteger.ONE)).equals(BigInteger.ONE)) { result = result.multiply(base); }
        }
        return result;
    }

    public static boolean isPrime(BigInteger candidate, BigInteger accuracy, int beaten)
    {
        Random rand = new Random();
        BigInteger THREE = (BigInteger.TWO).add(BigInteger.ONE);
        BigInteger d, s;

        if(candidate.equals(BigInteger.TWO)) { return true; }
        if(candidate.compareTo(BigInteger.TWO) < 1) { return false; }

        for(d = BigInteger.ZERO, s = BigInteger.ONE; (d.and(BigInteger.ONE)).equals(BigInteger.ZERO); s = s.add(BigInteger.ONE) )
        { d = (candidate.subtract(BigInteger.ONE)).divide(fastPow(BigInteger.TWO, s, beaten)); }

        BigInteger base, x;
        double tmp;
        BigDecimal tmpR, tmpT;
        BigDecimal tmpD = new BigDecimal(candidate.subtract(THREE));
        verification: for(BigInteger i = BigInteger.ZERO; (i.compareTo(accuracy)) < 0; i = i.add(BigInteger.ONE))
        {
            tmp = Math.random();
            tmpR = BigDecimal.valueOf(tmp);
            tmpT = tmpR.multiply(tmpD);
            base = ((tmpT.toBigInteger()).add(BigInteger.TWO));
            x = fastPow(base, d, candidate, beaten);
            //x = base.modPow(d, candidate);
            if(x.equals(BigInteger.ONE) || x.equals(candidate.subtract(BigInteger.ONE))) { continue verification; }

            for(BigInteger j = BigInteger.ZERO; j.compareTo(s.subtract(BigInteger.ONE)) < 0; j = j.add(BigInteger.ONE))
            {
                x = fastPow(x, BigInteger.TWO, candidate, beaten);
                if(x.equals(BigInteger.ONE)) { return false; }
                if(x.equals(candidate.subtract(BigInteger.ONE))) { continue verification; }
            }
            return false;
        }
        return true;
    }
}
