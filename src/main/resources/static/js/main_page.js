$(function () {
    $.each($("a"),function (index,a) {
        a = $(a);
        let url = a.data("url");
        if (url !== undefined && url !== null) {
            a.click(function () {
                let dom = $("#mainPage");
                dom.empty();
                dom.load(url);
            });
        }
    })
});