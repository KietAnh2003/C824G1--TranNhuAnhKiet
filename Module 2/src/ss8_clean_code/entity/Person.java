package ss8_clean_code.entity;

import java.util.Objects;

public abstract class Person {
    private long code;
    private String name;
    private String address;
    public Person(){
    }
    public Person(long code, String address, String name){
        this.code = code;
        this.address = address;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public long getCode() {
        return code;
    }
    public void setCode(long code) {
        this.code = code;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass()!= o.getClass()) return false;
        Person person = (Person) o ;
        return code == person.code && Objects.equals(name, person.name);
    }
    public int hashcode(){ return Objects.hash(code, name);}

    public String toString(){
        return " Person{" + "id=" + code + ", name" + name + ", address" + address + "}";
    }
}
