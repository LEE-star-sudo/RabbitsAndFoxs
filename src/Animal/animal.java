package Animal;

import Displayable.displayable;

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

    //Behavioral functions of animals
    public void grow(int age){
        if(age < ageLimit){
            age++;
        }
        else{
            died();
        }
    }

    @Override
    public void eat() {}

    public void died(){
        isLive = false;
    }

    public String returnColor(){
        return null;
    }

    public String toString(){
        return this.getClass().getSimpleName();
    }
}
