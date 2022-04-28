package com.pack.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		File src = new File("./configurations/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getPartnerCode() {
		String partnerCode=pro.getProperty("partnerCode");
		return partnerCode;
	}
	public String getApplicationUrl() {
		String url=pro.getProperty("url");
		return url;
	}
	public String getUserName() {
		String username=pro.getProperty("loginas");
		return username;
	}
	public String getPassword() {
		String pwd=pro.getProperty("password");
		return pwd;
	}
	public String getChromepath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	public String getFirefoxpath() {
		String firefox=pro.getProperty("firefoxpath");
		return firefox;
	}
	public String getIEpath() {
		String iepath=pro.getProperty("IEpath");
		return iepath;
	}
     
}
