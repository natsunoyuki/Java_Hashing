import java.security.NoSuchAlgorithmException; 
import java.security.MessageDigest; 
import java.math.BigInteger;

//The family of Hashing.java files are more about showing different ways
//of handling exceptions.

//In this file, main uses try-catch to catch the NoSuchAlgorithmException
//thrown by SHA256. This is different method from Hashing.java. This
//method frees the user from having force functions to throw Exceptions,
//but requires a try-catch method to be used whenever SHA256 is called.

public class Hashing2{
    public static void main(String args[]){ 
        //For the test string of "Hello, World!", we expect the result:
        //dffd6021bb2bd5b0af676290809ec3a53191dd81c7f70a4b28688a362182986f
        String string = "Hello, World!"; 
        try{
            String hashedString = SHA256(string, 16, 64);
            System.out.println(string);
            System.out.println(hashedString); 
	}catch(NoSuchAlgorithmException e){
	    System.err.println(e.getMessage());
	}
    } 

    //NoSuchAlgorithmException is thrown when a particular cryptographic  
    //algorithm is requested but is not available in the environment.
    public static String SHA256(String string, int N, int M) throws NoSuchAlgorithmException{ 
	//if this throws Exception, then main must use try-catch
        MessageDigest hasher = MessageDigest.getInstance("SHA-256"); 
        //the input string has to be encoded into bytes first!
        byte[] hashedbytes = hasher.digest(string.getBytes()); 
        //bytes have range of -128~127
        BigInteger toInt = new BigInteger(1, hashedbytes); 
        //convert the array of hashed bytes to a BigInt object
        String H = toInt.toString(N); //return a hex string  
        if(H.length() < M){
	    H=ZeroString(M-H.length())+H; 
	}
        return H; //return a zero padded hex string     
    }

    public static String ZeroString(int N){
	//returns a string of zeros of length N 
	if(N<0){
	    return "";
	}
	String string = "";
	for(int i=0;i<N;i++){
	    string += "0";
	}
	return string;
    }
}
