/*
 * Esta clase gestiona la ventana de selección de imágenes para los objetos
 * libro y usuario.
 */
package GUI;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import lib.CopyFile;

public class JavaFileChooser extends JFrame {
    
    private int seleccion;
    private JTextField areaTexto;
    private JFileChooser jfc;
    private String imagen = "";
    private FileNameExtensionFilter filter;
    private boolean libros;
    
    public JavaFileChooser(boolean libros){
        
        this.libros = libros;
        initComponents();
        accionesComponentes();
        
    }
    
    private void initComponents(){
        if(libros){
            jfc = new JFileChooser("images/libros/");
            jfc.setDialogTitle("Seleccione imagen para la portada del libro");
        }else{
            jfc = new JFileChooser("images/usuarios/");
            jfc.setDialogTitle("Seleccione imagen para el usuario");
        }
        filter = new FileNameExtensionFilter("JPG & GIF", "jpg", "gif");
        jfc.setFileFilter(filter);
        seleccion = jfc.showOpenDialog(areaTexto);
        
    }
    
    private void accionesComponentes() {
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String origen, destino, ori;
            origen = jfc.getSelectedFile().getAbsolutePath();

            ori = jfc.getSelectedFile().getName();
            destino = "images/importadas/" + ori;

            copiarArchivos(origen, destino);

            char[] aux = destino.toCharArray();
            imagen = "";
            for (int i = 0; i < aux.length; i++) {
                if(aux[i] == 92){
                    aux[i] = '/';
                }
                imagen += aux[i];
            }
        }
        
        
        
    }
    
    public String getImagen(){
        return imagen;
    }
    
    private void copiarArchivos(String origen, String destino){
        CopyFile cf = new CopyFile(origen, destino);
    }
    
}
