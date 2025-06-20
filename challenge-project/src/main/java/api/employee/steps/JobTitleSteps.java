//package api.employee.steps;
//
//import com.citigo.booking.api.dto.employee.models.CreateJobTitleRequest;
//import com.citigo.booking.api.dto.employee.models.JobTitle;
//import com.citigo.booking.api.dto.employee.models.ListJobTitleResponse;
//import com.citigo.booking.core.Base;
//import com.citigo.booking.helper.GlobalParamGherkin;
//import com.citigo.booking.helper.GlobalVariables;
//import com.citigo.booking.helper.RequestSpec;
//import io.restassured.response.Response;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//public class JobTitleSteps extends Base {
//    public List<JobTitle> getJobTitle() {
//        setUriToTimesheetHost();
//
//        setReqSpec(RequestSpec.baseHeader());
//        Response response = sendGetTimeSheet(GlobalVariables.JOB_TITLE_EMPLOYEE_PATH);
//        ListJobTitleResponse listJobTitleResponse = convertJsonResponseToJavaObject(response, ListJobTitleResponse.class);
//        setUriToHost();
//        return listJobTitleResponse.getResult().getData();
//    }
//
//    public String getJobTitleIdByName(String name) {
//        getJobTitle();
//        List<String> listJobTitle = convertStringToListString(getJsonValue("result.data.name"));
//        int index = listJobTitle.indexOf(name);
//        return index < 0 ? null : getJsonValue("result.data[" + index + "].id");
//    }
//
//    public JobTitle getJobTitleByName(String name) {
//        return getJobTitle().stream().filter(jobTitle -> jobTitle.getName().equals(name)).findFirst().orElse(new JobTitle());
//    }
//
//    public List<Long> getIdsByNames(String[] names) {
//        List<Long> jobTitleIds = new ArrayList<>();
//        for (String name : names) {
//            jobTitleIds.add(getJobTitleByName(name).getId());
//        }
//        return jobTitleIds;
//    }
//
//    public void createJobTitle(Map<String, String> data) {
//        setUriToTimesheetHost();
//
//        setReqSpec(RequestSpec.baseHeader());
//        JobTitle jobTitle = new JobTitle();
//        if (isContainsKeyAndNotNull(data, GlobalParamGherkin.NAME)) {
//            jobTitle.setName(data.get(GlobalParamGherkin.NAME));
//        }
//        if (isContainsKeyAndNotNull(data, GlobalParamGherkin.DESCRIPTION)) {
//            jobTitle.setDescription(data.get(GlobalParamGherkin.DESCRIPTION));
//        }
//        if (isContainsKeyAndNotNull(data, GlobalParamGherkin.IS_ACTIVE)) {
//            jobTitle.setIsActive(data.get(GlobalParamGherkin.IS_ACTIVE));
//        }
//        CreateJobTitleRequest createJobTitleRequest = new CreateJobTitleRequest();
//        createJobTitleRequest.setJobTitle(jobTitle);
//        sendPostTimeSheet(GlobalVariables.JOB_TITLE_EMPLOYEE_PATH, convertObjectToJson(createJobTitleRequest));
//        setUriToHost();
//    }
//}