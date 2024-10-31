package org.example.rlproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpController {
    @FXML
    private RadioButton AdminButton;

    @FXML
    private RadioButton EmployeeButton;

    @FXML
    private Button SignUp;

    @FXML
    private TextField UserId;

    @FXML
    private TextField UserName;

    @FXML
    private TextField Password;

    @FXML
    private TextField ConfirmPassword;

    @FXML
    void SignUpButton(ActionEvent event) {
        String userIdStr = UserId.getText().trim();
        String username = UserName.getText().trim();
        String password = Password.getText().trim();
        String confirmPassword = ConfirmPassword.getText().trim();

        int userId;
        try {
            userId = Integer.parseInt(userIdStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "UserId must be a numeric value.");
            return;
        }


        String role = null;
        if (AdminButton.isSelected()) {
            role = "Admin";
        } else if (EmployeeButton.isSelected()) {
            role = "Employee";
        } else {
            JOptionPane.showMessageDialog(null, "Please select a role.");
            return;
        }

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Passwords do not match.");
            return;
        }

        if (isUserIdUnique(userId)) {
            String sql = "INSERT INTO users (user_id, user_name, password, role) VALUES (?, ?, ?, ?::user_role)";

            try (Connection con = DatabaseConnectionManager.getConnection();
                 PreparedStatement stmt = con.prepareStatement(sql)) {

                stmt.setInt(1, userId);
                stmt.setString(2, username);
                stmt.setString(3, password);
                stmt.setString(4, role);

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "User registered successfully!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "UserId already exists. Please choose another.");
        }
    }

    private boolean isUserIdUnique(int userId) {
        String sql = "SELECT 1 FROM users WHERE user_id = ?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userId); // Set userId as an integer
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                System.out.println("DEBUG: UserId is unique (not found in database).");
                return true;
            } else {
                System.out.println("DEBUG: UserId already exists in the database.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error checking UserId uniqueness: " + e.getMessage());
        }
        return false;
    }
}

