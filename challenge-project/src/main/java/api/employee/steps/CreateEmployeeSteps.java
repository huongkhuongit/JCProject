//package api.employee.steps;
//
//import api.BaseAPI;
//import api.employee.models.CreateEmployeeRequest;
//import api.employee.models.PayRateRequest;
//import constants.GlobalVariables;
//import net.serenitybdd.core.Serenity;
//import org.jetbrains.annotations.NotNull;
//import utils.RequestSpec;
//
//import java.util.*;
//
//public class CreateEmployeeSteps extends BaseAPI {
//
//    public void createEmployee(Map<String, String> data) {
//        CreateEmployeeRequest createEmployeeRequest = prepareCreateEmployee(data);
//        PayRateRequest payRateRequest = preparePayRateRequest();
//        setUri("setUriToTimesheetHost");
//        HashMap<String, Object> formData = new HashMap<>();
//        formData.put("employee", convertObjectToJson(createEmployeeRequest));
//        formData.put("payRate", convertObjectToJson(payRateRequest));
//        setReqSpec(RequestSpec.headerFormData());
//        sendPostWithFormDataTimeSheet(GlobalVariables.BRANCH_ID, formData);
//        setUri("host thường");
//    }
//
//
//
//    @NotNull
//    private CreateEmployeeRequest prepareCreateEmployee(Map<String, String> data) {
//        CreateEmployeeRequest createEmployeeRequest = new CreateEmployeeRequest();
//        setInitializeInfo(data, createEmployeeRequest);
//        setWorkingInfo(data, createEmployeeRequest);
//        setPersonalInfo(data, createEmployeeRequest);
//        setContactInfo(data, createEmployeeRequest);
//        Serenity.setSessionVariable(GlobalVariables.EMPLOYEE_REQUEST).to(createEmployeeRequest);
//        return createEmployeeRequest;
//    }
//
//    private void setInitializeInfo(Map<String, String> data, CreateEmployeeRequest createEmployeeRequest) {
//        if (isContainsKeyAndNotNull(data, GlobalParamGherkin.NAME)) {
//            createEmployeeRequest.setName(data.get(GlobalParamGherkin.NAME));
//        } else {
//            createEmployeeRequest.setName(generateCustomerName());
//        }
//
//        createEmployeeRequest.setMobilePhone(generatePhoneNumber());
//        if (isContainsKeyAndNotNull(data, "branchName")) {
//            DetailBranch branch = new GetBranchSteps().getBranchByName(data.get("branchName"));
//            createEmployeeRequest.setBranchId(branch.getId());
//        }
//
//        if (isContainsKeyAndNotNull(data, "workBranchNames")) {
//            List<DetailBranch> detailBranchList = new GetBranchSteps().getBranchList();
//            String[] listBranch = data.get("workBranchNames").split(",");
//            List<Integer> branchIds;
//            if (listBranch[0].equals("all")) {
//                branchIds = new ArrayList<>();
//                for (DetailBranch branch : detailBranchList) {
//                    branchIds.add(branch.getId());
//                }
//            } else {
//                branchIds = new GetBranchSteps().getIdsByNames(listBranch);
//            }
//            createEmployeeRequest.setWorkBranchIds(branchIds);
//        }
//
//        if (isContainsKeyAndNotNull(data, "ProfilePictures") && data.get("ProfilePictures").equals("1")) {
//            ProfilePictures profilePictures = new ProfilePictures();
//            profilePictures.setImageUrl(Attachment.PIC_1.getHref());
//            createEmployeeRequest.setProfilePictures(profilePictures);
//        }
//    }
//
//    private void setWorkingInfo(Map<String, String> data, CreateEmployeeRequest createEmployeeRequest) {
//        if (isContainsKeyAndNotNull(data, "departmentName")) {
//            new DepartmentSteps().getDepartment();
//            List<String> listDepartmentName = convertStringToListString(getJsonValue("result.data.name"));
//            long departmentId = Long.parseLong(getJsonValue("result.data[" + listDepartmentName.indexOf(data.get("departmentName")) + "].id"));
//            createEmployeeRequest.setDepartmentId(departmentId);
//        }
//
//        if (isContainsKeyAndNotNull(data, "jobTitleName")) {
//            new JobTitleSteps().getJobTitle();
//            List<String> listJobTitleName = convertStringToListString(getJsonValue("result.data.name"));
//            long jobTitleId = Long.parseLong(getJsonValue("result.data[" + listJobTitleName.indexOf(data.get("jobTitleName")) + "].id"));
//            createEmployeeRequest.setJobTitleId(jobTitleId);
//        }
//
//        if (isContainsKeyAndNotNull(data, GlobalParamGherkin.USER_NAME)) {
//            String userName = data.get(GlobalParamGherkin.USER_NAME);
//            User user = userName.equals("auto") ? new GetUserSteps().getRandomUserAvailable() : new GetUserSteps().byName(userName);
//            createEmployeeRequest.setUserId(user.getId());
//            Serenity.setSessionVariable(GlobalVariables.EMPLOYEE_REQUEST_USER_NAME).to(user.getUserName());
//        }
//        createEmployeeRequest.setTenantId(Serenity.sessionVariableCalled(GlobalVariables.RETAILER_ID));
//        if (isContainsKeyAndNotNull(data, GlobalParamGherkin.NOTE)) {
//            createEmployeeRequest.setNote(data.get(GlobalParamGherkin.NOTE));
//        }
//    }
//
//    private void setPersonalInfo(Map<String, String> data, CreateEmployeeRequest createEmployeeRequest) {
//        if (isContainsKeyAndNotNull(data, "dob")) {
//            createEmployeeRequest.setDob(data.get("dob") + GlobalParamGherkin.TIME_0_Z);
//        } else {
//            createEmployeeRequest.setDob(null);
//        }
//        if (isContainsKeyAndNotNull(data, GlobalParamGherkin.GENDER)) {
//            boolean gender = !data.get(GlobalParamGherkin.GENDER).equals("female");
//            createEmployeeRequest.setGender(gender);
//        }
//        if (isContainsKeyAndNotNull(data, "identityNumber")) {
//            createEmployeeRequest.setIdentityNumber(data.get("identityNumber"));
//        }
//    }
//
//    private void setContactInfo(Map<String, String> data, CreateEmployeeRequest createEmployeeRequest) {
//        if (isContainsKeyAndNotNull(data, GlobalParamGherkin.EMAIL)) {
//            createEmployeeRequest.setEmail(data.get(GlobalParamGherkin.EMAIL));
//        }
//        if (isContainsKeyAndNotNull(data, "facebook")) {
//            createEmployeeRequest.setFacebook(data.get("facebook"));
//        }
//        if (isContainsKeyAndNotNull(data, GlobalParamGherkin.ADDRESS)) {
//            createEmployeeRequest.setAddress(data.get(GlobalParamGherkin.ADDRESS));
//        }
//        if (!isKeivi() && isContainsKeyAndNotNull(data, GlobalParamGherkin.LOCATION_NAME)) {
//            createEmployeeRequest.setLocationName(data.get(GlobalParamGherkin.LOCATION_NAME));
//            createEmployeeRequest.setTemploc(data.get(GlobalParamGherkin.LOCATION_NAME));
//        }
//        if (!isKeivi() && isContainsKeyAndNotNull(data, GlobalParamGherkin.WARD_NAME)) {
//            createEmployeeRequest.setWardName(data.get(GlobalParamGherkin.WARD_NAME));
//            createEmployeeRequest.setTempw(data.get(GlobalParamGherkin.WARD_NAME));
//        }
//    }
//}