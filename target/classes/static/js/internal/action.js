var globClickedTableId = '';

$(function () {
    // $('#TableFor6Id').click(function () {
    //     // $('#addPersonModalId').load(('include/addPersonDialog.html',function () {
    //     $('#makeReservationModalId').modal('show');
    //     // });
    // });
    //
    // $('#TableFor2Id').onclick(function () {
    //     // $('#addPersonModalId').load(('include/addPersonDialog.html',function () {
    //     $('#makeReservationModalId').modal('show');
    //     // });
    // });

    /*$('#TableFor6Id').click(function () {
        alert('kljsada');
        var tableId = $('#TableFor6Id').val();
        console.log(tableId);
    })*/
    // $(".tableForFamily").onclick(function () {
    //     $('#makeReservationModalId').modal('show');
    // });


    // $(document).on('click','#tablesListType6Id div', function () {
    //     var fullname = $(this).find('.name').text();
    //     console.logf
    //
    // });


    /*$('#searchBtnId').click(function () {
       var dayDate =  $('#chooseDateBtnId').val();
       var startDate = $('#startTimeId').val();
       var endDate = $('#endTimeId').val();

        // var dayDateString = /!*("0" + *!/dayDate.getDate()/!*).slice(-2)*!/ + "-" + /!*("0"+(*!/(dayDate.getMonth()+1)/!*+1)).slice(-2)*!/ + "-" + dayDate.getFullYear();
        var startTimeString = startDate.getHours() + ":" + startDate.getMinutes();
        var endTimeString = endDate.getHours() + ":" + endDate.getMinutes();
       alert('dayDateString = '+dayDateString + ', startTimeString = ' + startTimeString + ', endTimeString = '+endTimeString);

        $.ajax({
            url: 'findTableByParameter',
            type: 'POST',
            data: {"dayDateString": dayDateString, "startTimeString": startTimeString,"endTimeString":endTimeString},
            success: function () {
            },
            error: function () {
                alert('Have an error!');
            }
        })
    });*/

    $('#searchBtnId').click(function () {

        var reservDate = $(this).attr('reservDate');
        var startTime = $(this).attr('startTime');
        var endTime = $(this).attr('endTime');
    });

    $('.clickForTables').click(function () {

        var tableId = $(this).attr('id');
        globClickedTableId = tableId;
        // var tableType = $(this).attr('type');
        // var tableDescription = $(this).attr('description');
        // $('#newReservationModalId').load('reservationModal.html',function () {
        $('#makeReservationModalId').modal('show');

        // });
        alert(tableId)

    });

    // $('#makeReservationModalId').modal('show');


    $('#addPersonBtnId').click(function () {
        var name = $('#personNameId').val();
        var surname = $('#personSurnameId').val();
        var pin = $('#personPinId').val();
        var startDate = $('#personCreateDateId').val();
        var salary = $('#personSalaryId').val();

        console.log(name);
        console.log(surname);
        console.log(pin);
        console.log(startDate);
        console.log(salary);


        $.ajax({
            url: 'addPerson',
            method: 'POST',
            data: 'name=' + name + '&surname=' + surname + '&pin=' + pin + '&startDate=' + startDate + '&salary=' + salary,
            success: function () {
                $('#showInfo').html('Info added');
                $('#addPersonModalId').modal('hide');
                location.reload();
            }
        })
    });


});




$('#reserveSubmitBtnId').click(function () {
    var type = $('#tableTypeId').val();
    var description = $('#tableDescriptionId').val();


    $.ajax({
        url: 'updateTable',
        method: 'POST',
        data: 'type=' + type + '&description=' + description,
        success: function () {
            $('#showInfo').html('Table is succesfully reserved, wait for submit of admin');
            $('#makeReservationModalId').modal('hide');
            // burda css color(sari) verib rengi deyis ve 2 button var biri make reserve (for user ) biri de Submit(for Admin)
            location.reload();
        }
    })
});
