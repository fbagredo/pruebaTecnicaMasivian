package co.pruebatecnica.masivian.calculator.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.soap.client.SoapFaultClientException;

import co.pruebatecnica.masivian.calculator.client.schemas.calculator.Add;
import co.pruebatecnica.masivian.calculator.client.schemas.calculator.AddResponse;
import co.pruebatecnica.masivian.calculator.client.soap.SOAPConnector;

@SpringBootApplication
public class CalculatorClientSoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorClientSoapApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(SOAPConnector soapConnector) {
		return args -> {
			Add request = new Add();
			request.setIntA(977734849);
			request.setIntB(1655469698);

			try {
				AddResponse response = (AddResponse) soapConnector
						.callWebService("http://www.dneonline.com/calculator.asmx", request);
				System.out.println("Got Response As below ========= : ");
				System.out.println("Name : " + response.getAddResult());
			} catch (SoapFaultClientException e) {
				System.out.println("Error en el WS: " + e);
			}
		};
	}
}