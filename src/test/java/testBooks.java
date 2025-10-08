import org.Authors.Authors;
import org.Books.Books;
import org.Endpoints.Endpoints;
import org.Utils.FakerDataUtil;
import org.Utils.RestUtils;
import org.Utils.TimeUtil;
import org.testng.annotations.Test;

public class testBooks {

    private final int generatedID = FakerDataUtil.generateId();
    private final int pageCount = 0;

    @Test(description = "Tests GET request for Books", priority = 1)
    public void GET() {
        RestUtils.performGet(Endpoints.GET_BOOKS, 200);
    }

    @Test(description = "Tests POST request for Books", priority = 2)
    public void POST() {
        RestUtils.performPost(
                Endpoints.POST_BOOKS,
                Books.updateAndReturnMap(generatedID,
                        FakerDataUtil.generateTitle(),
                        FakerDataUtil.generateLorem(10, 10),
                        pageCount,
                        FakerDataUtil.generateLorem(30, 10),
                        TimeUtil.getCurrentIsoTime()),
                200);
    }

    @Test(description = "Tests GET request with id for Books", priority = 3)
    public void GET_ID() {
        RestUtils.performGetWithId(Endpoints.GET_SPECIFIC_BOOK, 200, generatedID);
    }

    @Test(description = "Tests PUT request for Books", priority = 4)
    public void PUT() {
        RestUtils.performPut(
                Endpoints.PUT_SPECIFIC_BOOK,
                Books.updateAndReturnMap(generatedID,
                        FakerDataUtil.generateTitle(),
                        FakerDataUtil.generateLorem(10, 10),
                        pageCount,
                        FakerDataUtil.generateLorem(30, 10),
                        TimeUtil.getCurrentIsoTime()),
                generatedID,
                200);
    }

    @Test(description = "Tests DELETE request for Books", priority = 5)
    public void DELETE() {
        RestUtils.performDelete(
                Endpoints.DELETE_SPECIFIC_BOOK,
                generatedID,
                201); // fail status
    }
}