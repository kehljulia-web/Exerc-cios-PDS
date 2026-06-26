package Classes;

public class Administrador {
	 private String nome;
	    private String email;
	    private String dataNascimento;

	    public Administrador(String nome, String email, String dataNascimento) {
	        this.nome = nome;
	        this.email = email;
	        this.dataNascimento = dataNascimento;
	    }

	    @Override
	    public String toString() {
	        return nome + " | " + email + " | " + dataNascimento;
	    }

}
