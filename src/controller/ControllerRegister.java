package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.ModelUser;
import view.ViewLogin;
import view.ViewRegister;

public class ControllerRegister {
	private static ViewRegister vr;
	private static ObservableList<ModelUser> users = FXCollections.observableArrayList();
	
	public ControllerRegister(ViewRegister view, ObservableList<ModelUser> users) {
		this.vr = view;
		setButtonListener();
	}
	
	private void setButtonListener() {
		vr.getRegistBtn().setOnAction(e -> handleInsert());
		vr.getCancelBtn().setOnAction(e -> handleGoLogin());
	}
	
	private void handleInsert() {
		String username = vr.getUsernameTF().getText();
		String email 	= vr.getEmailTF().getText();
		String password = vr.getPasswordPF().getText();
		String confirm 	= vr.getConfirmPF().getText();
		for (ModelUser user : users) {
			if (username.equals(user.getUserName())) {
				System.out.println("Name is not unique");
				return;
			}
		}
		ModelUser.registUser(username, email, password, confirm);
	}
	
	public static void handleGoLogin() {
		Stage stage 		= new Stage();
		ViewLogin vl 		= new ViewLogin(stage);
		ControllerLogin cl 	= new ControllerLogin(vl, users);
		
		vr.getScene().getWindow().hide();
		stage.show();
	}
}