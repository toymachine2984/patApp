$(document).ready(function () {
    bind();
});


function bind() {
    $('#companiesList').DataTable({
        // paging: true,
        serverSide: true,
        processing: true,
        // filter: true,
        deferRender: true,
        ajax: {
            url: "/companies",
            type: "POST",
            contentType: "application/json",
            dataSrc: "content",
            data: function (d) {
                return JSON.stringify(d);
            },
            dataFilter: function (data) {
                var j = jQuery.parseJSON(data);
                j["recordsTotal"] = j["totalElements"];
                j['recordsFiltered'] = j['totalElements'];
                return JSON.stringify(j);
            }
        },
        pagingType: "full",
        language: {
            // url: "/resources/dt_i18n/dt_ru.json",
            loadingRecords: "Please wait - loading..."
            // processing: '<i class="fa fa-spinner fa-spin fa-3x fa-fw"></i><span class="sr-only">Loading..n.</span> '


        },
        columnDefs: [
            {
                targets: [2, 3, 4],
                orderable: false,
                searchable: false
            }
        ],
        columns: [
            {
                data: "nameRu",
                render: $.fn.dataTable.render.ellipsis()
            },
            {data: "bin"},
            {data: "address"},
            {
                data: "region",
                render: "name"
            },
            {data: "branch_ru"}
        ],
        // drawCallback : function (settings) {
        //     console.log( 'DataTables has redrawn the table' );
        //
        // },
        initComplete: function () {
            var dbApi = this.api();
            $('#companiesList thead th:not(.sorting_disabled)').each(function () {
                var index = $(this).index();
                $(this).html('<div class="md-form input-group mb-0">' +
                    '<input type="text" class="form-control" id=' + index + '>' +
                    '<label class="mt-2" for="' + index + '">' + $(this).text() + ' </label>' +
                    '<div class="input-group-append d-flex align-items-center">' +
                    '<i class="fas fa-sort ml-1" data-sort="' + index + '"></i>' +
                    '</div>' +
                    '</div>');
            });
            dbApi.columns().every(function () {
                var that = this;
                $('input', this.header()).on('keyup change', function () {
                    if (that.search() !== this.value && (this.value.length > 5 || this.value.length === 0)) {
                        that
                            .search(this.value)
                            .draw();
                    }
                });
                $(this.header()).unbind("click");


                $("*[data-sort]", this.header()).each(function (i, el) {
                    dbApi.order.listener(el, $(el).data("sort"));
                });
            });

            $('a.toggle-vis').on('click', function (e) {
                e.preventDefault();

                // Get the column API object
                var column = table.column($(this).attr('data-column'));

                // Toggle the visibility
                column.visible(!column.visible());
            });

            $('#companiesList tbody')
                .on('mouseenter', 'td', function () {
                    var colIdx = dbApi.cell(this).index().column;
                    $(dbApi.cells().nodes()).removeClass('highlight');
                    $(dbApi.column(colIdx).nodes()).addClass('highlight');
                });
        }
    });
};

$.fn.dataTable.render.ellipsis = function () {
    return function (data, type, row) {
        if (type === 'display') {
           return data.replace(/ТОВАРИЩЕСТВО С ОГРАНИЧЕННОЙ ОТВЕТСТВЕННОСТЬЮ/ig, 'ТОО')
                .replace(/ПРОИЗВОДСТВЕННЫЙ КООПЕРАТИВ/ig,'ПК')
                .replace(/АКЦИОНЕРНОЕ ОБЩЕСТВО/ig,'АО')
                .replace(/ГОСУДАРСТВЕННОЕ УЧРЕЖДЕНИЕ/ig,'ГУ')
                .replace(/ОТКРЫТОЕ АКЦИОНЕРНОЕ ОБЩЕСТВО/ig,'ОАО')
                .replace(/ГОСУДАРСТВЕННОЕ КОММУНАЛЬНОЕ КАЗЕННОЕ ПРЕДПРИЯТИЕ/ig,'ГККП')
                .replace(/ГОСУДАРСТВЕННОЕ КОММУНАЛЬНОЕ УЧРЕЖДЕНИЕ /ig,'ГКУ')
                .replace(/ОБЩЕСТВЕННОЕ ОБЪЕДИНЕНИЕ/ig,'ОО');
        }
        return data;
    };
};


// Disable search and ordering by default default options for dataTable
// $.extend( $.fn.dataTable.defaults, {
//     searching: false,
//     ordering:  false
// } );


// function getData(page,size) {
//     $.ajax({
//         method: "GET",
//         url: "/companies",
//         data: {
//             "page": page !== undefined? page:0,
//             "size": size !== undefined? size:50
//         },
//         // contentType: "application/json",
//         //  success: function (result) {
//         //
//         //  }
//     }).done(function (data) {
//         $('#data').html(data);
//         $('#companiesList').DataTable({
//             "pagingType": "full"
//         });
//         // $('.dataTables_length').addClass('bs-select');
//     });
// };






