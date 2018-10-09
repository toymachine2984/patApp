$(document).ready(function () {
    getCompanies();

});
var isResponded = true;
var ajaxTimer;

function getCompanies() {
    $.ajax({
        type: "GET",
        url: "/companies",
        contentType: "application/json",
        success: function (data) {
            $.each(data.content, function (i, item) {
                $("#body").append("<tr><td>" + item.id + "</td><td>" + ellipsis(item.nameRu) + "</td><td>" + item.region.name + "</td><td>" + item.branch_ru + "</td></tr>")
            });
        },
        beforeSend: function () {
            isResponded = false;
            $("#progressRow").show();
            var $progressElement = $("#progressElement");
            ajaxTimer = setInterval(progress, 1000, $progressElement);
        },

        complete : function () {
            isResponded = true;
            $("#progressRow").hide();
            clearInterval(ajaxTimer);
        }
    });
}

function progress(el) {
    var valuenow = parseInt(el.attr("aria-valuenow"));
    if (valuenow !== 100) {
        el.attr("aria-valuenow", valuenow += 5).css("width", (valuenow += 5) + "%");
    } else {
        el.attr("aria-valuenow", 0).css("width", 0);
    }
}

function f() {
    
}


function ellipsis(name) {
    return name.replace(/ТОВАРИЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ/ig, 'ТОО')
        .replace(/ПРОИЗВОДСТВЕННЫЙ КООПЕРАТИВ/ig, 'ПК')
        .replace(/АКЦИОНЕРНОЕ ОБЩЕСТВО/ig, 'АО')
        .replace(/ГОСУДАРСТВЕННОЕ УЧРЕЖДЕНИЕ/ig, 'ГУ')
        .replace(/ОТКРЫТОЕ АКЦИОНЕРНОЕ ОБЩЕСТВО/ig, 'ОАО')
        .replace(/ГОСУДАРСТВЕННОЕ КОММУНАЛЬНОЕ КАЗЕННОЕ ПРЕДПРИЯТИЕ/ig, 'ГККП')
        .replace(/ГОСУДАРСТВЕННОЕ КОММУНАЛЬНОЕ УЧРЕЖДЕНИЕ /ig, 'ГКУ')
        .replace(/ОБЩЕСТВЕННОЕ ОБЪЕДИНЕНИЕ/ig, 'ОО');
}

// dataSrc: "content",
// data: function (d) {
//     return JSON.stringify(d);
// },
// dataFilter: function (data) {
//     var j = jQuery.parseJSON(data);
//     j["recordsTotal"] = j["totalElements"];
//     j['recordsFiltered'] = j['totalElements'];
//     return JSON.stringify(j);
// }

// }