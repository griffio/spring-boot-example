# spring-boot-example
Spring boot 1.3.2.RELEASE
Spring web mvc

~~~
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
~~~