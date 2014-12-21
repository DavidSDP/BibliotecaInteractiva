/*
 * Panel de búsqueda interactiva de libros (busqueda por portada).
 * Este panel muestra la portada de todos los libros guardados y te permite
 * seleccionarlos.
 * Busca todos los libros, les asigna una imagen predeterminada a cada uno en 
 * el momento del alta y si seleccionas el libro te muestra la información sobre
 * este.
 */
package PanelesInteractivos;

import ClasesPrincipales.CustomFont;
import ClasesPrincipales.Libro;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BusquedaLibros extends JPanel{
    
    private Libro lib1, lib2, lib3;
    private JButton sel1, sel2, sel3;
    private JLabel imagen1, imagen2, imagen3;
    private String black = "images/black.jpg";
    private int codigo;
    private boolean especial;
    private CustomFont cf;
    // Muestra los libros de tres en tres.
    public BusquedaLibros(Libro lib1, Libro lib2, Libro lib3, boolean especial) {
        this.especial = especial;
        this.lib1 = lib1;
        this.lib2 = lib2;
        this.lib3 = lib3;
        
        setLayout(null);
        initComponents();
        colocarComponentes();
        asignarImagenes();
        accionesBotones();
        
    }

    public void activarBotones() {

        this.sel1.setEnabled(true);
        this.sel2.setEnabled(true);
        this.sel3.setEnabled(true);
    }
    
    private void initComponents() {
        
        cf = new CustomFont();
        sel1 = new JButton("Seleccionar");
        sel1.setFont(cf.fuentenegrita());
        sel2 = new JButton("Seleccionar");
        sel2.setFont(cf.fuentenegrita());
        sel3 = new JButton("Seleccionar");
        sel3.setFont(cf.fuentenegrita());
        imagen1 = new JLabel();
        imagen2 = new JLabel();
        imagen3 = new JLabel();
        
    }

    private void colocarComponentes() {
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        add(sel1);
        sel1.setBounds(53, 250, 150, 25);
        add(sel2);
        sel2.setBounds(203, 250, 150, 25);
        add(sel3);
        sel3.setBounds(353, 250, 150, 25);
        
        add(imagen1);
        imagen1.setBounds(53, 50, 150, 200);
        add(imagen2);
        imagen2.setBounds(203, 50, 150, 200);
        add(imagen3);
        imagen3.setBounds(353, 50, 150, 200);
        imagen1.setVisible(true);
        imagen2.setVisible(true);
        imagen3.setVisible(true);
        
    }
    // En caso de no haber libro muestra el lugar donde debería ir la imagen en 
    // negro.
    private void asignarImagenes() {
        
        String img1 = lib1.getImagen();
        String img2 = lib2.getImagen();
        String img3 = lib3.getImagen();
        if (img1 == null) {
            img1 = black;
        }
        if (img2 == null) {
            img2 = black;
        }
        if (img3 == null) {
            img3 = black;
        }
        ImageIcon i1 = new ImageIcon(img1);
        ImageIcon i2 = new ImageIcon(img2);
        ImageIcon i3 = new ImageIcon(img3);
        imagen1.setIcon(new ImageIcon(i1.getImage().getScaledInstance(imagen1.getWidth(), imagen1.getHeight(), Image.SCALE_DEFAULT)));
        imagen2.setIcon(new ImageIcon(i2.getImage().getScaledInstance(imagen2.getWidth(), imagen2.getHeight(), Image.SCALE_DEFAULT)));
        imagen3.setIcon(new ImageIcon(i3.getImage().getScaledInstance(imagen3.getWidth(), imagen3.getHeight(), Image.SCALE_DEFAULT)));
        
        

    }
    
    private void accionesBotones(){
        
        sel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(!especial){
                    infoLibro(lib1);
                }else{
                    codigo = lib1.getCodigo();
                    desactivarBoton1();
                    desactivarBoton2();
                    desactivarBoton3();
                }
            }
        });
        
        sel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(!especial){
                    infoLibro(lib2);
                }else{
                    codigo = lib2.getCodigo();
                    desactivarBoton1();
                    desactivarBoton2();
                    desactivarBoton3();
                }   
            }
        });
        
        sel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(!especial){
                    infoLibro(lib3);
                }else{
                    codigo = lib3.getCodigo();
                    desactivarBoton1();
                    desactivarBoton2();
                    desactivarBoton3();
                }   
            }
        });
        
    }
    //Llama a la ventana de información del libro seleccionado que se pasa por
    // parámetro.
    private void infoLibro(Libro l) {
        PanelesInfo.FramePrincipal fp = new PanelesInfo.FramePrincipal(l, true);
        fp.setVisible(true);
    }
    
    public void desactivarBoton3(){
        this.sel3.setEnabled(false);
    }
    public void desactivarBoton2(){
        this.sel2.setEnabled(false);
    }
    public void desactivarBoton1(){
        this.sel1.setEnabled(false);
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
}
