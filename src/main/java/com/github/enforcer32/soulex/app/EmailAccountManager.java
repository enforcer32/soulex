package com.github.enforcer32.soulex.app;

import com.github.enforcer32.soulex.model.EmailAccount;
import com.github.enforcer32.soulex.model.EmailFolder;
import com.github.enforcer32.soulex.services.GmailService;

public class EmailAccountManager {
	private static EmailFolder<String> folders = new EmailFolder<>("");

	public static EmailFolder<String> getFolders() {
		return folders;
	}

	public static void addEmailAccount(EmailAccount emailAccount) {
		EmailFolder<String> emailAccountFolders = new EmailFolder<>(emailAccount.getEmailAddress());
		new GmailService(emailAccount.getStore(), emailAccountFolders).fetchFolders();
		folders.getChildren().add(emailAccountFolders);
	}
}
