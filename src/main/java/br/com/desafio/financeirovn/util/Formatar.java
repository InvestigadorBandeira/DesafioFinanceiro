package br.com.desafio.financeirovn.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Formatar {

    public static String dataTexto(Calendar data) {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	return data != null ? sdf.format(data.getTime()) : "";
    }

    public static String anoMes(Calendar data) {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	return data != null ? sdf.format(data.getTime()) : "";
    }

    public static String valorTexto(BigDecimal valor) {
	DecimalFormat df = new DecimalFormat("#,##0.00;-#,##0.00");
	return valor != null ? df.format(valor) : "0,00";
    }
}