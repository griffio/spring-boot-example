package griffio;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@RequestMapping
public class Main extends WebMvcConfigurerAdapter implements EmbeddedServletContainerCustomizer {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Main.class, args);
  }

  @Override public void customize(ConfigurableEmbeddedServletContainer container) {
    container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
    container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html"));
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    super.addViewControllers(registry);
    registry.addStatusController("/status", HttpStatus.OK);
  }
}
