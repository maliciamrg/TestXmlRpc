package com.maliciamrg.xmlrpc.server.client;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class TestXmlRpcClient {

	public static void main(String[] args) throws MalformedURLException, XmlRpcException {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();

		config.setServerURL(new URL((String) ("http://localhost:8080")));

		XmlRpcClient client = new XmlRpcClient();

		// client.setTransportFactory(new
		// XmlRpcSunHttpTransportFactory(client));
		client.setConfig(config);	


		
		String serie = "Test";
		String strnbjourprochainepisodes = "- 5 jours ";
		int nbpresent = 8;
		int nbencours = 5;
		int nbabsent = 3;
		int nbavenir = 1;
		
		Object[] params;
		
		params = new Object[] { serie };
		
		System.out.println((String) client.execute("ServerXmlRpc.testcommunication", params));
		
		params = new Object[] { nbabsent, nbavenir };

		System.out.println((int) client.execute("Calculator.subtract", params));
		
		System.out.println((Integer) client.execute("ServerXmlRpc.sum", params));
		
		params = new Object[] { serie, strnbjourprochainepisodes,
				nbpresent, nbencours, nbabsent, nbavenir };

		System.out.println((String) client.execute("Visuel.generate_image_resumer_serie", params));

	}
}
