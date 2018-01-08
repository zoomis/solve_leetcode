/* My idea
 * To use XOR operation because it can make 1 if two corresponding bits are different.
 * Then, count 1 from the result.
 */
class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;

        while(xor > 0) {
            count += xor & 1;   // count for only 1
            xor >>= 1;          // move the bit
        }
        return count;
    }

    // If we can use the existing library in the default java,
    // we can use the Integer.bitCount to count the bit 1.
    public int hammingDistanceByLibrary(int x, int y) {
        return Integer.bitCount(x^y);
    }
}