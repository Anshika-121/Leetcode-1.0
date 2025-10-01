class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int full = numBottles;
        int empty =0 ;
        int drunk =0;
        while (full > 0) {
            // Drink all the full bottles
            drunk += full;
            empty += full;
            
            // Exchange empty bottles for new full ones
            full = empty / numExchange;
            empty = empty % numExchange;
        }
        
        return drunk;
    }
}