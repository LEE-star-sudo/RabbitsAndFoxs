package Animal;

import Displayable.displayable;

import java.awt.*;

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

    public String returnColor(){
        return "r";
    }


    @Override
    public Color getColor() {
        return Color.RED;
    }
}
