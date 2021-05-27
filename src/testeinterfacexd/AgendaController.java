/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeinterfacexd;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class AgendaController implements Initializable {

    @FXML
    private ImageView imgInicio;
    @FXML
    private ImageView imgInicioBlue;
    @FXML
    private Button btnInicio;
    @FXML
    private ImageView imgAgenda;
    @FXML
    private ImageView imgAgendaBlue;
    @FXML
    private Button btnAgenda;
    @FXML
    private ImageView imgCliente;
    @FXML
    private ImageView imgClienteBlue;
    @FXML
    private Button btnCliente;
    @FXML
    private ImageView imgVendas;
    @FXML
    private ImageView imgVendasBlue;
    @FXML
    private Button btnVendas;
    @FXML
    private ImageView imgEstoque;
    @FXML
    private ImageView imgEstoqueBlue;
    @FXML
    private Button btnEstoque;
    @FXML
    private ImageView imgFinanceiro;
    @FXML
    private ImageView imgFinanceiroBlue;
    @FXML
    private Button btnFinanceiro;
    @FXML
    private ImageView imgRelatorio;
    @FXML
    private ImageView imgRelatorioBlue;
    @FXML
    private Button btnRelatorio;
    @FXML
    private ImageView imgSair;
    @FXML
    private Pane paneSelected;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        btnInicio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                app.changeScreen("inicio");
            }
        });
        
        
    }    
    
}
