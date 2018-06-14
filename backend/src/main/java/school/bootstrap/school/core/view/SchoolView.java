package school.bootstrap.school.core.view;

        import io.dropwizard.views.View;
        import lombok.Getter;


@Getter
public class SchoolView extends View {
   // private final Planner planner;

    public SchoolView() {
        super("/school-ui/school.ftl");
       // this.planner = plan1;
    }
}
