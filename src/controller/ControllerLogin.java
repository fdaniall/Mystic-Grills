package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.ModelUser;
import view.ViewAdmin;
import view.ViewCustomer;
import view.ViewCustomerMenu;
import view.ViewLogin;
import view.ViewRegister;

public class ControllerLogin {
	private static ViewLogin vl;
	private ObservableList<ModelUser> users = FXCollections.observableArrayList();

	public ControllerLogin(ViewLogin view, ObservableList<ModelUser> users) {
		this.vl = view;
		setButtonListener();
	}

	private void setButtonListener() {
		vl.getLoginBtn().setOnAction(e -> handleLogin());
		vl.getRegistBtn().setOnAction(e -> handleSwitch());
	}

	private void handleLogin() {
		String email 	= vl.getEmailTF().getText();
		String password = vl.getPasswordPF().getText();

		ModelUser.loginUser(email, password);
	}

	private void handleSwitch() {
		Stage stage 			= new Stage();
		ViewRegister vr 		= new ViewRegister(stage);
		ControllerRegister cr 	= new ControllerRegister(vr, users);

		vl.getScene().getWindow().hide();
	}

	private static void handleGoAdmin() {
		Stage stage 		= new Stage();
		ViewAdmin va 		= new ViewAdmin(stage);
		ControllerAdmin ca 	= new ControllerAdmin(va);

		vl.getScene().getWindow().hide();
		stage.show();
	}

	private static void handleGoCustomer() {
		Stage stage 			= new Stage();
		ViewCustomer vc			= new ViewCustomer(stage);
		ControllerCustomer cc 	= new ControllerCustomer(vc);

		vl.getScene().getWindow().hide();
		stage.show();
	}

	public static void displayUserRole(String userRole) {
		switch (userRole) {
		case "Admin":
			handleGoAdmin();
			break;
		case "Chef":
			//	        	showAlert("Ini Page Chef");
			break;
		case "Waiter":
			//	        	showAlert("Ini Page Waiter");
			break;
		case "Cashier":
			//	        	showAlert("Ini Page Cashier");
			break;
		case "Customer":
			handleGoCustomer();
			break;
		default:
			//	        	showAlert("Invalid User Role");
			break;
		}
	}
}