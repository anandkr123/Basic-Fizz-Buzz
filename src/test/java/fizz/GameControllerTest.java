package fizz;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import java.util.Calendar;
/**
 * Created by Anand on 7/25/2017.
 */
@WebMvcTest(controllers = {GameController.class})
@RunWith(SpringRunner.class)
public class GameControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void result_page() throws Exception {
        Model model;
        List list;
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek == 4)
            list= Arrays.asList(2,"wizz",4,"wuzz");
        else
            list= Arrays.asList(2,"fizz",4,"buzz");
      mockMvc.perform(post("/abc")
              .param("int_number","5")
              .param("model","model"))
              .andDo(print())
              .andExpect(model().attribute("data",Matchers.is(list) ))
              .andReturn();
    }
}