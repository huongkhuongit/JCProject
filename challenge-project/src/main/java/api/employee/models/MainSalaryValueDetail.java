package api.employee.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainSalaryValueDetail {
    @SerializedName("default")
    private double defaults = 5000000;
    @SerializedName("shiftId")
    private int shiftId;
    @SerializedName("rank")
    private int rank;
}

