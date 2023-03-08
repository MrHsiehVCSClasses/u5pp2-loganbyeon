package u5pp;
import java.util.Scanner;

public class InputHelper {
    boolean isValid;
    String i;
    Scanner myScanner = new Scanner(System.in);
    
    
    InputHelper(Scanner scanner){
        this.myScanner = scanner;
        isValid = false;
    }
    /**
     * gets the location of piece
     */
    public int[] getChessLocation(String prompt){
        int[] array = new int[2];
        isValid = false;

        while(isValid == false){
            System.out.println(prompt);
            i = myScanner.nextLine();

            if(i.length() == 2){
                char j = i.charAt(0);
                char k = i.charAt(1);

                if((int)j < 97 || (int)j > 104){
                    //System.out.println("Error");
                } 
                else if((int)k <49 || (int)k > 56){
                    //System.out.println("Error");
                }
                else{
                    array[0] = (int)k - 49;
                    array[1] = (int)j - 97;
                    isValid = true;
                }
            }
        }
        System.out.println(array[0]);
        System.out.println(array[1]);
        return array;
    }
}