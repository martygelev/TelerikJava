$(document).ready(function () {
    var urlBuilder = (() => {
        var defaultPerPage = 6;
        var endPoint = 'http://localhost:8080/api/beer';
        var pageNum = '';
        var currentPage = 0;
        var perPageCount = '';
        var beerName = '';

        var buildURL = function (urlParams) {
            beerName = '';

            setCurrentPage(urlParams.pageNumParam);
            setDefaultPerPage(urlParams.perPageCountParam);
            setBeerName(urlParams.beerNameParam);


            var query = 'beers?' + pageNum + perPageCount;
            if (beerName != '') {
                query += '&beer_name=' + beerName;
            }


            var newURL = new URL(endPoint + query);
            return newURL;
        }

        var getCurrentPage = function () {
            return parseInt(currentPage);
        }

        var setCurrentPage = function (currentPageNum) {
            if (currentPageNum > 1) {
                pageNum = 'page=' + currentPageNum;
                currentPage = currentPageNum
            } else {
                pageNum = 'page=' + 1;
                currentPage = 1;
            }
        }

        var getDefaultPerPage = function () {
            return defaultPerPage;
        }

        var setDefaultPerPage = function (newDefaultPerPage) {
            if (newDefaultPerPage != defaultPerPage) {
                perPageCount = '&per_page=' + newDefaultPerPage;
            } else {
                perPageCount = '&per_page=' + defaultPerPage;
            }
        }

        var getBeerName = function () {
            return beerName;
        }

        var setBeerName = function (newBeerName) {
            if (newBeerName === undefined || newBeerName === '') {
                beerName = '';
            } else {
                beerName = newBeerName;
            }
        }

        return {
            setCurrentPage,
            getCurrentPage,
            getDefaultPerPage,
            setBeerName,
            getBeerName,
            buildURL
        }
    })();

    var beers = [];
    var $beerContainer = $("#beers-container");
    var favoriteHandler = (() => {
        var toggleFavourite = function (beerid) {
            var $beer = $("#" + beerid);
            var $favIcon = $("#" + beerid + " .favourite-holder");
            if ($beer.hasClass("favourite")) {
                $beer.removeClass("favourite");
                $favIcon.animate({
                    "background-position": "0px"
                }, 300, function () {});
            } else {
                $beer.addClass("favourite");
                $favIcon.animate({
                    "background-position": "-43px"
                }, 300, function () {});
            }
        }

        var displayFavouritesOnly = false;
        $("a#favourites-call").on("click", function (element) {
            element.preventDefault();
            var $beerBox = $(".beer-box");

            if (!displayFavouritesOnly) {
                $beerBox.each(function () {
                    if (!$(this).hasClass("favourite")) {
                        $(this).hide();
                    }
                });
                displayFavouritesOnly = true;
            } else {
                $beerBox.show();
                displayFavouritesOnly = false;
            }
        });

        return {
            toggleFavourite
        }
    })();

    var $previous = $(".previous");
    var $next = $(".next");
    var loader = (() => {
        var $loadingMessage = "<p class='loading-message'><i class='fas fa-spinner'></i> We are getting your beers...</p>";
        var $noResultMessage = "<div class='no-result-message'><p><i class='far fa-frown'></i> Sorry</p><p>No beers have been found.</p></div>"
        var beersCount;
        var loadBeersFromJSON = function (url) {
            $beerContainer.html($loadingMessage);
            $.getJSON(url, function (data) {
                beers = [];
                beers.push(data);
                beersCount = beers[0].length;
                if (beersCount > 1) {
                    readBeers(beers);
                    $(".loading-message").remove();
                } else {
                    console.log("No beers :(");
                    beersCount = 0;
                    $beerContainer.html($noResultMessage);
                }
                paging.initializePaging();
            }, "jsonp");

        };

        var populateBeerContainer = function (beer) {
            $beerContainer.append(
                $("<article></article>")
                    .addClass("beer-box")
                    .attr("id", beer.id)
            );

            var $article = $(".beer-box#" + beer.id);

            $article.append(
                $("<div></div>")
                    .addClass("favourite-holder")
                    .on("click", function () {
                        var $beerid = $(this).parent().attr("id");
                        favoriteHandler.toggleFavourite($beerid);
                    })
            );


            $article.append($("<img />")
                .attr("src", beer.image_url)
                .attr("alt", beer.name)
            );

            $article.append(
                $("<h1></h1>")
                    .addClass("beer-name")
                    .html(beer.name)
            );

            $article.append($("<h2></h2>")
                .addClass("center")
                .html(beer.tagline)
            );

            $article.append(
                $("<div></div>")
                    .addClass("beer-abv")
                    .html("ABV: " + beer.abv)
            );

            $article.append(
                $("<a></a>")
                    .addClass("more-info")
                    .attr("href", "")
                    .html("more info")
                    .on("click", function (e) {
                        e.preventDefault();
                        var $beerid = $(this).parent().attr("id");
                        modal.populateModal($beerid);
                        modal.openModal($beerid);
                    })

            );

            $(".beer-box img").on("click", function (e) {
                e.preventDefault();
                var $beerid = $(this).parent().attr("id");
                modal.populateModal($beerid);
                modal.openModal($beerid);
            });
        }

        function readBeers(beers) {
            if (beers) {
                for (var i = 0; i < beers[beers.length - 1].length; i++) {
                    var beer = beers[beers.length - 1][i];
                    populateBeerContainer(beer);
                }
            }
        };

        return {
            beersCount,
            loadBeersFromJSON
        }
    })();

    var $modal = $(".modal-background");
    var $content = $(".modal-content");
    var modal = (() => {
        var getBeer = function (beerid) {
            for (var i = 0; i < beers[0].length; i++) {
                var beer = beers[0][i];
                if (beer.id == beerid) {
                    return beer;
                }
            }
        }

        var populateModal = function (beerid) {
            $modal.attr("id", beerid);
            var beerItem = getBeer(beerid);
            $(".modal-content .beer-name").html(beerItem.name);
            $(".modal-content .modal-img")
                .attr("src", beerItem.image_url);
            $(".modal-content h2").html(beerItem.tagline);
            $(".modal-content .beer-abv").html("ABV: " + beerItem.abv);
            $(".modal-content .beer-description").html(beerItem.description);
        }

        var openModal = function (beerid) {
            $modal.fadeIn(300);
            $content.fadeIn(300);
        }

        var closeHandler = function (event) {
            var target = $(event.target);
            if (target.is($modal) || event.keyCode === 27) {
                $content.fadeOut(300);
                $modal.fadeOut(300);
            };
        };

        return {
            $modal,
            populateModal,
            openModal,
            closeHandler
        }
    })();

    var paging = (() => {
        var disablePaging = function ($element) {
            $element.addClass("disabled");
            $element.on("click", function (event) {
                event.preventDefault();
            });
        }

        var initializePaging = function () {
            if (urlBuilder.getCurrentPage() === 1) {
                disablePaging($previous);
            }

            if (urlBuilder.getCurrentPage() > 1) {
                $previous.removeClass("disabled");
            }

            if (loader.beersCount < urlBuilder.getDefaultPerPage) {
                disablePaging($next);
            }
        }

        var getPage = function (direction) {
            var newPage = parseInt(urlBuilder.getCurrentPage()) + parseInt(direction);
            urlBuilder.setCurrentPage(newPage);
            var urlObj = {
                pageNumParam: newPage,
                perPageCountParam: urlBuilder.getDefaultPerPage(),
                beerNameParam: urlBuilder.getBeerName(),
            };

            url = urlBuilder.buildURL(urlObj);
            $beerContainer.empty;
            loader.loadBeersFromJSON(url);
            initializePaging();
        }

        return {
            getPage,
            initializePaging,
        }
    })();

    var searcher = (() => {
        var $searchInput = $("#search-input");

        var searchByName = function (element, option) {
            var nameValue = element.val();
            var $name = nameValue.split(' ').join('_');
            console.log($name);
            var urlObj = {
                pageNumParam: 1,
                perPageCountParam: urlBuilder.getDefaultPerPage(),
                beerNameParam: '',
            };

            $beerContainer.empty();

            if (option === 'beer') {

                urlObj.beerNameParam = $name;
                urlBuilder.setBeerName($name);
            }

            url = urlBuilder.buildURL(urlObj);
            loader.loadBeersFromJSON(url);
        };

        var excuteSearch = function (event) {
            if (event) {
                event.preventDefault();
            }

            $selectedOption = $(".search-option:checked").attr("id");
            var option = 0;
            if ($selectedOption === "search-for-beer") {
                option = "beer";
            }

            searchByName($searchInput, option);
        };

        return {
            excuteSearch
        }
    })();


    var urlObj = {
        pageNumParam: urlBuilder.getCurrentPage(),
        perPageCountParam: urlBuilder.getDefaultPerPage(),
        beerNameParam: urlBuilder.getBeerName(),
    };
    var url = urlBuilder.buildURL(urlObj);
    loader.loadBeersFromJSON(url);

    $previous.on("click", function (event) {
        event.preventDefault();
        paging.getPage(-1);
    });
    $next.on("click", function (event) {
        event.preventDefault();
        paging.getPage(1);
    });


    $modal.on("click", modal.closeHandler);
    $(document).on("keyup", function (event) {
        if (event.keyCode === 27) {
            console.log("here");
            modal.closeHandler(event);
        }
    });

    var $search = $("#search");
    $search.on("click", searcher.excuteSearch);
    $(document).on("keyup", function (event) {
        if (event.keyCode === 13) {
            searcher.excuteSearch();
        }
    });

    $('a[href="#top"]').on('click', function (e) {
        e.preventDefault();
        $('html, body').animate({
            scrollTop: $("#top").offset().top
        }, 500, 'swing');
    });

    $('a[href="#features-anchor"]').on('click', function (e) {
        e.preventDefault();
        $('html, body').animate({
            scrollTop: $("#features-anchor").offset().top
        }, 500, 'swing');
    });
});