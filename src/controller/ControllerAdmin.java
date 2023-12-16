package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.ModelMenu;
import model.ModelUser;
import view.ViewAdmin;
import view.ViewAdminMenuManagement;
import view.ViewAdminUserManagement;
import view.ViewLogin;

public class ControllerAdmin {
	private ViewAdmin va;
	private ObservableList<ModelUser> users = FXCollections.observableArrayList();
	private ObservableList<ModelMenu> menus = FXCollections.observableArrayList();
	
	public ControllerAdmin(ViewAdmin view) {
		this.va 	= view;
		setButtonListener();
	}
	
	//menu
	void handleMenu() {
		Stage stage = new Stage();
		ViewAdminMenuManagement vamm 		= new ViewAdminMenuManagement(stage);
		ControllerAdminMenuManagement camm 	= new ControllerAdminMenuManagement(vamm, menus);
		
		va.getScene().getWindow().hide();
		stage.show();
	}
	//user
	void handleUser() {
		Stage stage = new Stage();
		ViewAdminUserManagement vaum 		= new ViewAdminUserManagement(stage);
		ControllerAdminUserManagement caum 	= new ControllerAdminUserManagement(vaum, users);
		
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
		va.getUserBtn().setOnAction(e -> handleUser());
		va.getExitBtn().setOnAction(e -> handleExit());
	}
}