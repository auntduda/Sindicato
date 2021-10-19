package teste;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application{
	//torna possível a mudança de telas
	static AnchorPane root;
	//armazena todas as telas
	static List<GridPane> telas = new ArrayList<GridPane>();
	//guarda em qual tela o programa se encontra. default = 0
	static int telaAtual = 0;
	//ajuda a chamar os eventos decorrentes de se fechar o programa
	private static Stage janela;
	//nome do arquivo onde a lista será salva
	private static final String save = "save";

	@Override
	public void start(Stage stage) throws IOException{
		
		janela = stage;
		
		Lista.inicializarLista(save);
		
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("Ancora.fxml"));
	
			telas.add((GridPane) FXMLLoader.load(getClass().getResource("tela1.fxml")));
			telas.add((GridPane) FXMLLoader.load(getClass().getResource("telaConsulta.fxml")));
			telas.add((GridPane) FXMLLoader.load(getClass().getResource("telaCadastro.fxml")));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
			
			root.getChildren().add(telas.get(0));
		    AnchorPane.setTopAnchor(telas.get(0), 0.0);
		    AnchorPane.setLeftAnchor(telas.get(0), 0.0);
		    AnchorPane.setRightAnchor(telas.get(0), 0.0);
		    AnchorPane.setBottomAnchor(telas.get(0), 0.0);
			
			Scene cena = new Scene(root);
			
			janela.setOnCloseRequest(e -> {
				try {
					encerraPrograma();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			
			janela.setTitle("ABCD-RJ Banco de Associados");
			janela.setScene(cena);
			janela.show();
	}
	
	
	public static void mostrarTela(int indice) {
		
		root.getChildren().remove(telas.get(telaAtual));
		root.getChildren().add(telas.get(indice));
	    AnchorPane.setTopAnchor(telas.get(indice), 0.0);
	    AnchorPane.setLeftAnchor(telas.get(indice), 0.0);
	    AnchorPane.setRightAnchor(telas.get(indice), 0.0);
	    AnchorPane.setBottomAnchor(telas.get(indice), 0.0);
		telaAtual = indice;
	}
	
	private void encerraPrograma() throws IOException {
		Lista.salvarLista(save);
		janela.close();
	}
	
	public static void main (String[] args) {
		launch(args);
	}
	
}
