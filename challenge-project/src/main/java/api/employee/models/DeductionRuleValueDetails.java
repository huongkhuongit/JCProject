package api.employee.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeductionRuleValueDetails {
    @SerializedName("deductionRuleValueDetails")
    private List<String> deductionRuleValueDetails = new ArrayList<>();
}
