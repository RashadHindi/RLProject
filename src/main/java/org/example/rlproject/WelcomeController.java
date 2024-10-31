package org.example.rlproject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;

public class WelcomeController {

    @FXML
    private Button ForgetPassWord;

    @FXML
    private TextField UsernameField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button SignIn;

    @FXML
    private Button SignUp;

    @FXML
    void ForgetPassWordButton(ActionEvent event) {
        loadPage("ForgetPassword.fxml");

    }

    private void loadPage(String fxmlFile) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
            Stage stage = (Stage) SignIn.getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable to load page: " + e.getMessage());
        }
    }
    @FXML
    void SignInButton(ActionEvent event) {
        /*
        String username = UsernameField.getText();
        String password = PasswordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username or password cannot be empty.");
            return;
        }

        String sql = "SELECT role FROM users WHERE user_name = ? AND password = ?";

        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String userName = rs.getString("user_name");
                String role = rs.getString("role");

                if ("Employee".equalsIgnoreCase(role)) {
                    loadPage("Employee Page.fxml");
                } else if ("Admin".equalsIgnoreCase(role)) {

                    //loadPage("Admin Page.fxml");
                    AdminController adminController = new FXMLLoader(getClass().getResource("Admin Page.fxml")).getController();
                    adminController.setAdminUsername(userName);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid role.");
                }
            } else {
                // Show error if username or password is incorrect
                JOptionPane.showMessageDialog(null, "Invalid username or password.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
            e.printStackTrace();
        }*/
        String username = UsernameField.getText();
        String password = PasswordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username or password cannot be empty.");
            return;
        }

        String sql = "SELECT user_name, role FROM users WHERE user_name = ? AND password = ?";

        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            System.out.println("Executing SQL: " + stmt.toString());

            ResultSet rs = stmt.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ": " + rsmd.getColumnName(i));
            }

            if (rs.next()) {
                String userName = rs.getString("user_name"); // Retrieve user_name
                String role = rs.getString("role");

                if ("Employee".equalsIgnoreCase(role)) {
                    loadPage("Employee Page.fxml");
                } else if ("Admin".equalsIgnoreCase(role)) {
                    // Load Admin Page
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Admin Page.fxml"));
                    Stage stage = (Stage) SignIn.getScene().getWindow();
                    Scene scene = new Scene(loader.load());
                    stage.setScene(scene);

                    AdminController adminController = loader.getController();
                    adminController.setAdminUsername(userName); // Set the username in AdminController
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid role.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to load Admin Page: " + e.getMessage());
        }
    }

    @FXML
    void SignUpButton(ActionEvent event) {
        loadPage("SignUp.fxml");

    }
}



