/*
 * JPanel que se despliega al pulsar el botón "Alta préstamo" del JFrame
 * principal.
 */
package PanelesPrincipales;

import ClasesPrincipales.CustomFont;
import ClasesPrincipales.Libro;
import ClasesPrincipales.Prestamo;
import ClasesPrincipales.Usuario;
import java.awt.Color;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class PanelAltaPrestamo extends JPanel{
    
    private int codigoprestamo;
    private JLabel codusuario, nif, diasdev, numLibros;
    private JComboBox numlibros;
    public JTextField codUsuario, casNif, casLetraNif;
    private JButton bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10, bInteractiva, alta, restablecer;
    private JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10, diasDev;
    private JPanel panelLibros;
    private PanelesInteractivos.FramePrincipal fp0, fp1;
    private CustomFont cf;
    
    public PanelAltaPrestamo(){
        this.setLayout(null);
        Prestamo p = new Prestamo();
        codigoprestamo = Prestamo.totalPrestamos()+1;
        initComponents();
        colocarComponentes();
        controlarBotones();
        
    }
    
    private void initComponents(){
        fp0 = new PanelesInteractivos.FramePrincipal(false, true);
        fp1 = new PanelesInteractivos.FramePrincipal(true, true);
        codusuario = new JLabel("Código de usuario");
        codUsuario = new JTextField(2);
        nif = new JLabel("NIF");
        casNif = new JTextField(7);
        casLetraNif = new JTextField(2);
        numLibros = new JLabel("Libros a prestar");
        bInteractiva = new JButton("Búsqueda Interactiva");
        diasdev = new JLabel("Introduce días para devolución:");
        diasDev = new JTextField("21");
        Integer[] op = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        numlibros = new JComboBox(op);
        bt1 = new JButton("BI");
        bt2 = new JButton("BI");
        bt3 = new JButton("BI");
        bt4 = new JButton("BI");
        bt5 = new JButton("BI");
        bt6 = new JButton("BI");
        bt7 = new JButton("BI");
        bt8 = new JButton("BI");
        bt9 = new JButton("BI");
        bt10 = new JButton("BI");
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        tf9 = new JTextField();
        tf10 = new JTextField();
        cf = new CustomFont();
        restablecer = new JButton("Restablecer");
        alta = new JButton("Alta");
        
    }
    
    private void colocarComponentes(){
        
        Border blackline;

        blackline = BorderFactory.createLineBorder(Color.black);
        TitledBorder bordeDatos = BorderFactory.createTitledBorder(blackline, "Usuario");
        TitledBorder bordeUbicacion = BorderFactory.createTitledBorder(blackline, "Códigos de libros");
        bordeDatos.setTitleJustification(TitledBorder.LEFT);
        bordeUbicacion.setTitleJustification(TitledBorder.LEFT);
        bordeDatos.setTitleFont(cf.fuentenegrita());
        bordeUbicacion.setTitleFont(cf.fuentenegrita());

        JPanel panelUsuarios = new JPanel();
        panelLibros = new JPanel();
        panelUsuarios.setBorder(bordeDatos);
        panelLibros.setBorder(bordeUbicacion);
        
        add(panelUsuarios);
        panelUsuarios.setLayout(null);
        panelUsuarios.setBounds(20, 10, 200, 100);
        
        add(panelLibros);
        panelLibros.setLayout(null);
        panelLibros.setBounds(230, 10, 365, 50);
        
        
        panelUsuarios.add(codusuario);
        codusuario.setBounds(20, 20, 100, 20);
        codusuario.setFont(cf.fuente());
        panelUsuarios.add(codUsuario);
        codUsuario.setBounds(130, 20, 20, 20);
        codUsuario.setFont(cf.fuente());
        panelUsuarios.add(nif);
        nif.setBounds(20, 45, 30, 20);
        nif.setFont(cf.fuente());
        panelUsuarios.add(casNif);
        casNif.setBounds(50, 45, 80, 20);
        casNif.setFont(cf.fuente());
        panelUsuarios.add(casLetraNif);
        casLetraNif.setBounds(130, 45, 20, 20);
        casLetraNif.setFont(cf.fuente());
        panelUsuarios.add(bInteractiva);
        bInteractiva.setBounds(10, 70, 180, 20);
        bInteractiva.setFont(cf.fuentenegrita());
        
        add(numLibros);
        numLibros.setBounds(40, 120, 180, 20);
        numLibros.setFont(cf.fuente());
        add(numlibros);
        numlibros.setBounds(140, 120, 40, 20);
        numlibros.setFont(cf.fuente());
        
        panelLibros.add(bt1);
        bt1.setBounds(40, 20, 50, 20);
        panelLibros.add(tf1);
        tf1.setBounds(10, 20, 30, 20);
        
        panelLibros.add(bt2);
        bt2.setBounds(130, 20, 50, 20);
        panelLibros.add(tf2);
        tf2.setBounds(100, 20, 30, 20);
        
        panelLibros.add(bt3);
        bt3.setBounds(220, 20, 50, 20);
        panelLibros.add(tf3);
        tf3.setBounds(190, 20, 30, 20);
        
        panelLibros.add(bt4);
        bt4.setBounds(310, 20, 50, 20);
        panelLibros.add(tf4);
        tf4.setBounds(280, 20, 30, 20);
        
        panelLibros.add(bt5);
        bt5.setBounds(40, 50, 50, 20);
        panelLibros.add(tf5);
        tf5.setBounds(10, 50, 30, 20);
        
        panelLibros.add(bt6);
        bt6.setBounds(130, 50, 50, 20);
        panelLibros.add(tf6);
        tf6.setBounds(100, 50, 30, 20);
        
        panelLibros.add(bt7);
        bt7.setBounds(220, 50, 50, 20);
        panelLibros.add(tf7);
        tf7.setBounds(190, 50, 30, 20);
        
        panelLibros.add(bt8);
        bt8.setBounds(310, 50, 50, 20);
        panelLibros.add(tf8);
        tf8.setBounds(280, 50, 30, 20);
        
        panelLibros.add(bt9);
        bt9.setBounds(130, 80, 50, 20);
        panelLibros.add(tf9);
        tf9.setBounds(100, 80, 30, 20);
        
        panelLibros.add(bt10);
        bt10.setBounds(220, 80, 50, 20);
        panelLibros.add(tf10);
        tf10.setBounds(190, 80, 30, 20);
        
        add(diasdev);
        diasdev.setBounds(250, 130, 180, 20);
        add(diasDev);
        diasDev.setBounds(440, 130, 30, 20);
        
        add(alta);
        alta.setBounds(600, 35, 115, 20);
        alta.setFont(cf.fuentenegrita());
        
        add(restablecer);
        restablecer.setBounds(600, 60, 115, 20);
        restablecer.setFont(cf.fuentenegrita());
        
        ponerFuentes();
        hacerInvisibles();
        
    }
    
    private void redimensionarPanel(boolean dosfilas){
        if(dosfilas){
            panelLibros.setBounds(230, 10, 365, 80);
        }else{
            panelLibros.setBounds(230, 10, 365, 110);
        }
    }
    private void redimensionarPanel(){
        panelLibros.setBounds(230, 10, 365, 50);
    }
    private void hacerInvisibles(){
        
        bt2.setVisible(false);
        bt3.setVisible(false);
        bt4.setVisible(false);
        bt5.setVisible(false);
        bt6.setVisible(false);
        bt7.setVisible(false);
        bt8.setVisible(false);
        bt9.setVisible(false);
        bt10.setVisible(false);
        tf2.setVisible(false);
        tf3.setVisible(false);
        tf4.setVisible(false);
        tf5.setVisible(false);
        tf6.setVisible(false);
        tf7.setVisible(false);
        tf8.setVisible(false);
        tf9.setVisible(false);
        tf10.setVisible(false);
    }
    private int getCodigo(){
        if(codUsuario.getText().isEmpty()){
            return 0;
        }
        return Integer.parseInt(codUsuario.getText());
        
    }
    private String getNif(){
        return casNif.getText() + casLetraNif.getText();
    }
    
    private void darDeAlta() throws FileNotFoundException, IOException, salirException {
        if(!casillasVacias()){
        Prestamo p = new Prestamo();
        p.setCodigo(codigoprestamo);
        Usuario usr;
        if (getCodigo() != 0) {
            usr = buscarPorCodigo();
        } else {
            usr = buscarPorNif();
        }
        if (usr != null) {
            usr.setPrestamo(codigoprestamo);
            p.setCodUsuario(usr.getCodigo());
            
            Libro l = new Libro();
            if (getLib1() != 0) {
                l.read(getLib1());
                l.setPrestamo(codigoprestamo);
                p.setCodLibros(getLib1());
                if (getLib2() != 0) {
                    l.read(getLib1());
                    l.setPrestamo(codigoprestamo);
                    p.setCodLibros(getLib2());
                    if (getLib3() != 0) {
                        l.read(getLib1());
                        l.setPrestamo(codigoprestamo);
                        p.setCodLibros(getLib3());
                        if (getLib4() != 0) {
                            l.read(getLib1());
                            l.setPrestamo(codigoprestamo);
                            p.setCodLibros(getLib4());
                            if (getLib5() != 0) {
                                l.read(getLib1());
                                l.setPrestamo(codigoprestamo);
                                p.setCodLibros(getLib5());
                                if (getLib6() != 0) {
                                    l.read(getLib1());
                                    l.setPrestamo(codigoprestamo);
                                    p.setCodLibros(getLib6());
                                    if (getLib7() != 0) {
                                        l.read(getLib1());
                                        l.setPrestamo(codigoprestamo);
                                        p.setCodLibros(getLib7());
                                        if (getLib8() != 0) {
                                            l.read(getLib1());
                                            l.setPrestamo(codigoprestamo);
                                            p.setCodLibros(getLib8());
                                            if (getLib9() != 0) {
                                                l.read(getLib1());
                                                l.setPrestamo(codigoprestamo);
                                                p.setCodLibros(getLib9());
                                                if (getLib10() != 0) {
                                                    l.read(getLib1());
                                                    l.setPrestamo(codigoprestamo);
                                                    p.setCodLibros(getLib10());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }else{
                throw new salirException();
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            p.setFechaOut(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(diasDev.getText()));
            p.setFechaIn(cal.getTime());
            p.write();
            codigoprestamo++;
            ventanaEmergente("Se ha dado de alta el préstamo");
            
        } else {
            ventanaEmergente("El usuario no existe");
        }
        }else{
            ventanaEmergente("Introdudzca usuario para el préstamo");
        }
    }
    // Busca por código de usuario.
    private Usuario buscarPorCodigo() throws FileNotFoundException, IOException {
        Usuario u = new Usuario();
        for (int i = 0; i < Usuario.totalUsuarios(); i++) {
            u.read(i);
            if (u.getCodigo() == getCodigo()) {
                return u;
            }
        }
        return null;
    }
    // Busca por el NIF del usuario.
    private Usuario buscarPorNif() throws FileNotFoundException, IOException{
        Usuario u = new Usuario();
        for (int i = 0; i < Usuario.totalUsuarios(); i++) {
            u.read(i);
            if (u.getNif().equals(getNif())) {
                return u;
            }
        }
        return null;
    }
    /* Casillas de préstamos de libros se hacen visibles la cantidad de casillas 
     * como cantidad de libros selecciones que el usuario quiera que le presten,
     * máximo 10.
     */
    private void controlarBotones(){
        
        numlibros.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent ie) {
                hacerInvisibles();
                switch((Integer) numlibros.getSelectedItem()){
                    case 1: bt1.setVisible(true);
                            tf1.setVisible(true);
                            redimensionarPanel();
                            break;
                    case 2: bt1.setVisible(true);
                            bt2.setVisible(true);
                            tf1.setVisible(true);
                            tf2.setVisible(true);
                            redimensionarPanel();
                            break;
                    case 3: bt1.setVisible(true);
                            bt2.setVisible(true);
                            bt3.setVisible(true);
                            tf1.setVisible(true);
                            tf2.setVisible(true);
                            tf3.setVisible(true);
                            redimensionarPanel();
                            break;
                    case 4: bt1.setVisible(true);
                            bt2.setVisible(true);
                            bt3.setVisible(true);
                            bt4.setVisible(true);
                            tf1.setVisible(true);
                            tf2.setVisible(true);
                            tf3.setVisible(true);
                            tf4.setVisible(true);
                            redimensionarPanel();
                            break;
                    case 5: bt1.setVisible(true);
                            bt2.setVisible(true);
                            bt3.setVisible(true);
                            bt4.setVisible(true);
                            bt5.setVisible(true);
                            tf1.setVisible(true);
                            tf2.setVisible(true);
                            tf3.setVisible(true);
                            tf4.setVisible(true);
                            tf5.setVisible(true);
                            redimensionarPanel(true);
                            break;
                    case 6: bt1.setVisible(true);
                            bt2.setVisible(true);
                            bt3.setVisible(true);
                            bt4.setVisible(true);
                            bt5.setVisible(true);
                            bt6.setVisible(true);
                            tf1.setVisible(true);
                            tf2.setVisible(true);
                            tf3.setVisible(true);
                            tf4.setVisible(true);
                            tf5.setVisible(true);
                            tf6.setVisible(true);
                            redimensionarPanel(true);
                            break;
                    case 7: bt1.setVisible(true);
                            bt2.setVisible(true);
                            bt3.setVisible(true);
                            bt4.setVisible(true);
                            bt5.setVisible(true);
                            bt6.setVisible(true);
                            bt7.setVisible(true);
                            tf1.setVisible(true);
                            tf2.setVisible(true);
                            tf3.setVisible(true);
                            tf4.setVisible(true);
                            tf5.setVisible(true);
                            tf6.setVisible(true);
                            tf7.setVisible(true);
                            redimensionarPanel(true);
                            break;
                    case 8: bt1.setVisible(true);
                            bt2.setVisible(true);
                            bt3.setVisible(true);
                            bt4.setVisible(true);
                            bt5.setVisible(true);
                            bt6.setVisible(true);
                            bt7.setVisible(true);
                            bt8.setVisible(true);
                            tf1.setVisible(true);
                            tf2.setVisible(true);
                            tf3.setVisible(true);
                            tf4.setVisible(true);
                            tf5.setVisible(true);
                            tf6.setVisible(true);
                            tf7.setVisible(true);
                            tf8.setVisible(true);
                            redimensionarPanel(true);
                            break;
                    case 9: bt1.setVisible(true);
                            bt2.setVisible(true);
                            bt3.setVisible(true);
                            bt4.setVisible(true);
                            bt5.setVisible(true);
                            bt6.setVisible(true);
                            bt7.setVisible(true);
                            bt8.setVisible(true);
                            bt9.setVisible(true);
                            tf1.setVisible(true);
                            tf2.setVisible(true);
                            tf3.setVisible(true);
                            tf4.setVisible(true);
                            tf5.setVisible(true);
                            tf6.setVisible(true);
                            tf7.setVisible(true);
                            tf8.setVisible(true);
                            tf9.setVisible(true);
                            redimensionarPanel(false);
                            break;
                    case 10: bt1.setVisible(true);
                            bt2.setVisible(true);
                            bt3.setVisible(true);
                            bt4.setVisible(true);
                            bt5.setVisible(true);
                            bt6.setVisible(true);
                            bt7.setVisible(true);
                            bt8.setVisible(true);
                            bt9.setVisible(true);
                            bt10.setVisible(true);
                            tf1.setVisible(true);
                            tf2.setVisible(true);
                            tf3.setVisible(true);
                            tf4.setVisible(true);
                            tf5.setVisible(true);
                            tf6.setVisible(true);
                            tf7.setVisible(true);
                            tf8.setVisible(true);
                            tf9.setVisible(true);
                            tf10.setVisible(true);
                            redimensionarPanel(false);
                            break;
                }
            }
        });
        
        alta.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                try {
                    try {
                        darDeAlta();
                        restablecerCasillas(true);
                    } catch (salirException ex) {
                        ventanaEmergente("Introduce al menos un libro");
                    }
                } catch (FileNotFoundException ex) {
                    System.out.println("Archivo no encontrado");
                } catch (IOException ex) {
                    System.out.println("Error de entrada/salida");
                }
            }
        });
        
        bInteractiva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                fp0.setVisible(true);
            }
        });

        bt1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                fp1.setVisible(true);
            }
        });

        bt2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                fp1.setVisible(true);
            }
        });

        bt3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                fp1.setVisible(true);
            }
        });

        bt4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                fp1.setVisible(true);
            }
        });

        bt5.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                fp1.setVisible(true);
            }
        });

        bt6.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                fp1.setVisible(true);
            }
        });

        bt7.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                fp1.setVisible(true);
            }
        });

        bt8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                fp1.setVisible(true);
            }
        });

        bt9.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                fp1.setVisible(true);
            }
        });

        bt10.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                fp1.setVisible(true);
            }
        });

        fp0.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
            }

            @Override
            public void windowClosed(WindowEvent we) {
                int i = fp0.getCodigo();

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


        fp1.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent we) {
            }

            @Override
            public void windowClosing(WindowEvent we) {
            }

            @Override
            public void windowClosed(WindowEvent we) {
                int i = fp1.getCodigo();
                if (tf1.getText().isEmpty()) {
                    setLib1(i);
                } else {
                    if (tf2.getText().isEmpty()) {
                        setLib2(i);
                    } else {

                        if (tf3.getText().isEmpty()) {
                            setLib3(i);
                        } else {

                            if (tf4.getText().isEmpty()) {
                                setLib4(i);
                            } else {

                                if (tf5.getText().isEmpty()) {
                                    setLib5(i);
                                } else {

                                    if (tf6.getText().isEmpty()) {
                                        setLib6(i);
                                    } else {

                                        if (tf7.getText().isEmpty()) {
                                            setLib7(i);
                                        } else {

                                            if (tf8.getText().isEmpty()) {
                                                setLib8(i);
                                            } else {

                                                if (tf9.getText().isEmpty()) {
                                                    setLib9(i);
                                                } else {

                                                    if (tf10.getText().isEmpty()) {
                                                        setLib10(i);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
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
       
        restablecer.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt){
                restablecerCasillas(true);
            }
        });
        
    }
    // Pone en blanco las casillas.
    private void restablecerCasillas(boolean todas){
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        tf6.setText("");
        tf7.setText("");
        tf8.setText("");
        tf9.setText("");
        tf10.setText("");
        if (todas) {
            codUsuario.setText("");
            casNif.setText("");
            casLetraNif.setText("");
            diasDev.setText("21");
        }
    }
    
    private int getLib1(){
        if(!tf1.getText().isEmpty()) {
            return Integer.parseInt(tf1.getText());
        }
        return 0;
    }
    private int getLib2(){
        if(!tf2.getText().isEmpty()) {
            return Integer.parseInt(tf2.getText());
        }
        return 0;
    }
    private int getLib3(){
        if(!tf3.getText().isEmpty()) {
            return Integer.parseInt(tf3.getText());
        }
        return 0;
    }
    private int getLib4(){
        if(!tf4.getText().isEmpty()) {
            return Integer.parseInt(tf4.getText());
        }
        return 0;
    }
    private int getLib5(){
        if(!tf5.getText().isEmpty()) {
            return Integer.parseInt(tf5.getText());
        }
        return 0;
    }
    private int getLib6(){
        if(!tf6.getText().isEmpty()) {
            return Integer.parseInt(tf6.getText());
        }
        return 0;
    }
    private int getLib7(){
        if(!tf7.getText().isEmpty()) {
            return Integer.parseInt(tf7.getText());
        }
        return 0;
    }
    private int getLib8(){
        if(!tf8.getText().isEmpty()) {
            return Integer.parseInt(tf8.getText());
        }
        return 0;
    }
    private int getLib9(){
        if(!tf9.getText().isEmpty()) {
            return Integer.parseInt(tf9.getText());
        }
        return 0;
    }
    private int getLib10(){
        if(!tf10.getText().isEmpty()) {
            return Integer.parseInt(tf10.getText());
        }
        return 0;
    }
    
    private void setBI(int i){
        codUsuario.setText(Integer.toString(i));
    }
    private void setLib1(int i){
        tf1.setText(Integer.toString(i));
    }
    private void setLib2(int i){
        tf2.setText(Integer.toString(i));
    }
    private void setLib3(int i){
        tf3.setText(Integer.toString(i));
    }
    private void setLib4(int i){
        tf4.setText(Integer.toString(i));
    }
    private void setLib5(int i){
        tf5.setText(Integer.toString(i));
    }
    private void setLib6(int i){
        tf6.setText(Integer.toString(i));
    }
    private void setLib7(int i){
        tf7.setText(Integer.toString(i));
    }
    private void setLib8(int i){
        tf8.setText(Integer.toString(i));
    }
    private void setLib9(int i){
        tf9.setText(Integer.toString(i));
    }
    private void setLib10(int i){
        tf10.setText(Integer.toString(i));
    }

    private void ponerFuentes() {
        
        bt1.setFont(cf.fuentenegrita());
        bt2.setFont(cf.fuentenegrita());
        bt3.setFont(cf.fuentenegrita());
        bt4.setFont(cf.fuentenegrita());
        bt5.setFont(cf.fuentenegrita());
        bt6.setFont(cf.fuentenegrita());
        bt7.setFont(cf.fuentenegrita());
        bt8.setFont(cf.fuentenegrita());
        bt9.setFont(cf.fuentenegrita());
        bt10.setFont(cf.fuentenegrita());
        tf1.setFont(cf.fuente());
        tf2.setFont(cf.fuente());
        tf3.setFont(cf.fuente());
        tf4.setFont(cf.fuente());
        tf5.setFont(cf.fuente());
        tf6.setFont(cf.fuente());
        tf7.setFont(cf.fuente());
        tf8.setFont(cf.fuente());
        tf9.setFont(cf.fuente());
        tf10.setFont(cf.fuente());
    }

    private void ventanaEmergente(String s) {
        JOptionPane.showMessageDialog(null, s);
    }

    private boolean casillasVacias() {
        if (codUsuario.getText().isEmpty()&&getNif().isEmpty()) {
            return true;
        }
        return false;
    }

    private static class salirException extends Exception {

        public salirException() {
            
        }
       
    }
}
