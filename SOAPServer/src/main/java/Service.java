import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService(name = "Service", targetNamespace = "utez")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Service {

    //-----------------------------------------------------Adivinanza---------------------------------------------------------------------------------------------------//
    public String Adivinanza(int num){
        int Gen =(int) (Math.random()*3+1);
        if (Gen == num){
            return "Felicidades";
        }else {
            return "Lo lamento";
        }
    }
    //----------------------------------------------------Consonantes---------------------------------------------------------------------------------------------------//
    String palabra = "Hola que onda";
    char[] array = palabra.toCharArray();
    public char[] Lea(int i, char x, char[] array){

        if (i == array.length){
            return array;
        } else {
            x = array[i];
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u'
                    || x == 'A' || x == 'E' || x == 'I' || x == 'O' || x == 'U'){
                array[i] = ' ';
                return Lea(++i, x=' ',array);
            }else {
                return Lea(++i, x=' ',array);
            }
        }

    }

    //--------------------------------------------------------------------------RFC------------------------------------------------------------------------------------//
    public String compuesto(int longitud){
    String res ="";
    for (int cont =1 ; cont <= longitud;cont++){
        int num = (int) (Math.random()*(('z'-'a')+1)+'q');
        char letra = (char) num;
        res = res+letra;
    }
    return res;
}

    public String reversa(String fecha_nac){
        int cont;
        String num = "";
        char [] invertircadena = fecha_nac.toCharArray();
        for (cont = fecha_nac.length()-1; cont >= 0; cont--){
            num = ""+invertircadena[cont]+invertircadena[cont]+invertircadena[cont];
        }
        return num;
    }

    public String generar_rfc (String Ap1,String Ap2,String Nombre,String fecha_nac){
        String rfc = Ap1.trim().substring(0,2);
        rfc = rfc.concat(Ap2.trim().substring(0,1));
        rfc = rfc.concat(Nombre.trim().substring(0,1));
        return rfc;
    }

    @WebMethod(operationName = "responsesMessage")
    public String responsesMessage(@WebParam(name = "message") String message){
            return "Tu mensaje fue recibido leelo: "+message;
    }


    public static void main(String[] args) {
        System.out.println("Starting the Server.....");
        Endpoint.publish("http://localhost:8081/Service", new Service());
        System.out.println("Waiting for Requests...");


    }
}
