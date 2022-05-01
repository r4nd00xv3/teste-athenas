package controllers;

import java.util.List;

import model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import repository.PessoaRepository;


/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {

	@Autowired /* IC/CD ou CDI - Injeção de dependencia */
	private PessoaRepository pessoaRepository;


	@RequestMapping(value = "/olamundo/{nome}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String retornaOlaMundo(@PathVariable String nome) {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);

		pessoaRepository.save(pessoa);/* grava no banco de dados */

		return "Ola mundo " + nome;
	}

	@GetMapping(value = "listatodos") /* Nosso primeiro método de API */
	@ResponseBody /* Retorna os dados par ao corpo da resposta */
	public ResponseEntity<List<Pessoa>> listaUsuario() {

		List<Pessoa> usuarios = pessoaRepository.findAll();/* executa a consulta no banco de dados */

		return new ResponseEntity<List<Pessoa>>(usuarios, HttpStatus.OK);/* Retorna a lista em JSON */

	}

	@PostMapping(value = "salvar") /* mapeia a url */
	@ResponseBody /* Descricao da resposta */
	public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa usuario) { /* Recebe os dados para salvar */

		Pessoa user = pessoaRepository.save(usuario);

		return new ResponseEntity<Pessoa>(user, HttpStatus.CREATED);

	}
	
	
	@PutMapping(value = "atualizar") /* mapeia a url */
	@ResponseBody /* Descricao da resposta */
	public ResponseEntity<?> atualizar(@RequestBody Pessoa pessoa) { /* Recebe os dados para salvar */
		
		if (pessoa.getId() == null) {
			return new ResponseEntity<String>("Id não foi informado para atualização.", HttpStatus.OK);
		}

		Pessoa user = pessoaRepository.saveAndFlush(pessoa);

		return new ResponseEntity<Pessoa>(user, HttpStatus.OK);

	}
	
	
	
	@DeleteMapping(value = "delete") /* mapeia a url */
	@ResponseBody /* Descricao da resposta */
	public ResponseEntity<String> delete(@RequestParam Long iduser) { /* Recebe os dados para delete */

		pessoaRepository.deleteById(iduser);

		return new ResponseEntity<String>("User deletado com sucesso", HttpStatus.OK);

	}
	
	
	
	@GetMapping(value = "buscaruserid") /* mapeia a url */
	@ResponseBody /* Descricao da resposta */
	public ResponseEntity<Pessoa> buscaruserid(@RequestParam(name = "iduser") Long iduser) { /* Recebe os dados para consultar */

		Pessoa pessoa = pessoaRepository.findById(iduser).get();

		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);

	}
	
	
	
	
	@GetMapping(value = "buscarPorNome") /* mapeia a url */
	@ResponseBody /* Descricao da resposta */
	public ResponseEntity<List<Pessoa>> buscarPorNome(@RequestParam(name = "name") String name){ /* Recebe os dados para consultar */

	List<Pessoa> usuario = pessoaRepository.buscarPorNome(name.trim().toUpperCase());

		return new ResponseEntity<List<Pessoa>>(usuario, HttpStatus.OK);

	}}
	
	
	
		


