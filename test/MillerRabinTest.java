import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MillerRabinTest
{
    private Random rand = new Random();

    @Test
    public void fastPowTest1()
    {
        BigInteger result1 = MillerRabin.fastPow(new BigInteger(32, rand), new BigInteger(32, rand),
                new BigInteger(32, rand), 64);
        assertNotNull(result1);
    }

    @Test
    public void fastPowTest2()
    {
        BigInteger result2 = MillerRabin.fastPow(BigInteger.valueOf(11154L), BigInteger.valueOf(5L),
                BigInteger.valueOf(1204273229L), 64);
        assertEquals(BigInteger.valueOf(914327102L), result2);
    }

    @Test
    public void fastPowTest3()
    {
        BigInteger result3 = MillerRabin.fastPow(BigInteger.valueOf(106740725L), BigInteger.valueOf(97862827L),
                BigInteger.valueOf(146818489L), 64);
        assertEquals(BigInteger.valueOf(11154L), result3);
    }

    @Test
    public void isPrimeTest1()
    {
        boolean b = MillerRabin.isPrime(BigInteger.valueOf(17207L), BigInteger.valueOf(300L), 64);
        assertEquals(true, b);
    }

    @Test
    public void isPrimeTest2()
    {
        boolean b = MillerRabin.isPrime(BigInteger.valueOf(9876373L), BigInteger.valueOf(300L), 64);
        assertEquals(false, b);
    }

    @Test
    public void isPrimeTest3()
    {
        boolean b = MillerRabin.isPrime(new BigInteger(32, rand), BigInteger.valueOf(300L), 64);
        assertEquals(false, b);
    }
}