package controller;

import javafx.collections.ObservableList;
import javafx.stage.Stage;
import model.ModelMenu;
import model.ModelUser;
import view.ViewCustomerMenu;
import view.ViewCustomerOrderQuantity;
import view.ViewRegister;

public class ControllerCustomerOrderQuantity {
    private ViewCustomerOrderQuantity vcoq;
    private ObservableList<ModelMenu> menus;
    private ModelMenu selectedMenu;

    public ControllerCustomerOrderQuantity(ViewCustomerOrderQuantity vcoq, ObservableList<ModelMenu> menus, ModelMenu selectedMenu2) {
    	this.vcoq = vcoq;
        this.menus = menus;
        this.selectedMenu = selectedMenu;
        
        setButtonListener();
    }
    
    private void handleCancel() {
    	Stage stage 			= new Stage();
		ViewCustomerMenu vcm 		= new ViewCustomerMenu(stage);
		ControllerCustomerMenu cr 	= new ControllerCustomerMenu(vcm, menus);

		vcoq.getScene().getWindow().hide();
    }
    
    private void setButtonListener() {
		vcoq.getCancelBtn().setOnAction(e -> handleCancel());
	}
}
