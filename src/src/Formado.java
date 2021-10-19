package teste;


public class Formado extends Associado{

	private static final long serialVersionUID = 5L;
	protected Data conclusaoCurso;
    protected String conselhoNome, conselhoNum, telConsult, categoria;
    protected boolean cartaProTrabalho, primParcela;
    protected Endereco endConsult;
    protected String[] especialidades;

    public Formado(String nome, String rg, String rgOrgaoEmissor, String cpf, String estadoCivil, String naturalidade, String nacionalidade, String pai, String mae, String telCasa, String celular, String email, boolean isHomem, Endereco endCasa, Data nascimento, Data conclusaoCurso, String conselhoNome, String conselhoNum, String telConsult, boolean cartaProTrabalho, boolean primParcela, Endereco endConsult, String[] especialidades){
        super(nome, rg, rgOrgaoEmissor, cpf, estadoCivil, naturalidade, nacionalidade, pai, mae, telCasa, celular, email, isHomem, endCasa, nascimento);
        this.conclusaoCurso = conclusaoCurso;
        this.conselhoNome = conselhoNome;
        this.conselhoNum = conselhoNum;
        this.telConsult = telConsult;
        this.cartaProTrabalho = cartaProTrabalho;
        this.primParcela = primParcela;
        this.endConsult = endConsult;
        this.especialidades = especialidades;
        this.formado = true;
    }

    public Data getConclusaoCurso() {return this.conclusaoCurso;}
    public String getConselhoNome() {return this.conselhoNome;}
    public String getConselhoNum() {return this.conselhoNum;} 
    public String getTelConsult() {return this.telConsult;}
    public String getCategoria() {return this.categoria;}
    public boolean getCartaProTrabalho() {return this.cartaProTrabalho;}
    public boolean getPrimParcela() {return this.primParcela;}
    public Endereco getEndConsult() {return this.endConsult;}
    public String[] getEspecialidades() {return this.especialidades;}

	@Override
	public String checarPendencias() {

		String retorno;
		
		if(this.primParcela)
			retorno = "Esse associado não possui pendências.";
		else
			retorno = "Esse associado ainda não pagou a primeira parcela.";
			
		return retorno;
	}
    
    
} 