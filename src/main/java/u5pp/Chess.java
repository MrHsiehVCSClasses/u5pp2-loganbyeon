package u5pp;

import java.util.Scanner;

public class Chess {
    /**
     * play method starts the game of chess
     */
    public void play(Scanner scan){
        Scanner yuh = new Scanner(System.in);
        InputHelper helper = new InputHelper(yuh);
        
        ChessPiece[][] chessBoard = new ChessPiece[8][8];

        ChessPiece player = new Queen(chessBoard, 7, 0, true);
        ChessPiece playa = new Queen(chessBoard, 0, 0, false);

        chessBoard[7][0] = player;
        chessBoard[0][0] = playa;

        System.out.print(boardToString(chessBoard));

        while(true){
        int[] home = helper.getChessLocation(":)");
        player.moveTo(home[0], home[1]);
        System.out.print(boardToString(chessBoard));
        }

    }

    public static int getWinner(ChessPiece[][] board){
        int win = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == null){
                //does nothing because null = nothing 
                } 
                else if(board[i][j].toString().equals("K")){
                    win += 1;
                } 
                else if (board[i][j].toString().equals("k")){
                    win -= 1;
                }
            }
        }
        return win;
    }

    /**
     * prints chess board
     */
    public static String boardToString(ChessPiece[][] board) {

        String output = "";
        output += " ".repeat(3);

        for(int i = 0; i < 8; i++) {
            output += " " + (char)('a' + i) + "  ";
        }
        
        output += "\n";
        output += "  " + "┌───" + "┬───".repeat(7) + "┐";
        output += "\n";

        for(int r = 0; r < board.length; r++){
            output += (r)+1 + " │";

            for(int c = 0; c < board[r].length; c++){
                output += " ";

                if(board[r][c] == null) {
                    output += " ";
                } 
                else {
                    output += board[r][c];
                }
                output += " │";
            }

            output += (" " + (r+1));
            output += "\n";
                    
            if(r == board.length-1) {
                output += "  " + "└───" + "┴───".repeat(7) + "┘";
            } 
            else {
                output += "  " + "├───" + "┼───".repeat(7) + "┤";
            }
            
            output += "\n";
        }
        
        output += " ".repeat(3);

        for(int i = 0; i < 8; i++) {
            output += " " + (char)('a' + i) + "  ";
        }
        return output;
    }
}
