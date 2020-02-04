
import accessingdatajpa.AddressBook;
import accessingdatajpa.BuddyInfo;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressBookTest {

    private AddressBook addressBook;
    private BuddyInfo buddyInfo;

    private BuddyInfo buddy1;
    private BuddyInfo buddy2;

    @Test
    public void addBuddy() {
        addressBook = new AddressBook();
        buddyInfo = new BuddyInfo("Noah", 6475);
        addressBook.getBuddyInfos().add(buddyInfo);

        assertEquals("The address book has a buddy inserted" ,1 ,addressBook.buddySize());

    }

    @Test
    public void buddySize() {
        addressBook = new AddressBook();
        buddy1 = new BuddyInfo("Noah", 6475);
        buddy2 = new BuddyInfo("Josh", 789456);
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        assertEquals("The address book has a buddy inserted" ,2 ,addressBook.buddySize());
    }

}