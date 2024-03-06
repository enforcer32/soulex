package com.github.enforcer32.soulex.app;

import java.util.Properties;

public class Settings {
	static final Properties properties = new Properties();

	static {
		// IMAP
		properties.put("mail.store.protocol", "imap");
		properties.put("mail.imap.host", "imap.gmail.com");
		properties.put("mail.imap.port", "993");
		properties.put("mail.imap.ssl.enable", "true");

		// SMTP
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.auth", "true");
	}

	public static void set(Object key, Object value) {
		properties.put(key, value);
	}

	public static Object get(Object key) {
		return properties.get(key);
	}

	public static Properties getProperties() {
		return properties;
	}
}
