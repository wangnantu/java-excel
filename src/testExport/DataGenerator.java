package testExport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataGenerator {

	public ResultSet getDataFromDB(){
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@//10.65.200.42:1521/scmdb";
		String username = "dctrade";
		String password = "dctrade";
		
		try{   
		    //加载驱动类   
		    Class.forName(driver) ;   
		    }catch(ClassNotFoundException e){   
		    System.out.println("找不到驱动程序类 ，加载驱动失败！");   
		    e.printStackTrace() ;   
		    }   
		ResultSet rs = null;
		try{   
		    Connection con =    
		             DriverManager.getConnection(url , username , password ) ;   
		    Statement stmt = con.createStatement() ; 
		    String sql = "SELECT assetacc,depcode,clientname FROM dctrade.t_assetacc";
		    rs = stmt.executeQuery(sql);
		     }catch(SQLException se){   
		    System.out.println("数据库连接失败！");   
		    se.printStackTrace() ;   
		     }
		return rs;
	}
}
