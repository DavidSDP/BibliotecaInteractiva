/*
 * Muestra la información sobre un usuario.
 */
package PanelesInfo;

import ClasesPrincipales.CustomFont;
import ClasesPrincipales.Prestamo;
import ClasesPrincipales.Usuario;
import java.awt.Color;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class InfoUsuario extends JPanel{
    private JLabel codigo, cod, nombre, nom, nif, niff, direccion, dir,
                    telefono, tel, email, ema, labelimg, image, prestamos, pre;
    private Usuario usr;
    private SpringLayout splay2, splay3;
    private String img;
    private CustomFont cf;
    // Pasa por pasa por parámetro el usuario del que hay que mostrar la
    // información.
    public InfoUsuario(Usuario u){
        this.usr = u;
        initComponents();
        colocarComponentes();
        try {
            escribePrestamos(setPrestamos());
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Error de entrada/salida");
        } catch (ParseException ex) {
            System.out.println("Error de parseado");
        }
        
    }
    
    private void initComponents(){
        
        codigo = new JLabel("Código:");
        cod = new JLabel(Integer.toString(usr.getCodigo()));
        nombre = new JLabel("Nombre:");
        nom = new JLabel(usr.getNombre());
        nif = new JLabel("NIF:");
        niff = new JLabel(usr.getNif());
        direccion = new JLabel("Dirección:");
        dir = new JLabel(usr.getDireccion());
        telefono = new JLabel("Telefono:");
        tel = new JLabel(Integer.toString(usr.getTelefono()));
        email = new JLabel("Email:");
        ema = new JLabel(usr.getEmail());
        labelimg = new JLabel("Foto del usuario");
        image = new JLabel();
        splay2 = new SpringLayout();
        splay3 = new SpringLayout();
        cf = new CustomFont();
        prestamos = new JLabel("Préstamos:");
        pre = new JLabel("0");
                
    }
    
    private void colocarComponentes(){
        Border blackline;

        blackline = BorderFactory.createLineBorder(Color.black);
        TitledBorder bordeInfo = BorderFactory.createTitledBorder(blackline, "Información");
        bordeInfo.setTitleJustification(TitledBorder.LEFT);
        TitledBorder bordeImagen = BorderFactory.createTitledBorder(blackline, "Foto de usuario");
        bordeImagen.setTitleJustification(TitledBorder.LEFT);
        bordeInfo.setTitleFont(cf.fuentenegrita());
        bordeImagen.setTitleFont(cf.fuentenegrita());
        JPanel panelInfo = new JPanel();
        panelInfo.setBorder(bordeInfo);
        JPanel panelImagen = new JPanel();
        panelImagen.setBorder(bordeImagen);
        
        add(panelInfo);
        panelInfo.setBounds(20, 20, 300, 205);
        panelInfo.setLayout(splay2);
        
        add(panelImagen);
        panelImagen.setBounds(340, 20, 300, 300);
        panelImagen.setLayout(splay3);
        
        panelInfo.add(codigo);
        splay2.putConstraint(SpringLayout.WEST, codigo, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, codigo, 10, SpringLayout.NORTH, this);
        codigo.setFont(cf.fuentenegrita());
        
        panelInfo.add(cod);
        splay2.putConstraint(SpringLayout.WEST, cod, 90, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, cod, 10, SpringLayout.NORTH, this);
        cod.setFont(cf.fuente());
        
        panelInfo.add(nombre);
        splay2.putConstraint(SpringLayout.WEST, nombre, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, nombre, 35, SpringLayout.NORTH, this);
        nombre.setFont(cf.fuentenegrita());
        
        panelInfo.add(nom);
        splay2.putConstraint(SpringLayout.WEST, nom, 90, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, nom, 35, SpringLayout.NORTH, this);
        nom.setFont(cf.fuente());
        
        panelInfo.add(nif);
        splay2.putConstraint(SpringLayout.WEST, nif, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, nif, 60, SpringLayout.NORTH, this);
        nif.setFont(cf.fuentenegrita());
        
        panelInfo.add(niff);
        splay2.putConstraint(SpringLayout.WEST, niff, 90, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, niff, 60, SpringLayout.NORTH, this);
        niff.setFont(cf.fuente());
        
        panelInfo.add(direccion);
        splay2.putConstraint(SpringLayout.WEST, direccion, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, direccion, 85, SpringLayout.NORTH, this);
        direccion.setFont(cf.fuentenegrita());
        
        panelInfo.add(dir);
        splay2.putConstraint(SpringLayout.WEST, dir, 90, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, dir, 85, SpringLayout.NORTH, this);
        dir.setFont(cf.fuente());
        
        panelInfo.add(telefono);
        splay2.putConstraint(SpringLayout.WEST, telefono, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, telefono, 110, SpringLayout.NORTH, this);
        telefono.setFont(cf.fuentenegrita());
        
        panelInfo.add(tel);
        splay2.putConstraint(SpringLayout.WEST, tel, 90, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, tel, 110, SpringLayout.NORTH, this);
        tel.setFont(cf.fuente());
        
        panelInfo.add(email);
        splay2.putConstraint(SpringLayout.WEST, email, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, email, 135, SpringLayout.NORTH, this);
        email.setFont(cf.fuentenegrita());
        
        panelInfo.add(ema);
        splay2.putConstraint(SpringLayout.WEST, ema, 90, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, ema, 135, SpringLayout.NORTH, this);
        ema.setFont(cf.fuente());
        
        panelImagen.add(image);
        splay3.putConstraint(SpringLayout.WEST, image, 70, SpringLayout.WEST, this);  
        splay3.putConstraint(SpringLayout.NORTH, image, 40, SpringLayout.NORTH, this);
        image.setFont(cf.fuentenegrita());
        
        panelInfo.add(prestamos);
        splay2.putConstraint(SpringLayout.WEST, prestamos, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, prestamos, 160, SpringLayout.NORTH, this);
        prestamos.setFont(cf.fuentenegrita());
        
        panelInfo.add(pre);
        splay2.putConstraint(SpringLayout.WEST, pre, 90, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, pre, 160, SpringLayout.NORTH, this);
        pre.setFont(cf.fuente());
        
        img = usr.getFoto();
        ImageIcon imagen1 = new ImageIcon(img);
        image.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT)));
        image.setVisible(true);
        
    }
    
    
    private int[] setPrestamos() throws FileNotFoundException, IOException, ParseException{
        Prestamo p = new Prestamo();
        int [] aux = new int[10];
        int k = 0;
        for (int i = 0; i < Prestamo.totalPrestamos(); i++) {
            p.read(i);
            if (p.getCodUsuario() == usr.getCodigo()) {
                aux[k] = p.getCodigo();
                k++;
            }
        }
        return aux;
    }

    private void escribePrestamos(int[] aux) {
        String str = "";
        for(int i = 0; i<aux.length; i++){
            if(aux[i]!=0){
                if(str.isEmpty()){
                    str += aux[i];
                }else{
                    str += ", " + aux[i];
                }
            }
        }
        if(str.isEmpty()){
            pre.setText("Ninguno");
        }else{
            pre.setText(str);
        }
    }
    
    
}
