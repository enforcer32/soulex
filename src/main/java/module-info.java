module soulex {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.web;
	requires java.mail;

	opens com.github.enforcer32.soulex.app;
	opens com.github.enforcer32.soulex.controller;
}
