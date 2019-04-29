import java.security.NoSuchAlgorithmException; 
import java.security.MessageDigest; 
import java.math.BigInteger; 

public class Hashing{

    public static void main(String args[]) throws NoSuchAlgorithmException{ 
	//For the test string of "Hello, World!", we expect the result:
	//dffd6021bb2bd5b0af676290809ec3a53191dd81c7f70a4b28688a362182986f
        String string = "Hello, World!"; 
        String hashedString = SHA256(string, 16);
        System.out.println(string);
        System.out.println(hashedString); 
    } 
    //NoSuchAlgorithmWxception is thrown when a particular cryptographic  
    //algorithm is requested but is not available in the environment.
    public static String SHA256(String string, int N){ 
        try { 
            MessageDigest hasher = MessageDigest.getInstance("SHA-256"); 
            //the input string has to be encoded into bytes first!
            byte[] hashedbytes = hasher.digest(string.getBytes()); 
            BigInteger toInt = new BigInteger(1, hashedbytes); 
            return toInt.toString(N); //return a hex string  
        } 
        catch(NoSuchAlgorithmException except){ 
            System.out.println(except); 
            return null; 
        } 
    }
}
