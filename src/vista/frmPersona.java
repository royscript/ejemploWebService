/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import algoritmos.genericos.Tabla;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Persona;
import algoritmos.genericos.Ventana;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author Roy
 */
public final class frmPersona extends javax.swing.JFrame {
    /**
     * Variables
     */
    private List<Persona> personas;
    private final Persona persona = new Persona();
    private int pagInicial = 0;
    Tabla tabla = new Tabla();
    
    /**
     * Creates new form frmPersona
     * @throws java.io.IOException
     */
    public frmPersona() throws IOException {
        initComponents();
        personalizarGrilla();
        Ventana ventana = new Ventana();
        ventana.soloNumeros(this.txtPaginaActual);
        //------------Localizacion ventana------------
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Dimension tamanoPantalla = miPantalla.getScreenSize();
        int alturaPantalla = tamanoPantalla.height;
        int anchoPantalla = tamanoPantalla.width;
        setLocation(anchoPantalla/4, alturaPantalla/4);
        //-----------/Localizacion ventana------------
        ventana.botonAgregar(botonAgregar);
        ventana.botonExcel(this.botonExtraerExcel);
        cargar_lista_de_personas();
    }
    
    /**
     * Métodos
     */
    private void personalizarGrilla() {

        // Esta lista contiene los nombres que se mostrarán en el encabezado de cada columna de la grilla
        String[] columnas = new String[]{
            "Id",
            "Rut",
            "Nombres",
            "SecNombre",
            "ApPaterno",
            "ApMaterno",
            "",
            ""};

        // Estos son los tipos de datos de cada columna de la lista
        final Class[] tiposColumnas = new Class[]{
            java.lang.Integer.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            JLabel.class, // <- noten que aquí se especifica que la última columna es un botón
            JLabel.class
        };
        //Ejecutamos métodos para inicializar la tabla 
        tabla.generarTablaDao(grillaPersona, columnas, tiposColumnas);
        //Agregamos el evento que quede a la escucha si se hace click en alguna cabecera de columna para ordenar ascendente o descendente
        this.grillaPersona.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int columna = grillaPersona.columnAtPoint(e.getPoint());
                //JOptionPane.showMessageDialog(null, "Isiste click en una columna "+columna);
                if(columna==0){//Si hizo click en la cabecera de la columna 0 sucederá lo siguiente 
                    
                }else if(columna==1){//Si hizo click en la cabecera de la columna 1 sucederá lo siguiente 
                    
                }else if(columna==2){//Si hizo click en la cabecera de la columna 2 sucederá lo siguiente 
                    
                }else if(columna==3){//Si hizo click en la cabecera de la columna 3 sucederá lo siguiente 
                    
                }else if(columna==4){//Si hizo click en la cabecera de la columna 4 sucederá lo siguiente 
                    
                }else if(columna==5){//Si hizo click en la cabecera de la columna 5 sucederá lo siguiente 
                    
                }
            }
        });
        
        
        
        /**
         * Por último, agregamos un listener que nos permita saber cuando fue pulsada la celda que contiene el botón.
         * Noten que estamos capturando el clic sobre JTable, no el clic sobre el JButton. Esto también implica que en 
         * lugar de poner un botón en la celda, simplemente pudimos definir un CellRenderer que hiciera parecer que la 
         * celda contiene un botón. Es posible capturar el clic del botón, pero a mi parecer el efecto es el mismo y 
         * hacerlo de esta forma es más "simple"
         */
        
        
        this.grillaPersona.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int cantidadDeColumnas = 0;
                cantidadDeColumnas = grillaPersona.getColumnCount();
                int fila = grillaPersona.rowAtPoint(e.getPoint());
                int columna = grillaPersona.columnAtPoint(e.getPoint());
                if(columna==(cantidadDeColumnas-2)){//La ante penúltima columna corresponde a editar
                    int id = (Integer) grillaPersona.getModel().getValueAt(fila, 0);
                    String rut = (String) grillaPersona.getModel().getValueAt(fila, 1);
                    String nombres = (String) grillaPersona.getModel().getValueAt(fila, 2);
                    String secNombre = (String) grillaPersona.getModel().getValueAt(fila, 3);
                    String apPaterno = (String) grillaPersona.getModel().getValueAt(fila, 4);
                    String apMaterno = (String) grillaPersona.getModel().getValueAt(fila, 5);
                    //--------------------------Modificar-----------------------------------
                    JDialogPersonaModificar popPupModificar = new JDialogPersonaModificar(frmPersona.this,true,id,rut,nombres,secNombre,apPaterno,apMaterno);
                    popPupModificar.setVisible(true);
                    popPupModificar.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//Permite que se cierre solo la ventana y no el programa
                    //este evento espera a que el jframe abierto se cierre para hacer los siguientes eventos
                    popPupModificar.addWindowListener(new WindowAdapter() {
                                @Override
                                public void windowClosed(WindowEvent e) {
                                    try {
                                        //volver a cargar el listado de personas
                                        cargar_lista_de_personas();
                                    } catch (IOException ex) {
                                        Logger.getLogger(frmPersona.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                    });
                    //--------------------------/Modificar-----------------------------------
                }
                if(columna==(cantidadDeColumnas-1)){//La última columna corresponde a eliminar
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < grillaPersona.getModel().getColumnCount()-2; i++) {//Se le resta 2 para que no tome las columnas de los iconos modificar y eliminar
                        if (!grillaPersona.getModel().getColumnClass(i).equals(JButton.class)) {
                            sb.append("\n").append(grillaPersona.getModel().getColumnName(i)).append(": ").append(grillaPersona.getModel().getValueAt(fila, i));
                        }
                    }
                    int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el siguiente registro? " + fila + sb.toString(), "¿Está seguro?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(respuesta==0){
                        Persona persona = new Persona((Integer) grillaPersona.getModel().getValueAt(fila, 0));
                        persona.eliminar();
                        try {
                            cargar_lista_de_personas();
                        } catch (IOException ex) {
                            Logger.getLogger(frmPersona.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });
    }
    
    
    void cargar_lista_de_personas() throws IOException{
        int cantidadRegistrosPorPagina = Integer.parseInt((String) this.comboBoxCantidadRegistrosPorPagina.getSelectedItem());
        //Si se abre por primera vez, y el campo de texto correspondiente al número
        // de página esta vacio, se mostrará desde la página 1
        if(this.txtPaginaActual.getText().equals("")){
            this.pagInicial = 1;
        }else{
            this.pagInicial = Integer.parseInt(this.txtPaginaActual.getText());
        }
        this.txtPaginaActual.setText(Integer.toString(this.pagInicial));
       
        this.personas = this.persona.listar(cantidadRegistrosPorPagina, this.pagInicial,this.txtBuscar.getText(),this.labelCantidadTotalDeRegistros, this.labelTotalPaginas);
        DefaultTableModel dtm = (DefaultTableModel) grillaPersona.getModel();
        dtm.setRowCount(0);
        if(personas!=null){//Si el objeto no es null imprimirá los valores
            for (Persona persona : personas) {
                dtm.addRow(new Object[]{
                    persona.getId(),
                    persona.getRut(),
                    persona.getNombre(),
                    persona.getSecNombre(),
                    persona.getApPaterno(),
                    persona.getApMaterno(),
                    new JLabel(new ImageIcon(getClass().getResource("/imagenes/edit.png"))),
                    new JLabel(new ImageIcon(getClass().getResource("/imagenes/delete.png")))
                });
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        grillaPersona = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();
        botonExtraerExcel = new javax.swing.JButton();
        labelCantidadTotalDeRegistros = new javax.swing.JLabel();
        botonIr = new javax.swing.JButton();
        labelTotalPaginas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPaginaActual = new javax.swing.JTextField();
        botonSiguiente = new javax.swing.JButton();
        botonAnterior = new javax.swing.JButton();
        comboBoxCantidadRegistrosPorPagina = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Persona");
        setResizable(false);

        grillaPersona = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        grillaPersona.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        grillaPersona.setDoubleBuffered(true);
        jScrollPane1.setViewportView(grillaPersona);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Parametros de Búsqueda"));

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(botonBuscar)
                .addGap(30, 30, 30)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(391, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBuscar)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonExtraerExcel.setText("Excel");

        labelCantidadTotalDeRegistros.setText("Cantidad de Registros :");

        botonIr.setText("Ir");
        botonIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIrActionPerformed(evt);
            }
        });

        labelTotalPaginas.setText("XXX");

        jLabel1.setText("/");

        txtPaginaActual.setText("1");
        txtPaginaActual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaginaActualKeyTyped(evt);
            }
        });

        botonSiguiente.setText("Siguiente");
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSiguienteActionPerformed(evt);
            }
        });

        botonAnterior.setText("Anterior");
        botonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnteriorActionPerformed(evt);
            }
        });

        comboBoxCantidadRegistrosPorPagina.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "20", "40" }));
        comboBoxCantidadRegistrosPorPagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCantidadRegistrosPorPaginaActionPerformed(evt);
            }
        });

        jLabel2.setText("Registros por página:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxCantidadRegistrosPorPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAnterior)
                        .addGap(18, 18, 18)
                        .addComponent(botonSiguiente)
                        .addGap(46, 46, 46)
                        .addComponent(txtPaginaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTotalPaginas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonIr)
                        .addGap(29, 29, 29)
                        .addComponent(labelCantidadTotalDeRegistros)
                        .addGap(56, 56, 56))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(548, 548, 548)
                                .addComponent(botonExtraerExcel)
                                .addGap(18, 18, 18)
                                .addComponent(botonAgregar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(32, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonExtraerExcel))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPaginaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotalPaginas)
                    .addComponent(botonIr)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxCantidadRegistrosPorPagina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonSiguiente)
                    .addComponent(botonAnterior)
                    .addComponent(labelCantidadTotalDeRegistros))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        try {
            cargar_lista_de_personas();
        } catch (IOException ex) {
            Logger.getLogger(frmPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void txtPaginaActualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaginaActualKeyTyped
        
    }//GEN-LAST:event_txtPaginaActualKeyTyped

    private void comboBoxCantidadRegistrosPorPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCantidadRegistrosPorPaginaActionPerformed
        this.pagInicial = 0;
        this.txtPaginaActual.setText("1");
        try {
            cargar_lista_de_personas();
        } catch (IOException ex) {
            Logger.getLogger(frmPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_comboBoxCantidadRegistrosPorPaginaActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        JDialogPersonaCrear popPup = new JDialogPersonaCrear(this,true);
        popPup.setVisible(true);
        popPup.setDefaultCloseOperation(DISPOSE_ON_CLOSE);//Permite que se cierre solo la ventana y no el programa
        //este evento espera a que el jframe abierto se cierre para hacer los siguientes eventos
        popPup.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        try {
                            //volver a cargar el listado de personas
                            cargar_lista_de_personas();
                        } catch (IOException ex) {
                            Logger.getLogger(frmPersona.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
        });
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIrActionPerformed
        if(Integer.parseInt(this.txtPaginaActual.getText())>Integer.parseInt(this.labelTotalPaginas.getText())){
            this.txtPaginaActual.setText(this.labelTotalPaginas.getText());   
            try {
                cargar_lista_de_personas();
            } catch (IOException ex) {
                Logger.getLogger(frmPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                cargar_lista_de_personas();
            } catch (IOException ex) {
                Logger.getLogger(frmPersona.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botonIrActionPerformed

    private void botonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSiguienteActionPerformed
        tabla.BotonSiguiente(txtPaginaActual, labelTotalPaginas);
        try {
            cargar_lista_de_personas();
        } catch (IOException ex) {
            Logger.getLogger(frmPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonSiguienteActionPerformed

    private void botonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnteriorActionPerformed
         tabla.BotonAtras(txtPaginaActual, labelTotalPaginas);
        try {
            cargar_lista_de_personas();
        } catch (IOException ex) {
            Logger.getLogger(frmPersona.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonAnteriorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmPersona().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(frmPersona.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonAnterior;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonExtraerExcel;
    private javax.swing.JButton botonIr;
    private javax.swing.JButton botonSiguiente;
    private javax.swing.JComboBox<String> comboBoxCantidadRegistrosPorPagina;
    private javax.swing.JTable grillaPersona;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCantidadTotalDeRegistros;
    private javax.swing.JLabel labelTotalPaginas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtPaginaActual;
    // End of variables declaration//GEN-END:variables
}
