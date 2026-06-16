class Solution {
    public boolean isValidSudoku(char[][] mat) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        for(int i=0; i<9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat[0].length; j++) {
                if(mat[i][j] == '.') continue;
                else {
                    int n = ((i/3)*3) + (j/3);
                    if(rows[i].contains(mat[i][j]) || cols[j].contains(mat[i][j]) || boxes[n].contains(mat[i][j])) {
                        return false;
                    }
                    rows[i].add(mat[i][j]);
                    cols[j].add(mat[i][j]);
                    boxes[n].add(mat[i][j]);
                }
            }
        }

        return true;
    }
}
