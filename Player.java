public class Player
{
    String playerName;
    
    public Player()
    {
        playerName = "";
    }

    public void setName(String playerName) //sets the player's name
    {
        this.playerName = playerName;
    }
    
    public String getName() //returns the player's name
    {
        return this.playerName;
    }

}
