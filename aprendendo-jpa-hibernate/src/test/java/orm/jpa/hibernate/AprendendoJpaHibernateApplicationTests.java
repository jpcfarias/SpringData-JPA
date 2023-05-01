package orm.jpa.hibernate;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import orm.jpa.hibernate.dao.InterfaceSpringDataUser;
import orm.jpa.hibernate.dao.InterfaceTelefonePessoa;
import orm.jpa.hibernate.model.TelefonePessoa;
import orm.jpa.hibernate.model.UsuarioSpringData;

@SpringBootTest
class AprendendoJpaHibernateApplicationTests {

	@Autowired
    private InterfaceSpringDataUser interfaceSpringDataUser;

	@Autowired
	private InterfaceTelefonePessoa interfaceTelefonePessoa;

	@Test
	void teste() {
		System.out.println("Iniciando Spring...");
	}

	@Test
	void testeInsert() {
		UsuarioSpringData usuarioSpringData = new UsuarioSpringData();
		usuarioSpringData.setEmail("java@gmail.com");
		usuarioSpringData.setIdade(20);
		usuarioSpringData.setLogin("java123");
		usuarioSpringData.setSenha("admin");
		usuarioSpringData.setNome("java");

		interfaceSpringDataUser.save(usuarioSpringData);
	}

	@Test
	void testeConsulta() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		System.out.println(usuarioSpringData.get().toString());
	}

	@Test
	void testeConsultaTodos() {

		Iterable<UsuarioSpringData> lista = interfaceSpringDataUser.findAll();
		System.out.println("******** Lista de usuarios cadastrados ********\n");
		for (UsuarioSpringData usuarioSpringData : lista) {
			System.out.println(usuarioSpringData.toString());
			System.out.println("------------------------------------------------------------------------");
		}
	}
	@Test
	void testeUpdate() {
		Optional<UsuarioSpringData> usuarioSpringData = interfaceSpringDataUser.findById(1L);
		UsuarioSpringData data = usuarioSpringData.get();
		data.setNome("joao farias");
		interfaceSpringDataUser.save(data);
	}

	@Test
	void testeDelete() {
		interfaceSpringDataUser.deleteById(3L);
	}

	@Test
	void testeBuscaPorNome(){
		List<UsuarioSpringData> list = interfaceSpringDataUser.buscaPorNome("luis");
		System.out.println("******** Lista de busca por nome ********\n");
		for (UsuarioSpringData usuarioSpringData : list) {
			System.out.println(usuarioSpringData.toString());
			System.out.println("------------------------------------------------------------------------");
		}
	}

	@Test
	void testeDeletaCondicional(){
		interfaceSpringDataUser.deleteCondicional("luis");
	}

	@Test
	void testeUpdateCondicional(){
		interfaceSpringDataUser.updateCondicional("joaofarias@gmail.com","joao farias");
	}

	@Test
	void testeInsertTelefone(){
		Optional<UsuarioSpringData> usuarioTelefone = interfaceSpringDataUser.findById(1L);
		TelefonePessoa telefone = new TelefonePessoa();
		telefone.setNumero("12937182939");
		telefone.setTipo("Celular");
		telefone.setUsuarioSpringData(usuarioTelefone.get());

		interfaceTelefonePessoa.save(telefone);
		
	}

}
