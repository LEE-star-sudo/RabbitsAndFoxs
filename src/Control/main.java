package Control;
import Animal.animal;
import Animal.fox;
import Animal.rabbit;
import Field.field;
import Displayable.displayable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

//Control section
public class main
{
    //Initialization function.
    public void InitializingGame()
    {
        field f = new field();
        JFrame frame = new JFrame();
        frame.setTitle("Animal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(f.getView());
        JButton stepButton = new JButton("Step");
        //add button
        stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.updateGame();
            }
        });
        frame.add(stepButton, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);

        //Set up a random function and randomly generate a fox or a rabbit
        Random rand = new Random();
        double chance;
        for(int x = 0;x < 90;x++)
        {
            for (int y = 0;y < 90;y++)
            {
                chance = rand.nextDouble();
                if(chance < 0.3){
                    displayable fox = new fox(1,true,3);
                    f.InitializingObject(x,y,fox);
                } else if (chance < 0.4) {
                    displayable rabbit = new rabbit(1,true,3);
                    f.InitializingObject(x,y,rabbit);
                }
            }
        }

//        Timer timer = new Timer(1000,new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                f.updateGame();
//            }
//        });
//        timer.start();
    }

    public static void main(String[] args) {
        main start = new main();
        start.InitializingGame();
    }
}
