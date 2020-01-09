package ui.Elements;

import manage.WatchManager;
import models.Vendor;
import models.watch.Watch;
import utils.ViewStatus;

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
    protected void add(Scanner scanner) {
        System.out.print("Enter new type: ");
        String type = scanner.nextLine();
        System.out.println("Enter Price");
        BigDecimal price = BigDecimal.valueOf(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter Quantity");
        int qty = Integer.parseInt(scanner.nextLine());
        vendorMenu.view();
        System.out.print("Select vendor: ");
        int vendorId = Integer.parseInt(scanner.nextLine());
        ViewStatus.viewExecutionStatus(watchManager.create(new Watch(ANALOG,price,qty,new Vendor(vendorId,null, null))));


    }

    @Override
    protected void update(Scanner scanner) {
        view();
        System.out.println("Enter id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new type:");
        String type = scanner.nextLine();
        System.out.println("Enter Price");
        BigDecimal price = BigDecimal.valueOf(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter Quantity");
        int qty = Integer.parseInt(scanner.nextLine());
        vendorMenu.view();
        System.out.print("Select vendor: ");
        int vendorId = Integer.parseInt(scanner.nextLine());
        ViewStatus.viewExecutionStatus(watchManager.update(new Watch(id,ANALOG,price,qty,new Vendor(vendorId,null, null))));

    }

    @Override
    protected void delete(Scanner scanner) {
        view();
        System.out.println("Enter id:");
        int id = Integer.parseInt(scanner.nextLine());
        ViewStatus.viewExecutionStatus(watchManager.delete(id));
        System.out.println();
    }

    @Override
    public void viewElement(Watch model) {
        System.out.format("%d - %s - d% - d%", model.getId(), model.getType(), model.getPrice(), model.getQuantity());
        vendorMenu.viewElement(model.getVendor());
    }
}
