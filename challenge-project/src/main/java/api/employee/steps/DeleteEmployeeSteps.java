//package api.employee.steps;
//
//import com.citigo.booking.core.Base;
//import com.citigo.booking.helper.GlobalVariables;
//import com.citigo.booking.helper.RequestSpec;
//
//public class DeleteEmployeeSteps extends Base {
//    public void deleteEmployee(Long employeeId) {
//        setUriToTimesheetHost();
//        setReqSpec(RequestSpec.baseHeader());
//        sendDeleteTimeSheet(GlobalVariables.EMPLOYEE_TS_PATH + employeeId);
//        setUriToHost();
//    }
//}