package org.icbc.tool;

import java.io.FileWriter;
import java.io.IOException;

public class writefile {
	public static void writeMethod1(String text) {
		String fileName="/data/intern/app/tomcat/tomcat/log.txt";
		try {
			FileWriter writer = new FileWriter(fileName);
			writer.append(text);
			writer.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
