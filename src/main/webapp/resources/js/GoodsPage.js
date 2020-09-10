function showItems(id, page) {

    let sort = $('#priceMenu').val();



    $.ajax({
        url: 'http://localhost:8080/api/categories/' + id + '/items/'+ sort +'/page/' + page,
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {

            let table = ('');

            $.each(data, function (idx, obj) {
                table += ('<div id="table" class="col-lg-3 col-md-6 mb-4">');
                table += ('<div class="card">');
                table += ('<div class="view overlay">');
                table += ('<img class="card-img-top" src="' + obj.imageURL + '" alt="Iphone">');
                table += ('<a href="${pageContext.request.contextPath}/Goods/Item?id=' + obj.id + '">');
                table += ('<div class="mask rgba-white-slight"></div>');
                table += ('</a>');
                table += ('</div>');
                table += ('<div class="card-body text-center">');
                table += ('<a href="" class="grey-text">');
                table += ('<h5>' + obj.name + '</h5>');
                table += ('</a>');
                table += ('<h5>');
                table += ('<strong>');
                table += ('<a href="#" class="dark-grey-text">' + obj.brand + '');
                table += ('<span class="badge badge-pill danger-color">NEW</span> </a>');
                table += ('</strong>');
                table += ('</h5>');
                table += ('<h4 class="font-weight-bold blue-text">');
                table += ('<strong>' + obj.price + '</strong>');
                table += ('</h4>');
                table += ('</div>');
                table += ('</div>');
                table += ('</div>');
            });



             // $("#showItems").html(table);

            $('#showItems').html(table);
            $('#showItems').hide();
            $('#showItems').fadeIn(700);

        }

    });

}

$(document).ready(
    function showCategories() {
        $.ajax({
            url: 'http://localhost:8080/api/categories/',
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            success: function (data) {

                let ListCat = ('<li class="nav-item">');
                ListCat += ('<a class="nav-link">All</a>');
                ListCat += ('</li>');

                $.each(data, function (idx, obj) {
                    ListCat += ('<li onclick="CategoryClick(' + obj.id + ')" class="category" class="nav-item">');
                    ListCat += ('<a  class="nav-link">' + obj.name + '</a>');
                    ListCat += ('</li>');
                });

                $("#CategoriesContainer").html(ListCat);

            }
        });

    });

