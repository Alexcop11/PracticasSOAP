import javafx.concurrent.Service;

public class SoapClient {
    public static void main(String[] args) {
        ServiceService service = new Service();
        Service port = service.getServicePort();
        String response = port.responseMessage("Alex");
        String response = port.responseMessage(1);
        System.out.println(response);

    }
}
