package orm.jpa.hibernate.dao;

import org.springframework.data.repository.CrudRepository;

import orm.jpa.hibernate.model.TelefonePessoa;

public interface InterfaceTelefonePessoa extends CrudRepository<TelefonePessoa, Long>{
    
}
