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
    private JButton resetButton;
    private JButton exitButton;
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
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");
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
        buttonPanel.add(resetButton);
        buttonPanel.add(exitButton);
        frame.add(buttonPanel, BorderLayout.NORTH);
    }

    //设置按钮
    public void setButton()
    {
        stepButton.setVisible(false);
        resetButton.setVisible(false);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setVisible(false);
                stepButton.setVisible(true);
                resetButton.setVisible(true);
                f.generateAnimals();
                stepButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f.updateGame();
                    }
                });
                resetButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        f.generateAnimals();
                        f.updateGame();
                    }
                });
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    //主界面逻辑
    public void initializingGame()
    {
        String[] options = {"play","exit","instructions"};
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
            setButton();
        } else if (choice == 1)
        {
            System.exit(0);
        } else if (choice == 2) {
            showInstructions();
            InitializeDialogBox();
            setButton();
        }
    }

    private void showInstructions() {
        String message = "游戏说明“：";
        JOptionPane.showMessageDialog(null, message,"游戏说明",JOptionPane.QUESTION_MESSAGE);
    }

    public static void main(String[] args) {
        main start = new main();
        start.initializingGame();
    }
}