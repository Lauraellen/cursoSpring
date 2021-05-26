package br.com.devmedia.curso.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/*
 * a anota��o @Configuration, diz ao spring que essa � uma classe de 
 * configura��o. 
 * 
 * a anota��o @ComponentScan, diz ao spring onde est� as classe que ele
 * vai gerenciar. Aqui, tudo dentro do pacote br.com.devmedia.curso
 * ser� scanneado.
 * 
 * a anota��o @EnableWebMvc informa ao string que queremos usar o MVC.
 */


@Configuration
@ComponentScan("br.com.devmedia.curso")
@EnableWebMvc
public class RootConfig {

}
