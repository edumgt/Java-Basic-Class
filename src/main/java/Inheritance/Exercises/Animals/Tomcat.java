package InheritanceEXERCISES.Animals;

public class Tomcat extends Cat {

    public static final String gender = "Male";

    public Tomcat(String name, int age) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }

}
