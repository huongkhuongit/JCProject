package api.employee.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListJobTitleResponse {
    @SerializedName("result")
    private ResultListJobTitle result;
    @SerializedName("message")
    private String message;
}

