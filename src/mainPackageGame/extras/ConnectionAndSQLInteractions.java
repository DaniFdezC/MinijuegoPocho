package mainPackageGame.extras;

import java.sql.*;

public class ConnectionAndSQLInteractions {

    /* public static Connection getConnection(String database, String usernameDatabase, String passwordUsernameDatabase){
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database+"?useSSL=false",usernameDatabase,passwordUsernameDatabase);

        }  catch (Exception e1){
            System.out.println(e1.getMessage());
        }

        return con;
    }

     */

    public static ResultSet getResultSetFromStatement(String sql, Connection connection){
        ResultSet rs = null;
        try {
            Statement stm = connection.createStatement();
            rs = stm.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }

    public static void insertUsersStatement(String sql, Connection connection){
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.execute();
        } catch (Exception e) {
            System.err.println("EXCEPTION insert "+e.getMessage());
        }
    }


}
