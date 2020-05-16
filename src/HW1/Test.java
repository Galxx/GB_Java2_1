package HW1;

public class Test {

    public static void main(String[] args) {

        Course c = new Course(); // Создаем полосу препятствий
        c.addtObstacle(new Track("Дорожка № 1",20));
        c.addtObstacle(new Wall("Стена № 1",20));
        c.addtObstacle(new Track("Дорожка № 2",80));

        Team team = new Team(); // Создаем команду
        team.addtTammate(new Robot("Pasha", 100, 50));
        team.addtTammate(new Cat("Barsik", 50, 10));
        team.addtTammate(new Human("Gosha", 70, 50));
        team.addtTammate(new Human("Sasha", 110, 50));

        c.dolt(team);
        team.showResults();

    }
}