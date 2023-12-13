package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.ModelMenu;
import view.ViewCustomer;
import view.ViewCustomerMenu;
import view.ViewCustomerOrderQuantity;

public class ControllerCustomerMenu {
	private static ViewCustomerMenu vcm;
	
	private static ObservableList<ModelMenu> menus = FXCollections.observableArrayList();
	
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
		vcm.getAddBtn().setOnAction(e -> handleCart());
	}
	
	void handleBack() {
		Stage stage 			= new Stage();
		ViewCustomer vc			= new ViewCustomer(stage);
		ControllerCustomer cc 	= new ControllerCustomer(vc);
		
		vcm.getScene().getWindow().hide();
		stage.show();
	}
	
	public static void handleCart() {
	    ModelMenu selectedMenu = vcm.getTable().getSelectionModel().getSelectedItem();
	    Stage stage = new Stage();
        ViewCustomerOrderQuantity vcoq = new ViewCustomerOrderQuantity(stage);
        ControllerCustomerOrderQuantity ccoq = new ControllerCustomerOrderQuantity(vcoq, menus, selectedMenu);

        vcm.getScene().getWindow();
        stage.show();
	}
}
