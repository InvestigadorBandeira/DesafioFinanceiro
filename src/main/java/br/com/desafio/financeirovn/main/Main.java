package br.com.desafio.financeirovn.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.desafio.financeirovn.dao.ContaDAO;
import br.com.desafio.financeirovn.dao.LancamentoDAO;
import br.com.desafio.financeirovn.model.Conta;
import br.com.desafio.financeirovn.model.Lancamento;
import br.com.desafio.financeirovn.model.TipoLancamento;

public class Main {

    public static void main(String[] args) {
	System.out.println("Iniciando sistema.\n");

	criaContas();
	criaLancamentos();

	System.out.println("\nFinalizando sistema.");
    }

    private static void criaLancamentos() {
	ContaDAO dao = new ContaDAO();
	LancamentoDAO ldao = new LancamentoDAO();

	List<Lancamento> lancamentos = new ArrayList<>();

	for (int i = 0; i < 5; i++) {
	    Lancamento l = new Lancamento();
	    l.setData(Calendar.getInstance());
	    l.setTipo(TipoLancamento.ENTRADA);
	    l.setValor(new BigDecimal("100.0"));
	    lancamentos.add(l);
	}

	Conta conta = new Conta();
	conta.setNome(dao.getDados().get(0));
	conta.setLancamentos(lancamentos);
	// ldao.salvar(conta);
    }

    private static void criaContas() {
	ContaDAO dao = new ContaDAO();
	// dao.salvar("Caixa Fixo");
	// dao.salvar("Banco do Brasil");
    }
}