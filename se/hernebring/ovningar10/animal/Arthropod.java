package se.hernebring.ovningar10.animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Arthropod extends Animal {
    private static List<String> stages;
    private boolean canFly, canSwim;


    public Arthropod(String name, List<String> stages, boolean canFly, boolean canSwim) {
        super(name);
        this.stages = new ArrayList<>();
        this.stages.addAll(stages);
        this.canFly = canFly;
        this.canSwim = canSwim;
    }

    public static List<String> getStage() {
        //List<String> rList = List.copyOf(stages); add not possible
        //List<String> rList = Collections.unmodifiableList(stages); //add gives exception
        return Collections.unmodifiableList(stages);
    }

    public String toString() {
        String data = getName();
        for(String stage:stages){
            //data+=" "
        }
        return "";
        //return name+"Stage: "+stage+" can fly: "+canFly+"\t\tcan swim: "+canSwim;
    }

    public boolean canFly() {
        return canFly;
    }

    public boolean canSwim() {
        return canSwim;
    }

}
