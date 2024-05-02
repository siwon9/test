package Employee;

public class Engineer extends Employee {

    public Engineer(String name) {
        super(name);
    }

    private String skillset;

    public String getSkillset(){
        return skillset;
    }
    public void setSkillSet(String skillset){
        this.skillset = skillset;
    }
}
