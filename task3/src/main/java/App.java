import domain.BeanA;
import domain.BeanB;
import domain.BeanC;
import domain.BeanE;
import domain.BeanF;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  public static void main(String[] args) {
    AbstractApplicationContext context =
        new ClassPathXmlApplicationContext("config.xml");

    System.out.println(context.getBean("beanA", BeanA.class));
    System.out.println(context.getBean("beanB", BeanB.class));

    BeanC beanC = context.getBean("beanC", BeanC.class);
    System.out.println(beanC);

    System.out.println(beanC.getBeanD());
    System.out.println(beanC.getBeanD());

    BeanE beanE = context.getBean("beanE", BeanE.class);
    System.out.println(beanE);
    beanE.printer();


    BeanF beanF = context.getBean("beanF", BeanF.class);
    System.out.println(beanF);
    context.registerShutdownHook();
  }
}
