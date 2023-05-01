package orm.jpa.hibernate.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class TelefonePessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    private String numero;

    @ManyToOne
    private UsuarioSpringData usuarioSpringData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public UsuarioSpringData getUsuarioSpringData() {
        return usuarioSpringData;
    }

    public void setUsuarioSpringData(UsuarioSpringData usuarioSpringData) {
        this.usuarioSpringData = usuarioSpringData;
    }
}
