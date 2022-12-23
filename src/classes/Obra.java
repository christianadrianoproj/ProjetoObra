/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Christian
 */
import java.util.ArrayList;

public class Obra {

    private int codigo;
    private String titulo;
    private String autor;
    private ArrayList<Parecer> listaParecer;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void adicionaParecer(Parecer p) {
        listaParecer.add(p);
    }

    public Obra(String titulo, String autor, Parecer p) {
        this.titulo = titulo;
        this.autor = autor;
        this.listaParecer = new ArrayList<Parecer>();
        if (p != null) {
            this.adicionaParecer(p);
        }
    }

    public Obra(int codigo, String titulo, String autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.listaParecer = new ArrayList<Parecer>();
    }
    
    public Obra() {
        this.codigo = 0;
        this.titulo = "";
        this.autor = "";
        this.listaParecer = new ArrayList<Parecer>();
    }    
    
    public ArrayList<Parecer> getLista() {
        return this.listaParecer;
    }

    public String toString() {
        String res = "Código: " + this.getCodigo() + "\n Título: " + this.getTitulo() + "\n Autor: " + this.getAutor() + "\n Relação de Parecer: \n";
        for (Parecer p : listaParecer) {
            res += p.toString() + "\n";
        }
        return res;
    }
}
