package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.ModelMenu;
import model.ModelUser;

public class ViewCustomerOrderQuantity {
    Scene scene;
    private TableView<ModelMenu> table;

    private Label titleLB         	= new Label("Order Quantity");
    private Label nameLB          	= new Label("Menu Name: ");
    private Label quantityLB      	= new Label("Quantity: ");
    
    private GridPane gridCont      	= new GridPane();
    private BorderPane borderCont	= new BorderPane();

    private HBox buttonBox			= new HBox(10);
    private Button saveBtn     		= new Button("Add To Cart");
    private Button cancelBtn    	= new Button("Cancel");
    private TextField nameTF;
    private Spinner<Integer> quantityTF;

    private void init(ModelMenu rowData) {
        buttonBox.getChildren().addAll(saveBtn, cancelBtn);

        nameTF   	= new TextField(rowData.getMenuItemName());
        quantityTF	= new Spinner<>(1, Integer.MAX_VALUE, 1);
        quantityTF.getValueFactory().setValue(1);
        quantityTF.setEditable(true);

        borderCont.setTop(titleLB);
        borderCont.setCenter(gridCont);
        borderCont.setBottom(buttonBox);

        gridCont.add(nameLB, 0, 0);
        gridCont.add(nameTF, 1, 0);
        nameTF.setDisable(true);
        gridCont.add(quantityLB, 0, 1);
        gridCont.add(quantityTF, 1, 1);

        BorderPane.setAlignment(titleLB, Pos.CENTER);
        BorderPane.setAlignment(gridCont, Pos.CENTER);
        buttonBox.setAlignment(Pos.CENTER);

        BorderPane.setMargin(titleLB, new Insets(10));
        BorderPane.setMargin(gridCont, new Insets(10));
        BorderPane.setMargin(buttonBox, new Insets(10));

        gridCont.setAlignment(Pos.CENTER);
        gridCont.setVgap(10);

        titleLB.setFont(new Font("Copperplate Gothic Bold", 20));

        scene = new Scene(borderCont, 350, 200);
    }

    public ViewCustomerOrderQuantity(Stage stage, ModelMenu rowData) {
        init(rowData);

        stage.setScene(scene);
        stage.setTitle("Mystic Grills - Order Quantity");
        stage.setResizable(false);
        stage.show();
    }

    public TableView<ModelMenu> getTable() {
        return table;
    }

    public void setTable(TableView<ModelMenu> table) {
        this.table = table;
    }

    public HBox getButtonBox() {
        return buttonBox;
    }

    public void setButtonBox(HBox buttonBox) {
        this.buttonBox = buttonBox;
    }

    public Button getSaveBtn() {
        return saveBtn;
    }

    public void setSaveBtn(Button saveBtn) {
        this.saveBtn = saveBtn;
    }

    public Button getCancelBtn() {
        return cancelBtn;
    }

    public void setCancelBtn(Button cancelBtn) {
        this.cancelBtn = cancelBtn;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Label getTitleLB() {
        return titleLB;
    }

    public void setTitleLB(Label titleLB) {
        this.titleLB = titleLB;
    }

    public Label getNameLB() {
        return nameLB;
    }

    public void setNameLB(Label nameLB) {
        this.nameLB = nameLB;
    }

    public Label getQuantityLB() {
        return quantityLB;
    }

    public void setQuantityLB(Label quantityLB) {
        this.quantityLB = quantityLB;
    }

    public TextField getNameTF() {
        return nameTF;
    }

    public void setNameTF(TextField nameTF) {
        this.nameTF = nameTF;
    }

    public Spinner<Integer> getQuantityTF() {
        return quantityTF;
    }

    public void setQuantityTF(Spinner<Integer> quantityTF) {
        this.quantityTF = quantityTF;
    }

    public GridPane getGridCont() {
        return gridCont;
    }

    public void setGridCont(GridPane gridCont) {
        this.gridCont = gridCont;
    }

    public BorderPane getBorderCont() {
        return borderCont;
    }

    public void setBorderCont(BorderPane borderCont) {
        this.borderCont = borderCont;
    }
}
