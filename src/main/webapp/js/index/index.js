define("user", function (e, t, a) {
    var n = {
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
    return n
}), define("date", function (e, t, a) {
    var n = {
        getPreMonth: function (e) {
            var t = e ? new Date(e) : new Date, a = t.getMonth() + 1, n = t.getFullYear(), i = a - 1;
            return 0 === i && (n -= 1, i = 12), new Date(n + "/" + i + "/01")
        }, getDate: function (e, t) {
            var a = e.split(t);
            return new Date(parseInt(a[0]), parseInt(a[1]) - 1, parseInt(a[2]))
        }
    };
    return n
}), define("appOverall", function (e, t, a) {
    return "<ul><li><em>全部应用</em><font>{{allApp}}款</font></li><li><em>新上架</em><font>{{newApp}}款</font></li><li><em>精品推荐</em><font>{{recommendApp}}款</font></li></ul>"
}), define("myApp", function (e, t, a) {
    return '<div class="left_app"><a data-id="{{id}}"><div class="loading-img">{{if (iconUrl!="")}} <img src="{{iconUrl}}" border="0"> {{/if}}</div><div class="loading-img-logo"><img class="left_app_logo" src="{{host+logoUrl}}" border="0"></div><h3>{{name}}</h3><div class="left_app_bottom"><div class="radius {{expireStatus}}">F</div><span><i>服务期至：{{expireDate}}</i><em>{{supplier}}</em></span></div></a></div>'
}), define("index_main", ["myApp", "appOverall", "date", "user"], function (e) {
    function t(e) {
        n(), e.data.apps.length > 0 && i(e), o(e), r(e), l()
    }

    function a(e) {
        var t = u.getDate(e, "-"), a = u.getPreMonth(e), n = new Date;
        return a > n ? "radius_default" : n > t ? "radius_outdate" : "radius_soon"
    }

    function n() {
        $("body").removeClass("loading-animate")
    }

    function i(e) {
        for (var t = e.data.apps, n = 0, i = t.length; i > n; n++)t[n].expireStatus = a(t[n].expireDate), t[n].expireDate = t[n].expireDate.split(" ")[0]
    }

    function o(e) {
        for (var t = "", a = e.data.apps, n = 0, i = a.length; i > n; n++)a[n].host = f.interfaceHost, a[n].iconUrl = s(a[n].businessType.length > 0 ? a[n].businessType[0].id : 0), t += template(p, a[n]);
        $("#left-apps-wrapper").html(t)
    }

    function r(e) {
        var t = template(c, e.data.overall);
        $("#app_overall .right_list").html(t)
    }

    function s(e) {
        var t = "";
        switch (e) {
            case 1:
                t = f.host + "img/finacial_bg.jpg";
                break;
            case 2:
                t = f.host + "img/estate_bg.jpg";
                break;
            case 3:
                t = f.host + "img/game_bg.png";
                break;
            case 4:
                t = f.host + "img/mobile_bg.jpg";
                break;
            default:
                t = t
        }
        return t
    }

    function l() {
        var e = $("#left-apps-wrapper");
        e.on("click", "a", function () {
            var e = $(this), t = e.attr("data-id"), a = $.ajax({
                url: f.interfaceHost + f["interface"].access + "/" + t,
                type: "GET",
                dataType: "json",
                contentType: "application/json",
                beforeSend: function (e) {
                    e.setRequestHeader("Authorization", "Basic " + f.getToken())
                }
            });
            return a.done(function (e) {
                var t = e.result;
                1 == t ? window.location.href = f.host + "redirect.html?url=" + e.data.url : f.clearCookie()
            }), !1
        })
    }

    var p = e("myApp"), c = e("appOverall"), u = e("date"), f = e("user");
    f.setHeadUserInfo();
    var d = $.ajax({
        url: f.interfaceHost + f["interface"].myapps + "/" + f.getUserName(),
        type: "GET",
        dataType: "json",
        contentType: "application/json",
        beforeSend: function (e) {
            e.setRequestHeader("Authorization", "Basic " + f.getToken())
        }
    });
    d.done(function (e) {
        var a = e.result;
        1 == a ? t(e) : f.clearCookie()
    })
}), seajs.use(["index_main"]);