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

    $(".emp-edit").click(function () {
        var $this = $(this);
        var tr = $this.parent().parent();
        var tds = tr.find("td");
        var empno = $(tds[0]).text();
        var ename = $(tds[1]).text();
        var form = $("#emp-edit-form");
        form.find("#empno").val(empno);
        form.find("#ename").val(ename);
        $("#emp-edit").show();
    });

    $(".emp-del").click(function () {
        var $this = $(this);
        var tr = $this.parent().parent();
        var tds = tr.find("td");
        var empno = $(tds[0]).text();
        $.ajax({
            url: "empAction.do?method=delete",
            method: "POST",
            data: {
                empno: empno
            },
            success: function (data) {
                var ret = JSON.parse(data);
                if (0 === ret.code) {
                    window.location.reload()
                } else {
                    alert(ret.msg)
                }
            },
            error: function (e) {
                console.error(e)
            }
        });
    });
});