/**
 * Created by lzakharov on 30.10.15.
 */

$("#registration-form").submit(function() {
    alert( "Handler for .submit() called." );
    return false;
});

// поля, обязательные для заполнения
var fields = new Array("username", "first_name", "last_name", "password", "email");

$("form").submit(function() {
        var error = 0;

        for(var i = 0; i < fields.length; i++) {
            var input = $("#" + fields[i]);
            var group = $("#" + fields[i] + "-group");
            if(!input.val()) {
                group.attr('class', 'form-group has-success');
                error = 1;
            } else {
                group.attr('class', 'form-group');
                error = 0;
            }
        }


        if (error == 0) {
            return true;
        } else {
            var error_msg = "";
            $("#error_msg").html(error_msg);
        }
    }
);
