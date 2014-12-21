/*
 * La clase Usuario.java gestiona los atributos y funciones de los objetos usuario.
 */
package ClasesPrincipales;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Usuario {
    
    static private RandomAccessFile raf;
    static private String path = "usuarios.dat";
    static private long NumReg = 0;
    static private long TotalFile = 0;
    static private long TotalReg = 848;
    static private final int nChars = 50;
    private int codigo;
    private String nombre;
    private String nif;
    private String direccion;
    private int telefono;
    private String email;
    private int prestamo[];
    private String foto = "";
            
    /*
     * Constructor.
     */
    public Usuario(){
        
        codigo = 0;
        nombre = null;
        nif = null;
        direccion = null;
        telefono = 0;
        email = null;
        prestamo = new int[10];
        foto = null;
        actualizarValores();
        
    }
    
    @Override
    public String toString() {
        return codigo + ". " + nombre + " - " + nif + " - "
                + direccion + " - " + telefono + " - " + email;
    }
    
    public void setNombre(String s){
        nombre = s;
    }
    
    public void setNif(String s){
        nif = s;
    }
    
    public void setDireccion(String s){
        direccion = s;
    }
    
    public void setTelefono(int i){
        telefono = i;
    }
    
    public void setEmail(String s){
        email = s;
    }
    
    public void setPrestamo(int p) {
        
        for(int i=0; i<9; i++){            
            prestamo[i] = prestamo[i+1];            
        }
        prestamo[9] = p;
        
    }
    
    public void setFoto(String s){
        foto = s;
    }

    public String getNombre(){
        return nombre;
    }
    
    public String getNif(){
        return nif;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    public int getTelefono(){
        return telefono;
    }
    
    public String getEmail(){
        return email;
    }
    
    public int getPrestamo(int i){
        return prestamo[i];
    }
    public int getPrestamo(){
        return prestamo[9];
    }
    
    public String getFoto(){
        return foto;
    }
    
    public void setCodigo(int i){
        codigo = i;
    }
    
    public int getCodigo(){
        return codigo;
    }
    /*
     * Abre el fichero, se coloca al final de este y actualiza NumReg (cantidad 
     * de usuarios en el fichero).
     */
    private void open() throws FileNotFoundException, IOException {
        raf = new RandomAccessFile(path, "rw");
        TotalFile = raf.length();
        raf.seek(TotalFile);
        NumReg = TotalFile / TotalReg;
    }
    /*
     * Actualiza NumReg y cierra el fichero.
     */
    private void close() throws IOException {
        NumReg = raf.length() / TotalReg;
        raf.close();
    }
    /*
     * Añade espacios hasta llenar el espacio reservado para cada usuario.
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
    // Actualiza NumReg.
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
     * Abre el fichero actualizando NumReg, escribe el nuevo usuario en el 
     * fichero y lo cierra volviendo a actualizar NumReg.
     */
    public void write() throws FileNotFoundException, IOException {
        open();
        raf.writeInt(codigo);
        raf.writeChars(igualar(nombre, nChars));
        raf.writeChars(igualar(nif, nChars));
        raf.writeChars(igualar(direccion, nChars));
        raf.writeInt(telefono);
        raf.writeChars(igualar(email, nChars));
        writeInts(prestamo);
        raf.writeChars(igualar(foto, 200));
        close();
    }
    /*
     * i es una variable int que se pasa por parámetro que indica el usuario que
     * se quiere buscar. Si i >= NumReg significa que el libro no existe. 
     * Sino abre el fichero, lee el usuario que se ha buscado y lo cierra.
     */
    public void read(int i) throws FileNotFoundException, IOException {

        if (i < NumReg) {

            open();
            raf.seek(i*TotalReg);
            codigo = raf.readInt();
            nombre = readStrings(nChars);
            nif = readStrings(nChars);
            direccion = readStrings(nChars);
            telefono = raf.readInt();
            email = readStrings(nChars);
            prestamo = readInts(prestamo.length);
            foto = readStrings(200);
            close();
            
            
        } else {
            
            codigo = 0;
            nombre = null;
            nif = null;
            direccion = null;
            telefono = 0;
            email = null;
            prestamo = new int[5];
            foto = null;
            
        }
    }
    
    public static int totalUsuarios(){
        return (int)NumReg;
    }
    
}
