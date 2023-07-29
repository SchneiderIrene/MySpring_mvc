package com.zaurtregulov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class MyController {

    @RequestMapping("/")
    public String showFirstView (){
       return "first_view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails (Model model){

        model.addAttribute("employee", new Employee());

//        Employee emp = new Employee();
//        emp.setName("Ivan");
//        emp.setSurname("Petrov");
//        emp.setSalary(500);


        model.addAttribute("employee", new Employee());
        return "ask-emp-details-view";
    }

//    @RequestMapping("/showDetails")
//    public String showEmpDetails (){
//        return "show-emp-details-view";
//    }

//    @RequestMapping("showDetails")
//    public String showEmpDetails (HttpServletRequest request, Model model){
//        String empName = request.getParameter("employeeName");
//        empName = "Frau " + empName;
//        model.addAttribute("nameAttribute", empName);
//        model.addAttribute("description", " - udemy student");
//
//        return "show-emp-details-view";
//    }

    @PostMapping(path = "/showDetails")
    public String showEmpDetails (@Valid @ModelAttribute("employee") Employee emp
                                 , BindingResult bindingResult){


        if (bindingResult.hasErrors()){
            return "ask-emp-details-view";
        }
     else {
            return "show-emp-details-view";
        }
    }


}
