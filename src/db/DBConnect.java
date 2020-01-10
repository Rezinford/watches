package db;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnect {
    private static Connection connection;

    public static Connection getConnection() {
       if(connection==null){
           try {
               connection = getConnectionWithParam();
               System.out.println("Connection to Store DB succesfull!");
           } catch (IOException ex) {
               System.out.println("Setting Connection failed...");
//            System.out.println(ex);
           } catch (SQLException ex) {
               System.out.println("Connection failed...");
//            System.out.println(ex);
           }
       }
        return connection;
    }

    public static Connection getConnectionWithParam() throws SQLException, IOException {

        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("C:\\Java\\TrackEnsure\\watches\\src\\resources\\application.properties"))) {

            props.load(in);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
    public static void Disonnect(){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
        }
    }
}
