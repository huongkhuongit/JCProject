package api.employee.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTSResponseUser {
    @SerializedName("Id")
    private long id;
    @SerializedName("Code")
    private String code;
    @SerializedName("Name")
    private String name;
    @SerializedName("BranchId")
    private int branchId;
    @SerializedName("DepartmentName")
    private String departmentName;
    @SerializedName("JobTitleName")
    private String jobTitleName;
    @SerializedName("MobilePhone")
    private String mobilePhone;
    @SerializedName("isDeleted")
    private Boolean isDeleted;
    @SerializedName("Address")
    private String address;
    @SerializedName("LocationName")
    private String locationName;
    @SerializedName("WardName")
    private String wardName;
    @SerializedName("UserId")
    private int userId;
}