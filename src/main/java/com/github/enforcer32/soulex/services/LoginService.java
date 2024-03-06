package com.github.enforcer32.soulex.services;

import com.github.enforcer32.soulex.app.ConnResult;
import com.github.enforcer32.soulex.app.EmailAccountManager;
import com.github.enforcer32.soulex.app.Settings;
import com.github.enforcer32.soulex.model.EmailAccount;
import javafx.concurrent.Task;

import javax.mail.*;

public class LoginService {
	EmailAccount emailAccount;

	public LoginService(EmailAccount emailAccount) {
		this.emailAccount = emailAccount;
	}

	private ConnResult synclogin() {
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailAccount.getEmailAddress(), emailAccount.getPassword());
			}
		};

		try {
			Session session = Session.getInstance(Settings.getProperties(), authenticator);
			Store store = session.getStore("imap");
			store.connect(Settings.getProperties().getProperty("mail.imap.host"), emailAccount.getEmailAddress(), emailAccount.getPassword());
			emailAccount.setStore(store);
			EmailAccountManager.addEmailAccount(emailAccount);
		} catch (AuthenticationFailedException e) {
			return ConnResult.BAD_CREDENTIALS;
		} catch (Exception e) {
			return ConnResult.UNEXPECTED_ERROR;
		}

		return ConnResult.SUCCESS;
	}

	public Task<ConnResult> login() {
		Task<ConnResult> task = new Task<>() {
			@Override
			protected ConnResult call() {
				return synclogin();
			}
		};

		new Thread(task).start();
		return task;
	}
}
