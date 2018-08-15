package com.project.quelvymuahio.postbus.Model;

import java.io.Serializable;

public class Ticket implements Serializable {

    private String bilhete_id, bilhete_autocarro_id, bilhete_rota_id, bilhete_estado, bilhete_total, bilhete_preco, bilhete_data_partida, bilhete_hora_partida, bilhete_data_chegada, bilhete_hora_chegada;

    public Ticket(){
        //required no-argument construtor
    }

    public Ticket(String bilhete_id, String bilhete_autocarro_id, String bilhete_rota_id, String bilhete_estado, String bilhete_total, String bilhete_preco, String bilhete_data_partida, String bilhete_hora_partida, String bilhete_data_chegada, String bilhete_hora_chegada) {
        this.bilhete_id = bilhete_id;
        this.bilhete_autocarro_id = bilhete_autocarro_id;
        this.bilhete_rota_id = bilhete_rota_id;
        this.bilhete_estado = bilhete_estado;
        this.bilhete_total = bilhete_total;
        this.bilhete_preco = bilhete_preco;
        this.bilhete_data_partida = bilhete_data_partida;
        this.bilhete_hora_partida = bilhete_hora_partida;
        this.bilhete_data_chegada = bilhete_data_chegada;
        this.bilhete_hora_chegada = bilhete_hora_chegada;
    }

    public String getBilhete_id() {
        return bilhete_id;
    }

    public void setBilhete_id(String bilhete_id) {
        this.bilhete_id = bilhete_id;
    }

    public String getBilhete_autocarro_id() {
        return bilhete_autocarro_id;
    }

    public void setBilhete_autocarro_id(String bilhete_autocarro_id) {
        this.bilhete_autocarro_id = bilhete_autocarro_id;
    }

    public String getBilhete_rota_id() {
        return bilhete_rota_id;
    }

    public void setBilhete_rota_id(String bilhete_rota_id) {
        this.bilhete_rota_id = bilhete_rota_id;
    }

    public String getBilhete_estado() {
        return bilhete_estado;
    }

    public void setBilhete_estado(String bilhete_estado) {
        this.bilhete_estado = bilhete_estado;
    }

    public String getBilhete_total() {
        return bilhete_total;
    }

    public void setBilhete_total(String bilhete_total) {
        this.bilhete_total = bilhete_total;
    }

    public String getBilhete_preco() {
        return bilhete_preco;
    }

    public void setBilhete_preco(String bilhete_preco) {
        this.bilhete_preco = bilhete_preco;
    }

    public String getBilhete_data_partida() {
        return bilhete_data_partida;
    }

    public void setBilhete_data_partida(String bilhete_data_partida) {
        this.bilhete_data_partida = bilhete_data_partida;
    }

    public String getBilhete_hora_partida() {
        return bilhete_hora_partida;
    }

    public void setBilhete_hora_partida(String bilhete_hora_partida) {
        this.bilhete_hora_partida = bilhete_hora_partida;
    }

    public String getBilhete_data_chegada() {
        return bilhete_data_chegada;
    }

    public void setBilhete_data_chegada(String bilhete_data_chegada) {
        this.bilhete_data_chegada = bilhete_data_chegada;
    }

    public String getBilhete_hora_chegada() {
        return bilhete_hora_chegada;
    }

    public void setBilhete_hora_chegada(String bilhete_hora_chegada) {
        this.bilhete_hora_chegada = bilhete_hora_chegada;
    }
}
