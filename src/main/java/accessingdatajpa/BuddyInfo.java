package accessingdatajpa;

import javax.persistence.*;

@Entity
public class BuddyInfo {
    @ManyToOne
    private AddressBook addressBook;
    private int phoneNum;
    private String name;
    @Id
    @GeneratedValue
    private Integer id;

    public BuddyInfo(String name, int phoneNum){
        this.phoneNum = phoneNum;
        this.name = name;
    }
    public BuddyInfo(){

    }


    public Integer getId(){return id;}

    public void setId(Integer id){this.id =id;}

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
