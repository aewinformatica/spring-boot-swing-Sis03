package com.aewinformatica.sis03.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.entity.Cfop;
import com.aewinformatica.sis03.repository.CfopRepository;



@Component
public class ImportaCfop {
	
	private  Scanner input;
	
    @Autowired
    CfopRepository cfopRepository;
    
    
    @Bean
    public  void processaCfop(){
    	String arqcsv = System.getProperty("user.dir")+System.getProperty("file.separator")+"cfop.csv";
        
    	//JOptionPane.showMessageDialog(null, "Nome do arquivo importado: " + arqcsv );
    	System.out.println("Nome do arquivo Importado: " + arqcsv );
    	
    	try{
            input = new Scanner(new File(arqcsv));
            leRegistros();
    	}
    	catch (FileNotFoundException e){
                    JOptionPane.showMessageDialog(null, "Não encontrou o arquivo: " + arqcsv + " e a Importação de CFOP não será efetuada!");
    	}
           
    }
    
    public void leRegistros(){	
        //Abre o banco de dados Cadastros
//	List<Cfop>lista = cfopService.findAll();
//	Optional<Cfop>list = cfops.findById(1);
	List<Cfop>lista =  cfopRepository.findAll();
	System.out.println(lista);
//	JOptionPane.showMessageDialog(null, lista);
 	
        int qtReg = 0;
    
        try
        {
            String frase = input.nextLine();
	    while 
	    ( 
	    input.hasNextLine()){
                frase = input.nextLine();
                String delimita = ";";
                qtReg++;
//                		System.out.println("qtReg: "+qtReg);			
                StringTokenizer token = new StringTokenizer( frase , delimita);
                int cpo = 0;
                Cfop reg = new Cfop();
                while ( token.hasMoreTokens() ){
                    cpo++;
                    String wconteudo = token.nextToken();                   
                        //JOptionPane.showMessageDialog(null, "Num.Campo: " + cpo + " / 6" +  " - Conteudo: " + wconteudo);
                    
			                    reg.setObservacao(" ");
			                    reg.setFinanceiro(Boolean.valueOf(false));
			                    reg.setFaturamento(Boolean.valueOf(true));  
                    switch (cpo%7){
                            case 1: 
                                reg.setCfop(Long.parseLong(wconteudo));
                                //System.out.println("Cfop: "+reg.getCfop());
        
                                break;
                            case 2: 
                            	reg.setSeqcfop(Long.parseLong(wconteudo)); 
                                //System.out.println("seqcfop: "+reg.getSeqcfop());

                                break;
                            case 3: 
                            	reg.setDescricao(wconteudo.toUpperCase().trim()); 
                                //System.out.println("descricao: "+reg.getDescricao());

                                break;
                            case 5: 
                                reg.setOperacao(wconteudo.toUpperCase().trim()); 
                                //System.out.println("operacao: "+reg.getOperacao());
                   	           
//                                System.out.println(reg);
                                
                                cfopRepository.save(reg);
                                
                                /*
                                Optional<ValidationError> errors = cfopValidator.validate(reg);
                                if (errors.isPresent()) {
                                    ValidationError validationError = errors.get();
                                    Notifications.showFormValidationAlert(validationError.getMessage());
                                    //JOptionPane.showMessageDialog(null,"Erro a tentar Gravar o registro com  - Cfop: "+reg.getCfop()+" - seqcfop: "+reg.getCfop()+" - Descricao: "+ reg.getDescricao()+"- Observação: "+ reg.getObservacao()+" - faturamento: "+ reg.isFaturamento()+" - Financeiro: "+ reg.isFinanceiro()+" - Operacao: "+reg.getOperacao());
                                } else {
                                    cfopService.salvar(reg);
                                  }
                                */
                    	                      	        
                                break;
                	}
                    
                }
            
            }
//            JOptionPane.showMessageDialog(null, "Foram Importados " + qtReg + " Registros de CFOP com Sucesso!");//depois mudar de lugar
    }
        catch( NoSuchElementException e)
        {
        	System.err.println("Erro de tipo de dado incompativel!");
	System.exit(1);
        }
        catch (IllegalStateException e)
        {
        	System.err.println("Erro ao ler o arquivo!");
	System.exit(1);
        }
    }    
}
