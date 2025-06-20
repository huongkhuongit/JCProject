package api.employee.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class MainSalaryValueDetails {
    @SerializedName("default")
    private Integer defaulT;
    @SerializedName("shiftId")
    private int shiftId;
    @SerializedName("rank")
    private int rank;
}
