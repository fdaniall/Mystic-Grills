package view;
 
import controller.ControllerCustomerMenu;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.ModelMenu;

public class ViewCustomerMenu{
	private Scene scene;
	private TableView<ModelMenu> table;

	private Button addBtn 	= new Button();
	private Button viewBtn 	= new Button();
	private Button backBtn 	= new Button();

	private HBox buttonBox 	= new HBox(10);

	public ViewCustomerMenu(Stage primaryStage) {

		VBox root = new VBox();

		viewBtn	= new Button("View Cart");
		backBtn = new Button("Back to Menu");

		table = createMenuTable();
		buttonBox.getChildren().addAll(viewBtn, backBtn);
		HBox.setMargin(viewBtn, new Insets(50, 50, 50, 50));
		HBox.setMargin(backBtn, new Insets(50, 50, 50, 50));
		viewBtn.setPrefHeight(100);
		viewBtn.setPrefWidth(200);
		backBtn.setPrefHeight(100);
		backBtn.setPrefWidth(200);

		viewBtn.setFont(new Font("Arial", 15));
		backBtn.setFont(new Font("Arial", 15));

		root.getChildren().addAll(table, buttonBox);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		buttonBox.setAlignment(Pos.CENTER);

		scene = new Scene(root, 550, 500);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Mystic Grills - Menu");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private TableView<ModelMenu> createMenuTable() {
		TableView<ModelMenu> table = new TableView<>();

		TableColumn<ModelMenu, String> nameColumn = new TableColumn<>("Menu Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("menuItemName"));

		TableColumn<ModelMenu, String> descColumn = new TableColumn<>("Menu Description");
		descColumn.setCellValueFactory(new PropertyValueFactory<>("menuItemDescription"));

		TableColumn<ModelMenu, Number> priceColumn = new TableColumn<>("Menu Price");
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("menuItemPrice"));

		TableColumn<ModelMenu, Void> actionColumn = new TableColumn<>("Action");
		actionColumn.setCellFactory(param -> new TableCell<>() {
		    private final Button addButton = new Button("Add To Cart");
		    private final HBox hbox = new HBox(addButton) {{ setAlignment(Pos.CENTER); }};
		    {
		        addButton.setOnAction(event -> {
		            ModelMenu rowData = getTableView().getItems().get(getIndex());
		            ControllerCustomerMenu.handleCart(rowData);
		        });
		    }
		    @Override
		    protected void updateItem(Void item, boolean empty) {
		        super.updateItem(item, empty);
		        setGraphic(empty ? null : hbox);
		    }
		});

		table.getColumns().add(nameColumn);
		table.getColumns().add(descColumn);
		table.getColumns().add(priceColumn);
		table.getColumns().add(actionColumn);

		return table;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Button getViewBtn() {
		return viewBtn;
	}

	public void setViewBtn(Button viewBtn) {
		this.viewBtn = viewBtn;
	}

	public Button getBackBtn() {
		return backBtn;
	}

	public void setBackBtn(Button backBtn) {
		this.backBtn = backBtn;
	}

	public HBox getButtonBox() {
		return buttonBox;
	}

	public void setButtonBox(HBox buttonBox) {
		this.buttonBox = buttonBox;
	}

	public TableView<ModelMenu> getTable() {
		return table;
	}

	public void setTable(TableView<ModelMenu> table) {
		this.table = table;
	}

	public Button getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(Button addBtn) {
		this.addBtn = addBtn;
	}
}