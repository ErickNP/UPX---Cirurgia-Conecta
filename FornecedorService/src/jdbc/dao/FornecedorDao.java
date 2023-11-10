package jdbc.dao;

import java.util.ArrayList;
import jdbc.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FornecedorDao implements IdaoInterface{
    private Connection conn;

    public FornecedorDao(){
        conn = new ConnectionFactory().getConnection();
    };
    
    @Override
    public ArrayList<Fornecedor> consultar() {
    ArrayList<Fornecedor> lstFornecedores = new ArrayList<>();
        String sql = "SELECT * FROM fornecedores;";
        PreparedStatement comando;
        ResultSet resultado;
        try{
            comando = conn.prepareStatement(sql);
            resultado = comando.executeQuery();
            
            while(resultado.next()){
                Fornecedor f = new Fornecedor();
                f.setId(resultado.getInt("forn_id"));
                f.setNome(resultado.getString("nome_forn"));
                f.setEmail(resultado.getString("email"));
                lstFornecedores.add(f);
            }
            return lstFornecedores;
        }catch(SQLException err){
            throw new RuntimeException(err.getMessage());
        }
    }

    @Override
    public Fornecedor consultar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Fornecedor cadastrar(Fornecedor forn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
