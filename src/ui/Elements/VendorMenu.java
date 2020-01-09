package ui.Elements;

import manage.VendorManager;
import models.Country;
import models.Vendor;
import utils.ViewStatus;

import java.util.ArrayList;
import java.util.Scanner;

public class VendorMenu extends SelectorWork implements ShowElement<Vendor> {
    VendorManager vendorManager = new VendorManager();
    CountriesMenu countriesMenu = new CountriesMenu();
    @Override
    protected void view() {
        System.out.println("----------- Vendors ------------");
        for (Vendor vendor : new ArrayList<Vendor>(vendorManager.getAll())) {
            viewElement(vendor);
        }
        System.out.println("----------------------------------");
        System.out.println();
    }

    @Override
    protected void add(Scanner scanner) {
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        countriesMenu.view();
        System.out.print("Select country: ");
        int countryId = Integer.parseInt(scanner.nextLine());
        ViewStatus.viewExecutionStatus(vendorManager.create(new Vendor(name, new Country(countryId, null))));
    }

    @Override
    protected void update(Scanner scanner) {
        view();
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        countriesMenu.view();
        System.out.print("Select country: ");
        int countryId = Integer.parseInt(scanner.nextLine());
        ViewStatus.viewExecutionStatus(vendorManager.update(new Vendor(name, new Country(countryId, null))));
        System.out.println();
    }

    @Override
    protected void delete(Scanner scanner) {
        view();
        System.out.println("Enter id:");
        int id = Integer.parseInt(scanner.nextLine());
        ViewStatus.viewExecutionStatus(vendorManager.delete(id));
        System.out.println();
    }

    @Override
    public void viewElement(Vendor model) {
        System.out.format("%d - %s", model.getId(), model.getName());
        countriesMenu.viewElement(model.getCountry());
    }
}
