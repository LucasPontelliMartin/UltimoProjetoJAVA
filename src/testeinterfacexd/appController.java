/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeinterfacexd;

// <editor-fold defaultstate="collapsed" desc="IMPORTS">
import Controller.ClienteController;
import Controller.ProdutoController;
import Controller.VendaController;
import Model.ProdutoModel;
import Model.ClienteModel;
import Model.VendaModel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import javafx.scene.input.MouseEvent;

// </editor-fold>

public class appController implements Initializable {
    
    // <editor-fold defaultstate="collapsed" desc="Variaveis FXML">
    @FXML
    private Button btnInicio;
    @FXML
    private Button btnAgenda;
    @FXML
    private Pane paneSelected;
    @FXML
    private ImageView imgAgendaBlue;
    @FXML
    private ImageView imgInicioBlue;
    @FXML
    private ImageView imgClienteBlue;
    @FXML
    private Button btnCliente;
    @FXML
    private ImageView imgVendasBlue;
    @FXML
    private Button btnVendas;
    @FXML
    private ImageView imgEstoqueBlue;
    @FXML
    private Button btnEstoque;
    @FXML
    private ImageView imgFinanceiroBlue;
    @FXML
    private Button btnFinanceiro;
    @FXML
    private Pane paneEstoque1;
    @FXML
    private ImageView imgAddProd;
    @FXML
    private Pane paneNovoProd;
    @FXML
    private TableView<ProdutoModel> tbConsumoCliente;
    @FXML
    private TableColumn<ProdutoModel, String> clmCodigo;
    @FXML
    private TableColumn<ProdutoModel, String> clmCategoria;
    @FXML
    private TableColumn<ProdutoModel, String> clmProduto;
    @FXML
    private TableColumn<ProdutoModel, String> clmQuantidade;
    @FXML
    private TableColumn<ProdutoModel, String> clmPrecoCusto;
    @FXML
    private TableColumn<ProdutoModel, String> clmPrecoVenda;
    @FXML
    private TableView<ProdutoModel> tbInsumo;
    @FXML
    private TableColumn<ProdutoModel, String> clmCodigoInsummo;
    @FXML
    private TableColumn<ProdutoModel, String> clmProdutoInsumo;
    @FXML
    private TableColumn<ProdutoModel, String> clmQuantidadeInsumo;
    @FXML
    private TableColumn<ProdutoModel, String> clmPrecoCustoInsumo;
    @FXML
    private ComboBox<String> cmbTipoProd;   
    @FXML
    private ComboBox<String> cmbCategoriaProd;
    @FXML
    private TextField txtNomeProd;
    @FXML
    private TextField txtPrecoCusto;
    @FXML
    private TextField txtPrecoVenda;
    @FXML
    private TextField txtQuantidade;
    Alert a = new Alert(AlertType.NONE);
    
