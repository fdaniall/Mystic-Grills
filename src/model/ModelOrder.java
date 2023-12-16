package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ModelOrder {
	private static String orderId;
	private String menuItemName;
	private int quantity;

	private static ArrayList<String> cartArray = new ArrayList<>();

	public ModelOrder(String orderId, String menuItemName, int quantity) {
		super();
		this.orderId 		= orderId;
		this.menuItemName 	= menuItemName;
		this.quantity 		= quantity;
	}

	public static void getOrder(ArrayList<ModelOrder> orderList) {
		System.out.println("===== BATAS AWAL getOrder =====");
		
		for (ModelOrder order : orderList) {
		    System.out.println("Menu Name: " + order.getMenuItemName());
		    System.out.println("Quantity : " + order.getQuantity());
		    System.out.println("---");
		}
	}

	public static void cartTemp(String menuItemName, int quantity) {
		String orderInfo = "Menu Item: " + menuItemName + ", Quantity: " + quantity;
		cartArray.add(orderInfo);
		System.out.println(cartArray);
		showAlert("Order successfully added to cart!");
	}

	public static void saveToCart(int orderId, String menuItemName, int quantity) {
		String query = String.format("INSERT INTO orderitem (orderId, menuItemName, quantity) VALUES (NULL, '%s', %d)", menuItemName, quantity);
		Connect.getConnection().executeUpdate(query);
		showAlert("Checkout Succesful!");

		cartArray.add(menuItemName);
		System.out.println(menuItemName);
	}

	private static void showAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

	public static ArrayList<String> getCartArray() {
		return cartArray;
	}

	public static void setCartArray(ArrayList<String> cartArray) {
		ModelOrder.cartArray = cartArray;
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
