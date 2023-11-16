package jdbc.model;


public class Paciente {

    private int id;
    private String nome;
    private String rg;
    private String data;
    private String convenio;
    private int numeroConv;
    private String telefone;
    private String email;
    private String cidade;
    private String cep;

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }
    private String medico;

    public Paciente() {
    }

    public Paciente(int id, String nome, String rg, String data, String convenio, int numeroConv, String telefone, String email, String cidade, String cep) {
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
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
