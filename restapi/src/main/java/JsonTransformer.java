/**
 * zero-project
 * PACKAGE_NAME
 * Create by winadmin in 26/1/2018.
 * Description:
 */
import com.google.gson.Gson;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

    private Gson gson = new Gson();

    @Override
    public String render(Object model) {
        return gson.toJson(model);
    }

}