import lk.ijse.dep.dao.custom.CustomerDAO;
import lk.ijse.dep.entity.Customer;
import lk.ijse.dep.main.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.registerShutdownHook();
        ctx.refresh();
        CustomerDAO dao=ctx.getBean(CustomerDAO.class);
        List<Customer> customQuery=dao.customQuery("A","K");
        for (Customer customer:customQuery) {
            System.out.println(customer);
        }
    }
}
