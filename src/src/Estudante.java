package teste;

public class Estudante extends Associado{

	private static final long serialVersionUID = 4L;
	private static final String categoria = "estudante";
    private Data conclusaoCurso;

    public Estudante(String nome, String rg, String rgOrgaoEmissor, String cpf, String estadoCivil, String naturalidade, String nacionalidade, String pai, String mae, String telCasa, String celular, String email, boolean isHomem, Endereco endCasa, Data nascimento, Data conclusaoCurso){
        super(nome, rg, rgOrgaoEmissor, cpf, estadoCivil, naturalidade, nacionalidade, pai, mae, telCasa, celular, email, isHomem, endCasa, nascimento);
        this.conclusaoCurso = conclusaoCurso;
        this.formado = false;
    }

    public Data getConclusaoCurso(){return this.conclusaoCurso;}
    public String getCategoria(){return categoria;}

	@Override
	public String checarPendencias() {
		
		String retorno;
		
		if(this.conclusaoCurso.jaPassou())
			retorno = "A data de provável conclusão de curso desse associado (" + conclusaoCurso + ") já passou."; 
		else
			retorno = "Esse associado não possui pendências.";
		
		return retorno;
	}
    
    
}