package accessingdatajpa;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.*;

@Entity
@Component
public class AddressBook {

    @OneToMany
    private List<BuddyInfo> buddyInfos;

    @Id
    @GeneratedValue
    private Integer id;

    public AddressBook(){
        buddyInfos = new ArrayList<BuddyInfo>();
    }

    public AddressBook(Integer id){
        this.id =id;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<BuddyInfo> getBuddyInfos() {
        return buddyInfos;
     }

     public void setBuddyInfos(List<BuddyInfo> buddyInfos) {
        this.buddyInfos = buddyInfos;
    }

    public void addBuddy(BuddyInfo buddy){
        buddyInfos.add(buddy);
    }

    public int buddySize(){
        return buddyInfos.size();
    }

    public String ToString(){
        String s = "";
        for (BuddyInfo b: buddyInfos){
            s += " Name: " + b.getBuddyName() + " Phone Number: " + b.getPhoneNum() + " \n";
        }
        return s;
    }
    public void removeBuddy (int index){
        if (index >= 0 && index < buddySize()){
            buddyInfos.remove(index);
        }
    }


    public static void main (String [] args){
        AddressBook addressBook = new AddressBook();

        BuddyInfo buddy1 = new BuddyInfo("Guru" , 789);
        addressBook.addBuddy(buddy1);

        BuddyInfo buddy2 = new BuddyInfo("Abu" , 619);
        addressBook.addBuddy(buddy2);

        BuddyInfo buddy3 = new BuddyInfo("Roh" , 123);
        addressBook.addBuddy(buddy3);

        addressBook.ToString();
    }



}
