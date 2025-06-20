package api.employee.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListEmployeeTSResponse {
    @SerializedName("result")
    private ResultListEmployeeTS result;
    @SerializedName("message")
    private String message;
}

