package jdbc.model;

import java.sql.Date;

public class Paciente {

    private int id;
    private String nome;
    private String rg;
    private Date data;
    private String convenio;
    private int numeroConv;
    private int telefone;
    private String email;
    private String cidade;
    private String cep;

    public Paciente() {
    }

    public Paciente(int id, String nome, String rg, Date data, String convenio, int numeroConv, int telefone, String email, String cidade, String cep) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.data = data;
        this.convenio = convenio;
        this.numeroConv = numeroConv;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
        this.cep = cep;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public int getNumeroConv() {
        return numeroConv;
    }

    public void setNumeroConv(int numeroConv) {
        this.numeroConv = numeroConv;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
