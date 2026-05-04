class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m < n) return "";

        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;
        int count = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        while (right < m) {
            char ch = s.charAt(right);

            if (map.containsKey(ch) && map.get(ch) > 0) {
                count++;
            }

            map.put(ch, map.getOrDefault(ch, 0) - 1);

            // shrink window
            while (count == n) {
                int currLen = right - left + 1;
                if (currLen < minLength) {
                    minLength = currLen;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar, 0) + 1);

                if (map.containsKey(leftChar) && map.get(leftChar) > 0) {
                    count--;
                }

                left++;
            }

            right++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLength);
    }
}