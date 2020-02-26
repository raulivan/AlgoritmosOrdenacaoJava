package br.com.raulivan.ordenacao;

import br.com.raulivan.ordenacao.core.Item;

public class ImpItem implements Item<Integer> {
	
	private Integer _chave;
	public ImpItem(Integer chave) {
		_chave = chave;
	}
	
	@Override
	public int compara(Item<Integer> it) {
		//O valor atual é menor que o comparado
		if(this._chave < it.recuperaChave()) 
			return -1;
		//O valor atualor é maior que o comparado
		else if (this._chave > it.recuperaChave()) 
			return 1;
		//O valor atual e o comparado são iguais
		else
			return 0;
	}

	@Override
	public void alteraChave(Integer chave) {
		this._chave = chave;
	}

	@Override
	public Integer recuperaChave() {
		return this._chave;
	}
}
