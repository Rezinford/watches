package utils;

public class ViewStatus {
    public static void viewExecutionStatus(boolean status){
        if(status) {
            System.out.println("Operation successful");
        }else {
            System.out.println("Delete failed...");
        };
    }

}
