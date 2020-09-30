function getProfile() {

    $.ajax({
        url: 'http://localhost:8080/api/current_user',
        type: 'GET',
        dataType: 'json',
        mimeType: 'application/json',
        async: false,
        success: function (data) {

            if (data.rolesDtos[0]['id'] === 1) {
                $('#badge').text('administrator');
            }

            $('#username').text('@' + data.username);
            $('#first').val(data.firstName);
            $('#sur').val(data.surname);
            $('#mail').val(data.email);
            $('#user').val(data.username);
            $('#UserId').val(data.id);
        }
    });

}

function update() {

    let id = $('#UserId').val();

    var token = $("meta[name='_csrf']").attr("content");

    let userDto = {
        'id': 1,

        'firstName': $("#first").val(),

        'surname': $("#sur").val(),

        'username': $('#user').val(),

        'email': $("#mail").val()
    };


    $.ajax({
        url: 'http://localhost:8080/api/current_user/',
        type: 'PATCH',
        headers:{
            "X-CSRF-TOKEN": token
        },

        // dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        data: JSON.stringify(userDto),
        success: function (data) {

            getProfile();

        }
    });

}
