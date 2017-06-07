/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplowebservice;

import de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaStandardLookAndFeel;
import java.io.IOException;
import javax.swing.UIManager;
import vista.frmPersona;

/**
 *
 * @author Roy
 */
public class EjemploWebService {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        try{
          UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
        } 
        catch (Exception e) 
        {
          e.printStackTrace();
        }
        // TODO code application logic here
        frmPersona programa = new frmPersona();
        programa.setVisible(true);
        
    }
    
}
