package test.java.com.atech;

import main.java.com.atech.controller.ServiceController;
import main.java.com.atech.model.Service;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;

public class ServiceControllerTest {
    ServiceController serviceController = new ServiceController();
    @Test
    public void testSaveService() {
        Service service = new Service(1,2,"Screen repacement test",
                "In Progress", LocalDateTime.now(), LocalDateTime.now().plusDays(2), 150.0);
        serviceController.saveService(service);

        assertTrue(service.getId() > 0);
    }
}
