package br.com.teste.hasNextGetNext;

import java.util.Arrays;

public class StreamMain {

	public static void main(String[] args) {

		char charOutput;
		try {			
			charOutput = firstChar(new StreamImpl("aAbBABacafe"));
			
			System.out.println(charOutput);
			
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		}

	}
	

	public static char firstChar(Stream input) throws Exception{
		
		char charUnico;
		int size = 11, increment = 0;
		int found;

		//Armazena char encontrador
		char[] charsRepetidos = new char[size];

		//Armazena chars iguais
		short[] qtdIguais = new short[size];

		
		while (input.hasNext()) {
			
			charUnico = input.getNext();

			//Encontra char no array iguais
			found = sChar(charUnico, charsRepetidos);			

			if (found >= 0) {
				qtdIguais[found]++;
			} else {
				//Inclui char 
				charsRepetidos[increment] = charUnico;
				qtdIguais[increment]++;
				increment++;
			}

			//contrala o tamanho do array 
			if (increment == charsRepetidos.length) {
				charsRepetidos = Arrays.copyOf(charsRepetidos, charsRepetidos.length + size);
				qtdIguais = Arrays.copyOf(qtdIguais, charsRepetidos.length + size);
			}
		}

		// pega o primeiro char que nao repetido
		int firstChar = sCharFirst(qtdIguais);

		// se nao existir, informa o usuario
		if (firstChar < 0) {
			throw new Exception("Nenhum caracter encontrado!");
		}

		// output caracter
		return charsRepetidos[firstChar];
	}
	
	private static int sChar(char charUnico, char[] charsRepetidos) {
		for (int i = 0; i < charsRepetidos.length; i++) {
			if (charUnico == charsRepetidos[i]) {
				return i;
			}
		}
		return -1;
	}

	private static int sCharFirst(short[] charsRepetidos) {
		int result = -1;
		for (int i = 0; i < charsRepetidos.length; i++) {
			if (charsRepetidos[i] == 1) {
				result = i;				
			}
		}
		return result;
	}
}
