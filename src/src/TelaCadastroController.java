package teste;

import java.util.List;
import java.util.ResourceBundle;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TelaCadastroController implements Initializable{

    @FXML
    private Button botaoSalvar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private ComboBox<String> cbCategoria;
    
    private ObservableList<String> obsCategoria;

    @FXML
    private ComboBox<String> cbEstadoCivil;

    private ObservableList<String> obsEstadoCivil;

    @FXML
    private DatePicker dpNascimento;

    @FXML
    private ToggleGroup mail;

    @FXML
    private RadioButton rbCartaTrabalho;

    @FXML
    private RadioButton rbIsHomem;

    @FXML
    private RadioButton rbSemestre2;

    @FXML
    private ToggleGroup semester;

    @FXML
    private ToggleGroup sex;

    @FXML
    private TextField tfAnoFormatura;

    @FXML
    private TextField tfBairroCons;

    @FXML
    private TextField tfBairroRes;

    @FXML
    private TextField tfCPF;

    @FXML
    private TextField tfCelular;

    @FXML
    private TextField tfCepCons;

    @FXML
    private TextField tfCepRes;

    @FXML
    private TextField tfCidadeCons;

    @FXML
    private TextField tfCidadeRes;

    @FXML
    private TextField tfComplementoCons;

    @FXML
    private TextField tfComplementoRes;

    @FXML
    private TextField tfConselho;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfEspecialidades;

    @FXML
    private TextField tfLogradouroCons;

    @FXML
    private TextField tfLogradouroRes;

    @FXML
    private TextField tfMae;

    @FXML
    private TextField tfNacionalidade;

    @FXML
    private TextField tfNaturalidade;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfNumeroCons;

    @FXML
    private TextField tfNumeroConselho;

    @FXML
    private TextField tfNumeroRes;

    @FXML
    private TextField tfOrgaoEmissor;

    @FXML
    private TextField tfPai;

    @FXML
    private TextField tfRG;

    @FXML
    private TextField tfTelRes;

    @FXML
    private TextField tfTelefoneCons;

    @FXML
    private TextField tfUfCons;

    @FXML
    private TextField tfUfRes;

    @FXML
    private CheckBox ckbPrimParcela;
    
    @FXML
    private VBox campoConselho;

    @FXML
    private VBox campoEspecialidades;

    @FXML
    private VBox campoMail;
    
    @FXML
    private HBox bloco0;

    @FXML
    private HBox bloco1;

    @FXML
    private HBox bloco2;

    private void carregarCategorias() {
    	
    	List<String> categorias = new ArrayList<String>();
    	
    	categorias.add("Efetivo");
    	categorias.add("Recém-Formado");
    	categorias.add("Estudante");
    	categorias.add("ASB");
    	categorias.add("TSB");
    	categorias.add("APD");
    	categorias.add("TPD");
    	categorias.add("Afins");
    	
    	obsCategoria = FXCollections.observableArrayList(categorias);

    	cbCategoria.getItems().clear();;
    	cbCategoria.setItems(obsCategoria);
    }
    
    private void carregarEstadosCivis() {
    	
    	List<String> estadosCivis = new ArrayList<String>();

    	estadosCivis.add("Solteiro(a)");
    	estadosCivis.add("Casado(a)");
    	estadosCivis.add("Viúvo(a)");
    	estadosCivis.add("Separado(a)");
    	estadosCivis.add("Divorciado(a)");
    	
    	obsEstadoCivil = FXCollections.observableArrayList(estadosCivis);
    	
    	cbEstadoCivil.getItems().clear();
    	cbEstadoCivil.setItems(obsEstadoCivil);
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		carregarCategorias();
		carregarEstadosCivis();
		
	}

    private void retornar() {
    	Main.mostrarTela(0);
    }

    @FXML
    public void voltarPressionado(ActionEvent event) {
    	retornar();
    }
    
	@FXML
	public void cadastrarAssociado(ActionEvent event) {
		
		Associado novo;
		LocalDate nascimento = dpNascimento.getValue();
		
		if(!tfAnoFormatura.getText().matches("^[0-9]+$")) {
			// Mensagem pro usuario dizendo q ele n sabe ler
			System.out.println("ano de formatura inválido");
		}else if(!Lista.validarCPF(tfCPF.getText())){
			// Mensagem pro usuario dizendo q ele n sabe ler
			System.out.println("cpf inválido");
		}else {
			if(cbCategoria.getValue().equals("Estudante"))
				novo = new Estudante(tfNome.getText(), tfRG.getText(), tfOrgaoEmissor.getText(), tfCPF.getText(), cbEstadoCivil.getValue(), tfNaturalidade.getText(), tfNacionalidade.getText(), tfPai.getText(), tfMae.getText(), tfTelRes.getText(), tfCelular.getText(), tfEmail.getText(), rbIsHomem.isSelected(), new Endereco(tfUfRes.getText(), tfCepRes.getText(), tfCidadeRes.getText(), tfBairroRes.getText(), tfNumeroRes.getText(), tfLogradouroRes.getText(), tfComplementoRes.getText()), new Data(nascimento.getDayOfMonth(), nascimento.getMonthValue(), nascimento.getYear()), new Data(Integer.parseInt(tfAnoFormatura.getText()), rbSemestre2.isSelected()));
			else
				novo = new Formado(tfNome.getText(), tfRG.getText(), tfOrgaoEmissor.getText(), tfCPF.getText(), cbEstadoCivil.getValue(), tfNaturalidade.getText(), tfNacionalidade.getText(), tfPai.getText(), tfMae.getText(), tfTelRes.getText(), tfCelular.getText(), tfEmail.getText(), rbIsHomem.isSelected(), new Endereco(tfUfRes.getText(), tfCepRes.getText(), tfCidadeRes.getText(), tfBairroRes.getText(), tfNumeroRes.getText(), tfLogradouroRes.getText(), tfComplementoRes.getText()), new Data(nascimento.getDayOfMonth(), nascimento.getMonthValue(), nascimento.getYear()), new Data(Integer.parseInt(tfAnoFormatura.getText()), rbSemestre2.isSelected()), tfConselho.getText(), tfNumeroConselho.getText(), tfTelefoneCons.getText(), rbCartaTrabalho.isSelected(), ckbPrimParcela.isSelected(), new Endereco(tfUfCons.getText(), tfCepCons.getText(), tfCidadeCons.getText(), tfBairroCons.getText(), tfNumeroCons.getText(), tfLogradouroCons.getText(), tfComplementoCons.getText()), tfEspecialidades.getText().split(","));
		
			if(!Lista.jaExiste(novo.getCpf())) {
				Lista.listaRaw.put(novo.getCpf(), novo);
				retornar();
			}else {
				//Mensagem pro usuário falando q cpf ja foi cadastrado
				System.out.println("cpf ja cadastrado");
			}
		}
		
	}
	
	@FXML
	void filtrarCampos(ActionEvent event) {
		
		switch(cbCategoria.getValue()) {
		
			case("Estudante"):
				// Apagar campos impertinentes
				rbCartaTrabalho.setSelected(false);
				tfEspecialidades.setText("");
				tfConselho.setText("");
				tfNumeroCons.setText("");
				tfTelefoneCons.setText("");
				tfCepCons.setText("");
				tfUfCons.setText("");
				tfCidadeCons.setText("");
				tfBairroCons.setText("");
				tfLogradouroCons.setText("");
				tfNumeroConselho.setText("");
				tfComplementoCons.setText("");
				
				// Desabilitar campos impertinentes
				bloco0.setDisable(true);
				bloco1.setDisable(true);
				bloco2.setDisable(true);
				campoMail.setDisable(true);
				campoEspecialidades.setDisable(true);
				campoConselho.setDisable(true);
				ckbPrimParcela.setDisable(true);
				
				break;
				
			case("Afins"):
				// Habilitar campos possívelmente desabilitados
				bloco0.setDisable(false);
				bloco1.setDisable(false);
				bloco2.setDisable(false);
				campoMail.setDisable(false);
				campoEspecialidades.setDisable(false);
				campoConselho.setDisable(false);
				ckbPrimParcela.setDisable(false);

				break;
			case("Efetivo"):
			case("Recém-Formado"):
			case("ASB"):
			case("TSB"):
			case("APD"):
			case("TPD"):
				// Mesma ação tomada ("fall through")
				// Habilitar campos possívelmente desabilitados
				bloco0.setDisable(false);
				bloco1.setDisable(false);
				bloco2.setDisable(false);
				campoMail.setDisable(false);
				campoEspecialidades.setDisable(false);
				ckbPrimParcela.setDisable(false);
				
				//fixar campo padronizado
				tfConselho.setText("CRO");
				campoConselho.setDisable(true);
		}
		
	}
	
}
