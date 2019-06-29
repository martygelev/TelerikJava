'use strict';
let apiUrl = 'http://localhost:8080/api/beer/';
$(document).ready(function () {

    $('#add-beer-modal-component').load('../templates/components/AddBeerModal.html #add-beer-modal');
    $('#edit-beer-modal-component').load('../templates/components/EditBeerModal.html #edit-beer-modal');
    $('#confirmation-modal-component').load('../templates/components/ConfirmationModal.html #confirmation-modal');
    $('#info-modal-component').load('../templates/components/InfoModal.html #info-modal');
    $('#view-beer-modal-component').load('../templates/components/ViewBeerModal.html #view-beer-modal');
    $('#rating-modal-component').load('../templates/components/RatingModal.html #rating-modal');

    $('#sort-by-name').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl + '/sort/name');
    });
    $('#sort-by-abv').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl + '/sort/abv');
    });
    $('#sort-by-default').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl);
    });
    $('#sort-by-style-amber').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl + '/filter/style/' + 1);
    });
    $('#sort-by-style-strong').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl + '/filter/style/' + 2);
    });
    $('#sort-by-style-brown').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl+ '/filter/style/' + 3);
    });
    $('#sort-by-style-cream').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl+ '/filter/style/' + 4);
    });
    $('#sort-by-style-golden').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl+ '/filter/style/' + 5);
    });
    $('#filter-by-country-bulgaria').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl+ '/filter/country/' + 33);
    });
    $('#filter-by-country-germany').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl+ '/filter/country/' + 80);
    });
    $('#filter-by-country-netherlands').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl+ '/filter/country/' + 155);
    });
    $('#filter-by-country-denmark').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl+ '/filter/country/' + 56);
    });
    $('#filter-by-country-usa').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl+ '/filter/country/' + 231);
    });
    $('#filter-by-tag-cool').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl+ '/filter/tag/' + 1);
    });
    $('#filter-by-tag-nice').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl+ '/filter/tag/' + 2);
    });
    $('#filter-by-tag-excellent').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl+ '/filter/tag/' + 3);
    });
    $('#filter-by-tag-good').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl+ '/filter/tag/' + 4);
    });
    $('#filter-by-tag-bad').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl+ '/filter/tag/' + 5);
    });
    $('#filter-by-tag-horrible').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl+ '/filter/tag/' + 6);
    });
    $('#filter-by-tag-awful').on('click', function (event) {
        table.clearSort();
        table.setData(apiUrl+ '/filter/tag/' + 7);
    });


});


function wantToDrink(x) {
    x.classList.toggle("fa-thumbs-o-down");
}

function haveDrunk(x) {
    x.classList.toggle("fa-thumbs-down");
}


function editBeer(celldata) {
    document.getElementById('add-beer-form').reset();
    $('#edit-beer-modal').modal();

    $('#edit-beer-name').val(celldata.beerName);
    $('#edit-brewery').val(celldata.brewery);
    $('#edit-abv').val(celldata.abv);
    $('#edit-description').val(celldata.description);
    $('#edit-style').val(celldata.style.id);
    $('#edit-country').val(celldata.country.id);

    $('#edit-beer-form').submit(function (e) {
        e.preventDefault(); // avoid to execute the actual submit of the form.

        let beerId = celldata.id;
        let beerNameTemp = $('#edit-beer-name').val();
        let breweryTemp = $('#edit-brewery').val();
        let abvTemp = $('#edit-abv').val();
        let descriptionTemp = $('#edit-description').val();
        let pictureTemp = celldata.picture;
        let countryTemp = $('#edit-country').val();
        let styleTemp = $('#edit-style').val();

        let payload = {
            'id': beerId,
            'beerName': beerNameTemp,
            'brewery': breweryTemp,
            'abv': abvTemp,
            'description': descriptionTemp,
            'picture': pictureTemp,
            'country': {
                'id': countryTemp
            },
            'style': {
                'id': styleTemp
            }
        };

        let dataString = (JSON.stringify(payload));

        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: 'PUT',
            url: apiUrl + 'update/',
            data: dataString,

            success: function (data) {
                document.getElementById('edit-beer-form').reset();
                table.replaceData();
                $('#edit-beer-modal').modal('hide');
                $('#info-modal').modal();
                document.getElementById('info-modal-text').innerHTML = "Changes saved successfully!"
            },
            error: function (error) {
                document.getElementById('edit-beer-form').reset();
                $('#edit-beer-modal').modal('hide');
                table.replaceData();
                console.log('Error function was triggered from editBeer()');
                console.log(JSON.stringify(error));
            }
        });
    });
}


