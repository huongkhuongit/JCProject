package api.employee.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @SerializedName("Id")
    private int id;
    @SerializedName("Name")
    private String name;
    @SerializedName("GivenName")
    private String givenName;
    @SerializedName("IsAdmin")
    private Boolean isAdmin;
    @SerializedName("IsActive")
    private Boolean isActive;
    @SerializedName("MobilePhone")
    private String mobilePhone;
    @SerializedName("Address")
    private String address;
    @SerializedName("LocationName")
    private String locationName;
    @SerializedName("WardName")
    private String wardName;
    @SerializedName("BranchId")
    private int branchId;
    @SerializedName("RetailerId")
    private int retailerId;
    @SerializedName("isDeleted")
    private Boolean isDeleted;
    @SerializedName("UserId")
    private int userId;
}