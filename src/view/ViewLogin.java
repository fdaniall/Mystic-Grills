package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ViewLogin {
	Scene scene;

	private BorderPane borderCont;
	private GridPane gridCont;
	private FlowPane flowCont;

	private Label titleLb;
	private Label emailLb;
	private Label passwordLb;

	private TextField emailTF;

	private PasswordField passwordPF;

	private HBox buttonBox = new HBox(10);
	private Button loginBtn;
	private Button registBtn;

	private void initialize() {
		borderCont 	= new BorderPane();
		gridCont 	= new GridPane();
		flowCont	= new FlowPane();

		titleLb 	= new Label("Login Account");
		emailLb 	= new Label("Email");
		passwordLb 	= new Label("Password");

		emailTF 	= new TextField();
		passwordPF 	= new PasswordField();

		loginBtn 	= new Button("Sign In");
		registBtn 	= new Button("Register");
	}

	private void addComponent() {
		buttonBox.getChildren().addAll(loginBtn, registBtn);

		borderCont.setTop(titleLb);
		borderCont.setCenter(gridCont);
		borderCont.setBottom(buttonBox);

		gridCont.add(emailLb, 0, 0);
		gridCont.add(emailTF, 0, 1);
		gridCont.add(passwordLb, 0, 2);
		gridCont.add(passwordPF, 0, 3);

		scene = new Scene(borderCont, 350, 250);
	}

	private void arrangeComponent() {
		BorderPane.setAlignment(titleLb, Pos.CENTER);
		BorderPane.setAlignment(gridCont, Pos.CENTER);

		BorderPane.setMargin(titleLb, new Insets(20));
		BorderPane.setMargin(buttonBox, new Insets(20));

		buttonBox.setAlignment(Pos.CENTER);

		gridCont.setAlignment(Pos.CENTER);
		gridCont.setVgap(10);

		emailTF.setMinWidth(300);

		titleLb.setFont(new Font("Copperplate Gothic Bold", 24));
	}

	public ViewLogin(Stage stage) {

		initialize();
		addComponent();
		arrangeComponent();

		stage.setTitle("Mystic Grills");
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public BorderPane getBorderCont() {
		return borderCont;
	}

	public void setBorderCont(BorderPane borderCont) {
		this.borderCont = borderCont;
	}

	public GridPane getGridCont() {
		return gridCont;
	}

	public void setGridCont(GridPane gridCont) {
		this.gridCont = gridCont;
	}

	public FlowPane getFlowCont() {
		return flowCont;
	}

	public void setFlowCont(FlowPane flowCont) {
		this.flowCont = flowCont;
	}

	public Label getTitleLb() {
		return titleLb;
	}

	public void setTitleLb(Label titleLb) {
		this.titleLb = titleLb;
	}

	public Label getEmailLb() {
		return emailLb;
	}

	public void setEmailLb(Label emailLb) {
		this.emailLb = emailLb;
	}

	public Label getPasswordLb() {
		return passwordLb;
	}

	public void setPasswordLb(Label passwordLb) {
		this.passwordLb = passwordLb;
	}

	public TextField getEmailTF() {
		return emailTF;
	}

	public void setEmailTF(TextField emailTF) {
		this.emailTF = emailTF;
	}

	public PasswordField getPasswordPF() {
		return passwordPF;
	}

	public void setPasswordPF(PasswordField passwordPF) {
		this.passwordPF = passwordPF;
	}

	public HBox getButtonBox() {
		return buttonBox;
	}

	public void setButtonBox(HBox buttonBox) {
		this.buttonBox = buttonBox;
	}

	public Button getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(Button loginBtn) {
		this.loginBtn = loginBtn;
	}

	public Button getRegistBtn() {
		return registBtn;
	}

	public void setRegistBtn(Button registBtn) {
		this.registBtn = registBtn;
	}
}