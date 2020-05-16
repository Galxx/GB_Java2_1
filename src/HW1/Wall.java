package HW1;

public class Wall extends Obstacle {

    public Wall(String n, int v){
        this.name  = n;
        this.value = v;
    }

    public boolean go(Object teammate) {

        Jumpable j = (Jumpable) teammate;
        boolean runResult = j.Jump(this);
        return runResult;

    }



}
