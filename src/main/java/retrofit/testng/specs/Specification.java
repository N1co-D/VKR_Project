package retrofit.testng.specs;

import retrofit2.Response;

public class Specification {
    public static boolean isResponseSuccessful(Response<?> response) {
        return response.isSuccessful() && response.code() == 200;
    }
}