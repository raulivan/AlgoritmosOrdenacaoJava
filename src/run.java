
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import br.com.raulivan.ordenacao.ImpItem;
import br.com.raulivan.ordenacao.core.Item;
import br.com.raulivan.ordenacao.interna.AlgoritmosOrdenacaoInterna;

public class run {

	public static void main(String[] args) {
		int n = 100;
		Item<Integer>[] v = geraValoresAleatorios(n);
		System.out.println("Vetor sem ordenação:");
		imprimirVetor(v);
		
		System.out.println("\nApós Ordenação");
		AlgoritmosOrdenacaoInterna.quicksort(v, 0,n);
		imprimirVetor(v);		
	}
	
	public static void imprimirVetor(Item<Integer>[] v) {
		for(Item<Integer> item: v)
			System.out.printf("%d - ",item.recuperaChave());
	}
	
	public static Item<Integer>[] geraValoresAleatorios(int tamanho){
		Item<Integer>[] v = new Item[tamanho];
		
		Random gerador = new Random(GregorianCalendar.getInstance().getTimeInMillis());
		
		for(int i = 0; i < tamanho; i++) {
			v[i] = new ImpItem(gerador.nextInt(tamanho+10) + 1) ;
		}
		return v;
	}
}
