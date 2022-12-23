/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.SQLException;
import classes.*;
import java.sql.PreparedStatement;

/**
 *
 * @author Christian
 */
public class ServicoBancoParecer {

    private ServicoConexao conexao = new ServicoConexao();

    public void insert(Parecer parecer, int codigoObra) throws SQLException {
        PreparedStatement pst = conexao.getConexao().prepareStatement("insert into tb_parecer (codigo_parecer,parecerista,parecer,data,hora,codigo_obra)"
                + " values (0,?,?,?,?,?)");
        pst.setString(1, parecer.getParecerista());
        pst.setString(2, parecer.getConteudo());
        pst.setDate(3, new java.sql.Date(parecer.getData().getTime()));
        pst.setTime(4, new java.sql.Time(parecer.getData().getTime()));
        pst.setInt(5, codigoObra);
        pst.executeUpdate();
        pst.close();
        conexao.close();
    }

    public void update(Parecer parecer) throws SQLException {
        PreparedStatement pst = conexao.getConexao().prepareStatement("update tb_parecer set parecerista = ?,parecer=?,data=?,hora=?)"
                + " where codigo_parecer = ?");
        pst.setString(1, parecer.getParecerista());
        pst.setString(2, parecer.getConteudo());
        pst.setDate(3, new java.sql.Date(parecer.getData().getTime()));
        pst.setTime(4, new java.sql.Time(parecer.getData().getTime()));
        pst.setInt(5, parecer.getCodigo());
        pst.executeUpdate();
        pst.close();
        conexao.close();
    }

    public void delete(Parecer parecer) throws SQLException {
        PreparedStatement pst = conexao.getConexao().prepareStatement("delete from tb_parecer where codigo_parecer = ?");
        pst.setInt(1, parecer.getCodigo());
        pst.executeUpdate();
        pst.close();
        conexao.close();
    }

}
