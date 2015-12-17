
import entidades.Cliente;
import entidades.ClienteDocIdent;
import entidades.QuejasSugerencias;
import java.util.List;
import servicios.ClienteImpl;
import servicios.InterfaceDAO;
import servicios.QuejasImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nishme
 */
public class Test {
    public static void main(String[] args) {
//        InterfaceDAO<Cliente> daoCliente = new ClienteImpl();
//        Cliente cliente = new Cliente();
//        cliente.setNombres("Nishme Estafny");
//        cliente.setApellidos("Zapata Reto");
//        cliente.setTipoPersona("Natural");
//        daoCliente.insert(cliente);
//        System.out.println("Ingresado");
//        Cliente cliente2 = daoCliente.find(3);
//        System.out.println("cliente2" + cliente2.getNombres());
//        cliente2.setNombres("Mish Mish");
//        daoCliente.update(cliente2);
//        cliente2 = daoCliente.find(3);
//        System.out.println("cliente2" + cliente2.getNombres());
//        System.out.println("Find All");
//        List<Cliente> clientes = daoCliente.findAll();
//        for(Cliente c : clientes){
//            System.out.println("Cliente " + c.getNombres() );
//        }
//        System.out.println("Eliminar");
//        daoCliente.eliminar(3);
//         clientes = daoCliente.findAll();
//        for(Cliente c : clientes){
//            System.out.println("Cliente " + c.getNombres() );
//        }
        InterfaceDAO<QuejasSugerencias> daoQuejas = new QuejasImpl();
        QuejasSugerencias quejas = new QuejasSugerencias();
        quejas.setClienteDocIdent(new ClienteDocIdent(1));
        quejas.setObservacion("cualquier cosa");
        daoQuejas.insert(quejas);
    }
}
