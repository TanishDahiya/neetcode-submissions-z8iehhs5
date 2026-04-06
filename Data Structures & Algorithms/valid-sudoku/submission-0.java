class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for(int i =0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]== '.') continue;
                if(!set.add(board[i][j]+"row in"+i)) return false;
                if(!set.add(board[i][j]+"col in"+j)) return false;
                if(!set.add(board[i][j]+"box in"+i/3+j/3)) return false;
            }
        }

        return true;
    }
}

