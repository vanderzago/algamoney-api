package com.algaworks.algamoney.api.storage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.algaworks.algamoney.api.config.property.AlgamoneyApiProperty;

@Component
public class Local {

	private static Logger logger = LogManager.getLogger(Local.class);
	
	@Autowired
	private AlgamoneyApiProperty property;
	
	public String configurarUrl(String objeto) {
		return property.getLocal().getPath() + "/" + objeto;
	}
	
	public void salvar(MultipartFile anexo) throws IOException {
		String anexoURL=this.configurarUrl(anexo.getOriginalFilename());
		OutputStream out = new FileOutputStream(anexoURL);
		out.write(anexo.getBytes());
		out.close();
		if (logger.isDebugEnabled()) {
			logger.debug("Arquivo {} salvo com sucesso.", 
					anexo.getOriginalFilename());
		}  
	}

	public void remover(String objeto) {
		try  
		{         
			String anexoURL=this.configurarUrl(objeto);
			File f= new File(anexoURL); 
			if(f.delete()) 
			{  
				if (logger.isDebugEnabled()) {
					logger.debug("Arquivo {} deletado com sucesso.", 
							objeto);
				}  
			}  
		}
		catch(Exception e)  
		{  
			if (logger.isDebugEnabled()) {
				logger.debug("Falha ao deletar arquivo {}.", 
						objeto);
			}  
			e.printStackTrace();
		}  	
	}
}
