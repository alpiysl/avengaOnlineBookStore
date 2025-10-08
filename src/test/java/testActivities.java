import org.Activities.Activities;
import org.Endpoints.Endpoints;
import org.Utils.FakerDataUtil;
import org.Utils.RestUtils;
import org.Utils.TimeUtil;
import org.testng.annotations.Test;

import java.util.Map;

public class testActivities {

    private final int generatedID = FakerDataUtil.generateId();

    @Test(description = "Tests GET request for Activities", priority = 1)
    public void GET() {
        RestUtils.performGet(Endpoints.GET_ACTIVITIES, 200);
    }

    @Test(description = "Tests POST request for Activities", priority = 2)
    public void POST() {
        RestUtils.performPost(
                Endpoints.POST_ACTIVITIES,
                Activities.updateAndReturnMap(generatedID, FakerDataUtil.generateTitle(), TimeUtil.getCurrentIsoTime(),
                        FakerDataUtil.generateBool()),
                200);
    }

    @Test(description = "Tests GET request with id for Activities", priority = 3)
    public void GET_ID() {
        RestUtils.performGetWithId(Endpoints.GET_SPECIFIC_ACTIVITY, 200, generatedID);
    }

    @Test(description = "Tests PUT request for Activities", priority = 4)
    public void PUT() {
        RestUtils.performPut(
                Endpoints.PUT_SPECIFIC_ACTIVITY,
                Activities.updateAndReturnMap(generatedID, FakerDataUtil.generateTitle(), TimeUtil.getCurrentIsoTime(),
                        FakerDataUtil.generateBool()),
                generatedID, 200);
    }

    @Test(description = "Tests DELETE request for Activities", priority = 5)
    public void DELETE() {
        RestUtils.performDelete(
                Endpoints.DELETE_SPECIFIC_ACTIVITY,
                generatedID,
                200);
    }
}