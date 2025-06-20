//package api.employee.steps;
//
//import com.citigo.booking.api.dto.employee.models.CreateDepartmentRequest;
//import com.citigo.booking.api.dto.employee.models.Department;
//import com.citigo.booking.api.dto.employee.models.ListDepartmentResponse;
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
//public class DepartmentSteps extends Base {
//    public List<Department> getDepartment() {
//        setUriToTimesheetHost();
//
//        setReqSpec(RequestSpec.baseHeader());
//        Response response = sendGetTimeSheet(GlobalVariables.DEPARTMENT_EMPLOYEE_PATH);
//        ListDepartmentResponse listDepartmentResponse = convertJsonResponseToJavaObject(response, ListDepartmentResponse.class);
//        setUriToHost();
//        return listDepartmentResponse.getResult().getData();
//    }
//
//    public String getDepartmentIdByName(String name) {
//        getDepartment();
//        List<String> listDepartment = convertStringToListString(getJsonValue("result.data.name"));
//        int index = listDepartment.indexOf(name);
//        return index < 0 ? null : getJsonValue("result.data[" + index + "].id");
//    }
//
//    public Department getDepartmentByName(String name) {
//        return getDepartment().stream().filter(department -> department.getName().equals(name)).findFirst().orElse(new Department());
//    }
//
//    public List<Long> getIdsByNames(String[] names) {
//        List<Long> departmentIds = new ArrayList<>();
//        for (String name : names) {
//            departmentIds.add(getDepartmentByName(name).getId());
//        }
//        return departmentIds;
//    }
//
//    public void createDepartment(Map<String, String> data) {
//        setUriToTimesheetHost();
//
//        setReqSpec(RequestSpec.baseHeader());
//        Department department = new Department();
//        if (isContainsKeyAndNotNull(data, GlobalParamGherkin.NAME)) {
//            department.setName(data.get(GlobalParamGherkin.NAME));
//        }
//        if (isContainsKeyAndNotNull(data, GlobalParamGherkin.DESCRIPTION)) {
//            department.setDescription(data.get(GlobalParamGherkin.DESCRIPTION));
//        }
//        if (isContainsKeyAndNotNull(data, GlobalParamGherkin.IS_ACTIVE)) {
//            department.setIsActive(data.get(GlobalParamGherkin.IS_ACTIVE));
//        }
//        CreateDepartmentRequest createDepartmentRequest = new CreateDepartmentRequest();
//        createDepartmentRequest.setDepartment(department);
//        sendPostTimeSheet(GlobalVariables.DEPARTMENT_EMPLOYEE_PATH, convertObjectToJson(createDepartmentRequest));
//        setUriToHost();
//    }
//}