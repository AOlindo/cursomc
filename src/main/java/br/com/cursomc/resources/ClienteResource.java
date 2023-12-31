package br.com.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cursomc.domain.Cliente;
import br.com.cursomc.dto.ClienteDTO;
import br.com.cursomc.dto.ClienteNewDTO;
import br.com.cursomc.services.ClienteService;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/{id}")
	public ResponseEntity<Cliente>find(@PathVariable Long id){
		Cliente obj = clienteService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping("/email")
	public ResponseEntity<Cliente> find(@RequestParam(value = "value") String email){
		Cliente obj = clienteService.findByEmail(email);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO clienteDto) {
		Cliente cliente = clienteService.fromDTO(clienteDto);
		cliente = clienteService.insert(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId())
				.toUri();// Gera a URL do cliente cadastrado.
		return ResponseEntity.created(uri).build();

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateClient(@Valid @RequestBody ClienteDTO clienteDto, @PathVariable Long id){
		Cliente cliente = clienteService.fromDTO(clienteDto);
		cliente.setId(id);
		cliente = clienteService.update(cliente);
		return ResponseEntity.noContent().build();
	}
	@PreAuthorize("hasAnyRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		clienteService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<Cliente> lista = clienteService.findAll();
		List<ClienteDTO> listaDto = lista.stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDto);
	}
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/page")
	public ResponseEntity<Page<ClienteDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction){
				
			Page<Cliente> lista = clienteService.findPage(page, linesPerPage, orderBy, direction);
			Page<ClienteDTO> listaDto = lista.map(cliente -> new ClienteDTO(cliente));
			return ResponseEntity.ok().body(listaDto);
	}
	@PostMapping("/picture")
	public ResponseEntity<Void>uploadProfilePicture(@RequestParam(name = "file") MultipartFile file){
		URI uri = clienteService.uploadProfilePicture(file);
		return ResponseEntity.created(uri).build();
	}
	
	

	}
