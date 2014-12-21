/*
 * Controla el JPanel que se despliega al pulsar el botón "Alta libro" del 
 * JFrame principal.
 */
package PanelesPrincipales;

import ClasesPrincipales.CustomFont;
import ClasesPrincipales.Libro;
import GUI.JavaFileChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PanelAltaLibro extends JPanel{
    
    private JLabel Titulo, Autor, Editorial, Nave, Estanteria, Fila, Columna;
    private JTextField casTitulo, casAutor, casEditorial;
    private JComboBox casNave, casEstanteria, casFila, casColumna;
    private JButton botonAlta, botonRestablecer;
    private int codigolibro;
    private String portadaVacia = "images//portadaVacia.jpg";
    private CustomFont cf;
    
    public PanelAltaLibro(){
        Libro l = new Libro();
        codigolibro = Libro.totalLibros()+1;
        System.out.println("Numero de libros: "+Libro.totalLibros());
        this.setLayout(null);
        initComponents();
        colocarComponentes();
        accionesBotones();
    }
    
    private void initComponents(){
        
        Titulo = new JLabel("Título");
        Autor = new JLabel("Autor");
        Editorial = new JLabel("Editorial");
        Nave = new JLabel("Nave");
        Estanteria = new JLabel("Estantería");
        Fila = new JLabel("Fila");
        Columna = new JLabel("Columna");
        casTitulo = new JTextField(10);
        casAutor = new JTextField(10);
        casEditorial = new JTextField(10);
        String[] op1 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] op2 = {"0", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L",
            "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Integer[] op3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        casNave = new JComboBox(op1);
        casEstanteria = new JComboBox(op2);
        casFila = new JComboBox(op3);
        casColumna = new JComboBox(op3);
        botonAlta = new JButton("Alta");
        botonRestablecer = new JButton("Restablecer");
        cf = new CustomFont();
        
    }
    
    private void colocarComponentes(){
        
        Border blackline;

        blackline = BorderFactory.createLineBorder(Color.black);
        TitledBorder bordeDatos = BorderFactory.createTitledBorder(blackline, "Datos");
        TitledBorder bordeUbicacion = BorderFactory.createTitledBorder(blackline, "Ubicación");
        bordeDatos.setTitleJustification(TitledBorder.LEFT);
        bordeUbicacion.setTitleJustification(TitledBorder.LEFT);
        bordeDatos.setTitleFont(cf.fuentenegrita());
        bordeUbicacion.setTitleFont(cf.fuentenegrita());

        JPanel panelDatos = new JPanel();
        JPanel panelUbicacion = new JPanel();
        panelDatos.setBorder(bordeDatos);
        panelUbicacion.setBorder(bordeUbicacion);
        
        add(panelDatos);
        panelDatos.setLayout(null);
        panelDatos.setBounds(20, 10, 240, 140);
        
        add(panelUbicacion);
        panelUbicacion.setLayout(null);
        panelUbicacion.setBounds(280, 10, 150, 140);
        
        
        
        panelDatos.add(Titulo);
        panelDatos.add(casTitulo);
        Titulo.setBounds(20, 40, 50, 10);
        Titulo.setFont(cf.fuente());
        casTitulo.setBounds(80, 37, 100, 20);
        casTitulo.setFont(cf.fuente());

        panelDatos.add(Autor);
        panelDatos.add(casAutor);
        Autor.setBounds(20, 70, 50, 10);
        Autor.setFont(cf.fuente());
        casAutor.setBounds(80, 67, 100, 20);
        casAutor.setFont(cf.fuente());

        panelDatos.add(Editorial);
        panelDatos.add(casEditorial);
        Editorial.setBounds(20, 100, 70, 10);
        Editorial.setFont(cf.fuente());
        casEditorial.setBounds(80, 97, 100, 20);
        casEditorial.setFont(cf.fuente());

        panelUbicacion.add(Nave);
        panelUbicacion.add(casNave);
        Nave.setBounds(10, 20, 80, 10);
        Nave.setFont(cf.fuente());
        casNave.setBounds(100, 17, 40, 20);
        casNave.setFont(cf.fuente());


        panelUbicacion.add(Estanteria);
        panelUbicacion.add(casEstanteria);
        Estanteria.setBounds(10, 50, 80, 10);
        Estanteria.setFont(cf.fuente());
        casEstanteria.setBounds(100, 47, 40, 20);
        casEstanteria.setFont(cf.fuente());

        panelUbicacion.add(Fila);
        panelUbicacion.add(casFila);
        Fila.setBounds(10, 80, 80, 10);
        Fila.setFont(cf.fuente());
        casFila.setBounds(100, 77, 40, 20);
        casFila.setFont(cf.fuente());

        panelUbicacion.add(Columna);
        panelUbicacion.add(casColumna);
        Columna.setBounds(10, 110, 80, 10);
        Columna.setFont(cf.fuente());
        casColumna.setBounds(100, 107, 40, 20);
        casColumna.setFont(cf.fuente());

        add(botonAlta);
        add(botonRestablecer);
        botonAlta.setBounds(480, 15, 180, 25);
        botonRestablecer.setBounds(480, 45, 180, 25);
        botonAlta.setFont(cf.fuentenegrita());
        botonRestablecer.setFont(cf.fuentenegrita());
    }
    
    
    private void accionesBotones(){
        
        botonAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    altaLibro();
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo no encontrado");    
                } catch (IOException ex) {
                    System.out.println("Error de entrada/salida");           
                }
            }
        });
        
        botonRestablecer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                restablecerCampos();
            }
        });
        
    }
    
    // Vacía los campos a rellenar para dar de alta un libro.
    public void restablecerCampos(){
        casTitulo.setText("");
        casAutor.setText("");
        casEditorial.setText("");
        casNave.setSelectedIndex(0);
        casEstanteria.setSelectedIndex(0);
        casFila.setSelectedIndex(0);
        casColumna.setSelectedIndex(0);
    }
    
    public String casTitulo(){
        return casTitulo.getText();
    }
    
    public boolean tituloVacio(){
        return casTitulo().isEmpty();
    }
    
    public String casAutor(){
        return casAutor.getText();
    }
    
    public String casEditorial(){
        return casEditorial.getText();
    }
    
    public String casUbicacion(){
        return casNave.getSelectedItem().toString() + casEstanteria.getSelectedItem().toString()
                + casFila.getSelectedItem().toString() + casColumna.getSelectedItem().toString();
    }
    
    public String casNave(){
        return casNave.getSelectedItem().toString();
    }
    
    public String casEstanteria(){
        return casEstanteria.getSelectedItem().toString();
    }
    
    public String casFila(){
        return casFila.getSelectedItem().toString();
    }
    
    public String casColumna(){
        return casColumna.getSelectedItem().toString();
    }
    /*
     * Da de alta un libro obligaando a que mínimo se inserte el título para 
     * darlo de alta.
     */
    public void altaLibro() throws FileNotFoundException, IOException {
        if (!tituloVacio()) {       
            Libro libro = new Libro();
            libro.setTitulo(casTitulo());
            libro.setAutor(casAutor());
            libro.setEditorial(casEditorial());
            libro.setNave(casNave());
            libro.setEstanteria(casEstanteria());
            libro.setFila(Integer.parseInt(casFila()));
            libro.setColumna(Integer.parseInt(casColumna()));
            libro.setCodigo(codigolibro);
            libro.setEstado("Disponible");
            
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
            String fecha = sdf.format(cal.getTime());
            libro.setAlta(fecha);
            
            JavaFileChooser jfc = new JavaFileChooser(true);
            if(!jfc.getImagen().equals("")){
                libro.setImagen(jfc.getImagen());
            }else{
                libro.setImagen(portadaVacia);
            }
            libro.write();
            
            ventanaEmergente("El libro '" + libro.getTitulo() + "' ha sido dado de alta.");
            codigolibro++;
            
            restablecerCampos();
            
        } else {
            ventanaEmergente("Inserte el título del libro");
        }
    }
    
    private void ventanaEmergente(String s){
        JOptionPane.showMessageDialog(null, s);
    }

    private Font crearFuente() {
        Font calibri = null;
        try {
            InputStream is = new FileInputStream("fonts/calibri.ttf");
            calibri = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException | IOException ex) {
            System.out.println("Error de formato de fuente");  
        }
        return calibri;
    }
    
}
