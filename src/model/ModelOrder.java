package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ModelOrder {
	private static int orderId;
	private static String menuItemName;
	private int quantity;
	
	private static ArrayList<String> cartTemp = new ArrayList<>();
	
	public ModelOrder(int orderId, String menuItemName, int quantity) {
		super();
		this.orderId		= orderId;
		this.menuItemName 	= menuItemName;
		this.quantity 		= quantity;
	}
	
	public static ArrayList<ModelOrder> loadOrder(){
		ArrayList<ModelOrder> orders = new ArrayList<>();
		String query = "SELECT * FROM order";
		ResultSet rs = Connect.getConnection().executeQuery(query);
		try {
			while (rs.next()) {
				String id 		= rs.getString(1);
				String name 	= rs.getString(2);
				int price 		= rs.getInt(3);
				int quantity 	= rs.getInt(4);

				orders.add(new ModelOrder(orderId, menuItemName, quantity));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return orders;
	}

	public static void cartTemp(String menuItemName, int quantity) {
		showAlert("Checkout Succesful!");
		
		String orderInfo = "Menu Item: " + menuItemName + ", Quantity: " + quantity;
        cartTemp.add(orderInfo);
        System.out.println(cartTemp);
	}
	
	public static void saveToCart(int orderId, String menuItemName, int quantity) {
		String query = String.format("INSERT INTO orderitem (orderId, menuItemName, quantity) VALUES (NULL, '%s', %d)", menuItemName, quantity);
		Connect.getConnection().executeUpdate(query);
		showAlert("Order successfully added to cart!");
		
		cartTemp.add(menuItemName);
		System.out.println(menuItemName);
	}
	
	private static void showAlert(String message) {
	    Alert alert = new Alert(AlertType.INFORMATION);
	    alert.setTitle("Information");
	    alert.setHeaderText(null);
	    alert.setContentText(message);
	    alert.showAndWait();
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
