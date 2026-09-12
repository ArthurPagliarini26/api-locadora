package br.com.ctw.api_locadora.service;

import br.com.ctw.api_locadora.entity.Cidade;
import br.com.ctw.api_locadora.exception.RecursoNaoEncontradoException;
import br.com.ctw.api_locadora.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository repository;

    /**
     * Lista todos as cidades
     *
     * @return lista das cidades do banco de dados
     */

    public List<Cidade> listar() {
        return repository.findAll();
    }
    /**
     * Retorna uma cidade pelo seu id
     *
     * @param id ID da cidade que quer buscar
     * @return cidade específica do banco de dados
     */

    public Cidade buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Cidade não encontrada"));
    }

    /**
     * Cadastra uma nova cidade
     *
     * @param cidade que é o json que o usuário vai escrever
     * @return salvamento da cidade
     */

    public Cidade cadastrar(Cidade cidade) {
        cidade.setUltima_atualizacao(LocalDateTime.now());
        return repository.save(cidade);
    }

    /**
     * Atualiza todos os parâmetros de uma cidade
     *
     * @param id ID da cidade que quer atualizar
     * que é o json que o usuário vai escrever
     * @return salvamento da cidade atualizada
     */

    public Cidade atualizar(Long id, Cidade cidade) {
        Cidade cidadeAtualizada = repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Cidade não encontrada"));

        cidadeAtualizada.setCidade(cidade.getCidade());
        cidadeAtualizada.setPais(cidade.getPais());
        cidadeAtualizada.setUltima_atualizacao(LocalDateTime.now());

        return repository.save(cidadeAtualizada);
    }

    /**
     * Atualiza somente os parâmetros desejados de uma cidade
     *
     * @param id ID da cidade que quer atualizar
     * @param cidade que é o json que o usuário vai escrever
     * @return salvamento da cidade atualizado
     */

    public Cidade atualizarParcial(Long id, Cidade cidade) {
        Cidade cidadeAtualizada = repository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException("Cidade não encontrada"));

        if (cidade.getCidade() != null) {
            cidadeAtualizada.setCidade(cidade.getCidade());
        }

        if (cidade.getPais() != null) {
            cidadeAtualizada.setPais(cidade.getPais());
        }

        cidadeAtualizada.setUltima_atualizacao(LocalDateTime.now());
        return repository.save(cidadeAtualizada);
    }

    /**
     * Deleta a cidade
     *
     * @param id ID da cidade que quer deletar
     * @return delete da cidade
     */
    public void deletar(Long id) {
        repository.deleteById(id);
    }

}