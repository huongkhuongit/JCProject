package api.employee.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class PayRateRequest {
    @SerializedName("salaryPeriod")
    private Integer salaryPeriod;
    @SerializedName("mainSalaryRuleValue")
    private MainSalaryRuleValue mainSalaryRuleValue;
}
