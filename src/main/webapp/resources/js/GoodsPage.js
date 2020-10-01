function getBrands(id) {
    let checked = '';

    $('input:checkbox:checked').each(function () {
        checked += ($(this).val());
        checked += ',';
    });

    if (checked === '' || checked === undefined) {
        checked = '';
        $.ajax({
            url: 'http://localhost:8080/api/categories/' + id + '/items/brands',
            type: 'GET',
            dataType: 'json',
            contentType: 'application/json',
            mimeType: 'application/json',
            async: false,
            success: function (data) {
                $.each(data, function (idx, obj) {
                    checked += obj;
                    checked += ',';
                });

            }

        });
    }
    return checked;
}

function countPages(id, inputPrice, outputPrice, checked) {

    let page = localStorage.getItem('page');

    if (page === null || page === '0') {
        page = 1;

    }

    $.ajax({
        url: 'http://localhost:8080/api/categories/' + id + '/items/countPages',
        type: 'GET',
        dataType: "text",
        data: ({
            fromPrice: inputPrice,
            toPrice: outputPrice,
            brands: checked,

        }),
        async: false,
        success: function (data) {
            let Pages = ('');

            let firstPage = interval(page);

            if (data >= (firstPage + 4)) {
                // Pages += ('<li id="li' + (1) + '" class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                // Pages += ('<a id="' + (1) + '" onclick="getSortedItems(' + id + ',$(\'#priceMenu\').val(),$(\'#span\' + 1).text(),' + inputPrice + ',' + outputPrice + ',getBrands(' + id + '))"  class="page-link" aria-label="Previous">');
                // Pages += ('<span id="span' + (1) + '" class="sp" aria-hidden="true">' + (1) + '</span>');
                // Pages += ('</a>');
                // Pages += ('</li>');

                for (let i = 0; i < 5; i++) {
                    Pages += ('<li id="li' + (firstPage + i) + '" class="page-item  number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (firstPage + i) + '" onclick="getSortedItems(' + id + ',$(\'#priceMenu\').val(),$(\'#span\' + ' + (firstPage + i) + ').text(),' + inputPrice + ',' + outputPrice + ',getBrands(' + id + '))"  class="page-link" aria-label="Previous">');
                    Pages += ('<span id="span' + (firstPage + i) + '" class="sp" aria-hidden="true">' + (firstPage + i) + '</span>');
                    Pages += ('</a>');
                    Pages += ('</li>');
                }
            } else if (data < (firstPage + 4)) {
                // Pages += ('<li id="li' + (1) + '" class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                // Pages += ('<a id="' + (1) + '" onclick="getSortedItems(' + id + ',$(\'#priceMenu\').val(),$(\'#span\' + 1).text(),' + inputPrice + ',' + outputPrice + ',getBrands(' + id + '))"  class="page-link" aria-label="Previous">');
                // Pages += ('<span id="span' + (1) + '" class="sp" aria-hidden="true">' + (1) + '</span>');
                // Pages += ('</a>');
                // Pages += ('</li>');


                for (let i = 0; i < data - firstPage + 1; i++) {
                    Pages += ('<li id="li' + (firstPage + i) + '" class="page-item number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (firstPage + i) + '" onclick="getSortedItems(' + id + ',$(\'#priceMenu\').val(),$(\'#span\' + ' + (firstPage + i) + ').text(),' + inputPrice + ',' + outputPrice + ',getBrands(' + id + '))"  class="page-link" aria-label="Previous">');
                    Pages += ('<span id="span' + (firstPage + i) + '" class="sp" aria-hidden="true">' + (firstPage + i) + '</span>');
                    Pages += ('</a>');
                    Pages += ('</li>');
                }
            }
            $('.number').remove();

            $("#first").after(Pages);
        }
    });
}

function getSortedItems(id, sort, page, inputPrice, outputPrice, checked) {
    $.ajax({
        url: 'http://localhost:8080/api/categories/' + id + '/items/' + sort + '/page/' + page,
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        data: ({
            fromPrice: inputPrice,
            toPrice: outputPrice,
            brands: checked,
        }),
        success: function (data) {

            let table = ('');

            $.each(data, function (idx, obj) {
                table += ('<div id="table" class="col-lg-3 col-md-6 mb-4">');
                table += ('<div class="card">');
                table += ('<div class="view overlay">');
                table += ('<img class="card-img-top" src="' + obj.imageURL + '" alt="Iphone">');
                table += ('<a href="/Goods/Item?id=' + obj.id + '">');
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

            $('#showItems').html(table).hide();
            $('#showItems').fadeIn(700);
        }
    });
}

function showBrands(id) {

    $.ajax({
        url: 'http://localhost:8080/api/categories/' + id + '/items/brands',
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        async: false,
        success: function (data) {

            let checkboxes = ('');

            $.each(data, function (idx, obj) {
                checkboxes += ('<div class="custom-control custom-checkbox">');
                checkboxes += ('<span class="float-right badge badge-light round">52</span>');
                checkboxes += ('<input type="checkbox" class="custom-control-input" value="' + obj + '" id="Check' + idx + '">');
                checkboxes += ('<label class="custom-control-label" for="Check' + idx + '">' + obj + '</label>');
                checkboxes += ('</div>');
            });

            $('#brands').append(checkboxes);


        }

    })
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

    localStorage.clear();

    $('input:checked').prop('checked', false);
    $('.custom-checkbox').fadeOut(300, function () {
        $(this).remove();
    });

    showBrands(id);

    $('#hid').replaceWith('<input id="hid" class="hid" type="hidden" value="' + id + '">');

    let page = 1;
    let sort = $('#priceMenu').val();
    let inputPrice = 0;
    let outputPrice = 0;
    let checked = getBrands(id);

    if ($('#inputEmail4').val() !== "") {
        $('#inputEmail4').val('');
    }

    if ($('#inputEmail5').val() !== "") {
        $('#inputEmail5').val('');
    }

    getSortedItems(id, sort, page, 0, 0, checked);
    countPages(id, 0, 0, checked);

    $('#li' + page).addClass('active');

    PageClickListener();
}

function RightArrowClick() {
    let id = $('#hid').val();
    let checked = getBrands(id);


    let inputPrice = 0;
    let outputPrice = 0;

    if ($('#inputEmail4').val() !== "") {
        inputPrice = $('#inputEmail4').val();
    }
    if ($('#inputEmail5').val() !== "") {
        outputPrice = $('#inputEmail5').val();
    }

    $.ajax({
        url: 'http://localhost:8080/api/categories/' + id + '/items/countPages',
        type: 'GET',
        dataType: "text",
        data: ({
            fromPrice: inputPrice,
            toPrice: outputPrice,
            brands: checked,
        }),
        success: function (data) {

            let last = parseInt($('.sp').last().text());

            let remain = data - last;

            let Pages = ('');

            if (remain > 0 && remain <= 5) {


                Pages += ('<li id="li' + (last + 1) + '" class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                Pages += ('<a id="' + (last + 1) + '" onclick="getSortedItems(' + id + ',$(\'#priceMenu\').val(),$(\'#span' + (last + 1) + '\').text(),' + inputPrice + ',' + outputPrice + ',getBrands(' + id + '))"  class="page-link" aria-label="Previous">');
                Pages += ('<span id="span' + (last + 1) + '" class="sp" aria-hidden="true">' + (last + 1) + '</span>');
                Pages += ('</a>');
                Pages += ('</li>');

                let a = last + 1;
                localStorage.setItem('page', '' + a);

                getSortedItems(id, $('#priceMenu').val(), last + 1, inputPrice, outputPrice, checked);

                for (let i = last + 1; i < data; i++) {

                    Pages += ('<li id="li' + (i + 1) + '" class="page-item number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (i + 1) + '" onclick="getSortedItems(' + id + ',$(\'#priceMenu\').val(),$(\'#span' + (i + 1) + '\').text(),' + inputPrice + ',' + outputPrice + ',getBrands(' + id + '))"  class="page-link" aria-label="Previous">');
                    Pages += ('<span id="span' + (i + 1) + '" class="sp" aria-hidden="true">' + (i + 1) + '</span>');
                    Pages += ('</a>');
                    Pages += ('</li>');
                }

                // $("#first").show();
                $('.number').remove();
                // $('#last').hide();
                $("#first").after(Pages);

            } else if (remain > 5) {

                Pages += ('<li id="li' + (last + 1) + '" class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                Pages += ('<a id="' + (last + 1) + '" onclick="getSortedItems(' + id + ',$(\'#priceMenu\').val(),$(\'#span' + (last + 1) + '\').text(),' + inputPrice + ',' + outputPrice + ',getBrands(' + id + '))"  class="page-link" aria-label="Previous">');
                Pages += ('<span id="span' + (last + 1) + '" class="sp" aria-hidden="true">' + (last + 1) + '</span>');
                Pages += ('</a>');
                Pages += ('</li>');


                let a = last + 1;
                localStorage.setItem('page', '' + a);

                getSortedItems(id, $('#priceMenu').val(), last + 1, inputPrice, outputPrice, checked);
                // showItems(id, last + 1);

                for (let i = last + 1; i < last + 5; i++) {
                    Pages += ('<li id="li' + (i + 1) + '" class="page-item number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (i + 1) + '" onclick="getSortedItems(' + id + ',$(\'#priceMenu\').val(),$(\'#span' + (i + 1) + '\').text(),' + inputPrice + ',' + outputPrice + ',getBrands(' + id + '))"  class="page-link" aria-label="Previous">');
                    Pages += ('<span id="span' + (i + 1) + '" class="sp" aria-hidden="true">' + (i + 1) + '</span>');
                    Pages += ('</a>');
                    Pages += ('</li>');
                }

                // $("#first").show();
                $('.number').remove();
                $("#first").after(Pages);
            }
        }
    });
    PageClickListener();
}

function LeftArrowClick() {
    let id = $('#hid').val();

    let checked = getBrands(id);


    let inputPrice = 0;
    let outputPrice = 0;
    if ($('#inputEmail4').val() !== "") {
        inputPrice = $('#inputEmail4').val();
    }
    if ($('#inputEmail5').val() !== "") {
        outputPrice = $('#inputEmail5').val();
    }

    $.ajax({
        url: 'http://localhost:8080/api/categories/' + id + '/items/countPages',
        type: 'GET',
        dataType: "text",
        data: ({
            fromPrice: inputPrice,
            toPrice: outputPrice,
            brands: checked,
        }),
        success: function (data) {

            let first = parseInt($('.sp').first().text());

            let last = parseInt($('.sp').last().text());

            let remain = first;

            let Pages = ('');

            if (remain > 6) {

                // showItems(id, first - 1);
                getSortedItems(id, $('#priceMenu').val(), first - 1, inputPrice, outputPrice, checked);
                for (let i = first - 6; i < first - 2; i++) {


                    Pages += ('<li id="li' + (i + 1) + '" class="page-item number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (i + 1) + '" onclick="getSortedItems(' + id + ',$(\'#priceMenu\').val(),$(\'#span' + (i + 1) + '\').text(),' + inputPrice + ',' + outputPrice + ',getBrands(' + id + '))"  class="page-link" aria-label="Previous">');
                    Pages += ('<span id="span' + (i + 1) + '" class="sp" aria-hidden="true">' + (i + 1) + '</span>');
                    Pages += ('</a>');
                    Pages += ('</li>');
                }

                Pages += ('<li id="li' + (first - 1) + '" class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                Pages += ('<a id="' + (first - 1) + '" onclick="getSortedItems(' + id + ',$(\'#priceMenu\').val(),$(\'#span' + (first - 1) + '\').text(),' + inputPrice + ',' + outputPrice + ',getBrands(' + id + '))"  class="page-link" aria-label="Previous">');
                Pages += ('<span id="span' + (first - 1) + '" class="sp" aria-hidden="true">' + (first - 1) + '</span>');
                Pages += ('</a>');
                Pages += ('</li>');

                let a = first - 1;
                localStorage.setItem('page', '' + a);

                // $("#last").show();
                $('.number').remove();
                $("#first").after(Pages);

            } else if (remain === 6) {

                // showItems(id, first - 1);
                getSortedItems(id, $('#priceMenu').val(), first - 1, inputPrice, outputPrice, checked);

                for (let i = 0; i < remain - 2; i++) {
                    Pages += ('<li id="li' + (i + 1) + '" class="page-item number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (i + 1) + '" onclick="getSortedItems(' + id + ',$(\'#priceMenu\').val(),$(\'#span' + (i + 1) + '\').text(),' + inputPrice + ',' + outputPrice + ',getBrands(' + id + '))"  class="page-link" aria-label="Previous">');
                    Pages += ('<span id="span' + (i + 1) + '" class="sp" aria-hidden="true">' + (i + 1) + '</span>');
                    Pages += ('</a>');
                    Pages += ('</li>');
                }

                Pages += ('<li id="li' + (remain - 1) + '" class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                Pages += ('<a id="' + (remain - 1) + '" onclick="getSortedItems(' + id + ',$(\'#priceMenu\').val(),$(\'#span' + (remain - 1) + '\').text(),' + inputPrice + ',' + outputPrice + ',getBrands(' + id + '))"  class="page-link" aria-label="Previous">');
                Pages += ('<span id="span' + (remain - 1) + '" class="sp" aria-hidden="true">' + (remain - 1) + '</span>');
                Pages += ('</a>');
                Pages += ('</li>');

                let a = first - 1;
                localStorage.setItem('page', '' + a);

                // $("#last").show();
                $('.number').remove();
                $("#last").before(Pages);
                // $("#first").hide();

            }
        }
    });

    PageClickListener();

}

function FilterSubmitButtonClick() {

    localStorage.setItem('inputEmail4', $('#inputEmail4').val());

    localStorage.setItem('inputEmail5', $('#inputEmail5').val());

    localStorage.setItem('page', "1");

    PageClickListener();


    let id = $('#hid').val();
    let page = 1;
    let sort = $('#priceMenu').val();
    let checked = getBrands(id);
    let inputPrice = 0;
    let outputPrice = 0;


    if ($('#inputEmail4').val() !== "") {
        inputPrice = $('#inputEmail4').val();
    }
    if ($('#inputEmail5').val() !== "") {
        outputPrice = $('#inputEmail5').val();
    }

    getSortedItems(id, sort, page, inputPrice, outputPrice, checked);
    countPages(id, inputPrice, outputPrice, checked);
    $('#li' + page).addClass('active');

}

function dropdownItemClick() {

    PageClickListener();

    let id = $('#hid').val();
    let page = 1;
    let sort = $('#priceMenu').val();
    let checked = getBrands(id);
    let inputPrice = 0;
    let outputPrice = 0;

    if ($('#inputEmail4').val() !== "") {
        inputPrice = $('#inputEmail4').val();
    }
    if ($('#inputEmail5').val() !== "") {
        outputPrice = $('#inputEmail5').val();
    }

    getSortedItems(id, sort, page, inputPrice, outputPrice, checked);
    countPages(id, inputPrice, outputPrice, checked);
    localStorage.setItem('page', '1');
    $('#li' + page).addClass('active');
}

function pageOnLoad() {

    let id = $('#hid').val();
    showBrands(id);
    let checked;
    let page = 1;


    if (localStorage.getItem('page') !== null) {
        page = localStorage.getItem('page');
    }

    if (localStorage.getItem('navbarDropdownMenuLink') !== null) {
        $('#navbarDropdownMenuLink').text(localStorage.getItem('navbarDropdownMenuLink'));
    }

    if (localStorage.getItem('priceMenu') !== null) {
        $('#priceMenu').val(localStorage.getItem('priceMenu'));
    } else {
        localStorage.setItem('priceMenu', $('#priceMenu').val());
    }

    let sort = $('#priceMenu').val();
    let inputPrice = 0;
    let outputPrice = 0;

    document.querySelectorAll(".custom-checkbox").forEach(el => {
        el.onchange = () => localStorage.setItem(el.id, el.checked);
        if (localStorage.getItem(el.id) == "true") {
            document.getElementById(el.id).setAttribute('checked', 'checked');
        }
    })

    $('#inputEmail4').val(localStorage.getItem('inputEmail4'));
    $('#inputEmail5').val(localStorage.getItem('inputEmail5'));

    if ($('#inputEmail4').val() !== "") {
        inputPrice = $('#inputEmail4').val();
    }

    if ($('#inputEmail5').val() !== "") {
        outputPrice = $('#inputEmail5').val();
    }

    setTimeout(function () {
        checked = getBrands(id);
    }, 200);

    setTimeout(function () {
        countPages(id, inputPrice, outputPrice, checked);

        $('.page-item').removeClass('active');

        $('#li' + page).addClass('active');

    }, 300);

    setTimeout(function () {
        getSortedItems(id, sort, page, inputPrice, outputPrice, checked);

    }, 300);

    PageClickListener();

    // countPages(id, inputPrice, outputPrice, checked);
    // let page = $('.page-item').find(".sp").text();
    // getSortedItems(id,sort,page,inputPrice,outputPrice,checked  );


}

function PageClickListener() {
    setTimeout(function () {
        document.querySelectorAll('.page-item').forEach(el => {
            el.addEventListener('click', function () {
                localStorage.setItem('page', $('.active').find(".sp").text());
            })
        });

    }, 400);
}

function interval(input) {
    let output;
    if (input % 5 === 0) {
        input = input - 1;
    }

    for (let i = input; ; i--) {
        if (i % 5 === 0) {
            output = i + 1;
            break;
        }
    }
    return output;

}