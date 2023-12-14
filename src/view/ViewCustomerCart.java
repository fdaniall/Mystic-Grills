package view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.ModelMenu;
import model.ModelOrder;
import model.ModelUser;

public class ViewCustomerCart {

	Scene scene;
	private TableView<ModelOrder> table;
	
	private static ArrayList<String> cartTemp = new ArrayList<>();
	
	private BorderPane borderCont		= new BorderPane();
	private HBox buttonBox 				= new HBox(10);
	private Button checkoutBtn			= new Button("Checkout");
	private Button cancelBtn			= new Button("Cancel");
	
	private TableView<ModelOrder> createMenuOrder(){
		TableView<ModelOrder> table = new TableView<>();

		TableColumn<ModelOrder, String> nameColumn = new TableColumn<>("Menu Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("menuItemName"));

		TableColumn<ModelOrder, Number> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		table.getColumns().add(nameColumn);
		table.getColumns().add(quantityColumn);

		return table;
	}
	
	public ViewCustomerCart(Stage stage) {
		VBox root = new VBox();
		
		table = createMenuOrder();
		buttonBox.getChildren().addAll(checkoutBtn, cancelBtn);
		HBox.setMargin(checkoutBtn, new Insets(50, 50, 50, 50));
		HBox.setMargin(cancelBtn, new Insets(50, 50, 50, 50));
		checkoutBtn.setPrefHeight(100);
		checkoutBtn.setPrefWidth(200);
		cancelBtn.setPrefHeight(100);
		cancelBtn.setPrefWidth(200);
		
		checkoutBtn.setFont(new Font("Arial", 15));
		cancelBtn.setFont(new Font("Arial", 15));
		
		root.getChildren().addAll(table, buttonBox);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		buttonBox.setAlignment(Pos.CENTER);
        
	    scene = new Scene(root, 500, 500);
	        
	    stage.setScene(scene);
	    stage.setTitle("Mystic Grills - Cart");
	    stage.setResizable(false);
	    stage.show();
    }
	
	public TableView<ModelOrder> getTable() {
		return table;
	}

	public void setTable(TableView<ModelOrder> table) {
		this.table = table;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public static ArrayList<String> getCartTemp() {
		return cartTemp;
	}

	public static void setCartTemp(ArrayList<String> cartTemp) {
		ViewCustomerCart.cartTemp = cartTemp;
	}

	public BorderPane getBorderCont() {
		return borderCont;
	}

	public void setBorderCont(BorderPane borderCont) {
		this.borderCont = borderCont;
	}

	public Button getCheckoutBtn() {
		return checkoutBtn;
	}

	public void setCheckoutBtn(Button checkoutBtn) {
		this.checkoutBtn = checkoutBtn;
	}

	public Button getCancelBtn() {
		return cancelBtn;
	}

	public void setCancelBtn(Button cancelBtn) {
		this.cancelBtn = cancelBtn;
	}
}
