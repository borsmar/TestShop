function createCategory() {

    var token = $("meta[name='_csrf']").attr("content");

    let categoryDto = {
        'name': $("#namecat").val()
    };

    $.ajax({
        url : 'http://localhost:8080/api/categories/',
        type: 'POST',
        headers: {"X-CSRF-TOKEN": token},
        contentType: 'application/json',
         // mimeType: 'application/json',
        data: JSON.stringify(categoryDto) ,
        success: function () {

            getCategories();
        }
    });

}