    @FXML
    private ImageView imgInicio;
    @FXML
    private ImageView imgAgenda;
    @FXML
    private ImageView imgCliente;
    @FXML
    private ImageView imgVendas;
    @FXML
    private ImageView imgEstoque;
    @FXML
    private ImageView imgFinanceiro;
    @FXML
    private ImageView imgSair;
    @FXML
    private ImageView imgInsumo;
    @FXML
    private Pane paneInicio;
    @FXML
    private ImageView btnNovoCliente;
    @FXML
    private Pane paneNovoCliente;
    @FXML
    private TextField txtNomeCliente;
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTelefone;
    @FXML
    private Button btnFecharNovoCliente;
    @FXML
    private Pane paneCliente;
    @FXML
    private Button btnSalvarCliente;
    @FXML
    private Button btnLimparCliente;
    @FXML
    private TableView<ClienteModel> tbCliente;
    @FXML
    private TableColumn<ClienteModel, String> clmNomeCliente;
    @FXML
    private TableColumn<ClienteModel, String> clCpf;
    @FXML
    private TableColumn<ClienteModel, String> clEmail;
    @FXML
    private TableColumn<ClienteModel, String> clTelefone;
    @FXML
    private Pane paneAgenda;
    @FXML
    private Pane paneFinanceiro;
    @FXML
    private ImageView txtVendas;
    @FXML
    private ImageView txtCustos;
    @FXML
    private ImageView txtLucros;
    @FXML
    private TextArea txtCampoLucro;
    @FXML
    private TextArea txtCampoVendas;
    @FXML
    private TextArea txtCampoCustos;
    @FXML
    private Button btnHistoricoAgendamento;
    @FXML
    private Button btnHistoricoEstoque;
    @FXML
    private Button btnHistoricoComandas;
    @FXML
    private Button btnHistoricoCliente;
    // </editor-fold>
    @FXML
    private Button btnLimparModNovoProduto;
    @FXML
    private Button btnSalvarNovoProd;
    @FXML
    private ImageView btnSairModNovoProduto;
    @FXML
    private Button btnLimparModNovoProduto1;
    @FXML
    private Button btnSalvarNovoProd1;
    @FXML
    private Pane paneVenda;
    @FXML
    private TableView<VendaModel> tbConsumoVenda;
    @FXML
    private TableColumn<VendaModel, String> clmCodigoVenda;
    @FXML
    private TableColumn<VendaModel, String> clmProdutoVenda;
    @FXML
    private TableColumn<VendaModel, String> clmQuantidadeVenda;
    @FXML
    private TableColumn<VendaModel, String> clmPrecoUnidadeVenda;
    @FXML
    private TableColumn<VendaModel, String> clmPrecoVendaVenda;
    @FXML
    private ImageView imgAddVenda;
    @FXML
    private Pane paneNovaVenda;
    @FXML
    private Button btnLimparModNovoProduto2;
    @FXML
    private ImageView btnSairModNovoProduto1;
    @FXML
    private TextField txtCodigoVenda;
    @FXML
    private TextField txtNomeProdVenda;
    @FXML
    private TextField txtPrecoCustoVenda;
    @FXML
    private TextField txtQuantidadeVenda;
    @FXML
    private Button btnSalvarNovaVenda;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // <editor-fold defaultstate="collapsed" desc="Botao Inicio">
            btnInicio.setOnAction((ActionEvent event) -> {
            paneSelected.setLayoutY(400);
            
            btnAgenda.setTextFill(Color.BLACK);
            btnCliente.setTextFill(Color.BLACK);
            btnVendas.setTextFill(Color.BLACK);
            btnEstoque.setTextFill(Color.BLACK);
            btnFinanceiro.setTextFill(Color.BLACK);
            
            btnInicio.setTextFill(Color.web("#226cfc"));
            
            imgAgendaBlue.setVisible(false);
            imgInicioBlue.setVisible(true);
            imgClienteBlue.setVisible(false);
            imgVendasBlue.setVisible(false);
            imgEstoqueBlue.setVisible(false);
            imgFinanceiroBlue.setVisible(false);
            
            
            paneEstoque1.setVisible(false);
            paneNovoProd.setVisible(false);
            paneCliente.setVisible(false);
            paneInicio.setVisible(false);  
            paneAgenda.setVisible(false);
            paneFinanceiro.setVisible(false);
            paneNovoCliente.setVisible(false);
            paneVenda.setVisible(false);
            paneNovaVenda.setVisible(false);
        });
// </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Botao Agenda">
            btnAgenda.setOnAction((ActionEvent event) -> {
            paneSelected.setLayoutY(455);
            
            btnInicio.setTextFill(Color.BLACK);
            btnCliente.setTextFill(Color.BLACK);
            btnVendas.setTextFill(Color.BLACK);
            btnEstoque.setTextFill(Color.BLACK);
            btnFinanceiro.setTextFill(Color.BLACK);
            
            btnAgenda.setTextFill(Color.web("#226cfc"));
            
            imgAgendaBlue.setVisible(true);
            imgInicioBlue.setVisible(false);
            imgClienteBlue.setVisible(false);
            imgVendasBlue.setVisible(false);
            imgEstoqueBlue.setVisible(false);
            imgFinanceiroBlue.setVisible(false);
            
            paneEstoque1.setVisible(false);
            paneCliente.setVisible(false);
            paneNovoProd.setVisible(false);
            paneInicio.setVisible(false); 
            paneAgenda.setVisible(true);
            paneFinanceiro.setVisible(false);
            paneNovoCliente.setVisible(false);
            paneVenda.setVisible(false);
            paneNovaVenda.setVisible(false);
        });
// </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Botao Cliente">
            btnCliente.setOnAction((ActionEvent event) -> {
            paneSelected.setLayoutY(510);
            
            btnAgenda.setTextFill(Color.BLACK);
            btnInicio.setTextFill(Color.BLACK);
            btnAgenda.setTextFill(Color.BLACK);
            btnVendas.setTextFill(Color.BLACK);
            btnEstoque.setTextFill(Color.BLACK);
            btnFinanceiro.setTextFill(Color.BLACK);
            
            btnCliente.setTextFill(Color.web("#226cfc"));
            
            imgAgendaBlue.setVisible(false);
            imgInicioBlue.setVisible(false);
            imgClienteBlue.setVisible(true);
            imgVendasBlue.setVisible(false);
            imgEstoqueBlue.setVisible(false);
            imgFinanceiroBlue.setVisible(false);
                       
            paneEstoque1.setVisible(false);
            paneNovoProd.setVisible(false);
            paneInicio.setVisible(false); 
            paneAgenda.setVisible(false);
            paneCliente.setVisible(true);
            paneFinanceiro.setVisible(false);
            paneNovoCliente.setVisible(false);
            paneVenda.setVisible(false);
            paneNovaVenda.setVisible(false);
            initTableCliente();      
        });
// </editor-fold>
    
