class CharacterCount {
    public static int countMapSize = 26;
    public int[] characterCount;

    public CharacterCount(String s) {
        characterCount = new int[countMapSize];

        for (int i=0; i<s.length(); i++) {
            characterCount[(int)(s.charAt(i)-'a')]++;
        }
    }

    public boolean equals(CharacterCount c) {
        for (int i=0; i<countMapSize; i++) {
            if (this.characterCount[i] != c.characterCount[i])
                return false;
        }

        return true;
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        CharacterCount sC = new CharacterCount(s);
        CharacterCount tC = new CharacterCount(t);

        return tC.equals(sC);
    }
}
