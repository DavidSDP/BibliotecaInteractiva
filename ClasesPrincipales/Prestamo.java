/*
 * Gestiona los atributos de Préstamo y sus funciones.
 */
package ClasesPrincipales;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Prestamo {
    static private RandomAccessFile raf;
    static private String path = "prestamos.dat";
    static private long NumReg = 0;
    static private long TotalFile = 0;
    static private long TotalReg = 248;
    static private final int nChars = 50;
    private int codigo;
    private int codusuario;
    private int codlibros[];
    private Date fechaout;
    private Date fechain;
    /*
     * Constructor.
     */
    public Prestamo() {

        codigo = 0;
        codusuario = 0;
        codlibros = new int[10];
        fechaout = null;
        fechain = null;
        actualizarValores();
    }
    /*
     * Constructor que pasa por parámetro el código del préstamo, el código del
     * usuario al que se le presta, el código del libro prestado y las fechas de
     * préstamo y devolución.
     */
    public Prestamo(int c, int cu, int cl[], Date fo, Date fi) throws FileNotFoundException, IOException {

        codigo = c;
        codusuario = cu;
        codlibros = cl;
        fechaout = fo;
        fechain = fi;
        open();
        close();
    }

    @Override
    public String toString() {
        if (codlibros[0] == 0) {
            return codigo + ". " + codusuario;
        } else {
            return null;
        }
    }

    public void setCodigo(int i) {
        codigo = i;
    }

    public void setCodUsuario(int i) {
        codusuario = i;
    }

    public void setCodLibros(int p) {

        for (int i = 0; i < 9; i++) {
            codlibros[i] = codlibros[i + 1];
        }
        codlibros[9] = p;

    }

    public void setFechaOut(Date d) {
        fechaout = d;
    }

    public void setFechaIn(Date d) {
        fechain = d;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCodUsuario() {
        return codusuario;
    }

    public int getCodLibros(int i) {
        return codlibros[i];
    }

    public Date getFechaOut() {
        return fechaout;
    }

    public Date getFechaIn() {
        return fechain;
    }
    
    /*
     * Abre el fichero, se coloca al final de este y actualiza la cantidad 
     * de préstamos en el fichero.
     */
    private void open() throws FileNotFoundException, IOException {
        raf = new RandomAccessFile(path, "rw");
        TotalFile = raf.length();
        raf.seek(TotalFile);
        NumReg = TotalFile / TotalReg;
    }
    /*
     * Actualiza la cantidad de préstamos en el fichero y lo cierra.
     */
    private void close() throws IOException {
        NumReg = raf.length() / TotalReg;
        raf.close();
    }
    /*
     * Añade espacios hasta llegar a llenar el espacio guardado para cada 
     * objeto préstamo.
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
    private void writeSDate(String[] aux) throws IOException {
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

        return aux.replaceAll(" ", "");
    }
    /*
     * Métodos para gestionar las fechas de préstamo.
     */
    private String readSDate(int i) throws IOException {
        String aux = "";

        for (int j = 0; j < i; j++) {
            aux += raf.readChar();
        }

        return aux;
    }
    private Date toDate(String s) throws IOException, ParseException {
        
        Date date = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy", Locale.ENGLISH).parse(s);
        return date;
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
     * Actualiza NumReg (cantidad de préstamos).
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
    
    
    /*
     * Abre el fichero, actualiza NumReg (cantidad de préstamos), escribe 
     * un nuevo objeto libro y cierra el fichero volviendo a 
     * actualizar NumReg.
     */
    public void write() throws FileNotFoundException, IOException {
        open();
        raf.writeInt(codigo);
        raf.writeInt(codusuario);
        writeInts(codlibros);
        raf.writeChars(igualar(fechaout.toString(), nChars));
        raf.writeChars(igualar(fechain.toString(), nChars));
        close();
    }
    /*
     * La variable i integer que se pasa por parámetro indica el préstamo que se
     * quiere buscar. Si i < NumReg abre el fichero, lee el préstamo y cierra 
     * el fichero. Sino significa que el libro no existe.
     */
    public void read(int i) throws FileNotFoundException, IOException, ParseException {

        if (i < NumReg) {

            open();
            raf.seek(i*TotalReg);
            codigo = raf.readInt();
            codusuario = raf.readInt();
            codlibros = readInts(codlibros.length);
            fechaout = toDate(readSDate(nChars));
            fechain = toDate(readSDate(nChars));
            close();

        } else {
            
            codigo = 0;
            codusuario = 0;
            codlibros = new int[10];
            fechaout = null;
            fechain = null;
            
        }
    }
    
    public static int totalPrestamos(){
        return (int)NumReg;
    }
    
    
}
