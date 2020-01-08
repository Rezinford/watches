package ui.Elements;

import manage.CountryManager;
import models.Country;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountriesMenu extends SelectorWork{
    public void show(Scanner scanner) {

    }
    private CountryManager countryManager =new CountryManager();



    @Override
    protected void view() {
        System.out.println("----------- Countries ------------");
//        List<Country> countryList = new ArrayList<>(countryManager.getAll());
        for (Country country : new ArrayList<Country> (countryManager.getAll())) {
            System.out.format("%d - %s", country.getId(), country.getName());
        }
        System.out.println("----------------------------------");
    }

    @Override
    protected void add(Scanner scanner) {
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        Country country = new Country(name);

        if(countryManager.create(country)) {
            System.out.println("Successful added");
        }else {
            System.out.println("Added failed...");
        };
    }

    @Override
    protected void update(Scanner scanner) {
        view();
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        Country country = new Country(id, name);
        if(countryManager.update(country)) {
            System.out.println("Successful update");
        }else {
            System.out.println("Update failed...");
        };
    }

    @Override
    protected void delete(Scanner scanner) {
        view();
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        if(countryManager.delete(id)) {
            System.out.println("Successful delete");
        }else {
            System.out.println("Delete failed...");
        };
    }
}
