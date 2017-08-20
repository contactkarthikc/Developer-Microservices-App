package com.techartifact;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    DeveloperRepository developerRepository;

    @Autowired
    SkillRepository skillRepository;
     public static final Optional<String> host;
    public static final Optional<String> port;
    public static final Properties myProps = new Properties();

    static {
        host = Optional.ofNullable(System.getenv("HOSTNAME"));
        port = Optional.ofNullable(System.getenv("PORT"));
    }

	public static void main(String[] args) {
             myProps.setProperty("server.address", host.orElse("localhost"));
        myProps.setProperty("server.port", port.orElse("8080"));

        SpringApplication app = new SpringApplication(Application.class);
       app.setDefaultProperties(myProps);
        app.run(args);
  
    }

	@Override
	public void run(String... args) throws Exception {
		Skill javascript = new Skill("javascript", "Javascript language skill");
		Skill jet = new Skill("OracleJET", "Oracle JET skill");
		Skill ADF = new Skill("OracleADF", "ADF framework");
		Skill spring = new Skill("Spring", "Spring framework");
                Skill java = new Skill("javat", "Java 9 skill");
		Skill jee = new Skill("JEE", "Java Enterprise edition");
		Skill es = new Skill("ElasticSearch", "Elastic Search");
		Skill kafka = new Skill("kafka", "Kafka framework");
                
                skillRepository.save(kafka);
		skillRepository.save(es);
		skillRepository.save(java);
		skillRepository.save(jee);
		skillRepository.save(javascript);
		skillRepository.save(jet);
		skillRepository.save(spring);
		skillRepository.save(ADF);
                

		List<Developer> developers = new LinkedList<Developer>();
		developers.add(new Developer("Vinay", "kumar", "mail2vinayku@example.com", 
				Arrays.asList(new Skill[] { javascript, jet,spring,ADF,java,jee,es,kafka })));
		developers.add(new Developer("Tim", "Edle", "mjohnson@example.com", 
				Arrays.asList(new Skill[] { javascript, jet })));
		developers.add(new Developer("Michael", "brock", "michael.williams@example.com", 
				Arrays.asList(new Skill[] { jee})));
		developerRepository.save(developers);
	}

}
