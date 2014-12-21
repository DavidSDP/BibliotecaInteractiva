/*
 * Panel desplegable para buscar información sobre un determinado libro.
 */
package PanelesPrincipales;

import ClasesPrincipales.CustomFont;
import ClasesPrincipales.Libro;
import GUI.FrameListado;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PanelInfoLibro extends JPanel{
    
    private JLabel Titulo;
    private JTextField casTitulo;
    private JButton botonBuscar, botonRestablecer, botonLista, botonBusqueda;
    private JList lista;
    private DefaultListModel modelo;
    private String descripcion = "Cód. Título - Autor - Editorial - Ubicación";
    private CustomFont cf;
    
    public PanelInfoLibro(){
        
        Libro l = new Libro();
        this.setLayout(null);
        initComponents();
        colocarComponentes();
        accionesBotones();
    }
    
    
    private void initComponents(){
        
        Titulo = new JLabel("Título");
        casTitulo = new JTextField(10);
        botonBuscar = new JButton("Buscar");
        botonRestablecer = new JButton("Restablecer");
        botonLista = new JButton("Lista de libros");
        botonBusqueda = new JButton("Búsqueda Interactiva");
        lista = new JList();
        modelo = new DefaultListModel();
        lista.setModel(modelo);
        cf = new CustomFont();
        
    }
    
    private void colocarComponentes(){
        
        Border blackline;

        blackline = BorderFactory.createLineBorder(Color.black);
        TitledBorder bordeBuscar = BorderFactory.createTitledBorder(blackline, "Buscar");
        bordeBuscar.setTitleJustification(TitledBorder.LEFT);
        bordeBuscar.setTitleFont(cf.fuentenegrita());

        JPanel panelBuscar = new JPanel();
        panelBuscar.setBorder(bordeBuscar);
        
        add(panelBuscar);
        panelBuscar.setLayout(null);
        panelBuscar.setBounds(20, 10, 300, 140);
        
        panelBuscar.add(Titulo);
        panelBuscar.add(casTitulo);
        Titulo.setBounds(30, 30, 50, 20);
        casTitulo.setBounds(80, 30, 90, 20);
        Titulo.setFont(cf.fuente());
        casTitulo.setFont(cf.fuente());
        
        panelBuscar.add(botonBuscar);
        panelBuscar.add(botonRestablecer);
        botonBuscar.setBounds(30, 70, 150, 25);
        botonRestablecer.setBounds(30, 100, 150, 25);
        botonBuscar.setFont(cf.fuentenegrita());
        botonRestablecer.setFont(cf.fuentenegrita());

        add(botonLista);
        botonLista.setFont(cf.fuentenegrita());
        botonLista.setBounds(380, 40, 180, 25);

        add(botonBusqueda);
        botonBusqueda.setFont(cf.fuentenegrita());
        botonBusqueda.setBounds(380, 70, 180, 25);

        
    }
    
    private void accionesBotones(){
        
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    buscarLibro(getTitulo());
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo no encontrado");   
                } catch (IOException ex) {
                    System.out.println("Error de entrada/salida");       
                }
            }
        });
        
        botonRestablecer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                restablecerCampos();
            }
        });
        
        botonLista.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                listarLibros();
            }
        });
        
        botonBusqueda.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                busquedaLibros();
            }
        });
    }
    
    private String getTitulo(){
        return casTitulo.getText();
    }
    
    private void restablecerCampos(){
        casTitulo.setText("");
    }
    // Busca el libro por el título que se pasa por parámetro, si hay más de uno
    // te muestra todos los encontrados, si no existe te muestra una ventana
    // emergente con el mensaje: "El libro no existe".
    private void buscarLibro(String titulo) throws FileNotFoundException, IOException {
        Libro l = new Libro();
        boolean encontrado = false;
        boolean masdeuno = false;
        if(getTitulo().isEmpty()) {
            ventanaEmergente("Inserte un título a buscar");
        } else {
            for (int i = 0; i < Libro.totalLibros(); i++) {
                l.read(i);
                if (l.getTitulo().equals(titulo)) {
                    if (encontrado == true) {
                        masdeuno = true;
                    }
                    encontrado = true;
                }
            }
            if (encontrado == false) {
                ventanaEmergente("El libro no existe");
            } else {
                if (masdeuno == true) {

                    modelo.clear();

                    for (int i = 0; i < Libro.totalLibros(); i++) {
                        l = new Libro();
                            l.read(i);
                        if (l.getTitulo().equals(titulo)) {
                            modelo.addElement(l.toString());
                        }
                    }
                    ventanaListado(modelo, descripcion, true);

                } else {
                    l = new Libro();
                    for (int i=0; i< Libro.totalLibros(); i++){
                        l.read(i);
                        if(l.getTitulo().equals(titulo)){
                            infoLibro(l);
                        }
                    }
                }
            }
        }
        restablecerCampos();

    }
    // Crea una lista de todos los libros guardados.
    private void listarLibros() {
        modelo.clear();
        Libro l = new Libro();
        if(Libro.totalLibros()!=0){
        for (int i = 0; i < Libro.totalLibros(); i++) {
                try {
                    l.read(i);
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo no encontrado");
                } catch (IOException ex) {
                    System.out.println("Error de lectura");
                }
                modelo.addElement(l.toString());
            }
            ventanaListado(modelo, descripcion, true);
        } else {
            ventanaEmergente("No hay libros dados de alta");
        }
    }
    // Venta en la que se muestra una lista de libros.
    private void ventanaListado(DefaultListModel modelo, String descripcion, boolean libros){
        
        FrameListado fl = new FrameListado(modelo, descripcion, libros, false, false);
        fl.setVisible(true);
        
    }
    
    private void ventanaEmergente(String s){
        JOptionPane.showMessageDialog(null, s);
    }

    private void infoLibro(Libro l) {
        
        PanelesInfo.FramePrincipal fp = new PanelesInfo.FramePrincipal(l, true);
        fp.setVisible(true);
        
    }
    
    private void busquedaLibros(){
        if(Libro.totalLibros()==0){
            ventanaEmergente("No hay libros dados de alta");
        }else{
            PanelesInteractivos.FramePrincipal fp = new PanelesInteractivos.FramePrincipal(true, false);
            fp.setVisible(true);
        }
    }

}
