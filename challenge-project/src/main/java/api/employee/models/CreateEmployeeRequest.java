package api.employee.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
    @SerializedName("id")
    private long id;
    @SerializedName("code")
    private String code = "";
    @SerializedName("name")
    private String name;
    @SerializedName("dob")
    private String dob;
    @SerializedName("gender")
    private Boolean gender;
    @SerializedName("identityNumber")
    private String identityNumber = "";
    @SerializedName("mobilePhone")
    private String mobilePhone = "";
    @SerializedName("email")
    private String email = "";
    @SerializedName("facebook")
    private String facebook = "";
    @SerializedName("address")
    private String address;
    @SerializedName("LocationName")
    private String locationName = "";
    @SerializedName("WardName")
    private String wardName = "";
    @SerializedName("note")
    private String note;
    @SerializedName("branchId")
    private int branchId;
    @SerializedName("profilePictures")
    private ProfilePictures profilePictures;
    @SerializedName("departmentId")
    private Long departmentId;
    @SerializedName("jobTitleId")
    private Long jobTitleId;
    @SerializedName("userId")
    private int userId;
    @SerializedName("tenantId")
    private int tenantId;
    @SerializedName("temploc")
    private String temploc = "";
    @SerializedName("tempw")
    private String tempw = "";
    @SerializedName("workBranchIds")
    private List<Integer> workBranchIds;
    @SerializedName("identityKeyClocking")
    private String identityKeyClocking;
    @SerializedName("isNotUpdateUserId")
    private Boolean isNotUpdateUserId = false;


}