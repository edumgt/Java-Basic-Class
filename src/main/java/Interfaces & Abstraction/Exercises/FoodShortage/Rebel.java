package InterfacesAndAbstractionEXERCISES.FoodShortage;

public class Rebel implements Buyer, Person {

    private String name;

    private int age;

    private String group;

    private int food = 0;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public void buyFood() {
        food += 5;

    }

    @Override
    public int getFood() {
        return food;
    }
}
