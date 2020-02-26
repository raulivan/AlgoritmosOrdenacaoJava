package br.com.raulivan.ordenacao.interna;

import br.com.raulivan.ordenacao.core.Item;

public class AlgoritmosOrdenacaoInterna {

	public static void selectionSort (Item<Integer> v[] , int n) {
		
		long tempoinicial = System.currentTimeMillis();
		
        for (int i = 0; i < n; i++) {
            int indiceMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (v[j].compara(v[indiceMinimo]) < 0) {
                    indiceMinimo = j;
                }
            }
            
            Item<Integer> tmp = v[indiceMinimo];
            v[indiceMinimo] = v[i];
            v[i]= tmp;
            
        }
        long tempofinal = System.currentTimeMillis();
        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de Processamento de SelectionSort: " + tempototal + "ms");
        
	} 
	
	public static void insertionSort (Item<Integer> v[] , int n) {
		long tempoinicial = System.currentTimeMillis();
		
        for (int i = 0; i < n; i++) {
        	Item<Integer> atual = v[i];
            int j = i - 1;
            while (j >= 0 && v[j].compara(atual) >= 0) {
                v[j + 1] = v[j];
                j--;
            }
            v[j + 1] = atual;;
        }
        long tempofinal = System.currentTimeMillis();
        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de Processamento de InsertionSort: " + tempototal + "ms");
	}

	public static void bubbleSort(Item<Integer> v[], int n) {
		
        long tempoinicial = System.currentTimeMillis();
        
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (v[j - 1].compara(v[j]) > 0) {
                	Item<Integer> aux = v[j];
                    v[j] = v[j - 1];
                    v[j - 1] = aux;
                }
            }
        }
        long tempofinal = System.currentTimeMillis();
        long tempototal = tempofinal - tempoinicial;
        System.out.println("Tempo de Processamento de BubbleSort: " + tempototal + "ms");
    }

	//Métodos referente ao algoritmo quicksort
	
	public static void quicksort(Item<Integer> v[], int ini, int fim) {
		 
        int meio;

        if (ini < fim) { 
            meio = particao(v, ini, fim);
            
            quicksort(v, ini, meio);
            
            quicksort(v, meio + 1, fim);
        }
    }
	
	
	private static int particao(Item<Integer> v[], int ini, int fim) {
		 
		Item<Integer> pivo;
		int topo, i;
 
        pivo = v[ini];
        topo = ini;
 
        for (i = ini + 1; i < fim; i++) {
        	
            if (v[i].compara(pivo) < 0) {
            	
                v[topo] = v[i];
                v[i] = v[topo + 1];
                topo++;
            }
        }
        v[topo] = pivo;
 
        return topo;
    }
	
	//Fim dos métodos do quicksort
	
	//Métodos do HeapSort 
	public static void heapSort(Item<Integer> v[], int n) {
        buildMaxHeap(v,n);
        int n2 = n;

        for (int i = n - 1; i > 0; i--) {
            swap(v, i, 0);
            maxHeapify(v, 0, --n2);
        }
    }

    private static void buildMaxHeap(Item<Integer> v[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(v, i, n);
        }

    }

    private static void maxHeapify(Item<Integer> v[], int pos, int tamanhoDoVetor) {

        int max = 2 * pos + 1, right = max + 1;
        if (max < tamanhoDoVetor) {

            if (right < tamanhoDoVetor && v[max].compara(v[right]) < 0) {
                max = right;
            }

            if (v[max].compara(v[pos]) > 0) {
                swap(v, max, pos);
                maxHeapify(v, max, tamanhoDoVetor);
            }
        }
    }

    private static void swap(Item<Integer> v[], int j, int aposJ) {
    	Item<Integer> aux = v[j];
        v[j] = v[aposJ];
        v[aposJ] = aux;
    }
	//Fim Métodos do HeapSort 
    
	public static void shellsort (Item<Integer> v[] , int n) {
		int h = 1;
		do {
			h = h * 3 + 1; 
		}while (h < (n - 1));
		
		do {
			h /= 3;
			for (int i = h ; i < n; i ++) {
				Item<Integer> x = v[i]; 
				int j = i;
				while (v[j-h].compara(x) > 0) {
					v[j]= v[j-h];
					j -= h;
					if (j <= h) 
						break;
				}
				v[j] = x;
			}
		}while (h != 1);
	}
}
