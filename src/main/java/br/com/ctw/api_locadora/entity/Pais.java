package br.com.ctw.api_locadora.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name="pais")

/**
 * Representa um país cadastrado no sistema
 * @author Arthur Martins
 */
@Entity

public class Pais {

    /**
     * Identificador único do país
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pais_id;

    /**
     * Nome do país
     */
    @Column(name = "pais")
    private String pais;

    /**
     * Última data da atualização, sendo put ou patch
     */
    @Column(name = "ultima_atualizacao")
    private LocalDateTime ultima_atualizacao;


    /**
     * Relação um pra muitos com a classe cidade
     */
    @OneToMany(mappedBy = "pais")
    private List<Cidade> cidade;
}
