/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.SQLException;
import classes.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;

/**
 *
 * @author Christian
 */
public class ServicoBancoObra {

    private ServicoConexao conexao = new ServicoConexao();

    public void insert(Obra obra) throws SQLException {
        PreparedStatement pst = conexao.getConexao().prepareStatement("insert into tb_obra (codigo_obra,titulo,autor)"
                + " values (0,?,?)");
        pst.setString(1, obra.getTitulo());
        pst.setString(2, obra.getAutor());
        pst.executeUpdate();
        pst.close();
        conexao.close();
    }

    public void update(Obra obra) throws SQLException {
        PreparedStatement pst = conexao.getConexao().prepareStatement("update tb_obra set titulo=?,autor=? where codigo_obra = ?");
        pst.setString(1, obra.getTitulo());
        pst.setString(2, obra.getAutor());
        pst.setInt(3, obra.getCodigo());
        pst.executeUpdate();
        pst.close();
        conexao.close();
    }

    public void delete(Obra obra) throws SQLException {
        PreparedStatement pst = conexao.getConexao().prepareStatement("delete from tb_obra where codigo_obra = ?");
        pst.setInt(1, obra.getCodigo());
        pst.executeUpdate();
        pst.close();
        conexao.close();
    }

    public void setCodigoBancoObra(Obra obra) throws SQLException {
        PreparedStatement pst = conexao.getConexao().prepareStatement("select codigo_obra from tb_obra where titulo = ? and autor = ?");
        pst.setString(1, obra.getTitulo());
        pst.setString(2, obra.getAutor());

        ResultSet rs = pst.executeQuery();
        rs.first();
        obra.setCodigo(rs.getInt("codigo_obra"));
        
        rs.close();
        pst.close();
        conexao.close();
    }
    
    public ArrayList<Obra> getAll() throws SQLException {
        Statement st = conexao.getConexao().createStatement();
     
     Statement st2 = conexao.getConexao().createStatement();
     
     ResultSet rs = st.executeQuery("select * from tb_obra");
     ArrayList<Obra> lista = new ArrayList<Obra>();
     int i=0;
     while (rs.next()){
         lista.add(new Obra(rs.getInt("codigo_obra"),rs.getString("titulo"),rs.getString("autor")));
         
         //buscar pareceres da obra
         ResultSet rp = st2.executeQuery("select * from tb_parecer where codigo_obra = " + rs.getInt("codigo_obra"));
         while (rp.next()){
            lista.get(i).adicionaParecer(new Parecer(rp.getInt("codigo_parecer"),rp.getString("parecerista"),rp.getDate("data"),rp.getTime("hora"),rp.getString("parecer"))); 
         }//laço parecer
        rp.close();
        i++;
     }//laço obra 
     rs.close();
     st.close();
     st2.close();
     conexao.close();
     return lista;        
    }
}
