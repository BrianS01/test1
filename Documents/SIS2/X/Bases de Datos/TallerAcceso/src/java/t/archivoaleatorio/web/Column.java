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
public class Column {

    int tamañoRg;
    boolean elExi = true;
    RandomAccessFile archivo;

    public void crearArchivo() throws FileNotFoundException {
        this.archivo = new RandomAccessFile("Columnas.txt", "rw");
    }

    public void crearColumn(String tipoDato, String nombre, int fkTabla) throws IOException {
        if (archivo.length() == 0) {
            System.out.println("Tamano actual: " + tamañoRg);
            archivo.writeInt(1);
            archivo.writeUTF("\r\n");

            archivo.seek(70);
            archivo.writeInt(tamañoRg);
            archivo.writeUTF(tipoDato);

            archivo.seek(97);
            archivo.writeUTF(nombre);

            archivo.seek(120);
            archivo.writeInt(fkTabla);

            archivo.writeChar('A');
            archivo.writeUTF("\r\n");

        } else {
            archivo.seek(0);
            tamañoRg = (archivo.readInt() + 1);
            archivo.seek(0);
            archivo.writeInt(tamañoRg);

            System.out.println("Tamano actual: " + tamañoRg * 70);

            archivo.seek(tamañoRg * 70);
            archivo.writeInt(tamañoRg);
            archivo.writeUTF(tipoDato);

            archivo.seek((tamañoRg * 70) + 27);
            archivo.writeUTF(nombre);

            archivo.seek((tamañoRg * 70) + 50);
            archivo.writeInt(fkTabla);

            archivo.writeChar('A');
            archivo.writeUTF("\r\n");

        }

    }

    public void leerColum(int codigo) throws IOException {
        existe(codigo);
        if (elExi == true) {
            archivo.seek((codigo * 70));
            System.out.print(archivo.readInt() + " ");
            System.out.print(archivo.readUTF() + " ");

            archivo.seek((codigo * 70) + 27);
            System.out.print(archivo.readUTF() + " ");

            archivo.seek((codigo * 70) + 50);
            System.out.print(archivo.readInt() + " ");

            System.out.println(archivo.readChar() + " ");
        }
    }

    public void actualizarColum(int codigo, String Campo, String newDato) throws IOException {
        existe(codigo);
        if (elExi == true) {
            archivo.seek(codigo * 70);

            if ("tipoDato" == Campo) {
                archivo.skipBytes(4);
                archivo.writeUTF(newDato);
            }
            if ("nombre" == Campo) {
                archivo.skipBytes(27);
                archivo.writeUTF(newDato);
            }
            if ("fkTabla" == Campo) {
                archivo.skipBytes(27);
                archivo.writeInt(Integer.parseInt(newDato));
            }
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

    public void existe(int codigo) throws IOException {
        archivo.seek(codigo * 70);
        archivo.skipBytes(54);
        char estado = archivo.readChar();
        if ('A' == estado) {
            System.out.println("Elemento si existe");
        } else {
            this.elExi = false;
            System.out.println("Elemento no existe");
        }
    }

}
