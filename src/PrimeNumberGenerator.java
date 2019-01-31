import java.math.BigInteger;
import java.util.Random;

public class PrimeNumberGenerator
{
    public static BigInteger generatePrimeNumber(int beaten)
    {
        Random rand = new Random();

        BigInteger result;
        while(true)
        {
            result = new BigInteger(beaten, rand);
            if(MillerRabin.isPrime(result, BigInteger.valueOf(300L), beaten)) { return result; }
        }
    }
}
