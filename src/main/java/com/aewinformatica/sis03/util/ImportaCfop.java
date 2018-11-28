package com.aewinformatica.sis03.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aewinformatica.sis03.entity.Cfop;
import com.aewinformatica.sis03.repository.CfopRepository;
import com.aewinformatica.sis03.service.CfopService;

@Component
public class ImportaCfop {
	
	private  Scanner input;
	
	@Autowired
//	private Cfop reg = new Cfop();
	private Cfop reg;
    @Autowired
	private CfopRepository cfopRepository;
	
	@Autowired
	private CfopService cfopService;
	
    @Autowired
    public ImportaCfop() {
    	this.reg = new Cfop();
  
    }
    
    public  void ImportaArquivo() {
     	 processaCfop();
         fechaArquivo();   
    }

public  void processaCfop(){
	String arqcsv = System.getProperty("user.dir")+System.getProperty("file.separator")+"cfop.csv";
    
	//JOptionPane.showMessageDialog(null, "Nome do arquivo texto: " + arqcsv );
	//System.out.println("Nome do arquivo texto: " + arqcsv );
	
	try{
                input = new Scanner(new File(arqcsv));
                leRegistros();
	}
	catch (FileNotFoundException e){
                JOptionPane.showMessageDialog(null, "Não encontrou o arquivo: " + arqcsv + " e a Importação de CFOP não será efetuada!");
	}
       
}

public void leRegistros()
{
        //  Abre o banco de dados Cadastros

//	Optional<Cfop>lista = cfopRepository.findById(1);
//	JOptionPane.showMessageDialog(null, lista);
 	
        int qtReg = 0;
        try
        {
            String frase = input.nextLine();
	while ( input.hasNextLine()){
                frase = input.nextLine();
                String delimita = ";";
                qtReg++;
//                		System.out.println("qtReg: "+qtReg);			
                StringTokenizer token = new StringTokenizer( frase , delimita);
                int cpo = 0;
                while ( token.hasMoreTokens() )
                {
                    cpo++;
                    String wconteudo = token.nextToken();
                   
//                        JOptionPane.showMessageDialog(null, "Num.Campo: " + cpo + " / 6" +  " - Conteudo: " + wconteudo);
                    
                   
                    switch (cpo%7){
                            case 1: 
                                reg.setCfop(Integer.parseInt(wconteudo));
                                System.out.println("Cfop: "+reg.getCfop());
        
                                break;
                            case 2: 
                            	reg.setSeqcfop(Integer.parseInt(wconteudo)); 
                                System.out.println("seqcfop: "+reg.getSeqcfop());

                                break;
                            case 3: 
                            	reg.setDescricao(wconteudo.toUpperCase().trim()); 
                                System.out.println("descricao: "+reg.getDescricao());

                                break;
                            case 5: 
                                reg.setOperacao(wconteudo.toUpperCase().trim()); 
                                System.out.println("operacao: "+reg.getOperacao());

                             
                                reg.setFinanceiro(false);
                                reg.setFaturamento(true);
//                                
//                                insereRegistro();
//                                                         
                                break;

                	}
                    //insereRegistro();
                    
                }
                
                
            }
	        insereRegistro();
//	        JOptionPane.showMessageDialog(null, reg.getCodigo());
            JOptionPane.showMessageDialog(null, "Foram Importados " + qtReg + " Registros de CFOP com Sucesso!");//depois mudar de lugar
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
		
//    public void insereRegistro(){
////  Inclusao do registro no banco de dados
//    try
//    {
//    	Optional<Cfop> cfopEncontrado = cfopRepository.findById(reg.getCfop());
//
//      //  cfopService.salvar(reg);       
//
//    		  JOptionPane.showMessageDialog(null,"Gravacao realizado com sucesso!");     
//    }
//            catch (Exception erro)
//            {
//                JOptionPane.showMessageDialog(null,"Erro a tentar Gravar o registro com codigo: "+reg.getCodigo()+" - Cfop: "+reg.getCfop()+" - seqcfop: "+reg.getCfop()+" - Descricao: "+ reg.getDescricao()+" - faturamento: "+ reg.isFaturamento()+" - Financeiro: "+ reg.isFinanceiro()+" - Operacao: "+reg.getOperacao()+"  - Erro: "+erro);
//            }
//       
//    }
    
    public void insereRegistro(){
//  Inclusao do registro no banco de dados
    
//    	Optional<Cfop> cfopEncontrado = cfopRepository.findById(reg.getCfop());

      //  cfopService.salvar(reg);       

    		  JOptionPane.showMessageDialog(null,"Gravacao realizado com sucesso!");     
    
    
       
    }
    public  void fechaArquivo()
{
	if (input != null)
		input.close();
}

	public static void main(String[] args) {		

//		Cfop cfop = new Cfop();
//		ImportaCfop leCfop = new ImportaCfop(cfop);
		//ImportaCfop leCfop = new ImportaCfop();
		//leCfop.ImportaArquivo();



}
}
