/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EsmateriaControle.View;

import EsmateriaControle.MainApp;
import Model.Funcionario;
import Model.Pessoa;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author felipecpl11
 */
public class PrincipalViewController {

    @FXML
    private TableView<Funcionario> funcionariosTable;

    @FXML
    private ContextMenu contextMenu;

    @FXML
    private MenuItem menuItem1;

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

        criarColuna();
        inserirValorColuna("vai");
    }

    public void inserirValorColuna(String valor) {
        System.out.println("inserirValorColuna");
        ObservableList<Funcionario> funcionariosData = FXCollections.observableArrayList();
        funcionariosData.add(new Funcionario(valor));
        coluna.setCellValueFactory(cellData -> cellData.getValue().getNome());
        

        funcionariosTable.setItems(funcionariosData);
    }

    public void criarColuna() {
        coluna = new TableColumn<>("Nome");
        coluna.setCellValueFactory(new PropertyValueFactory<>("nome"));

        funcionariosTable.getColumns().addAll(coluna);
    }

    public void verificarClickeEmCelula1() {
        ObservableList<TablePosition> selectedCells = funcionariosTable.getSelectionModel().getSelectedCells();
        selectedCells.addListener((ListChangeListener.Change<? extends TablePosition> change) -> {
            if (selectedCells.size() > 0) {
                System.out.println("qweqweqwe");
                TablePosition selectedCell = selectedCells.get(0);
                TableColumn column = selectedCell.getTableColumn();
                if (column != null) {
                    int rowIndex = selectedCell.getRow();
                    Object data = column.getCellObservableValue(rowIndex).getValue();
                }
            }
        });
    }

    //CRIA UM CONTEXT MENU APOS CLICK
    public void verificarClickeEmCelula2() {
        ObservableList<TablePosition> selectedCells = funcionariosTable.getSelectionModel().getSelectedCells();
        selectedCells.addListener((ListChangeListener.Change<? extends TablePosition> change) -> {
            if (selectedCells.size() > 0) {
                System.out.println("qweqweqwe");
                TablePosition selectedCell = selectedCells.get(0);
                TableColumn column = selectedCell.getTableColumn();
                if (column != null) {
                    int rowIndex = selectedCell.getRow();
                    Object data = column.getCellObservableValue(rowIndex).getValue();
                    System.out.println(data.toString());
                    contextMenu.show(funcionariosTable, 0, 0);

                }
            }
        });
    }

    //CRIA UMA CENA APOS CLICK
    public void verificarClickeEmCelula3() {
        ObservableList<TablePosition> selectedCells = funcionariosTable.getSelectionModel().getSelectedCells();
        selectedCells.addListener((ListChangeListener.Change<? extends TablePosition> change) -> {
            if (selectedCells.size() > 0) {
                System.out.println("qweqweqwe");
                TablePosition selectedCell = selectedCells.get(0);
                TableColumn column = selectedCell.getTableColumn();
                if (column != null) {
                    int rowIndex = selectedCell.getRow();
                    Object data = column.getCellObservableValue(rowIndex).getValue();
                    Stage myDialog = new Stage();
                    myDialog.initModality(Modality.WINDOW_MODAL);

                    Scene myDialogScene = new Scene(VBoxBuilder.create()
                            .children(new Text("Hello! it's My Dialog."))
                            .alignment(Pos.CENTER)
                            .padding(new Insets(10))
                            .build());

                    myDialog.setScene(myDialogScene);
                    myDialog.show();
                }
            }
        });
    }

    @FXML
    private void initialize() {
        System.out.println("initialize");
        contextMenu = new ContextMenu();
        contextMenu.setAutoFix(true);
        contextMenu.setAutoHide(true);
        menuItem1 = new MenuItem("teaste");
        contextMenu.getItems().add(menuItem1);
        criarColuna();
        inserirValorColuna("teste");
        verificarClickeEmCelula2();
        /*
        funcionariosTable.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                
            }
        });
         */

    }

    public void setMainApp(MainApp mainApp) {
        System.out.println("passei aqui2");
        this.mainApp = mainApp;

        // Adiciona os dados da observable list na tabela
        funcionariosTable.setItems(mainApp.getFuncionarioData());
    }
}
