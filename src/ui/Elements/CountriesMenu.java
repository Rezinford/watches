package ui.Elements;

import manage.CountryManager;
import models.Country;
import utils.InputData;
import utils.ViewStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CountriesMenu extends SelectorWork implements ShowElement<Country>{

    private CountryManager countryManager = new CountryManager();


    @Override
    protected void add() throws IOException {
        System.out.println("----------- Countries ------------");
        System.out.print("Enter new name: ");
        String name = InputData.getInputString();
        ViewStatus.viewExecutionStatus(countryManager.create(new Country(name)));
        System.out.println("----------------------------------");
        System.out.println();
    }

    @Override
    protected void update() throws IOException {
        view();
        System.out.print("Enter id: ");
        int id = InputData.getInputInt();
        System.out.print("Enter new name: ");
        String name = InputData.getInputString();
        ViewStatus.viewExecutionStatus(countryManager.update(new Country(id, name)));
        System.out.println();

    }

    @Override
    protected void delete() throws IOException {
        view();
        System.out.println("Enter id");
        int id = InputData.getInputInt();
        ViewStatus.viewExecutionStatus(countryManager.delete(id));
        System.out.println();
    }

    @Override
    protected void view() {
        viewTableName();
        System.out.println();
        viewTableHeader();
        System.out.println();
        System.out.println("----------------------------------");
        new ArrayList<>(countryManager.getAll()).forEach(this::viewElement);
        System.out.println("----------------------------------");
        System.out.println();
    }

    @Override
    public void viewElement(Country model) {
        viewLine(model);
        System.out.println();
    }

    public void viewTableHeader(){
        System.out.printf("|%4s  |  %20s |", "id", "County Name");
    }

    public void viewLine(Country model){
        System.out.printf("|%4d  |  %20s |", model.getId(), model.getName());
    }

    public void viewTableName(){
        System.out.print("----------- Countries ------------");
    }
}
