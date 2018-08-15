package com.project.quelvymuahio.postbus.Model;

import java.io.Serializable;

public class Rota implements Serializable {
    private String rota_id, rota_destino, rota_distancia, rota_nome, rota_partida;

    public Rota(){
        //required no-argument construtor
    }

    public Rota(String rota_id, String rota_destino, String rota_distancia, String rota_nome, String rota_partida) {

        if (rota_nome.trim().equals(""))
            rota_nome = "Sem nome";

        this.rota_id = rota_id;
        this.rota_destino = rota_destino;
        this.rota_distancia = rota_distancia;
        this.rota_nome = rota_nome;
        this.rota_partida = rota_partida;
    }

    public String getRota_id() {
        return rota_id;
    }

    public void setRota_id(String rota_id) {
        this.rota_id = rota_id;
    }

    public String getRota_destino() {
        return rota_destino;
    }

    public void setRota_destino(String rota_destino) {
        this.rota_destino = rota_destino;
    }

    public String getRota_distancia() {
        return rota_distancia;
    }

    public void setRota_distancia(String rota_distancia) {
        this.rota_distancia = rota_distancia;
    }

    public String getRota_nome() {
        return rota_nome;
    }

    public void setRota_nome(String rota_nome) {
        this.rota_nome = rota_nome;
    }

    public String getRota_partida() {
        return rota_partida;
    }

    public void setRota_partida(String rota_partida) {
        this.rota_partida = rota_partida;
    }
}
