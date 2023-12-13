package model;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ModelMenu {
	private String menuItemId;
	private String menuItemName;
	private String menuItemDescription;
	private BigDecimal menuItemPrice;
	
	public ModelMenu(String menuItemId, String menuItemName, String menuItemDescription, BigDecimal menuItemPrice) {
		super();
		this.menuItemId 			= menuItemId;
		this.menuItemName 			= menuItemName;
		this.menuItemDescription 	= menuItemDescription;
		this.menuItemPrice 			= menuItemPrice;
	}
	
	public static ArrayList<ModelMenu> getMenu(){
		ArrayList<ModelMenu> menus = new ArrayList<>();
		String query = "SELECT * FROM menuitem";
		ResultSet rs = Connect.getConnection().executeQuery(query);
		try {
			while (rs.next()) {
				String id			= rs.getString(1);
				String name 		= rs.getString(2);
				String description 	= rs.getString(3);
				BigDecimal price	= rs.getBigDecimal(4);

				menus.add(new ModelMenu(id, name, description, price));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menus;
	}
	
	public static void insertMenu(String menuItemName, String menuItemDescription, BigDecimal menuItemPrice) {

		if (menuItemName.trim().isEmpty() || menuItemDescription.trim().isEmpty() || menuItemPrice.compareTo(BigDecimal.ZERO) <= 0) {
	        showAlert("All fields must be filled in!");
	        return;
	    }
	    if (menuItemName.isEmpty()) {
	    	showAlert("Menu Item Name cannot be empty.");
	        return;
	    }
	    
	    if (menuItemDescription.length() <= 10) {
	    	showAlert("Menu Item Description must be more than 10 characters.");
	        return;
	    }

	    if (menuItemPrice.compareTo(new BigDecimal("2.5")) < 0) {
	    	showAlert("Menu Item Price must be greater than or equal to 2.5");
	        return;
	    }

	    String query = "INSERT INTO menuitem (menuItemName, MenuItemDescription, menuItemPrice) VALUES (?, ?, ?)";
	    try (PreparedStatement ps = Connect.getConnection().prepareStatement(query)) {
	        ps.setString(1, menuItemName);
	        ps.setString(2, menuItemDescription);
	        ps.setBigDecimal(3, menuItemPrice);

	        ps.executeUpdate();
	        showAlert("Menu item inserted successfully.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	        showAlert("Failed to insert menu item.");
	    }
	}

	
	public static void deleteMenu(String menuItemName) {
		String query = "DELETE FROM menuitem WHERE menuItemName = ?";
		PreparedStatement ps = Connect.getConnection().prepareStatement(query);
		try {
			ps.setString(1, menuItemName);
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateMenu(String menuItemName, String menuItemDescription, BigDecimal menuItemPrice) {
		String query = "UPDATE menuitem SET menuItemDescription = ?, menuItemPrice = ? WHERE menuItemName = ?";

		PreparedStatement ps = Connect.getConnection().prepareStatement(query);

		try {
			ps.setString(1, menuItemDescription);
	        ps.setBigDecimal(2, menuItemPrice);
	        ps.setString(3, menuItemName);
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

	public String getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(String menuItemId) {
		this.menuItemId = menuItemId;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public String getMenuItemDescription() {
		return menuItemDescription;
	}

	public void setMenuItemDescription(String menuItemDescription) {
		this.menuItemDescription = menuItemDescription;
	}

	public BigDecimal getMenuItemPrice() {
		return menuItemPrice;
	}

	public void setMenuItemPrice(BigDecimal menuItemPrice) {
		this.menuItemPrice = menuItemPrice;
	}
}