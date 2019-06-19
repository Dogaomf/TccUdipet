import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.udipet.entity.Role;
import br.udipet.entity.Usuario;
import br.udipet.repository.UsuarioRepository;

public class testelogin {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	

	@Test
	public void test(String nomeUsuario) {
		Usuario usuario = usuarioRepository.findByNomeUsuario(nomeUsuario);
		if (usuario == null) {
			throw new UsernameNotFoundException("E-mail ou senha inválidos.");
		}
		assertTrue(nomeUsuario);
	}

	private void assertTrue(String nomeUsuario) {
		nomeUsuario= "jojo";
		
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNome())).collect(Collectors.toList());
	}

	}
