function loadMenuSelectable() {
    $.get('/dishes', function(dishes) {
        var form = '';
        (dishes || []).forEach(function (dish) {
            form = form
            + "<option value='"
            + dish.id
            + "'>"
            + dish.name
            + "</option>"
        });
        if(form.length > 0) {
            form = ""
                + "<form name='Menu' id='menu' method='GET'><label>Please select your dishes</label><br><select name='Order' id='menuselect' size='" + dishes.length + "'>"
            + form
            + "</select> </form> <br> <button type='button' onclick='OnClick()'>Order</button>";// <input type='submit' value='Order'></form>";
        } else
        {
            form = "No dishes in database";
        }
        $('#all-dishes').html(form);
    });
}

function OnClick(){
    var listbox = $('#menuselect');
    $.get('/order', {'id':listbox.val()}, function(result) {
        if(result == "1")
        {
            alert("Order succesful");
        }
        else
        {
            alert("Something wrent wrong");
        }
    });
}
