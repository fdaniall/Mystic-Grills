package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.ModelMenu;

public class ViewAdminMenuManagement {
	private Scene scene;
	private TableView<ModelMenu> table;
	
	private TextField nameTF 	= new TextField();
	private TextField descTF 	= new TextField();
	private TextField priceTF 	= new TextField();
	
	private Button addBtn 		= new Button("Add");
	private Button updateBtn 	= new Button("Update");
	private Button deleteBtn 	= new Button("Delete");
	private Button backBtn		= new Button("Back to Menu");
	
	public ViewAdminMenuManagement(Stage stage) {
		VBox root = new VBox();
		
		table = createMenuTable();
		
		GridPane form = createMenuForm(table);
		VBox.setMargin(form, new Insets(20));
		root.getChildren().addAll(table, form);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		scene = new Scene(root, 800, 600);
		stage.setScene(scene);
		stage.setTitle("Mystic Grills - Menu Management");
		stage.setResizable(false);
		stage.show();
	}
	
	private TableView<ModelMenu> createMenuTable(){
		TableView<ModelMenu> table = new TableView<>();

		TableColumn<ModelMenu, String> nameColumn = new TableColumn<>("Menu Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("menuItemName"));

		TableColumn<ModelMenu, String> descColumn = new TableColumn<>("Menu Description");
		descColumn.setCellValueFactory(new PropertyValueFactory<>("menuItemDescription"));

		TableColumn<ModelMenu, Number> priceColumn = new TableColumn<>("Menu Price");
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("menuItemPrice"));
		
		table.getColumns().add(nameColumn);
		table.getColumns().add(descColumn);
		table.getColumns().add(priceColumn);
		
		return table;
	}
	
	private GridPane createMenuForm(TableView<ModelMenu> table) {
		GridPane form = new GridPane();
		form.setVgap(20);
		form.setHgap(10);
		
		form.add(new Label("Name:"), 0, 0);
		form.add(nameTF, 1, 0);
		form.add(new Label("Description:"), 0, 1);
		form.add(descTF, 1, 1);
		form.add(new Label("Price:"), 0, 2);
		form.add(priceTF, 1, 2);
		form.add(addBtn, 0, 3);
		form.add(updateBtn, 1, 3);
		form.add(deleteBtn, 2, 3);
		form.add(backBtn, 3, 3);
		
		addBtn.setFont(new Font("Arial", 15));
		updateBtn.setFont(new Font("Arial", 15));
		deleteBtn.setFont(new Font("Arial", 15));
		backBtn.setFont(new Font("Arial", 15));
		
		return form;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Button getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(Button backBtn) {
		this.backBtn = backBtn;
	}

	public TableView<ModelMenu> getTable() {
		return table;
	}

	public void setTable(TableView<ModelMenu> table) {
		this.table = table;
	}

	public TextField getNameTF() {
		return nameTF;
	}

	public void setNameTF(TextField nameTF) {
		this.nameTF = nameTF;
	}

	public TextField getDescTF() {
		return descTF;
	}

	public void setDescTF(TextField descTF) {
		this.descTF = descTF;
	}

	public TextField getPriceTF() {
		return priceTF;
	}

	public void setPriceTF(TextField priceTF) {
		this.priceTF = priceTF;
	}

	public Button getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(Button addBtn) {
		this.addBtn = addBtn;
	}

	public Button getUpdateBtn() {
		return updateBtn;
	}

	public void setUpdateBtn(Button updateBtn) {
		this.updateBtn = updateBtn;
	}

	public Button getDeleteBtn() {
		return deleteBtn;
	}

	public void setDeleteBtn(Button deleteBtn) {
		this.deleteBtn = deleteBtn;
	}
}