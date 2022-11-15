package Java;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
@RestController
public class Indexcontroller {

    /*
    The method stores returned a HTML string from the ReadFeeds method
    and connects it with Ynet.html
     */
    @RequestMapping
    public ModelAndView  rssForm(Model model) throws Exception {

        String finalFeed = FeedHandler.ReadFeeds();
        model.addAttribute("FinalParsedFeed",finalFeed);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Ynet");
        return modelAndView;
    }
}
