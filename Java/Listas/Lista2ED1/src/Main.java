/*		
 * 		Implantação das classes construidas para fazer a lista 02
 * 	
 * 	Autor: Luiz Fernando (luizfcneto)
 * 	Email: Luizfcneto123@gmail.com
 * 	Descrição: Implantação dos métodos da questão 1) 
 * 
 * 
 */


public class Main {
	
	public static void main( String[] args ) {
		Fila fila1, fila2,filaMista;
		
		fila1 = new Fila();
		fila2 = new Fila();
		filaMista = new Fila();
		fila1.adicionaNaFila(1);
		fila1.adicionaNaFila(2);
		fila1.adicionaNaFila(3);
		
		fila2.adicionaNaFila(4);
		fila2.adicionaNaFila(5);
		fila2.adicionaNaFila(6);
		
		filaMista.combinaFilas(fila1, fila2);
		filaMista.imprimeFila();
//		fila1.imprimeFila();
//		fila2.imprimeFila();
	}
	
	
}