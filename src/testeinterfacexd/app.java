/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeinterfacexd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author LENOVO
 */
public class app extends Application {
    
    private static Stage primaryStage;
    
    private static Scene mainScene;
    private static Scene agendaScene;
    private static Scene estoqueScene;
    
    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        
        Parent root = FXMLLoader.load(getClass().getResource("app.fxml"));
        mainScene = new Scene(root);
        
        Parent agendaRoot = FXMLLoader.load(getClass().getResource("Agenda.fxml"));
        agendaScene = new Scene(agendaRoot);
              
        stage.setScene(mainScene);
        stage.show();
    }
    
    
    public static void changeScreen(String scr){
        switch(scr){
            case "inicio":
                primaryStage.setScene(mainScene);
                break;
            case "agenda":
                primaryStage.setScene(agendaScene);
                break;
            case "estoque":
                primaryStage.setScene(estoqueScene);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
        
    }
    
}
