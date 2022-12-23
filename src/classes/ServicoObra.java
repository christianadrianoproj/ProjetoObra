/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import banco.ServicoBancoObra;
import banco.ServicoBancoParecer;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Christian
 */
public class ServicoObra {

    private ArrayList<Obra> listaObra;

    public ServicoObra() {
        listaObra = new ArrayList<Obra>();
    }

    public void persitirBanco(Obra obra) {
        ServicoBancoObra srvObra = new ServicoBancoObra();
        ServicoBancoParecer srvParecer = new ServicoBancoParecer();
        try {
            srvObra.insert(obra);
            srvObra.setCodigoBancoObra(obra);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }

        ArrayList<Parecer> listaparecer = obra.getLista();

        for (Parecer p : listaparecer) {
            try {
                srvParecer.insert(p, obra.getCodigo());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }

    public void adicionaObra(Obra obra) {
        this.listaObra.add(obra);
    }

    public String toString() {
        String res = "";
        for (Obra o : listaObra) {
            res += o.toString() + "\n";
        }
        return res;
    }

}
