package com.github.enforcer32.soulex.model;

import javafx.scene.control.TreeItem;

public class EmailFolder<T> extends TreeItem<T> {
	private T value;

	public EmailFolder(T value) {
		super(value);
		this.value = value;
	}
}
