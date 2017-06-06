package modelo;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import javax.swing.JOptionPane;
import org.json.JSONObject;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.7F263C33-4DD2-C9E9-836B-B8A2832C4630]
// </editor-fold> 
public class ConexionWebService {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F1A25C0A-C59E-67E6-F27B-DF3F1F472060]
    // </editor-fold> 
    private String url = "http://186.64.113.50/~jorgesilva/Prueba/";

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.ABAE7082-47BF-7B7F-ACEA-7209A0DE5FC5]
    // </editor-fold> 
    private int codigoRespuesta;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F3673061-CF52-CC9A-9552-E8B29A0BF0B5]
    // </editor-fold> 
    public ConexionWebService () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.3023E1C4-DCE6-7751-B6C7-4E467D04CC14]
    // </editor-fold> 
    public int getCodigoRespuesta () {
        return codigoRespuesta;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.0A52D240-A7A3-0C12-C542-A4A81AA96E09]
    // </editor-fold> 
    public void setCodigoRespuesta (int val) {
        this.codigoRespuesta = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E6C354D3-910D-CFB9-8481-B9413D53F6A9]
    // </editor-fold> 
    public String getUrl () {
        return url;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A3198F40-714B-4D04-A48C-C2F063A5D4F5]
    // </editor-fold> 
    public void setUrl (String val) {
        this.url = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A315D517-EEE9-23F7-C978-40CA00D127D3]
    // </editor-fold> 
    public String solicitarDatosSinPaginacion (String campos, String tablas, String clausulaWhere) {
        
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.3F909751-5F86-F365-04D0-4C3BB02EF013]
    // </editor-fold> 
    public String solicitarDatosConPaginacion (String campos, String tablas, String clausulaWhere, String ordenarPorCampo, int indiceComienzo, int datosPorPagina) throws MalformedURLException, IOException {
        URL obj = new URL(this.url+"Sql.controlador.php");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("POST");
	con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
	con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        con.setDoOutput(true);
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        
        
        String parametros = "campos="+campos
                           +"&tablas="+tablas
                           +"&clausula_where="+clausulaWhere
                           +"&jtSorting="+ordenarPorCampo
                           +"&jtStartIndex="+String.valueOf(indiceComienzo)
                           +"&jtPageSize="+String.valueOf(datosPorPagina)
                           +"&accion=consulta_con_paginacion";
	wr.writeBytes(parametros);
	wr.flush();
	wr.close();
        
        //Este nos va a mostrar el código de respuesta de apache.
	this.codigoRespuesta = con.getResponseCode();
	
        //Salidas de control
        //System.out.println("Enviando request 'POST' a: " + this.url);
        //System.out.println("Parámetros del POST : " + this.parametros);
        //System.out.println("Código respuesta: " + this.codigoRespuesta);
        switch (this.codigoRespuesta) {
            case 200://La conexión es exitosa
                break;
            case 401:
                //Si hay un error mostrará un jPanel y retornará null
                JOptionPane.showMessageDialog(null, "Error de conexión : No Autorizado.");
                return null;
            default:
                JOptionPane.showMessageDialog(null, "Error : El servidor no se encuentra disponible, espere un momento y vuelva a intentarlo, si continúa el problema contacte con los desarrolladores.");
                return null;
        }
        
        //Acá se procesa por entrada estándar la respuesta que entrega el sitio web (http://localhost/WebServices/index.php)
	BufferedReader entrada = new BufferedReader(new InputStreamReader(con.getInputStream()));
	String lineaEntrada;
	StringBuilder salida = new StringBuilder();
	
	/**
	 * Según lo que se hizo por el lado de PHP, va a devolver un arreglo JSON
	 * Recibimos ese texto y lo armamos.
	 */
	while ((lineaEntrada = entrada.readLine()) != null) {
	    salida.append(lineaEntrada);
	}
	entrada.close();
	//System.out.println(salida.toString());
	//Convertimos el texto recibido desde PHP a un objeto JSON de Java.

	JSONObject json = new JSONObject(salida.toString());
        return salida.toString();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AF91DC14-BB38-8DD9-3064-EAEC78B2970F]
    // </editor-fold> 
    public String ingresar (String sql) throws MalformedURLException, ProtocolException, IOException {
        URL obj = new URL(this.url+"Sql.controlador.php");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("POST");
	con.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
	con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        con.setDoOutput(true);
	DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        
        
        String parametros = "sql="+sql
                           +"&accion=DAO";
	wr.writeBytes(parametros);
	wr.flush();
	wr.close();
        
        //Este nos va a mostrar el código de respuesta de apache.
	this.codigoRespuesta = con.getResponseCode();
	
        //Salidas de control
        System.out.println("Enviando request 'POST' a: " + this.url);
        System.out.println("Parámetros del POST : " + parametros);
        System.out.println("Código respuesta: " + codigoRespuesta);
        switch (this.codigoRespuesta) {
            case 200://La conexión es exitosa
                break;
            case 401:
                //Si hay un error mostrará un jPanel y retornará null
                JOptionPane.showMessageDialog(null, "Error de conexión : No Autorizado.");
                return null;
            default:
                JOptionPane.showMessageDialog(null, "Error : El servidor no se encuentra disponible, espere un momento y vuelva a intentarlo, si continúa el problema contacte con los desarrolladores.");
                return null;
        }
        
        //Acá se procesa por entrada estándar la respuesta que entrega el sitio web (http://localhost/WebServices/index.php)
	BufferedReader entrada = new BufferedReader(new InputStreamReader(con.getInputStream()));
	String lineaEntrada;
	StringBuilder salida = new StringBuilder();
	
	/**
	 * Según lo que se hizo por el lado de PHP, va a devolver un arreglo JSON
	 * Recibimos ese texto y lo armamos.
	 */
	while ((lineaEntrada = entrada.readLine()) != null) {
	    salida.append(lineaEntrada);
	}
	entrada.close();
	//System.out.println(salida.toString());
	//Convertimos el texto recibido desde PHP a un objeto JSON de Java.

	JSONObject json = new JSONObject(salida.toString());
        return salida.toString();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A58AC9A3-D985-332A-4CA2-511B3E2EB176]
    // </editor-fold> 
    public String modificar (String sql) {
        return null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1B891E1C-9A37-4C90-3863-B1C243D4887B]
    // </editor-fold> 
    public String eliminar (String sql) {
        return null;
    }

}

