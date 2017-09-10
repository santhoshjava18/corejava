package com.example.codility;



/**
 * Consider N coins aligned in a row. Each coin is showing either heads or tails. The adjacency of
 * these coins is the number of adjacent pairs of coins showing the same face. 
 * Given a non-empty zero-indexed array A consisting of N integers representing the coins, return
 * the maximum possible adjacency that can be obtained by reversing exactly one coin (that is, one
 * of the coins must be reversed). Consecutive elements of array A represent consecutive coins in
 * the row. Array A contains only 0s and/or 1s: 
 * 
 * For example, given array A consisting of six numbers, such that:
 * 
 *  A[0] = 1
 *  A[1] = 1
 *  A[2] = 0
 *  A[3] = 1
 *  A[4] = 0
 *  A[5] = 0
 * 
 * the function returns 4. The initial adjacency is 2, as there are two pairs of adjacent coins
 * showing the same face, namely (0, 1) and (4, 5). After reversing the coin represented by A[2] the
 * adjacency equals 4, as there are four pairs of adjacent coins showing the same face, namely
 * (0, 1), (1, 2), (2, 3) and (4, 5), and it is not possible to obtain a higher adjacency.
 *  
 * @author Riccardo Vitale
 *
 */
public class CoinFlip {
	
	public static void main(String args[]){
		int A[] = {1,1,0,1,0,0}; 
		System.out.println(flipCoin(A));
	}

    /**
     * The solution does at most three linear scans to determine which coin to flip. In the first
     * pass it looks for cases like 010 or 101 which would increase the adjacency by 2. In the
     * second pass it looks for cases like 100, 110, 011 or 001, where, by changing a single coin,
     * the adjacency may increase by 1 (only if the flipped element stands in first or last
     * position). If both of these passes don't find any suitable flip, then the array must be in an
     * already optimal configuration, so it flips the first element (it could be any element).
     * The third eventual pass consists of the computation of the adjacency for the array.
     * If n = len(coins):
     *      Time Complexity: O(n)
     *      Space Complexity: O(n)
     * 
     * @param coins The coin array
     * @return The maximum adjacency achievable for the array resulting from the required flip
     */
    public static int flipCoin(int[] coins) {
        if (coins.length == 0) {
            return 0;
        }
        
        for (int i = 1; i < coins.length - 1; i++) {
            if (coins[i - 1] != coins[i] && coins[i] != coins[i + 1]) { // 010 or 101
                coins[i] = coins[i] == 1 ? 0 : 1;
                return adjacency(coins);
            }
        }
        
        for (int i = 1; i < coins.length - 1; i++) {
            if (coins[i - 1] == coins[i] && coins[i] != coins[i + 1]) {
                coins[i + 1] = coins[i + 1] == 1 ? 0 : 1;
                return adjacency(coins);
            } else if (coins[i - 1] != coins[i] && coins[i] == coins[i + 1]) {
                coins[i - 1] = coins[i - 1] == 1 ? 0 : 1;
                return adjacency(coins);
            }
        }
        
        coins[0] = coins[0] == 1 ? 0 : 1;
        return adjacency(coins);
    }
    
    private static int adjacency(int[] A) {
        int adj = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == A[i]) {
                adj++;
            }
        }
        return adj;
    }
}
