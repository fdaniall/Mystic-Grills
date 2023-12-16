package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.ModelMenu;
import model.ModelUser;
import view.ViewCustomer;
import view.ViewCustomerCart;
import view.ViewCustomerMenu;
import view.ViewLogin;

public class ControllerCustomer {
	private ViewCustomer va;
	private ObservableList<ModelUser> users = FXCollections.observableArrayList();
	private ObservableList<ModelMenu> menus = FXCollections.observableArrayList();

	public ControllerCustomer(ViewCustomer view) {
		this.va 	= view;
		setButtonListener();
	}

	//menu
	void handleMenu() {
		Stage stage = new Stage();
		ViewCustomerMenu vcm 		= new ViewCustomerMenu(stage);
		ControllerCustomerMenu ccm 	= new ControllerCustomerMenu(vcm, menus);

		va.getScene().getWindow().hide();
		stage.show();
	}
	//user
	void handleCart() {
		Stage stage = new Stage();
		ViewCustomerCart vaum 		= new ViewCustomerCart(stage);
		ControllerCustomerCart cl	= new ControllerCustomerCart(vaum, null);

		va.getScene().getWindow().hide();
		stage.show();
	}
	//exit
	void handleExit() {
		Stage stage 		= new Stage();
		ViewLogin vl 		= new ViewLogin(stage);
		ControllerLogin cl 	= new ControllerLogin(vl, users);

		va.getScene().getWindow().hide();
		stage.show();
	}
	
	private void setButtonListener() {
		va.getMenuBtn().setOnAction(e -> handleMenu());
		va.getCartBtn().setOnAction(e -> handleCart());
		va.getExitBtn().setOnAction(e -> handleExit());
	}
}
