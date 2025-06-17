package com.pluralsight;

import com.pluralsight.dao.RegistrationDAO;
import com.pluralsight.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {


    private RegistrationDAO registrationDAO;

    @Autowired
    public HomeController(RegistrationDAO registrationDAO) {
        this.registrationDAO = registrationDAO;
    }

    @RequestMapping(path="/", method= RequestMethod.GET)
    public List<Student> index(){
        return registrationDAO.getAllStudents();
    }
}
