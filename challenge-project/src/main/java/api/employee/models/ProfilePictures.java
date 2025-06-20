package api.employee.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfilePictures {
    @SerializedName("id")
    private int id;
    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("file")
    private Object file;
}
