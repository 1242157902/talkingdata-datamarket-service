define("user", function (e, n, o) {
    var t = {
        host: "https://www.talkingdata.com/appstore/",
        interfaceHost: "https://www.talkingdata.com/appstore",
        "interface": {login: "/login", apps: "/apps", myapps: "/myapps", access: "/myapps/access"},
        getUserName: function () {
            return $.cookie("username")
        },
        getToken: function () {
            return $.cookie("token")
        },
        setHeadUserInfo: function () {
            self = this, $(".header .user span").html(self.getUserName()), $(".header .user .layout_icon").click(function () {
                self.clearCookie()
            }), $(".header .nav").on("click", "a", function () {
                var e = $(this).attr("data-target");
                window.parent.location.href = self.host + e
            })
        },
        clearCookie: function () {
            $.cookie("username", null), $.cookie("token", null), window.location.href = this.host + "loginpage.html"
        }
    };
    return t
}), define("login_main", ["user"], function (e) {
    var n = ($.cookie("memoPwd"), $(".login_user .forgetPwd i"), $(".login .login_con .login_user")), o = $(".login .login_con .login_btn"), t = e("user");
    o.click(function () {
        var e = n.find(".userName").val(), o = n.find(".pwd").val(), i = {
            username: e,
            password: o
        }, a = $.ajax({
            url: t.interfaceHost + t["interface"].login,
            type: "post",
            data: JSON.stringify(i),
            dataType: "json",
            contentType: "application/json"
        });
        a.done(function (o) {
            var i = o.result;
            if (1 == i) {
                var a = o.data.token;
                $.cookie("token", a), $.cookie("username", e), window.location.href = t.host + "index.html"
            } else n.addClass("login_tips")
        })
    })
}), seajs.use(["login_main"]);