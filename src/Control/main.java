package Control;
import Animal.fox;
import Animal.rabbit;
import Field.field;
import Displayable.displayable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

//Control section
public class main
{
    //Initialization function.
    public void InitializingGame()
    {
        String[] options = {"exit","start"};
        int choice = JOptionPane.showOptionDialog(null,"Welcome to the game of animals !",
                "Welcome",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,options,options[0]);
        
        //Initializing
        if(choice == 0)
        {
            field f = new field();
            JFrame frame = new JFrame();
            frame.setTitle("Animal");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(f.getView());
            frame.pack();
            frame.setVisible(true);

            //Create button
            JButton stepButton = new JButton("Step");
            JButton startButton = new JButton("Start");
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(startButton);
            buttonPanel.add(stepButton);
            frame.add(buttonPanel, BorderLayout.NORTH);

            //Button logic
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.updateGame();
                    startButton.setVisible(false);
                    //add button
                    stepButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            f.updateGame();
                        }
                    });
                }
            });

            //Set up a random function and randomly generate a fox or a rabbit
            Random rand = new Random();
            double chance;
            for (int x = 0; x < 90; x++) {
                for (int y = 0; y < 90; y++) {
                    chance = rand.nextDouble();
                    if (chance < 0.3) {
                        displayable fox = new fox(1, true, 3);
                        f.InitializingObject(x, y, fox);
                    } else if (chance < 0.4) {
                        displayable rabbit = new rabbit(1, true, 3);
                        f.InitializingObject(x, y, rabbit);
                    }
                }
            }
        } else if (choice == 1)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        main start = new main();
        start.InitializingGame();
    }
}