function CategoryClick(id) {
    $('#hid').replaceWith('<input id="hid" class="hid" type="hidden" value="' + id + '">');


    $.ajax({
        url: 'http://localhost:8080/api/categories/' + id + '/items/countPages',
        type: 'GET',
        dataType: "text",
        success: function (data) {

            let Pages = ('');


            if (data <= 5) {

                Pages += ('<li class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                Pages += ('<a id="' + (1) + '" onclick="showItems($(\'#hid\').val(), $(\'#span' + (1) + '\').text())"  class="page-link" aria-label="Previous">');
                Pages += ('<span id="span' + (1) + '" class="sp" aria-hidden="true">' + (1) + '</span>');
                Pages += ('</a>');
                Pages += ('</li>');


                for (let i = 1; i < data; i++) {

                    Pages += ('<li class="page-item  number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (i + 1) + '" onclick="showItems($(\'#hid\').val(), $(\'#span' + (i + 1) + '\').text())"  class="page-link" aria-label="Previous">');
                    Pages += ('<span id="span' + (i + 1) + '" class="sp" aria-hidden="true">' + (i + 1) + '</span>');
                    Pages += ('</a>');
                    Pages += ('</li>');
                }
            } else {

                Pages += ('<li class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                Pages += ('<a id="' + (1) + '" onclick="showItems($(\'#hid\').val(), $(\'#span' + (1) + '\').text())"  class="page-link" aria-label="Previous">');
                Pages += ('<span id="span' + (1) + '" class="sp" aria-hidden="true">' + (1) + '</span>');
                Pages += ('</a>');
                Pages += ('</li>');

                for (let i = 1; i < 5; i++) {

                    Pages += ('<li class="page-item number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (i + 1) + '" onclick="showItems($(\'#hid\').val(), $(\'#span' + (i + 1) + '\').text())"  class="page-link" aria-label="Previous">');
                    Pages += ('<span id="span' + (i + 1) + '" class="sp" aria-hidden="true">' + (i + 1) + '</span>');
                    Pages += ('</a>');
                    Pages += ('</li>');
                }


            }

            $('.number').remove();

            $("#first").after(Pages);
        }
    });

    showItems(id, 1);

}


function RightArrowClick() {

    let id = $('#hid').val();

    $.ajax({
        url: 'http://localhost:8080/api/categories/' + id + '/items/countPages',
        type: 'GET',
        dataType: "text",
        success: function (data) {

            let last = parseInt($('.sp').last().text());

            let remain = data - last;

            let Pages = ('');

            if (remain > 0 && remain <= 5) {

                Pages += ('<li class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                Pages += ('<a id="' + (last + 1) + '" onclick="showItems($(\'#hid\').val(), $(\'#span' + (last + 1) + '\').text())"  class="page-link" aria-label="Previous">');
                Pages += ('<span id="span' + (last + 1) + '" class="sp" aria-hidden="true">' + (last + 1) + '</span>');
                Pages += ('</a>');
                Pages += ('</li>');

                showItems(id, last + 1);

                for (let i = last+1; i < data; i++) {

                    Pages += ('<li class="page-item number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (i + 1) + '" onclick="showItems($(\'#hid\').val(), $(\'#span' + (i + 1) + '\').text())"  class="page-link" aria-label="Previous">');
                    Pages += ('<span id="span' + (i + 1) + '" class="sp" aria-hidden="true">' + (i + 1) + '</span>');
                    Pages += ('</a>');
                    Pages += ('</li>');
                }

                $("#first").show();
                $('.number').remove();
                 $('#last').hide();
                $("#first").after(Pages);

            } else if (remain > 5) {

                Pages += ('<li class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                Pages += ('<a id="' + (last + 1) + '" onclick="showItems($(\'#hid\').val(), $(\'#span' + (last + 1) + '\').text())"  class="page-link" aria-label="Previous">');
                Pages += ('<span id="span' + (last + 1) + '" class="sp" aria-hidden="true">' + (last + 1) + '</span>');
                Pages += ('</a>');
                Pages += ('</li>');

                showItems(id, last + 1);

                for (let i = last+1; i < last + 5; i++) {
                    Pages += ('<li class="page-item number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (i + 1) + '" onclick="showItems($(\'#hid\').val(), $(\'#span' + (i + 1) + '\').text())"  class="page-link" aria-label="Previous">');
                    Pages += ('<span id="span' + (i + 1) + '" class="sp" aria-hidden="true">' + (i + 1) + '</span>');
                    Pages += ('</a>');
                    Pages += ('</li>');
                }

                $("#first").show();
                $('.number').remove();
                $("#first").after(Pages);
            }
        }
    });
}


function LeftArrowClick() {
    let id = $('#hid').val();

    $.ajax({
        url: 'http://localhost:8080/api/categories/' + id + '/items/countPages',
        type: 'GET',
        dataType: "text",
        success: function (data) {

            let first = parseInt($('.sp').first().text());

            let last = parseInt($('.sp').last().text());

            let remain =  first;

            let Pages = ('');

            if (remain > 6) {



                showItems(id, first - 1);

                for (let i = first-6; i < first - 2; i++) {

                    Pages += ('<li class="page-item number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (i + 1) + '" onclick="showItems($(\'#hid\').val(), $(\'#span' + (i + 1) + '\').text())"  class="page-link" aria-label="Previous">');
                    Pages += ('<span id="span' + (i + 1) + '" class="sp" aria-hidden="true">' + (i + 1) + '</span>');
                    Pages += ('</a>');
                    Pages += ('</li>');
                }

                Pages += ('<li class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                Pages += ('<a id="' + (first - 1) + '" onclick="showItems($(\'#hid\').val(), $(\'#span' + (first - 1) + '\').text())"  class="page-link" aria-label="Previous">');
                Pages += ('<span id="span' + (first - 1) + '" class="sp" aria-hidden="true">' + (first - 1) + '</span>');
                Pages += ('</a>');
                Pages += ('</li>');

                $("#last").show();
                $('.number').remove();
                $("#first").after(Pages);

            } else if (remain === 6) {


                showItems(id, first - 1);

                for (let i = 0; i < remain - 2; i++) {
                    Pages += ('<li class="page-item number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (i + 1) + '" onclick="showItems($(\'#hid\').val(), $(\'#span' + (i + 1) + '\').text())"  class="page-link" aria-label="Previous">');
                    Pages += ('<span id="span' + (i + 1) + '" class="sp" aria-hidden="true">' + (i + 1) + '</span>');
                    Pages += ('</a>');
                    Pages += ('</li>');
                }

                Pages += ('<li class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                Pages += ('<a id="' + (remain - 1) + '" onclick="showItems($(\'#hid\').val(), $(\'#span' + (remain - 1) + '\').text())"  class="page-link" aria-label="Previous">');
                Pages += ('<span id="span' + (remain - 1) + '" class="sp" aria-hidden="true">' + (remain - 1) + '</span>');
                Pages += ('</a>');
                Pages += ('</li>');

                $('.number').remove();
                $("#last").before(Pages);
                 $("#first").hide();


            }
        }
    });

}