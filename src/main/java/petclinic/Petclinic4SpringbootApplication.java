package petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.fasterxml.jackson.databind.ObjectMapper;

import petclinic.model.Vets;

@SpringBootApplication
@EnableCaching
public class Petclinic4SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(Petclinic4SpringbootApplication.class, args);
	}

	@Bean(name = "vets/vetList.xml")
	@Description("Renders an XML view. Used by the BeanNameViewResolver")
	public MarshallingView marshallingView() {
		return new MarshallingView(marshaller());
	}

	@Bean(name = "vets/vetList.json")
	@Description("Renders a JSON view. Used by the BeanNameViewResolver")
	public MappingJackson2JsonView jsonView(ObjectMapper objectMapper) {
		return new MappingJackson2JsonView(objectMapper);
	}

	@Bean
	@Description("Object-XML mapping declared using annotations inside 'Vets'")
	public Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Vets.class);
		return marshaller;
	}

}
