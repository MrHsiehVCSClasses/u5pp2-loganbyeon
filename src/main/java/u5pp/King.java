package u5pp;

public class King extends ChessPiece {
    
    public King(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }
    /**
     * can only move 1 square in any of the 8 directions
     * cannot move to a square next to another king
     */
    public boolean canMoveTo(int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || (row == this.row && col == this.col)) {
            return false;
        }
        int rowDiff = Math.abs(this.row - row);
        int colDiff = Math.abs(this.col - col);
        
        /**
         * check king's moves
         */
        if (rowDiff > 1 || colDiff > 1) {
            return false;
        }
        
        if (enemyKingBad(row, col)) {
            return false;
        }
        
        if (board[row][col] == null || board[row][col].isWhite != this.isWhite) {
            return true;
        }
        return false;
    }
    /**
     * checks for opps
     */
    private boolean enemyKingBad(int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] != null && board[i][j].getClass().getSimpleName().equals("King") && board[i][j].isWhite != this.isWhite) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        if (isWhite == false) {
            return "k";
        } 
        else {
            return "K";
        }
    }
}