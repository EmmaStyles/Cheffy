package com.infs3634.cheffy;

import java.util.ArrayList;
import java.util.List;

//Level object that determines which level you are based on the number of goals you've completed
public class Level {
    public String level;

    public Level(){
    }

    public Level(String level){
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public static List<Level> getLevels() {
        List<Level> levels = new ArrayList<>();
        levels.add(new Level("Apprentice"));
        levels.add(new Level("Demi Chef"));
        levels.add(new Level("Sous Chef"));
        levels.add(new Level("Head Chef"));
        return levels;
    }
}
