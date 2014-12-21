/*
 * Controla el JPanel que se despliega al pulsar el botón "Alta usuario" del 
 * JFrame principal.
 */
package PanelesPrincipales;

import ClasesPrincipales.CustomFont;
import ClasesPrincipales.Usuario;
import GUI.JavaFileChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PanelAltaUsuario extends JPanel {

    private JLabel nombre, nif, direccion, telefono, email, arroba;
    private JTextField casNombre, casNif, casLetraNif, casDireccion, casTelefono,
            casEmail, casServidor;
    private JButton botonAlta, botonRestablecer;
    private int codigousuario;
    private String fotoVacia = "images/portadavacia.jpg";
    private CustomFont cf;

    public PanelAltaUsuario() {
        Usuario u = new Usuario();
        codigousuario = Usuario.totalUsuarios() + 1;
        System.out.println("Numero de usuarios: " + Usuario.totalUsuarios());
        this.setLayout(null);
        initComponents();
        colocarComponentes();
        accionesBotones();
    }

    private void initComponents() {

        nombre = new JLabel("Nombre");
        nif = new JLabel("NIF");
        direccion = new JLabel("Dirección");
        telefono = new JLabel("Teléfono");
        email = new JLabel("Email");
        arroba = new JLabel("@");
        casNombre = new JTextField(10);
        casNif = new JTextField(7);
        casLetraNif = new JTextField(2);
        casDireccion = new JTextField(10);
        casTelefono = new JTextField(10);
        casEmail = new JTextField(10);
        casServidor = new JTextField(8);
        botonAlta = new JButton("Alta");
        botonRestablecer = new JButton("Restablecer");
        cf = new CustomFont();

    }

    private void colocarComponentes() {

        Border blackline;

        blackline = BorderFactory.createLineBorder(Color.black);
        TitledBorder bordeDatos = BorderFactory.createTitledBorder(blackline, "Datos Personales");
        TitledBorder bordeUbicacion = BorderFactory.createTitledBorder(blackline, "Contacto");
        bordeDatos.setTitleJustification(TitledBorder.LEFT);
        bordeUbicacion.setTitleJustification(TitledBorder.LEFT);
        bordeDatos.setTitleFont(cf.fuentenegrita());
        bordeUbicacion.setTitleFont(cf.fuentenegrita());

        JPanel panelDatos = new JPanel();
        JPanel panelContacto = new JPanel();
        panelDatos.setBorder(bordeDatos);
        panelContacto.setBorder(bordeUbicacion);
        
        add(panelDatos);
        panelDatos.setLayout(null);
        panelDatos.setBounds(20, 10, 240, 140);
        
        add(panelContacto);
        panelContacto.setLayout(null);
        panelContacto.setBounds(280, 10, 170, 140);
        
        
        
        panelDatos.add(nombre);
        panelDatos.add(casNombre);
        nombre.setBounds(10, 30, 60, 10);
        nombre.setFont(cf.fuente());
        casNombre.setBounds(80, 27, 100, 20);
        casNombre.setFont(cf.fuente());

        panelDatos.add(nif);
        panelDatos.add(casNif);
        panelDatos.add(casLetraNif);
        nif.setBounds(10, 70, 50, 10);
        casNif.setBounds(80, 67, 80, 20);
        casLetraNif.setBounds(160, 67, 20, 20);
        nif.setFont(cf.fuente());
        casNif.setFont(cf.fuente());
        casLetraNif.setFont(cf.fuente());

        panelDatos.add(direccion);
        panelDatos.add(casDireccion);
        direccion.setBounds(10, 110, 80, 10);
        casDireccion.setBounds(80, 107, 100, 20);
        direccion.setFont(cf.fuente());
        casDireccion.setFont(cf.fuente());

        panelContacto.add(telefono);
        panelContacto.add(casTelefono);
        telefono.setBounds(10, 25, 70, 20);
        casTelefono.setBounds(10, 45, 122, 20);
        telefono.setFont(cf.fuente());
        casTelefono.setFont(cf.fuente());
        
        panelContacto.add(email);
        panelContacto.add(casEmail);
        panelContacto.add(arroba);
        panelContacto.add(casServidor);
        email.setBounds(10, 80, 50, 10);
        casEmail.setBounds(10, 100, 60, 20);
        arroba.setBounds(70, 100, 13, 20);
        casServidor.setBounds(83, 100, 75, 20);
        email.setFont(cf.fuente());
        casEmail.setFont(cf.fuente());
        arroba.setFont(cf.fuente());
        casServidor.setFont(cf.fuente());


        add(botonAlta);
        add(botonRestablecer);
        botonAlta.setBounds(480, 15, 180, 25);
        botonRestablecer.setBounds(480, 45, 180, 25);
        botonAlta.setFont(cf.fuentenegrita());
        botonRestablecer.setFont(cf.fuentenegrita());
    }
    // Vacía las casillas de todos los campos.
    private void restablecerCampos() {

        casNombre.setText("");
        casNif.setText("");
        casLetraNif.setText("");
        casDireccion.setText("");
        casTelefono.setText("");
        casEmail.setText("");
        casServidor.setText("");

    }

    private String getNombre() {
        return casNombre.getText();
    }

    private String getNif() {
        return casNif.getText() + casLetraNif.getText();
    }

    private String getDireccion() {
        return casDireccion.getText();
    }

    private String getTelefono() {
        return casTelefono.getText();
    }

    private String getEmail() {
        return casEmail.getText() + "@" + casServidor.getText();
    }

    private boolean camposVacios() {
        boolean aux = false;
        if (getNif().isEmpty() || getTelefono().isEmpty()) {
            aux = true;
        }
        return aux;
    }

    private void accionesBotones() {
        
        botonAlta.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent evt){
                try {
                    altaUsuario();
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo no encontrado");
                } catch (IOException ex) {
                    System.out.println("Error de entrada/salida");
                } catch (NumberFormatException nfe) {
                    ventanaEmergente("Introduce un teléfono válido");
                }
            }
        });
        
        botonRestablecer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed (ActionEvent evt){
                restablecerCampos();
            }
        });
        
        
        
    }
    // Comprueva si un usuario está guardado en el fichero.
    private boolean usuarioExiste(String nombre) throws FileNotFoundException, IOException {

        for(int i = 0; i<Usuario.totalUsuarios(); i++){
            Usuario usr = new Usuario();
            usr.read(i);
            if (nombre.equals(usr.getNombre())) {
                return true;
            }
        }
        return false;
    }
    // Añade un usuario nuevo y abre una ventana emergente diciendo que ha sido dado de alta.
    private void altaUsuario() throws FileNotFoundException, IOException, NumberFormatException{
        if (!camposVacios()) {
            if (!usuarioExiste(getNombre())) {

                Usuario usuario = new Usuario();
                usuario.setNombre(getNombre());
                usuario.setNif(getNif());
                usuario.setDireccion(getDireccion());
                usuario.setTelefono(Integer.parseInt(getTelefono()));
                usuario.setEmail(getEmail());
                usuario.setCodigo(codigousuario);
                JavaFileChooser jfc = new JavaFileChooser(false);
                if(!jfc.getImagen().equals("")){
                    usuario.setFoto(jfc.getImagen());
                }else{
                    usuario.setFoto(fotoVacia);
                }
                usuario.write();
                ventanaEmergente("El usuario '" + usuario.getNombre() + "' ha sido dado de alta.");
                codigousuario++;
                restablecerCampos();
            }else{
                ventanaEmergente("El usuario '" + getNombre() + "' ya existe");
            }
        } else {
            ventanaEmergente("Inserte como mínimo NIF y teléfono");
        }
    }

    private void ventanaEmergente(String s) {
        JOptionPane.showMessageDialog(null, s);
    }
}
