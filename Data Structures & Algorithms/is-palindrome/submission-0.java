class Solution {
    public boolean isPalindrome(String s) {

        int i = 0;
        int k = s.length() - 1;

        while(i < k){

            if(!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }

            if(!Character.isLetterOrDigit(s.charAt(k))) {
                k--;
                continue;
            }

            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(k))) {
                return false;
            }

            i++;
            k--;
        }

        return true;
    }
}


// The below approach fails at this test case 
// s="Was it a car or a cat I saw?"
// because of the question mark as well as W is uppercase

// class Solution {
//     public boolean isPalindrome(String s) {

//         int i = 0;
//         int k = s.length() - 1;

//         while(i < k){

//             if(s.charAt(i) == ' ') {
//                 i++;
//                 continue;
//             }

//             if(s.charAt(k) == ' ') {
//                 k--;
//                 continue;
//             }

//             if(s.charAt(i) != s.charAt(k)) {
//                 return false;
//             }

//             i++;
//             k--;
//         }

//         return true;
//     }
// }