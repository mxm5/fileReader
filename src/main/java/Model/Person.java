package Model;

import org.apache.commons.csv.CSVRecord;

public class Person {
    private int id;
    private String name;
    private int age;

    private String phone;

    public Person(int id, String name, int age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // getters and setters


    @Override
    public String toString() {
        return "Model.Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static Person fromRecord(CSVRecord record) {
        int id = Integer.parseInt(record.get("id"));
        String name = record.get("name");
        int age = Integer.parseInt(record.get("age"));
        String phone = record.get("phone");
        return new Person(id, name, age, phone);
    }
}
