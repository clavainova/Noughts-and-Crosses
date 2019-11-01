import java.util.*;

public class main
{
    public static void main(String [] args)
    {
        // create two players for the game 
        Player player1 = new Player();
        Player player2 = new Player();
        playingBoard Board = new playingBoard();

        //ask player 1 for a name
        Scanner keyboard = new Scanner(System.in);
        System.out.print ("Please enter the name of Player 1 (represented by crosses): ");
        player1.setName(keyboard.nextLine());

        //ask player 2 for a name
        System.out.print ("Please enter the name of Player 2 (represented by noughts): ");
        player2.setName(keyboard.nextLine());

        //print the names to clarify which person is which player
        System.out.println ("Player 1 is: " + player1.getName());
        System.out.println ("Player 2 is: " + player2.getName());

        int count = 0;

        while ((Board.checkStalemate()) && (Board.checkRows() == 0) && (Board.checkColumns() == 0) && (Board.checkDiagonals() == 0)) //while no player has won and it is not a stalemate
        {
            Board.drawSelf();

            String strX = "";
            String strY = "";

            int x = 3;
            int y = 3;
            
            //records coordinates
            if(count % 2 == 0) //checks which player's turn it is
            {
                System.out.println(player1.playerName + "'s turn . What is the X-coordinate?");            
                strY = keyboard.nextLine();
                y = Integer.valueOf(strY);
                
                System.out.println(player1.playerName + "'s turn still. What is the Y-coordinate?");
                strX = keyboard.nextLine();
                x = Integer.valueOf(strX);
            }
            else
            {
                System.out.println(player2.playerName + "'s turn . What is the X-coordinate?");            
                strY = keyboard.nextLine();
                y = Integer.valueOf(strY);

                System.out.println(player2.playerName + "'s turn still. What is the Y-coordinate?");
                strX = keyboard.nextLine();
                x = Integer.valueOf(strX);   
            }
            
            //this way the person can enter 1 instead of 0, which is more intuitivley correct
            y = y - 1;
            x = x - 1;

            if((x > 3) || (x < 0) || (y > 3) || (y < 0)) //checks that the number isn't out of range
            {
                System.out.println("Those are out of range!");
                count = count - 1;
            }
            else
            {
                if(!Board.isCellEmpty(x, y)) //checks that the cell hasn't been used before
                {
                    System.out.println("Those co-ordinates have already been used, try again.");
                    count = count - 1;
                }
                else
                {
                    Board.addPlay(x, y);
                }
            }
            count++; //for the mod function determining which player's turn it is
        }

        Board.drawSelf(); //print the board so they can see that they won - otherwise it wouldn't be shown for the last turn because it's inside the while loop
        
        if  (!Board.checkStalemate()) //check if the reason it's stopped is a stalemate
        {
            System.out.println("Stalemate, sorry! :(");
        }

        if ((Board.checkRows() == 1) || (Board.checkColumns() == 1) || (Board.checkDiagonals() == 1)) //check if the reason it's stopped is because player 1 won
        {
            System.out.println(player1.playerName + " wins! Nice :)");
        }        

        if((Board.checkRows() == 2) || (Board.checkColumns() == 2) || (Board.checkDiagonals() == 2)) //check if the reason it's stopped is because player 2 won
        {
            System.out.println(player2.playerName + " wins! Nice :)");
        }                

    }
}
