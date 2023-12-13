package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ViewCustomer {
	Scene scene;
	private Label titleLb 	= new Label("Hello, Customer!");;

	private Button menuBtn	= new Button("View Menu");
	private Button cartBtn 	= new Button("View Cart");
	private Button exitBtn 	= new Button("Exit");
	private HBox buttonBox 	= new HBox(10);

	private BorderPane borderCont = new BorderPane();

	private void addComponent() {

		titleLb.setFont(new Font("Copperplate Gothic Bold", 20));

		buttonBox.getChildren().addAll(menuBtn, cartBtn);
		borderCont.setTop(titleLb);
		borderCont.setCenter(buttonBox);
		borderCont.setBottom(exitBtn);

		BorderPane.setAlignment(titleLb, Pos.CENTER);
		BorderPane.setAlignment(exitBtn, Pos.CENTER);

		BorderPane.setMargin(buttonBox, new Insets(20));
		buttonBox.setAlignment(Pos.CENTER);
		scene = new Scene(borderCont, 300, 150);
	}
	
	public ViewCustomer(Stage stage) {
		addComponent();
		
		stage.setScene(scene);
		stage.setTitle("Customer");
		stage.setResizable(false);
		stage.show();
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Label getTitleLb() {
		return titleLb;
	}

	public void setTitleLb(Label titleLb) {
		this.titleLb = titleLb;
	}

	public Button getMenuBtn() {
		return menuBtn;
	}

	public void setMenuBtn(Button menuBtn) {
		this.menuBtn = menuBtn;
	}

	public Button getCartBtn() {
		return cartBtn;
	}

	public void setCartBtn(Button cartBtn) {
		this.cartBtn = cartBtn;
	}

	public Button getExitBtn() {
		return exitBtn;
	}

	public void setExitBtn(Button exitBtn) {
		this.exitBtn = exitBtn;
	}

	public HBox getButtonBox() {
		return buttonBox;
	}

	public void setButtonBox(HBox buttonBox) {
		this.buttonBox = buttonBox;
	}

	public BorderPane getBorderCont() {
		return borderCont;
	}

	public void setBorderCont(BorderPane borderCont) {
		this.borderCont = borderCont;
	}
}
