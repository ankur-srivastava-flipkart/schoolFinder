package school.bootstrap.resource;

import io.swagger.annotations.Api;
import school.bootstrap.school.core.view.SchoolView;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/school")
@Singleton
@Api(value = "School Finder")
public class SchoolResource {
    @GET
    public SchoolView getQuarterPlan() {
        return new SchoolView();
    }

}
