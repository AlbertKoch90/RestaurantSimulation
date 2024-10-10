function loadMenu(){
    $.get('/dishes', function(dishes) {
        var list = '';
        (dishes || []).forEach(function (dish) {
            list = list
            + '<tr>'
            + '<td>' + dish.name + '</td>'
            + '<td>' + dish.preparationDuration + '</td>'
            + '</tr>'
        });
        if(list.length > 0) {
            list = ''
            + '<table><thead><th>Name</th><th>Preparation Duration</th></thead>'
            + list
            + '</table>';
        } else {
            list = "No dishes in database";
        }
        $('#all-dishes').html(list);
    });
}
