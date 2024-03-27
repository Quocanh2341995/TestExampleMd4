package com.example.managercity_module4.controller;

import com.example.managercity_module4.modal.City;
import com.example.managercity_module4.service.HomeService;
import com.example.managercity_module4.service.ICityService;
import com.example.managercity_module4.service.INationalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/city")
@AllArgsConstructor
public class CityController {
    protected final ICityService cityService;
    protected final INationalService nationalService;
    protected final HomeService homeService;

    @GetMapping
    public ModelAndView index(@RequestParam(defaultValue = "") String search) {
        return new ModelAndView("index")
                .addObject("listCity", cityService.getAllCityBy(search))
                .addObject(search);
    }

    @GetMapping("/add")
    public ModelAndView showFormCreate() {
        return new ModelAndView("add")
                .addObject("listNational", nationalService.getAllNational())
                .addObject("city", new City());
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id) {
        return new ModelAndView("update")
                .addObject("city", cityService.getDetailCityBy(id))
                .addObject("listNational", nationalService.getAllNational());
    }

    @PostMapping("/add")
    public String addStaff(@ModelAttribute @Valid City city, RedirectAttributes redirectAttributes) {
        cityService.save(city);
        redirectAttributes.addFlashAttribute("success", "Thêm mới city thành công!!");
        return "redirect:/city";
    }

    @PostMapping("/edit/{id}")
    public String updateStaff(@PathVariable Long id, @ModelAttribute @Valid City city, RedirectAttributes redirectAttributes) {
        cityService.save(city);
        redirectAttributes.addFlashAttribute("success", "Sửa thông tin city thành công!");
        return "redirect:/city";
    }

    @GetMapping("/delete/{id}")
    public String deleteStaff(@PathVariable Long id, RedirectAttributes redirectAttributes) throws Exception {
        cityService.deletedBy(id);
        redirectAttributes.addFlashAttribute("success", "Xóa city thành công!");
        return "redirect:/city";
    }
}
