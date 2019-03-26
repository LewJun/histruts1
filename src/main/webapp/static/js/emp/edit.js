$(function () {
    $("#emp-edit #submit").click(function () {
        var form = $("#emp-edit-form");
        $.ajax({
            url: "empAction.do?method=update",
            method: "POST",
            data: {
                empno: form.find("#empno").val(),
                ename: form.find("#ename").val()
            },
            dataType: "text/json",
            timeout: 5000,
            async: false,
            beforeSend: function () {
                console.log('before send')
            },
            success: function (data) {
                console.info(data);
                var ret = JSON.parse(data)
                if (0 === ret.code) {
                    window.location.reload()
                } else {
                    alert(ret.msg)
                }
            },
            error: function (e) {
                alert("error:" + e)
            },
            complete: function (data) {
                console.log('complete')
                $("#emp-edit").hide()
            }
        })
    });
});