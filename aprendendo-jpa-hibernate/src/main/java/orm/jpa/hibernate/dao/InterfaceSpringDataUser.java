package orm.jpa.hibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import orm.jpa.hibernate.model.UsuarioSpringData;

@Repository
public interface InterfaceSpringDataUser extends CrudRepository<UsuarioSpringData, Long>{
    
    @Query(value = "select p from UsuarioSpringData p where p.nome like %?1%")
    public List<UsuarioSpringData> buscaPorNome (String nome);

    @Modifying
    @Transactional
    @Query(value = "delete from UsuarioSpringData u where u.nome = ?1")
    public void deleteCondicional(String nome);

    @Modifying
    @Transactional
    @Query(value = "update UsuarioSpringData u set u.email = ?1 where u.nome = ?2")
    public void updateCondicional(String email, String nome);
    
}
