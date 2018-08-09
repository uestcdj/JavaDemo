package SocketDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDemo {
	
	private static void send(String path) {
		OutputStream os = null;
		Socket socket = null;
		PrintWriter pw = null;
		InputStream is = null;
		try {
			socket = new Socket("localhost", 10086);
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write(path);
			pw.flush();
			socket.shutdownOutput();
			is = socket.getInputStream();
			String s = ConvertUtils.getStreamString(is);
			System.out.println(s);
		} catch (UnknownHostException e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("请输入文件目录（如/usr/dj）");
		Scanner s = new Scanner(System.in);
		String path = "";
		while(!(path = s.next()).startsWith("/")) {
			System.out.println("请输入正确的文件目录格式");
		}
		send(path);
	}
}
