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

            $('#name').text(data.firstName +" "+ data.surname);
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

        'firstName': $("#first").val(),

        'surname': $("#sur").val(),

        'username': $('#user').val(),

        'email': $("#mail").val()
    };


    $.ajax({
        url: 'http://localhost:8080/api/current_user/'+id,
        type: 'PATCH',
        headers:{
            "X-CSRF-TOKEN": token
        },

        contentType: 'application/json',
        mimeType: 'application/json',
        data: JSON.stringify(userDto),
        success: function () {


            getProfile();

        }
    });

}

function changePassword() {
    let token = $("meta[name='_csrf']").attr("content");

    let currentPassword = $('#current').val();
    let newPassword = $('#new').val();
    let username = $('#user').val();
    let confirm = $('#confirm').val();

    if(newPassword === confirm) {
        $.ajax({
            url: 'http://localhost:8080/api/updateuser',
            type: 'GET',
            headers: {
                "X-CSRF-TOKEN": token
            },
            data: ({
                username: username,
                password: newPassword,
                currentPassword: currentPassword,
            }),
            success: function () {

                getProfile();

            }
        });
    }
    else {
        alert('Passwords are different, try again');
    }
}
