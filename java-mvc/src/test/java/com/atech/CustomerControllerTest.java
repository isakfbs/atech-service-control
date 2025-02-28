package test.java.com.atech;

import main.java.com.atech.controller.CustomerController;
import main.java.com.atech.model.Customer;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CustomerControllerTest {
    private CustomerController customerController = new CustomerController();

    @Test
    public void testSaveCustomer(){
        Customer customer = new Customer("Isak Silva", "111998153","isak@teste.com");

        customerController.saveCustomer(customer);

        assertTrue(customer.getId() > 0);
    }
}
