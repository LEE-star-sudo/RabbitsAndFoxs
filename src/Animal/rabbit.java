package Animal;

import Displayable.displayable;

import java.awt.*;

public class rabbit extends animal implements displayable
{
    public rabbit(int age, boolean isLive,int ageLimit) {
        super(age, isLive,ageLimit);
    }

    public String returnColor(){
        return "r";
    }


    @Override
    public Color getColor() {
        return Color.RED;
    }
}
