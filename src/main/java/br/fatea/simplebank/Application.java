package br.fatea.simplebank;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Application implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = buildApplicationContext();
		
		Dynamic appServlet = servletContext.addServlet("appServlet", new DispatcherServlet(applicationContext));
		//Deve passar o applicationContext para o servlet, caso contrário ele irá procurar o XML referente ao contexto, recebendo o erro:
		//Could not open ServletContext resource [/WEB-INF/appServlet-servlet.xml]

		appServlet.setLoadOnStartup(1);
		appServlet.addMapping("/");
		
		FilterRegistration.Dynamic filter = servletContext.addFilter("openEntityManagerInViewFilter", buildOpenEntityManagerFilter());
		filter.addMappingForUrlPatterns(getDispatcherTypes(), false, "/");
		
		servletContext.addListener(new ContextLoaderListener(applicationContext));
	}
	
	private OpenEntityManagerInViewFilter buildOpenEntityManagerFilter() {
		OpenEntityManagerInViewFilter openEntityManagerInViewFilter = new OpenEntityManagerInViewFilter();
		openEntityManagerInViewFilter.setEntityManagerFactoryBeanName("entityManagerFactory");
		return openEntityManagerInViewFilter;
	}

	private EnumSet<DispatcherType> getDispatcherTypes() {
		return EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.INCLUDE, DispatcherType.ASYNC);
	}

	private AnnotationConfigWebApplicationContext buildApplicationContext() {
		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.setConfigLocation("br.fatea.simplebank.config");
		return webApplicationContext;
	}
	
}
