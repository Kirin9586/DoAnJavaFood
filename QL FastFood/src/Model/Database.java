package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
private static final String DB_PATH ="DB/Food.db";
private Connection connection;
public Database(){
    final String url = "jdbc:sqlite:"+DB_PATH;
    try {
        connection = DriverManager.getConnection(url);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public Connection getConnection() {
        return connection;
    }
    public void close(){
        if(connection== null);
    }
}
