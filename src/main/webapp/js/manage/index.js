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
}), define("index_main", ["user"], function (e) {
    var n = e("user");
    n.setHeadUserInfo()
}), seajs.use(["index_main"]);
