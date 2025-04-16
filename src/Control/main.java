package Control;
import Animal.animal;
import Animal.fox;
import Animal.rabbit;
import Field.field;
import Displayable.displayable;

import java.util.Random;

//Control section
public class main
{
    //Initialization function.
    public void InitializingGame()
    {
        //Set up a random function and randomly generate a fox or a rabbit
        Random rand = new Random();
        double chance;
        field f = new field();
        for(int x = 0;x < 90;x++)
        {
            for (int y = 0;y < 90;y++)
            {
                chance = rand.nextDouble();
                if(chance < 0.1){
                    displayable fox = new fox(1,true,3);
                    f.InitializingObject(x,y,fox);
                } else if (chance < 0.4) {
                    displayable rabbit = new rabbit(1,true,3);
                    f.InitializingObject(x,y,rabbit);
                }
            }
        }
    }
    public static void main(String[] args) {
        main start = new main();
        start.InitializingGame();
    }
}
