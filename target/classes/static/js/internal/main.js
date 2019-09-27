$(function () {
    $('#tablesDataTableId').dataTable();
    // $('.datepicker').datepicker({dateFormat: 'yy-MM-dd'});

    $('.clockpicker').clockpicker();



    // $('.redTable').disabled(true);
    // $('.yellowTable').disabled(true);
});

function edit(id) {
    console.log('id: ' +id);
}