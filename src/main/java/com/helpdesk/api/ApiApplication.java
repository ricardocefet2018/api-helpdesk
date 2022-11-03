package com.helpdesk.api;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.helpdesk.api.model.Atividade;
import com.helpdesk.api.model.Categoria;
import com.helpdesk.api.model.Usuario;
import com.helpdesk.api.repository.AtividadeRepository;
import com.helpdesk.api.repository.CategoriaRepository;
import com.helpdesk.api.repository.UsuarioRepository;

@SpringBootApplication
public class ApiApplication implements ApplicationRunner {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	AtividadeRepository atividadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Usuario u1 = new Usuario("Aline", "aline@teste.com", "testuser", "testuser");
		Usuario u2 = new Usuario("Ricardo", "ricardo@teste.com", "usertest", "usertest");
		u1 = usuarioRepository.save(u1);
		u2 = usuarioRepository.save(u2);
		System.out.println(u1);
		System.out.println(u2);

		Categoria prova = new Categoria("Prova", u1);
		Categoria trabalho = new Categoria("Trabalho", u1);
		Categoria tarefa = new Categoria("Tarefa", u2);

		prova = categoriaRepository.save(prova);
		trabalho = categoriaRepository.save(trabalho);
		tarefa = categoriaRepository.save(tarefa);
		System.out.println(prova);
		System.out.println(trabalho);
		System.out.println(tarefa);

		Atividade atvProvaSegundaGuerra = new Atividade("Segunda guerra", Instant.parse("2022-12-01T08:55:00Z"),
				Instant.parse("2022-12-01T10:35:00Z"), prova, u1);
		Atividade atvTrabalhoMatematica = new Atividade("Geometria analítica", Instant.now(),
				Instant.parse("2022-11-01T10:35:00Z"), trabalho, u1);
		Atividade tarefaFisica = new Atividade("lista de relatividade", Instant.now(),
				Instant.parse("2022-11-01T08:55:00Z"), tarefa, u1);
		Atividade atvProvaSegundaGuerraU2 = new Atividade("Segunda guerra", Instant.parse("2022-12-01T08:55:00Z"),
				Instant.parse("2022-12-01T10:35:00Z"), prova, u2);
		Atividade atvTrabalhoMatematicaU2 = new Atividade("Geometria analítica", Instant.now(),
				Instant.parse("2022-11-01T10:35:00Z"), trabalho, u2);
		Atividade tarefaFisicaU2 = new Atividade("lista de relatividade", Instant.now(),
				Instant.parse("2022-11-01T08:55:00Z"), tarefa, u2);
		atvProvaSegundaGuerra = atividadeRepository.save(atvProvaSegundaGuerra);
		atvTrabalhoMatematica = atividadeRepository.save(atvTrabalhoMatematica);
		tarefaFisica = atividadeRepository.save(tarefaFisica);
		atvProvaSegundaGuerraU2 = atividadeRepository.save(atvProvaSegundaGuerraU2);
		atvTrabalhoMatematicaU2 = atividadeRepository.save(atvTrabalhoMatematicaU2);
		tarefaFisicaU2 = atividadeRepository.save(tarefaFisicaU2);
		System.out.println(atvProvaSegundaGuerra);
		System.out.println(atvTrabalhoMatematica);
		System.out.println(tarefaFisica);
		System.out.println(atvProvaSegundaGuerraU2);
		System.out.println(atvTrabalhoMatematicaU2);
		System.out.println(tarefaFisicaU2);

		System.out.println("////////////////////////////////////");
		Optional<Usuario> u3 = usuarioRepository.findByUsernameAndSenha("usertest", "usertest");
		if (u3.isPresent()) {
			System.out.println(u3);
		}

	}
}
