/*
 * Ventana principal del programa (JFrame principal).
 */
package GUI;

import ClasesPrincipales.CustomFont;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class PanelMultiple extends JFrame {

    private JPanel opcPanel = new JPanel();
    private JPanel extPanel = null;
    private JButton cerrarPanel;
    private JButton botonAltaLibro, botonInfoLibro, botonAltaUsuario,
            botonInfoUsuario, botonAltaPrestamo, botonInfoPrestamo;
    private String imagenAltaLibro = "images/panelmultiple/añadirlibro.png";
    private String imagenInfoLibro = "images/panelmultiple/infolibro.png";
    private String imagenAltaUsuario = "images/panelmultiple/añadirusuario.png";
    private String imagenInfoUsuario = "images/panelmultiple/infousuario.png";
    private String imagenAltaPrestamo = "images/panelmultiple/añadirprestamo.png";
    private String imagenInfoPrestamo = "images/panelmultiple/infoprestamo.png";
    private CustomFont cf;
    
    public PanelMultiple() {

        super("Fundación Lea un Libro");
        super.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        dimensionarFrame();
        inicializarOpciones();
        asignarImagenes();
        inicializarBotones();        
        accionesBotones();
        this.setResizable(false);
        
    }

    private void inicializarOpciones() {
        opcPanel = new JPanel();
        opcPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        opcPanel.setSize(700, 150);
        opcPanel.setLayout(null);
        
        this.add(opcPanel);

        botonAltaLibro = new JButton();
        botonInfoLibro = new JButton();
        botonAltaUsuario = new JButton();
        botonInfoUsuario = new JButton();
        botonAltaPrestamo = new JButton();
        botonInfoPrestamo = new JButton();
        opcPanel.add(botonAltaLibro);
        opcPanel.add(botonInfoLibro);
        opcPanel.add(botonAltaUsuario);
        opcPanel.add(botonInfoUsuario);
        opcPanel.add(botonAltaPrestamo);
        opcPanel.add(botonInfoPrestamo);
        botonAltaLibro.setBounds(10, 10, 100, 100);
        botonInfoLibro.setBounds(130, 10, 100, 100);
        botonAltaUsuario.setBounds(250, 10, 100, 100);
        botonInfoUsuario.setBounds(370, 10, 100, 100);
        botonAltaPrestamo.setBounds(490, 10, 100, 100);
        botonInfoPrestamo.setBounds(610, 10, 100, 100);
        cf = new CustomFont();
        opcPanel.setVisible(true);
    }
    // Dimensión del JFrame principal.
    private void dimensionarFrame() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        this.setLocation(dim.width / 2 - 365, dim.height / 2 - 200);
        this.setSize(730, 150);
        this.setVisible(true);
    }
    // Dimensiones de los JPanels desplegables.
    private void redimensionarFrame(boolean agrandar) {
        if (agrandar) {
            this.setSize(730, 350);
        } else {
            this.setSize(730, 150);
        }
    }
    
    private void accionesBotones() {

        botonAltaLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonAltaLibro();
            }
        });

        botonInfoLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonInfoLibro();
            }

        });

        botonAltaUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonAltaUsuario();
            }

        });

        botonInfoUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonInfoUsuario();
            }

        });

        botonAltaPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonAltaPrestamo();
            }

        });

        botonInfoPrestamo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonInfoPrestamo();
            }

        });

        cerrarPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cerrarPanel();
            }
        });

    }
    // Cierra el JPanel desplegado y vuelve a la ventana principal (activa los 
    // botones del la ventana principal).
    private void cerrarPanel() {
        extPanel.setVisible(false);
        extPanel = null;
        paralizarBotones(false);
        redimensionarFrame(false);
    }
    
    private void inicializarBotones() {
        cerrarPanel = new JButton("Cerrar");
        cerrarPanel.setFont(cf.fuentenegrita());
    }
    // Desactiva los botones de JFrame principal.
    private void paralizarBotones(boolean paralizar) {
        if (paralizar) {
            botonAltaLibro.setEnabled(false);
            botonInfoLibro.setEnabled(false);
            botonAltaUsuario.setEnabled(false);
            botonInfoUsuario.setEnabled(false);
            botonAltaPrestamo.setEnabled(false);
            botonInfoPrestamo.setEnabled(false);
        } else {
            botonAltaLibro.setEnabled(true);
            botonInfoLibro.setEnabled(true);
            botonAltaUsuario.setEnabled(true);
            botonInfoUsuario.setEnabled(true);
            botonAltaPrestamo.setEnabled(true);
            botonInfoPrestamo.setEnabled(true);
        }
    }
    // Asigna un icono a cada botón del JFrame.
    private void asignarImagenes(){
        
        botonAltaLibro.setIcon(new ImageIcon(imagenAltaLibro));
        botonInfoLibro.setIcon(new ImageIcon(imagenInfoLibro));
        botonAltaUsuario.setIcon(new ImageIcon(imagenAltaUsuario));
        botonInfoUsuario.setIcon(new ImageIcon(imagenInfoUsuario));
        botonAltaPrestamo.setIcon(new ImageIcon(imagenAltaPrestamo));
        botonInfoPrestamo.setIcon(new ImageIcon(imagenInfoPrestamo));
        
    }
    /*
     * Como cada botóndespliega un JPanel diferente los siguientes métodos lo
     * que hacen es gestionar los JPanel que hay que desplegar para cada botón.
     */
    private void botonAltaLibro() {

        redimensionarFrame(true);
        paralizarBotones(true);
        extPanel = new PanelesPrincipales.PanelAltaLibro();
        extPanel.add(cerrarPanel);
        cerrarPanel.setBounds(615, 120, 80, 25);
        
        extPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        extPanel.setVisible(true);
        add(extPanel);
        
    }
    
    private void botonInfoLibro() {

        redimensionarFrame(true);
        paralizarBotones(true);
        extPanel = new PanelesPrincipales.PanelInfoLibro();
        extPanel.add(cerrarPanel);
        cerrarPanel.setBounds(615, 120, 80, 25);

        extPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        extPanel.setVisible(true);
        add(extPanel);
    }
    
    private void botonAltaUsuario() {

        redimensionarFrame(true);
        paralizarBotones(true);
        extPanel = new PanelesPrincipales.PanelAltaUsuario();
        extPanel.add(cerrarPanel);
        cerrarPanel.setBounds(615, 120, 80, 25);

        extPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        extPanel.setVisible(true);
        add(extPanel);
        
    }
    
    private void botonInfoUsuario() {

        redimensionarFrame(true);
        paralizarBotones(true);
        extPanel = new PanelesPrincipales.PanelInfoUsuario();
        extPanel.add(cerrarPanel);
        cerrarPanel.setBounds(615, 120, 80, 25);

        extPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        extPanel.setVisible(true);
        add(extPanel);
    }
    
    private void botonAltaPrestamo() {

        redimensionarFrame(true);
        paralizarBotones(true);
        extPanel = new PanelesPrincipales.PanelAltaPrestamo();
        extPanel.add(cerrarPanel);
        cerrarPanel.setBounds(615, 120, 80, 25);

        extPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        extPanel.setVisible(true);
        add(extPanel);
        
    }
    
    private void botonInfoPrestamo() {

        redimensionarFrame(true);
        paralizarBotones(true);
        extPanel = new PanelesPrincipales.PanelInfoPrestamo();
        extPanel.add(cerrarPanel);
        cerrarPanel.setBounds(615, 120, 80, 25);

        extPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        extPanel.setVisible(true);
        add(extPanel);
    }   
    
}
