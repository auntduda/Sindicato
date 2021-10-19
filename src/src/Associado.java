package teste;

import java.io.Serializable;

public abstract class Associado implements Serializable{

	private static final long serialVersionUID = 1L;
	protected String nome, rg, rgOrgaoEmissor, cpf, estadoCivil, naturalidade;
    protected String nacionalidade, pai, mae, telCasa, celular, email;
    protected boolean formado, isHomem;
    protected Endereco endCasa;
    protected Data nascimento;

    protected Associado(String nome, String rg, String rgOrgaoEmissor, String cpf, String estadoCivil, String naturalidade, String nacionalidade, String pai, String mae, String telCasa, String celular, String email, boolean isHomem, Endereco endCasa, Data nascimento){
        this.nome = nome;
        this.rg = rg;
        this.rgOrgaoEmissor = rgOrgaoEmissor;
        this.cpf = cpf;
        this.estadoCivil = estadoCivil;
        this.naturalidade = naturalidade;
        this.nacionalidade = nacionalidade;
        this.pai = pai;
        this.mae = mae;
        this.telCasa = telCasa;
        this.celular = celular;
        this.email = email;
        this.isHomem = isHomem;
        this.endCasa = endCasa;
        this.nascimento = nascimento;
    }

    public String getNome(){return this.nome;}
    public String getRg(){return this.rg;}
    public String getRgOrgaoEmissor(){return this.rgOrgaoEmissor;}
    public String getCpf(){return this.cpf;}
    public String getEstadoCivil(){return this.estadoCivil;}
    public String getNaturalidade(){return this.naturalidade;}
    public String getNacionalidade(){return this.nacionalidade;}
    public String getPai(){return this.pai;}
    public String getMae(){return this.mae;}
    public String getTelCasa(){return this.telCasa;}
    public String getCelular(){return this.celular;}
    public String getEmail(){return this.email;}
    public boolean getIsHomem(){return this.isHomem;}
    public Endereco getEndCasa(){return this.endCasa;}
    public Data getNascimento(){return this.nascimento;}
    public boolean getFormado(){return this.formado;}
    
    //usado ˙nicamente para fins de debug, n„o precisa de tratamento
    public String toString(){
        return this.nome + "\n" +
        this.rg + "\n" +
        this.rgOrgaoEmissor + "\n" +
        this.cpf + "\n" +
        this.estadoCivil + "\n" +
        this.naturalidade + "\n" +
        this.nacionalidade + "\n" +
        this.pai + "\n" +
        this.mae + "\n" +
        this.telCasa + "\n" +
        this.celular + "\n" +
        this.email + "\n" +
        this.endCasa + "\n" +	// EnderÁo n„o tem toString mas n„o È necess·rio
        this.nascimento + "\n";
    }
    

	public abstract String checarPendencias();
}

class Data implements Serializable{
	
	private static final long serialVersionUID = 2L;
	int dia, mes, ano;
	boolean semestre2;
	
	public Data(int ano, boolean semestre2) {
		this.dia = 31;
		this.mes = semestre2 ? 12 : 7;
		this.ano = ano;
		this.semestre2 = semestre2;
	}
	public Data(int dia, int mes, int ano, boolean semestre2){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.semestre2 = semestre2;
	}
	public Data(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.semestre2 = false;
	}
	public String toString(){
		return Integer.toString(dia) + '/' + Integer.toString(mes) + '/' + Integer.toString(ano) + (semestre2 ? ".2" : ".1"); 
	}
	public boolean jaPassou(){return false;}
	
	public int getDia(){return this.dia;}
	public int getMes(){return this.mes;}
	public int getAno(){return this.ano;}
	public boolean getSemestre2(){return this.semestre2;}
	
}

class Endereco implements Serializable{
	
	private static final long serialVersionUID = 3L;
	String cidade, bairro, CEP, complemento, logradouro, numero, UF;
	
	public Endereco(String UF, String CEP, String cidade, String bairro, String numero, String logradouro, String complemento){
		this.UF = UF;
		this.CEP = CEP;
		this.cidade = cidade;
		this.bairro = bairro;
		this.numero = numero;
		this.logradouro = logradouro;
		this.complemento = complemento;
	}
	
	public String getUF(){return this.UF;}
	public String getCEP(){return this.CEP;}
	public String getCidade(){return this.cidade;}
	public String getBairro(){return this.bairro;}
	public String getNumero(){return this.numero;}
	public String getLogradouro(){return this.logradouro;}
	public String getComplemento(){return this.complemento;}
	
	public void setUF(String UF){this.UF = UF;}
	public void setCEP(String CEP){this.CEP = CEP;}
	public void setCidade(String cidade){this.cidade = cidade;}
	public void setBairro(String bairro){this.bairro = bairro;}
	public void setNumero(String numero){this.numero = numero;}
	public void setLogradouro(String logradouro){this.logradouro = logradouro;}
	public void setComplemento(String complemento){this.complemento = complemento;}
	
}




/*================================================================================================================================
categoria no formulario e primeiro pagamento.
efetivo, e recem-formado: tudo menos provavel conclusao
estudante: n tem: CRO, formado no ano, estudante recebe correspondencia sempre na residencia, n tem consult√≥rio nem telde constult,
 n √© especialisata nem especializa√ß√£o, comprovante de pagamento. TEM: provavel conclusao de curso

ASB, TSB, APD, TPD: protese tem laboratorio ao inv√©s de consultorio.
AFINS: conselhoNome de classe ao inv√©s de cro.
================================================================================================================================*/