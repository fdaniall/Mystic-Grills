package controller;

import java.math.BigDecimal;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.ModelMenu;
import view.ViewAdmin;
import view.ViewAdminMenuManagement;

public class ControllerAdminMenuManagement {
	private ViewAdminMenuManagement vamm;
	
	private ObservableList<ModelMenu> menus = FXCollections.observableArrayList();
	
	public ControllerAdminMenuManagement(ViewAdminMenuManagement view, ObservableList<ModelMenu> menus2) {
		this.vamm = view;
		loadMenuData();
		setButtonListener();
		setupTableSelectionListener();
	}
	
	private void setupTableSelectionListener() {
		vamm.getTable().getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				vamm.getNameTF().setText(newSelection.getMenuItemName());
				vamm.getDescTF().setText(newSelection.getMenuItemDescription());
				vamm.getPriceTF().setText(String.valueOf(newSelection.getMenuItemPrice()));
			}
		});
	}
	
	void loadMenuData() {
		menus.clear();
		menus.addAll(ModelMenu.getMenu());
		vamm.getTable().setItems(menus);
	}
	
	void handleInsert() {
		String menuItemName 		= vamm.getNameTF().getText();
		String menuItemDescription 	= vamm.getDescTF().getText();
		BigDecimal menuItemPrice 	= new BigDecimal(vamm.getPriceTF().getText());
		for (ModelMenu menu : menus) {
			if (menuItemName.equals(menu.getMenuItemName())) {
				System.out.println("Name is not unique");
				return;
			}
		}
		ModelMenu.insertMenu(menuItemName, menuItemDescription, menuItemPrice);
		loadMenuData();
	}
	
	void handleDelete() {
		String menuItemName = vamm.getNameTF().getText();
		ModelMenu.deleteMenu(menuItemName);
		loadMenuData();
	}

	void handleUpdate() {
		String menuItemName 		= vamm.getNameTF().getText();
		String menuItemDescription 	= vamm.getDescTF().getText();
		BigDecimal menuItemPrice 	= new BigDecimal(vamm.getPriceTF().getText());
		ModelMenu.updateMenu(menuItemName, menuItemDescription, menuItemPrice);
		loadMenuData();
	}
	
	void handleBack() {
		Stage stage 		= new Stage();
		ViewAdmin va 		= new ViewAdmin(stage);
		ControllerAdmin ca 	= new ControllerAdmin(va);
		
		vamm.getScene().getWindow().hide();
		stage.show();
	}
	
	private void setButtonListener() {
		vamm.getAddBtn().setOnAction(e -> handleInsert());
		vamm.getDeleteBtn().setOnAction(e -> handleDelete());
		vamm.getUpdateBtn().setOnAction(e -> handleUpdate());
		vamm.getBackBtn().setOnAction(e -> handleBack());
	}
}
