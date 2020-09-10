
    function getCategories(){
    $.ajax({
        url : 'http://localhost:8080/api/categories/',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {

            var options;

            var tableCat ='<table class="table table-dark table-hover"><tr><th>id</th><th>name</th><th>View</th><th>Delete</th></tr>';

            $.each(data, function (idx, obj) {


                options += ("<option id='"+obj.id+"'  value='"+ obj.id + "'> "+ obj.name +" </option>");

                tableCat += ('<tr>');
                tableCat += ('<td>' + obj.id + '</td>');
                tableCat += ('<td>' + obj.name + '</td>');
                tableCat += ('<td>' + '<a class="btn btn-primary btn-list" href="http://localhost:8080/GoodsManager/edit?id='+ obj.id +'">EDIT</a>' +'</td>');
                tableCat += ('<td>' + '<a id="deleteCat" class="btn btn-danger btn-list" onclick="deleteCategory('+obj.id+')">DELETE</a>' + '</td>');
                tableCat += ('</tr>');

            });

            tableCat += '</table>';

            $("#TableCatContainer").html(tableCat);

            $("#cat").html(options);
        }
    });
}
