import io.restassured.response.Response;
import org.Endpoints.Endpoints;
import org.Endpoints.RequestTypes;
import org.Utils.RestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testAuthors {

    @Test
    public void test1(){
        RestUtils.performGet(Endpoints.GET_ACTIVITIES, RequestTypes.GET.value,200);
    }
}
