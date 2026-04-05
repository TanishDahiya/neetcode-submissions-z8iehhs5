class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();

        for(String str : strs){
            builder.append(str.length());
            builder.append("#");
            builder.append(str);
        }

        return builder.toString();
    }

    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while(i < s.length()){
            int j = i;

            // find #
            while(s.charAt(j) != '#'){
                j++;
            }

            int length = Integer.parseInt(s.substring(i, j));
            j++; // move after '#'

            String word = s.substring(j, j + length);
            result.add(word);

            i = j + length;
        }

        return result;
    }
}

// Encoded string:

// "2#ab3#c#d"

// At any point, you only know:

// i = current position

// But you DON’T know:

// Is length 2 or 23 or 234 ❓
// 👉 So we must scan until #
// 📊 TABLE VISUALIZATION
// 🔹 String with index
// Index	Char
// 0	2
// 1	#
// 2	a
// 3	b
// 4	3
// 5	#
// 6	c
// 7	#
// 8	d
// 🔹 Iteration 1

// Start:

// i = 0
// j = 0
// Step 1: Find #
// j	char	condition
// 0	'2'	not '#' → move
// 1	'#'	stop

// 👉 That’s why we do:

// while(s.charAt(j) != '#'){
//     j++;
// }
// Step 2: Extract length
// substring(0,1) → "2"
// length = 2
// Step 3: Extract word
// j = 1 → j+1 = 2
// substring(2, 2+2) → "ab"
// Step 4: Move pointer
// i = 4
// 🔹 Iteration 2

// Start:

// i = 4
// j = 4
// Step 1: Find #
// j	char	condition
// 4	'3'	not '#' → move
// 5	'#'	stop
// Step 2: Extract length
// substring(4,5) → "3"
// length = 3
// Step 3: Extract word
// substring(6, 9) → "c#d"
// 🎯 KEY INSIGHT (IMPORTANT)

// 👉 We are NOT searching # for fun
// 👉 We are finding where the number ends

// 🚀 Simple Analogy

// Imagine this string:

// "12#hello_world"

// 👉 Is length:

// 1 ❌
// 12 ✅

// How do you know?

// 👉 Only when you hit #