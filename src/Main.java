import java.math.BigInteger;

public class Main
{
    public static void main(String[] args)
    {
        RSA rsa = new RSA(1024);

        BigInteger password1 = new BigInteger("7638767164788712637868888");
        BigInteger cipher = rsa.encrypt(password1);
        BigInteger password2 = rsa.decrypt(cipher);

        System.out.println("public key:");
        System.out.println(rsa.getN());
        System.out.println(rsa.getE());
        System.out.println("private key:");
        System.out.println(rsa.getN());
        System.out.println(rsa.getD());
        System.out.println("password for encryption: " + password1);
        System.out.println("cipher: " + cipher);
        System.out.println("decrypted password: " + password2);
    }

}
