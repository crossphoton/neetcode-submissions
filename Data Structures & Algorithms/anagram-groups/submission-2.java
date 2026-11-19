class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs, (a, b) -> {
            return a.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining()).compareTo(b.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining()));
        });

        List<List<String>> ans = new ArrayList<List<String>>();

        for (int i=0; i<strs.length; i++) {
            String current = strs[i].chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

            List<String> curr = new ArrayList<>();
            curr.add(strs[i]);

            for (int j=(i+1); j<strs.length; j++) {
                if (
                    strs[j].chars()
                        .sorted()
                        .mapToObj(c -> String.valueOf((char) c))
                        .collect(Collectors.joining()).equals(current)
                ) {
                    curr.add(strs[j]);
                    i++;
                } else break;
            }


            ans.add(curr);
        }


        return ans;
    }
}
