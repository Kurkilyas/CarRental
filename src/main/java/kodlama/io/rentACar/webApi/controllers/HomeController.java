package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class HomeController {
    private CarRepository carRepository;


    @GetMapping("/services.html")
    public String services()
    {
        return "services";
    }
    @GetMapping("/about.html")
    public String about()
    {
        return "about";
    }
    @GetMapping("/dashboardAdmin")
    public String dashborar()
    {
        return "index";
    }
    @GetMapping("/addCar.html")
    public String addCar()
    {
        return "addCar";
    }
    @GetMapping("/contact.html")
    public String contact()
    {
        return "contact";
    }
    @GetMapping("gallery.html")
    public String gallerty()
    {
        return "gallery";
    }
    @GetMapping("/index.html")
    public String index()
    {
        return "index";
    }
    @GetMapping("/myAds.html")
    public String myAdds()
    {
        return "myAds";
    }
    @GetMapping("/rentCar2.html")
    public String rentCar2()
    {
        return "rentCar2";
    }

    @GetMapping("/updateCar.html")
    public String updateCar()
    {
        return "updateCar";
    }

    @GetMapping("/silme.html")

        public String silme()
    {
        return "silme";
    }
    @GetMapping("/dashboard")
    public String showDashboard() {
        return "index.html";
    }


    @GetMapping("/dashboardUser")
    public String showDashboardUser() {
        return "about.html";
    }
    /*@GetMapping("/allAds.html")
    public String allAlds()
    {
        return "allAds";
    }*/
    @GetMapping("/deneme.html")
    public String denemeee()
    {
        return "denemeee";
    }
    @GetMapping("/login.html")
    public String login()
    {
        return "login";
    }
    @GetMapping("/signin.html")
    public String signup()
    {
        return "signin";
    }
    @GetMapping("/indexUser.html")
    public String indexUser()
    {
        return "indexUser";
    }

    @GetMapping("/indexAdmin.html")
    public String indexAdmin()
    {
        return "indexAdmin";
    }
    @GetMapping("/aboutUser.html")
    public String aboutUser()
    {
        return "aboutUser";
    }
    @GetMapping("/aboutAdmin.html")
    public String aboutAdmin()
    {
        return "aboutAdmin";
    }





}