import java.security.NoSuchAlgorithmException; 
import java.security.MessageDigest; 
import java.math.BigInteger;

//The family of Hashing.java files are more about showing different ways
//of handling exceptions.

//In this file, we use a separate function SHA256Except to specifically 
//handle the the NoSuchAlgorithmException thrown by SHA256. This enables
//us to not have to explicitly use try-catch in the main() method, or to
//force the main() method to throw the NoSuchAlgorithmException.

public class Hashing3{
    public static void main(String args[]){ 
        //For the test string of "Hello, World!", we expect the result:
        //dffd6021bb2bd5b0af676290809ec3a53191dd81c7f70a4b28688a362182986f
        String string = "Hello, World!"; 
        String hashedString = SHA256Except(string, 16, 64);
        System.out.println(string);
        System.out.println(hashedString);
    } 
    
    public static String SHA256Except(String string, int N, int M){
		String hashedString = null;
        try{
            hashedString = SHA256(string, N, M);
		}catch(NoSuchAlgorithmException e){
		    System.err.println(e.getMessage());
		}   
		return hashedString;
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
