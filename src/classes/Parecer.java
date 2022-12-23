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
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parecer {

    private int codigo;
    private String parecerista;
    private Date data;
    private Date hora;
    private String conteudo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getParecerista() {
        return parecerista;
    }

    public void setParecerista(String parecerista) {
        this.parecerista = parecerista;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Parecer(String parecerista, Date data, Date hora, String conteudo) {
        this.parecerista = parecerista;
        this.data = data;
        this.hora = hora;
        this.conteudo = conteudo;
    }

    public Parecer(int codigo, String parecerista, Date data, Date hora, String conteudo) {
        this.codigo = codigo;
        this.parecerista = parecerista;
        this.data = data;
        this.hora = hora;
        this.conteudo = conteudo;
    }

    public Parecer() {
        this.codigo = 0;
        this.parecerista = "";
        this.conteudo = "";
    }

    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hr = new SimpleDateFormat("HH:mm:ss");
        return "Código: " + this.getCodigo() + "\n Parecerista: " + this.getParecerista() + "\n Data: " + df.format(this.getData()) + "\n Hora: "
                + hr.format(this.getHora()) + "\n Conteudo: " + this.getConteudo();
    }

}
