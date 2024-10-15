package day11;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;

public class Network01 {

	public static void main(String[] args) throws IOException {
		// 인터넷 주소의 정보를 확인
		InetAddress ip = null;
		ip = InetAddress.getByName("www.naver.com");
		System.out.println("HostAddress > "+ip.getHostAddress()); //*
		System.out.println("HostName > "+ip.getHostName());
		System.out.println(ip.toString());
		
		URL url = new URL("https://weather.naver.com/today/11200101?cpName=KMA");
		
		System.out.println(url.getContent());
		System.out.println(url.getAuthority());  //접근권한
		System.out.println(url.getDefaultPort());
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getQuery()); //*
		System.out.println(url.getPath());  //*
		
	}

}
