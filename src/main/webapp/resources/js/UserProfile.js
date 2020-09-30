function getProfile() {

        $.ajax({
            url: 'http://localhost:8080/api/currentUser',
            type: 'GET',
            dataType: 'json',
            mimeType: 'application/json',
            async: false,
            success: function (data) {

                if (data.role_id === 1) {
                    $('#badge').text('administrator');
                }

                $('#username').text('@' + data.username);
                $('#first').val(data.firstName);
                $('#sur').val(data.surName);
                $('#mail').val(data.email);
                $('#user').val(data.username);
                $('#UserId').val(data.id);
            }
        });

}

function update(){

    let id =$('#UserId').val();

    var token = $("meta[name='_csrf']").attr("content");

    let userDto = {
      //  'id': $('#UserId').val(),

        'firstName': $("#first").val(),

        'surName': $("#sur").val(),

        'username': $('#user').val(),

        'email': $("#mail").val()
    };


    $.ajax({
        url: 'http://localhost:8080/api/currentUser/'+id,
        type: 'GET',
        headers: {
            "X-CSRF-TOKEN": token,
        },

       // dataType: 'json',
        contentType: 'json',
       // mimeType: 'application/json',
       // data: JSON.stringify(userDto) ,
        data: ({
            'firstName':  $("#first").val(),
            'surName' : $('#sur').val()
        }),
        success: function (data) {

            getProfile();

    }});

}
