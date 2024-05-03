package retrofit.junit;

import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit.junit.services.Constants;
import retrofit.junit.services.PgupsApi;
import retrofit.junit.specs.Specification;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PgupsRFJunitAllTest {
    private PgupsApi pgupsApi;

    @BeforeEach
    public void setUp() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.pgups.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pgupsApi = retrofit.create(PgupsApi.class);
    }

    @Test
    public void openSchedule() throws IOException {
        Response<ResponseBody> response = pgupsApi.openSchedule(Constants.SCHEDULE_PAGE).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void searchByGroup() throws IOException {
        Response<ResponseBody> response = pgupsApi.searchByGroup(Constants.GROUP_SEARCH, 310).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void openGroupSchedule() throws IOException {
        Response<ResponseBody> response = pgupsApi.openGroupSchedule(Constants.ISM310_SCHEDULE).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void openDormitories() throws IOException {
        Response<ResponseBody> response = pgupsApi.openDormitories(Constants.DORMITORIES).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void openFirstDormitory() throws IOException {
        Response<ResponseBody> response = pgupsApi.openFirstDormitory(Constants.FIRST_DORMITORY).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void openPriemPgups() throws IOException {
        Response<ResponseBody> response = pgupsApi.openPriemPgups(Constants.PRIEM_PGUPS).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void openPriemPlan() throws IOException {
        Response<ResponseBody> response = pgupsApi.openPriemPlan(Constants.PRIEM_PLAN).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void priemPlan2024file() throws IOException {
        Response<ResponseBody> response = pgupsApi.priemPlan2024file(Constants.PRIEM_PLAN_2024).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void openEducation() throws IOException {
        Response<ResponseBody> response = pgupsApi.openEducation(Constants.EDUCATION).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void ismPlanFile() throws IOException {
        Response<ResponseBody> response = pgupsApi.ismPlanFile(Constants.ISM_PLAN).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void openFacultyContacts() throws IOException {
        Response<ResponseBody> response = pgupsApi.openFacultyContacts(Constants.FACULTY_CONTACTS).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void openAitFaculty() throws IOException {
        Response<ResponseBody> response = pgupsApi.openAitFaculty(Constants.AIT_FACULTY).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void openPrioritet2030() throws IOException {
        Response<ResponseBody> response = pgupsApi.openPrioritet2030(Constants.PRIORITET).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void openDigitalDepartament() throws IOException {
        Response<ResponseBody> response = pgupsApi.openDigitalDepartament(Constants.DIGITAL_DEPARTAMWNT).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void openScientificConference() throws IOException {
        Response<ResponseBody> response = pgupsApi.openScientificConference(Constants.SCIENTIFIC_CONFERENCE).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void ScientificPlanFile() throws IOException {
        Response<ResponseBody> response = pgupsApi.ScientificPlanFile(Constants.SCIENTIFIC_PLAN).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void openMagistracySection() throws IOException {
        Response<ResponseBody> response = pgupsApi.openMagistracySection(Constants.PRIEM_MAGISTRACY).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void MagistracyEducationCostFile() throws IOException {
        Response<ResponseBody> response = pgupsApi.MagistracyEducationCostFile(Constants.PRIEM_MAGISTRACY_COST).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void openPgupsMuseum() throws IOException {
        Response<ResponseBody> response = pgupsApi.openPgupsMuseum(Constants.PGUPS_MUSEUM).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void pgupsMuseumZayavkaFile() throws IOException {
        Response<ResponseBody> response = pgupsApi.pgupsMuseumZayavkaFile(Constants.PGUPS_MUSEUM_ZAYAVKA).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void openPish() throws IOException {
        Response<ResponseBody> response = pgupsApi.openPish(Constants.PISH).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }

    @Test
    public void openPishAsProgram() throws IOException {
        Response<ResponseBody> response = pgupsApi.openPishAsProgram(Constants.PISH_AS_PROGRAM).execute();
        assertTrue(Specification.isResponseSuccessful(response));
    }
}