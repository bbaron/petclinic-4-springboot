package petclinic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import petclinic.service.ClinicService;
import petclinic.web.PetTypeFormatter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
	@Autowired
	private ClinicService clinicService;

	@Override
	public void addFormatters(FormatterRegistry formatterRegistry) {
		formatterRegistry.addFormatter(petTypeFormatter());
	}

	@Bean
	public PetTypeFormatter petTypeFormatter() {
		return new PetTypeFormatter(clinicService);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("welcome");
		registry.addViewController("/error").setViewName("error");
	}

	/**
	 * Resolves specific types of exceptions to corresponding logical view names
	 * for error views.
	 *
	 * <p>
	 * View name resolved using bean of type InternalResourceViewResolver
	 * (declared in {@link MvcViewConfig}).
	 */
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		exceptionResolver.setDefaultErrorView("exception");
		exceptionResolver.setWarnLogCategory("warn");
		exceptionResolvers.add(exceptionResolver);
	}

}
