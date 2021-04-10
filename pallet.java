import java.math.BigInteger;
public class Solution {
    public static int solution(String x) {
        BigInteger bi = new BigInteger(x);
        int count = 0;
        while(!bi.equals(BigInteger.ONE)){
            if(checkIfEvenNumber(bi)) {
                bi = bi.shiftRight(1);
            } else {
                if(bi.equals(new BigInteger("3"))) {
                    return count + 2;
                }
                BigInteger minusOne = bi.subtract(BigInteger.ONE);
                BigInteger plusOne = bi.add(BigInteger.ONE);
                
                int m0 = findNumberOfZerosAtEnd(minusOne);
                int m1 = findNumberOfZerosAtEnd(plusOne);
                
                BigInteger bj;
                if(m1 > m0) {
                    count += m1;
                    while(m1!=0) {
                        plusOne = plusOne.shiftRight(1);
                        m1--;
                    }
                    bi = plusOne;
                } else {
                    count += m0;
                    while(m0 != 0) {
                        minusOne = minusOne.shiftRight(1);
                        m0--;
                    }
                    bi = minusOne;
                }
            }
            count++;
        }
        return count;
    }
    
    public static boolean checkIfEvenNumber(BigInteger bi) {
        return bi.testBit(0) ? false : true;
    }
    
    public static int findNumberOfZerosAtEnd(BigInteger bi) {
        int c = 0;
        while(!bi.testBit(0)) {
            c++;
            bi = bi.shiftRight(1);
        }
        return c;
    } 
}