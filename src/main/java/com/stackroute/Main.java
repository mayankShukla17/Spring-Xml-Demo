package com.stackroute;
/*1. Task 1:

Create a Maven project and add required dependency of spring-context 5.1.4.RELEASE Create a Main class in package com.stackroute and two Spring Beans – Movie, and Actor 
in package com.stackroute.domain. Actor has two String properties, name and gender, and an age property of type int. An Actor can be initialized with the three properties 
via the corresponding setter methods. Use property based injection in the bean definition file (beans.xml) Movie “has a” Actor that can be initialized via the corresponding 
setter method. Use property based object injection in the bean definition file (beans.xml) The Main class looks up Movie bean via three ways to print out actor information:

	1. Using XmlBeanFactory
	2. Using Spring 3.2 BeanDefinitionRegistry and BeanDefinitionReader
	3. Using ApplicationContext Create a spring-xml-demo repo and push the code to master branch.
*/

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.stackroute.domain.Movie;
public class Main {
	public static void main(String[] args) {

		// Using XMLBeanFactory
		XmlBeanFactory xmlBeanFactory= new XmlBeanFactory ( new ClassPathResource("beans.xml"));
		Movie movie1 = xmlBeanFactory.getBean("movie1",Movie.class);

		//Using BeanDefinitionRegistry and BeanDefinitionReader
		//BeanDefinitionRegistry beanDefinitionRegistry= new BeanDefinitionReader("beans.xml");


		// Using ApplicationContext
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		Movie movie2 = applicationContext.getBean("movie2",Movie.class);

		System.out.println(movie1.getActor());

		System.out.println(movie2.getActor());
	}
}
