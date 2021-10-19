package teste;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map; 
import java.util.HashMap;

public class Lista{
    
    public static Map<String, Associado> listaRaw;
    public static List<Associado> listaFiltered;
    
    // Lê a lista de nomeArquivo
    public static void inicializarLista(String nomeArquivo) throws IOException {
    	
    	File listaSalva = new File(nomeArquivo);

		if(listaSalva.exists()) {
			try {
				FileInputStream listaStream = new FileInputStream(listaSalva);
				ObjectInputStream leitorLista = new ObjectInputStream(listaStream);
				
				listaRaw = (Map<String, Associado>) leitorLista.readObject();
				
				leitorLista.close();
				listaStream.close();
				
			} catch (ClassNotFoundException | IOException e) {
				System.out.println("something went wrong");
				listaRaw = new HashMap<String, Associado>();
			}
    
		}else
			listaRaw = new HashMap<String, Associado>();
    
    }
    // Escreve a versão atualizada da lista em nomeArquivo
    public static void salvarLista(String nomeArquivo) throws IOException{
    	
	    FileOutputStream listaSalva = new FileOutputStream(new File(nomeArquivo));
		ObjectOutputStream escritorLista = new ObjectOutputStream(listaSalva);
	
		escritorLista.writeObject(listaRaw);
	
		escritorLista.close();
		listaSalva.close();
    }
    
    public static boolean jaExiste(String key) {
    	return listaRaw.containsKey(key);
    }
    
    public static boolean validarCPF(String cpf) {
    	
    	if(cpf.matches("^[0-9]+$") && cpf.length() == 11) {
    		int verificador1 = 0, verificador2 = 0;
    		
    		for(int i = 0; i < 10; i++) {
   				verificador1 += Character.digit(cpf.charAt(i), 10) * (10 - i);
    			verificador2 += Character.digit(cpf.charAt(i), 10) * (11 - i);
    		}					
    		verificador1 -= Character.digit(cpf.charAt(9), 10);
    		
    		verificador1 = ((verificador1 * 10) % 11) % 10;
    		verificador2 = ((verificador2 * 10) % 11) % 10;
    		
    		if(verificador1 == Character.digit(cpf.charAt(9), 10) && verificador2 == Character.digit(cpf.charAt(10), 10))
	    		return true;    		
    	}
    	
    	return false;
    }

}