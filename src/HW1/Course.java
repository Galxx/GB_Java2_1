package HW1;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private List<Obstacle> obstacles;

    public Course(){
        obstacles = new ArrayList<Obstacle>();
    }

    public void addtObstacle(Obstacle o){
        obstacles.add(o);
    }

    public void dolt(Team team){
        List<Object> teammates = team.getTeammates();

        for (Object teammate : teammates) {

            boolean win = true;

            for (Obstacle obstacle : obstacles) {
                if (!obstacle.go(teammate)){
                    win = false;
                    break;
                };
            }
            if(win) team.addtTammateWin(teammate);
        }
    }

}
