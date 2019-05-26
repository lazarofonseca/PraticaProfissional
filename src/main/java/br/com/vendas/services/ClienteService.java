package br.com.vendas.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vendas.domain.Cidade;
import br.com.vendas.domain.Cliente;
import br.com.vendas.domain.Endereco;
import br.com.vendas.domain.enums.TipoCliente;
import br.com.vendas.dto.ClienteDTO;
import br.com.vendas.dto.ClienteNewDTO;
import br.com.vendas.repositories.CidadeRepository;
import br.com.vendas.repositories.ClienteRepository;
import br.com.vendas.repositories.EnderecoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	public Cliente find(Integer id) throws ObjectNotFoundException {

		Optional<Cliente> obj = clienteRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrada! Id: " + id + ", Tipo: " + Cliente.class.getName()));

	}

	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		clienteRepository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}

	public Cliente update(Cliente obj) throws ObjectNotFoundException {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return clienteRepository.save(newObj);
	}

	public void delete(Integer id) throws ObjectNotFoundException {
		find(id);
		clienteRepository.deleteById(id);

	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDto) {

		return new Cliente(objDto.getId(), objDto.getNome(), null, null, objDto.getEmail());
	}

	public Cliente fromDTO(ClienteNewDTO objDto) throws ObjectNotFoundException {

		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getCpfOuCnpj(), TipoCliente.toEnum(objDto.getTipo()),
				objDto.getEmail());
		
		//Cidade cid = findCid(objDto.getCidadeId());

		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
		cli.getEnderecos().addAll(Arrays.asList(end));

		cli.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
/*
	public Cidade findCid(Integer id) throws ObjectNotFoundException {

		Optional<Cidade> obj = cidadeRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrada! Id: " + id + ", Tipo: " + Cidade.class.getName()));

	}
	*/
}
