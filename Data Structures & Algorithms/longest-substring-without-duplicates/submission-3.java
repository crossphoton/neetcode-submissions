class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        System.out.println(s.length());

        Map<Character, Integer> m = new HashMap<>();

        int index = 1, start = 0;

        int maxLength = 1;

        m.put(s.charAt(start), start);

        while (index < s.length()) {
            while (!m.containsKey(s.charAt(index))) {
                m.put(s.charAt(index), index);
                index++;

                if (index == s.length()) break;
            }

            // System.out.println(start + ", " + index + "  |  " + (index-start));

            maxLength = Math.max(maxLength, index - start);
            if (index < s.length()) {
                start = Math.max(start, m.get(s.charAt(index)) + 1);
                m.put(s.charAt(index), index);
                index++;
            }
        }

        return maxLength;

    }
}
