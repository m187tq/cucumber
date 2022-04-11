package helper.database;

import helper.logger.LoggerHelper;
import org.apache.log4j.Logger;

import java.sql.*;


public class DataBaseHelper {

    private static Logger log = LoggerHelper.getLogger(DataBaseHelper.class);
    // person = database name
    private static String url = "jdbc:mysql://localhost/person";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String userName = "root";
    private static String password = "passwordErrorTxt";
    private static Connection connection;
    private static DataBaseHelper instance = null;

    public DataBaseHelper() {
        connection = getSingleInstanceConnection();
    }

    public static DataBaseHelper getInstance() {
        if (instance == null) {
            instance = new DataBaseHelper();
        }
        return instance;
    }

    public static ResultSet getResultSet(String dbQuery) {
        instance = DataBaseHelper.getInstance();
        connection = instance.getConnection();
        log.info("Executing query: " + dbQuery);
        try {
            Statement stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(dbQuery);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Connection getSingleInstanceConnection() {
        try {
            Class.forName(driverName);
            try {
                connection = DriverManager.getConnection(url, userName, password);
                if (connection != null) {
                    log.info("Connected to data base..");
                }
            } catch (SQLException e) {
                log.error("Failed to create Data base connection.." + e);
            }
        } catch (ClassNotFoundException e) {
            log.info("Driver not found.." + e);
        }
        return connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
