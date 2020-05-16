package HW1;

public class Human implements Runnable,Jumpable {

    private String name;
    private int valueRun;
    private int valueJump;

    public Human(String name, int valueRun, int valueJump){
        this.name = name;
        this.valueJump = valueJump;
        this.valueRun  = valueRun;
    }

    @Override
    public boolean Run(Track track) {

        if(valueRun >= track.value){
            System.out.println("Человек "+ name + " пробежал " + track.getName());
            return true;
        }
        else{
            System.out.println("Человек "+ name + " не пробежал " + track.getName());
            return false;
        }

    }


    @Override
    public boolean Jump(Wall wall) {

        if(valueJump >= wall.value){
            System.out.println("Человек "+ name + " перепрыгнул " + wall.getName());
            return true;
        }
        else{
            System.out.println("Человек "+ name + " не перепрыгнул " + wall.getName());
            return false;
        }

    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                '}';
    }
}
