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
    private static ArrayList<ModelOrder> orderList = new ArrayList<>();
    private ViewCustomerCart vcc;
    
    public ControllerCustomerOrderQuantity(ViewCustomerOrderQuantity vcoq, ObservableList<ModelOrder> orders,
			 ViewCustomerCart vcc, ArrayList<String> cartTemp) {
		super();
		this.vcoq 	= vcoq;
		this.orders = orders;
		this.vcc 	= vcc; 
		setButtonListener();
	}

	private void handleSave() {
		String orderId 	= "1";
    	String menuName = vcoq.getNameTF().getText();
    	int quantity 	= vcoq.getQuantityTF().getValue();
    	
    	ModelOrder newOrder = new ModelOrder(orderId, menuName, quantity);

        orderList.add(newOrder);

    	System.out.println("Order ID	: " + newOrder.getOrderId());
    	System.out.println("Menu Name	: " + newOrder.getMenuItemName());
    	System.out.println("Quantity	: " + newOrder.getQuantity());
    	
//    	for (ModelOrder order : orderList) {
//    	    System.out.println("Menu Name: " + order.getMenuItemName());
//    	    System.out.println("Quantity : " + order.getQuantity());
//    	    System.out.println("---");
//    	}
    	
//    	ControllerCustomerCart.loadTableData(menuName, quantity);
    	ModelOrder.getOrder(orderList);
//    	ModelOrder.cartTemp(menuName, quantity);
    	vcoq.getScene().getWindow().hide();
    }
    
    private void handleCancel() {
		vcoq.getScene().getWindow().hide();
    }
    
    private void setButtonListener() {
    	vcoq.getSaveBtn().setOnAction(e -> handleSave());
		vcoq.getCancelBtn().setOnAction(e -> handleCancel());
	}
}
