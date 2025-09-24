class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        // Edge case: numerator is 0
        if (numerator == 0) return "0";
        
        StringBuilder result = new StringBuilder();

        // Handle negative sign
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        // Convert to long to avoid overflow (e.g., -2^31 / -1)
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append integer part
        result.append(num / den);
        long remainder = num % den;

        // If perfectly divisible
        if (remainder == 0) {
            return result.toString();
        }

        // Otherwise, handle fractional part
        result.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            // If we've seen this remainder before, cycle starts
            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                result.insert(index, "(");
                result.append(")");
                break;
            }

            // Store position of this remainder
            map.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }
}
