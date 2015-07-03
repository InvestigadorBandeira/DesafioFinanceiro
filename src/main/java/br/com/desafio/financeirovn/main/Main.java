package br.com.desafio.financeirovn.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.desafio.financeirovn.model.Conta;
import br.com.desafio.financeirovn.model.Lancamento;
import br.com.desafio.financeirovn.model.TipoLancamento;
import br.com.desafio.financeirovn.repository.Contas;
import br.com.desafio.financeirovn.repository.Lancamentos;
import br.com.desafio.financeirovn.util.Formatar;

public class Main {

    public static void main(String[] args) {
	System.out.println("Iniciando sistema.\n");

	salvarCSV();
	CarregarCSV();

	System.out.println("\nFinalizando sistema.");
    }

    private static void salvarCSV() {
	Conta nova = new Conta();
	nova.setNome("Santander Brasil");

	List<Lancamento> lan = new ArrayList<>();

	for (int i = 0; i < 5; i++) {
	    Lancamento l = new Lancamento();
	    l.setData(Calendar.getInstance());
	    l.setTipo(TipoLancamento.ENTRADA);
	    l.setValor(new BigDecimal("100.85"));
	    lan.add(l);
	}
	nova.setLancamentos(lan);

	// new Contas().salvar(nova);
	// new Lancamentos().salvarTodos(lan, nova);
    }

    private static void CarregarCSV() {
	List<Conta> contas = new Contas().buscaTodos();

	Calendar mes = Calendar.getInstance();
	mes.add(Calendar.MONTH, 0);

	for (Conta c : contas)
	    c.setLancamentos(new Lancamentos().buscaPorMes(mes, c));

	contas.forEach(conta -> System.out.println(print(conta)));
    }

    private static String print(Object dado) {
	StringBuilder texto = new StringBuilder("");

	if (dado instanceof Conta) {
	    Conta c = (Conta) dado;
	    texto.append(c.getNome() + "\n");
	    for (Lancamento lan : c.getLancamentos())
		texto.append("  " + print(lan) + "\n");
	} else {
	    Lancamento l = (Lancamento) dado;
	    texto.append(Formatar.dataTexto(l.getData()) + "  ");
	    texto.append(l.getTipo() + "  ");
	    texto.append(Formatar.valorTexto(l.getValor()));
	}
	return texto.toString();
    }

}