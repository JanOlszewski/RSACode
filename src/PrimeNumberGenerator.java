import java.math.BigInteger;
import java.util.Random;

public class PrimeNumberGenerator
{
    public static BigInteger generatePrimeNumber(int bits)
    {
        Random rand = new Random();

        BigInteger result;
        while(true)
        {
            result = new BigInteger(bits, rand);
            if(MillerRabin.isPrime(result, BigInteger.valueOf(300L), bits)) { return result; }
        }
    }
}
