package HW1;

public class Cat implements Runnable,Jumpable {

    private String name;
    private int valueRun;
    private int valueJump;

    public Cat(String name,int valueRun, int valueJump){
        this.name = name;
        this.valueJump = valueJump;
        this.valueRun  = valueRun;
    }

    @Override
    public boolean Run(Track track) {
        if(valueRun >= track.value){
            System.out.println("Кошка "+ name + " пробежал " + track.getName());
            return true;
        }
        else{
            System.out.println("Кошка "+ name + " не пробежал " + track.getName());
            return false;
        }
    }


    @Override
    public boolean Jump(Wall wall) {
        if(valueJump >= wall.value){
            System.out.println("Кошка "+ name + " перепрыгнула " + wall.getName());
            return true;
        }
        else{
            System.out.println("Кошка "+ name + " не перепрыгнула " + wall.getName());
            return false;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
