package ui.Elements;

import manage.WatchManager;
import models.Vendor;
import models.watch.Watch;
import utils.InputData;
import utils.ViewStatus;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import static models.watch.WatchType.ANALOG;

public class WatchesMenu extends SelectorWork implements ShowElement<Watch> {
    WatchManager watchManager = new WatchManager();
    VendorMenu vendorMenu = new VendorMenu();

    @Override
    protected void view() {
        System.out.println("----------- Watches ------------");
        for (Watch watch : new ArrayList<Watch>(watchManager.getAll())) {
            viewElement(watch);
        }
        System.out.println("----------------------------------");
        System.out.println();
    }

    @Override
    protected void add() throws IOException {
        System.out.print("Enter new type: ");
        String type = InputData.getInputString();
        System.out.println("Enter Price");
        BigDecimal price = BigDecimal.valueOf(Long.parseLong(InputData.getInputString()));
        System.out.println("Enter Quantity");
        int qty = InputData.getInputInt();
        vendorMenu.view();
        System.out.print("Select vendor: ");
        int vendorId = InputData.getInputInt();
        ViewStatus.viewExecutionStatus(watchManager.create(new Watch(ANALOG,price,qty,new Vendor(vendorId,null, null))));


    }

    @Override
    protected void update() throws IOException {
        view();
        System.out.println("Enter id");
        int id = InputData.getInputInt();
        System.out.print("Enter new type:");
        String type = InputData.getInputString();
        System.out.println("Enter Price");
        BigDecimal price = BigDecimal.valueOf(Long.parseLong(InputData.getInputString()));
        System.out.println("Enter Quantity");
        int qty = InputData.getInputInt();
        vendorMenu.view();
        System.out.print("Select vendor: ");
        int vendorId = InputData.getInputInt();
        ViewStatus.viewExecutionStatus(watchManager.update(new Watch(id,ANALOG,price,qty,new Vendor(vendorId,null, null))));

    }

    @Override
    protected void delete() throws IOException {
        view();
        System.out.println("Enter id:");
        int id = InputData.getInputInt();
        ViewStatus.viewExecutionStatus(watchManager.delete(id));
        System.out.println();
    }

    @Override
    public void viewElement(Watch model) {
        System.out.format("%d - %s - d% - d%", model.getId(), model.getType(), model.getPrice(), model.getQuantity());
        vendorMenu.viewElement(model.getVendor());
    }

    @Override
    public void viewTableHeader() {

    }

    @Override
    public void viewLine(Watch model) {

    }

    @Override
    public void viewTableName() {

    }
}
