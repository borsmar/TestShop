function getBrands(id) {
    let checked='';

    $('input:checkbox:checked').each(function () {
        checked += ($(this).val());
        checked += ',';
    });

    if (checked === '' || checked === undefined){
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





                $.ajax({
                    url: 'http://localhost:8080/api/categories/' + id + '/items/countPages',
                    type: 'GET',
                    dataType: "text",
                    data : ({
                        fromPrice: inputPrice,
                        toPrice: outputPrice,
                        brands: checked,

                    }),
                    async: false,
                    success: function (data) {
                        let Pages = ('');



                        if (data <= 5) {
                            Pages += ('<li class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                            Pages += ('<a id="' + (1) + '" onclick="getSortedItems('+id+',$(\'#priceMenu\').val(),$(\'#span\' + 1).text(),'+inputPrice+','+outputPrice+',getBrands('+id+'))"  class="page-link" aria-label="Previous">');
                            Pages += ('<span id="span' + (1) + '" class="sp" aria-hidden="true">' + (1) + '</span>');
                            Pages += ('</a>');
                            Pages += ('</li>');

                            for (let i = 1; i < data; i++) {
                                Pages += ('<li class="page-item  number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                                Pages += ('<a id="' + (i + 1) + '" onclick="getSortedItems('+id+',$(\'#priceMenu\').val(),$(\'#span\' + '+(i+1)+').text(),'+inputPrice+','+outputPrice+',getBrands('+id+'))"  class="page-link" aria-label="Previous">');
                                Pages += ('<span id="span' + (i + 1) + '" class="sp" aria-hidden="true">' + (i + 1) + '</span>');
                                Pages += ('</a>');
                                Pages += ('</li>');
                            }
                        } else {
                            Pages += ('<li class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                            Pages += ('<a id="' + (1) + '" onclick="getSortedItems('+id+',$(\'#priceMenu\').val(),$(\'#span\' + 1).text(),'+inputPrice+','+outputPrice+',getBrands('+id+'))"  class="page-link" aria-label="Previous">');
                            Pages += ('<span id="span' + (1) + '" class="sp" aria-hidden="true">' + (1) + '</span>');
                            Pages += ('</a>');
                            Pages += ('</li>');

                            for (let i = 1; i < 5; i++) {
                                Pages += ('<li class="page-item number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                                Pages += ('<a id="' + (i + 1) + '" onclick="getSortedItems('+id+',$(\'#priceMenu\').val(),$(\'#span\' + '+(i+1)+').text(),'+inputPrice+','+outputPrice+',getBrands('+id+'))"  class="page-link" aria-label="Previous">');
                                Pages += ('<span id="span' + (i + 1) + '" class="sp" aria-hidden="true">' + (i + 1) + '</span>');
                                Pages += ('</a>');
                                Pages += ('</li>');
                            }
                        }
                        $('.number').remove();

                        $("#first").after(Pages);
                    }
                });
}

function getSortedItems(id,sort,page,inputPrice,outputPrice,checked) {
    $.ajax({
        url: 'http://localhost:8080/api/categories/' + id + '/items/'+ sort +'/page/' + page,
        type: 'GET',
        dataType: 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        data : ({
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
                checkboxes+=('<div class="custom-control custom-checkbox">');
                checkboxes+=('<span class="float-right badge badge-light round">52</span>');
                checkboxes+=('<input type="checkbox" class="custom-control-input" value="'+obj+'" id="Check'+idx+'">');
                checkboxes+=('<label class="custom-control-label" for="Check'+idx+'">'+obj+'</label>');
                checkboxes+=('</div>');
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

    $('input:checked').prop('checked', false);
    $('.custom-checkbox').fadeOut(300, function(){ $(this).remove();});

    showBrands(id);

    $('#hid').replaceWith('<input id="hid" class="hid" type="hidden" value="' + id + '">');

    let page = 1;
    let sort = $('#priceMenu').val();
    let inputPrice;
    let outputPrice;
    let checked = getBrands(id);

    if($('#inputEmail4').val() !== ""){
        inputPrice = $('#inputEmail4').val();
    }
    else {
         inputPrice = 0;
    }

    if($('#inputEmail5').val() !== ""){
        outputPrice = $('#inputEmail5').val();
    }
    else {
         outputPrice = 0;
    }

    // showItems(id, 1);
    getSortedItems(id,sort,page,inputPrice,outputPrice,checked);
    countPages(id, inputPrice, outputPrice, checked);



}

function RightArrowClick() {
    let id = $('#hid').val();
    let checked = getBrands(id);


    let inputPrice = 0;
    let outputPrice = 0;

    if($('#inputEmail4').val() !== ""){
        inputPrice = $('#inputEmail4').val();
    }
    if($('#inputEmail5').val() !== ""){
        outputPrice = $('#inputEmail5').val();
    }

    $.ajax({
        url: 'http://localhost:8080/api/categories/' + id + '/items/countPages',
        type: 'GET',
        dataType: "text",
        data : ({
            fromPrice: inputPrice,
            toPrice: outputPrice,
            brands: checked,
        }),
        success: function (data) {

            let last = parseInt($('.sp').last().text());

            let remain = data - last;

            let Pages = ('');

            if (remain > 0 && remain <= 5) {


                Pages += ('<li class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                Pages += ('<a id="' + (last + 1) + '" onclick="getSortedItems('+id+',$(\'#priceMenu\').val(),$(\'#span' + (last + 1) + '\').text(),'+inputPrice+','+outputPrice+',getBrands('+id+'))"  class="page-link" aria-label="Previous">');
                Pages += ('<span id="span' + (last + 1) + '" class="sp" aria-hidden="true">' + (last + 1) + '</span>');
                Pages += ('</a>');
                Pages += ('</li>');

                // showItems(id, last + 1);
                getSortedItems(id, $('#priceMenu').val(),last + 1, outputPrice, inputPrice, checked);

                for (let i = last+1; i < data; i++) {

                    Pages += ('<li class="page-item number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (i + 1) + '" onclick="getSortedItems('+id+',$(\'#priceMenu\').val(),$(\'#span' + (i + 1) + '\').text(),'+inputPrice+','+outputPrice+',getBrands('+id+'))"  class="page-link" aria-label="Previous">');
                    Pages += ('<span id="span' + (i + 1) + '" class="sp" aria-hidden="true">' + (i + 1) + '</span>');
                    Pages += ('</a>');
                    Pages += ('</li>');
                }

                // $("#first").show();
                $('.number').remove();
                 // $('#last').hide();
                $("#first").after(Pages);

            } else if (remain > 5) {

                Pages += ('<li class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                Pages += ('<a id="' + (last + 1) + '" onclick="getSortedItems('+id+',$(\'#priceMenu\').val(),$(\'#span' + (last + 1) + '\').text(),'+inputPrice+','+outputPrice+',getBrands('+id+'))"  class="page-link" aria-label="Previous">');
                Pages += ('<span id="span' + (last + 1) + '" class="sp" aria-hidden="true">' + (last + 1) + '</span>');
                Pages += ('</a>');
                Pages += ('</li>');

                getSortedItems(id, $('#priceMenu').val(),last + 1, outputPrice, inputPrice, checked);
                // showItems(id, last + 1);

                for (let i = last+1; i < last + 5; i++) {
                    Pages += ('<li class="page-item number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (i + 1) + '" onclick="getSortedItems('+id+',$(\'#priceMenu\').val(),$(\'#span' + (i + 1) + '\').text(),'+inputPrice+','+outputPrice+',getBrands('+id+'))"  class="page-link" aria-label="Previous">');
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
}

function LeftArrowClick() {
    let id = $('#hid').val();

    let checked= getBrands(id);



    let inputPrice = 0;
    let outputPrice = 0;
    if($('#inputEmail4').val() !== ""){
        inputPrice = $('#inputEmail4').val();
    }
    if($('#inputEmail5').val() !== ""){
        outputPrice = $('#inputEmail5').val();
    }

    $.ajax({
        url: 'http://localhost:8080/api/categories/' + id + '/items/countPages',
        type: 'GET',
        dataType: "text",
        data : ({
            fromPrice: inputPrice,
            toPrice: outputPrice,
            brands: checked,
        }),
        success: function (data) {

            let first = parseInt($('.sp').first().text());

            let last = parseInt($('.sp').last().text());

            let remain =  first;

            let Pages = ('');

            if (remain > 6) {

                // showItems(id, first - 1);
                getSortedItems(id, $('#priceMenu').val(),first - 1, outputPrice, inputPrice, checked);
                for (let i = first-6; i < first - 2; i++) {



                    Pages += ('<li class="page-item number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (i + 1) + '" onclick="getSortedItems('+id+',$(\'#priceMenu\').val(),$(\'#span' + (i + 1) + '\').text(),'+inputPrice+','+outputPrice+',getBrands('+id+'))"  class="page-link" aria-label="Previous">');
                    Pages += ('<span id="span' + (i + 1) + '" class="sp" aria-hidden="true">' + (i + 1) + '</span>');
                    Pages += ('</a>');
                    Pages += ('</li>');
                }

                Pages += ('<li class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                Pages += ('<a id="' + (first - 1) + '" onclick="getSortedItems('+id+',$(\'#priceMenu\').val(),$(\'#span' + (first - 1) + '\').text(),'+inputPrice+','+outputPrice+',getBrands('+id+'))"  class="page-link" aria-label="Previous">');
                Pages += ('<span id="span' + (first - 1) + '" class="sp" aria-hidden="true">' + (first - 1) + '</span>');
                Pages += ('</a>');
                Pages += ('</li>');

                // $("#last").show();
                $('.number').remove();
                $("#first").after(Pages);

            } else if (remain === 6) {

                // showItems(id, first - 1);
                getSortedItems(id, $('#priceMenu').val(),first - 1, outputPrice, inputPrice, checked);

                for (let i = 0; i < remain - 2; i++) {
                    Pages += ('<li class="page-item number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                    Pages += ('<a id="' + (i + 1) + '" onclick="getSortedItems('+id+',$(\'#priceMenu\').val(),$(\'#span' + (i + 1) + '\').text(),'+inputPrice+','+outputPrice+',getBrands('+id+'))"  class="page-link" aria-label="Previous">');
                    Pages += ('<span id="span' + (i + 1) + '" class="sp" aria-hidden="true">' + (i + 1) + '</span>');
                    Pages += ('</a>');
                    Pages += ('</li>');
                }

                Pages += ('<li class="page-item active number" onclick="$(\'.page-item\').removeClass(\'active\'); $(this).addClass(\'active\')">');
                Pages += ('<a id="' + (remain - 1) + '" onclick="getSortedItems('+id+',$(\'#priceMenu\').val(),$(\'#span' + (remain - 1) + '\').text(),'+inputPrice+','+outputPrice+',getBrands('+id+'))"  class="page-link" aria-label="Previous">');
                Pages += ('<span id="span' + (remain - 1) + '" class="sp" aria-hidden="true">' + (remain - 1) + '</span>');
                Pages += ('</a>');
                Pages += ('</li>');

                // $("#last").show();
                $('.number').remove();
                $("#last").before(Pages);
                 // $("#first").hide();

            }
        }
    });

}

function FilterSubmitButtonClick(){

    let id = $('#hid').val();
    let page = 1;
    let sort = $('#priceMenu').val();
    let checked = getBrands(id);
    let inputPrice = 0;
    let outputPrice = 0;
    if($('#inputEmail4').val() !== ""){
        inputPrice = $('#inputEmail4').val();
    }
    if($('#inputEmail5').val() !== ""){
        outputPrice = $('#inputEmail5').val();
    }

    getSortedItems(id,sort,page,inputPrice,outputPrice,checked);
    countPages(id, inputPrice, outputPrice, checked);

}

function dropdownItemClick() {

    let id = $('#hid').val();
    let page = 1;
    let sort = $('#priceMenu').val();
    let checked = getBrands(id);
    let inputPrice = 0;
    let outputPrice = 0;
    if($('#inputEmail4').val() !== ""){
        inputPrice = $('#inputEmail4').val();
    }
    if($('#inputEmail5').val() !== ""){
        outputPrice = $('#inputEmail5').val();
    }

    getSortedItems(id,sort,page,inputPrice,outputPrice,checked);
}

function pageOnLoad(){
    let id = $('#hid').val();
    showBrands(id);
    document.getElementById('Check1').onclick = function() {
        if(document.getElementById('Check1').checked) {
            localStorage.setItem('Check1', "true");
        } else {
            localStorage.setItem('Check1', "false");
        }
    }
    if (localStorage.getItem('Check1') == "true") {
        document.getElementById("Check1").setAttribute('checked','checked');
    }
    let sort = $('#priceMenu').val();
    let checked = getBrands(id);
    let inputPrice = 0;
    let outputPrice = 0;
    if($('#inputEmail4').val() !== ""){
        inputPrice = $('#inputEmail4').val();
    }
    if($('#inputEmail5').val() !== ""){
        outputPrice = $('#inputEmail5').val();
    }
    countPages(id, inputPrice, outputPrice, checked);

    let page = $('.active').find(".sp").text();

    getSortedItems(id,sort,page,inputPrice,outputPrice,checked);


}