package u5pp;


public class Bishop extends ChessPiece {
   
    public Bishop(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }
    /**
     * check if bishop can move in direction given by user
     * bishop: can move in any diagonal direction any # of squares
     */
    public boolean canMoveTo(int row, int col){
        if(super.canMoveTo(row, col) == true){
            if(java.lang.Math.abs(this.row - row) == java.lang.Math.abs(this.col - col)){
                if(clearDiagnal(row, col) == true){
                    return true;
                } 
                //System.out.println("16");
                return false;
            }
            //System.out.println("19");
            return false;
        }
        //System.out.println("22");
        return false;
    }
    /**
     * moves to square and check it's not making a dupe
     */
    public void moveTo(int row, int col){
            board[row][col] = board[this.row][this.col];
            board[this.row][this.col] = null;
            this.row = row;
            this.col = col;
    }

    public String toString(){
        return isWhite == true ? "B" : "b";
    }
}