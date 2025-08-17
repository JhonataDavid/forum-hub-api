package com.jhonata.forumhub.domain.enums;

import lombok.Getter;

@Getter
public enum Categoria {

    PROGRAMACAOWEB("Programação Web"),
    PROGRAMADORBACKEND("Programador Back-end");

    private final String nome; // atributo associado ao enum

    Categoria(String nome) {
        this.nome = nome;
    }

//    public Categoria mapearCategoria(String nomeCategoria){
//        if (this.nome.equalsIgnoreCase(nomeCategoria)){
//            return Categoria.valueOf(nomeCategoria);
//        }else {
//            throw new IllegalArgumentException("Categria invalida" + nomeCategoria);        }
//    }
}
