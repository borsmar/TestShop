function deleteCategory(id) {
    var token = $("meta[name='_csrf']").attr("content");


    $.ajax({
        url: 'http://localhost:8080/api/categories/' + id,
        type: 'DELETE',
        headers: {"X-CSRF-TOKEN": token},
        success: function () {
            $("#" + id).hide(500);
        }
    });
}