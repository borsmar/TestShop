function getItemsByCategory(id) {
    $.ajax({
        url: 'http://localhost:8080/api/categories/' + id + '/items',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {


            var i = 0;
            var table = '<table class="table table-dark table-hover"><tr><th>id</th><th>name</th><th>brand</th><th>color</th><th>View</th><th>Delete</th></tr>';
            $.each(data, function (idx, obj) {
                table += ('<tr id="'+obj.id+'">');
                table += ('<td>' + obj.id + '</td>');
                table += ('<td>' + obj.name + '</td>');
                table += ('<td>' + obj.brand + '</td>');
                table += ('<td>' + obj.color + '</td>');
                table += ('<td>' + '<a class="btn btn-primary btn-list" href="http://localhost:8080/GoodsManager/edit?id='+ obj.id +'">EDIT</a>' +'</td>');
                table += ('<td>' + '<a id="deleteGoods" class="btn btn-danger btn-list" onclick="deleteItem('+obj.id+')">DELETE</a>' + '</td>');
                table += ('</tr>');
            });
            table += '</table>';
            $("#tableContainer").html(table);
        }
    });

}