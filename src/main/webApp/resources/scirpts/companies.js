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
        data: ajaxOptions,
        success: function (data) {
            $.each(data.content, function (i, item) {
                $("#tbody").append("<tr><td>" + (i + 1) + "</td><td>" + ellipsis(item.nameRu || item.nameKz) + "</td><td>" + item.region.name + "</td><td>" + (item.branchRu || item.branchKz) + "</td></tr>")
            });
        },
        beforeSend: function () {
            isResponded = false;
            $("#tbody tr").empty();
            $("#progressRow").show();
            var $progressElement = $("#progressElement");
            ajaxTimer = setInterval(progress, 1000, $progressElement);
        },
        complete: function (data) {
            isResponded = true;
            init(data.responseJSON);
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


function ellipsis(name) {
    if (name !== undefined) {
        return name.replace(/ТОВАРИЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ/ig, 'ТОО')
            .replace(/ПРОИЗВОДСТВЕННЫЙ КООПЕРАТИВ/ig, 'ПК')
            .replace(/АКЦИОНЕРНОЕ ОБЩЕСТВО/ig, 'АО')
            .replace(/ГОСУДАРСТВЕННОЕ УЧРЕЖДЕНИЕ/ig, 'ГУ')
            .replace(/ОТКРЫТОЕ АКЦИОНЕРНОЕ ОБЩЕСТВО/ig, 'ОАО')
            .replace(/ГОСУДАРСТВЕННОЕ КОММУНАЛЬНОЕ КАЗЕННОЕ ПРЕДПРИЯТИЕ/ig, 'ГККП')
            .replace(/ГОСУДАРСТВЕННОЕ КОММУНАЛЬНОЕ УЧРЕЖДЕНИЕ /ig, 'ГКУ')
            .replace(/ОБЩЕСТВЕННОЕ ОБЪЕДИНЕНИЕ/ig, 'ОО');
    }
    return name;
}
