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
    private field f;
    private JFrame frame;
    private JButton stepButton;
    private JButton startButton;
    private JPanel buttonPanel;
    private Random rand;
    private double chance;
    private int choice;

    public main()
    {
        f = new field();
        frame = new JFrame();
        rand = new Random();
        stepButton = new JButton("Step");
        startButton = new JButton("Start");
        buttonPanel = new JPanel();
    }

    //初始化对话框
    public void InitializeDialogBox()
    {
        frame.setTitle("Animal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(f.getView());
        frame.pack();
        frame.setVisible(true);

        //Create button
        buttonPanel.add(startButton);
        buttonPanel.add(stepButton);
        frame.add(buttonPanel, BorderLayout.NORTH);
    }

    //设置按钮
    public void setButton()
    {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
    }

    //随机生成动物
    public void generateAnimals()
    {
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
    }

    //Initialization function.
    public void initializingGame()
    {
        String[] options = {"start","exit"};
        choice = JOptionPane.showOptionDialog(null,
                "Welcome to the game of animals !",
                "Welcome",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,options[0]);

        //Initializing
        if(choice == 0)
        {
            InitializeDialogBox();
            generateAnimals();
            setButton();
        } else if (choice == 1)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        main start = new main();
        start.initializingGame();
    }
}