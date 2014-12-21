/*
 * Panel desplegable para buscar información sobre los préstamos.
 */
package PanelesPrincipales;

import ClasesPrincipales.CustomFont;
import ClasesPrincipales.Libro;
import ClasesPrincipales.Prestamo;
import ClasesPrincipales.Usuario;
import GUI.FrameListado;
import PanelesInteractivos.FramePrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PanelInfoPrestamo extends JPanel{
    
    private JLabel nifusuario, codusuario, line, codlibro, titlibro, antesdel;
    private JTextField nifUsuario, letraNifUsuario, codUsuario, codLibro, titLibro, antesDel;
    private JButton botonListado, buscar, busquedaInteractiva, buscarPrestamo, botonFueraPlazo;
    private CustomFont cf;
    private FramePrincipal fp;
    private String descripcion = "Cód. Título - Autor - Estado - Ubicación";
    private String descripcion2 = "Préstamo - Libro - Usuario - Prestado - Devolución";
    private String descripcion3 = "Usuario - Prestado - Devolución";
    private String fechaActual;
    
    public PanelInfoPrestamo(){
        Prestamo p = new Prestamo();
        this.setLayout(null);
        initComponents();
        colocarComponentes();
        accionesBotones();
    }
    
    private void initComponents(){
        
        fp = new PanelesInteractivos.FramePrincipal(false, true);
        nifusuario = new JLabel("Nif de usuario");
        codusuario = new JLabel("Código de usuario");
        nifUsuario = new JTextField(7);
        letraNifUsuario = new JTextField(2);
        codUsuario = new JTextField(2);
        busquedaInteractiva = new JButton("Búsqueda Interactiva");
        cf = new CustomFont();
        line = new JLabel("______________________");
        buscar = new JButton("Buscar");
        botonListado = new JButton("Listado");
        codlibro = new JLabel("Código de libro");
        codLibro = new JTextField(2);
        titlibro = new JLabel("Título de libro");
        titLibro = new JTextField(7);
        buscarPrestamo = new JButton("Buscar");
        botonFueraPlazo = new JButton("Buscar préstamos");
        antesdel = new JLabel("Antes del");
        antesDel = new JTextField(7);
        
    }
    
    private void colocarComponentes(){
        Border blackline;

        blackline = BorderFactory.createLineBorder(Color.black);
        TitledBorder bordeLibros = BorderFactory.createTitledBorder(blackline, "Libros prestados");
        TitledBorder bordeListadoLibros = BorderFactory.createTitledBorder(blackline, "Listado de libros prestados");
        TitledBorder bordeBuscarPrestamo = BorderFactory.createTitledBorder(blackline, "Buscar préstamo por libro");
        TitledBorder bordePlazo = BorderFactory.createTitledBorder(blackline, "Préstamos fuera de plazo");
        bordeLibros.setTitleJustification(TitledBorder.LEFT);
        bordeListadoLibros.setTitleJustification(TitledBorder.LEFT);
        bordeBuscarPrestamo.setTitleJustification(TitledBorder.LEFT);
        bordePlazo.setTitleJustification(TitledBorder.LEFT);
        bordeLibros.setTitleFont(cf.fuentenegrita());
        bordeListadoLibros.setTitleFont(cf.fuentenegrita());
        bordeBuscarPrestamo.setTitleFont(cf.fuentenegrita());
        bordePlazo.setTitleFont(cf.fuentenegrita());

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fechaActual = sdf.format(cal.getTime());
        
        JPanel panelListado = new JPanel();
        panelListado.setBorder(bordeListadoLibros);
        add(panelListado);
        panelListado.setBounds(260, 10, 200, 50);
        panelListado.setLayout(null);
        
        JPanel panelLibros = new JPanel();
        panelLibros.setBorder(bordeLibros);
        add(panelLibros);
        panelLibros.setBounds(10, 10, 240, 140);
        panelLibros.setLayout(null);
        
        JPanel panelPrestamos = new JPanel();
        panelPrestamos.setBorder(bordeBuscarPrestamo);
        add(panelPrestamos);
        panelPrestamos.setBounds(470, 10, 225, 100);
        panelPrestamos.setLayout(null);
        
        JPanel panelPlazo = new JPanel();
        panelPlazo.setBorder(bordePlazo);
        add(panelPlazo);
        panelPlazo.setBounds(260, 70, 200, 80);
        panelPlazo.setLayout(null);
        
        panelLibros.add(codusuario);
        codusuario.setBounds(20, 20, 110, 20);
        codusuario.setFont(cf.fuente());
        panelLibros.add(codUsuario);
        codUsuario.setBounds(135, 20, 20, 20);
        codUsuario.setFont(cf.fuente());
        panelLibros.add(nifusuario);
        nifusuario.setBounds(20, 45, 80, 20);
        nifusuario.setFont(cf.fuente());
        panelLibros.add(nifUsuario);
        nifUsuario.setBounds(110, 45, 70, 20);
        nifUsuario.setFont(cf.fuente());
        panelLibros.add(letraNifUsuario);
        letraNifUsuario.setBounds(180, 45, 20, 20);
        letraNifUsuario.setFont(cf.fuente());
        panelLibros.add(busquedaInteractiva);
        busquedaInteractiva.setBounds(20, 70, 180, 20);
        busquedaInteractiva.setFont(cf.fuentenegrita());
        panelLibros.add(line);
        line.setBounds(20, 84, 180, 20);
        line.setFont(cf.fuentenegrita());
        panelLibros.add(buscar);
        buscar.setBounds(37, 110, 140, 20);
        buscar.setFont(cf.fuentenegrita());
        panelListado.add(botonListado);
        botonListado.setBounds(10, 20, 180, 20);
        botonListado.setFont(cf.fuentenegrita());
        panelPrestamos.add(codlibro);
        codlibro.setBounds(20, 20, 90, 20);
        codlibro.setFont(cf.fuente());
        panelPrestamos.add(codLibro);
        codLibro.setBounds(115, 20, 20, 20);
        codLibro.setFont(cf.fuente());
        panelPrestamos.add(titlibro);
        titlibro.setBounds(20, 45, 90, 20);
        titlibro.setFont(cf.fuente());
        panelPrestamos.add(titLibro);
        titLibro.setBounds(110, 45, 70, 20);
        titLibro.setFont(cf.fuente());
        panelPrestamos.add(buscarPrestamo);
        buscarPrestamo.setBounds(30, 70, 140, 20);
        buscarPrestamo.setFont(cf.fuentenegrita());
        panelPlazo.add(botonFueraPlazo);
        botonFueraPlazo.setBounds(20, 50, 160, 20);
        botonFueraPlazo.setFont(cf.fuentenegrita());
        panelPlazo.add(antesdel);
        antesdel.setBounds(30, 20, 60, 20);
        antesdel.setFont(cf.fuente());
        panelPlazo.add(antesDel);
        antesDel.setBounds(90, 20, 73, 20);
        antesDel.setFont(cf.fuente());
        antesDel.setText(fechaActual);
        
    }
    
    private void restablecerCampos(){
        codUsuario.setText("");
        nifUsuario.setText("");
        letraNifUsuario.setText("");
        codLibro.setText("");
        titLibro.setText("");
        antesDel.setText(fechaActual);
    }
    
    private void setBI(int i){
        codUsuario.setText(Integer.toString(i));
    }
    
    private void accionesBotones(){
        
        busquedaInteractiva.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                fp.setVisible(true);
            }
        });
        
        fp.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
            }

            @Override
            public void windowClosed(WindowEvent we) {
                int i = fp.getCodigo();
                setBI(i);

            }

            @Override
            public void windowIconified(WindowEvent we) {
            }

            @Override
            public void windowDeiconified(WindowEvent we) {
            }

            @Override
            public void windowActivated(WindowEvent we) {
            }

            @Override
            public void windowDeactivated(WindowEvent we) {
            }
        });

        buscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try {
                    buscarLibros();
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo no encontrado");
                } catch (IOException ex) {
                    System.out.println("Error de entrada/salida");
                } catch (ParseException ex) {
                    System.out.println("Error de parseado");
                }
                restablecerCampos();
            }
        });
        
        botonListado.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try {
                    listarLibrosPrestados();
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo no encontrado");
                } catch (IOException ex) {
                    System.out.println("Error de entrada/salida");
                } catch (ParseException ex) {
                    System.out.println("Error de parseado");
                }
                restablecerCampos();
            }
        });
        
        buscarPrestamo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try {
                    buscarPrestamo();
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo no encontrado");
                } catch (IOException ex) {
                    System.out.println("Error de entrada/salida");
                } catch (ParseException ex) {
                    System.out.println("Error de parseado");
                }
                restablecerCampos();
            }
        });
        
        botonFueraPlazo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try {
                    buscarPrestamosPlazo();
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo no encontrado");
                } catch (IOException ex) {
                    System.out.println("Error de entrada/salida");
                } catch (ParseException ex) {
                    System.out.println("Error de parseado");
                }
            }

        });
        
    }
    
    private int getCodigo(){
        if(codUsuario.getText().isEmpty()){
            return 0;
        }
        return Integer.parseInt(codUsuario.getText());
    }
    private String getNif(){
        return nifUsuario.getText() + letraNifUsuario.getText();
    }
    
    private int getCodLibro(){
        if(codLibro.getText().isEmpty()){
            return 0;
        }
        return Integer.parseInt(codLibro.getText());
    }
    private String getTitLibro(){
        if(titLibro.getText().isEmpty()){
            return null;
        }
        return titLibro.getText();
    }
    // Busca un usuario por código de usuario.
    private Usuario buscarUsuario(int codigo) throws FileNotFoundException, IOException{
        Usuario u = new Usuario();
        for(int i = 0; i<Usuario.totalUsuarios(); i++){
            u.read(i);
            if(u.getCodigo()==codigo){
                return u;
            }
        }
        return null;
    }
    // Busca un usuario por NIF.
    private Usuario buscarUsuario(String nif) throws FileNotFoundException, IOException{
        Usuario u = new Usuario();
        for(int i = 0; i<Usuario.totalUsuarios(); i++){
            u.read(i);
            if(u.getNif().equals(nif)){
                return u;
            }
        }
        return null;
    }
    // Busca un préstamo por el usuario al que se le ha prestado.
    private Prestamo encontrarPrestamo(Usuario u) throws FileNotFoundException, IOException, ParseException {
        Prestamo p = new Prestamo();
        for (int i = 0; i < Prestamo.totalPrestamos(); i++) {
            p.read(i);
            if (p.getCodUsuario() == u.getCodigo()) {
                return p;
            }
        }
        return null;
    }
    // Busca si un libro está prestado.
    private void buscarPrestamo() throws FileNotFoundException, IOException, ParseException{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DefaultListModel modelo = new DefaultListModel();
        boolean found = false;
        if(getCodLibro()!=0 || getTitLibro()!=null) {
            Libro l;
            if(getCodLibro()!=0){
                l = getLibro(getCodLibro());
            }else{
                l = getLibro(getTitLibro());
            }
            
            if(l != null) {

                Prestamo p = new Prestamo();
                for (int i = 0; i < Prestamo.totalPrestamos(); i++) {
                    p.read(i);
                    for (int j = 0; j < 10; j++) {
                        if (p.getCodLibros(j) == l.getCodigo()) {
                            String fecha = sdf.format(p.getFechaOut());
                            String fecha2 = sdf.format(p.getFechaIn());
                            modelo.addElement(p.getCodUsuario() + " - " + fecha + " - " + fecha2);
                            found = true;
                        }
                    }
                }
                if (!found) {
                    ventanaEmergente("El libro no está en préstamo");
                } else {
                    ventanaListado(modelo, descripcion3, true, false, true);
                }
            }else{
                ventanaEmergente("El libro no figura en la base de datos");
            }
        } else {
            ventanaEmergente("Introduca código o título de libro");
        }
        
    }
    
    private Libro getLibro(int codigo) throws FileNotFoundException, IOException{
        Libro l = new Libro();
        l.read(codigo-1);
        if(l.getCodigo()==0){
            return null;
        }
        return l;
    }
    
    private Libro getLibro(String titulo) throws FileNotFoundException, IOException{
        Libro l = new Libro();
        for(int i = 0; i<Libro.totalLibros(); i++){
            l.read(i);
            if(l.getTitulo().equals(titulo)){
                return l;
            }
        }
        return null;
    }
    // Crea un listado de todos los libros prestados en otra ventana.
    private void listarLibrosPrestados() throws FileNotFoundException, IOException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Prestamo p = new Prestamo();
        if (Prestamo.totalPrestamos() != 0) {
            DefaultListModel modelo = new DefaultListModel();
            for (int i = 0; i < Prestamo.totalPrestamos(); i++) {
                p.read(i);
                for (int j = 0; j < 10; j++) {
                    if (p.getCodLibros(j) != 0) {
                        Usuario u = buscarUsuario(p.getCodUsuario());
                        Libro l = getLibro(p.getCodLibros(j));
                        String fecha = sdf.format(p.getFechaOut());
                        String fecha2 = sdf.format(p.getFechaIn());
                        modelo.addElement(p.getCodigo() + " - " + l.getTitulo() + " - " + u.getNombre() + " - " + fecha + " - " + fecha2);
                    }
                }
            }
            ventanaListado(modelo, this.descripcion2, true, true, false);
        } else {
            ventanaEmergente("No hay ningún préstamo en activo");
        }
    }
    // Busca los libros prestados.
    private void buscarLibros() throws FileNotFoundException, IOException, ParseException{
        DefaultListModel dlm = new DefaultListModel();
        Usuario u;
        if(getCodigo()==0){
            u = buscarUsuario(getNif());
        }else{
            u = buscarUsuario(getCodigo());
        }
        if(u!=null){
            Prestamo p = encontrarPrestamo(u);
            if(p!=null){
                for(int i = 0; i < 10; i++) {
                    if (p.getCodLibros(i) != 0) {
                        Libro l = getLibro(p.getCodLibros(i));
                        dlm.addElement(l.toString());
                    }
                }
                ventanaListado(dlm, this.descripcion, true, false, false);
            } else {
                ventanaEmergente("No hay ningún préstamo para ése usuario");
            }
        }else{
            ventanaEmergente("El usuario no existe");
        }
    }
    // Busca préstamos por fecha.
    private void buscarPrestamosPlazo() throws FileNotFoundException, IOException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Prestamo p = new Prestamo();
        DefaultListModel modelo = new DefaultListModel();
        Date df = (new SimpleDateFormat("dd/MM/yyyy")).parse(antesDel.getText());
        for(int i = 0; i<Prestamo.totalPrestamos(); i++){
            p.read(i);
            if(p.getFechaIn().before(df)){
                String fecha = sdf.format(p.getFechaOut());
                String fecha2 = sdf.format(p.getFechaIn());
                modelo.addElement(p.getCodUsuario()+" - "+fecha+" - "+fecha2);
            }
        }
        if(!modelo.isEmpty()){
            ventanaListado(modelo, descripcion3, true, false, true);
        }else{
            ventanaEmergente("No hay préstamos fuera del plazo");
        }
    }

    private void ventanaListado(DefaultListModel modelo, String descripcion, boolean libros, boolean especial, boolean especial2){
        
        FrameListado fl = new FrameListado(modelo, descripcion, libros, especial, especial2);
        fl.setVisible(true);
        
    }

    private void ventanaEmergente(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
    
}

