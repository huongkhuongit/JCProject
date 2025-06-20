package api.employee.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTSDetailResponse {
    @SerializedName("id")
    private long id;
    @SerializedName("code")
    private String code;
    @SerializedName("name")
    private String name;
    @SerializedName("dob")
    private String dob;
    @SerializedName("gender")
    private Boolean gender;
    @SerializedName("isActive")
    private boolean isActive;
    @SerializedName("identityNumber")
    private String identityNumber;
    @SerializedName("mobilePhone")
    private String mobilePhone;
    @SerializedName("email")
    private String email;
    @SerializedName("facebook")
    private String facebook;
    @SerializedName("address")
    private String address;
    @SerializedName("LocationName")
    private String locationName;
    @SerializedName("WardName")
    private String wardName;
    @SerializedName("note")
    private String note;
    @SerializedName("userId")
    private int userId;
    @SerializedName("departmentId")
    private Long departmentId;
    @SerializedName("department")
    private Department department;
    @SerializedName("jobTitleId")
    private Long jobTitleId;
    @SerializedName("jobTitle")
    private JobTitle jobTitle;
    @SerializedName("tenantId")
    private int tenantId;
    @SerializedName("branchId")
    private int branchId;
    @SerializedName("createdBy")
    private int createdBy;
    @SerializedName("modifiedBy")
    private int modifiedBy;
    @SerializedName("isDeleted")
    private boolean isDeleted;
    @SerializedName("profilePictures")
    private List<ProfilePictures> profilePictures = Collections.emptyList();
    @SerializedName("clockings")
    private List<String> clockings = Collections.emptyList();
    @SerializedName("departmentName")
    private String departmentName;
    @SerializedName("jobTitleName")
    private String jobTitleName;
    @SerializedName("isNotUpdateUserId")
    private boolean isNotUpdateUserId;
    @SerializedName("debt")
    private int debt;
    @SerializedName("finqerCodes")
    private List<String> finqerCodes = new ArrayList<>();
    @SerializedName("employeeBranches")
    private List<EmployeeBranchTS> employeeBranches = new ArrayList<>();

}

