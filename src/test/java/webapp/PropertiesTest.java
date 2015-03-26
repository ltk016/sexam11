package webapp;

import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PropertiesTest {

	static Log log = LogFactory.getLog(PropertiesTest.class);
	@Test
	public void test1() throws IOException {
		
		ClassPathResource resource = new ClassPathResource("/message.properties");
		
		Properties prop = new Properties();
		prop.load(resource.getInputStream());
		
		String value = prop.getProperty("required");
		log.info("value = " + value);
		
		log.info(prop.getProperty("typeMismatch"));
		log.info(prop.getProperty("required.dept"));
	}
	
	@Test
	public void test2() throws IOException {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		
		ms.setBasenames("classpath:/message");
		
		String mess1 = ms.getMessage("required", null, null);
		log.info(mess1);
		
//		Locale.setDefault(Locale.ITALIAN);
		
		String mess2 = ms.getMessage("required", null, Locale.JAPANESE);
		log.info(mess2);
	}
	
	@Test
	public void test3() throws IOException {
		String[] langs = Locale.getISOLanguages();
		
		for (String s : langs) 
			log.info(s);
	}
	@Test
	public void test4() throws IOException {
		Locale[] locales = Locale.getAvailableLocales();
		
		for (Locale l : locales) {
			log.info(l.getDisplayLanguage() + " : " + l.getLanguage());
		}
		
		
	}
	
	
	
	
	
}
