package br.com.ctw.api_locadora.controller;

import br.com.ctw.api_locadora.entity.Cidade;
import br.com.ctw.api_locadora.service.CidadeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-locadora/cidade")

public class CidadeController {

    @Autowired
    private CidadeService service;

    @Operation(summary = "Busca todos as cidades")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Cidades encontradas"
            )
    })

    @GetMapping
    public ResponseEntity<List<Cidade>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @Operation(summary = "Busca uma cidade pelo ID")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Cidade encontrada"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Cidade não encontrada"
            )
    })

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> buscarPorId(@PathVariable Long id) {
        Cidade cidadeEncontrada = service.buscarPorId(id);

        if (cidadeEncontrada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cidadeEncontrada);
    }

    @Operation(summary = "Cadastra uma nova cidade")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Cidade criada"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Json com sistaxe errada"
            )
    })

    @PostMapping
    public ResponseEntity<Cidade> cadastrar(@RequestBody Cidade cidade) {
        service.cadastrar(cidade);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Atualiza uma cidade pelo ID")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Cidade atualizada"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Json com sistaxe errada"
            )
    })

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> atualizar (@PathVariable Long id, @RequestBody Cidade cidade) {
        service.atualizar(id, cidade);
        return ResponseEntity.ok(cidade);
    }

    @Operation(summary = "Atualiza dados específicos de uma cidade pelo ID")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Cidade atualizada"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Cidade não encontrada"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Json com sistaxe errada"
            )
    })

    @PatchMapping("/{id}")
    public ResponseEntity<Cidade> atualizarParcial (@PathVariable Long id, @RequestBody Cidade cidade) {
        Cidade cidadeAtualizada = service.atualizarParcial(id, cidade);
        return ResponseEntity.ok(cidadeAtualizada);
    }

    @Operation(summary = "Deleta uma cidade pelo ID")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Cidade deletada"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Cidade não encontrada"
            )
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
