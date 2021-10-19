package teste;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class TelaConsultaController {

    @FXML
    private Button botaoVoltar;

    @FXML
    void voltarPressionado(ActionEvent event) {
    	Main.mostrarTela(0);
    }

}
