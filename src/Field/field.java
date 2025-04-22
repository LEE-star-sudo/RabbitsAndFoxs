package Field;
import Animal.rabbit;
import Displayable.displayable;
import FieldView.fieldView;
import Animal.fox;

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

    public void updateGame() {
        for (int i = 0; i < 90; i++)
        {
            for (int j = 0; j < 90; j++)
            {
                if (object[i][j] != null) {
                    if(object[i][j] instanceof rabbit)
                    {
                        rabbit r = (rabbit) object[i][j];
                        r.grow();
                        if(r.returnAge() > r.getAgeLimit())
                        {
                            object[i][j] = null;
                            continue;
                        }
                        object[i][j] = r;
                    }
                    else if (object[i][j] instanceof fox)
                    {
                        fox f = (fox) object[i][j];
                        f.eat(object, i, j);
                        if(f.returnAge() > f.getAgeLimit())
                        {
                            object[i][j] = null;
                            continue;
                        }
                        object[i][j] = f;
                    }
                }
            }
        }
        fv.setObject(object);
    }
}
