package br.com.desafio.financeirovn.dao;

import java.util.List;

public interface DAO<T> {

    public List<T> getDados();

    public void salvar();
}
