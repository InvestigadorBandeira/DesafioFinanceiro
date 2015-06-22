package br.com.desafio.financeirovn.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Formatar {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static String dataTexto(Calendar data) {
	return data != null ? sdf.format(data.getTime()) : "";
    }

    public static Calendar textoData(String data) {
	Calendar calendar = Calendar.getInstance();

	try {
	    calendar.setTime(sdf.parse(data));
	} catch (ParseException e) {
	    return null;
	}

	return calendar;
    }

    public static String anoMes(Calendar data) {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	return data != null ? sdf.format(data.getTime()) : "";
    }

    public static String valorTexto(BigDecimal valor) {
	DecimalFormat df = new DecimalFormat("#,##0.00;-#,##0.00");
	return valor != null ? df.format(valor) : "0,00";
    }

    public static String valorTextoReal(BigDecimal valor) {
	DecimalFormat df = new DecimalFormat("R$ #,##0.00;R$ -#,##0.00");
	return valor != null ? df.format(valor) : "0,00";
    }
}
