/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t.archivoaleatorio.web;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Mario-Bx
 */
public class Schema {

    int tamañoRg;
    boolean elExi = true;
    RandomAccessFile archivo;

    public void crearArchivo() throws FileNotFoundException {
        this.archivo = new RandomAccessFile("Schema.txt", "rw");
    }

    public void existe(int codigo) throws IOException {
        archivo.seek(codigo * 40);
        archivo.skipBytes(30);
        char estado = archivo.readChar();
        if ('A' == estado) {
            System.out.println("Elemento si existe");
        } else {
            this.elExi = false;
            System.out.println("Elemento no existe");
        }
    }

    public void crearSch(String nombre) throws IOException {
        if (archivo.length() == 0) {
            System.out.println("Tamano actual: " + tamañoRg);
            archivo.writeInt(1);
            archivo.writeUTF("\r\n");

            archivo.seek(40);
            archivo.writeInt(tamañoRg);
            archivo.writeUTF(nombre);

            archivo.seek(70);

            archivo.writeChar('A');
            archivo.writeUTF("\r\n");

        } else {
            archivo.seek(0);
            tamañoRg = (archivo.readInt() + 1);
            archivo.seek(0);
            archivo.writeInt(tamañoRg);

            System.out.println("Tamano actual: " + tamañoRg * 40);

            archivo.seek(tamañoRg * 40);
            archivo.writeInt(tamañoRg);
            archivo.writeUTF(nombre);

            archivo.seek((tamañoRg * 40) + 30);

            archivo.writeChar('A');
            archivo.writeUTF("\r\n");
        }
    }

    public void leerSch(int codigo) throws IOException {
        existe(codigo);
        if (elExi == true) {
            archivo.seek((codigo * 40));
            System.out.print(archivo.readInt() + " ");
            System.out.print(archivo.readUTF() + " ");

            archivo.seek((codigo * 40) + 30);

            System.out.println(archivo.readChar() + " ");
        }
    }

    public void actualizarSch(int codigo, String newDato) throws IOException {
        existe(codigo);
        if (elExi == true) {
            archivo.seek(codigo * 40);
            archivo.skipBytes(4);
            archivo.writeUTF(newDato);

        }
    }

    public void borrarRegistro(int codigo) throws IOException {
        existe(codigo);
        if (elExi == true) {
            archivo.seek(archivo.getFilePointer() - 2);
            archivo.writeChar('B');
            System.out.println("Elemento Eliminado");
        }
    }
}
