/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author felipecpl11
 */
public class Funcionario {

    private StringProperty nome;

    public Funcionario(String nome) {
        this.nome = new SimpleStringProperty(nome);
    }

    /**
     * @return the nome
     */
    public StringProperty getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(StringProperty nome) {
        this.nome = nome;
    }

}
