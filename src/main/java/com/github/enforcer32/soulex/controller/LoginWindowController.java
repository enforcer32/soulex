package com.github.enforcer32.soulex.controller;

import com.github.enforcer32.soulex.app.ConnResult;
import com.github.enforcer32.soulex.model.EmailAccount;
import com.github.enforcer32.soulex.services.LoginService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		// DEV
		emailAddressField.setText("@gmail.com");
		passwordField.setText("Pass");
	}

	@FXML
	private TextField emailAddressField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private Label statusBarLabel;

	@FXML
	void loginBtn() {
		if(validateForm()) {
			EmailAccount emailAccount = new EmailAccount(emailAddressField.getText(), passwordField.getText());
			LoginService loginService = new LoginService(emailAccount);

			loginService.login().setOnSucceeded(event -> {
				ConnResult result = (ConnResult) event.getSource().getValue();
				switch (result) {
					case SUCCESS:
						sceneManager.switchScene("view/MainWindow.fxml");
						break;
					case BAD_CREDENTIALS:
						statusBarLabel.setText("Invalid credentials");
						break;
					default:
						statusBarLabel.setText("Unexpected Error");
						break;
				}
			});
		}
	}

	private boolean validateForm() {
		if(!emailAddressField.getText().isEmpty() && !passwordField.getText().isEmpty())
			return true;

		statusBarLabel.setText("Bad Input");
		return false;
	}

}
