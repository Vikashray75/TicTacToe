package Models;

import java.util.Scanner;

public class Player {
    String Name;
    Character Symbol;

   


public Player(String Name,Character Symbol)
    {
        this.Name=Name;
        this.Symbol=Symbol;
    }
    public String getName() {
        return Name;
    }
    public Character getSymbol() {
        return Symbol;
    }

    

    public Move makMove(Board board)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println(getName()+"'s turn, give row and col");
        int row=sc.nextInt();
        int col=sc.nextInt();
        Cell cell = board.setPlayer(this, row, col);
       Move move=new Move(this, cell);
       return move;
        
    }

    

    
    // public String toString()
    // {
    //     return "Player name:"+Name +"player Symbol:"+" "+Symbol+" ";
    // }
    
}
