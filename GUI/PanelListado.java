/*
 * Gestiona las listas de objetos.
 */
package GUI;

import ClasesPrincipales.CustomFont;
import ClasesPrincipales.Libro;
import ClasesPrincipales.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;

public class PanelListado extends JPanel{
    
    private String descripcion;
    private JLabel descLabel;
    private JList listado;
    private DefaultListModel modelo;
    private SpringLayout splay;
    private JButton ver;
    private boolean libro, especial, especial2;
    private CustomFont cf;
    
    public PanelListado(DefaultListModel modelo, String descripcion, SpringLayout splay, boolean libro, boolean especial, boolean especial2){
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.splay = splay;
        this.libro = libro;
        this.especial = especial;
        this.especial2 = especial2;
        initComponents();
        colocarComponentes();
        accionBoton();
        listado.setModel(modelo);
        listado.setVisible(true);
        
    }
    
    private void initComponents(){
        
        descLabel = new JLabel(descripcion);
        modelo = new DefaultListModel();
        listado = new JList();
        ver = new JButton("Ver");
        cf = new CustomFont();
        
    }
    
    private void colocarComponentes(){
        
        add(descLabel);
        splay.putConstraint(SpringLayout.WEST, descLabel, 10, SpringLayout.WEST, this);
        splay.putConstraint(SpringLayout.NORTH, descLabel, 10, SpringLayout.NORTH, this);
        descLabel.setFont(cf.fuentenegrita());
        add(listado);
        splay.putConstraint(SpringLayout.WEST, listado, 10, SpringLayout.WEST, this);
        splay.putConstraint(SpringLayout.NORTH, listado, 40, SpringLayout.NORTH, this);
        listado.setFont(cf.fuente());
        add(ver);
        splay.putConstraint(SpringLayout.WEST, ver, 590, SpringLayout.WEST, this);
        splay.putConstraint(SpringLayout.NORTH, ver, 295, SpringLayout.NORTH, this);
        ver.setFont(cf.fuentenegrita());
        ver.setEnabled(false);
        
    }
    
    private void accionBoton(){
        
        listado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if(!especial2){
                    JList list = (JList) evt.getSource();
                    if (evt.getClickCount() == 2) {
                        int index = list.locationToIndex(evt.getPoint());
                        String s = list.getModel().getElementAt(index).toString();
                        verSeleccionado(s);
                    }
                    if (evt.getClickCount() == 1) {
                        ver.setEnabled(true);
                    }
                    if (evt.getClickCount() == 0) {
                        ver.setEnabled(false);
                    }
                }
            }
        });
        
        
        ver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                    String s = listado.getSelectedValue().toString();
                    verSeleccionado(s);
            }
        });

    }
 
    private void infoLibro(Libro l) {
        
        PanelesInfo.FramePrincipal fp = new PanelesInfo.FramePrincipal(l, true);
        fp.setVisible(true);
        
    }

    private void infoUsuario(Usuario u) {
        
        PanelesInfo.FramePrincipal fp = new PanelesInfo.FramePrincipal(u, false);
        fp.setVisible(true);
        
    }

    // Llama a la ventana de información del objeto seleccionado en la lista.
    private void verSeleccionado(String s) {
        try{
        if(!especial){
            char c = s.charAt(0);
            int n = Integer.parseInt(String.valueOf(c));
            if (n != -1) {
                if (libro) {
                    Libro l = new Libro();
                    l.read(n - 1);

                    infoLibro(l);
                } else {

                    Usuario u = new Usuario();
                    u.read(n - 1);
                    infoUsuario(u);

                }
            }
        }else{
            int i = s.indexOf("-")+2;
            String aux = "";
            char c = s.charAt(i);
            while(c != ' '){
                i++;
                aux = aux + c;
                c = s.charAt(i);
            }
            infoLibro(buscarLibro(aux));
        }
        }catch(FileNotFoundException e){
            System.out.println("Archivo no encontrado");
        }catch(IOException e){
            System.out.println("Error de entrada/salida");
        }
    }
    
    private Libro buscarLibro(String titulo) throws FileNotFoundException, IOException{
        Libro l = new Libro();
        for(int i = 0; i<Libro.totalLibros(); i++){
            l.read(i);
            if(l.getTitulo().equals(titulo)){
                return l;
            }
        }
        return null;
    }
    
}
