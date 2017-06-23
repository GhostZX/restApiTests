package Core;

import org.junit.jupiter.api.BeforeAll;

import java.util.HashMap;
import java.util.Map;

public class TestBase {
    protected final String BASE_SEARCH_URL = "https://search-02.russianplace.com/app_dev.php/api/search/v1/json/";
    protected final String EMAIL = "probe@grr.la";
    protected final String PASSWORD = "1234567";
    protected final String CHANGED_PASSWORD = "cpassword";
    protected final String USER_ID = "13079";
    protected final String USER_TOKEN = "590307db9d004205039a088a";
    protected final String USER_WALL_ID = "9027678f31363235f4e1812aa1ea70be";
    protected final String USER_PLACE = "6987";
    protected final String CITY_ID = "1686293227";
    protected final String CITY_NAME = "Moscow";
    protected final String CITY_LAT = "55.7516147";
    protected final String CITY_LON = "37.6187012";
    protected final String DEFAULT_RADIUS = "10000";
    protected final String DEFALUT_COUNT = "1";

    protected final String RP_USER_ID = "";
    protected final String RP_USER_WALL_ID = "";
    protected final String RP_USER_EMAIL = "";
    protected final String TEST_PROJECT_URL = "https://dev.russianplace.com/api/";

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
