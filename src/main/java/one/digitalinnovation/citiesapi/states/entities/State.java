package one.digitalinnovation.citiesapi.states.entities;

import java.util.List;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.citiesapi.countries.entities.Country;

@Entity
@Table(name = "estado")
@AllArgsConstructor
@NoArgsConstructor
@Data
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    @Column(name = "uf")
    private String uf;

    @Column(name = "ibge")
    private Integer ibge;

    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id")
    private Country country;

    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

}
