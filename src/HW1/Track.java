package HW1;

public class Track extends Obstacle{

    public Track(String n,int v){
        name  = n;
        value = v;
    }

    @Override
    public boolean go(Object teammate) {

        Runnable r = (Runnable) teammate;
        boolean runResult = r.Run(this);
        return runResult;

    }
}
