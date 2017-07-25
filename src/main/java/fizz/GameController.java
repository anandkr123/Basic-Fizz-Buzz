package fizz;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * Created by Anand on 7/24/2017.
 */
@Controller
public class GameController {
    @GetMapping("/")
     String welcome_page(InputNum inputNum)
    {
        return "welcome";
    }

    @PostMapping("/")
    String validate(@Valid InputNum inputNum, BindingResult bindingResult)
    {
        if (bindingResult.hasErrors()) {
            return "welcome";
        }
        return "calculate";
    }

    @PostMapping("/abc")
    String result_page(@RequestParam("int_number")int number, Model model)
    {
        if(number<2 || number >999)
        {
            return "calculate";
        }
        String f="fizz";
        String b="buzz";
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);            // checking for the WEDNESDAY
        if(dayOfWeek == 4)
        {
            f="wizz";
            b="wuzz";
        }

        int i=2;
        List<Object> stringList=new ArrayList<Object>();
        while(i <= number)
        {
            if ((i%3 == 0) && (i%5 !=0))
                stringList.add(f);
            else if((i%3 != 0) && (i%5 ==0))                           // adding fizz and buzz and the number to the list
                stringList.add(b);                                     //  according to the number
            else if((i%3 == 0) && (i%5 ==0))
                stringList.add(f+" "+b);
            else
                stringList.add(i);
            i++;
        }

        model.addAttribute("data",stringList);           // adding created list to the model attribute making it
                                                                      // accessible to HTML view
        return "result";
    }
}
