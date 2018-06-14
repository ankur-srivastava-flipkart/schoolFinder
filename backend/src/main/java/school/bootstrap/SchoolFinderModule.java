package school.bootstrap;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.SessionFactory;

/**
 * Created by ankur.srivastava on 26/08/17.
 */
public class SchoolFinderModule extends AbstractModule{

    // private  HibernateBundle<PlannerConfiguration> hibernateBundle;

    public SchoolFinderModule() {
        //this.hibernateBundle = hibernateBundle;
    }

    @Override
    protected void configure() {

    }

//    @Provides
//    public SessionFactory getSessionFactory() {
//        return hibernateBundle.getSessionFactory();
//    }

}
