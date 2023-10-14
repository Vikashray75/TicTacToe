package Models;

public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState cellState;

    public Cell(int row,int col,CellState cellState)
    {
        this.row=row;
        this.col=col;
        this.player=null;
        this.cellState=cellState;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }


    public Player getPlayer() {
        return player;
    }

    public Cell setPlayer(Player player) {
        this.player = player;
        this.cellState=cellState.OCCUPIED;
        return this;
    }

    public void removePlayer()
    {
        this.player=null;
        this.cellState=CellState.EMPTY;
    }

    public CellState getCellState() {
        return cellState;
    }

    

    

    
}
