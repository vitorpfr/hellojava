# Setup
- To create a web project, we need to compile it as a .war instead of a .jar
- To manage that, we need to add maven-war-plugin (to compile to .war), maven cargo plugin (to deploy tomcat container server in embedded mode) in the pom.xml
- After setup and running the 'cargo:run' task, we can access the index page with http://localhost:8080/todo-list/index.html

# MVC
- A DispatcherServlet object is responsible for handling all the request processing and orchestrating (mapping the correct controller to process it, the correct view to return, etc)

## Controller
- The Dispatcher Servlet plays the role of Front Controller - it receives all the requests for your application
- We can map requests to methods in classes annotated with @Controller. Those classes are known as annotated controllers or controller classes
- Controller classes have methods with @RequestMapping annotations, which will be scanned and will receive requests

## View
- Spring MVC defines ViewResolver and View interfaces, which enables us to render models in a browser without forcing us to use specific view technology - ViewResolver provides mapping between view names and actual views
- For example, we can use JSP (Java Server Pages), Thymeleaf, Freemarker, etc
- For this project, the ViewResolver is defined inside the WebConfig file as a bean, which receives requests processed by the controller
- This project will use JSP as the view return, but later on we'll move to thymeleaf

## Model
- Represents data passed from the controller method to the view, or from the view to the controller (in case of forms)
- Models can be thought as key-value pairs (map), those are the "attributes"
- The controller handler receives the model object and can call .addAttribute(k, v) and .getAttribute(k) on it
- Another way to add an attribute to the model is to create a method and annotate it with @ModelAttribute("attrName")
- Attributes can be used in the view files, e.g. ${user}