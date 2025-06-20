package api.employee.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeBranchTS {
    @SerializedName("id")
    private long id;
    @SerializedName("tenantId")
    private int tenantId;
    @SerializedName("branchId")
    private int branchId;
    @SerializedName("employeeId")
    private long employeeId;
}
