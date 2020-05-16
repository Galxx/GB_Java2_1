package HW1;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private List<Object> teammates;
    private List<Object> teammatesWin;

    public Team(){
        teammates    = new ArrayList<Object>();
        teammatesWin = new ArrayList<Object>();
    }

    public void addtTammate(Object o){
        teammates.add(o);
    }

    public void addtTammateWin(Object o){
        teammatesWin.add(o);
    }

    public List<Object> getTeammates() {
        return teammates;
    }

    public void showResults(){

        System.out.println("Победители:");

        for (Object teammate : teammatesWin) {
            System.out.println(teammate);
        }

    }
}
