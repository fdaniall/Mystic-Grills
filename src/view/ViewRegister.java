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

public class ViewRegister{
	Scene scene;

	private BorderPane borderCont;
	private GridPane gridCont;
	private FlowPane flowCont;

	private Label titleLb;
	private Label usernameLb;
	private Label emailLb;
	private Label passwordLb;
	private Label confirmLb;

	private TextField usernameTF;
	private TextField emailTF;

	private PasswordField passwordPF;
	private PasswordField confirmPF;

	private HBox buttonBox = new HBox(10);
	private Button registBtn;
	private Button cancelBtn;

	private void initialize() {
		borderCont 	= new BorderPane();
		gridCont 	= new GridPane();
		flowCont	= new FlowPane();

		titleLb 	= new Label("Create Account");
		usernameLb 	= new Label("Username");
		emailLb 	= new Label("Email");
		passwordLb 	= new Label("Password");
		confirmLb 	= new Label("Confirm Password");

		usernameTF 	= new TextField();
		emailTF 	= new TextField();
		passwordPF 	= new PasswordField();
		confirmPF 	= new PasswordField();

		registBtn 	= new Button("Sign Up");
		cancelBtn 	= new Button("Cancel");
	}

	private void addComponent() {
		buttonBox.getChildren().addAll(registBtn, cancelBtn);

		borderCont.setTop(titleLb);
		borderCont.setCenter(gridCont);
		borderCont.setBottom(buttonBox);

		gridCont.add(usernameLb, 0, 0);
		gridCont.add(usernameTF, 0, 1);
		gridCont.add(emailLb, 0, 2);
		gridCont.add(emailTF, 0, 3);
		gridCont.add(passwordLb, 0, 4);
		gridCont.add(passwordPF, 0, 5);
		gridCont.add(confirmLb, 0, 6);
		gridCont.add(confirmPF, 0, 7);

		scene = new Scene(borderCont, 350, 350);
	}

	private void arrangeComponent() {
		BorderPane.setAlignment(titleLb, Pos.CENTER);
		BorderPane.setAlignment(gridCont, Pos.CENTER);

		BorderPane.setMargin(titleLb, new Insets(20));
		BorderPane.setMargin(buttonBox, new Insets(20));

		buttonBox.setAlignment(Pos.CENTER);

		gridCont.setAlignment(Pos.CENTER);
		gridCont.setVgap(5);

		usernameTF.setMinWidth(300);

		titleLb.setFont(new Font("Copperplate Gothic Bold", 24));
	}

	public ViewRegister(Stage stg1) {
		initialize();
		addComponent();
		arrangeComponent();

		stg1.setTitle("Mystic Grills");
		stg1.setScene(scene);
		stg1.setResizable(false);
		stg1.show();
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

	public Label getUsernameLb() {
		return usernameLb;
	}

	public void setUsernameLb(Label usernameLb) {
		this.usernameLb = usernameLb;
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

	public Label getConfirmLb() {
		return confirmLb;
	}

	public void setConfirmLb(Label confirmLb) {
		this.confirmLb = confirmLb;
	}

	public TextField getUsernameTF() {
		return usernameTF;
	}

	public void setUsernameTF(TextField usernameTF) {
		this.usernameTF = usernameTF;
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

	public PasswordField getConfirmPF() {
		return confirmPF;
	}

	public void setConfirmPF(PasswordField confirmPF) {
		this.confirmPF = confirmPF;
	}

	public HBox getButtonBox() {
		return buttonBox;
	}

	public void setButtonBox(HBox buttonBox) {
		this.buttonBox = buttonBox;
	}

	public Button getRegistBtn() {
		return registBtn;
	}

	public void setRegistBtn(Button registBtn) {
		this.registBtn = registBtn;
	}

	public Button getCancelBtn() {
		return cancelBtn;
	}

	public void setCancelBtn(Button cancelBtn) {
		this.cancelBtn = cancelBtn;
	}
}