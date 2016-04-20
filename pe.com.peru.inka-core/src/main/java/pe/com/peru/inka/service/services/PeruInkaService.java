package pe.com.peru.inka.service.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.peru.inka.service.util.Cliente;

@Service("peruInkaService")
public class PeruInkaService {

	public static List<Cliente> list = new ArrayList<Cliente>();
	
	public void saveCliente(Cliente cliente){
		list.add(cliente);
	}
	
	public List<Cliente> findAllCliente(){
		return list;
	}
	
	public void updateCliente(Cliente clienteUpdate){
		List<Cliente> listTemp = new ArrayList<Cliente>();
		
		for (Cliente cliente : list) {
			if(clienteUpdate.getId().compareTo(cliente.getId())==0){
				listTemp.add(clienteUpdate);
			}else{
				listTemp.add(cliente);
			}
		}
		list = new ArrayList<Cliente>();
		list.addAll(listTemp);

	}
	
	public Cliente searchCliente(Long id){
		Cliente clienteReturn = new Cliente();
		for (Cliente cliente : list) {
			if(id.compareTo(cliente.getId())==0){
				clienteReturn = cliente;
				continue;
			}
		}
		return clienteReturn;
	}
	
	public void deleteCliente(Long id){
		List<Cliente> listTemp = new ArrayList<Cliente>();
		
		for (Cliente cliente : list) {
			if(id.compareTo(cliente.getId())!=0){
				listTemp.add(cliente);
			}
		}
		list = new ArrayList<Cliente>();
		list.addAll(listTemp);
	}

}
