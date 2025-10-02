class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
     int drink = numBottles ;
     int empties = numBottles;
     while (empties >= numExchange) {
        // trade empties for 1 full bottle
        empties -= numExchange;  // spend empties
        numExchange++;           // cost increases
        drink++;                 // drink the new bottle
        empties++;               // add the empty from the new bottle
    } 
    return drink;  
    }
}