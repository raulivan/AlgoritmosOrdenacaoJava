package br.com.raulivan.ordenacao.core;

public interface Item<TipoChave> {

	public int compara(Item<TipoChave> it);
	
	public void alteraChave(TipoChave chave);
	
	public TipoChave recuperaChave();
}
