package webapp;

import static org.junit.Assert.*;

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

	static Log log = LogFactory.getLog(Properties.class);

	@Test
	public void test1() throws IOException {

		ClassPathResource resource = new ClassPathResource(
				"/message.properties");
		Properties prop = new Properties();
		prop.load(resource.getInputStream());
		String value1 = prop.getProperty("required");
		String value2 = prop.getProperty("typeMismatch");
		String value3 = prop.getProperty("required.dept");
		log.info("value1 = " + value1);
		log.info("value2 = " + value2);
		log.info("value3 = " + value3);
	}

	@Test
	public void test2() {
		ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
		ms.setBasename("classpath:/message");
		String msg1 = ms.getMessage("required", null, null);
		log.info(msg1);
		String msg2 = ms.getMessage("required", null, Locale.JAPANESE);
		log.info(msg2);
	}

	@Test
	public void test3() {
		Locale[] locales = Locale.getAvailableLocales();
		for (Locale l : locales) {
			log.info(l.getDisplayLanguage(Locale.KOREAN) + "("
					+ l.getDisplayLanguage(Locale.ENGLISH) + ")" + " : "
					+ l.getLanguage());
		}
	}
}
