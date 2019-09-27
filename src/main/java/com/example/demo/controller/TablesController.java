package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.persistance.entity.Person;
import com.example.demo.persistance.entity.Reservation;
import com.example.demo.persistance.entity.Tables;
import com.example.demo.persistance.entity.Users;
import com.example.demo.persistance.service.ReservationService;
import com.example.demo.persistance.service.TablesService;
import com.example.demo.persistance.service.UsersService;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Profile("dev")
@RestController
public class TablesController {

    @Autowired
    private UsersService userService;

    @Autowired
    private TablesService tablesService;

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private Tables tables;

//    @Autowired
//    private Reservation reservation;

    @Value("${rest.client}")
    private String endPoint;

    public List<TablesDto> tablesList() {
        List<TablesDto> tablesDtoList = tablesService.findAll()
                .stream()
                .map(t -> new TablesDto(t.getId(), t.getType(), t.getDescription()))
                .collect(Collectors.toList());
        return tablesDtoList;

    }

    public List<ReservationDto> reservationList() {
        List<ReservationDto> reservationDtos = reservationService.findAll()
                .stream()
                .map(r -> new ReservationDto(r.getId(), r.getUsers(), r.getTables(), r.getReservDate(), r.getStartTime(), r.getEndTime(), r.getStatus()))
                .collect(Collectors.toList());
        return reservationDtos;

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(ModelAndView view) {
//        Long userId = UserPrincipalDetailsService.userId;
//        Long positionId = permissionService.getUserById(userId).getPosition().getId();

        view.addObject("reservationDto", new ReservationDto());

        view.setViewName("index");
        return view;
    }

    @PostMapping(value = "/searchTables")
    public ModelAndView searchTables(ReservationDto reservationDto, ModelAndView view) {
        LocalDate reservDate = reservationDto.getReservDate();
        LocalTime startTime = reservationDto.getStartTime();
        LocalTime endTime = reservationDto.getEndTime();
        List<TablesDto> tablesDtoList = tablesList();
        List<TableInfoDto> tableInfoDtoList = new ArrayList<>(tablesDtoList.size());
        List<Reservation> reservationSearchedList = reservationService.findByReservDateAndStartTimeAndEndTime(reservDate, startTime, endTime);
        if (!reservationSearchedList.isEmpty()) {
            for (TablesDto tablesDto : tablesDtoList) {
                TableInfoDto tableInfoDto = new TableInfoDto();
                for (Reservation reservationSearch : reservationSearchedList) {
                    if (reservationSearch == null) {
                        tableInfoDto.setTablesDto(tablesDto);
                        tableInfoDto.setStatus("G");
                    } else {
                        System.out.println("reservationSearch.getTables().getId() = " + reservationSearch.getTables().getId() + "tablesDto.getId()" + tablesDto.getId());
                        if (reservationSearch.getTables().getId().equals(tablesDto.getId()) && reservationSearch.getStatus().equals("R")) {
                            tableInfoDto.setTablesDto(tablesDto);
                            tableInfoDto.setStatus("R");
                            System.out.println("You cannot reserve!");
                            break;
                        } else if (reservationSearch.getTables().getId().equals(tablesDto.getId()) && reservationSearch.getStatus().equals("Y")) {
                            tableInfoDto.setTablesDto(tablesDto);
                            tableInfoDto.setStatus("Y");
                            System.out.println("You cannot reserve, another user reserved!");
                            break;
                        } else {
                            tableInfoDto.setTablesDto(tablesDto);
                            tableInfoDto.setStatus("G");
                        }
                    }
                }
                tableInfoDtoList.add(tableInfoDto);
            }

        } else {
            for (TablesDto tablesDto : tablesDtoList) {
                TableInfoDto tableInfoDto = new TableInfoDto();
                tableInfoDto.setTablesDto(tablesDto);
                tableInfoDto.setStatus("G");
                tableInfoDtoList.add(tableInfoDto);
            }

        }


        List<TableInfoDto> tableInfoDtoListType6 = new LinkedList<>();
        List<TableInfoDto> tableInfoDtoListType2 = new LinkedList<>();
        System.out.println("tableInfoDtoList sorting = " + tableInfoDtoList);
        for (TableInfoDto tableInfoDto : tableInfoDtoList) {
            if (tableInfoDto.getTablesDto().getType().equals(Long.valueOf(6))) {
                tableInfoDtoListType6.add(tableInfoDto);
            } else {
                tableInfoDtoListType2.add(tableInfoDto);
            }
        }
        System.out.println("tableInfoDtoListType6 = " + tableInfoDtoListType6);
        System.out.println("tableInfoDtoListType2 = " + tableInfoDtoListType2);

        view.addObject("tableInfoDtoListType6", tableInfoDtoListType6);
        view.addObject("tableInfoDtoListType2", tableInfoDtoListType2);
        view.setViewName("index");
//        view.setViewName("redirect:/index");
        return view;
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ModelAndView home(ModelAndView view) {
//
//        List<Tables> tablesList2 = tablesService.findByType(Long.valueOf(2));
//        List<Tables> tablesList6 = tablesService.findByType(Long.valueOf(6));
////        System.out.println("Muraciet olunan url : "+endPoint);
////        System.out.println("tables Data 2 lik   =  "+tablesList2);
////        System.out.println("tables Data 6 liq   =  "+tablesList6);
//
////        view.addObject("tables", new TablesDto());
////        view.addObject("tablesListType2", tablesList2);
////        view.addObject("tablesListType6", tablesList6);
//        view.setViewName("index");
//        return view;
//    }

//    @RequestMapping(value = "/findTableDataById", method = RequestMethod.GET)
//    @ResponseBody //bu elave olunub
//    public ModelAndView findTableById(ModelAndView modelAndView, @RequestParam("id") Long id) {
//        System.out.println("find by id isledi");
//        modelAndView.setViewName("reservationModal");
//        System.out.println("table id from html"+id);
//        Tables tables = tablesService.findById(id);
//        System.out.println("tablesListById metod = " + tablesService.findById(id));
//        System.out.println("tablesListById data = " + tables);


//        modelAndView.addObject("tables", new TablesDto());

//        modelAndView.addObject("tablesOneById", new TablesDto());
//        modelAndView.addObject("tablesDataById", tables);
//
//        return modelAndView;
//
//    }

//    @RequestMapping(path = "/findTableByParameter"  /*"/findTableByParameter"*/,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody //bu elave olunub
//    public ModelAndView     findTableByParameter(ModelAndView modelAndView, @RequestParam("dayDate") String dayDate, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
//
//        System.out.println("dayDate = " + dayDate + "startDate = " + startDate + "endDate" + endDate);
//        LocalDate date = dayDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        List<TablesUtilDto> tablesUtilDtoList2 = tablesService.findByParameter2(LocalTime.ofSecondOfDay(startDate), LocalTime.ofSecondOfDay(endDate), date);
//        List<TablesUtilDto> tablesUtilDtoList6 = tablesService.findByParameter6(LocalTime.ofSecondOfDay(startDate), LocalTime.ofSecondOfDay(endDate), date);
//        modelAndView.addObject("tables", new TablesDto());
//        modelAndView.addObject("tablesUtilDtoList2", tablesUtilDtoList2);
//        modelAndView.addObject("tablesUtilDtoList6", tablesUtilDtoList6);
//        modelAndView.setViewName("index");
//
//
//        List<Tables> tablesList = tablesService.findAll();
//        List<Reservation> reservationList = reservationService.findAll();
//        List<TablesUtilDto> tablesListUtil = new ArrayList<>(tablesList.size());
//        TablesUtilDto tablesUtilDto = new TablesUtilDto();
//        for (Tables table : tablesList) {
//            for (Reservation reservation : reservationList) {
//                if (table.getId().equals(reservation.getTables().getId()))
//                    if (reservation.getStartTime().compareTo(LocalTime.ofSecondOfDay(startDate)) >= 0)
//                        if (reservation.getEndTime().compareTo(LocalTime.ofSecondOfDay(endDate)) <= 0)
//                            if (reservation.getReservDate().compareTo(date) ==0) {
//                                tablesUtilDto.setTables(table);
//                                tablesUtilDto.setReservation(reservation);
//                            }
//                }
//            tablesListUtil.add(tablesUtilDto);
//        }

//        for(TablesUtilDto tablesUtilDto1 : tablesListUtil){
//            if()
//        }
//
//        System.out.println(tablesListUtil);
//        modelAndView.addObject("tablesListUtil", tablesListUtil);
//        modelAndView.setViewName("index");
//        return modelAndView;

//        modelAndView.setViewName("reservationModal");
////        System.out.println("table id from html"+id);
//        Tables tables = tablesService.findById(id);
//        System.out.println("tablesListById metod = " + tablesService.findById(id));
//        System.out.println("tablesListById data = " + tables);
//
//
////        modelAndView.addObject("tables", new TablesDto());
//
//        modelAndView.addObject("tablesOneById", new TablesDto());
//        modelAndView.addObject("tablesDataById", tables);


//    @RequestMapping(value = "/tablesListType2", method = RequestMethod.GET)
//    public ModelAndView findByType2(ModelAndView modelAndView) {
//        System.out.println("type2 called");
//
//        modelAndView.setViewName("index");
//        List<Tables> tablesList = tablesService.findByType(Long.valueOf(2));
//        System.out.println("type 2 called getdata =  "+tablesList);
//
//        modelAndView.addObject("tables", new TablesDto());
//        modelAndView.addObject("tablesListType2",tablesList);
//        modelAndView.setViewName("index");
//        return modelAndView;
//
//    }
//    @RequestMapping(value = "/tablesListType6", method = RequestMethod.GET)
//    public ModelAndView findByType6(ModelAndView modelAndView) {
//        System.out.println("type6 called");
//
//        modelAndView.setViewName("index");
//        List<Tables> tablesList6 = tablesService.findByType(Long.valueOf(6));
//        System.out.println("type 6 called getdata =  "+tablesList6);
//        modelAndView.addObject("tables", new TablesDto());
//        modelAndView.addObject("tablesListType6",tablesList6);
//        modelAndView.setViewName("index");
//        return modelAndView;
//


}
