/*
 * Gestiona los atributos y funciones de los objetos libro.
 */
package ClasesPrincipales;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Libro {
    
    static private RandomAccessFile raf;
    static private String path = "libros.dat";
    static private long NumReg = 0;
    static private long TotalFile = 0;
    static private long TotalReg = 1628;
    static private final int nChars = 50;
    private int codigo;
    private String titulo;
    private String autor;
    private String editorial;
    private String ubicacion[];
    private int estado[];
    private String alta;
    private int prestamo;
    private String estropeado[];
    private String reparacion="";
    private String baja="";
    private String imagen="";
/*
 * Constructor.
 */
    public Libro(){

        codigo = 0;
        titulo = null;
        autor = null;
        editorial = null;
        ubicacion = new String[4];
        estado = new int[5];
        alta = null;
        prestamo = 0;
        estropeado = new String[2];
        estropeado[0] = "no";
        estropeado[1] = "";
        reparacion = "no";
        baja = "no";
        imagen = "";
        actualizarValores();
    }
    /*
     * Abre el fichero, actualiza NumReg (cantidad de libros en la biblioteca),
     * escribe un nuevo objeto libro y cierra el fichero volviendo a 
     * actualizar NumReg.
     */
    public void write() throws FileNotFoundException, IOException {
        open();
        raf.writeInt(codigo);
        raf.writeChars(igualar(titulo, nChars));
        raf.writeChars(igualar(autor, nChars));
        raf.writeChars(igualar(editorial, nChars));
        writeStrings(ubicacion);
        writeInts(estado);
        raf.writeChars(igualar(alta, nChars));
        raf.writeInt(prestamo);
        writeStrings(estropeado);
        raf.writeChars(igualar(reparacion, nChars));
        raf.writeChars(igualar(baja, nChars));
        raf.writeChars(igualar(imagen, 200));
        close();
    }
    /*
     * i es una variable int que se pasa por parámetro que indica el libro a buscar.
     * Si i >= NumReg significa que el libro no existe. Sino abre el fichero, 
     * lee el libro que se ha buscado y cierra el fichero.
     */
    public void read(int i) throws FileNotFoundException, IOException {

        if (i < NumReg) {

            open();
            raf.seek(i*TotalReg);
            codigo = raf.readInt();
            titulo = readStrings(nChars);
            autor = readStrings(nChars);
            editorial = readStrings(nChars);
            ubicacion = readAStrings(ubicacion.length);
            estado = readInts(estado.length);
            alta = readStrings(nChars);
            prestamo = raf.readInt();
            estropeado = readAStrings(estropeado.length);
            reparacion = readStrings(nChars);
            baja = readStrings(nChars);
            imagen = readStrings(200);
            close();

        } else {
            codigo = 0;
            titulo = null;
            autor = null;
            editorial = null;
            ubicacion = new String[4];
            estado = new int[5];
            alta = null;
            prestamo = 0;
            estropeado = new String[2];
            reparacion = null;
            baja = null;
            imagen = null;
        }
    }
    
    public static int totalLibros(){
        return (int)NumReg;
    }

    @Override
    public String toString() {
        return codigo + ". " + titulo + " - " + autor + " - "
                + editorial + " - " + ubicacion[0] + ubicacion[1] + ubicacion[2] + ubicacion[3];
    }

    public void setCodigo(int c) {
        codigo = c;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getUNave() {
        return ubicacion[0];
    }

    public String getUEstanteria() {
        return ubicacion[1];
    }

    public int getUFila() {
        return Integer.parseInt(ubicacion[2]);
    }

    public int getUColumna() {
        return Integer.parseInt(ubicacion[3]);
    }

    public String getEstado() {
        if (estado[0] == 1) {
            return "Disponible";
        } else {
            if (estado[1] == 1) {
                return "En préstamo";
            } else {
                if (estado[2] == 1) {
                    return "Estropeado";
                } else {
                    if (estado[3] == 1) {
                        return "En reparación";
                    } else {
                        return "Baja";
                    }
                }
            }
        }
    }

    public String getAlta() {
        return alta;
    }

    public int getPrestamo() {
        return prestamo;
    }

    public String getFechaEstropeado() {
        return estropeado[0];
    }

    public int getCodigoEstropeado() {
        return (Integer.parseInt(estropeado[1]));
    }

    public String getReparacion() {
        return reparacion;
    }

    public String getBaja() {
        return baja;
    }

    public String getImagen() {
        return imagen;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setTitulo(String s) {
        titulo = s;
    }

    public void setAutor(String s) {
        autor = s;
    }

    public void setEditorial(String s) {
        editorial = s;
    }

    public void setNave(String s) {
        ubicacion[0] = s;
    }

    public void setEstanteria(String s) {
        ubicacion[1] = s;
    }

    public void setFila(int i) {
        ubicacion[2] = (Integer.toString(i));
    }

    public void setColumna(int i) {
        ubicacion[3] = (Integer.toString(i));
    }

    public void setEstado(String s) {
        switch (s) {
            case "Disponible":
                estado[0] = 1;
                estado[1] = 0;
                estado[2] = 0;
                estado[3] = 0;
                estado[4] = 0;
                break;
            case "En préstamo":
                estado[0] = 0;
                estado[1] = 1;
                estado[2] = 0;
                estado[3] = 0;
                estado[4] = 0;
                break;
            case "Estropeado":
                estado[0] = 0;
                estado[1] = 0;
                estado[2] = 1;
                estado[3] = 0;
                estado[4] = 0;
                break;
            case "En reparación":
                estado[0] = 0;
                estado[1] = 0;
                estado[2] = 0;
                estado[3] = 1;
                estado[4] = 0;
                break;
            case "Baja":
                estado[0] = 0;
                estado[1] = 0;
                estado[2] = 0;
                estado[3] = 0;
                estado[4] = 1;
                break;
        }
    }

    public void setAlta(String s) {
        alta = s;
    }

    public void setPrestamo(int i) {
        prestamo = i;
    }

    public void setFechaEstropeado(String s) {
        estropeado[0] = s;
    }

    public void setCodigoEstropeado(int i) {
        estropeado[1] = Integer.toString(i);
    }

    public void setReparacion(String s) {
        reparacion = s;
    }

    public void setBaja(String s) {
        baja = s;
    }

    public void setImagen(String s) {
        imagen = s;
    }
    /*
     * Abre el fichero, se coloca al final de este y actualiza la cantidad 
     * de libros en el fichero.
     */
    public void open() throws FileNotFoundException, IOException {
        raf = new RandomAccessFile(path, "rw");
        TotalFile = raf.length();
        raf.seek(TotalFile);
        NumReg = TotalFile / TotalReg;
    }
    /*
     * Actualiza la cantidad de libros en el fichero y lo cierra.
     */
    public void close() throws IOException {
        NumReg = raf.length() / TotalReg;
        raf.close();
    }
    /*
     * Añade espacios hasta llegar a llenar el espacio guardado para cada 
     * objeto libro.
     */
    private String igualar(String s, int i) {
        String aux = s;
        for (int j = aux.length(); j < i; j++) {
            aux += " ";
        }

        return aux;
    }

    private void writeStrings(String[] aux) throws IOException {
        for (int i = 0; i < aux.length; i++) {
            raf.writeChars(igualar(aux[i], nChars));
        }
    }

    private void writeInts(int[] aux) throws IOException {
        for (int i = 0; i < aux.length; i++) {
            raf.writeInt(aux[i]);
        }
    }

    private String readStrings(int i) throws IOException {
        String aux = "";

        for (int j = 0; j < i; j++) {
            aux += raf.readChar();
        }
        while(aux.endsWith(" ")){
            aux = aux.substring(0, aux.length()-1);
        }
        return aux;
    }

    private String[] readAStrings(int i) throws IOException {
        String[] aux = new String[i];

        for (int j = 0; j < i; j++) {
            aux[j] = readStrings(nChars);
        }

        return aux;
    }

    private int[] readInts(int i) throws IOException {
        int[] aux = new int[i];

        for (int j = 0; j < i; j++) {
            aux[j] = raf.readInt();
        }

        return aux;

    }
    /*
     * Actualiza NumReg.
     */
    private void actualizarValores() {
        try {
            open();
            close();
        } catch (FileNotFoundException ex) {
            System.out.println("Fichero no encontrado!");
        } catch (IOException ex) {
            System.out.println("Error de I/O");
        }
    }
    
}
