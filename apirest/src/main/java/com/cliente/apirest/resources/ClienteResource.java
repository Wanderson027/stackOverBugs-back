package com.cliente.apirest.resources;

import com.cliente.apirest.models.Cliente;
import com.cliente.apirest.models.Contato;
import com.cliente.apirest.models.Email;
import com.cliente.apirest.repository.ClienteRepository;
import com.cliente.apirest.repository.ContatoRepository;
import com.cliente.apirest.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteResource {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    ContatoRepository contatoRepository;

    @GetMapping("/clientes")
    public List<Cliente> listaClientes(){
        return clienteRepository.findAll();
    }

    @GetMapping("/cliente/{id}")
    public Optional<Cliente> clienteById(@PathVariable(value = "id") long id){
        return clienteRepository.findById(id);
    }

    @PostMapping("/cliente")
    public Cliente salvaCliente(@RequestBody Cliente cliente){
        for (Contato contato : cliente.getTelefones()){
            contato.setCliente(cliente);
        }
        for (Email email : cliente.getEmails()){
            email.setCliente(cliente);
        }
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/cliente/{id}")
    public void deletaCliente(@PathVariable(value="id") long id){
        clienteRepository.deleteById(id);
    }

    @PutMapping("/cliente")
    public Cliente atualizaCliente(@RequestBody Cliente cliente){
        for(Contato contato : cliente.getTelefones()){
            contato.setCliente(cliente);
        }
        for(Email email : cliente.getEmails()){
            email.setCliente(cliente);
        }
        return clienteRepository.save(cliente);
    }
}
