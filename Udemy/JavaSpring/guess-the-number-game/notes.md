# Spring

### Spring container and beans
- A Spring container gets your POJOs (plain old java objects) and metadata about it (bean declaration), instantiates them and makes the application ready for use
- Beans are a way to tell Spring that they should instantiate and manage the marked objects for us
- The Spring beans metadata can be declared in two ways: in a xml or through annotations
  - XML: create a beans.xml file with all configs and specify it on container startup
  - Annotation: annotate beans, etc directly on their code (more concise, but harder to understand)
- Using the @Configuration annotation is a way to get the best of both worlds

### Dependency injection
- When you create a class/bean, some of its fields may have other classes that you own declared as fields, which must be instantiated
- Instead of creating a random instance, you should use the bean that's already been instantiated by Spring and lives in the context

- Example: if you have a NumberGenerator bean and a Game bean which has a numberGenerator field, you should have the NumberGenerator bean injected into the Game field on game bean initialization


- Spring has a dependency injection feature, where you can inject instantiated beans inside other ones, and you can define the order of starting beans
- There are two ways to do dependency injection
  - Constructor-based: add a constructor to the bean that will receive the dependency, and modify bean declaration
  - Setter-based: add a setter to the bean that will receive the dependency, and modify bean declaration
 
- Best practice: use constructor for mendatory dependencies (guarantees it is not null) and setter methods for optional dependencies
- The Spring team advocates constructor injection, as it enables application components as immutable objects and ensure dependencies are not null

### Using bean lifecycle callbacks
- Sometimes you want to have a method called automatically on bean startup (reset in this case)
- There are three ways to do that:
  - Add "init-method" to the bean definition
  - Add "default-init-method" to the beans definition
  - Use annotation:
    - Add a bean class="org.springframework.context.annotation.CommonAnnotationBeanPostProcessor
    - Add the annotation dependency
    - Add the @PostConstruct annotation to the method to be called on initialization


### Autowired annotation

- How to use Autowired (and other) annotations:
  - Add "xmlns:context="http://www.springframework.org/schema/context" in the beans config file
  - Add two schemaLocation (see beans.xml file)
  - Remove any properties or constructor-arg from the beans we want to use autowired inside
  - Add the @Autowired annotation, inside the class, in the component you want to inject
- After doing that, Spring will map and process all annotations in your code (even the @PostConstruct and @PreDestroy we've inserted before) and do stuff with what was annotated according to the annotation

- The @Autowired annotation can be used with construction, setter and fields (here we are using in a field)
- You could add this annotation to parameters of a constructor or setter method
- It is recommended by the Spring team (and best practice) to use constructor injection to guarantee immutable components

### Beans as components
- Spring provides several stereotype annotations such as @Component, @Service and @Controller
- Stereotype annotations are markers for any class that fulfills a role within an application. This cuts down greatly on the need to use Spring XML based configuration
  - @Component is a generic stereotype for any Spring-managed component
  - @Repository, @Service and @Controller are specializations of @Component for more specific use cases

### Annotation configuration
- We can have a class in our project that will represent the Spring configuration
- With this, we can delete the beans.xml file
- This config class needs to have the @Configuration annotation, which is also a component (candidate for component auto-scanning)
- To re-enable component auto-scanning (which was configured in the xml), we also need to add the @ComponentScan(basePackages = "org.example") annotation to this config class

- @ComponentScan and @Component annotations auto-finds and create the beans. Another option is to manually create the beans in the Config file with the @Bean annotation
- @Bean is an annotation applied to methods. It indicates that the method returns a bean to be managed by the Spring container. The name of the bean is the same of the name of the method

Why would we use @Bean methods to create beans, instead of the more practical component auto scanning?
- Bean methods are useful when we need some additional configuration for a bean

### Application events
- You can make a component listen to an event and execute code when it receives. There are two ways:
  - Class implements ApplicationListener<ContextRefreshedEvent> and overrides method onApplicationEvent
  - A method with the annotation EventListener receives ContextRefreshedEvent event as a parameter