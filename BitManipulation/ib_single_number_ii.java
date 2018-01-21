public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {

        int x1 = 0;
        int x2 = 0;
        int mask = 0;

        for (Integer elem : A) {
            x2 = x2 ^ (x1 & elem);
            x1 = x1 ^ elem;

            mask = ~(x1 & x2);

            x2 = x2 & mask;
            x1 = x1 & mask;
        }

        return (x1 | x2);
    }
}

/*
 *    GENERAL IDEA.
 *    1- Figure out the number of variables needed to represent the counter.
 *          In this example we need 2 variables for the counter (x1 and x2),
            given that most elements are repeated 3 times and using 2 bits we
            can represent the number 3 in binary.
      2- Figure out if we need a mask.
            Most elements are repeated 3 times, and 3 is not a power of 2,
            then we need a mask. If the number was a power of 2 we wouldn't
            need a mask.
     3-  Figure out the value of the mask.
            Using the binary representation of the number of times most
            elements are repeated, we create the mask in the following way:
            For this example, the number is 3 = 11, then the mask is ~(x1 & x2)
            if the number was 5 = 101, the mask would be ~(x1 & ~x2 & x3)
            if the number was 4 = 100, the mask would be ~(~x1 & ~x2 & x3).
     4-  The code:
            In a loop over all elements elem:
                x_m = x_m ^ (x_(m-1) & ... & x_1 & elem);
                x_(m-1) = x_(m-1) ^ (x_(m-2) & ... & x_1 & elem);
                .
                .
                .
                x_1 = x_1 ^ elem;

                mask = ~([~]xm & [~]x_(m-1) & ... & [~]x_1);

                x_m = x_m & mask;
                x_(m-1) = x_(m-1) & mask;
                .
                .
                .
                x_1 = x_1 = mask;
            End Loop;

            return (x_m | x_(m-1) | ... | x_1);
*/
