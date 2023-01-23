import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.Console;

import javax.swing.*;
import javax.swing.plaf.multi.MultiPopupMenuUI;

import org.jsoup.select.Evaluator.TagEndsWith;

public class App {
	public static float valorCotacao = 0;
	public static float valorCotacaoASerConvertido = 0;
	
	static GetPreco preco = new GetPreco();
	
	public static void exibeCotacao(int tipoOperacao) {
		int operacaoContinua = 0;
		String valorFormatado = String.format("%.02f", valorCotacao * valorCotacaoASerConvertido);
		// Conversões de outras moedas para REAL, formatação de exibição com o símbolo correto
		if (tipoOperacao == 1 || tipoOperacao >= 7) {
			operacaoContinua = JOptionPane.showConfirmDialog(null,"O valor é: R$"+valorFormatado+". Deseja continuar?", "Selecione uma opção", JOptionPane.YES_NO_OPTION);
		}else {
			switch (tipoOperacao) {
			case 2:
				// Exibição para conversão para EURO
				operacaoContinua = JOptionPane.showConfirmDialog(null,"O valor é: €"+valorFormatado+". Deseja continuar?", "Selecione uma opção", JOptionPane.YES_NO_OPTION);
				break;
			case 3:
				// Exibição para conversão para LIBRA ESTERLINA
				operacaoContinua = JOptionPane.showConfirmDialog(null,"O valor é: £"+valorFormatado+". Deseja continuar?", "Selecione uma opção", JOptionPane.YES_NO_OPTION);
				break;
			case 4:
			case 5:
			case 6:
				// Exibição para conversão para moedas que usam $ como símbolo
				operacaoContinua = JOptionPane.showConfirmDialog(null,"O valor é: $"+valorFormatado+". Deseja continuar?", "Selecione uma opção", JOptionPane.YES_NO_OPTION);
				break;
			}
		}
		if (operacaoContinua < 1) {
			valorCotacao = 0f;
			valorCotacaoASerConvertido = 0f;
			menuSelecao();
		}else {
			JOptionPane.showMessageDialog(null, "Programa finalizado");
			System.exit(0);
		}
		
	}
	
