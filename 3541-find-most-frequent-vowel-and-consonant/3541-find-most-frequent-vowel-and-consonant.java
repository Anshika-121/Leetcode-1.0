class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int[26];
        
        // Count frequencies
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        
        String vowels = "aeiou";
        int maxVowel = 0, maxConsonant = 0;
        
        for (int i = 0; i < 26; i++) {
            char ch = (char)(i + 'a');
            if (freq[i] > 0) {
                if (vowels.indexOf(ch) != -1) { // vowel
                    maxVowel = Math.max(maxVowel, freq[i]);
                } else { // consonant
                    maxConsonant = Math.max(maxConsonant, freq[i]);
                }
            }
        }
        
        return maxVowel + maxConsonant;
    }
}
