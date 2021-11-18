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