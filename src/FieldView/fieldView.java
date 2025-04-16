package FieldView;

import javax.swing.*;
import java.awt.*;

//This is a class that implements data and draws the data through swing.

public class fieldView extends JPanel
{
    //Set the number of grids and the size of a grid
    private static final int GRID_WIDTH = 90;
    private static final int GRID_HEIGHT = 90;
    private static final int CELL_SIZE = 8;

    //Constructor, set the total size and background color of the canvas
    public fieldView()
    {
        setPreferredSize(new Dimension(GRID_WIDTH*CELL_SIZE, GRID_HEIGHT*CELL_SIZE));
        setBackground(Color.white);
    }

    //Calling the drawing function
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);

        //Draw the grid
        for (int x = 0; x < GRID_WIDTH; x++){
            g.drawLine(x*CELL_SIZE, 0, x*CELL_SIZE, GRID_HEIGHT);
        }
        for (int y = 0; y < GRID_HEIGHT; y++){
            g.drawLine(0, y*CELL_SIZE, GRID_WIDTH, y*CELL_SIZE);
        }
    }
}
