package co.pruebatecnica.masivian.calculator.client.soap;

import java.io.IOException;

import javax.xml.transform.TransformerException;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;
 
public class SOAPConnector extends WebServiceGatewaySupport {
 
    public Object callWebService(String url, Object request){
        return getWebServiceTemplate().marshalSendAndReceive(url, request, new WebServiceMessageCallback() {
            @Override
            public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {
                ((SoapMessage)webServiceMessage).setSoapAction("http://tempuri.org/Add");
            }
        });
    }
}