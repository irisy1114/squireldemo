package edu.wctc.squireldemo;

import edu.wctc.squireldemo.entity.Location;
import edu.wctc.squireldemo.entity.Sighting;
import edu.wctc.squireldemo.entity.Squirrel;
import edu.wctc.squireldemo.service.LocationService;
import edu.wctc.squireldemo.service.SightingService;
import edu.wctc.squireldemo.service.SquirrelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SightingController {
    @Autowired
    private SquirrelService squirrelService;

    @Autowired
    private SightingService sightingService;

    @Autowired
    private LocationService locationService;


    @GetMapping("/report")
    public String showSightingForm(@RequestParam("id") String idString, Model model) {
        int squirrelId = 0;
        try {
            squirrelId = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            squirrelId = 1;
        }
        // get squirrel object with matching ID
        Squirrel squirrel = squirrelService.getSquirrel(squirrelId);
        model.addAttribute("squirrelObj",squirrel );

        // get list of locations and add to model
        List<Location> list = locationService.getLocationList();
        model.addAttribute("locationList", list);

        Sighting newSighting = new Sighting();
        newSighting.setSquirrelId(squirrel.getId());
        newSighting.setSpotterName("Iris");
        model.addAttribute("theSighting", newSighting);

        return "sighting-form";
    }

    @GetMapping("/list")
    public String showSquirrelList(Model model) {
        model.addAttribute("squirrelList",
                squirrelService.getSquirrelList());
        return "squirrel-list";
    }

    @PostMapping("/save")
    public String saveSighting(@Valid @ModelAttribute Sighting sighting,
                               BindingResult bindingResult, Model model) {
        // check if validation is passing
        if (bindingResult.hasErrors()) {
            // if it's not,
            // send them back to the form that now shows errors
            // get squirrel object with matching ID
            Squirrel squirrel = squirrelService.getSquirrel(sighting.getSquirrelId());
            model.addAttribute("squirrelObj",squirrel );

            // get list of locations and add to model
            List<Location> list = locationService.getLocationList();
            model.addAttribute("locationList", list);

            model.addAttribute("theSighting", sighting);
            return "sighting-form";
        } else {
            // if it is
            // save the sighting to the db
            // send them to the confirmation page
            sightingService.saveSighting(sighting);
            return "confirmation";
        }
    }

    @GetMapping("/sightings")
    public String showSightingsList(@RequestParam("id") String idString, Model model) {
        int squirrelId = 0;
        try {
            squirrelId = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            squirrelId = 1;
        }
        // get squirrel with matching ID and add to model
        Squirrel squirrel = squirrelService.getSquirrel(squirrelId);
        model.addAttribute("commonName", squirrel.getCommonName());

        // get sightings with matching squirrel ID and add to model
        List<Sighting> list = sightingService.getSightingsForSquirrel(squirrelId);
        model.addAttribute("sightingList", list);

        return "sighting-list";
    }

}
