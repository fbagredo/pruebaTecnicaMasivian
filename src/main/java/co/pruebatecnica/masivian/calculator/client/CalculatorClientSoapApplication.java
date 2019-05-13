package co.pruebatecnica.masivian.calculator.client;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ws.soap.client.SoapFaultClientException;

import co.pruebatecnica.masivian.calculator.client.entities.ResultadoOperacion;
import co.pruebatecnica.masivian.calculator.client.schemas.calculator.Add;
import co.pruebatecnica.masivian.calculator.client.schemas.calculator.AddResponse;
import co.pruebatecnica.masivian.calculator.client.schemas.calculator.Divide;
import co.pruebatecnica.masivian.calculator.client.schemas.calculator.DivideResponse;
import co.pruebatecnica.masivian.calculator.client.schemas.calculator.Multiply;
import co.pruebatecnica.masivian.calculator.client.schemas.calculator.MultiplyResponse;
import co.pruebatecnica.masivian.calculator.client.schemas.calculator.Subtract;
import co.pruebatecnica.masivian.calculator.client.schemas.calculator.SubtractResponse;
import co.pruebatecnica.masivian.calculator.client.service.ResultadoOperacionController;
import co.pruebatecnica.masivian.calculator.client.soap.SOAPConnector;

@SpringBootApplication
public class CalculatorClientSoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorClientSoapApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(SOAPConnector soapConnector, ResultadoOperacionController resultadoOperacionController) {
		return args -> {
			
			Logger logger = LogManager.getLogger(CalculatorClientSoapApplication.class);
			
			Add requestAdd = new Add();
			requestAdd.setIntA(9774532);
			requestAdd.setIntB(16558);

			Subtract requestSub = new Subtract();
			requestSub.setIntA(9774532);
			requestSub.setIntB(16558);

			Multiply requestMultiply = new Multiply();
			requestMultiply.setIntA(97745);
			requestMultiply.setIntB(16558);

			Divide requestDivide = new Divide();
			requestDivide.setIntA(9774532);
			requestDivide.setIntB(16558);

			try {
				AddResponse addResponse = (AddResponse) soapConnector.callWebService(requestAdd, "Add");

				resultadoOperacionController.saveResultadoOperacion(new ResultadoOperacion(requestAdd.getIntA(),
						requestAdd.getIntB(), "Add", addResponse.getAddResult()));

				SubtractResponse substracResponse = (SubtractResponse) soapConnector.callWebService(requestSub,
						"Subtract");

				resultadoOperacionController.saveResultadoOperacion(new ResultadoOperacion(requestSub.getIntA(),
						requestSub.getIntB(), "Substract", substracResponse.getSubtractResult()));

				MultiplyResponse multuplyResponse = (MultiplyResponse) soapConnector.callWebService(requestMultiply,
						"Multiply");

				resultadoOperacionController.saveResultadoOperacion(new ResultadoOperacion(requestMultiply.getIntA(),
						requestMultiply.getIntB(), "Multiply", multuplyResponse.getMultiplyResult()));

				DivideResponse divideResponse = (DivideResponse) soapConnector.callWebService(requestDivide, "Divide");
				resultadoOperacionController.saveResultadoOperacion(new ResultadoOperacion(requestDivide.getIntA(),
						requestDivide.getIntB(), "Divide", divideResponse.getDivideResult()));

			} catch (SoapFaultClientException e) {
				logger.error("Error en el WS: " + e);
			}

			for (ResultadoOperacion ro : resultadoOperacionController.getAllResultadoOperacion()) {
				logger.info(ro);
			}
		};
	}
}