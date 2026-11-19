class Solution {
    private int boxIndex(int i, int j) {
        return 18 + ((i/3)+(3*(j/3)));
    }

    private int columnIndex(int i, int j) {
        return i;
    }

    private int rowIndex(int i, int j) {
        return 9 + j;
    }

    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        int m = 9;

        List<Set<Character>> sets = new ArrayList<>();

        for (int i=0; i<27; i++) {
            sets.add(new HashSet<Character>());
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (board[i][j] == '.') continue;
                if (
                    sets.get(boxIndex(i, j)).contains(board[i][j]) ||
                    sets.get(columnIndex(i, j)).contains(board[i][j]) ||
                    sets.get(rowIndex(i, j)).contains(board[i][j])
                ) {
                    return false;
                }

                sets.get(boxIndex(i, j)).add(board[i][j]);
                sets.get(columnIndex(i, j)).add(board[i][j]);
                sets.get(rowIndex(i, j)).add(board[i][j]);
            }
        }

        return true;
    }
}
