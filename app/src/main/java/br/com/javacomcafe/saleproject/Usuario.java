package br.com.javacomcafe.saleproject;

import java.util.ArrayList;

public class Usuario {

    String nome;
    String senha;

    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();


    public Usuario(String nome, String senha){

        this.nome = nome;
        this.senha = senha;

    }

    public Usuario(){


    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public static boolean existUser(String login, String senha) {

        Usuario loginTentativa = new Usuario(login, senha);


        for (Usuario usu : listaUsuarios) {

            if (usu.getNome().matches(loginTentativa.getNome()) && usu.getSenha().matches(loginTentativa.getSenha())) {

                return true;
            }


        }
        return false;
    }


}
