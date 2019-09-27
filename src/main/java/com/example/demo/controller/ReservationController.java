package com.example.demo.controller;

import com.example.demo.model.ReservationDto;
import com.example.demo.persistance.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Profile("dev")
@RestController(value = "/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    public List<ReservationDto> reservationList() {
        List<ReservationDto> reservationDtos = reservationService.findAll()
                .stream()
                .map(r -> new ReservationDto(r.getId(), r.getUsers(), r.getTables(), r.getReservDate(), r.getStartTime(), r.getEndTime(), r.getStatus()))
                .collect(Collectors.toList());
        return reservationDtos;

    }



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView view) {
        view.addObject("reservationDtoModal", new ReservationDto());
        view.setViewName("index");
        return view;
    }

    @PostMapping(value = "/addReservationByUser")
    public ModelAndView addReservationByUser(ReservationDto reservationDto, ModelAndView view) {
        System.out.println("addReservationByUser data = "+reservationDto);
        reservationService.save(reservationDto);
        view.setViewName("index");
//        view.setViewName("redirect:/index");
        return view;
    }




}
