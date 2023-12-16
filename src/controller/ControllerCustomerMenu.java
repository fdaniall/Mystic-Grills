package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.ModelMenu;
import model.ModelOrder;
import view.ViewCustomer;
import view.ViewCustomerCart;
import view.ViewCustomerMenu;
import view.ViewCustomerOrderQuantity;

public class ControllerCustomerMenu {
	private static ViewCustomerMenu vcm;
	
	private static ObservableList<ModelMenu> menus 		= FXCollections.observableArrayList();
	private static ObservableList<ModelOrder> orders 	= FXCollections.observableArrayList();
	
	public ControllerCustomerMenu(ViewCustomerMenu view, ObservableList<ModelMenu> menus) {
	    this.vcm 	= view;
	    loadMenuData();
	    setButtonListener();
	}

	void loadMenuData() {
		menus.clear();
		menus.addAll(ModelMenu.getMenu());
		vcm.getTable().setItems(menus);
	}
	
	void setButtonListener() {
		vcm.getBackBtn().setOnAction(e -> handleBack());
		vcm.getViewBtn().setOnAction(e -> handleCart());
	}
	
	void handleBack() {
		Stage stage 			= new Stage();
		ViewCustomer vc			= new ViewCustomer(stage);
		ControllerCustomer cc 	= new ControllerCustomer(vc);
		
		vcm.getScene().getWindow().hide();
		stage.show();
	}			
	
	void handleCart() {
		Stage stage 				= new Stage();
		ViewCustomerCart vcc		= new ViewCustomerCart(stage, null);
		ControllerCustomerCart ccc 	= new ControllerCustomerCart(vcc, null);
		
		vcm.getScene().getWindow().hide();
		stage.show();
	}
	
	public static void handleCart(ModelMenu rowData) {
        vcm.getAddBtn().setOnAction(e -> handleCart(rowData));
        vcm.getScene().getWindow();
        ModelMenu selectedMenu 					= vcm.getTable().getSelectionModel().getSelectedItem();
	    Stage stage 							= new Stage();
        ViewCustomerOrderQuantity vcoq 			= new ViewCustomerOrderQuantity(stage, rowData);
        ControllerCustomerOrderQuantity ccoq 	= new ControllerCustomerOrderQuantity(vcoq, orders, null, null);
        stage.show();
	}
}
