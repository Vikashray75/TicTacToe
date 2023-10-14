package Strategies;

import java.util.List;

import Models.Board;
import Models.Cell;
import Models.CellState;
import Models.Move;

public class OrderNWinningStrategies implements WinningStrategies{

    @Override
    public boolean checkifWon(Board board, Move move) {
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        List<Cell> cells = board.getCells().get(row);
        int count=0;
        for(Cell cell:cells)
        {
            if(cell.getCellState()==CellState.OCCUPIED && cell.getPlayer().getSymbol()==move.getPlayer().getSymbol())
            {
                count++;
            }
            else
            {
                break;
            }

        }

        if(count==cells.size())
        return true;

        count =0;
        for(int i=0;i<cells.size();i++)
        {
            Cell cell = board.getCells().get(i).get(col);
            if(cell.getCellState().equals(CellState.OCCUPIED) && cell.getPlayer().getSymbol()==move.getPlayer().getSymbol())
            {
                count++;
            }
            else
            {
                break;
            }

            if(count==cells.size())
            {
                return true;
            }
        }

        count=0;
        if(row==col)
        {
            for(int i=0;i<board.getCells().size();i++)
            {
                Cell cell = board.getCells().get(i).get(i);
                if(cell.getCellState()==CellState.OCCUPIED && cell.getPlayer().getSymbol()==move.getPlayer().getSymbol())
                {
                    count++;
                }
                else
                {
                    break;
                }

                if(count==cells.size())
                {
                    return true;
                }
            }
        }

        count =0;
        if(row+col==board.getCells().size()-1)
        {
            for(int i=0;i<board.getCells().size();i++)
            {
                int j=board.getCells().size()-1-i;
                Cell cell = board.getCells().get(i).get(j);
                if(cell.getCellState()==CellState.OCCUPIED && cell.getPlayer().getSymbol()==move.getPlayer().getSymbol())
                {
                    count++;
                }
                else
                {
                    break;
                }

                if(count==cells.size())
                {
                    return true;
                }
            }
        }

        return false;
      
    }
    
}
