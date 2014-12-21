/*
 * JFrame principal de los paneles de información. Llama a InfoLibro o 
 * InfoUsuario dependiendo de si lo que pasamos por parámetro es un libro o 
 * un usuario.
 */
package PanelesInfo;

import ClasesPrincipales.CustomFont;
import ClasesPrincipales.Libro;
import ClasesPrincipales.Usuario;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class FramePrincipal extends JFrame {
    
    private SpringLayout sp;
    private JPanel jp;
    private boolean libro;
    private Libro lib;
    private Usuario usr;
    private JButton salir;
    private CustomFont cf;
    // En el constructor pasas por parámetro el objeto del cual quieres que se 
    // muestre la información y el tipo de objeto que es (libro o usuario).
    public FramePrincipal(Object obj, boolean libro){
        initComponents();
        if(libro){
            this.lib = (Libro) obj;
            initComponentsLibro();
        }else{
            this.usr = (Usuario) obj;
            initComponentsUsuario();
        }
        this.add(jp);
        jp.setLayout(null);
        dimensionarFrame();
        botonSalir();
        this.setUndecorated(true);
        
    }
    
    private void dimensionarFrame(){
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        this.setLocation(dim.width / 2 - 365, dim.height / 2 - 200);
        this.setSize(730, 350);
        
    }
    
    private void initComponents(){
        sp = new SpringLayout();
        salir = new JButton("Salir");
        cf = new CustomFont();
    }
    
    private void initComponentsLibro(){
        jp = new InfoLibro(lib);
    }
    
    private void initComponentsUsuario(){
        jp = new InfoUsuario(usr);
    }
    
    private void botonSalir() {
        
        jp.add(salir);
        salir.setBounds(660, 295, 63, 25);
        salir.setFont(cf.fuentenegrita());
        
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                cerrarFrame();
            }
        });
    }
    
    private void cerrarFrame(){
        this.dispose();
    }
    
}
