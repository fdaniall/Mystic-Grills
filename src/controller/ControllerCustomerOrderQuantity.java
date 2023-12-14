package controller;

import java.util.ArrayList;
import java.util.Collection;

import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.ModelMenu;
import model.ModelOrder;
import model.ModelUser;
import view.ViewCustomerCart;
import view.ViewCustomerMenu;
import view.ViewCustomerOrderQuantity;
import view.ViewRegister;

public class ControllerCustomerOrderQuantity {
	private ViewCustomerOrderQuantity vcoq;
    private ObservableList<ModelOrder> orders;
    private ViewCustomerCart vcc;
    
    public ControllerCustomerOrderQuantity(ViewCustomerOrderQuantity vcoq, ObservableList<ModelOrder> orders,
			 ViewCustomerCart vcc, ArrayList<String> cartTemp) {
		super();
		this.vcoq = vcoq;
		this.orders = orders;
		this.vcc = vcc;
		setButtonListener();
	}

	private void handleSave() {
		int orderId = 1;
    	String menuName = vcoq.getNameTF().getText();
    	int quantity 	= vcoq.getQuantityTF().getValue();
    	
    	ModelOrder newOrder = new ModelOrder(orderId, menuName, quantity);

    	System.out.println("Order ID: " + newOrder.getOrderId());
    	System.out.println("Menu Name: " + newOrder.getMenuItemName());
    	System.out.println("Quantity: " + newOrder.getQuantity());
    	
    	
    	ModelOrder.cartTemp(menuName, quantity);

    }
    
    private void handleCancel() {
		vcoq.getScene().getWindow().hide();
    }
    
    private void setButtonListener() {
    	vcoq.getSaveBtn().setOnAction(e -> handleSave());
		vcoq.getCancelBtn().setOnAction(e -> handleCancel());
	}
}
