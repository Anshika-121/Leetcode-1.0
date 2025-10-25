class Solution {
    public int totalMoney(int n) {
        // Base case: less than or equal to one week
        if (n <= 7) return n * (n + 1) / 2;

        // Full weeks and remaining days
        int fullWeeks = n / 7;
        int remainingDays = n % 7;

        // Total from complete weeks
        int moneyFromFullWeeks = fullWeeks * 28 + (7 * (fullWeeks - 1) * fullWeeks) / 2;

        // Remaining days from the last partial week
        int moneyFromRemainingDays = remainingDays * (2 * fullWeeks + remainingDays + 1) / 2;

        return moneyFromFullWeeks + moneyFromRemainingDays;
    }
}
