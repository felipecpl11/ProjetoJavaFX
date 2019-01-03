/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EsmateriaControle;

import EsmateriaControle.View.PrincipalViewController;
import Model.Funcionario;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author felipecpl11
 */
public class MainApp extends Application {

    private Stage primaryStage;
    private AnchorPane rootLayout;
    private ObservableList<Funcionario> funcionariosData = FXCollections.observableArrayList();

    public MainApp() {
        //funcionariosData.add(new Funcionario("teste"));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
       // funcionariosData.add(new Funcionario("teste"));
        System.out.println("passei aqui5");
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Controle");

        initRootLayout();
    }

    public void initRootLayout() throws IOException {
        System.out.println("passei aqu4");
        
        Parent root = FXMLLoader.load(getClass().getResource("View/PrincipalView.fxml"));
        System.out.println("root");
        Scene scene = new Scene(root);
        System.out.println("new scene");
        primaryStage.setScene(scene);
        System.out.println("set scne");
        primaryStage.show();
        System.out.println("show");
        
        //PrincipalViewController controller = new PrincipalViewController();
         

        /*
        // Carrega o root layout do arquivo fxml.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource("View/PrincipalView.fxml"));
        rootLayout = (AnchorPane) loader.load();

        // Mostra a scene (cena) contendo o root layout.
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
        */
    }

    public void showPersonOverview() {
        try {
            // Carrega a person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("View/PrincipalView.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Define a person overview no centro do root layout.
            
            rootLayout.setCenterShape(true);

            // Dá ao controlador acesso à the main app.
            PrincipalViewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Funcionario> getFuncionarioData() {
        System.out.println("passei aqui3");
        return funcionariosData;

    }

}
