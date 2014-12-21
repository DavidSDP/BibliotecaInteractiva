/*
 * Gestiona las ventanas en las que se listan objetos (libros usuarios o
 * préstamos).
 */
package GUI;

import ClasesPrincipales.CustomFont;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

public class FrameListado extends JFrame{
    
    private DefaultListModel modelo;
    private String descripcion;
    private SpringLayout splay;
    private PanelListado pl;
    private boolean libros, especial, especial2;
    private JButton salirListado;
    private CustomFont cf;
    // Pasa por parámetro el tipo de objeto a listar.
    public FrameListado(DefaultListModel modelo, String descripcion, boolean libros, boolean especial, boolean especial2){
        
        this.libros = libros;
        this.descripcion = descripcion;
        this.modelo = modelo;
        this.especial = especial;
        this.especial2 = especial2;
        initComponents();
        colocarComponentes();
        botonSalirListado();
        setDimensiones();
        pl.setLayout(splay);
        pl.setVisible(true);
        this.setUndecorated(true);
        
    }

    private void initComponents() {
        
        splay = new SpringLayout();
        pl = new PanelListado(modelo, descripcion, splay, libros, especial, especial2);
        salirListado = new JButton("Salir");
        cf = new CustomFont();
        
    }
  
    
    private void setDimensiones(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dim = toolkit.getScreenSize();
        this.setLocation(dim.width / 2 - 365, dim.height / 2 - 200);
        this.setSize(730, 350);
    } 

    private void colocarComponentes(){
        
        this.add(pl);
        
        pl.add(salirListado);
        splay.putConstraint(SpringLayout.WEST, salirListado, 660, SpringLayout.WEST, this);
        splay.putConstraint(SpringLayout.NORTH, salirListado, 295, SpringLayout.NORTH, this);
        salirListado.setFont(cf.fuentenegrita());
        
    }
    
    private void botonSalirListado(){
        salirListado.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                cerrarFrame();
            }
        });
    }
    
    private void cerrarFrame(){
        this.dispose();
    }
    
    
}
