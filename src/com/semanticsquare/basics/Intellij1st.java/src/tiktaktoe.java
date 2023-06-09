import java.util.Scanner;

public class tiktaktoe {
    public static void main(String[] args) {

        char[][] box = new char[3][3];

        for (int i = 0 ; i < box.length ; i++)
        {
            for (int j = 0 ; j < box.length; j++ )
            {
                box[i][j] = ' ';
                System.out.print("|"+ box[i][j] + "|" );
            }
            System.out.println();
        }

        int row;
        int column;
        tiktaktoe obj = new tiktaktoe();
        Scanner scn = new Scanner(System.in);


        for (int m = 0 ; m < 6 ; m++)
        {
            do {
                System.out.println("ENTER - Player X");
                row = scn.nextInt();
                column = scn.nextInt();
            }while (obj.boxReinitializeCheck(row,column,box));

            obj.PlayerX(row,column,box);

            if (obj.WinnerCheck(row,column,box)){
                System.out.println("PLayer X is winner!!");
                break;
            }

            do {
                System.out.println("ENTER - Player O");
                row = scn.nextInt();
                column = scn.nextInt();
            }while (obj.boxReinitializeCheck(row,column,box));

            obj.PlayerO(row,column,box);

            if (obj.WinnerCheck(row,column,box)){
                System.out.println("PLayer O is winner!!");
                break;
            }



        }
    }


    //This is to check whether any player have won the game!!
    public boolean WinnerCheck(int row , int column , char[][] box ){
        boolean isWinner = false;

        for (int i = 0 ; i < box.length ; i++)
        {
            if(box[i][0] == 'X' && box[i][1] == 'X'  && box[i][2] == 'X' )
            {
                isWinner = true;
            }
            if(box[i][0] == 'O' && box[i][1] == 'O'  && box[i][2] == 'O' )
            {
                isWinner = true;
            }
            if(box[0][i] == 'X' && box[1][i] == 'X'  && box[2][i] == 'X' )
            {
                isWinner = true;
            }
            if(box[0][i] == 'O' && box[1][i] == 'O'  && box[2][i] == 'O' )
            {
                isWinner = true;
            }
        }
        if((box[0][0] == 'O' && box[1][1] == 'O'  && box[2][2] == 'O' )|| (box[0][0] == 'X' && box[1][1] == 'X'  && box[2][2] == 'X' ))
        {
            isWinner = true;
        }
        if((box[2][0] == 'O' && box[1][1] == 'O'  && box[0][2] == 'O' )|| (box[2][0] == 'X' && box[1][1] == 'X'  && box[0][2] == 'X' ))
        {
            isWinner = true;
        }
        return isWinner;
    }

    //This is to print X
    public void PlayerX(int row , int column , char[][] box){


        for (int i = 0 ; i < box.length ; i++){
            for (int j = 0 ; j < box.length; j++ )
            {
                if (i == row && j == column)
                {
                    box[i][j] = 'X';
                    System.out.print("|"+ box[i][j] + "|");
                }
                else
                {
                    System.out.print("|"+ box[i][j] + "|");
                }
            }
            System.out.println();
        }
    }

    // This is to print Y
    public void PlayerO(int row , int column , char[][] box){
        for (int i = 0 ; i < box.length ; i++){
            for (int j = 0 ; j < box.length; j++ )
            {
                if (i == row && j == column)
                {
                    box[i][j] = 'O';
                    System.out.print("|"+ box[i][j] + "|");
                }
                else
                {
                    System.out.print("|"+ box[i][j] + "|");
                }
            }
            System.out.println();
        }
    }

    public boolean boxReinitializeCheck(int row , int column , char[][] box){

        boolean check = false;

        if ( (row > 2) || (column>2) ||box[row][column] == 'O' || box[row][column] == 'X' )
        {
            System.out.println("Invalid Output!!");
            check = true;
        }
        return check;
    }



}