function addBeer(celldata) {
    $('#beer-name-input').removeClass('error-outline');
    $('#add-beer-modal').modal();
    document.getElementById('add-beer-form').reset();
    $('#add-modal-title').html('Add New Beer');

    $('#add-beer-form').submit(function (e) {
        e.preventDefault(); // avoid to execute the actual submit of the form.

        if(isDuplicated($('#beer-name-input').val())){
            $('#beer-name-input').addClass('error-outline');
            $('#info-modal').modal();
            document.getElementById('info-modal-text').innerHTML = "A beer with that name already exists!"
            return;
        }

        let beerNameTemp = $('#beer-name-input').val();
        let breweryTemp = $('#brewery-input').val();
        let abvTemp = $('#abv-input').val();
        let descriptionTemp = $('#description-input').val();
        let countryTemp = $('#country-input').val();
        let styleTemp = $('#style-input').val();

        let payload = {
            'beerName': beerNameTemp,
            'brewery': breweryTemp,
            'abv': abvTemp,
            'description': descriptionTemp,
            'country': {
                'id': countryTemp
            },
            'style': {
                'id': styleTemp
            }
        };

        let dataString = (JSON.stringify(payload));

        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: 'POST',
            url: apiUrl,
            data: dataString,

            success: function (data) {
                console.log(data);
                table.replaceData();
                document.getElementById('add-beer-form').reset();
                $('#add-beer-modal').modal('hide');
                $('#info-modal').modal();
                document.getElementById('info-modal-text').innerHTML = "A new beer was created!"

            },
            error: function (error) {
                console.log('Error function was triggered from addBeer()');
                console.log(JSON.stringify(error));
                document.getElementById('add-beer-form').reset();
                $('#add-beer-modal').modal('hide');
            }
        });
    });
}


function deleteBeer(id, name) {

    $('#confirmation-modal').modal();
    $('#confirmation-yes').on('click', function (event) {
        $.ajax({
            url: apiUrl + 'delete/' + id + "/",
            type: 'DELETE',
            data: '_method=DELETE',
            success: function () {
                $('#info-modal').modal();
                document.getElementById('info-modal-text').innerHTML = "Beer with name " + name + " was deleted!"
                table.replaceData();

            },
            error: function (error) {
                console.log('Error function was triggered from deleteBeer()');
                console.log(JSON.stringify(error));
            }
        });
    });
}


function rateBeer(beerId) {
    $('#rating-modal').modal();
    $(':radio').change(function() {
        let rating = this.value;

        $.ajax({
            url: 'http://localhost:8080/api/user/rate/1/' + beerId + "/" + rating,
            type: 'PUT',
            data: '_method=PUT',
            success: function () {
                $('#rating-modal').modal('hide');
                $('#info-modal').modal();
                document.getElementById('info-modal-text').innerHTML = "You rated this beer: " + rating + "!";
                table.replaceData();
            },
            error: function (error) {
                console.log('Error function was triggered from rateBeer()');
                console.log(JSON.stringify(error));
            }
        });
    });
}

function searchBeers() {
    $('#info-modal').modal();
    document.getElementById('info-modal-text').innerHTML = "Search function is under construction!";
}

function isDuplicated(name) {
    let dataValues = table.getData();
    let arrayLength = dataValues.length;
    for (let i = 0; i < arrayLength; i++) {
        if (dataValues[i].beerName.toUpperCase() === name.toUpperCase()) {
            return true;
        }
    }
    return false;
}

let table = new Tabulator("#beers-table", {

    height: 760,
    ajaxURL: apiUrl,
    layout: "fitColumns",
    pagination: "local",
    paginationSize: 5,
    placeholder: "No beers match your query. Refine your search and try again!",
    footerElement: "<span id='add-beer-span'><button id='add-beer-button' type='button' class='btn btn-success' onclick='addBeer()'>Add Beer</button></span>",
    columns: [
        {
            title: "Picture", field: "picture", width: "110", formatter: "image", headerSort: false,
            formatterParams: {height: "130px", width: "100px"},
            mutator: function (value) {
                if (value === null) {
                    return "../images/default_image.jpg";
                } else {
                    return "../images/" + value;
                }
            }
        },
        {title: "Name", field: "beerName", align: "left"},
        {title: "ABV", field: "abv", width: "65", align: "left"},
        {title: "Brewery", field: "brewery", align: "left", formatter: "textarea"},
        {title: "Country", field: "country.name"},
        {title: "Rating", field: "avg", width: "100", formatter: "star",cellClick: function (e, cell) {
                e.stopPropagation();
                rateBeer(cell.getRow().getData().id);
            }},
        {title: "Style", field: "style.typeOfStyle"},
        {
            headerSort: false, align: "center", formatter: function (cell, formatterParams, onRendered) {
                return "<button class='btn btn-info'>Edit Beer</button>"
            }, cellClick: function (e, cell) {
                e.stopPropagation();
                editBeer(cell.getRow().getData());
            }
        },
        {
            headerSort: false, align: "center", formatter: function (cell, formatterParams, onRendered) {
                return "<button class='btn btn-danger'>Delete Beer</button>"
            }, cellClick: function (e, cell) {
                e.stopPropagation();
                deleteBeer(cell.getRow().getData().id, cell.getRow().getData().beerName);
            }
        }
    ],

    rowClick: function (e, row) {
        $('#view-beer-modal').modal();
        document.getElementById('beer-header').innerHTML = row.getData().id;
        document.getElementById('beer-image').src = "" + row.getData().picture;
        document.getElementById('beer-name').innerHTML = row.getData().beerName;
        document.getElementById('brewery-name').innerHTML = row.getData().brewery;
        document.getElementById('country-name').innerHTML = row.getData().country.name;
        document.getElementById('description').innerHTML = row.getData().description;
    },
});






