package br.com.devmedia.curso.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/*
 * a anotação @Configuration, diz ao spring que essa é uma classe de 
 * configuração. 
 * 
 * a anotação @ComponentScan, diz ao spring onde está as classe que ele
 * vai gerenciar. Aqui, tudo dentro do pacote br.com.devmedia.curso
 * será scanneado.
 * 
 * a anotação @EnableWebMvc informa ao string que queremos usar o MVC.
 */


@Configuration
@ComponentScan("br.com.devmedia.curso")
@EnableWebMvc
public class RootConfig {

}
