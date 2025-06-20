package api.employee.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class MainSalaryRuleValue {
    @SerializedName("type")
    private Integer type;
    @SerializedName("mainSalaryValueDetails")
    private List<MainSalaryValueDetails> mainSalaryValueDetails;
}
