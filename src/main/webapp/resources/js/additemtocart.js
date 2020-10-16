let counter = 0;

function addItemToCart(id){
    counter++;
    localStorage.setItem(''+counter, id);

}

function showItemsInCart(){

    let items='';
    //for(let i=0; i<counter; i++) {
        $.ajax({
            url: 'http://localhost:8080/api/items/' + 1,
            type: 'GET',
            dataType: 'json',
            async:false,
            success: function (data) {
                items += '<div class="row mb-4">\n' +
                    '                                <div class="col-md-5 col-lg-3 col-xl-3">\n' +
                    '                                    <div class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">\n' +
                    '                                        <img class="img-fluid w-100" src="'+data.imageURL+'" alt="Sample">\n' +
                    '                                        <a href="#!">\n' +
                    '                                            <div class="mask waves-effect waves-light">\n' +
                    '                                                <img class="img-fluid w-100" src="'+data.imageURL+'">\n' +
                    '                                                <div class="mask rgba-black-slight waves-effect waves-light"></div>\n' +
                    '                                            </div>\n' +
                    '                                        </a>\n' +
                    '                                    </div>\n' +
                    '                                </div>\n' +
                    '                                <div class="col-md-7 col-lg-9 col-xl-9">\n' +
                    '                                    <div>\n' +
                    '                                        <div class="d-flex justify-content-between">\n' +
                    '                                            <div>\n' +
                    '                                                <h5>'+data.name+'</h5>\n' +
                    '                                                <p class="mb-3 text-muted text-uppercase small">'+data.category+'</p>\n' +
                    '                                                <p class="mb-2 text-muted text-uppercase small">Color: '+data.color+'</p>\n' +
                    '                                                <p class="mb-3 text-muted text-uppercase small">Brand: '+data.brand+'</p>\n' +
                    '                                            </div>\n' +
                    '                                            <div>\n' +
                    '                                                <div class="def-number-input number-input safari_only mb-0 w-100">\n' +
                    '                                                    <button onclick="this.parentNode.querySelector(\'input[type=number]\').stepDown()" class="minus"></button>\n' +
                    '                                                    <input class="quantity" min="0" name="quantity" value="1" type="number">\n' +
                    '                                                    <button onclick="this.parentNode.querySelector(\'input[type=number]\').stepUp()" class="plus"></button>\n' +
                    '                                                </div>\n' +
                    '                                                <small id="passwordHelpBlock" class="form-text text-muted text-center">\n' +
                    '                                                    (Note, 1 piece)\n' +
                    '                                                </small>\n' +
                    '                                            </div>\n' +
                    '                                        </div>\n' +
                    '                                        <div class="d-flex justify-content-between align-items-center">\n' +
                    '                                            <div>\n' +
                    '                                                <a href="#!" type="button" class="card-link-secondary small text-uppercase mr-3"><i class="fas fa-trash-alt mr-1"></i> Remove item </a>\n' +
                    '                                                <a href="#!" type="button" class="card-link-secondary small text-uppercase"><i class="fas fa-heart mr-1"></i> Move to wish list </a>\n' +
                    '                                            </div>\n' +
                    '                                            <p class="mb-0"><span><strong>'+data.price+'</strong></span></p>\n' +
                    '                                        </div>\n' +
                    '                                    </div>\n' +
                    '                                </div>\n' +
                    '                            </div>'

            }
        });
   // }




$('#number').after(items);


}