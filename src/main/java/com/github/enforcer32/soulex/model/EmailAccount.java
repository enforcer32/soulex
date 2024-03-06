package com.github.enforcer32.soulex.model;

import javax.mail.Store;

public class EmailAccount {
	private String emailAddress;
	private String password;
	private Store store;

	public EmailAccount(String emailAddress, String password) {
		this.emailAddress = emailAddress;
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
}
