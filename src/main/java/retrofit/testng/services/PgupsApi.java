package retrofit.testng.services;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface PgupsApi {
    @GET
    Call<ResponseBody> openSchedule(@Url String url);

    @GET
    Call<ResponseBody> searchByGroup(@Url String url, @Query("group") int group);

    @GET
    Call<ResponseBody> openGroupSchedule(@Url String url);

    @GET
    Call<ResponseBody> openDormitories(@Url String url);

    @GET
    Call<ResponseBody> openFirstDormitory(@Url String url);

    @GET
    Call<ResponseBody> openPriemPgups(@Url String url);

    @GET
    Call<ResponseBody> openPriemPlan(@Url String url);

    @GET
    Call<ResponseBody> priemPlan2024file(@Url String url);

    @GET
    Call<ResponseBody> openEducation(@Url String url);

    @GET
    Call<ResponseBody> ismPlanFile(@Url String url);

    @GET
    Call<ResponseBody> openFacultyContacts(@Url String url);

    @GET
    Call<ResponseBody> openAitFaculty(@Url String url);

    @GET
    Call<ResponseBody> openPrioritet2030(@Url String url);

    @GET
    Call<ResponseBody> openDigitalDepartament(@Url String url);

    @GET
    Call<ResponseBody> openScientificConference(@Url String url);

    @GET
    Call<ResponseBody> ScientificPlanFile(@Url String url);

    @GET
    Call<ResponseBody> openMagistracySection(@Url String url);

    @GET
    Call<ResponseBody> MagistracyEducationCostFile(@Url String url);

    @GET
    Call<ResponseBody> openPgupsMuseum(@Url String url);

    @GET
    Call<ResponseBody> pgupsMuseumZayavkaFile(@Url String url);

    @GET
    Call<ResponseBody> openPish(@Url String url);

    @GET
    Call<ResponseBody> openPishAsProgram(@Url String url);
}