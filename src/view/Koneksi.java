package view;

 
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
 
public class Koneksi {
  private static Connection koneksi;
  
  public static Connection getKoneksi() {
    if (koneksi == null)
      try {
    	//String url = "jdbc:mysql:http://localhost:3306/rizky";
    	//jdbc:oracle:thin:@//192.168.1.105:1521/MYORA"
    	//String url = "jdbc:mysql://192.168.1.40/rizky";
    	//dataSource.setUrl("jdbc:mysql://192.168.1.40:3306/rizky");

        String url = "jdbc:mysql://localhost:3306/rizky";
        String username = "root";
        String password = "";
        DriverManager.registerDriver((Driver)new Driver());
        koneksi = DriverManager.getConnection(url, username, password);
      } catch (Exception ex) {
        System.out.println(ex);
      }  
    return koneksi;
  }
}
