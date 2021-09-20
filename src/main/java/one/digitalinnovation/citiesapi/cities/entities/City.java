package one.digitalinnovation.citiesapi.cities.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cidade")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class City {   

    @Id
    Long id;

    @Column(name = "nome")
    String name;

    @Column(name = "uf")
    private Integer uf;

    @Column(name = "ibge")
    private Integer ibge;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

}
