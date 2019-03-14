$(function () {
    $("a#mockExAjax").click(function () {
        $.ajax({
            url: "empAction.do?method=mockException",
            method: "POST",
            data: {
                uname: 'zs',
                pwd: '123456'
            },
            dataType: "text/json",
            timeout: 5000,
            async: false,
            beforeSend: function () {
                console.log('before send')
            },
            success: function (data) {
                console.log('success');
                alert("success:" + data)
            },
            error: function (e) {
                alert("error:" + e)
            },
            complete: function (data) {
                console.log('complete')
            }
        })
    });

    $("a#getEmpListByAjax").click(function () {
        $.ajax({
            url: "empAction.do?method=getEmpList",
            method: "POST",
            data: {
                uname: 'zs',
                pwd: '123456'
            },
            dataType: "text/json",
            timeout: 5000,
            async: false,
            beforeSend: function () {
                console.log('before send')
            },
            success: function (data) {
                console.log('success');
                alert("success:" + data)
            },
            error: function (e) {
                alert("error:" + e)
            },
            complete: function (data) {
                console.log('complete')
            }
        })
    });
});