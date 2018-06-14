package school.bootstrap;

import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import io.swagger.config.ScannerFactory;
import io.swagger.jaxrs.config.DefaultJaxrsScanner;

public class SchoolFinderApplication extends Application<SchoolFinderConfiguration> {
    public static void main(String[] args) throws Exception {
        try {
            new school.bootstrap.SchoolFinderApplication().run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getName() {
        return "Planner";
    }

//    private final HibernateBundle<SchoolFinderConfiguration> hibernateBundle
//            = new HibernateBundle<SchoolFinderConfiguration>(Person.class, Team.class, Okr.class, Week.class, PersonWeek.class, Plan.class, OkrAllocation.class) {
//        @Override
//        public DataSourceFactory getDataSourceFactory(
//                PlannerConfiguration configuration
//        ) {
//            return configuration.getDataSourceFactory();
//        }
//    };

    @Override
    public void initialize(Bootstrap<SchoolFinderConfiguration> bootstrap) {
        GuiceBundle<SchoolFinderConfiguration> guiceBundle = GuiceBundle.<SchoolFinderConfiguration>newBuilder()
                .setConfigClass(SchoolFinderConfiguration.class)
                .addModule(new SchoolFinderModule())
                .enableAutoConfig("school")
                .build();

        bootstrap.addBundle(guiceBundle);

//        bootstrap.addBundle(new MigrationsBundle<PlannerConfiguration>() {
//            @Override
//            public DataSourceFactory getDataSourceFactory(PlannerConfiguration configuration) {
//                return configuration.getDataSourceFactory();
//            }
//        });

      //  bootstrap.addBundle(new AssetsBundle("/swagger-ui", "/swagger-ui", "index.html","swaggerui"));
        bootstrap.addBundle(new AssetsBundle("/school-ui", "/school-ui", "index.html", "plannerui"));

      //  bootstrap.addBundle(hibernateBundle);

        bootstrap.addBundle(new ViewBundle());

        bootstrap.getObjectMapper().registerModule(new JodaModule());
    }

    @Override
    public void run(SchoolFinderConfiguration configuration, Environment environment) {
//        environment.jersey().register(ApiListingResourceJSON.class);
//        environment.jersey().register(SwaggerSerializers.class);
        ScannerFactory.setScanner(new DefaultJaxrsScanner());

        environment.getObjectMapper().registerModule(new JodaModule());
        environment.getObjectMapper().configure(com.fasterxml.jackson.databind.SerializationFeature.
                WRITE_DATES_AS_TIMESTAMPS , false);

    }
}