	public static void setvalorCotacaoMoeda(int tipoOperacao) {
		switch(tipoOperacao) {
		case 1:
			//dólar -> real
			String valorCotacaoDolar = JOptionPane.showInputDialog(null, "Valor de 1 dólar em real:", preco.getUsd());
			try {
				String valorCotacaoStringSemVirgula = valorCotacaoDolar.replaceFirst(",", ".");
				valorCotacao = Float.parseFloat(valorCotacaoStringSemVirgula);
				if (valorCotacao > 0) {
					preco.setUsd(valorCotacao);
					exibeCotacao(tipoOperacao);
				}else {
					JOptionPane.showMessageDialog(null, "Você deve digitar um número válido!");
					setvalorCotacaoMoeda(tipoOperacao);
				}
			}catch (Exception e) {
				if (valorCotacaoDolar == null || valorCotacaoDolar.equals(JOptionPane.CANCEL_OPTION)) {
					System.exit(0);
				}
			}
			break;
		case 6:
			//real -> dólar
			String valorCotacaoRealDolar = JOptionPane.showInputDialog(null, "Valor de 1 real em dólar:", preco.getBrlusd());
			try {
				String valorCotacaoStringSemVirgula = valorCotacaoRealDolar.replaceFirst(",", ".");
				valorCotacao = Float.parseFloat(valorCotacaoStringSemVirgula);
				if (valorCotacao > 0) {
					preco.setBrlusd(valorCotacao);
					exibeCotacao(tipoOperacao);		
				}else {
					JOptionPane.showMessageDialog(null, "Você deve digitar um número válido!");
					setvalorCotacaoMoeda(tipoOperacao);
				}
			}catch (Exception e) {
				if (valorCotacaoRealDolar == null || valorCotacaoRealDolar.equals(JOptionPane.CANCEL_OPTION)) {
					System.exit(0);
				}
			}
			break;
		case 2:
			//real -> euro
			String valorCotacaoRealEuro = JOptionPane.showInputDialog(null, "Valor de 1 real em euro:", preco.getBrleur());
			try {
				String valorCotacaoStringSemVirgula = valorCotacaoRealEuro.replaceFirst(",", ".");
				valorCotacao = Float.parseFloat(valorCotacaoStringSemVirgula);
				if (valorCotacao > 0) {
					preco.setBrleur(valorCotacao);
					exibeCotacao(tipoOperacao);	
				}else {
					JOptionPane.showMessageDialog(null, "Você deve digitar um número válido!");
					setvalorCotacaoMoeda(tipoOperacao);
				}
			}catch (Exception e) {
				if (valorCotacaoRealEuro == null || valorCotacaoRealEuro.equals(JOptionPane.CANCEL_OPTION)) {
					System.exit(0);
				}
			}
			break;					
		case 7:
			// euro -> real
			String valorCotacaoEuro = JOptionPane.showInputDialog(null, "Valor de 1 euro em real:", preco.getEur());
			try {
				String valorCotacaoStringSemVirgula = valorCotacaoEuro.replaceFirst(",", ".");
				valorCotacao = Float.parseFloat(valorCotacaoStringSemVirgula);
				if (valorCotacao > 0) {
					preco.setEur(valorCotacao);
					exibeCotacao(tipoOperacao);
				}else {
					JOptionPane.showMessageDialog(null, "Você deve digitar um número válido!");
					setvalorCotacaoMoeda(tipoOperacao);
				}
			}catch (Exception e) {
				if (valorCotacaoEuro == null || valorCotacaoEuro.equals(JOptionPane.CANCEL_OPTION)) {
					System.exit(0);
				}
			}
			break;	

		case 3:
			// real -> libra esterlina
			String valorCotacaoRealLibra = JOptionPane.showInputDialog(null, "Valor de 1 real em libra esterlina:", preco.getBrlgbp());
			try {
				String valorCotacaoStringSemVirgula = valorCotacaoRealLibra.replaceFirst(",", ".");
				valorCotacao = Float.parseFloat(valorCotacaoStringSemVirgula);
				if (valorCotacao > 0) {
					preco.setBrlgbp(valorCotacao);
					exibeCotacao(tipoOperacao);
				}else {
					JOptionPane.showMessageDialog(null, "Você deve digitar um número válido!");
					setvalorCotacaoMoeda(tipoOperacao);
				}
			}catch (Exception e) {
				if (valorCotacaoRealLibra == null || valorCotacaoRealLibra.equals(JOptionPane.CANCEL_OPTION)) {
					System.exit(0);
				}
			}
			break;			
		case 8:
			//libra esterlina -> real
			String valorCotacaoLibra = JOptionPane.showInputDialog(null, "Valor de 1 libra esterlina em real:", preco.getGbp());
			try {
				String valorCotacaoStringSemVirgula = valorCotacaoLibra.replaceFirst(",", ".");
				valorCotacao = Float.parseFloat(valorCotacaoStringSemVirgula);
				if (valorCotacao > 0) {
					preco.setGbp(valorCotacao);
					exibeCotacao(tipoOperacao);
				}else {
					JOptionPane.showMessageDialog(null, "Você deve digitar um número válido!");
					setvalorCotacaoMoeda(tipoOperacao);
				}
			}catch (Exception e) {
				if (valorCotacaoLibra == null || valorCotacaoLibra.equals(JOptionPane.CANCEL_OPTION)) {
					System.exit(0);
				}
			}
			break;		
		case 4:
			// real -> peso argentino
			String valorCotacaoRealPesoArgentino = JOptionPane.showInputDialog(null, "Valor de 1 real em peso argentino:", preco.getBrlars());
			try {
				String valorCotacaoStringSemVirgula = valorCotacaoRealPesoArgentino.replaceFirst(",", ".");
				valorCotacao = Float.parseFloat(valorCotacaoStringSemVirgula);
				if (valorCotacao > 0) {
					preco.setBrlars(valorCotacao);
					exibeCotacao(tipoOperacao);
				}else {
					JOptionPane.showMessageDialog(null, "Você deve digitar um número válido!");
					setvalorCotacaoMoeda(tipoOperacao);
				}
			}catch (Exception e) {
				if (valorCotacaoRealPesoArgentino == null || valorCotacaoRealPesoArgentino.equals(JOptionPane.CANCEL_OPTION)) {
					System.exit(0);
				}
			}			
			break;
		case 9:
			// peso argentino -> real
			String valorCotacaoPesoArgentino = JOptionPane.showInputDialog(null, "Valor de 1 peso argentino em real:", preco.getArs());
			try {
				String valorCotacaoStringSemVirgula = valorCotacaoPesoArgentino.replaceFirst(",", ".");
				valorCotacao = Float.parseFloat(valorCotacaoStringSemVirgula);
				if (valorCotacao > 0) {
					preco.setArs(valorCotacao);
					exibeCotacao(tipoOperacao);
				}else {
					JOptionPane.showMessageDialog(null, "Você deve digitar um número válido!");
					setvalorCotacaoMoeda(tipoOperacao);
				}
			}catch (Exception e) {
				if (valorCotacaoPesoArgentino == null || valorCotacaoPesoArgentino.equals(JOptionPane.CANCEL_OPTION)) {
					System.exit(0);
				}
			}			
			break;			
		case 5:
			// real -> peso chileno
			String valorCotacaoPesoRealChileno = JOptionPane.showInputDialog(null, "Valor de 1 real em peso chileno:", preco.getBrlclp());
			try {
				String valorCotacaoStringSemVirgula = valorCotacaoPesoRealChileno.replaceFirst(",", ".");
				valorCotacao = Float.parseFloat(valorCotacaoStringSemVirgula);
				if (valorCotacao > 0) {
					preco.setBrlclp(valorCotacao);
					exibeCotacao(tipoOperacao);
				}else {
					JOptionPane.showMessageDialog(null, "Você deve digitar um número válido!");
					setvalorCotacaoMoeda(tipoOperacao);
				}
			}catch (Exception e) {
				if (valorCotacaoPesoRealChileno == null || valorCotacaoPesoRealChileno.equals(JOptionPane.CANCEL_OPTION)) {
					System.exit(0);
				}
			}			
			break;
		case 10:
			// peso chileno -> real
			String valorCotacaoPesoChileno = JOptionPane.showInputDialog(null, "Valor de 1 peso chileno em real:", preco.getClp());
			try {
				String valorCotacaoStringSemVirgula = valorCotacaoPesoChileno.replaceFirst(",", ".");
				valorCotacao = Float.parseFloat(valorCotacaoStringSemVirgula);
				if (valorCotacao > 0) {
					preco.setClp(valorCotacao);
					exibeCotacao(tipoOperacao);
				}else {
					JOptionPane.showMessageDialog(null, "Você deve digitar um número válido!");
					setvalorCotacaoMoeda(tipoOperacao);
				}
			}catch (Exception e) {
				if (valorCotacaoPesoChileno == null || valorCotacaoPesoChileno.equals(JOptionPane.CANCEL_OPTION)) {
					System.exit(0);
				}
			}
			break;
		}
	}
	
