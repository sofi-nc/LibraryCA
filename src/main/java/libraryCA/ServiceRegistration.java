package libraryCA;

import java.io.IOException;
import java.net.InetAddress;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class ServiceRegistration {
	public static void main(String[] args) throws InterruptedException {

		try {

			// Create a JmDNS instance
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			System.out.println("Registration: " + InetAddress.getLocalHost());

			
			// Register a service
			// ServiceInfo.create takes the hostname, service name, port name and
			// the URL to access the service
			ServiceInfo LightsInfo = ServiceInfo.create("_grpc.local.", "Lighting", 50051, "path=index.html");
			jmdns.registerService(LightsInfo);
			System.out.println("Registered: " + InetAddress.getLocalHost() + LightsInfo.getPort());
			// Start a service
			LightingServer.startServer();
			Thread.sleep(100);

			
			ServiceInfo SearchInfo = ServiceInfo.create("_grpc.local.", "SearchEngine", 50052, "path=index.html");
			jmdns.registerService(SearchInfo);
			System.out.println("Registered: " + InetAddress.getLocalHost() + SearchInfo.getPort());
			SearchServer.startServer();
			Thread.sleep(100);
			
			ServiceInfo RegistrationInfo = ServiceInfo.create("_grpc.local.", "Registration", 50053, "path=index.html");
			jmdns.registerService(RegistrationInfo);
			System.out.println("Registered: " + InetAddress.getLocalHost() + SearchInfo.getPort());
			RegisterServer.startServer();
			Thread.sleep(100);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}