/*
 * JPanel que muestra información sobre los usuarios.
 */
package PanelesPrincipales;

import ClasesPrincipales.CustomFont;
import ClasesPrincipales.Usuario;
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

public class PanelInfoUsuario extends JPanel{
    
    private JLabel pNombre, pNif;
    private JButton botonBuscar, botonRestablecer, botonListado, botonBInteractiva;
    private JTextField nombre, nif, letranif;
    private JList lista;
    private DefaultListModel modelo;
    private String descripcion = "Cód. Nombre - NIF - Dirección - Teléfono - Email";
    private CustomFont cf;
    
    public PanelInfoUsuario(){
        Usuario u = new Usuario();
        this.setLayout(null);
        initComponents();
        colocarComponentes();
        accionesBotones();
    }
    
    private void initComponents(){
        
        pNombre = new JLabel("Nombre");
        pNif = new JLabel("NIF");
        nombre = new JTextField(10);
        nif = new JTextField(7);
        letranif = new JTextField(2);
        botonBuscar = new JButton("Buscar");
        botonRestablecer = new JButton("Restablecer");
        botonListado = new JButton("Lista de Usuarios");
        botonBInteractiva = new JButton("Búsqueda Interactiva");
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
        
        
        panelBuscar.add(pNombre);
        pNombre.setBounds(30, 20, 80, 20);
        pNombre.setFont(cf.fuente());
        
        panelBuscar.add(nombre);
        nombre.setBounds(100, 20, 100, 20);
        nombre.setFont(cf.fuente());
        
        panelBuscar.add(pNif);
        pNif.setBounds(30, 50, 80, 20);
        pNif.setFont(cf.fuente());
        
        panelBuscar.add(nif);
        nif.setBounds(100, 50, 80, 20);
        nif.setFont(cf.fuente());
        
        panelBuscar.add(letranif);
        letranif.setBounds(180, 50, 20, 20);
        letranif.setFont(cf.fuente());
        
        panelBuscar.add(botonBuscar);
        botonBuscar.setBounds(30, 75, 150, 25);
        botonBuscar.setFont(cf.fuentenegrita());
        
        panelBuscar.add(botonRestablecer);
        botonRestablecer.setBounds(30, 105, 150, 25);
        botonRestablecer.setFont(cf.fuentenegrita());
        
        add(botonListado);
        botonListado.setFont(cf.fuentenegrita());
        botonListado.setBounds(380, 40, 180, 25);

        add(botonBInteractiva);
        botonBInteractiva.setFont(cf.fuentenegrita());
        botonBInteractiva.setBounds(380, 70, 180, 25);
        
    }
    
    private String getNombre(){
        return nombre.getText();
    }
    
    private String getNif(){
        return nif.getText() + letranif.getText();
    }
    
    private void restablecerCampos(){
        nombre.setText("");
        nif.setText("");
        letranif.setText("");
    }

    private void accionesBotones() {

        botonBuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try {
                    botonBuscar();
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo no encontrado");
                } catch (IOException ex) {
                    System.out.println("Error de entrada/salida");
                }
            }
        });
        

        botonRestablecer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                restablecerCampos();
            }
        });
        
        
        botonListado.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try {
                    listarUsuarios();
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo no encontrado");
                } catch (IOException ex) {
                    System.out.println("Error de entrada/salida");
                }
            }
        });

        botonBInteractiva.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                busquedaInteractiva();
            }

        });
        
    }
    
    // Crea la ventana en laque se muestra una lista de usuarios.
    private void ventanaListado(DefaultListModel modelo, String descripcion, boolean libros){
        FrameListado fl = new FrameListado(modelo, descripcion, libros, false, false);
        fl.setVisible(true);
    }
        
        
    // Crea una lista de usuarios.
    private void listarUsuarios() throws FileNotFoundException, IOException {
        modelo.clear();
        Usuario u = new Usuario();
        if(Usuario.totalUsuarios() != 0) {
            for (int i = 0; i < Usuario.totalUsuarios(); i++) {
                u.read(i);
                modelo.addElement(u.toString());
            }
            ventanaListado(modelo, descripcion, false);
        } else {
            ventanaEmergente("No hay libros dados de alta");
        }
    }
    
    private void ventanaEmergente(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
    
    private boolean nombreVacio(){
        return nombre.getText().equals("");
    }
    // Busca un usuario por nombre o NIF.
    private Usuario buscarUsuario() throws FileNotFoundException, IOException {

        Usuario u = new Usuario();

        if (!nombreVacio()) {
            for (int i = 0; i < Usuario.totalUsuarios(); i++) {
                u.read(i);
                if (u.getNombre().equals(getNombre())) {
                    return u;
                }
            }

        } else {
            for (int i = 0; i < Usuario.totalUsuarios(); i++) {
                u.read(i);
                if (u.getNif().equals(getNif())) {
                    return u;
                }
            }
        }
        return null;

    }
    
    private void botonBuscar() throws FileNotFoundException, IOException {
        Usuario u = buscarUsuario();
        if(Usuario.totalUsuarios()!= 0) {
            restablecerCampos();
            if (u == null) {
                ventanaEmergente("El usuario no existe");
            } else {
                infoUsuario(u);
            }
        }else{
            ventanaEmergente("No hay usuarios dados de alta");
        }
    }

    private void infoUsuario(Usuario u) {
        PanelesInfo.FramePrincipal fp = new PanelesInfo.FramePrincipal(u, false);
        fp.setVisible(true);
    }
    // Llama a la busqueda interactiva de usuarios.
    private void busquedaInteractiva() {
        
        if(Usuario.totalUsuarios() == 0) {
            ventanaEmergente("No hay usuarios dados de alta");
        } else {
            PanelesInteractivos.FramePrincipal fp = new PanelesInteractivos.FramePrincipal(false, false);
            fp.setVisible(true);
        }
        
    }
}
