package com.atech.view;

import com.atech.controller.CustomerController;
import com.atech.model.Customer;

import java.util.Scanner;

public class CustomerView {
    private CustomerController controller;
    private Scanner scanner;

    public CustomerView(CustomerController controller){
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu(){
        int opcao;
        do{
            System.out.println("\n--- Menu de Clientes ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Buscar Cliente por ID");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){
                case 1:
                    addCustomer();
                    break;
                case 2:
                    showCustomersList();
                    break;
                case 3:
                    searchCustomerById();
                    break;
                case 0:
                    System.out.println("Bye...");
                    break;
                default:
                    System.out.println("Invalid option");
            }

        } while (opcao != 0);
    }

    public void addCustomer(){
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("Phone: ");
        String phone = scanner.nextLine();
        System.out.println("Email: ");
        String email = scanner.nextLine();

        controller.saveCustomer(new Customer(name,phone,email));
        System.out.println("Customer saved successfully");
    }

    private void showCustomersList() {
        System.out.println("\n--- Customers List ---");
        controller.listCustomer();
    }

    private void searchCustomerById(){
        System.out.println("Customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

//        Customer customer = controller.searchCustomerById(id);
//        if(customer != null){
//            System.out.println("Customer found: " + customer.getName());
//        }else{
//            System.out.println("Customer not found!");
//        }
    }
}


