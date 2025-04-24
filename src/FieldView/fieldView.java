package FieldView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Displayable.displayable;
import Field.field;

//This is a class that implements data and draws the data through swing.

public class fieldView extends JPanel
{
    private static final int GRID_WIDTH = 90;
    private static final int GRID_HEIGHT = 90;
    private static final int CELL_SIZE = 15;
    private displayable objects[][];
    private int hoveredX;
    private int hoveredY;

    private JWindow window;
    private JLabel label;

    //初始化
    public fieldView()
    {
        setPreferredSize(new Dimension(GRID_WIDTH*CELL_SIZE, GRID_HEIGHT*CELL_SIZE));
        setBackground(Color.white);
        window = new JWindow();
        label = new JLabel();

        //小窗口初始化
        label.setOpaque(true);
        label.setBackground(Color.white);
        label.setBorder(BorderFactory.createLineBorder(Color.white));
        window.getContentPane().add(label);
        window.setSize(200,200);

        //添加鼠标的监测
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {}

            @Override
            public void mouseMoved(MouseEvent e) {
                //获取鼠标是否在某个网格内
                int mouseX = e.getX();
                int mouseY = e.getY();
                hoveredX = mouseX/CELL_SIZE;
                hoveredY = mouseY/CELL_SIZE;

                //判断整个数组是否为空以及鼠标坐标是否越界
                if(objects != null &&
                   hoveredX >= 0 && hoveredY >= 0 && hoveredX < objects.length &&
                   hoveredY < objects[0].length)
                {
                    displayable temp = objects[hoveredX][hoveredY];
                    if(temp != null){
                        label.setText(temp.getClass().getSimpleName() + "\n" + "  " + "Age is " + temp.returnAge());
                        Point screenPoint = e.getLocationOnScreen();
                        window.setLocation(screenPoint.x + 10, screenPoint.y + 10);
                        window.setVisible(true);
                    }else {
                        window.setVisible(false);
                    }
                } else {
                    window.setVisible(false);
                }
                repaint();
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {
                window.setVisible(false);
            }
        });
    }

    public void setObject(displayable[][] objects)
    {
        this.objects = objects;
        repaint();
    }


    //绘图
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);

        //填上颜色
        if (objects!=null){
            for(int x = 0; x < objects.length; x++)
            {
                for(int y = 0; y < objects[x].length; y++){
                    displayable d = objects[x][y];
                    if(d != null){
                        g.setColor(d.getColor());
                        g.fillRect(x*CELL_SIZE, y*CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    }
                }
            }
        }

        //画网格
        for (int x = 0; x < GRID_WIDTH; x++){
            g.drawLine(x*CELL_SIZE, 0, x*CELL_SIZE, GRID_HEIGHT*CELL_SIZE);
        }
        for (int y = 0; y < GRID_HEIGHT; y++){
            g.drawLine(0, y*CELL_SIZE, GRID_WIDTH*CELL_SIZE, y*CELL_SIZE);
        }

    }
}
