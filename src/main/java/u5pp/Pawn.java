package u5pp;

public class Pawn extends ChessPiece{
    
    public boolean isFirstMove;
    Pawn(ChessPiece board[][], int row, int col, boolean isWhite){
        super(board, row, col, isWhite);
        isFirstMove = true;
    }
    /**
     * checks if pawn can move in direction given by user
     * pawn: 
        - can move straight forward 1 space, and cannot take when doing so
        - can move forward diagonally, only when taking
        - forward is defined as away from the side of the board where it started
            - black pawns only move to lower number rows
            - white pawns only move to higher number rows
        - if a pawn has never taken a move, it can move 2 squares directly forward (cannot take with this move)
     */
    public boolean canMoveTo(int row, int col) {
        if(super.canMoveTo(row, col) == true){
            if(board[this.row][this.col].isWhite == true && row == this.row + 1 || board[this.row][this.col].isWhite == false && row == this.row - 1){
                if(col == this.col + 1 || col == this.col - 1){
                    if(board[row][col] == null){
                        return false;
                    } 
                    else if(board[row][col].isWhite == board[this.row][this.col].isWhite){
                        return false;
                    }
                    return true;
                }
                if(board[row][col] != null){
                    return false;
                }
                return true;
            } 
            else if(board[this.row][this.col].isWhite == true && row == this.row + 2 && isFirstMove == true || board[this.row][this.col].isWhite == false && row == this.row - 2 && isFirstMove == true){
                if(board[row][col] != null){
                    return false;
                }
                return true;

            }
            return false;
        }
        return false;
    }

public void moveTo(int row, int col){
        isFirstMove = false;
        board[row][col] = board[this.row][this.col];
        board[this.row][this.col] = null;
        this.row = row;
        this.col = col;
}

    public String toString(){
        return isWhite == true ? "P" : "p";
    }
}