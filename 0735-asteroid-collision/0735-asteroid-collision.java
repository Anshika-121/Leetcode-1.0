import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for (int ast : asteroids) {
            boolean exploded = false;
            
            while (!st.isEmpty() && st.peek() > 0 && ast < 0) {
                int top = st.peek();
                
                if (top + ast == 0) {   // same size, both explode
                    st.pop();
                    exploded = true;
                    break;
                } else if (top + ast > 0) { // top bigger, left asteroid explodes
                    exploded = true;
                    break;
                } else { // top smaller, pop it and continue
                    st.pop();
                }
            }
            
            if (!exploded) {
                st.push(ast); // safe to push
            }
        }
        
        // Convert stack to array
        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        
        return result;
    }
}
