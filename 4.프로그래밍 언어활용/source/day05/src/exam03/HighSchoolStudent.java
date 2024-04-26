package exam03;

public class HighSchoolStudent extends Student {

    public HighSchoolStudent(){
        super(1000, "siwon");
    }

    @Override
    public String toString() {
        return "HighSchoolStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
