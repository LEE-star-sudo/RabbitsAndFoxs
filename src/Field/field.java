package Field;
import Animal.animal;
import Animal.rabbit;
import Displayable.displayable;
import FieldView.fieldView;
import Animal.fox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

//The data part of the whole game
public class field
{
    private final displayable[][] object = new displayable[90][90];
    private final ArrayList<animal> temp_animals = new ArrayList<>();
    private double chance;
    fieldView fv;

    public field()
    {
        fv = new fieldView();
        fv.setObject(object);
    }

    public void InitializingObject(int x, int y,displayable animal)
    {
        object[x][y] = animal;
        temp_animals.add((animal) animal);
        fv.setObject(object);
    }

    public fieldView getView()
    {
        return fv;
    }

    public void generateRabbitAndFox(int x, int y)
    {
        animal a = null;
        Random rand = new Random();
        double chance = rand.nextDouble();
        if(chance < 0.3)
        {
            a = new fox(1,true,3,x,y);
            temp_animals.add(a);
            object[x][y] = a;
        } else if (chance < 0.6) {
            a = new rabbit(1,true,3,x,y);
            temp_animals.add(a);
            object[x][y] = a;
        }else{
            object[x][y] = null;
        }
    }

    public void generateAnimals()
    {
        for (int x = 0; x < 90; x++) {
            for (int y = 0; y < 90; y++) {
                Random rand = new Random();
                chance = rand.nextDouble();
                if (chance < 0.3) {
                    displayable fox = new fox(1, true, 3,x,y);
                    InitializingObject(x, y, fox);
                } else if (chance < 0.4) {
                    displayable rabbit = new rabbit(1, true, 3,x,y);
                    InitializingObject(x, y, rabbit);
                }
            }
        }
    }

    public void updateGame() {
        Iterator<animal> it = temp_animals.iterator();
        while(it.hasNext()) {
            animal animal = it.next();
            if(animal instanceof rabbit) {
                animal.grow();
            } else if (animal instanceof fox) {
                animal.eat();
                animal.grow();
            }

            if(animal.returnAge() > animal.getAgeLimit()) {
                object[animal.returnLocation()[0]][animal.returnLocation()[1]] = null;
                it.remove();
            }else{
                object[animal.returnLocation()[0]][animal.returnLocation()[1]] = animal;
            }
        }
        for(int i = 0;i < 90;i++)
        {
            for(int j = 0;j < 90;j++)
            {
                if(object[i][j] == null)
                {
                    generateRabbitAndFox(i,j);
                }
            }
        }
        fv.setObject(object);
    }
}
