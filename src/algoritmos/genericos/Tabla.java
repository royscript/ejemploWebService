/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos.genericos;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Roy
 */
public class Tabla {
    
    public String familiaLetra = "Segoe UI Semilight";
    public int tipoLetra = 1;
    public int tamanoLetra = 16;
    
    public Tabla() {
    }
    
    public void generarTablaDao(javax.swing.JTable tabla, String[] columnas,final Class[] tiposColumnas){
        //COn el siguiente codigo activamos que se puedan mostrar imagenes en el JTable por medio de JLabel
        tabla.setDefaultRenderer(Object.class, new ImagenTabla());
        //Ordena tabla de forma automática sorting
        //tabla.setAutoCreateRowSorter(true);
        // Defino el TableModel y le indico los datos y nombres de columnas
        tabla.setModel(new javax.swing.table.DefaultTableModel(
                null,
                columnas) {
            // Esta variable nos permite conocer de antemano los tipos de datos de cada columna, dentro del TableModel
            Class[] tipos = tiposColumnas;

            @Override
            public Class getColumnClass(int columnIndex) {
                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                // observen que estamos retornando la clase que definimos de antemano.
                return tipos[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                return !(this.getColumnClass(column).equals(JButton.class));
            }
        });
        // El objetivo de la siguiente línea es indicar el CellRenderer que será utilizado para dibujar el botón
         tabla.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                /**
                 * Observen que todo lo que hacemos en éste método es retornar el objeto que se va a dibujar en la 
                 * celda. Esto significa que se dibujará en la celda el objeto que devuelva el TableModel. También 
                 * significa que este renderer nos permitiría dibujar cualquier objeto gráfico en la grilla, pues 
                 * retorna el objeto tal y como lo recibe.
                 */
                return (Component) objeto;
            }

           // @Override
            //public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //}
        });
         
         
         //---------------------------Agregar estilo a la tabla----------------------
         
         //-----Cabecera----------
         // cambia el tipo de letra del encabezado de la tabla
        //tabla.getTableHeader().setFont(new Font(this.familiaLetra, this.tipoLetra, this.tamanoLetra)); 
        // cambia el fondo del encabezado de la tabla
        //tabla.getTableHeader().setBackground(new java.awt.Color(51, 153, 255));
        //tabla.getTableHeader().setForeground(new java.awt.Color(255, 255, 255));
        // cambia el color de la letra del encabezado de la tabla
       
        //------------------------
        
        //------Body--------------
        // cambiar la fuente de los datos de la tabla
        //tabla.setFont(new Font(this.familiaLetra, this.tipoLetra, this.tamanoLetra));
        //tabla.setDefaultRenderer(Object.class, new cambiarColorFilasTabla());
        //------------------------
         SeleccionadorDeColumnasJTable tcs = new SeleccionadorDeColumnasJTable();
         tcs.install(tabla);
         //-----------Disminuir el tamaño de las ultimas columnas (editar y eliminar)---------
        int cantidadDeColumnas = 0;
        cantidadDeColumnas = tabla.getColumnCount();
        tabla.getColumnModel().getColumn(cantidadDeColumnas-2).setMaxWidth(20);
        tabla.getColumnModel().getColumn(cantidadDeColumnas-1).setMaxWidth(20);
        //-----------------------------------------------------------------------------------
    }
    public void BotonSiguiente(javax.swing.JTextField txtPaginaActual,javax.swing.JLabel labelTotalPaginas){
        int paginaActual = Integer.parseInt(txtPaginaActual.getText());
        int totalPaginas = Integer.parseInt(labelTotalPaginas.getText());
        if(paginaActual>=totalPaginas){
            //Si el numero del paginador es superior a la cantidad total de paginas se le corrige al numeor maximo de paginas
            txtPaginaActual.setText(labelTotalPaginas.getText());
        }else{
            txtPaginaActual.setText(String.valueOf(paginaActual+1));
        }
    }
    public void BotonAtras(javax.swing.JTextField txtPaginaActual,javax.swing.JLabel labelTotalPaginas){
        int paginaActual = Integer.parseInt(txtPaginaActual.getText());
        int totalPaginas = Integer.parseInt(labelTotalPaginas.getText());
        if(paginaActual>totalPaginas){
            //Si el numero del paginador es superior a la cantidad total de paginas se le corrige al numeor maximo de paginas
            txtPaginaActual.setText(labelTotalPaginas.getText());
        }else if((paginaActual-1)<=0){
            txtPaginaActual.setText("1");
        }else{
            txtPaginaActual.setText(String.valueOf(paginaActual-1));
        }
    }
}
