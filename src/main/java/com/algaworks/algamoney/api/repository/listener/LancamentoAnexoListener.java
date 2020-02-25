package com.algaworks.algamoney.api.repository.listener;

import javax.persistence.PostLoad;

import org.springframework.util.StringUtils;

import com.algaworks.algamoney.api.AlgamoneyApiApplication;
import com.algaworks.algamoney.api.model.Lancamento;
import com.algaworks.algamoney.api.storage.Local;

public class LancamentoAnexoListener {

	@PostLoad
	public void postLoad(Lancamento lancamento) {
		if (StringUtils.hasText(lancamento.getAnexo())) {
			Local local = AlgamoneyApiApplication.getBean(Local.class);
			lancamento.setUrlAnexo(local.configurarUrl(lancamento.getAnexo()));
		}
	}
}
