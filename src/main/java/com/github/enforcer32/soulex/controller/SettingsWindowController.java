package com.github.enforcer32.soulex.controller;

import com.github.enforcer32.soulex.app.Settings;
import com.github.enforcer32.soulex.app.StageManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsWindowController extends BaseController implements Initializable {
	@FXML
	private TextField imapHostField;

	@FXML
	private TextField imapPortField;

	@FXML
	private CheckBox imapSSLCheckbox;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		imapHostField.setText(Settings.get("mail.imap.host").toString());
		imapPortField.setText(Settings.get("mail.imap.port").toString());
		imapSSLCheckbox.setSelected(Boolean.parseBoolean(Settings.get("mail.imap.ssl.enable").toString()));
	}

	@FXML
	void applyBtn() {
		Settings.set("mail.imap.host", imapHostField.getText());
		Settings.set("mail.imap.port", imapPortField.getText());
		Settings.set("mail.imap.ssl.enable", String.valueOf(imapSSLCheckbox.isSelected()));
	}

	@FXML
	void cancelBtn() {
		StageManager.closeStage(this.getClass());
	}
}

