package org.example.rlproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ForgetPasswordController {
    @FXML
    private Button ChangePassword;

    @FXML
    private TextField ConfirmPassword;

    @FXML
    private TextField Email;

    @FXML
    private TextField Password;

    @FXML
    private TextField UserID;

    @FXML
    void ChangePasswordButton(ActionEvent event) {
        String userIdText = UserID.getText();
        String email = Email.getText();
        String newPassword = Password.getText();
        String confirmPassword = ConfirmPassword.getText();

        if (userIdText.isEmpty() || email.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
            showMessage("Error", "All fields are required.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            showMessage("Error", "Passwords do not match.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int userId;
        try {
            userId = Integer.parseInt(userIdText);
        } catch (NumberFormatException e) {
            showMessage("Error", "User ID must be a valid number.", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String checkUserSql = """
                SELECT u.user_id
                FROM users u
                JOIN employee e ON u.user_id = e.user_id
                WHERE u.user_id = ? AND e.email = ?;
                """;

        String updatePasswordSql = "UPDATE users SET password = ? WHERE user_id = ?";

        try (Connection conn = DatabaseConnectionManager.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkUserSql)) {

            checkStmt.setInt(1, userId);
            checkStmt.setString(2, email);

            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                try (PreparedStatement updateStmt = conn.prepareStatement(updatePasswordSql)) {
                    updateStmt.setString(1, newPassword);
                    updateStmt.setInt(2, userId);
                    updateStmt.executeUpdate();

                    showMessage("Success", "Password changed successfully.", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                showMessage("Error", "User ID and email do not match.", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            showMessage("Database Error", "Error updating password: " + e.getMessage(), JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void showMessage(String title, String message, int messageType) {
        JOptionPane.showMessageDialog(null, message, title, messageType);
    }
}

