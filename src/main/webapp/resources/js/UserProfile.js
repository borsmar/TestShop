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



            localStorage.setItem('addressesDtos', JSON.stringify(data.addressesDtos));

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

function getAddress(){

    let address = '<div id="tab-pane2" class="tab-pane active" style="display: none">';

    $.each(JSON.parse(localStorage.getItem('addressesDtos')), function (idx, obj) {
        address += '<div id="'+obj.id+'" class="row mt-3 adresses">';
        address += '<div class="col justify-content-center bg-white card addresses-item mb-4 border border-primary shadow">';
        address +='<div class="gold-members p-4">';
        address +='<div class="media">';
        address +='<div class="mr-3"><i class="icofont-ui-home icofont-3x"></i></div>';
        address += '<div class="media-body">';
        address +='<h6 class="mb-1 text-secondary">Home</h6>'
        address +='<p class="text-black">apt '+obj.apt+', building '+obj.building+' , '+obj.street+', '+obj.city+', '+obj.zipCode+','+obj.state+' </p>';
        address +='<p class="mb-0 text-black font-weight-bold"><a class="text-primary mr-3" data-toggle="modal" data-target="#add-address-modal" onclick="editClick('+obj.id+')"><i class="icofont-ui-edit"></i> EDIT</a> <a class="text-danger" data-toggle="modal" data-target="#delete-address-modal" onclick="deleteAddress('+obj.id+')"><i class="icofont-ui-delete"></i> DELETE</a></p></div>';
        address +='</div>';
        address +='</div>';
        address +='</div>';
        address +='</div>';

    });
    address+='<div class="row mt-3"> ';
    address += '<div class="col justify-content-center bg-white mb-4 ">';
    address += '<button id="addbut" class="btn btn-rounded btn-success" onclick="addClick()">add<i class="fas fa-plus pl-1"></i></button>';
    address+='</div>'
    address+='</div>'
    address+='</div>';
    address +='</div>';


    $('#ProfileTab').append(address);
}

function AddressClick(){
    $('.navv').removeClass('active');

    $('#adr').addClass('active');

    $('#tab-pane').fadeOut();

 //   $('#tab-pane2').show();

    $('#tab-pane2').fadeIn();

}


function SettingsClick(){
    $('.navv').removeClass('active');

    $('#set').addClass('active');

    $('#tab-pane2').fadeOut();

    $('#tab-pane').fadeIn();

}

function deleteAddress(id){
    let token = $("meta[name='_csrf']").attr("content");


    let userDto = {
        id: $('#UserId').val(),
    }


    $.ajax({
        url: 'http://localhost:8080/api/current_user/address/'+id,
        type: 'DELETE',
        headers: {"X-CSRF-TOKEN": token},
        contentType: 'application/json',
        data: JSON.stringify(userDto),
        async: false,
        success: function () {

            $("#"+id).fadeOut();

        }
    });
}

function addClick(){

    $('#ProfileTab').append('<div id="addingRow" class="row">\n' +
        '        <div class="col">\n' +
        '    <div class="row">\n' +
        '        <div class="col">\n' +
        '            <div class="form-group">\n' +
        '                <label>Zip</label>\n' +
        '                <input id="Zip" class="form-control" type="text" name="name" placeholder="Zip" >\n' +
        '                    <input id="UserId" type="hidden">\n' +
        '            </div>\n' +
        '        </div>\n' +
        '        <div class="col">\n' +
        '            <div class="form-group">\n' +
        '                <label>Apt</label>\n' +
        '                <input id="Apt" class="form-control" type="text" name="name" placeholder="Apt" >\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="col">\n' +
        '            <div class="form-group">\n' +
        '                <label>Building</label>\n' +
        '                <input id="Building" class="form-control" type="text" name="name" placeholder="Building" >\n' +
        '                    <input id="UserId" type="hidden">\n' +
        '            </div>\n' +
        '        </div>\n' +
        '        <div class="col">\n' +
        '            <div class="form-group">\n' +
        '                <label>City</label>\n' +
        '                <input id="City" class="form-control" type="text" name="name" placeholder="City" >\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="col">\n' +
        '            <div class="form-group">\n' +
        '                <label>State</label>\n' +
        '                <input id="State" class="form-control" type="text" name="name" placeholder="State" >\n' +
        '                    <input id="UserId" type="hidden">\n' +
        '            </div>\n' +
        '        </div>\n' +
        '        <div class="col">\n' +
        '            <div class="form-group">\n' +
        '                <label>Street</label>\n' +
        '                <input id="Street" class="form-control" type="text" name="name" placeholder="Street" >\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '<button class="btn btn-rounded btn-danger" onclick="cancelClick()">Cancel<i class="fas fa-minus pl-1"></i></button>\n' +
        '<button class="btn btn-rounded btn-blue" onclick="confirmClick()">Confirm</button>\n' +
        '        </div>\n' +
        '    </div>');
}

