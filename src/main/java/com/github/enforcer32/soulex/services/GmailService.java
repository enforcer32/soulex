package com.github.enforcer32.soulex.services;

import com.github.enforcer32.soulex.model.EmailFolder;

import javax.mail.Folder;
import javax.mail.MessagingException;
import javax.mail.Store;

public class GmailService {
	private Store store;
	private EmailFolder<String> folders;

	public GmailService(Store store, EmailFolder<String> folders) {
		this.store = store;
		this.folders = folders;
	}

	public void fetchFolders() {
		try {
			Folder[] fetched = store.getDefaultFolder().list();
			gmailFetchFolders(fetched, folders);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private void gmailFetchFolders(Folder[] gmailFolders, EmailFolder<String> root) throws MessagingException {
		for(Folder folder: gmailFolders) {
			EmailFolder<String> folderItem = new EmailFolder<>(folder.getName());
			root.getChildren().add(folderItem);
			root.setExpanded(true);
			if(folder.getType() == Folder.HOLDS_FOLDERS) {
				Folder[] subFolders = folder.list();
				gmailFetchFolders(subFolders, folderItem);
			}
		}
	}
}