	public static void menuMoedas() {
		Object opcoes[] = {"De Reais para Dólares", "De Reais para Euros", "De Reais para Libras Esterlinas", "De Reais para Pesos Argentinos", "De Reais para Pesos Chilenos", "De Dólares para Reais", "De Euros para Reais", "De Libras Esterlinas para Reais", "De Pesos Argentinos para Reais", "De Pesos Chilenos para Reais"};
		try {
			Object opcaoSelecionada = JOptionPane.showInputDialog(null, "Escolha uma opção", "Escolha uma opção", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
			switch(opcaoSelecionada.toString()) {
			case "De Reais para Dólares":
				setvalorCotacaoMoeda(6);
				break;
			case "De Reais para Euros":
				setvalorCotacaoMoeda(2);
				break;
			case "De Reais para Libras Esterlinas":
				setvalorCotacaoMoeda(3);
				break;
			case "De Reais para Pesos Argentinos":
				setvalorCotacaoMoeda(4);
				break;
			case "De Reais para Pesos Chilenos":
				setvalorCotacaoMoeda(5);
				break;
			case "De Dólares para Reais":
				setvalorCotacaoMoeda(1);
				break;
			case "De Euros para Reais":
				setvalorCotacaoMoeda(7);
				break;
			case "De Libras Esterlinas para Reais":
				setvalorCotacaoMoeda(8);
				break;
			case "De Pesos Argentinos para Reais":
				setvalorCotacaoMoeda(9);
				break;
			case "De Pesos Chilenos para Reais":
				setvalorCotacaoMoeda(10);
				break;		
			}
		}catch (Exception e) {
			// TODO: handle exception
			if (opcoes == null || opcoes.equals(JOptionPane.CANCEL_OPTION)) {
				System.exit(0);
			}
		}
	}

	public static void menuConversor() {
		String valorCotacaoString = JOptionPane.showInputDialog(null, "Insira um valor para a cotação:", "Insira um valor para a cotação", JOptionPane.QUESTION_MESSAGE);
		try {
			String valorCotacaoStringSemVirgula = valorCotacaoString.replaceFirst(",", ".");
			valorCotacaoASerConvertido = Float.parseFloat(valorCotacaoStringSemVirgula);
		}catch (Exception e) {
			if (valorCotacaoString == null || valorCotacaoString.equals(JOptionPane.CANCEL_OPTION)) {
				System.exit(0);
			}
			JOptionPane.showMessageDialog(null, "Você deve digitar um número válido!");
			menuConversor();
		}
		if (valorCotacaoASerConvertido > 0) {
			menuMoedas();
		}
	}
	
	public static void menuSelecao() {
		Object opcoes[] = {"Conversor de moedas"};
		try {
			Object opcaoSelecionada = JOptionPane.showInputDialog(null, "Escolha uma opção", "Escolha uma opção", JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
			if (opcaoSelecionada.toString() == "Conversor de moedas") {
				menuConversor();
			}else if (opcaoSelecionada == null || (opcaoSelecionada != null && ("".equals(opcaoSelecionada)))) {

			}
		} catch (Exception e) {
		}

	}
	
	public static void main(String[] args) {
		Dimension tamanho = Toolkit.getDefaultToolkit().getScreenSize();
		int larguraTela = (int) tamanho.getWidth();
		int alturaTela =  (int) tamanho.getHeight();
		int larguraApp = 500;
		int alturaApp = 100;
		
		//Abre o menu de seleção
		menuSelecao();
		
		//Obtem os preços
		GetPreco precos = new GetPreco();

	}
}