function editClick(id){

    $('#'+id).after('<div id="addingRow" class="row">\n' +
        '        <div class="col">\n' +
        '    <div class="row">\n' +
        '        <div class="col">\n' +
        '            <div class="form-group">\n' +
        '                <label>Zip</label>\n' +
        '                <input id="Zip" class="form-control" type="text" name="name" placeholder="Zip" >\n' +
        '                    <input id="UserId" type="hidden">\n' +
        '            </div>\n' +
        '        </div>\n' +
        '        <div class="col">\n' +
        '            <div class="form-group">\n' +
        '                <label>Apt</label>\n' +
        '                <input id="Apt" class="form-control" type="text" name="name" placeholder="Apt" >\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="col">\n' +
        '            <div class="form-group">\n' +
        '                <label>Building</label>\n' +
        '                <input id="Building" class="form-control" type="text" name="name" placeholder="Building" >\n' +
        '                    <input id="UserId" type="hidden">\n' +
        '            </div>\n' +
        '        </div>\n' +
        '        <div class="col">\n' +
        '            <div class="form-group">\n' +
        '                <label>City</label>\n' +
        '                <input id="City" class="form-control" type="text" name="name" placeholder="City" >\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '    <div class="row">\n' +
        '        <div class="col">\n' +
        '            <div class="form-group">\n' +
        '                <label>State</label>\n' +
        '                <input id="State" class="form-control" type="text" name="name" placeholder="State" >\n' +
        '                    <input id="UserId" type="hidden">\n' +
        '            </div>\n' +
        '        </div>\n' +
        '        <div class="col">\n' +
        '            <div class="form-group">\n' +
        '                <label>Street</label>\n' +
        '                <input id="Street" class="form-control" type="text" name="name" placeholder="Street" >\n' +
        '            </div>\n' +
        '        </div>\n' +
        '    </div>\n' +
        '<button class="btn btn-rounded btn-blue" onclick="updateAddress('+id+')">Update</button>\n' +
        '<button class="btn btn-rounded btn-danger" onclick="cancelClick()">Cancel<i class="fas fa-minus pl-1"></i></button>\n' +
        '        </div>\n' +
        '    </div>');

}

function cancelClick(){
    $('#addingRow').remove();
}

function confirmClick(){

    var token = $("meta[name='_csrf']").attr("content");

    let addressDto = {

        'ZipCode': $("#Zip").val(),

        'apt': $("#Apt").val(),

        'building': $('#Building').val(),

        'city': $("#City").val(),

        'state': $("#State").val(),

        'street': $("#Street").val(),
    };

    let id = $('#UserId').val();

    $.ajax({
        url: 'http://localhost:8080/api/address/'+id,
        type: 'POST',
        headers:{"X-CSRF-TOKEN": token},
        contentType: 'application/json',
        data: JSON.stringify(addressDto),
        async: false,
        success: function () {
            alert('GoodJob');

            $('.adresses').remove();
            $('#addbut').remove();

            $('#addingRow').remove();

            getProfile();

            getAddress();



    }
});



}

function updateAddress(id){
    var token = $("meta[name='_csrf']").attr("content");

    let userId = $('#UserId').val();

    let addressDto = {

        'zipCode': $("#Zip").val(),

        'apt': $("#Apt").val(),

        'building': $('#Building').val(),

        'city': $("#City").val(),

        'state': $("#State").val(),

        'street': $("#Street").val(),
    };

    $.ajax({
        url: 'http://localhost:8080/api/current_user/'+userId+'/address/'+id,
        type: 'PATCH',
        headers:{"X-CSRF-TOKEN": token},
        contentType: 'application/json',
        data: JSON.stringify(addressDto),
        async: false,
        success: function () {
            $('#tab-pane2').remove();

            //$('.adresses').remove();
            // $('#addbut').remove();
            // $('#addingRow').remove();



            getProfile();
            getAddress();

            $('#tab-pane2').show();

        }
    });



}