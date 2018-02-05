/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hxy2017.Conn;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLHelper {

    public static Connection getConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
            										"jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=gbk",
            										"root", "");
			//×¢ÒâURLµÄÃèÊö¡°&amp;¡±
            return conn;
        } catch (SQLException ex) {
        	ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
        	ex.printStackTrace();
        }
        return null;
    }

    public static void closeResult(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
        }
    }

    public static void closePreparedStatement(PreparedStatement ps) {
        try {
        	if(ps != null)
        		ps.close();
        } catch (SQLException e) {
        }
    }

    public static void closeConneciton(Connection conn) {
        try {
        	if(conn != null)
        		conn.close();
        } catch (SQLException e) {
        }
    }
}
