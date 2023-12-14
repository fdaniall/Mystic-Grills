package main;

import controller.ControllerAdmin;
import controller.ControllerAdminUserManagement;
import controller.ControllerCustomer;
import controller.ControllerCustomerCart;
import controller.ControllerCustomerMenu;
import controller.ControllerCustomerOrderQuantity;
import controller.ControllerLogin;
import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewAdmin;
import view.ViewAdminUserManagement;
import view.ViewCustomer;
import view.ViewCustomerCart;
import view.ViewCustomerMenu;
import view.ViewCustomerOrderQuantity;
import view.ViewLogin;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // ViewAdmin va = new ViewAdmin(primaryStage);
        // ControllerAdmin ca = new ControllerAdmin(va);

        // ViewAdminMenuManagement vamm = new ViewAdminMenuManagement(primaryStage);
        // ControllerAdminMenuManagement camm = new ControllerAdminMenuManagement(vamm);

        // ViewAdminUserManagement vaum = new ViewAdminUserManagement(primaryStage);
        // ControllerAdminUserManagement camm = new ControllerAdminUserManagement(vaum);

        // ViewCustomer vc = new ViewCustomer(primaryStage);
        // ControllerCustomer cc = new ControllerCustomer(vc);

        // LOGIN
         ViewLogin vl = new ViewLogin(primaryStage);
         ControllerLogin cl = new ControllerLogin(vl, null);
    	
//    	ViewCustomerCart vcc = new ViewCustomerCart(primaryStage);
//    	ControllerCustomerCart ccc = new ControllerCustomerCart(vcc, null);
    	

        // ViewCustomerMenu dan ControllerCustomer
//        ViewCustomerMenu vcm = new ViewCustomerMenu(primaryStage);
//        ControllerCustomerMenu cc = new ControllerCustomerMenu(vcm);

        // ViewCustomerOrderQuantity dan ControllerCustomerOrderQuantity
//        ViewCustomerOrderQuantity vcoq = new ViewCustomerOrderQuantity(primaryStage);
//        ControllerCustomerOrderQuantity ccoq = new ControllerCustomerOrderQuantity(vcoq, vcm, null);
         
//         ViewCustomer vc = new ViewCustomer(primaryStage);
//         ControllerCustomer cc = new ControllerCustomer(vc);
    }
}
