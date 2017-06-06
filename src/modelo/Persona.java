package modelo;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.37F59F61-C943-1E37-409D-73292D316F1A]
// </editor-fold> 
public class Persona {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A2AADC43-9E93-48A0-B258-B659D601279C]
    // </editor-fold> 
    private int id;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C8D8C8E0-08BD-C23C-FAA6-14D6B7AA8C6D]
    // </editor-fold> 
    private String rut;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FD552F85-5769-53EA-9910-FDF6E0B3C19B]
    // </editor-fold> 
    private String nombre;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9874EDF9-4B21-4F04-3241-13AD83BC6E2C]
    // </editor-fold> 
    private String secNombre;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.F22D8889-F068-856D-83DD-2910629E4FDE]
    // </editor-fold> 
    private String apPaterno;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2739368B-79E2-EC5B-61EB-4638E7D1FA11]
    // </editor-fold> 
    private String apMaterno;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0EC1E2E4-E115-0C67-84CF-5017CCD13CA9]
    // </editor-fold> 
    private ConexionWebService mConexionWebService;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D9F4A615-7305-9438-D791-A1B6C982EF4B]
    // </editor-fold> 
    public Persona () {
    }

    public Persona(int id, String rut, String nombre, String secNombre, String apPaterno, String apMaterno) {
        this.id = id;
        this.rut = rut;
        this.nombre = nombre;
        this.secNombre = secNombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
    }

    public Persona(String rut, String nombre, String secNombre, String apPaterno, String apMaterno) {
        this.rut = rut;
        this.nombre = nombre;
        this.secNombre = secNombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
    }

    public Persona(int id) {
        this.id = id;
    }
    
   
    
    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4E519D6D-C6D3-4FDB-EA1A-73E0EAB19D4C]
    // </editor-fold> 
    public String getApMaterno () {
        return apMaterno;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.AC32A506-EB55-5215-02EA-B3CF950BA81E]
    // </editor-fold> 
    public void setApMaterno (String val) {
        this.apMaterno = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.95C02B29-3A9C-445B-A3D7-5E825B9E9895]
    // </editor-fold> 
    public String getApPaterno () {
        return apPaterno;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.433E9ABD-070B-03C8-ABA1-2D76CA03F953]
    // </editor-fold> 
    public void setApPaterno (String val) {
        this.apPaterno = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.4AFC9891-949B-14FF-9B6C-9FB87B1BC8F4]
    // </editor-fold> 
    public int getId () {
        return id;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.2B0EC2F1-B1DB-7DA4-6490-718DACCABEEE]
    // </editor-fold> 
    public void setId (int val) {
        this.id = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.E4D17420-F951-B0E1-674C-1918BFC07720]
    // </editor-fold> 
    public ConexionWebService getConexionWebService () {
        return mConexionWebService;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.15B2AC9B-1ED3-3A0B-DB8E-2D756DFF232F]
    // </editor-fold> 
    public void setConexionWebService (ConexionWebService val) {
        this.mConexionWebService = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.B716E39E-B81B-B099-C2E2-8D979F4AE64E]
    // </editor-fold> 
    public String getNombre () {
        return nombre;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.7CFD720F-6F4F-D24F-782D-BD27A72D1B0B]
    // </editor-fold> 
    public void setNombre (String val) {
        this.nombre = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.82A5F0ED-6026-4673-214C-32213EB2DF20]
    // </editor-fold> 
    public String getRut () {
        return rut;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.A5B27340-CFA3-6A48-DB99-7944F6D1CC05]
    // </editor-fold> 
    public void setRut (String val) {
        this.rut = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.42506CE9-2B9B-3E13-062F-0B4F6DACAD3A]
    // </editor-fold> 
    public String getSecNombre () {
        return secNombre;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.8A3465C8-0BCD-030F-606F-DEDF4FBC7C56]
    // </editor-fold> 
    public void setSecNombre (String val) {
        this.secNombre = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.69F97923-A094-F988-CE6E-805E91474FF3]
    // </editor-fold> 
    public List<Persona> listar (int cantidadRegistrosPorPagina,int paginaActual, String parametros,javax.swing.JLabel labelCantidadTotalDeRegistros,javax.swing.JLabel labelTotalPaginas) throws IOException {
        List<Persona> personas = new ArrayList<>();//Preparamos un array para ingresar a todas las personas consultadas
        this.mConexionWebService = new ConexionWebService();
        String campos = "*";
        String tablas = "persona";
        String clausulaWhere = "";
        String ordenarPorCampo = "IDPERSONA";
        
        int indiceComienzo = (paginaActual-1) * cantidadRegistrosPorPagina;
        int datosPorPagina = cantidadRegistrosPorPagina;
        String datosObtenidos = this.mConexionWebService.solicitarDatosConPaginacion(campos, tablas, clausulaWhere, ordenarPorCampo, indiceComienzo, datosPorPagina);
        JSONObject json = new JSONObject(datosObtenidos);
   
        /**
         * Verificamos si los datos llegaron sin errores
         */
        if(json.getString("Resultado").equals("ERROR")){//Si existe un error en el servidor mostrará el error
            JOptionPane.showMessageDialog(null, "Error: "+json.getString("Error")+".");
        }else{//Si no hay ningún error en el servidor analizamos el JSON
            /**
            * Se crea un array JSON (JSONArray) a partir del parámetro "persona" 
            * del arreglo JSON que se recibió desde PHP.
            */

           JSONArray ar = json.getJSONArray("Registros");
           //Se recorre el arreglo JSON para obtener los registros
           for(int i = 0; i < ar.length(); i++){

               JSONObject fila = ar.getJSONObject(i);//Se obtiene fila por fila del arreglo

               //Se va agregando el contenido al objeto persona
               personas.add(
                       new Persona(
                               Integer.parseInt(fila.get("IDPERSONA").toString()),
                               fila.get("RUT").toString(),
                               fila.get("NOMBRE").toString(),
                               fila.get("SECNOMBRE").toString(),
                               fila.get("APPATERNO").toString(),
                               fila.get("APMATERNO").toString()
                       )
               );
           }

          /**
           * Obtener la cantidad de registros
           */
          int cantidadRegistros = json.getInt("CantidadDeRegistros");
          labelCantidadTotalDeRegistros.setText("Cantidad de Registros : "+String.valueOf(cantidadRegistros));
          labelTotalPaginas.setText(
                                        Integer.toString(
                                                dividirRedondear(cantidadRegistros,cantidadRegistrosPorPagina)
                                        )
          );
        }
       return personas;
    }
    
    public static int dividirRedondear(double a, double b)
    {
          if((a/b)%1==0){//Si el numero no es entero se devuelve el numero entero
              return (int) (a/b);
          }else{//Si el numero es double, se le suma uno para redondearlo
              return (int) ((a/b)+1);
          }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FC9B54B9-B06F-1D2D-32EA-24CD06D506E2]
    // </editor-fold> 
    public boolean ingresar () throws ProtocolException, IOException {
        String sql = "INSERT INTO `persona`" +
                    "(`RUT`,`NOMBRE`,`SECNOMBRE`,`APPATERNO`,`APMATERNO`)" +
                    "VALUES" +
                    "('"+this.rut+"','"+this.nombre+"','"+this.secNombre+"','"+this.apPaterno+"','"+this.apMaterno+"')";
        this.mConexionWebService = new ConexionWebService();
        String datosObtenidos = this.mConexionWebService.ingresar(sql);
        JSONObject json = new JSONObject(datosObtenidos);
        if(json.getString("Resultado").equals("ERROR")){//Si existe un error en el servidor mostrará el error
            JOptionPane.showMessageDialog(null, "Error: "+json.getString("Error")+".");
            return false;
        }else{//Si no hay ningún error en el servidor analizamos el JSON
            return true;
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A06CCC30-4389-0AB9-7BCA-1515ADD2F7A1]
    // </editor-fold> 
    public boolean modificar () {
        String sql = "UPDATE `persona` SET" +
                    " `RUT` = '"+this.rut+"',"+
                    " `NOMBRE` = '"+this.nombre+"',"+
                    " `SECNOMBRE` = '"+this.secNombre+"',"+
                    " `APPATERNO` = '"+this.apPaterno+"',"+
                    " `APMATERNO` = '"+this.apMaterno+"'"+
                    "WHERE `IDPERSONA` = "+this.id;
        this.mConexionWebService = new ConexionWebService();
        String datosObtenidos = null;
        try {
            datosObtenidos = this.mConexionWebService.ingresar(sql);
        } catch (ProtocolException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        JSONObject json = new JSONObject(datosObtenidos);
        if(json.getString("Resultado").equals("ERROR")){//Si existe un error en el servidor mostrará el error
            JOptionPane.showMessageDialog(null, "Error: "+json.getString("Error")+".");
            return false;
        }else{//Si no hay ningún error en el servidor analizamos el JSON
            return true;
        }
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FA933929-003F-7D1D-0D5B-982FAA11C26A]
    // </editor-fold> 
    public boolean eliminar () {
        String sql = "DELETE FROM `persona` WHERE `IDPERSONA` = "+this.id;
        this.mConexionWebService = new ConexionWebService();
        String datosObtenidos = null;
        try {
            datosObtenidos = this.mConexionWebService.ingresar(sql);
        } catch (ProtocolException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
        JSONObject json = new JSONObject(datosObtenidos);
        if(json.getString("Resultado").equals("ERROR")){//Si existe un error en el servidor mostrará el error
            JOptionPane.showMessageDialog(null, "Error: "+json.getString("Error")+".");
            return false;
        }else{//Si no hay ningún error en el servidor analizamos el JSON
            return true;
        }
    }

}

