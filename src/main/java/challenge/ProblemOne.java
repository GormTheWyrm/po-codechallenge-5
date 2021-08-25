package challenge;

import java.math.BigInteger;

public class ProblemOne {
    /*
    Create a function that takes a number as an argument and returns true if the number is a valid credit card number, false otherwise.

    Credit card numbers must be between 14-19 digits in length, and pass the Luhn test, described below:

    Remove the last digit (this is the "check digit").
    Reverse the number.
    Double the value of each digit in odd-numbered positions. If the doubled value has more than 1 digit, add the digits together (e.g. 8 x 2 = 16 ➞ 1 + 6 = 7).
    Add all digits.
    Subtract the last digit of the sum (from step 4) from 10. The result should be equal to the check digit from step 1.
    Examples
    validateCard(1234567890123456) --> false

    // Step 1: check digit = 6, num = 123456789012345
    // Step 2: num reversed = 543210987654321
    // Step 3: digit array after selective doubling: [1, 4, 6, 2, 2, 0, 9, 8, 5, 6, 1, 4, 6, 2, 2]
    // Step 4: sum = 58
    // Step 5: 10 - 8 = 2 (not equal to 6) --> false

    validateCard(1234567890123452) --> true
    */
     //START

    public static boolean isValidCardNumber(BigInteger num){
        String strNum = num.toString();//nw I have a str and a num I can work with...
        BigInteger min = new BigInteger("10000000000000"); //14 digit min
        BigInteger max = new BigInteger("9999999999999999999");//19 digit max
        if (num.compareTo(min) >= 0 && num.compareTo(max) <=0){ //
            StringBuilder wip = new StringBuilder(strNum.substring(0, strNum.length()-1)); //drop last digit
//            System.out.println(wip);//good
            StringBuilder reversed = new StringBuilder();
            //should be a simple sort method available...right?
            for (int i = wip.length()-1; i>=0 ;i--){ //count DOWN, fill reversed string
                reversed.append(wip.charAt(i));
            }
//            System.out.println(reversed.length());//good
            StringBuilder doubledReversed = new StringBuilder();
                for (int i = 0; i< reversed.length();i++){             //double the sb...
                    if (i%2==1) { //odd numbered positions
                        int current = 2*Character.getNumericValue(wip.charAt(i));
                        if (current>=10){
                            int rollover = current/10;
                            current = current-10 + rollover;
                        }
                        doubledReversed.append(Integer.toString(current));
                    }
                    else{
                        doubledReversed.append(Character.getNumericValue(wip.charAt(i)));
                    }
                    System.out.println(doubledReversed);//looks alright...not testing values yet
                }//end doubling... should have made these functions
                //SUM
            int sum = 0;
                for (int i = 0; i<doubledReversed.length();i++){
                    sum += Character.getNumericValue(doubledReversed.charAt(i));
                }
                System.out.println("Sum: " +sum);//
                String sumStr = Integer.toString(sum);
                int lastDigit = Character.getNumericValue(sumStr.charAt(sumStr.length()-1));
            System.out.println("last Digit: " + lastDigit);//
                int checkDigit = Character.getNumericValue(strNum.charAt(strNum.length()-1));
            System.out.println("Check Digit: " + checkDigit);//

                if (10-(lastDigit)==checkDigit){
                    return true;
                }


        }

        return false; //if any step fails return false
    }


    public static void main(String[] args) {
    BigInteger test = new BigInteger("12345678901234");
    boolean isValid = isValidCardNumber(test);
        System.out.println(isValid);
    }

}
//fixme deal with leading zeroes...









// I misread directions
// int rollover = 0;
//             for (int i = wip.length()-1; i>=0 ;i--){ //count DOWN, fill reversed string
//                 int current = 2*Character.getNumericValue(wip.charAt(i)) + rollover;
//                 if (current>=10){
//                     rollover = current/10;
//                     current = current-10;
//                 }
//                 else {
//                     rollover = 0;
//                 }
//
//                reversed.append(current);
//
//                //easier to double it within this loop?
//            }