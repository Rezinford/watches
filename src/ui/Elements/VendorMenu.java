package ui.Elements;

import manage.VendorManager;
import models.Country;
import models.Vendor;
import utils.InputData;
import utils.ViewStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VendorMenu extends SelectorWork implements ShowElement<Vendor> {
    VendorManager vendorManager = new VendorManager();
    CountriesMenu countriesMenu = new CountriesMenu();


    @Override
    protected void add() throws IOException {
        System.out.print("Enter new name: ");
        String name = InputData.getInputString();
        countriesMenu.view();
        System.out.print("Select country: ");
        int countryId = InputData.getInputInt();
        ViewStatus.viewExecutionStatus(vendorManager.create(new Vendor(name, new Country(countryId, null))));
    }

    @Override
    protected void update() throws IOException {
        view();
        System.out.println("Enter id");
        int id = InputData.getInputInt();
        System.out.print("Enter new name: ");
        String name = InputData.getInputString();
        countriesMenu.view();
        System.out.print("Select country: ");
        int countryId = InputData.getInputInt();
        ViewStatus.viewExecutionStatus(vendorManager.update(new Vendor(name, new Country(countryId, null))));
        System.out.println();
    }

    @Override
    protected void delete() throws IOException {
        view();
        System.out.println("Enter id:");
        int id = InputData.getInputInt();
        ViewStatus.viewExecutionStatus(vendorManager.delete(id));
        System.out.println();
    }
    @Override
    protected void view() {
        viewTableName();
        System.out.println();
        viewTableHeader();
        System.out.println();
        System.out.print("--------------------------------");
        System.out.println("--------------------------------");
        for (Vendor vendor : new ArrayList<Vendor>(vendorManager.getAll())) {
            viewElement(vendor);
        }
        System.out.print("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println();
    }
    @Override
    public void viewElement(Vendor model) {
        viewLine(model);
        System.out.println();

    }

    public void viewTableHeader(){
        System.out.printf("|%4s  |  %20s |", "id", "Vendor Name");
        countriesMenu.viewTableHeader();
    }

    public void viewLine(Vendor model){
        System.out.printf("|%4d  |  %20s |", model.getId(), model.getName());
        countriesMenu.viewLine(model.getCountry());
    }
    public void viewTableName(){
        System.out.print("----------- Vendors -----------");
        System.out.print("||");
        countriesMenu.viewTableName();
    }
}
