package ui.Elements;

import manage.CustomerManager;
import models.Country;
import models.Customer;
import utils.ViewStatus;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomersMenu extends SelectorWork implements ShowElement<Customer> {
    CustomerManager customerManager = new CustomerManager();


    @Override
    protected void view() {
        System.out.println("----------- Countries ------------");
        new ArrayList<>(customerManager.getAll()).forEach(this::viewElement);
        System.out.println("----------------------------------");
        System.out.println();
    }

    @Override
    protected void add(Scanner scanner) {
        System.out.println("----------- Customers ------------");
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        ViewStatus.viewExecutionStatus(customerManager.create(new Customer(name)));
        System.out.println("----------------------------------");
        System.out.println();

    }

    @Override
    protected void update(Scanner scanner) {
        System.out.println("----------- Customers ------------");
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        ViewStatus.viewExecutionStatus(customerManager.update(new Customer(id, name)));
        System.out.println("----------------------------------");
        System.out.println();
    }

    @Override
    protected void delete(Scanner scanner) {
        view();
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        ViewStatus.viewExecutionStatus(customerManager.delete(id));
        System.out.println();
    }


    @Override
    public void viewElement(Customer model) {
        System.out.format("%d - %s", model.getId(), model.getName());
    }
}
