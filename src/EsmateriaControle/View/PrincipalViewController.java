/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EsmateriaControle.View;

import EsmateriaControle.MainApp;
import Model.Funcionario;
import Model.Pessoa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author felipecpl11
 */
public class PrincipalViewController {

    @FXML
    private TableView<Funcionario> funcionariosTable;

    @FXML
    private Button butonClik;

    @FXML
    private TableColumn<Funcionario, String> coluna;

    private MainApp mainApp;

    public PrincipalViewController() {
    }

    @FXML
    private void onAction() {
        System.out.println("adsadasda");

        //List<Funcionario> funcionarios = Arrays.asList(new Funcionario("Williamm"));
        //funcionariosTable.setItems(FXCollections.observableArrayList(funcionarios));
        ObservableList<Funcionario> funcionariosData = FXCollections.observableArrayList();
        funcionariosData.add(new Funcionario("teste"));
        
        //funcionariosTable.setItems(funcionariosData);
        
        coluna.setCellValueFactory(cellData -> cellData.getValue().getNome());
        System.out.println("adsadasda");
        
        funcionariosTable.setItems(funcionariosData);
        
        System.out.println("adsadasda");

    }

    @FXML
    private void initialize() {

        List pessoas = Arrays.asList(
                new Pessoa("William", 32, "william@email.com")
        );

        List funcionarios = Arrays.asList(new Funcionario("Williamm")
        );

        System.out.println("passei aqui");
        coluna = new TableColumn<>("Nome");
        coluna.setCellValueFactory(new PropertyValueFactory<>("nome"));

        //funcionariosTable.setItems(FXCollections.observableArrayList(funcionarios));
        funcionariosTable.getColumns().addAll(coluna);

        //funcionariosTable.setItems(FXCollections.observableArrayList(funcionarios));
        //funcionariosTable.getColumns().addAll(colunaNome);
        //TODO
        /*
        // Inicializa a tablea de pessoa com duas colunas.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
         */
    }

    public void setMainApp(MainApp mainApp) {
        System.out.println("passei aqui2");
        this.mainApp = mainApp;

        // Adiciona os dados da observable list na tabela
        funcionariosTable.setItems(mainApp.getFuncionarioData());
    }
}
