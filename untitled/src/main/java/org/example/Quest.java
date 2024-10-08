package org.example;

import java.util.ArrayList;
import java.util.List;

public class Quest {
    List<Stage> stages;
    public Quest(List<Stage> newStages){
        stages = newStages;
    }
    public Quest addStage(Stage newStage ){
        List<Stage> newStages = new ArrayList<>(stages);
        newStages.add(newStage);
        return new Quest(newStages);
    }
    public List<Stage> getStages() {
        return stages;
    }
}
