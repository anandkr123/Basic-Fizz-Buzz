package fizz;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by Anand on 7/25/2017.
 */
public class InputNum {
    @Min(2) @Max(999)                     // providing validation for the number
    private Integer num;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
