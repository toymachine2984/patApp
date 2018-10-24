function init(data) {
    f(data);
}

var isFirst;
var isLast;
var totalElements;
var totalPages;
var currentNumberOfElements;
var page;

var sort = {};
var pagable = {};


var ajaxOptions = {
    start: 0,
    lenght: 10
};


function getNextPage(element) {
    ajaxOptions.start = $(element).data("page");
    getCompanies();
}

function f(data) {
    processResponceData(data);
    var $nav = $("#nav-group").not($("#item-count"));
    var children = $nav.children();
    if (isFirst) {
        children.first().attr("disabled", true);
        children.last().data("page", page + 1);
    }
    if (isLast) {
        children.last().attr("disabled", true);
        children.first().data("page", page + 1);
    }
    if (!isLast && !isFirst) {
        children.last().attr("disabled", false).data("page", page + 1);
        children.first().attr("disabled", false).data("page", page - 1);
    }
    generateLinks($nav.children().not(":first").not(":last"));
}

function generateLinks(elements) {
    elements.each(function () {
        var $1 = $(this);
        $1.data("page", page);
        $1.text(page + 1);
        page++;
    })
}


function disableLinks(element) {
    element.attr("disabled", true);
}

function enableLinks(element) {
    element.attr("disabled", true);
}

function dataAttrBind(element) {

}


function processResponceData(data) {
    isFirst = data.first;
    isLast = data.last;
    totalElements = parseInt(data.totalElements);
    totalPages = parseInt(data.totalPages);
    page = parseInt(data.number);
}



