package u5pp;

public class ChessPiece {
    int row;
    int col;
    boolean isWhite;
    ChessPiece board[][];

    public ChessPiece(ChessPiece[][] board, int row, int col, boolean isWhite){
        this.row = row;
        this.col = col;
        this.isWhite = isWhite;
        this.board = board;
    }

    public ChessPiece[][] getBoard(){
        return board;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return col;
    }

    public boolean getIsWhite(){
        return isWhite;
    }
    /**
     * checks if piece can move in direction given by user
     */
    public boolean canMoveTo(int row, int col){
        if(row < 0 || row > board.length - 1){
            return false;
        } 
        else if(col < 0 || col > board[row].length - 1){
            return false;
        } 
        else if (board[row][col] != null){
            if(board[row][col].isWhite == board[this.row][this.col].isWhite){
                return false;
            }
        }
        return true;
    }   
    /**
     * checks piece can make a diagonal move
     */
    public boolean clearDiagnal(int row, int col){
        System.out.println("Enter clearDiagnal at" + row + " " + col);
        int colCount = 1;
        int rowCount = 1;
        if(row > this.row){
            if(col > this.col){
                for(int i = this.row; i < row - 1; i++){
                    if(board[row - rowCount][col - colCount] != null){
                        
                        return false;
                    }
                    colCount += 1;
                    rowCount +=1 ;
                }
            } 
            else{
                for(int i = this.row; i < row - 1; i++){
                    if(board[row - rowCount][col + colCount] != null){
                        return false;
                    }
                    colCount += 1;
                    rowCount += 1;
                }
            }
        } 
        else{
            if(col < this.col){
                for(int i = row; i < this.row - 1; i++){
                    if(board[row + rowCount][col + colCount] != null){
                        System.out.println(i);
                        System.out.println(row + " " + rowCount + " " + col + " " + colCount);
                        return false;
                    }
                    colCount += 1;
                    rowCount += 1;
                }
            }
            else {
                for(int i = row; i <this.row - 1; i++){
                    if(board[row+ rowCount][col - colCount] != null){
                        return false;
                    }
                    colCount += 1;
                    rowCount += 1;
                }
            }
        }
        return true;
    }
    /**
     * checks for horizontal and vertical moves
     * if not, returns false
     */
    public boolean checkHorVert(int row, int col){
        if(this.row == row && this.col != col){
            if(col > this.col){
                for(int i = col ; i < this.col; i++){
                    if(board[this.row][i] != null){
                        return false;
                    }
                }
            }
            else{
                for(int i = col +1 ; i < this.col ; i++){
                    if(board[this.row][i] != null){
                        return false;
                    }
                }
            }
        } 
        else{
            if(row > this.row){
                for(int i = this.row +1; i < row; i++){
                    if(board[i][this.col] != null){
                        return false;
                    }
                }
            }
            else{
                for(int i = row +1; i < this.row; i++){
                    if(board[i][this.col] != null){
                        return false;
                    }
                }
            }
        }
        return true;
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
        return isWhite ? "O" : "o";
    }
}