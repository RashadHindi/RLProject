package org.example.rlproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Welcome.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 665, 419);
        stage.setTitle("Car Parts Store!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        launch();
        /*
        String sql = "SELECT first_name FROM employee";
        try (Connection con = DatabaseConnectionManager.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                String name = rs.getString("first_name");
                System.out.println("Employee Name: " + name);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        /*
        String sql = "select first_name from  employee";
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "rashadlina";
        String password = "1912";

        try {
            Connection con = DriverManager.getConnection(url,username,password);
            con.setAutoCommit(false); // to connect automatically
            Statement stmt = con.createStatement();
            ResultSet rs =  stmt.executeQuery(sql) ;
            rs.next();
            String name = rs.getString(1);
            System.out.println(name);
            con.commit();/**/
           // con.close();/**/
        /*
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.toString());
        }*/


        /*
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        String name = rs.getString(1);
        System.out.println(name);
        */
    }
}