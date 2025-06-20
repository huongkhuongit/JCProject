//package api.employee.steps;
//
//import com.citigo.booking.api.dto.branch.steps.GetBranchSteps;
//import com.citigo.booking.api.dto.employee.models.Employee;
//import com.citigo.booking.api.dto.employee.models.EmployeeTSDetailResponse;
//import com.citigo.booking.api.dto.employee.models.GetEmployeeResponse;
//import com.citigo.booking.api.dto.employee.models.ListEmployeeTSResponse;
//import com.citigo.booking.core.Base;
//import com.citigo.booking.helper.GlobalParamGherkin;
//import com.citigo.booking.helper.GlobalVariables;
//import com.citigo.booking.helper.RequestSpec;
//import io.restassured.response.Response;
//import net.serenitybdd.core.Serenity;
//
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.HashMap;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class GetEmployeeSteps extends Base {
//    public Response getEmployeeInBranch(int branchId) {
//        HashMap<String, Object> queryParam = new HashMap<>();
//        queryParam.put("IsSale", true);
//        queryParam.put("branchId", branchId);
//        queryParam.put("excludeDefault", true);
//
//        setReqSpec(RequestSpec.baseHeader());
//        return sendGet(GlobalVariables.EMPLOYEE_PATH, queryParam);
//    }
//
//    public List<Employee> getEmployeeList() {
//        int branchId = Serenity.sessionVariableCalled(GlobalVariables.BRANCH_ID);
//        List<Employee> employees = Serenity.sessionVariableCalled(GlobalVariables.EMPLOYEES_BRANCH + branchId);
//        if (employees == null) {
//            Response res = getEmployeeInBranch(branchId);
//            GetEmployeeResponse responseResult = convertJsonResponseToJavaObject(res, GetEmployeeResponse.class);
//            employees = responseResult.getData().stream().filter(item -> item.getIsDeleted().equals(false)).collect(Collectors.toList());
//            Serenity.setSessionVariable(GlobalVariables.EMPLOYEES_BRANCH + branchId).to(employees);
//        }
//        return employees;
//    }
//
//    private HashMap<String, Object> setGeneralParam() {
//        HashMap<String, Object> queryParam = new HashMap<>();
//        queryParam.put("OrderByDesc", "id");
//        queryParam.put("includeFingerPrint", true);
//        return queryParam;
//    }
//
//    public List<EmployeeTSDetailResponse> getAllEmployeeTS() {
//        HashMap<String, Object> queryParam = setGeneralParam();
//        queryParam.put("skip", 0);
//        setUriToTimesheetHost();
//
//        setReqSpec(RequestSpec.baseHeader());
//        Response res = sendGetTimeSheet(GlobalVariables.EMPLOYEE_TS_PATH, queryParam);
//        ListEmployeeTSResponse listEmployeeResponse = convertJsonResponseToJavaObject(res, ListEmployeeTSResponse.class);
//        setUriToHost();
//        return listEmployeeResponse.getResult().getData();
//    }
//
//    public Employee getEmployeeBranchByName(String name) {
//        List<Employee> employees = getEmployeeList();
//        String finalName = name.equals(GlobalParamGherkin.VI_CUSTOMER_DEFAULT) ? GlobalParamGherkin.EN_CUSTOMER_DEFAULT : name;
//        List<Employee> employee = employees.stream()
//                .filter(e -> e.getName().equalsIgnoreCase(finalName) && !e.getIsDeleted()).collect(Collectors.toList());
//
//        if (!employee.isEmpty()) {
//            return employee.get(0);
//        } else {
//            return employees.stream()
//                    .filter(e -> (e.getName().equalsIgnoreCase(GlobalParamGherkin.VI_CUSTOMER_DEFAULT)
//                            || e.getName().equalsIgnoreCase(GlobalParamGherkin.EN_CUSTOMER_DEFAULT)))
//                    .findFirst().orElse(null);
//        }
//    }
//
//    public Employee getEmployeeByName(List<Employee> employeeList, String employeeName) {
//        return employeeList.stream().filter(employee -> employee.getName().equalsIgnoreCase(employeeName)).findFirst().orElse(new Employee());
//    }
//
//    public Employee getEmployeeById(List<Employee> employeeList, int employeeId) {
//        return employeeList.stream().filter(employee -> employee.getId() == employeeId).findFirst().orElse(new Employee());
//    }
//
//    public List<Integer> getListEmployeeIds(String names) {
//        List<String> employeeNames = convertStringToListString(names);
//        List<Integer> employeeIds = new ArrayList<>();
//        for (String employeeName : employeeNames) {
//            Employee employee = getEmployeeBranchByName(employeeName);
//            employeeIds.add(employee.getId());
//        }
//        return employeeIds;
//    }
//
//    public List<String> getEmployeeNameList(List<Employee> employeeList, String idListStr) {
//        List<String> idList = convertStringToListString(idListStr);
//        List<String> nameList = new ArrayList<>();
//        for (String id : idList) {
//            nameList.add(getEmployeeById(employeeList, Integer.parseInt(id)).getName());
//        }
//        return nameList;
//    }
//
//    public List<Employee> getListEmployee(String names, String regex) {
//        List<Employee> allEmployee = getEmployeeList();
//        String[] employeeNames = names.split(regex);
//        List<Employee> employeeIds = new ArrayList<>();
//        for (String employeeName : employeeNames) {
//            employeeIds.add(getEmployeeByName(allEmployee, employeeName));
//        }
//
//        return employeeIds;
//    }
//
//    public List<Employee> sortEmployeeListById(List<Employee> employeeList) {
//        Comparator<Employee> compareById = Comparator
//                .comparing(Employee::getId);
//        return employeeList.stream()
//                .sorted(compareById)
//                .collect(Collectors.toList());
//    }
//
//    public List<String> getListEmployeeNames(List<Employee> employeeList) {
//        return employeeList.stream().map(Employee::getName).collect(Collectors.toList());
//    }
//
//    public List<Integer> getListEmployeeIds(List<Employee> employeeList) {
//        return employeeList.stream().map(Employee::getId).collect(Collectors.toList());
//    }
//
//    public List<EmployeeTSDetailResponse> getEmployeeTSDefault() {
//        HashMap<String, Object> queryParam = setGeneralParam();
//        queryParam.put(GlobalParamGherkin.QUERY_BRANCH_IDS, Serenity.sessionVariableCalled(GlobalVariables.BRANCH_ID));
//        setUriToTimesheetHost();
//
//        setReqSpec(RequestSpec.baseHeader());
//        ListEmployeeTSResponse listEmployeeResponse = convertJsonResponseToJavaObject(sendGetTimeSheet(GlobalVariables.EMPLOYEE_TS_PATH, queryParam), ListEmployeeTSResponse.class);
//        setUriToHost();
//        return listEmployeeResponse.getResult().getData();
//    }
//
//    public List<EmployeeTSDetailResponse> searchEmployee(String key, String value) {
//        HashMap<String, Object> queryParam = setGeneralParam();
//        switch (key) {
//            case "Keyword":
//                queryParam.put(key, value);
//                break;
//            case "BranchIds":
//                String[] branchNames = value.split(",");
//                List<Integer> branchIds = new GetBranchSteps().getIdsByNames(branchNames);
//                queryParam.put(key, branchIds.toString());
//                break;
//            case "departmentIds":
//                String[] departmentNames = value.split(",");
//                List<Long> departmentIds = new DepartmentSteps().getIdsByNames(departmentNames);
//                queryParam.put(key, departmentIds.toString());
//                break;
//            case "jobTitleIds":
//                String[] jobTitleNames = value.split(",");
//                List<Long> jobTitleIds = new JobTitleSteps().getIdsByNames(jobTitleNames);
//                queryParam.put(key, jobTitleIds.toString());
//                break;
//            default:
//                break;
//        }
//        setUriToTimesheetHost();
//        setReqSpec(RequestSpec.baseHeader());
//        ListEmployeeTSResponse listEmployeeResponse = convertJsonResponseToJavaObject(sendGetTimeSheet(GlobalVariables.EMPLOYEE_TS_PATH, queryParam), ListEmployeeTSResponse.class);
//        setUriToHost();
//        return listEmployeeResponse.getResult().getData();
//    }
//
//    public List<Employee> getListActiveEmployee() {
//        HashMap<String, Object> queryParam = new HashMap<>();
//        queryParam.put("excludeDefault", true);
//
//        setReqSpec(RequestSpec.baseHeader());
//        sendGet(GlobalVariables.GET_EMPLOYEE_PATH, queryParam);
//        GetEmployeeResponse getEmployeeTSResponse = convertJsonResponseToJavaObject(getResponse(), GetEmployeeResponse.class);
//        return getEmployeeTSResponse.getData();
//    }
//
//    public Employee getEmployeeByUser(Integer userId) {
//        List<Employee> employees = getListActiveEmployee();
//        return employees.stream().filter(e -> e.getUserId() == userId).findFirst().orElse(getEmployeeBranchByName(GlobalParamGherkin.VI_CUSTOMER_DEFAULT));
//    }
//}