package SocketDemo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class ServerDemo {
	
	private static void appendSbf(StringBuffer s, File f) {
		if(!f.exists()) {
			s.append("不存在该目录");
		}else {
			if(f != null && f.isDirectory()) {
				File[] fileList = f.listFiles();
				if(fileList.length > 0) {
					for(File now : fileList) {
						Calendar cal = Calendar.getInstance();
						cal.setTimeInMillis(now.lastModified());
						s.append("文件名:").append(now.getName())
						.append(" 文件大小:").append(now.length())
						.append(" 文件最后修改时间:").append(cal.getTime().toLocaleString());
					}
				}else {
					s.append("该目录下没有文件！");
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		InputStream is = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			serverSocket = new ServerSocket(10086);
			socket = serverSocket.accept();
			is = socket.getInputStream();
			String path = ConvertUtils.getStreamString(is);
			File f = new File(path);
			socket.shutdownInput();
			StringBuffer s = new StringBuffer();
			appendSbf(s, f);
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write(s.toString());
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			if(os != null) {
				os.close();
			}
			if(socket != null) {
				socket.close();
			}
			if(pw != null) {
				pw.close();
			}
			if(is != null) {
				is.close();
			}
		} catch (Exception e) {

		}
	}

}
