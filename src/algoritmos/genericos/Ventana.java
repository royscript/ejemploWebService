/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.genericos;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 *
 * @author Roy
 */
public class Ventana extends JFrame{
    
    public String familiaLetra = "Segoe UI Semilight";
    public int tipoLetra = 1;
    public int tamanoLetra = 16;

    public Ventana() {
    }
    
    public void soloNumeros(javax.swing.JTextField a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isLetter(c)){
                    e.consume();
                }
            }
        });
    }
    public void soloNumerosPaginador(javax.swing.JTextField a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isLetter(c)){
                    e.consume();
                }else{
                    Integer.parseInt(a.getText());
                }
            }
        });
    }
    public void soloLetras(javax.swing.JTextField a){
        a.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                if(Character.isDigit(c)){
                    e.consume();
                }
            }
        });
    }
    public void iniciarVentanaMediana(){
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = miPantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        setSize(anchoPantalla/2, alturaPantalla/2);
        setLocation(anchoPantalla/4, alturaPantalla/4);
    }
    public void botonAgregar(javax.swing.JButton botonAgregar){
        //botonAgregar.setBackground(new java.awt.Color(51, 153, 255));
        //botonAgregar.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png")));
        botonAgregar.setText("Agregar nuevo registro");
        //botonAgregar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        //botonAgregar.setFont(new Font(this.familiaLetra, this.tipoLetra, this.tamanoLetra));

    }
    public void botonExcel(javax.swing.JButton botonExcel){
        //botonExcel.setBackground(new java.awt.Color(51, 153, 255));
        //botonExcel.setForeground(new java.awt.Color(255, 255, 255));
        botonExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exportar_a_excel.png")));
        botonExcel.setText("Exportar a excel");
        //botonExcel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        //botonExcel.setFont(new Font(this.familiaLetra, this.tipoLetra, this.tamanoLetra));

    }
    public void botonGuardar(javax.swing.JButton botonGuardar){
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_boton_guardar.png")));
        botonGuardar.setText("Guardar");

    }
    
    public void botonModificar(javax.swing.JButton botonModificar){
        botonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icono_boton_modificar.png")));
        botonModificar.setText("Modificar");

    }
}
