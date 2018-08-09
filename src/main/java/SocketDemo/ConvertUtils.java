package SocketDemo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ConvertUtils {
	
	public static String getStreamString(InputStream in) {
		BufferedReader bfr = null;
		if(in != null) {
			try {
				bfr = new BufferedReader(new InputStreamReader(in));
				StringBuffer sbf = new StringBuffer();
				String tmp = "";
				while((tmp = bfr.readLine()) != null) {
					sbf.append(tmp);
				}
				return sbf.toString();
			} catch (Exception e) {
				
			}
		}
		try {
			if(bfr != null) {
				bfr.close();
			}
		} catch (Exception e) {
			
		}
		return "";
	}
}
