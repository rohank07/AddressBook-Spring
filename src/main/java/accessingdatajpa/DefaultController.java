package accessingdatajpa;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class DefaultController {


    private AddressBookRepository addressRepo;
    private BuddyRepository buddyRepo;

    @Autowired
    public DefaultController(AddressBookRepository addressRepo , BuddyRepository buddyRepo){
        this.addressRepo = addressRepo;
        this.buddyRepo = buddyRepo;
    }

    @PostMapping("/add")
    @ResponseStatus (value = HttpStatus.OK)
    public void addBuddy(@RequestParam(value = "name" ,required =  true) String name, @RequestParam(value ="number" , required = true) int number ){
        AddressBook addressbook = addressRepo.findById(4);
        BuddyInfo buddy = new BuddyInfo(name, number);
        addressbook.addBuddy(buddy);
        buddyRepo.save(buddy);
    }

    @PostMapping("/addBook")
    @ResponseStatus(value = HttpStatus.OK)
    public void addAddressBook(){
        AddressBook addressBook = new AddressBook();
        addressRepo.save(addressBook);
    }

    @PostMapping("/remove")
    @ResponseStatus(value = HttpStatus.OK)
    public void removeBuddy(@RequestParam(value = "id") int id){
        AddressBook addressBook = addressRepo.findById(4);
        BuddyInfo buddy = buddyRepo.findById(id);
        Integer index = buddy.getId();
        addressBook.removeBuddy(index);
        addressRepo.save(addressBook);
    }

    @GetMapping("/display")
    @ResponseStatus(value = HttpStatus.OK)
    public String displayBuddies(Model model){
        AddressBook addressBook = addressRepo.findById(4);
        model.addAttribute("addressBook", addressBook);
        return "addressBook";
    }


}
