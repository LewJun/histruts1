$(function () {
    $("a#mockExAjax").click(function () {
        $.ajax({
            url: "empAction.do?method=mockException",
            success: function (data) {
                console.log("success: ", data)
            },
            error: function (e, data) {
                console.log("error: ", data)
            },
            complete: function (data) {
                console.log("complete: ", data)
            }
        })
    });

    $("a#getEmpListByAjax").click(function () {
        $.ajax({
            url: "empAction.do?method=getEmpList",
            success: function (data) {
                console.log("success: ", data)
            },
            error: function (e) {
                console.error("error: ", e)
            },
            complete: function (data) {
                console.log("complete: ", data)
            }
        })
    });
});