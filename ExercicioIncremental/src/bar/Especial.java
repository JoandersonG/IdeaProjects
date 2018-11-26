package bar;

public class Especial extends Cliente {
    private String endereco;
    private String telefone;
    private String email;
    private char sexo;

    public Especial(int id, String nome, int tipo, String endereco, String telefone, String email, char sexo) {
        super(id, nome, tipo);
        this.endereco = endereco;
        telefone = telefone;
        this.email = email;
        this.sexo = sexo;
        super.setCategoria(1);
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEndereço: " + endereco + "\nTelefone: " + telefone + "\nE-mail: " + email;
    }
}
