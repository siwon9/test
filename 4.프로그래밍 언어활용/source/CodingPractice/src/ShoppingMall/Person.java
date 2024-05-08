package ShoppingMall;

public class Person {
    private String name;
    private int id;
    private String address;
    
    public Person (String name, int id, String address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
