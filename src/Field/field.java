package Field;
import Displayable.displayable;
import FieldView.fieldView;

//The data part of the whole game
public class field
{
    private final displayable[][] object = new displayable[90][90];
    fieldView fv;

    public field()
    {
        fv = new fieldView();
        fv.setObject(object);
    }

    public void InitializingObject(int x, int y,displayable animal)
    {
        object[x][y] = animal;
        fv.setObject(object);
    }

    public fieldView getView()
    {
        return fv;
    }
}
