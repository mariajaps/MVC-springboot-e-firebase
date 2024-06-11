package com.example.ConCon.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class Product {
    @DecimalMin("0.0")
    @NotNull
    private int idProduto;
    @DecimalMin("0.0")
    @NotNull
    private int quantidadeProduto;
    @NotBlank
    @NotNull
    private String nomeProduto;
    @NotBlank
    @NotNull
    private String descricaoProduto;
    @NotBlank
    @NotNull
    private String imgProduto;
    @DecimalMin("0.0")
    @NotNull
    private float precoProduto;

      public Product() {}
    public Product(int idProduto, int quantidadeProduto, String nomeProduto, String descricaoProduto, String imgProduto, float precoProduto) {
        this.idProduto = idProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.imgProduto = imgProduto;
        this.precoProduto = precoProduto;
    }
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public  String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getImgProduto() {
        return imgProduto;
    }

    public void setImgProduto(String imgProduto) {
        this.imgProduto = imgProduto;
    }

    public float getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(float precoProduto) {
        this.precoProduto = precoProduto;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduto=" + idProduto +
                ", quantidadeProduto=" + quantidadeProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", descricaoProduto='" + descricaoProduto + '\'' +
                ", imgProduto='" + imgProduto + '\'' +
                ", precoProduto=" + precoProduto +
                '}';
    }
}

