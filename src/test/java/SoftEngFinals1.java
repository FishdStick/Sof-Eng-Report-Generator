/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import java.sql.*;
/**
 *
 * @author river
 */
public class SoftEngFinals1 {
    
    public static void main(String[] args) {
            // TODO code application logic here

        String dbURL = "jdbc:mysql://localhost:3306/dbtesting";
        String username = "root";
        String password = "password";  //Change the password whatever ur pw is in ur mysql pw 

        try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

        insert(dbURL, username, password);
        select(dbURL, username, password);
        delete(dbURL, username, password);



        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        }

        public static void insert(String dbURL, String username, String password){

            try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

                String sql = "INSERT INTO tbusers (amount, accountType, description, data) VALUES (?, ?, ?, ?)";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, "100");
                statement.setString(2, "employee");
                statement.setString(3, "panglaro");
                statement.setString(4, "2023-04-14");

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                 System.out.println("A new user was inserted successfully!");
                }

        } catch (SQLException ex) {
        ex.printStackTrace();
        }

        }

        public static void select(String dbURL, String username, String password){
            try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

            String sql = "SELECT * FROM tbusers";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()){
                String accountType = result.getString(2);
                String description = result.getString(3);
                String amount = result.getString("amount");
                String date = result.getString("data");

                String output = "ID #%d: %s - %s - %s - %s"; 
                System.out.println(String.format(output, ++count, accountType, description, amount, date));
            }

            } catch (SQLException ex) {
              ex.printStackTrace();
            }   
        }

        public static void delete(String dbURL, String username, String password){
            try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

                String sql = "DELETE FROM tbusers WHERE amount=?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, "100");

                int rowsDeleted = statement.executeUpdate();
                if (rowsDeleted > 0) {
                    System.out.println("A user was deleted successfully!");
                }

            }
            catch (SQLException ex) {
              ex.printStackTrace();
            }   
        }

        /*public static void update(String dbURL, String username, String password){
            try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

                String sql = "UPDATE tbusers SET amount=?, accountType=?, description=? WHERE amount=?";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, "");
                statement.setString(2, "");
                statement.setString(3, "");
                statement.setString(4, "");

                int rowsUpdated = statement.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("An existing user was updated successfully!");
                }

                }
                catch (SQLException ex) {
                ex.printStackTrace();
                }   
            } */

}
