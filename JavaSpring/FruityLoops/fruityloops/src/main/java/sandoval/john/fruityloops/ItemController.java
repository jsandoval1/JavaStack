package sandoval.john.fruityloops;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import sandoval.john.fruityloops.models.Item;

@Controller
@RequestMapping("/")
public class ItemController {

    @RequestMapping
    public String index(ModelMap model) {
        // Create a list of fruits
        ArrayList<Item> fruits = new ArrayList<>();
        fruits.add(new Item("Kiwi", 1.5));
        fruits.add(new Item("Mango", 2.0));
        fruits.add(new Item("Goji Berries", 4.0));
        fruits.add(new Item("Guava", 0.75));
        fruits.add(new Item("Apple", 1.0));
        fruits.add(new Item("Pineapple", 1.25));
        fruits.add(new Item("Orange", 1.5));
        fruits.add(new Item("Peach", 1.75));
        fruits.add(new Item("Strawberry", 2.0));

        // We add the "fruits" list to the model, labeling the key "fruits"
        model.addAttribute("fruits", fruits);

        // Return the view name, .jsp not needed because we mention it in
        // application.properties
        return "index";
    }
}
