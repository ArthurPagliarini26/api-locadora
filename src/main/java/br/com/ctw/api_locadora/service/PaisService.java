package br.com.ctw.api_locadora.service;

import br.com.ctw.api_locadora.entity.Pais;
import br.com.ctw.api_locadora.exception.RecursoNaoEncontradoException;
import br.com.ctw.api_locadora.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaisService {

    @Autowired
    private PaisRepository repository;

    /**
     * Lista todos os países
     *
     * @return lista dos países do banco de dados
     */
    public List<Pais> listar() {
        return repository.findAll();
    }

    /**
     * Retorna um país pelo seu id
     *
     * @param id ID do país que quer buscar
     * @return país específico do banco de dados
     */
    public Pais buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("País não encontrado"));
    }

    /**
     * Cadastra um novo país
     *
     * @param pais que é o json que o usuário vai escrever
     * @return salvamento do pais
     */
    public Pais cadastrar(Pais pais) {
        pais.setUltima_atualizacao(LocalDateTime.now());
        return repository.save(pais);
    }

    /**
     * Atualiza todos os parâmetros de um país
     *
     * @param id ID do país que quer atualizar
     * que é o json que o usuário vai escrever
     * @return salvamento do país atualizado
     */
    public Pais atualizar(Long id, Pais pais) {
        Pais paisExiste = repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("País não encontrado"));;

        paisExiste.setPais(pais.getPais());
        paisExiste.setUltima_atualizacao(LocalDateTime.now());

        return repository.save(paisExiste);
    }

    /**
     * Atualiza somente os parâmetros desejados de um país
     *
     * @param id ID do país que quer atualizar
     * @param pais que é o json que o usuário vai escrever
     * @return salvamento do país atualizado
     */
    public Pais atualizarParcial(Long id, Pais pais) {
        Pais paisExiste = repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("País não encontrado"));

        if (pais.getPais() != null) {
            paisExiste.setPais(pais.getPais());
        }

        paisExiste.setUltima_atualizacao(LocalDateTime.now());
        return repository.save(paisExiste);
    }

    /**
     * Deleta o país
     *
     * @param id ID do país que quer deletar
     * @return delete do país
     */
    public void deletar(Long id) {
        repository.deleteById(id);
    }

}
