package Animal;

import Displayable.displayable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class fox extends animal implements displayable
{

    public fox(int age,boolean isLive,int ageLimit,int locX,int locY)
    {
        super(age,isLive,ageLimit,locX,locY);
    }

    public void eat(displayable[][] map, int x, int y)
    {
        ArrayList<int[]> maps = new ArrayList<>();
        for(int i = x - 1;i < x + 2;i++)
        {
            for (int j = y - 1; j < y + 2; j++) {
                //continue the middle space
                if(i == x && j == y)
                    continue;
                //consider bordering
                if(i < 0 || j < 0 || i >= map.length || j >= map[0].length)
                    continue;
                if(map[i][j] instanceof rabbit)
                {
                    maps.add(new int[]{i,j});
                }
            }
        }
        if(maps.size() > 0)
        {
            Random rand = new Random();
            int[] beEaten = maps.get(rand.nextInt(maps.size()));
            map[beEaten[0]][beEaten[1]] = null;
            map[x][y].grow();
        }
    }

    @Override
    public Color getColor() {
        if(super.returnAge() == 2)
        {
            return Color.GRAY;
        }
        if(super.returnAge() == 3)
        {
            return Color.green;
        }
        return Color.BLACK;
    }
}
