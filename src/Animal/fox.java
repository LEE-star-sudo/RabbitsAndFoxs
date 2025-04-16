package Animal;

import Displayable.displayable;

public class fox extends animal implements displayable
{
    private int ageLimit;
    private boolean isLive;
    private int age;

    public fox(int age,boolean isLive,int ageLimit)
    {
        super(age,isLive,ageLimit);
    }

    public void grow(int age){
        super.grow(age);
    }

    public void eat(){}

    public void died(){
        super.died();
    }

    public String returnColor(){
        return "F";
    }

//    public String toString(){
//        return super.toString();
//    }
}
