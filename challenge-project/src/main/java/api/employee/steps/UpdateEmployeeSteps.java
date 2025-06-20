//package api.employee.steps;
//
//import com.citigo.booking.core.Base;
//import com.citigo.booking.helper.GlobalVariables;
//import com.citigo.booking.helper.RequestSpec;
//
//import java.util.HashMap;
//
//public class UpdateEmployeeSteps extends Base {
//    public void setEmployeeStatus(Long employeeId) {
//        setUriToTimesheetHost();
//
//        setReqSpec(RequestSpec.baseHeader());
//        HashMap<String, Object> formData = new HashMap<>();
//        formData.put("id", employeeId);
//        formData.put("deactivateUser", false);
//        sendPutWithFormDataTimeSheet(GlobalVariables.STOP_WORKING, formData);
//        setUriToHost();
//    }
//}