        // <editor-fold defaultstate="collapsed" desc="Botao Vendas">
            btnVendas.setOnAction((ActionEvent event) -> {
            paneSelected.setLayoutY(578);
            
            btnInicio.setTextFill(Color.BLACK);
            btnAgenda.setTextFill(Color.BLACK);
            btnCliente.setTextFill(Color.BLACK);
            btnEstoque.setTextFill(Color.BLACK);
            btnFinanceiro.setTextFill(Color.BLACK);

            btnVendas.setTextFill(Color.web("#226cfc"));
            
            imgAgendaBlue.setVisible(false);
            imgInicioBlue.setVisible(false);
            imgClienteBlue.setVisible(false);
            imgVendasBlue.setVisible(true);
            imgEstoqueBlue.setVisible(false);
            imgFinanceiroBlue.setVisible(false);
            
            paneEstoque1.setVisible(false);
            paneNovoProd.setVisible(false);
            paneInicio.setVisible(false); 
            paneAgenda.setVisible(false);
            paneCliente.setVisible(false);
            paneFinanceiro.setVisible(false);  
            paneNovoCliente.setVisible(false);
            paneVenda.setVisible(true);
            paneNovaVenda.setVisible(false);
                try {
                    initTableVenda();
                } catch (IOException ex) {
                    Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
            
            
            imgAddVenda.setOnMouseClicked((Event event) -> {
                   paneEstoque1.setVisible(false);
                   paneVenda.setVisible(false);
                   paneNovaVenda.setVisible(true);
                   
                   VendaController venda = new VendaController();
                try {  
                    txtCodigoVenda.setText(venda.BuscarUltimoId());
                } catch (IOException ex) {
                    Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
                }
                   
                });
             
             btnSalvarNovaVenda.setOnAction((ActionEvent event) -> {

                 VendaModel prod = new VendaModel();
                 VendaController controller = new VendaController();
                 prod.setId(txtCodigoVenda.getText());
                 prod.setProduto(txtNomeProdVenda.getText());
                 prod.setQuantidade(txtQuantidadeVenda.getText());
                 prod.setValorUnidade(txtPrecoCustoVenda.getText());
                 
                 double valor = Double.valueOf(prod.getValorUnidade()) * Integer.parseInt(prod.getQuantidade());
                 DecimalFormat df = new DecimalFormat("#,###.00");
                        prod.setValorVenda(df.format(valor)); 
               
                try {
                    controller.Salvar(prod);
                } catch (IOException ex) {
                    Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
                }
                        
                            
                  a.setAlertType(Alert.AlertType.CONFIRMATION);
                            a.setHeaderText("Venda Confirmada!");
                            a.show();
                            paneVenda.setVisible(true);
                            paneNovaVenda.setVisible(false);          
                            try {
                                initTableVenda();
                                } catch (IOException ex) {
                                    Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            });
            
// </editor-fold>
        
        // <editor-fold defaultstate="collapsed" desc="Botao Estoque">
            btnEstoque.setOnAction((ActionEvent event) -> {
            paneSelected.setLayoutY(632);
            
            btnInicio.setTextFill(Color.BLACK);
            btnAgenda.setTextFill(Color.BLACK);
            btnCliente.setTextFill(Color.BLACK);
            btnVendas.setTextFill(Color.BLACK);
            btnFinanceiro.setTextFill(Color.BLACK);
            
            btnEstoque.setTextFill(Color.web("#226cfc"));
            
            imgAgendaBlue.setVisible(false);
            imgClienteBlue.setVisible(false);
            imgInicioBlue.setVisible(false);
            imgVendasBlue.setVisible(false);
            imgEstoqueBlue.setVisible(true);
            imgFinanceiroBlue.setVisible(false);
            
            paneEstoque1.setVisible(true);
            paneNovoProd.setVisible(false);
            paneInicio.setVisible(false); 
            paneAgenda.setVisible(false);
            paneCliente.setVisible(false);
            paneFinanceiro.setVisible(false);
            paneNovoCliente.setVisible(false);
            paneVenda.setVisible(false);
            try {
                initTable();
            } catch (IOException ex) {
                Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
            }
            initTableInsumo();
        });
// </editor-fold>
       
        // <editor-fold defaultstate="collapsed" desc="Botao Financeiro">
            btnFinanceiro.setOnAction((ActionEvent event) -> {
            paneSelected.setLayoutY(693);
            
            btnInicio.setTextFill(Color.BLACK);
            btnAgenda.setTextFill(Color.BLACK);
            btnCliente.setTextFill(Color.BLACK);
            btnVendas.setTextFill(Color.BLACK);
            btnEstoque.setTextFill(Color.BLACK);
            
            btnFinanceiro.setTextFill(Color.web("#226cfc"));
            
            imgAgendaBlue.setVisible(false);
            imgClienteBlue.setVisible(false);
            imgInicioBlue.setVisible(false);
            imgVendasBlue.setVisible(false);
            imgEstoqueBlue.setVisible(false);
            imgFinanceiroBlue.setVisible(true);
            
            paneEstoque1.setVisible(false);
            paneNovoProd.setVisible(false);
            paneInicio.setVisible(false);
            paneCliente.setVisible(false);
            paneAgenda.setVisible(false);
            paneFinanceiro.setVisible(true);
            paneNovoCliente.setVisible(false);
            
            Valores();
            
        });
// </editor-fold>   
         
        /*****/
        
        // <editor-fold defaultstate="collapsed" desc="Extrasão de Relatorios">
       
       btnHistoricoAgendamento.setOnMouseClicked((Event event) -> {
           ExtrairAgendamento();
        });
       
       btnHistoricoEstoque.setOnMouseClicked((Event event) -> {
            try {
                ExtrairEstoque();
            } catch (IOException ex) {
                Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
         btnHistoricoComandas.setOnMouseClicked((Event event) -> {
                try {
                    ExtrairVendas();
                } catch (IOException ex) {
                    Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
         
         btnHistoricoCliente.setOnMouseClicked((Event event) -> {
                try {
                    ExtrairClientes();
                } catch (IOException ex) {
                    Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
// </editor-fold> 
 
        // <editor-fold defaultstate="collapsed" desc="Novo Cliente">
        
            btnNovoCliente.setOnMouseClicked((Event event) -> {
               paneNovoCliente.setVisible(true);
               paneCliente.setVisible(false);
            });
        
            btnSalvarCliente.setOnAction((ActionEvent event) -> {
              ClienteModel cliente = new ClienteModel();
              cliente.setNome(txtNomeCliente.getText());
              cliente.setCpf(txtCpf.getText());
              cliente.setEmail(txtEmail.getText());
              cliente.setTelefone(txtTelefone.getText());

              ClienteController controller = new ClienteController();
              try {
                  controller.Salvar(cliente);
              } catch (IOException ex) {
                  Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
              }
           });
            
// </editor-fold>
      
        // <editor-fold defaultstate="collapsed" desc="Novo Produto - Insumo">
        
                imgAddProd.setOnMouseClicked((Event event) -> {
                   paneEstoque1.setVisible(false);
                   paneNovoProd.setVisible(true);
                });
                
                cmbTipoProd.getItems().addAll("Cliente", "Insumos");
                cmbCategoriaProd.getItems().addAll("Bebida", "Comida");       
                cmbTipoProd.getEditor().setFont(Font.font("System", FontWeight.BLACK, 20));
        
                cmbTipoProd.setOnAction((ActionEvent event) -> {
                   if ("Insumos".equals(cmbTipoProd.getValue())) {
                       cmbCategoriaProd.setDisable(true);
                       txtPrecoVenda.setEditable(false);
                   }
                   else{
                       cmbCategoriaProd.setDisable(false);
                       txtPrecoVenda.setEditable(true);
                   }               
                });
                
                btnLimparModNovoProduto.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    txtPrecoVenda.setText("");
                    txtPrecoCusto.setText("");
                    txtQuantidade.setText("");
                    cmbTipoProd.setId("");
                    cmbCategoriaProd.setId("");
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
                
                btnSalvarNovoProd.setOnAction((ActionEvent event) -> {
           
                String tipoProduto = "";
                if (null == cmbTipoProd.getValue()) {
                    a.setAlertType(AlertType.ERROR);
                    a.setHeaderText("Selecione o tipo do produto!");
                    a.show();
                }
                else {
                    
                    tipoProduto = cmbTipoProd.getValue();

                 ProdutoModel prod = new ProdutoModel();
                 prod.setCategoria(cmbCategoriaProd.getValue());
                 prod.setProduto(txtNomeProd.getText());
                 prod.setQuantidade(txtQuantidade.getText());
                 prod.setValorCusto(txtPrecoCusto.getText());
                 prod.setValorVenda(txtPrecoVenda.getText());
                   
                   ProdutoController prodController = new ProdutoController();
                   
                    try {
                        prodController.Salvar(prod, tipoProduto);
                    } catch (IOException ex) {
                        Logger.getLogger(appController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                            
                            
                  a.setAlertType(Alert.AlertType.CONFIRMATION);
                            a.setHeaderText("Produto Cadastrado!");
                            a.show();
                            paneEstoque1.setVisible(true);
                            paneNovoProd.setVisible(false);          
                
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Erro ao cadastrar o produto, verifique os campos!");
            
        });
// </editor-fold>

        /*****/
        
    } 
      
    // <editor-fold defaultstate="collapsed" desc="PRODUTO">
    
    public void initTable() throws IOException{

                clmCodigo.setCellValueFactory(new PropertyValueFactory("id"));
                clmCategoria.setCellValueFactory(new PropertyValueFactory("categoria"));
                clmProduto.setCellValueFactory(new PropertyValueFactory("produto"));
                clmQuantidade.setCellValueFactory(new PropertyValueFactory("quantidade"));
                clmPrecoCusto.setCellValueFactory(new PropertyValueFactory("valorCusto"));
                clmPrecoVenda.setCellValueFactory(new PropertyValueFactory("valorVenda"));
                tbConsumoCliente.setItems(atualizaTabela());
    }
    
    public ObservableList<ProdutoModel> atualizaTabela () throws IOException{
        
        ProdutoController prod = new ProdutoController();
        List<ProdutoModel> dados = prod.Buscar();

        File arquivo = new File("./src/Produtos.txt" );
            
            return  FXCollections.observableArrayList(dados);   
    }
    
    
    public void initTableVenda() throws IOException{

                clmCodigoVenda.setCellValueFactory(new PropertyValueFactory("id"));
                clmProdutoVenda.setCellValueFactory(new PropertyValueFactory("produto"));
                clmQuantidadeVenda.setCellValueFactory(new PropertyValueFactory("quantidade"));
                clmPrecoUnidadeVenda.setCellValueFactory(new PropertyValueFactory("valorUnidade"));
                clmPrecoVendaVenda.setCellValueFactory(new PropertyValueFactory("valorVenda"));
                tbConsumoVenda.setItems(atualizaTabelaVenda());
    }
    
    public ObservableList<VendaModel> atualizaTabelaVenda () throws IOException{
        
        VendaController prod = new VendaController();
        List<VendaModel> dados = prod.Buscar();

        File arquivo = new File("./src/Produtos.txt" );
            
            return  FXCollections.observableArrayList(dados);   
    }
    
    
    
    
    
    
    public void initTableInsumo(){

                clmCodigoInsummo.setCellValueFactory(new PropertyValueFactory("id"));
                clmProdutoInsumo.setCellValueFactory(new PropertyValueFactory("produto"));
                clmQuantidadeInsumo.setCellValueFactory(new PropertyValueFactory("quantidade"));
                clmPrecoCustoInsumo.setCellValueFactory(new PropertyValueFactory("valorCusto"));
                tbInsumo.setItems(atualizaTabelaInsumo());
    }

    public ObservableList<ProdutoModel> atualizaTabelaInsumo (){
        List<ProdutoModel> dados = new ArrayList<>();

        File arquivo = new File("./src/ProdutosInsumo.txt" );
        if (arquivo.exists()) {
            String dadosConta[] = new String[4];
            try {
                BufferedReader in = new BufferedReader(new FileReader(arquivo));

                while (in.ready()) {
                    
                dadosConta = (in.readLine().split(Pattern.quote(" - ")));
                    
                ProdutoModel prod = new ProdutoModel();
                prod.setId("        " + dadosConta[0]);
                prod.setProduto("      " + dadosConta[1]);
                prod.setQuantidade("        " + dadosConta[2]);
                prod.setValorCusto("        " + dadosConta[3]);
                dados.add(prod);
                }
                in.close();
            } catch (IOException ex) {
            
        }
        } else {
            System.out.println("Erro na leitura do arquivo.");
        }        // TODO add your handling code here:

                
            return  FXCollections.observableArrayList(dados);   
    }
    
// </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="CLIENTE">
    
        public void initTableCliente(){

                clmNomeCliente.setCellValueFactory(new PropertyValueFactory("nome"));
                clCpf.setCellValueFactory(new PropertyValueFactory("cpf"));
                clEmail.setCellValueFactory(new PropertyValueFactory("email"));
                clTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));
                
                tbCliente.setItems(atualizaTabelaCliente());
    }
        
        public ObservableList<ClienteModel> atualizaTabelaCliente (){
            ClienteController controller = new ClienteController();
        List<ClienteModel> dados = controller.Buscar();
                
            return  FXCollections.observableArrayList(dados);   
    }
        
 // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="FINANCEIRO">

         public void Valores () {
            String valorCustoForm = "";
             VendaController venda = new VendaController();
             String valorVenda = venda.ValorVenda();
             txtCampoVendas.setText(valorVenda);
             
  DecimalFormat df = new DecimalFormat("#,###.00");
   double valoresCusto = 0;
        File arquivo = new File("./src/ProdutosInsumo.txt" );
        if (arquivo.exists()) {
            String dadosConta[] = new String[4];
           
            try {
                BufferedReader in = new BufferedReader(new FileReader(arquivo));
                while (in.ready()) { 
                dadosConta = (in.readLine().split(Pattern.quote(" - ")));
                valoresCusto += Double.valueOf(dadosConta[3]);
                }
                in.close();
            } catch (IOException ex) {
        }
        } else {
            System.out.println("Erro na leitura do arquivo.");
        }        // TODO add your handling code here:
        double valorLucro = 0.0;
        valorCustoForm = df.format(valoresCusto); 
        txtCampoCustos.setText(valorCustoForm); 
        double valorVendaCalculo = Double.valueOf(valorVenda.replace(",", "."));
        valorLucro =  valorVendaCalculo - valoresCusto;
        txtCampoLucro.setText(df.format(valorLucro));
    }
            
         public void ExtrairAgendamento () {
            
        }
         
         public void ExtrairEstoque () throws IOException {
            List<String> dados = new ArrayList<>();

        File arquivo = new File("./src/Produtos.txt" );
        if (arquivo.exists()) {
            String dadosContass = "";
            try {
                BufferedReader in = new BufferedReader(new FileReader(arquivo));

                while (in.ready()) {
                dadosContass = in.readLine();  
               
                dados.add(dadosContass);
                }
                in.close();
            } catch (IOException ex) {
            
        }
       
        }
        
        File arquivoInsumo = new File("./src/ProdutosInsumo.txt" );
        if (arquivoInsumo.exists()) {
            String dadosConta = "";
            try {
                BufferedReader in = new BufferedReader(new FileReader(arquivoInsumo));

                while (in.ready()) {
                    
                dadosConta = (in.readLine());
                    
                ProdutoModel prod = new ProdutoModel();
                
                dados.add(dadosConta);
                }
                in.close();
            } catch (IOException ex) {
            
        }
        } else {
            System.out.println("Erro na leitura do arquivo.");
        }        // TODO add your handling code here:

        FileWriter file = new FileWriter("./Relatorios/Historico_Produtos.txt");
        
        int n = dados.size();
                for (int i=0; i<n; i++) {
                    file.write( dados.get(i) +"\n");
                }
        file.close();
        
          }
        
         public void ExtrairVendas () throws IOException {
            
             
             List<String> dados = new ArrayList<>();

        File arquivo = new File("./src/Vendas.txt" );
        if (arquivo.exists()) {
            String dadosContass = "";
            try {
                BufferedReader in = new BufferedReader(new FileReader(arquivo));

                while (in.ready()) {
                dadosContass = in.readLine();  
               
                dados.add(dadosContass);
                }
                in.close();
            } catch (IOException ex) {
            
        }
       
        }
        
             
        FileWriter fileFinal = new FileWriter("./Relatorios/Historico_Comandas.txt");
        
        int n = dados.size();
                for (int i=0; i<n; i++) {
                    fileFinal.write( dados.get(i) +"\n");
                }
        fileFinal.close();
        
        }
         
         
         public void ExtrairClientes () throws IOException {

             List<String> dados = new ArrayList<>();

        File arquivo = new File("./src/Clientes.txt" );
        if (arquivo.exists()) {
            String dadosContass = "";
            try {
                BufferedReader in = new BufferedReader(new FileReader(arquivo));

                while (in.ready()) {
                dadosContass = in.readLine();  
               
                dados.add(dadosContass);
                }
                in.close();
            } catch (IOException ex) {
            
        }
       
        }
        
             
        FileWriter fileFinal = new FileWriter("./Relatorios/Historico_Clientes.txt");
        
        int n = dados.size();
                for (int i=0; i<n; i++) {
                    fileFinal.write( dados.get(i) +"\n");
                }
        fileFinal.close();
        
        }
// </editor-fold>  

    @FXML
    private void handle(MouseEvent event) {
    }
            
}
