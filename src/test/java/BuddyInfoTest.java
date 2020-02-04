
import accessingdatajpa.BuddyInfo;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    private BuddyInfo b;

    @org.junit.Test
    public void getPhoneNum() {
        b = new BuddyInfo("Bob" , 123456);
        assertEquals("The Buddy's phone number is 123456:" , 123456, b.getPhoneNum());
    }

    @org.junit.Test
    public void setPhoneNum() {
        b = new BuddyInfo("Sam", 123456);
        b.setPhoneNum(789);
        assertEquals("The Buddy's phone number is set to 789:" , 789, b.getPhoneNum());

    }

    @org.junit.Test
    public void getBuddyName() {
        b = new BuddyInfo("Sam", 123456);
        assertEquals("The Buddy's name is Sam" , "Sam", b.getBuddyName());
    }

    @org.junit.Test
    public void setBuddyName() {
        b = new BuddyInfo("Sam", 123456);
        b.setBuddyName("Robert");
        assertEquals("The Buddy's name is Robert" , "Robert", b.getBuddyName());

    }
}