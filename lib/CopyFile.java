/*
 * Copia los archivos seleccionados como fotos de usuario y portada de libro a 
 * a la carpeta del proyecto.
 */
package lib;

import java.io.*;

public class CopyFile {

    public CopyFile(String srFile, String dtFile) {
        try {
            File f1 = new File(srFile);
            File f2 = new File(dtFile);
            FileOutputStream out;
            try (FileInputStream in = new FileInputStream(f1)) {
                out = new FileOutputStream(f2);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
            }
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage() + " in the specified directory.");
            System.exit(0);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
