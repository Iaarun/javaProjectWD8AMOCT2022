package filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileHandle {

	public static void main(String[] args) throws IOException {
		PropertiesFileHandle pfh = new PropertiesFileHandle();
		pfh.readConfig();
	}

	public Properties readConfig() throws IOException {
		File file = new File("D:\\javaprog\\JavaProjectWD8AMOCT\\dataSet\\config.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);

//		System.out.println(prop.get("browser"));
//		System.out.println(prop.get("username"));
//		System.out.println(prop.get("password"));

		return prop;
	}

}
