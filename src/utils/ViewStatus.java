package utils;

public class ViewStatus {
    public static void viewExecutionStatus(boolean status){
        if(status) {
            System.out.println("Successful delete");
        }else {
            System.out.println("Delete failed...");
        };
    }

}
