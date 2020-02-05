package accessingdatajpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


    public interface BuddyRepository extends CrudRepository<BuddyInfo, Integer> {

        List<BuddyInfo> findByName(String name);
        BuddyInfo findById (int id);


}
