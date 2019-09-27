//package com.example.demo.controller;
//
//import com.example.demo.model.PersonDto;
//import com.example.demo.persistance.entity.Person;
//import com.example.demo.persistance.service.PersonService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Controller
////@Profile("dev")
//public class PersonController {
//
//    @Autowired
//    private PersonService personService;
//
////    @Autowired(required = false)
//    @Autowired
//    private Person person;
//
//    @Value("${rest.client}")
//    private String endPoint;
//
//    public List<PersonDto> personList () {
////        return entityManager.createQuery("from Person", PersonDto.class).getResultList();
//        List<PersonDto> personDtos = personService.findAll()
//                .stream()
//                .map(p -> new PersonDto(p.getId(),p.getName(),p.getSurname(),p.getPin(),p.getStartDate(),p.getSalary()))
//                .collect(Collectors.toList());
//        return personDtos;
//
//    }
//
//
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView home(ModelAndView view/*, HttpServletRequest request*/) {
//
//        System.out.println("Muraciet olunan url : "+endPoint);
//        System.out.println("Profile (dev or prod) person : "+person);
//
//        System.out.println("home isledi controller");
//        Person person = personService.find("00000","000000","00000");
////        Person personNameSurname = personService.findByNameAndSurname("Seymur","hhh");
//
//        System.out.println(" Searched and found person -> " +person );
//
//
//        view.addObject("person", new PersonDto());
//        view.addObject("personList",personList());
//        view.setViewName("index");
//        return view;
//    }
//
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public ModelAndView delete(ModelAndView modelAndView, @PathVariable("id") Long id) {
//        modelAndView.setViewName("index");
//        personService.remove(id);
//        modelAndView.addObject("person", new PersonDto());
//
//        modelAndView.addObject("personList",personList());
//        System.out.println("removed  id : " + id);
//        return modelAndView;
//
//    }
//
//    @PostMapping(value = "/addPerson")
////    @Transactional //EntityManager isledende tranzaksiya lazim olur
//    public ModelAndView addPerson (PersonDto person, ModelAndView view) {
//
////        entityManager.getTransaction().begin();
////        entityManager.persist(person);
////        entityManager.getTransaction().commit();
//        personService.save(person.person());
//        view.addObject("person", new PersonDto());
//
//        System.out.println(person);
//        view.setViewName("index");
//        view.addObject("personList", personList());
//        return view;
//    }
//
////    @GetMapping(value = "/addPerson")
////    public ModelAndView addPerson (ModelAndView view) {
////        view.setViewName("index");
////        return view;
////    }
//
//
//    //    List<PersonDto> personList = Arrays.asList( //yalanci data atmaq ucun istifade olunur
////            new PersonDto(1,"Haci","Aliyev","backend1",new Date(),200.7),
////            new PersonDto(2,"Elvin","Shahmuradov","backend2",new Date(),201.7),
////            new PersonDto(3,"Etibar","Nadirov","fullstack",new Date(),202.7)
////    );
//
//    //    @Autowired
////    private EntityManager entityManager; //bunun evezine peronRepository var ve Jpa islede bilerem.
//}
