/*
 * Busqueda interactiva de usuarios. Se muestra la foto de los distintos
 * usuarios guardados y se muestra la información del usuario seleccionado.
 */
package PanelesInteractivos;

import ClasesPrincipales.CustomFont;
import ClasesPrincipales.Usuario;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BusquedaUsuarios extends JPanel{
    
    private Usuario usr1, usr2, usr3;
    private JButton sel1, sel2, sel3;
    private JLabel imagen1, imagen2, imagen3;
    private String black = "images/black.jpg";
    private boolean especial;
    private int codigo;
    private CustomFont cf;
    // Muestra tres usuarios cada vez.
    public BusquedaUsuarios(Usuario usr1, Usuario usr2, Usuario usr3, boolean especial) {
        this.especial = especial;
        this.usr1 = usr1;
        this.usr2 = usr2;
        this.usr3 = usr3;
        
        setLayout(null);
        initComponents();
        colocarComponentes();
        asignarImagenes();
        accionesBotones();
        
    }

    private void initComponents() {
        
        sel1 = new JButton("Seleccionar");
        sel2 = new JButton("Seleccionar");
        sel3 = new JButton("Seleccionar");
        imagen1 = new JLabel();
        imagen2 = new JLabel();
        imagen3 = new JLabel();
        cf = new CustomFont();
    }

    private void colocarComponentes() {
        
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        add(sel1);
        sel1.setBounds(53, 250, 150, 25);
        sel1.setFont(cf.fuentenegrita());
        add(sel2);
        sel2.setBounds(203, 250, 150, 25);
        sel2.setFont(cf.fuentenegrita());
        add(sel3);
        sel3.setBounds(353, 250, 150, 25);
        sel3.setFont(cf.fuentenegrita());
        
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
    // Asigna las imágenes, si no hay usuario muestra una imagen en negro.
    private void asignarImagenes() {
        
        String img1 = usr1.getFoto();
        String img2 = usr2.getFoto();
        String img3 = usr3.getFoto();
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
                    infoUsuario(usr1);
                }else{
                    codigo = usr1.getCodigo();
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
                    infoUsuario(usr2);
                }else{
                    codigo = usr2.getCodigo();
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
                    infoUsuario(usr3);
                }else{
                    codigo = usr3.getCodigo();
                    desactivarBoton1();
                    desactivarBoton2();
                    desactivarBoton3();
                }      
            }
        });
        
    }
    // Llama a la ventana que muestra la información del usuario seleccionado.
    private void infoUsuario(Usuario u) {
        PanelesInfo.FramePrincipal fp = new PanelesInfo.FramePrincipal(u, false);
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

    public int getCodigo() {
        return this.codigo;
    }

    public void activarBotones() {
        
        this.sel1.setEnabled(true);
        this.sel2.setEnabled(true);
        this.sel3.setEnabled(true);
    }
    
}

