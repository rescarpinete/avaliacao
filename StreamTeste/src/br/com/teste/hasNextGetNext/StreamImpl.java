package br.com.teste.hasNextGetNext;


public class StreamImpl implements Stream {


    private String stream;
 
    private int indexOf = 0;

    public StreamImpl(String stream) {
	this.stream = stream;
    }
    
    //Retorna proximo caracter
    public char getNext() {
	return this.stream.charAt(indexOf++);
    }

    //Leitura do proximo caracter
    public boolean hasNext() {
	return (this.stream.length() > indexOf);
    }

}
