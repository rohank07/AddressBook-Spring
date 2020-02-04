import accessingdatajpa.AddressBook;
import accessingdatajpa.BuddyInfo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
public class JPATest {

    public void performJPA(){
        BuddyInfo buddy1 = new BuddyInfo();
        buddy1.setBuddyName("Jacob");
        buddy1.setPhoneNum(6476778);

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setBuddyName("Mathew");
        buddy2.setPhoneNum(678655);

        BuddyInfo buddy3 = new BuddyInfo();
        buddy3.setBuddyName("Robin");
        buddy3.setPhoneNum(445432);

        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy3);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(buddy1);
        em.persist(buddy2);
        em.persist(addressBook);

        tx.commit();

        Query q = em.createQuery("Select p from BuddyInfo p");

        Query addressBookQuery = em.createQuery("Select a from AddressBook a");
        @SuppressWarnings("unchecked")
        List<AddressBook> addressBookQueryResultList = addressBookQuery.getResultList();

        @SuppressWarnings("unchecked")
        List<BuddyInfo> results = q.getResultList();

        for (BuddyInfo b:  results){
            System.out.println(b.getBuddyName() + "(id= " + b.getId() + ")");
        }
        for (AddressBook a : addressBookQueryResultList){
            System.out.println("(id= " + a.getId() + ")");
        }

        em.close();
        emf.close();
    }
    public static void main (String[]args){
        JPATest jpa = new JPATest();
        jpa.performJPA();
    }
}


