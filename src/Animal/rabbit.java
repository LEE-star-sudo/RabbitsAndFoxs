package Animal;

import Displayable.displayable;

public class rabbit extends animal implements displayable
{
    private int ageLimit;
    private boolean isLive;
    private int age;

    public rabbit(int age, boolean isLive,int ageLimit) {
        super(age, isLive,ageLimit);
    }

    public void grow(){

    }

    public void died(){
        super.died();
    }

    public String returnColor(){
        return "r";
    }
}
