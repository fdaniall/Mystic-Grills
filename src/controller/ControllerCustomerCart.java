package controller;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.ModelMenu;
import model.ModelOrder;
import view.ViewCustomerCart;
import view.ViewCustomerMenu;
import view.ViewCustomerOrderQuantity;

public class ControllerCustomerCart {
	private ViewCustomerCart vcc;
	private static ViewCustomerMenu vcm;
	
	private ObservableList<ModelOrder> orders = FXCollections.observableArrayList();
	private ArrayList<String> cartTemp = new ArrayList<>();

	
	
	public ControllerCustomerCart(ViewCustomerCart vcc, ArrayList<String> cartTemp) {
		super();
		this.vcc 		= vcc;
		this.cartTemp 	= cartTemp;
		
		setButtonListener();
	}
	
	void loadTableData() {
		orders.clear();
		orders.addAll(ModelOrder.loadOrder());
		vcc.getTable().setItems(orders);
	}

	void handleSave(){
//		for (String item : vcc.getCart()) {
//            System.out.println("Item in cart: " + item);
//            // Lakukan logika lain sesuai kebutuhan
//        }
		System.out.println("test");
	}

	void handleCancel(){
		Stage stage 				= new Stage();
		ViewCustomerMenu vcm		= new ViewCustomerMenu(stage);
		ControllerCustomerMenu cc	= new ControllerCustomerMenu(vcm, null);
		
		vcc.getScene().getWindow().hide();
		stage.show();
	}
	
	void handleOrder(ModelMenu rowData) {
		vcm.getAddBtn().setOnAction(e -> handleOrder(rowData));
        vcm.getScene().getWindow();
        ModelMenu selectedMenu 					= vcm.getTable().getSelectionModel().getSelectedItem();
	    Stage stage 							= new Stage();
        ViewCustomerOrderQuantity vcoq 			= new ViewCustomerOrderQuantity(stage, rowData);
        ControllerCustomerOrderQuantity ccoq 	= new ControllerCustomerOrderQuantity(vcoq, orders, null, null);
        stage.show();
	}
	
	void setButtonListener() {
		vcc.getCheckoutBtn().setOnAction(e -> handleSave());
		vcc.getCancelBtn().setOnAction(e -> handleCancel());
	}

}
