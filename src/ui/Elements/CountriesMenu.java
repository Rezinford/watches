package ui.Elements;

import manage.CountryManager;
import models.Country;
import utils.ViewStatus;

import java.util.ArrayList;
import java.util.Scanner;

public class CountriesMenu extends SelectorWork implements ShowElement<Country>{

    private CountryManager countryManager =new CountryManager();


    @Override
    protected void add(Scanner scanner) {
        System.out.println("----------- Countries ------------");
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        ViewStatus.viewExecutionStatus(countryManager.create(new Country(name)));
        System.out.println("----------------------------------");
        System.out.println();
    }

    @Override
    protected void update(Scanner scanner) {
        view();
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        ViewStatus.viewExecutionStatus(countryManager.update(new Country(id, name)));
        System.out.println();

    }

    @Override
    protected void delete(Scanner scanner) {
        view();
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        ViewStatus.viewExecutionStatus(countryManager.delete(id));
        System.out.println();
    }

    @Override
    protected void view() {
        System.out.println("----------- Countries ------------");
        new ArrayList<>(countryManager.getAll()).forEach(this::viewElement);
        System.out.println("----------------------------------");
        System.out.println();
    }
    @Override
    public void viewElement(Country model) {
        System.out.format("%d - %s", model.getId(), model.getName());
    }

}
