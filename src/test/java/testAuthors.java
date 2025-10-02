import org.Authors.Authors;
import org.Endpoints.Endpoints;
import org.Utils.FakerDataUtil;
import org.Utils.RestUtils;
import org.Utils.TimeUtil;
import org.testng.annotations.Test;

public class testAuthors {

    private final int generatedID = FakerDataUtil.generateId();
    private final int generatedIdBook = FakerDataUtil.generateId();

    @Test(description = "Tests GET request for Authors", priority = 1)
    public void GET() {
        RestUtils.performGet(Endpoints.GET_AUTHORS, 200);
    }

    @Test(description = "Tests POST request for Authors", priority = 2)
    public void POST() {
        RestUtils.performPost(
                Endpoints.POST_AUTHORS,
                Authors.updateAndReturnMap(generatedID, generatedIdBook, FakerDataUtil.generateFirstName(), FakerDataUtil.generateLastName()),
                200
        );
    }

    @Test(description = "Tests GET request with id for Authors", priority = 3)
    public void GET_ID() {
        RestUtils.performGetWithId(Endpoints.GET_SPECIFIC_AUTHOR, 201, generatedID);
    }

    @Test(description = "Tests PUT request for Authors", priority = 4)
    public void PUT() {
        RestUtils.performPut(
                Endpoints.PUT_SPECIFIC_AUTHOR,
                Authors.updateAndReturnMap(generatedID, generatedIdBook, FakerDataUtil.generateFirstName(), FakerDataUtil.generateLastName()),
                generatedIdBook, 200);
    }

    @Test(description = "Tests DELETE request for Authors", priority = 5)
    public void DELETE() {
        RestUtils.performDelete(
                Endpoints.DELETE_SPECIFIC_AUTHOR,
                generatedID,
                200);
    }
}