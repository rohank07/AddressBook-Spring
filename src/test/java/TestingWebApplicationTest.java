import accessingdatajpa.AccessingDataJpaApplication;
import accessingdatajpa.DefaultController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import accessingdatajpa.AddressBookRepository;
import accessingdatajpa.BuddyRepository;


@SpringBootTest(classes = AccessingDataJpaApplication.class)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class TestingWebApplicationTest {


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BuddyRepository buddyRepository;
    @Autowired
    private AddressBookRepository addressBookRepository;


    @Test
    public void createAddressBook() throws Exception{

        String url = "/addBook";
        this.mockMvc.perform(post(url)).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
        Assert.assertNotEquals(this.addressBookRepository.count(), 0);
    }

    @Test
    public void createBuddy() throws Exception{
        String url = "/add?name=Bob&number=34234";

        mockMvc.perform(post(url))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assert.assertNotNull (this.buddyRepository.findByName("Bob"));
    }


}
