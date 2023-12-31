package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.ModelUser;
import view.ViewAdmin;
import view.ViewAdminUserManagement;

public class ControllerAdminUserManagement {
	private ViewAdminUserManagement vaum;
	
	private ObservableList<ModelUser> users = FXCollections.observableArrayList();
	
	public ControllerAdminUserManagement(ViewAdminUserManagement view, ObservableList<ModelUser> users) {
		this.vaum = view;
		loadMenuData();
		setButtonListener();
		setupTableSelectionListener();
	}
	
	private void setupTableSelectionListener() {
		vaum.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				vaum.getRoleCB().setValue(newSelection.getUserRole());
				vaum.getNameTF().setText(newSelection.getUserName());
				vaum.getEmailTF().setText(newSelection.getUserEmail());
			}
		});
	}
	
	void loadMenuData() {
		users.clear();
		users.addAll(ModelUser.getUsers());
		vaum.getTable().setItems(users);
	}
	
	void handleInsert() {
		String userRole		= vaum.getRoleCB().getValue();
		String userName 	= vaum.getNameTF().getText();
		String userEmail 	= vaum.getEmailTF().getText();
		for (ModelUser user : users) {
			if (userName.equals(user.getUserName())) {
				System.out.println("Name is not unique");
				return;
			}
		}
		ModelUser.insertUser(userRole, userName, userEmail);
		loadMenuData();
	}
	
	void handleDelete() {
		String userName = vaum.getNameTF().getText();
		ModelUser.deleteUser(userName);
		loadMenuData();
	}

	void handleUpdate() {
		String userRole		= vaum.getRoleCB().getValue();
		String userName 	= vaum.getNameTF().getText();
		String userEmail 	= vaum.getEmailTF().getText();
		ModelUser.updateUser(userRole, userName, userEmail);
		loadMenuData();
	}
	
	void handleBack() {
		Stage stage 		= new Stage();
		ViewAdmin va 		= new ViewAdmin(stage);
		ControllerAdmin ca 	= new ControllerAdmin(va);
		
		vaum.getScene().getWindow().hide();
		stage.show();
	}
	
	private void setButtonListener() {
		vaum.getAddBtn().setOnAction(e -> handleInsert());
		vaum.getDeleteBtn().setOnAction(e -> handleDelete());
		vaum.getUpdateBtn().setOnAction(e -> handleUpdate());
		vaum.getBackBtn().setOnAction(e -> handleBack());
	}
}
