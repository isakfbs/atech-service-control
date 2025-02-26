package test.java.com.atech;

import main.java.com.atech.model.Service;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import java.time.LocalDateTime;


public class ServiceTest {

    @Test
    public void testSaveService(){
        Service service = new Service(1,
                "Screen replacement","Pending", LocalDateTime.now(),null,150.00);
        service.saveInDatabase();

        assertTrue("Service should be saved successfully.", true);
    }
}
