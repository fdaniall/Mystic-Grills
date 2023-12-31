package view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.ModelUser;

public class ViewAdminUserManagement {
	private Scene scene;
	private TableView<ModelUser> table;

	private ComboBox<String> roleTF = new ComboBox<>();
	
	private TextField nameTF 	= new TextField();
	private TextField emailTF 	= new TextField();

	private Button addBtn 		= new Button("Add");
	private Button updateBtn	= new Button("Update");
	private Button deleteBtn 	= new Button("Delete");
	private Button backBtn		= new Button("Back to Menu");

	public ViewAdminUserManagement(Stage stage) {
		VBox root = new VBox();

		table = createMenuUser();

		GridPane form = createUserForm(table);
		VBox.setMargin(form, new Insets(20));
		root.getChildren().addAll(table, form);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		scene = new Scene(root, 500, 500);
		stage.setScene(scene);
		stage.setTitle("Mystic Grills - User Management");
		stage.setResizable(false);
		stage.show();
	}

	private TableView<ModelUser> createMenuUser(){
		TableView<ModelUser> table = new TableView<>();

		TableColumn<ModelUser, String> roleColumn = new TableColumn<>("User Role");
		roleColumn.setCellValueFactory(new PropertyValueFactory<>("userRole"));

		TableColumn<ModelUser, String> nameColumn = new TableColumn<>("User Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));

		TableColumn<ModelUser, String> emailColumn = new TableColumn<>("User Email");
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("userEmail"));

		table.getColumns().add(roleColumn);
		table.getColumns().add(nameColumn);
		table.getColumns().add(emailColumn);

		return table;
	}

	private GridPane createUserForm(TableView<ModelUser> table) {
		GridPane form = new GridPane();
		form.setVgap(20);
		form.setHgap(10);
		
		roleTF.getItems().addAll("Admin", "Chef", "Waiter", "Cashier", "Customer");
		form.add(new Label("Role:"), 0, 0);
		form.add(roleTF, 1, 0);
		form.add(new Label("Name:"), 0, 1);
		form.add(nameTF, 1, 1);
		form.add(new Label("Email:"), 0, 2);
		form.add(emailTF, 1, 2);
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

	public TableView<ModelUser> getTable() {
		return table;
	}

	public void setTable(TableView<ModelUser> table) {
		this.table = table;
	}

	public ComboBox<String> getRoleCB() {
	    return roleTF;
	}

	public void setRoleCB(ComboBox<String> roleCB) {
	    this.roleTF = roleCB;
	}

	public TextField getNameTF() {
		return nameTF;
	}

	public void setNameTF(TextField nameTF) {
		this.nameTF = nameTF;
	}

	public TextField getEmailTF() {
		return emailTF;
	}

	public void setEmailTF(TextField emailTF) {
		this.emailTF = emailTF;
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

	public Button getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(Button backBtn) {
		this.backBtn = backBtn;
	}
}