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
    private int locX;
    private int locY;

    //Constructor
    public animal(int age, boolean isLive,int ageLimit,int locX,int locY) {
        this.age = age;
        this.isLive = isLive;
        this.ageLimit = ageLimit;
        this.locX = locX;
        this.locY = locY;
    }

    public int returnAge() {
        return age;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    //Behavioral functions of animals
    public void grow(){
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

    public int[] returnLocation(){
        return new int[]{locX,locY};
    }
}
