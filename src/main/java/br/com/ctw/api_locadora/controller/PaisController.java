package br.com.ctw.api_locadora.controller;
import br.com.ctw.api_locadora.entity.Pais;
import br.com.ctw.api_locadora.service.PaisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-locadora/pais")

public class PaisController {

    @Autowired
    private PaisService service;

    @Operation(summary = "Busca todos os países")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Países encontrados"
            )
    })
    @GetMapping()
    public ResponseEntity<List<Pais>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @Operation(summary = "Busca um país pelo ID")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "País encontrado"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "País não encontrado"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<Pais> buscarPorId(@PathVariable Long id) {
        Pais paisEncontrado = service.buscarPorId(id);

        if (paisEncontrado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(paisEncontrado);
    }

    @Operation(summary = "Cadastra um novo país")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "País criado"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Json com sistaxe errada"
            )
    })
    @PostMapping
    public ResponseEntity<Pais> cadastrar(@RequestBody Pais pais) {
        service.cadastrar(pais);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Atualiza um país pelo ID")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "País atualizado"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Json com sistaxe errada"
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<Pais> atualizar(@PathVariable Long id, @RequestBody Pais pais) {
        service.atualizar(id, pais);
        return ResponseEntity.ok(pais);
    }

    @Operation(summary = "Atualiza dados específicos de um país pelo ID")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "País atualizado"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "País não encontrado"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Json com sistaxe errada"
            )
    })
    @PatchMapping("/{id}")
    public ResponseEntity<Pais> atualizarParcial(@PathVariable Long id, @RequestBody Pais pais) {
        service.atualizarParcial(id, pais);
        return ResponseEntity.ok(pais);
    }

    @Operation(summary = "Deleta um país pelo ID")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "País deletado"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "País não encontrado"
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
