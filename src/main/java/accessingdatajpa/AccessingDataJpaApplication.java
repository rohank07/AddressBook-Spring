package accessingdatajpa;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class AccessingDataJpaApplication{
    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main (String[] args){
        SpringApplication.run(AccessingDataJpaApplication.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyRepository repository) {
        return (args) -> {
            repository.save(new BuddyInfo("Samuel", 5673));
            repository.save(new BuddyInfo("Jonathan", 5664));
            repository.save(new BuddyInfo("Matt", 1232));


            log.info("Buddies found with findAll()");
            log.info("-----------------------------");
            for (BuddyInfo buddy : repository.findAll()) {
                log.info(buddy.toString());
            }
            log.info("");


            log.info("Find buddy by ID");
            log.info("---------------------------");
            BuddyInfo buddyInfo = repository.findById(1);
            log.info("----------------------------");
            log.info(buddyInfo.toString());
            log.info("");


            log.info("Buddy found with findbyName Matt");
            log.info("--------------------------------");
            repository.findByName("Matt").forEach(Matt -> {
                log.info(Matt.toString());


            });


            log.info("");



        };
    }
}
