package Animal;

import Displayable.displayable;

import java.awt.*;

/*This part is to build the common attributes of animals,
reduce the duplication of code in specific functions,
and reduce the changes to other codes when adding new animals.
 */

public class animal implements displayable
{
    //Define the common attributes that animals have
    private int age;
    private boolean isLive;
    private int ageLimit;

    //Constructor
    public animal(int age, boolean isLive,int ageLimit) {
        this.age = age;
        this.isLive = isLive;
    }

    public int returnAge() {
        return age;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    //Behavioral functions of animals
    public void grow(int age){
        age++;
    }

    @Override
    public void eat() {}

    public String returnColor(){
        return null;
    }

    @Override
    public Color getColor() {
        return null;
    }

    public String toString(){
        return this.getClass().getSimpleName();
    }
}
