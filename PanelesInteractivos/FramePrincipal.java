/*
 * Frame principal de búsquedas interactivas que llama a BusquedaLibros o 
 * BusquedaUsuarios.
 */
package PanelesInteractivos;

import ClasesPrincipales.CustomFont;
import ClasesPrincipales.Libro;
import ClasesPrincipales.Usuario;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FramePrincipal extends JFrame{
    
    private int indice = 0;
    private BusquedaLibros bl;
    private BusquedaUsuarios bu;
    private Libro lib1, lib2, lib3;
    private Usuario usr1, usr2, usr3;
    private JButton flechaIzquierda, flechaDerecha;
    private String fleizq = "images/flechas/fleizq_2.jpg", fleder = "images/flechas/fleder_2.jpg";
    private JButton salir;
    private boolean libros, especial;
    private CustomFont cf;
    // En este constructor pasamos por parámetro si queremos buscar libros o 
    // usuarios.
    public FramePrincipal(boolean libros, boolean especial){ 
        this.libros = libros;
        this.especial = especial;
        this.setLayout(new BorderLayout());
        dimensionarFrame();
        initComponents();
        accionesBotones();
        if(libros){
            asignarLibros();
            initComponentsLibros();
            quitarBotonesLibros();
            
        }else{
            asignarUsuarios();
            initComponentsUsuarios();
            quitarBotonesUsuarios();
            
        }
        this.setUndecorated(true);
        
    }
    // Asigna los libros que se han de mostrar y controla las flechas para ir a
    // los siguientes libros de la lista.
    private void asignarLibros() {

        lib1 = libro(indice);
        lib2 = libro(indice + 1);
        lib3 = libro(indice + 2);
        flechaIzquierda.setEnabled(false);
        if (Libro.totalLibros() < 3) {
            flechaDerecha.setEnabled(false);
        }

    }
    // Pone los libros que se han de mostrar y gestiona las flechas de dirección.
    private void asignarUsuarios() {

        usr1 = usuario(indice);
        usr2 = usuario(indice + 1);
        usr3 = usuario(indice + 2);
        flechaIzquierda.setEnabled(false);
        if (Usuario.totalUsuarios() < 3) {
            flechaDerecha.setEnabled(false);
        }

    }
    
    private void dimensionarFrame(){
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        this.setSize(730, 350);
        this.setLocation(dim.width / 2 - 365, dim.height / 2 - 200);
        this.setResizable(false);
        
    }
    
    public int getCodigo(){
        if(libros){
            return bl.getCodigo();
        } else {
            return bu.getCodigo();
        }
    }
    
    private void initComponents() {
        
        cf = new CustomFont();
        flechaIzquierda = new JButton(new ImageIcon(fleizq));
        flechaDerecha = new JButton(new ImageIcon(fleder));
        if(!especial){
            salir = new JButton("Salir");
        }else{
            salir = new JButton("Aceptar");
        }
        salir.setFont(cf.fuentenegrita());
        this.add(flechaIzquierda, BorderLayout.WEST);
        this.add(flechaDerecha, BorderLayout.EAST);
        this.add(salir, BorderLayout.SOUTH);
        
    }

    private void initComponentsLibros(){
        
        this.bl = new BusquedaLibros(lib1, lib2, lib3, especial);
        this.add(bl, BorderLayout.CENTER);
        
    }
    
    private void initComponentsUsuarios(){
        
        this.bu = new BusquedaUsuarios(usr1, usr2, usr3, especial);
        this.add(bu, BorderLayout.CENTER);
        
    }
    
    private void accionesBotones(){
        salir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                if(libros){
                    bl.activarBotones();
                }else{
                    bu.activarBotones();
                }
                cerrarFrame();
                
            }
        });
        
        flechaIzquierda.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                flechaDerecha.setEnabled(true);
                if (indice > 0) {
                    indice--;
                    repaint();
                }
            }
        });
        
        
        flechaDerecha.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(libros){
                    if (indice < Libro.totalLibros() - 2) {
                        indice++;
                        repaint();
                    }
                }else{
                    if (indice < Usuario.totalUsuarios() - 2) {
                        indice++;
                        repaint();
                    }
                }
            }
        });
        
    }
    
    @Override
    public void repaint(){
        if(libros){
            bl.setVisible(false);
            asignarLibros();
            initComponentsLibros();
            if (indice == Libro.totalLibros() - 2) {
                    bl.desactivarBoton3();
                    flechaDerecha.setEnabled(false);
            }
        }else{
            bu.setVisible(false);
            asignarUsuarios();
            initComponentsUsuarios();
            if (indice == Usuario.totalUsuarios() - 2) {
                bu.desactivarBoton3();
                flechaDerecha.setEnabled(false);
            }
        }
        if (indice == 0) {
            flechaIzquierda.setEnabled(false);
        }else{
            flechaIzquierda.setEnabled(true);
        }
    }

    private void cerrarFrame(){
        this.dispose();
    }

    private Libro libro(int indice) {
        Libro l = new Libro();
        try {
            l.read(indice);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida");
        }
        return l;
    }

    private Usuario usuario(int indice) {
        Usuario u = new Usuario();
        try {
            u.read(indice);
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida");
        }
        return u;
    }
    
    private void quitarBotonesUsuarios(){
        
            if(Usuario.totalUsuarios()==1){
                bu.desactivarBoton2();
                bu.desactivarBoton3();
            }
            if(Usuario.totalUsuarios()==0){
                bu.desactivarBoton1();
                bu.desactivarBoton2();
                bu.desactivarBoton3();
            }
            if(Usuario.totalUsuarios()==2){
                bu.desactivarBoton3();
            }
    }

    private void quitarBotonesLibros() {
        
            if(Libro.totalLibros()==1){
                bl.desactivarBoton2();
                bl.desactivarBoton3();
            }
            if(Libro.totalLibros()==2){
                bl.desactivarBoton3();
            }
            if(Libro.totalLibros()==0){
                bl.desactivarBoton1();
                bl.desactivarBoton2();
                bl.desactivarBoton3();
            }
        
    }

}
