import java.util.Scanner;

public class TikTakToe {
    public static void main(String[] args) {

     char[][] box = new char[3][3];

     for (int i = 0 ; i < box.length  ; i ++){
         for (int j =0 ; j < box.length ; j++){
             box[i][j]= ' ';
             System.out.print("|" + box[i][j] + "|");
         }
         System.out.println();
     }

     TikTakToe obj = new TikTakToe();
     Scanner scn = new Scanner(System.in);
     int row;
     int column;

     for (int i = 0 ; i < 6 ; i++){
         do {
             System.out.println("PLayer X input the value: ");
             row = scn.nextInt();
             column = scn.nextInt();
         }while (obj.ReinitializeCheck(row , column ,box));

         obj.PlayerX(row , column , box);

         if (obj.checkWinner(row,column,box)){
             System.out.println("X is winner!!");
             break;
         }

         do {
             System.out.println("PLayer Y input the value: ");
             row = scn.nextInt();
             column = scn.nextInt();
         }while (obj.ReinitializeCheck(row , column ,box));

         obj.PlayerO(row , column , box);

         if (obj.checkWinner(row,column,box)){
             System.out.println("O is winner!!");
             break;
         }
     }

    }

    public void PlayerX(int row , int column , char[][] box){
        for (int i = 0 ; i < box.length  ; i ++){
            for (int j =0 ; j < box.length ; j++){
                if (i == row && j == column){
                    box[i][j]= 'X';
                    System.out.print("|" + box[i][j] + "|");
                }
                else {
                    System.out.print("|" + box[i][j] + "|");
                }
            }
            System.out.println();
        }
    }

    public void PlayerO(int row , int column , char[][] box){
        for (int i = 0 ; i < box.length  ; i ++){
            for (int j =0 ; j < box.length ; j++){
                if (i == row && j == column){
                    box[i][j]= 'O';
                    System.out.print("|" + box[i][j] + "|");
                }
                else {
                    System.out.print("|" + box[i][j] + "|");
                }
            }
            System.out.println();
        }
    }

    public boolean checkWinner(int row , int column , char[][] box){
        boolean isWinner = false;
        for (int i = 0 ; i < box.length ; i++){
            if ((box[i][0] == 'X' && box[i][1] == 'X' && box[i][2] == 'X' )||(box[i][0] == 'O' && box[i][1] == 'O' && box[i][2] == 'O' ) ){
                isWinner = true;
            }
            if ((box[0][i] == 'X' && box[1][i] == 'X' && box[2][i] == 'X' )||(box[0][i] == 'O' && box[1][i] == 'O' && box[2][i] == 'O' ) ){
                isWinner = true;
            }
        }

        if ((box[0][0] == 'X' && box[1][1] == 'X' && box[2][2] == 'X' )||(box[0][0] == 'O' && box[1][1] == 'O' && box[2][2] == 'O' ) ){
            isWinner = true;
        }
        if ((box[2][0] == 'X' && box[1][1] == 'X' && box[0][2] == 'X' )||(box[2][0] == 'O' && box[1][1] == 'O' && box[0][2] == 'O' ) ){
            isWinner = true;
        }

        return isWinner;
    }

    public boolean ReinitializeCheck(int row , int column , char[][] box){
        boolean isReinitialized = false;

        if (row > 2 || column > 2 || box[row][column] == 'X' || box[row][column] == 'O' ){
            System.out.println("Invalid Input!!");
            isReinitialized = true;
        }

        return  isReinitialized;
    }




}


