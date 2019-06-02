package br.com.vendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.vendas.domain.Cliente;
import br.com.vendas.repositories.ClienteRepository;
import br.com.vendas.security.UserSS;

@Service
public class UserDetailsServiceImplements implements UserDetailsService{

	@Autowired
	ClienteRepository clienteRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Cliente cli = clienteRepository.findByEmail(email);
		
		if(cli == null) {
			throw new UsernameNotFoundException(email);
		}
		
		
		return new UserSS(cli.getId(),cli.getEmail(), cli.getSenha(), cli.getPerfil());
	}

}
