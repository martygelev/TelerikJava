package bitwiseoperators;

public class BitwiseOperators {

    public static void main(String[] args) {
        /*
            BIT
            0 1 11010101010101
        
          BITWISE OPERATORS
          
            1 - true, 0 - false
        
          & - bitwise and
        
          | - bitwise or
         
          ^ - XOR eXclusive OR
          
                    result
          1     0     1
          0     1     1
          1     1     0
          0     0     0
           
          x << 1 - moving bits to the left by 1 (left shift)
          x >> 2 - moving bits to the right by 2 (right shift)
          
          ~ - bitwise negation
        
          1 2 6 = 1 * 10 ^ 2 + 2 * 10 ^ 1 + 6 * 10 ^ 0
        
          0 0 0 1 - edit - 1
          0 0 1 0 - post - 2
          0 1 0 0 - delete - 4
          1 0 0 0 - ban - 8
        
          1 1 0 1 - 13
        
          1 0 1 1 //11
          0 0 0 1 //1
        ---------

          1 0 1 0
          0 1 0 1 - 5
            
        */
        int a = 10; //32 bits 111111111111111111111111111111111111111111111111111111111110101

        System.out.println(~10);

    }

}
