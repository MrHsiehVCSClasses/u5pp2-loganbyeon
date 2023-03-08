package u5pp;

public class Queen extends ChessPiece{

    public Queen(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }
    /**
     * checks if queen can move in direction given by user
     * can move in a straight line in any of the 8 directions (rook + bishop), any number of squares
     */
    public boolean canMoveTo(int row, int col){
        if(super.canMoveTo(row, col) == true){
            if(java.lang.Math.abs(row - this.row) == java.lang.Math.abs(col - this.col)){
                if (clearDiagnal(row, col) == false){
                    return false;
                }
                return true;
            } 
            else if (row != this.row && col == this.col){
                if(checkHorVert(row, col) == false){
                    return false;
                }
                return true;
                
            } 
            else if (row == this.row && col != this.col){
                if(checkHorVert(row, col) == false){
                    return false;
                }
                return true;
            }
        }
        return false;
    }
    
    public void moveTo(int row, int col){
        if(canMoveTo(row, col) == true){
            board[row][col] = board[this.row][this.col];
            board[this.row][this.col] = null;
            this.row = row;
            this.col = col;
        }
    }
    
    public String toString(){
        return isWhite == true ? "Q" : "q";
    }
}