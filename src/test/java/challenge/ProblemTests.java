package challenge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.math.BigInteger;

public class ProblemTests {

    @Test
    @DisplayName("smallNumber")
    public void testSmallNum(){
        BigInteger testNum = new BigInteger("9999999999999");
        boolean isValid = ProblemOne.isValidCardNumber(testNum);
        //need to figure out if this is true or false...
        assertFalse(isValid);
        System.out.println("Numbers under 14 digits return false");
    }
    @Test
    @DisplayName("largeNumber")
    public void testLargeNum(){
        BigInteger testNum = new BigInteger("10000000000000000000");
        boolean isValid = ProblemOne.isValidCardNumber(testNum);
        //need to figure out if this is true or false...
        assertFalse(isValid);
        System.out.println("Numbers over 19 digits return false");
    }//fixme make sure this number would be otherwise valid...

    @Test
    @DisplayName("valid Number")
    public void testOdd(){
        BigInteger testNum = new BigInteger("10000000000009");
        boolean isValid = ProblemOne.isValidCardNumber(testNum);
        //need to figure out if this is true or false...
        assertTrue(isValid);
        System.out.println("10000000000009 returned true");
    }

    @Test
    @DisplayName("valid odd and even digit")
    public void testBoth(){
        BigInteger testNum = new BigInteger("100000000000017");
        boolean isValid = ProblemOne.isValidCardNumber(testNum);
        //need to figure out if this is true or false...
        assertTrue(isValid);
        System.out.println("100000000000017 returned true");
    }

    @Test
    @DisplayName("2 even digits")
    public void testEvens(){
        BigInteger testNum = new BigInteger("100000000000108");
        boolean isValid = ProblemOne.isValidCardNumber(testNum);
        //need to figure out if this is true or false...
        assertTrue(isValid);
        System.out.println("100000000000108 returned true");
    }


    //leading zeros

    //negative numbers?

}
