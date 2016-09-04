		define(
				"choose",
			function(e, t, a) {
				return '<ul><a href="appStore.html?type=all"><li target="all">全部</li></a><li target=industry>行业<span class="icon_down"></span><ol><a href="appStore.html?type=1"><li>金融</li></a> <a href="appStore.html?type=2"><li>房地产</li></a> <a href="appStore.html?type=9"><li>通用</li></a><a href="appStore.html?type=11"><li>政府</li></a><a href="appStore.html?type=3"><li>游戏</li></a> <a href="appStore.html?type=5"><li>出行</li></a> <a href="appStore.html?type=7"><li>营销</li></a><a href="appStore.html?type=4"><li>航旅</li></a> <a href="appStore.html?type=8"><li>零售</li></a></ol></li><a href="appStore.html?type=new"><li target="new">新品</li></a> <a href="appStore.html?type=recommend"><li target=recommend>推荐</li></a></ul>'
			}),
		define("appStoreCrumbs", function(e, t, a) {
			return '<span><a href="appStore.html">应用商店</a> > {{value}}</span>'
		}),
		define("hashUtil", function(e, t, a) {
			var r = {
				queryFormat : function() {
					var e = window.location.href.split("?")[1];
					if (e) {
						var t = {};
						return $.each(e.split("&"), function(e, a) {
							var r = this.split("=");
							t[r[0]] = r[1]
						}), t
					}
				},
				queryTopFormat : function() {
					var e = window.top.location.href.split("?")[1];
					if (e) {
						var t = {};
						return $.each(e.split("&"), function(e, a) {
							var r = this.split("=");
							t[r[0]] = r[1]
						}), t
					}
				}
			};
			return r
		}),
		define(
				"appStoreFilter",
				function(e, t, a) {
					var r = {
						businessType : {
							1 : "金融",
							2 : "房地产",
							3 : "航旅",
							4 : "出行",
							5 : "零售",
							6 : "政府",
							7 : "营销",
							8 : "游戏",
							9 : "通用"
						},
						tag : {
							"new" : "新品",
							recommend : "推荐"
						},
						crumbs : {
							1 : "金融",
							2 : "房地产",
							3 : "航旅",
							4 : "出行",
							5 : "零售",
							6 : "政府",
							7 : "营销",
							8 : "游戏",
							9 : "通用",
							"new" : "新品",
							recommend : "推荐",
							all : "全部"
						},
						filter : function(e, t, a) {
							if ("tag" == t)
								return e.filter(function(e) {
									return e[t] === a
								});
							for (var r = [], n = 0, i = e.length; i > n; n++)
								for (var o = 0, s = e[n].businessType.length; s > o; o++)
									e[n].businessType[o].id == a
											&& r.push(e[n]);
							return r
						},
						getType : function(e) {
							return -1 !== JSON.stringify(this.businessType)
									.indexOf(e) ? "businessType" : -1 !== JSON
									.stringify(this.tag).indexOf(e) ? "tag"
									: "all" == e ? "all" : "error"
						},
						indexIndustry : function(e) {
							switch (e) {
							case "all":
								$(".white .dmp_type ul [target=all]").addClass(
										"dmp_choose");
								break;
							case "new":
								$(".white .dmp_type ul [target=new]").addClass(
										"dmp_choose");
								break;
							case "recommend":
								$(".white .dmp_type ul [target=recommend]")
										.addClass("dmp_choose");
								break;
							default:
								$(".white .dmp_type ul [target=industry]")
										.addClass("dmp_choose")
							}
						}
					};
					return r
				}),
		define("user", function(e, t, a) {
			var r = {
				host : "https://www.talkingdata.com/appstore/",
				interfaceHost : "https://www.talkingdata.com/appstore",
				"interface" : {
					login : "/login",
					apps : "/apps",
					myapps : "/myapps",
					access : "/myapps/access"
				},
				getUserName : function() {
					return $.cookie("username")
				},
				getToken : function() {
					return $.cookie("token")
				},
				setHeadUserInfo : function() {
					self = this, $(".header .user span").html(
							self.getUserName()),
							$(".header .user .layout_icon").click(function() {
								self.clearCookie()
							}), $(".header .nav").on("click", "a", function() {
								var e = $(this).attr("data-target");
								window.parent.location.href = self.host + e
							})
				},
				clearCookie : function() {
					$.cookie("username", null), $.cookie("token", null),
							window.location.href = this.host + "loginpage.html"
				}
			};
			return r
		}),
		define(
				"product",
				function(e, t, a) {
					return '<div class="content_middle"><a href="detail.html?id={{id}}&type={{type}}">{{if tag == "new"}} <img class="img_introduce" src="img/new_img.png" alt=""> {{/if}} {{if tag == "recommend"}} <img class="img_introduce" src="img/recom_img.png" alt=""> {{/if}}<dl><dt><img src="{{host+logoUrl}}" alt=""></dt><dd><h2>{{name}}</h2><div class="star-line"><i>{{version}}</i><p class="star">{{each star as value i}} <span class="{{value}}">★</span> {{/each}}</p></div><p class="easy_use">{{description}}</p></dd></dl><div class="provider-bottom"><span class="provider">供应商：{{supplier}}</span> {{each businessType as value i}} <font>{{value.name}}</font> {{/each}}</div></a></div>'
				}),
		define(
				"index_main",
				[ "product", "user", "appStoreFilter", "hashUtil",
						"appStoreCrumbs", "choose" ],
				function(e) {
					function t(e) {
						a(e), r(), n(), i(e)
					}
					function a(e) {
						for (var t = e.data.apps, a = 0, r = t.length; r > a; a++) {
							t[a].star = [], t[a].host = s.interfaceHost;
							for (var n = 0; 5 > n; n++)
								n < t[a].rating ? t[a].star[n] = "other_choose"
										: t[a].star[n] = ""
						}
					}
					function r() {
						$("body").removeClass("loading-animate")
					}
					function n() {
						$(".white .dmp_type").html(template(u))
					}
					function i(e) {
						var t = d.type || "all", a = l.getType(t);
						if (temp = "", "error" == a)
							return void (window.location.href = s.host
									+ "index.html");
						$(".list_top").html(template(c, {
							value : l.crumbs[t]
						})), l.indexIndustry(t);
						for (var r = "all" != a ? l.filter(e.data.apps, a, t)
								: e.data.apps, n = 0, i = r.length; i > n; n++)
							r[n].type = t, temp += template(o, r[n]);
						$(".content_middle_wrapper .content_middle_main").html(
								temp)
					}
					var o = e("product"), s = e("user"), l = e("appStoreFilter"), p = e("hashUtil"), c = e("appStoreCrumbs"), u = e("choose");
					s.setHeadUserInfo();
					var d = p.queryFormat();
					d = d ? d : {
						type : ""
					};
					var f = $.ajax({
						url : s.interfaceHost + s["interface"].apps,
						type : "GET",
						dataType : "json",
						contentType : "application/json",
						beforeSend : function(e) {
							e.setRequestHeader("Authorization", "Basic "
									+ s.getToken())
						}
					});
					f.done(function(e) {
						var a = e.result;
						1 == a ? t(e) : s.clearCookie()
					}).fail(function() {
						s.clearCookie()
					})
				}), seajs.use([ "index_main" ]);
