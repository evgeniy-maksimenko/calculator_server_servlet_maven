package components;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import model.Person;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionMySql {
    private static ConnectionMySql instance;
    private Statement st;

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    private ConnectionMySql(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ma", "root", "");
            setSt((Statement) conn.createStatement());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionMySql getInstance(){
        if(instance == null) {
            instance = new ConnectionMySql();
        }
        return  instance;
    }
}
