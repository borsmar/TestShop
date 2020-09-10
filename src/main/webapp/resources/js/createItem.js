function createItem() {

    let id = $("#cat").val();

    var token = $("meta[name='_csrf']").attr("content");


    let goodsDto = {
    'name': $("#name").val(),
    'brand': $("#brand").val(),
    'color': $("#color").val()
    };


    $.ajax({
        url : 'http://localhost:8080/api/categories/'+id+'/items',
        type: 'POST',
        headers: {"X-CSRF-TOKEN": token},
        //  dataType: 'json',
          contentType: 'application/json',
         // mimeType: 'application/json',
        data: JSON.stringify(goodsDto) ,
        success: function () {

            getItemsByCategory(id);

        }
    });

}