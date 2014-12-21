/*
 * Cambia el tipo de letra del programa a calibri.
 */
package ClasesPrincipales;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.FileInputStream;
import java.io.IOException;

public class CustomFont {
    
    private Font font = null;
    private String name;
    
    public CustomFont(){
        try {
            this.name = "fonts/calibri.ttf";
            FileInputStream fis =  new FileInputStream(name);
            font = Font.createFont(Font.TRUETYPE_FONT, fis);
        } catch (FontFormatException | IOException ex) {
            System.out.println("La fuente "+name+" no pudo cargarse");
            System.out.println("Se cargará la fuente por defecto: Arial");
            font = new Font("Arial", Font.PLAIN, 14);
        }
        
    }
    
    public Font fuente(){
        return font.deriveFont(Font.PLAIN, 14);
    }
    
    public Font fuentenegrita(){
        return font.deriveFont(Font.BOLD, 14);
    }
    
}
