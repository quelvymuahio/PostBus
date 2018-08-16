package com.project.quelvymuahio.postbus.Model;

import java.io.Serializable;

public class Bilhete implements Serializable {

    private String carro_nome, carro_assentos, carro_matricula, carro_motorista, carro_imagem;
    private String rota_nome, rota_partida, rota_destino, rota_distancia;
    private String estado, total, preco, data_partida, hora_partida, data_chegada, hora_chegada;

    public Bilhete(){
        //required no-argument construtor
    }

    public Bilhete(String carro_nome, String carro_assentos, String carro_matricula, String carro_motorista, String carro_imagem, String rota_nome, String rota_partida, String rota_destino, String rota_distancia, String estado, String total, String preco, String data_partida, String hora_partida, String data_chegada, String hora_chegada){
        this.carro_nome = carro_nome;
        this.carro_assentos = carro_assentos;
        this.carro_matricula = carro_matricula;
        this.carro_motorista = carro_motorista;
        this.carro_imagem = carro_imagem;
        this.rota_nome = rota_nome;
        this.rota_partida = rota_partida;
        this.rota_destino = rota_destino;
        this.rota_distancia = rota_distancia;
        this.estado = estado;
        this.total = total;
        this.preco = preco;
        this.data_partida = data_partida;
        this.hora_partida = hora_partida;
        this.data_chegada = data_chegada;
        this.hora_chegada = hora_chegada;
    }

    public String getCarro_nome() {
        return carro_nome;
    }

    public void setCarro_nome(String carro_nome) {
        this.carro_nome = carro_nome;
    }

    public String getCarro_assentos() {
        return carro_assentos;
    }

    public void setCarro_assentos(String carro_assentos) {
        this.carro_assentos = carro_assentos;
    }

    public String getCarro_matricula() {
        return carro_matricula;
    }

    public void setCarro_matricula(String carro_matricula) {
        this.carro_matricula = carro_matricula;
    }

    public String getCarro_motorista() {
        return carro_motorista;
    }

    public void setCarro_motorista(String carro_motorista) {
        this.carro_motorista = carro_motorista;
    }

    public String getCarro_imagem() {
        return carro_imagem;
    }

    public void setCarro_imagem(String carro_imagem) {
        this.carro_imagem = carro_imagem;
    }

    public String getRota_distancia() {
        return rota_distancia;
    }

    public void setRota_distancia(String rota_distancia) {
        this.rota_distancia = rota_distancia;
    }

    public String getRota_destino() {
        return rota_destino;
    }

    public void setRota_destino(String rota_destino) {
        this.rota_destino = rota_destino;
    }

    public String getRota_partida() {
        return rota_partida;
    }

    public void setRota_partida(String rota_partida) {
        this.rota_partida = rota_partida;
    }

    public String getRota_nome() {
        return rota_nome;
    }

    public void setRota_nome(String rota_nome) {
        this.rota_nome = rota_nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getData_partida() {
        return data_partida;
    }

    public void setData_partida(String data_partida) {
        this.data_partida = data_partida;
    }

    public String getHora_partida() {
        return hora_partida;
    }

    public void setHora_partida(String hora_partida) {
        this.hora_partida = hora_partida;
    }

    public String getData_chegada() {
        return data_chegada;
    }

    public void setData_chegada(String data_chegada) {
        this.data_chegada = data_chegada;
    }

    public String getHora_chegada() {
        return hora_chegada;
    }

    public void setHora_chegada(String hora_chegada) {
        this.hora_chegada = hora_chegada;
    }
}
