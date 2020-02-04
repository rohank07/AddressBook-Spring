package accessingdatajpa;

import javax.persistence.*;

@Entity
public class BuddyInfo {
    @ManyToOne
    private AddressBook addressBook;
    private int phoneNum;
    private String buddyName;
    @Id
    @GeneratedValue
    private Integer id;

    public BuddyInfo(String buddyName, int phoneNum){
        this.phoneNum = phoneNum;
        this.buddyName = buddyName;
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

    public String getBuddyName() {
        return buddyName;
    }

    public void setBuddyName(String buddyName) {
        this.buddyName = buddyName;
    }





}
