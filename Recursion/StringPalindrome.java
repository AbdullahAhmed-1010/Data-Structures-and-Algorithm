// Recursive Approach
class Solution{
    public boolean palindrome(int i, String s){
        if(i >= s.length()/2){
            return true;
        }
        if(s.charAt(i) != s.charAt(s.length() - i - 1)){
            return false;
        }

        return palindrome(i+1, s);
    }
}

public class StringPalindrome{
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "madam";

        System.out.println(solution.palindrome(0, s));
    }
}

// Iterative Approach (Leetcode)
class Solution1 {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) != 
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}