class Solution {

    public String encode(List<String> strs) {
        String result = "";
        for (int i=0; i<strs.size(); i++) {
            result += String.format("%03d", strs.get(i).length());
            result += strs.get(i);
        }

        return result;
    }

    public List<String> decode(String str) {
        int current = 0;
        List<String> result = new ArrayList<>();
        while (current < str.length()) {
            int length = Integer.parseInt(str.substring(current, current + 3));
            String currStr = str.substring(current + 3, current + 3 + length);
            result.add(currStr);

            current = current + 3 + length;
        }

        return result;
    }
}
