package com.aewinformatica.sis03.util;

import java.io.File;

import javax.swing.JOptionPane;

public class Utilidades {

    public static boolean  checkExistFileCSV(String arqcsv) {
        boolean retorno = true;
     try {
         File arquivo = new File(arqcsv);
         if (!arquivo.exists()) {
         JOptionPane.showMessageDialog(null, "Não encontrou o arquivo: " + arqcsv + "\nCopie o arquivo do googledrive para a pasta: " + System.getProperty("user.dir") + " e tente novamente!"
                 + "\nSe o problema persistir, favor pedir ajuda ao suporte!!");
         retorno = false;
         }
     } 
	catch (Exception ex) {
         JOptionPane.showMessageDialog(null, "Erro ao tentar verificar a existencia do arquivo: " + arqcsv + ".\nErro: " + ex);
         retorno = false;
     }
     return retorno;
    }
}
