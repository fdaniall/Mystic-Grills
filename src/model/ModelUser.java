package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.ControllerCustomerMenu;
import controller.ControllerLogin;
import controller.ControllerRegister;
import database.Connect;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ModelUser {

	private String userId;
	private String userRole;
	private String userName;
	private String userEmail;
	private String userPassword;

	public ModelUser(String userId, String userRole, String userName, String userEmail, String userPassword) {
		super();
		this.userId 		= userId;
		this.userRole 		= userRole;
		this.userName 		= userName;
		this.userEmail 		= userEmail;
		this.userPassword 	= userPassword;
	}

	public static ArrayList<ModelUser> getUsers(){
		ArrayList<ModelUser> users = new ArrayList<>();
		String query = "SELECT * FROM user";
		ResultSet rs = Connect.getConnection().executeQuery(query);
		try {
			while (rs.next()) {
				String userId 		= rs.getString(1);
				String userRole 	= rs.getString(2);
				String userName 	= rs.getString(3);
				String userEmail 	= rs.getString(4);
				String userPassword = rs.getString(5);

				users.add(new ModelUser(userId, userRole, userName, userEmail, userPassword));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public static void insertUser(String userRole, String userName, String userEmail) {

	    String query = "INSERT INTO user (userRole, userName, userEmail) VALUES (?, ?, ?)";
	    try (PreparedStatement ps = Connect.getConnection().prepareStatement(query)) {
	        ps.setString(1, userRole);
	        ps.setString(2, userName);
	        ps.setString(3, userEmail);

	        ps.executeUpdate();
	        showAlert("User inserted successfully.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        showAlert("Failed to insert user.");
	    }
	}

	public static void registUser(String userName, String userEmail, String userPassword, String confirmPassword) {
		if (userName.trim().isEmpty() || userEmail.trim().isEmpty() || userPassword.trim().isEmpty() || confirmPassword.trim().isEmpty()) {
	        showAlert("All fields must be filled in!");
	        return;
	    }
		if (!userPassword.equals(confirmPassword)) {
			showAlert("Password and Confirm Password do not match!");
			return;
		}
		if (userPassword.length() < 6) {
	        showAlert("Password must be at least 6 characters long!");
	        return;
	    }
		String query = String.format("INSERT INTO user (userId, userRole, userName, userEmail, userPassword) VALUES (NULL, 'Customer', '%s', '%s', '%s')", userName, userEmail, userPassword, confirmPassword);
		Connect.getConnection().executeUpdate(query);
		showAlert("Registration Succesful!");
		
		ControllerRegister.handleGoLogin();
		
	}

	public static void loginUser(String userEmail, String userPassword) {
		try {
	        String query 			= "SELECT * FROM user WHERE userEmail = ? AND userPassword = ?";
	        PreparedStatement ps 	= Connect.getConnection().prepareStatement(query);
	        ps.setString(1, userEmail);
	        ps.setString(2, userPassword);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            String userRole = rs.getString("userRole");
	            ControllerLogin.displayUserRole(userRole);
	        } else {
	            showAlert("User Not Found!");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void deleteUser(String userName) {
		String query = "DELETE FROM user WHERE userName = ?";
		PreparedStatement ps = Connect.getConnection().prepareStatement(query);
		try {
			ps.setString(1, userName);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateUser(String userRole, String userName, String userEmail) {
		String query = "UPDATE user SET userRole = ?, userEmail = ? WHERE userName = ?";

		PreparedStatement ps = Connect.getConnection().prepareStatement(query);

		try {
			ps.setString(1, userRole);
	        ps.setString(2, userEmail);
	        ps.setString(3, userName);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void showAlert(String message) {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Information");
	    alert.setHeaderText(null);
	    alert.setContentText(message);
	    alert.showAndWait();
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}