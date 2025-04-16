package Field;
import Displayable.displayable;

//The data part of the whole game
public class field
{
    private displayable object[][] = new displayable[90][90];

    public void InitializingObject(int x, int y,displayable animal)
    {
        object[x][y] = animal;
        System.out.println(object[x][y]);
    }
}
