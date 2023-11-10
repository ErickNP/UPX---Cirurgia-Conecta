package jdbc.dao;

import java.util.ArrayList;
import jdbc.model.Fornecedor;

public interface IdaoInterface {
    public ArrayList<Fornecedor> consultar();
    public Fornecedor consultar(int id);
    public Fornecedor cadastrar(Fornecedor forn);
    public boolean excluir(int id);
}
