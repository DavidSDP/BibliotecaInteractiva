/*
 * Muestra la información sobre un libro seleccionado.
 */
package PanelesInfo;

import ClasesPrincipales.CustomFont;
import ClasesPrincipales.Libro;
import ClasesPrincipales.Prestamo;
import java.awt.Color;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class InfoLibro extends JPanel{
    
    private JLabel codigo, cod, titulo, tit, autor, aut, editorial, edi, 
            ubicacion, nave, est, fila, columna, estado, estd, alta, alt, 
            prestamo, pre, estropeado, estr, reparacion, rep, baja, baj, 
            image;
    private Libro lib;
    private SpringLayout splay2, splay3;
    private String img;
    private CustomFont cf;
    // Constructor que pasa por parámetro el libro del cual se quiere mostrar
    // la información.
    public InfoLibro(Libro l){
        this.lib = l;
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
        cod = new JLabel(Integer.toString(lib.getCodigo()));
        titulo = new JLabel("Título:");
        tit = new JLabel(lib.getTitulo());
        autor = new JLabel("Autor:");
        aut = new JLabel(lib.getAutor());
        editorial = new JLabel("Editorial:");
        edi = new JLabel(lib.getEditorial());
        ubicacion = new JLabel("Ubicación:");
        nave = new JLabel(lib.getUNave());
        est = new JLabel(lib.getUEstanteria());
        fila = new JLabel(Integer.toString(lib.getUFila()));
        columna = new JLabel(Integer.toString(lib.getUColumna()));
        estado = new JLabel("Estado:");
        estd = new JLabel(lib.getEstado());
        alta = new JLabel("Alta:");
        alt = new JLabel(lib.getAlta());
        prestamo = new JLabel("Préstamo:");
        pre = new JLabel(Integer.toString(lib.getPrestamo()));
        estropeado = new JLabel("Estropeado:");
        estr = new JLabel(lib.getFechaEstropeado());
        reparacion = new JLabel("Reparación:");
        rep = new JLabel(lib.getReparacion());
        baja = new JLabel("Baja:");
        baj = new JLabel(lib.getBaja());
        image = new JLabel();        
        splay2 = new SpringLayout();
        splay3 = new SpringLayout();
        cf = new CustomFont();
        
    }
    
    private void colocarComponentes(){
        Border blackline;

        blackline = BorderFactory.createLineBorder(Color.black);
        TitledBorder bordeInfo = BorderFactory.createTitledBorder(blackline, "Información");
        bordeInfo.setTitleJustification(TitledBorder.LEFT);
        TitledBorder bordeImagen = BorderFactory.createTitledBorder(blackline, "Portada del libro");
        bordeImagen.setTitleJustification(TitledBorder.LEFT);
        bordeInfo.setTitleFont(cf.fuentenegrita());
        bordeImagen.setTitleFont(cf.fuentenegrita());
        
        JPanel panelInfo = new JPanel();
        panelInfo.setBorder(bordeInfo);
        JPanel panelImagen = new JPanel();
        panelImagen.setBorder(bordeImagen);
        
        add(panelInfo);
        panelInfo.setBounds(20, 20, 300, 300);
        panelInfo.setLayout(splay2);
        
        add(panelImagen);
        panelImagen.setBounds(340, 20, 300, 300);
        panelImagen.setLayout(splay3);
        
        panelInfo.add(codigo);
        splay2.putConstraint(SpringLayout.WEST, codigo, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, codigo, 10, SpringLayout.NORTH, this);
        codigo.setFont(cf.fuentenegrita());
        
        panelInfo.add(cod);
        splay2.putConstraint(SpringLayout.WEST, cod, 100, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, cod, 10, SpringLayout.NORTH, this);
        cod.setFont(cf.fuente());
        
        panelInfo.add(titulo);
        splay2.putConstraint(SpringLayout.WEST, titulo, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, titulo, 35, SpringLayout.NORTH, this);
        titulo.setFont(cf.fuentenegrita());
        
        panelInfo.add(tit);
        splay2.putConstraint(SpringLayout.WEST, tit, 100, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, tit, 35, SpringLayout.NORTH, this);
        tit.setFont(cf.fuente());
        
        panelInfo.add(autor);
        splay2.putConstraint(SpringLayout.WEST, autor, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, autor, 60, SpringLayout.NORTH, this);
        autor.setFont(cf.fuentenegrita());
        
        panelInfo.add(aut);
        splay2.putConstraint(SpringLayout.WEST, aut, 100, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, aut, 60, SpringLayout.NORTH, this);
        aut.setFont(cf.fuente());
        
        panelInfo.add(editorial);
        splay2.putConstraint(SpringLayout.WEST, editorial, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, editorial, 85, SpringLayout.NORTH, this);
        editorial.setFont(cf.fuentenegrita());
        
        panelInfo.add(edi);
        splay2.putConstraint(SpringLayout.WEST, edi, 100, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, edi, 85, SpringLayout.NORTH, this);
        edi.setFont(cf.fuente());
        
        panelInfo.add(ubicacion);
        splay2.putConstraint(SpringLayout.WEST, ubicacion, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, ubicacion, 110, SpringLayout.NORTH, this);
        ubicacion.setFont(cf.fuentenegrita());
        
        panelInfo.add(nave);
        splay2.putConstraint(SpringLayout.WEST, nave, 100, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, nave, 110, SpringLayout.NORTH, this);
        nave.setFont(cf.fuente());
        
        panelInfo.add(est);
        splay2.putConstraint(SpringLayout.WEST, est, 110, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, est, 110, SpringLayout.NORTH, this);
        est.setFont(cf.fuente());
        
        panelInfo.add(fila);
        splay2.putConstraint(SpringLayout.WEST, fila, 120, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, fila, 110, SpringLayout.NORTH, this);
        fila.setFont(cf.fuente());
        
        panelInfo.add(columna);
        splay2.putConstraint(SpringLayout.WEST, columna, 130, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, columna, 110, SpringLayout.NORTH, this);
        columna.setFont(cf.fuente());
        
        panelInfo.add(estado);
        splay2.putConstraint(SpringLayout.WEST, estado, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, estado, 135, SpringLayout.NORTH, this);
        estado.setFont(cf.fuentenegrita());
        
        panelInfo.add(estd);
        splay2.putConstraint(SpringLayout.WEST, estd, 100, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, estd, 135, SpringLayout.NORTH, this);
        estd.setFont(cf.fuente());
        
        panelInfo.add(alta);
        splay2.putConstraint(SpringLayout.WEST, alta, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, alta, 160, SpringLayout.NORTH, this);
        alta.setFont(cf.fuentenegrita());
        
        panelInfo.add(alt);
        splay2.putConstraint(SpringLayout.WEST, alt, 100, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, alt, 160, SpringLayout.NORTH, this);
        alt.setFont(cf.fuente());
        
        panelInfo.add(prestamo);
        splay2.putConstraint(SpringLayout.WEST, prestamo, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, prestamo, 185, SpringLayout.NORTH, this);
        prestamo.setFont(cf.fuentenegrita());
        
        panelInfo.add(pre);
        splay2.putConstraint(SpringLayout.WEST, pre, 100, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, pre, 185, SpringLayout.NORTH, this);
        pre.setFont(cf.fuente());
        
        panelInfo.add(estropeado);
        splay2.putConstraint(SpringLayout.WEST, estropeado, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, estropeado, 210, SpringLayout.NORTH, this);
        estropeado.setFont(cf.fuentenegrita());
        
        panelInfo.add(estr);
        splay2.putConstraint(SpringLayout.WEST, estr, 100, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, estr, 210, SpringLayout.NORTH, this);
        estr.setFont(cf.fuente());
        
        panelInfo.add(reparacion);
        splay2.putConstraint(SpringLayout.WEST, reparacion, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, reparacion, 235, SpringLayout.NORTH, this);
        reparacion.setFont(cf.fuentenegrita());
        
        panelInfo.add(rep);
        splay2.putConstraint(SpringLayout.WEST, rep, 100, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, rep, 235, SpringLayout.NORTH, this);
        rep.setFont(cf.fuente());
        
        panelInfo.add(baja);
        splay2.putConstraint(SpringLayout.WEST, baja, 10, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, baja, 260, SpringLayout.NORTH, this);
        baja.setFont(cf.fuentenegrita());
        
        panelInfo.add(baj);
        splay2.putConstraint(SpringLayout.WEST, baj, 100, SpringLayout.WEST, this);  
        splay2.putConstraint(SpringLayout.NORTH, baj, 260, SpringLayout.NORTH, this);
        baj.setFont(cf.fuente());
        
        panelImagen.add(image);
        splay3.putConstraint(SpringLayout.WEST, image, 70, SpringLayout.WEST, this);  
        splay3.putConstraint(SpringLayout.NORTH, image, 40, SpringLayout.NORTH, this);
        image.setFont(cf.fuentenegrita());
        
        img = lib.getImagen();
        ImageIcon imagen1 = new ImageIcon(img);
        image.setIcon(new ImageIcon(imagen1.getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT)));
        image.setVisible(true);
        
    }
    
    private int[] setPrestamos() throws FileNotFoundException, IOException, ParseException{
        Prestamo p = new Prestamo();
        int [] aux = new int[10];
        int k = 0;
        for(int i = 0; i<Prestamo.totalPrestamos(); i++){
            p.read(i);
            for(int j = 0; j<10; j++){
                if(p.getCodLibros(j)==lib.getCodigo()){
                    aux[k] = p.getCodigo();
                    k++;
                }
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
