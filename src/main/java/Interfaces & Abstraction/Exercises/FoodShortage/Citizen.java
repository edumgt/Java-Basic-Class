package InterfacesAndAbstractionEXERCISES.FoodShortage;

public class Citizen implements Person, Identifiable, Birthable, Buyer {

    private String name;

    private int age;

    private String id;

    private String birthDate;

    private int food = 0;

    public Citizen(String name, int age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }



    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }




    @Override
    public String getBirthDate() {
        return birthDate;
    }





    @Override
    public String getId() {
        return id;
    }







    @Override
    public void buyFood() {
        food += 10;

    }

    @Override
    public int getFood() {
        return food;
    }
}
