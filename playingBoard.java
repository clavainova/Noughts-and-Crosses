public class playingBoard
{	
    private int[][] Board;

    //create the board array
    public playingBoard()
    {
        Board = new int[3][3]; 
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                Board[i][j] = 0;
            }
        }
    }

    //check that they haven't already chosen that square
    public boolean isCellEmpty(int x, int y)
    {   
        if(Board[x][y] == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    int playerCount = 0;
    
    //fill the space with their new integer
    public void addPlay(int x, int y)
    {
        if (playerCount % 2 == 0)
        {
            Board[x][y] = 1;
        }
        else
        {
            Board[x][y] = -1;
        }
        
        playerCount++;
    }

    //print out the board (much of this is decorative - e.g. turning them to noughts and crosses and doing the line breaks)
    public void drawSelf()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(Board[i][j] == -1)
                {
                    System.out.print("0");
                }
                if(Board[i][j] == 1)
                {
                    System.out.print("X");
                }
                if(Board[i][j] == 0)
                {
                    System.out.print(" ");
                }
                if (j != 2)
                {
                    System.out.print (" | ");
                }
            }
            System.out.println();
            if (i != 2)
            {
                System.out.println ("--|---|--");
            }
        }

    }

    //check that none of the rows have the same - a win
    public int checkRows()
    {
        int total;
        for( int i = 0; i < 3; i++)
        {
            total = Board[i][0] + Board[i][1] + Board[i][2];
            if (total == 3)
            {
                return 1;
            }
            else if (total == -3)
            {
                return 2;
            }
        }
        return 0;
    }

    //check that none of the columns have the same - a win
    public int checkColumns()
    {
        int total;
        for( int j = 0; j < 3; j++)
        {
            total = Board[0][j] + Board[1][j] + Board[2][j];
            if (total == 3)
            {
                return 1;
            }
            else if (total == -3)
            {
                return 2;
            }
        }
        return 0;
    }

    //check that none of the diagonals have the same - a win
    public int checkDiagonals()
    {
        if ((Board[0][0] + Board[1][1] + Board[2][2] == 3) || (Board[2][0] + Board[1][1] + Board[0][2] == 3))
        {
            return 1;
        }
        else if ((Board[2][0] + Board[1][1] + Board[0][2] == 3) || (Board[2][0] + Board[1][1] + Board[0][2] == -3))
        {
            return 2;
        }
        return 0;
    }

    //check that there is still space and that it isn't a stalemate
    public boolean checkStalemate()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (Board[i][j] == 0)
                {
                    return true; //?
                }
            }
        }
        return false; //?
    }

}