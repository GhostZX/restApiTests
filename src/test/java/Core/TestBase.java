package Core;

import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;

public class TestBase {
    protected final String BASE_SEARCH_URL = "";
    protected final String EMAIL = "";
    protected final String PASSWORD = "password";
    protected final String CHANGED_PASSWORD = "cpassword";
    protected final String USER_ID = "";
    protected final String USER_TOKEN = "";
    protected final String USER_WALL_ID = "";
    protected final String USER_PLACE = "";
    protected final String CITY_ID = "";
    protected final String CITY_NAME = "";
    protected final String CITY_LAT = "";
    protected final String CITY_LON = "";
    protected final String DEFAULT_RADIUS = "";
    protected final String DEFALUT_COUNT = "";

    protected final String RP_USER_ID = "";
    protected final String RP_USER_WALL_ID = "";
    protected final String RP_USER_EMAIL = "";
    protected final String TEST_PROJECT_URL = "";

    protected String tokenId;

    protected Core.RandomGenerated generated = new Core.RandomGenerated();
    protected Core.RandomGeneratedGender generatedGender = new Core.RandomGeneratedGender();

    /*static  {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }*/


    protected Map<String, Object> jsonBody = new HashMap<>();
    protected Map<String, Object> jsonLogin = new HashMap<>();
    protected Map<String, Object> jsonChangePassword = new HashMap<>();
    protected Map<String, Object> jsonChangePasswordCheck = new HashMap<>();
    protected Map<String, Object> jsonEditCheck = new HashMap<>();
    protected Map<String, Object> jsonDeleteUserBody = new HashMap<>();

    @BeforeAll
    static void beforeAllTests() {

    }

}
