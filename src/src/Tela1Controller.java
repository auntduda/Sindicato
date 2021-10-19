package teste;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Tela1Controller {

    @FXML
    private Button botaoCadastro;

    @FXML
    private Button botaoConsulta;

    @FXML
    void toTelaCadastro(ActionEvent event) {
    	Main.mostrarTela(2);
    }

    @FXML
    void toTelaConsulta(ActionEvent event) {
    	Main.mostrarTela(1);
    }

}
