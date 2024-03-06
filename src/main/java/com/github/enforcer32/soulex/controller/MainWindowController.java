package com.github.enforcer32.soulex.controller;

import com.github.enforcer32.soulex.app.EmailAccountManager;
import com.github.enforcer32.soulex.app.StageManager;
import com.github.enforcer32.soulex.model.EmailAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {
	@FXML
	private WebView emailWebView;

	@FXML
	private TableView<?> emailsTableView;

	@FXML
	private TreeView<String> foldersTreeView;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		foldersTreeView.setRoot(EmailAccountManager.getFolders());
		foldersTreeView.setShowRoot(false);
	}

	@FXML
	void addAccountMenu() {
		StageManager.createStage(LoginWindowController.class, "view/LoginWindow.fxml");
	}

	@FXML
	void settingsMenu() {
		StageManager.createStage(SettingsWindowController.class, "view/SettingsWindow.fxml");
	}
}
