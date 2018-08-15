package com.project.quelvymuahio.postbus.Model;

public class Route {

    private String rota_id, rota_nome, rota_partida, rota_destino, rota_distancia;

    public Route(){
        //required no-argument construtor
    }
    public Route(String rota_id, String rota_nome, String rota_partida, String rota_destino, String rota_distancia) {
        this.rota_id = rota_id;
        this.rota_nome = rota_nome;
        this.rota_partida = rota_partida;
        this.rota_destino = rota_destino;
        this.rota_distancia = rota_distancia;
    }

    public String getRota_id() {
        return rota_id;
    }

    public void setRota_id(String rota_id) {
        this.rota_id = rota_id;
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
}
