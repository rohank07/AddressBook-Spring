package accessingdatajpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


    public interface BuddyRepository extends CrudRepository<BuddyInfo, Integer> {

        List<BuddyInfo> findByBuddyName(String name);
        BuddyInfo findById (int id);


}
