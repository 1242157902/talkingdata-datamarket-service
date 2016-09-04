		define("user", function(e, t, a) {
			var i = {
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
			return i
		}),
		define(
				"detailCrumbs",
				function(e, t, a) {
					return '<a href="appStore.html">应用商店</a> &gt; <a href="appStore.html?type={{type}}">{{typeName}}</a> &gt; {{name}}'
				}),
		define(
				"appStoreFilter",
				function(e, t, a) {
					var i = {
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
							for (var i = [], n = 0, r = e.length; r > n; n++)
								for (var s = 0, l = e[n].businessType.length; l > s; s++)
									e[n].businessType[s].id == a
											&& i.push(e[n]);
							return i
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
					return i
				}),
		define(
				"choose",
				function(e, t, a) {
					return '<ul><a href="appStore.html?type=all"><li target="all">全部</li></a><li target=industry>行业<span class="icon_down"></span><ol><a href="appStore.html?type=1"><li>金融</li></a> <a href="appStore.html?type=2"><li>房地产</li></a> <a href="appStore.html?type=4"><li>航旅</li></a> <a href="appStore.html?type=3"><li>游戏</li></a><a href="appStore.html?type=8"><li>零售</li></a> <a href="appStore.html?type=5"><li>出行</li></a href="appStore.html?type=11"><a><li>政府</li></a><a href="appStore.html?type=9"><li>通用</li></a><a href="appStore.html?type=7"><li>营销</li></a></ol></li><a href="appStore.html?type=new"><li target="new">新品</li></a> <a href="appStore.html?type=recommend"><li target=recommend>推荐</li></a></ul>'
				}),
		define("hashUtil", function(e, t, a) {
			var i = {
				queryFormat : function() {
					var e = window.location.href.split("?")[1];
					if (e) {
						var t = {};
						return $.each(e.split("&"), function(e, a) {
							var i = this.split("=");
							t[i[0]] = i[1]
						}), t
					}
				},
				queryTopFormat : function() {
					var e = window.top.location.href.split("?")[1];
					if (e) {
						var t = {};
						return $.each(e.split("&"), function(e, a) {
							var i = this.split("=");
							t[i[0]] = i[1]
						}), t
					}
				}
			};
			return i
		}),
		define(
				"video",
				function(e, t, a) {
					return '<div class="td_tcc_video"><div class="td_tcc_tit"><span class="icon"></span><strong></strong></div><div class="td_tcc_con clearfix"><iframe height=400 width=480 src="{{video}}" frameborder=0 allowfullscreen></iframe></div></div>'
				}),
		define(
				"detail_content",
				function(e, t, a) {
					return '<div class="det_tit">产品展示</div><div class="proshow"><div class="proshow_top"><div class="prev"><span>prev</span></div><div class="proshow_pic"><ul>{{each media.imgUrl as value i}} {{if (i == 0)}}<li target="{{i}}"><img src="{{host+value}}"> {{if (media.videoUrl.length >0)}} <button type="button" name="button">点击查看</button> {{/if}}</li>{{/if}} {{if (i != 0)}}<li target="{{i}}"><img src="{{host+value}}"></li>{{/if}} {{/each}}</ul></div><div class="next"><span>next</span></div></div><div class="proshow_list"><ul>{{each media.imgUrl as value i}} {{if (i == 0)}}<li target="{{i}}" class="detail current"><img src="{{host+value}}"></li>{{/if}} {{if (i != 0)}}<li target="{{i}}"><img src="{{host+value}}"></li>{{/if}} {{/each}}</ul></div></div><!--\n    描述：产品介绍\n-->{{if introduction.length>0}}<div class="det_tit">产品介绍</div><div class="product clearfix">{{each introduction as value i}}<dl><dt>{{value.title}}</dt><dd>{{value.details}}</dd></dl>{{/each}}</div>{{/if}}<!--\n    描述：使用客户\n-->{{if customs.length>0}}<div class="det_tit">使用客户</div><div class="customer clearfix"><ol>{{each customs as value i}}<li><span style="background: url({{host+value.logoUrl}}) center no-repeat">{{value.name}}</span></li>{{/each}}</ol></div>{{/if}}<!--\n    描述：开发商其他产品\n-->{{if relatedApps.length>0}}<div class="det_tit">开发商其他产品</div><div class="other clearfix">{{each relatedApps as value i}}<dl><dt><img src="{{host+value.logoUrl}}"></dt><dd>{{value.name}}</dd><dd>{{each value.star as val j}} <span class="{{val}}">★</span> {{/each}}</dd></dl>{{/each}}</div>{{/if}}'
				}),
		define(
				"detail_bar",
				function(e, t, a) {
					return "计价方式：<span>{{pricing}}</span> 部署方式：<span>{{deploy}}</span> 可否试用：<span>{{trial}}</span> 接入日期：<span>{{accessDate}}</span>"
				}),
		define(
				"detail_logo",
				function(e, t, a) {
					return '<div class="made_btn r"><a href="javascript:void(0)">查阅演示</a> <a href="javascript:void(0)">购买服务</a></div><div id="appOverall"><div class="made_logo l"><span><img src="{{host+logoUrl}}"></span></div><div class="made_con l"><h2>{{name}}<span>{{version}}</span> {{each businessType as value i}} <em>{{value.name}}</em> {{/each}}</h2><p>供应商：{{supplier}}</p><p>{{each star as value i}} <span class="{{value}}">★</span> {{/each}}</p></div></div>'
				}),
		define(
				"index_main",
				[ "detail_logo", "detail_bar", "detail_content", "video",
						"hashUtil", "choose", "appStoreFilter", "detailCrumbs",
						"user" ],
				function(e) {
					function t(e) {
						if (!e)
							return void (window.location.href = y.host
									+ "index.html");
						var t = $.ajax({
							url : y.interfaceHost + y["interface"].apps + "/"
									+ e,
							type : "GET",
							dataType : "json",
							contentType : "application/json",
							beforeSend : function(e) {
								e.setRequestHeader("Authorization", "Basic "
										+ y.getToken())
							}
						});
						t.done(function(e) {
							var t = e.result;
							1 == t ? a(e) : y.clearCookie()
						}).fail(function() {
							y.clearCookie()
						})
					}
					function a(e) {
						i(e), n(), r(e), s(e), l(e), o(e), c(e)
					}
					function i(e) {
						var t = e.data, a = t.relatedApps;
						t.star = d(t.rating);
						for (var i = 0, n = a.length; n > i; i++)
							a[i].star = d(a[i].rating)
					}
					function n() {
						$("body").removeClass("loading-animate")
					}
					function r(e) {
						$(".white .dmp_type").html(template(m)), $(
								".content .crumbs").html(template(_, {
							type : C,
							typeName : g.crumbs[C],
							name : e.data.name
						})), g.indexIndustry(C)
					}
					function s(e) {
						e.data.host = y.interfaceHost, $(
								".projects .made_header").html(
								template(p, e.data))
					}
					function l(e) {
						$(".projects .bar").html(template(u, e.data))
					}
					function o(e) {
						$(".projects .det_pad").html(template(f, e.data))
					}
					function d(e) {
						for (var t = [], a = 0; 5 > a; a++)
							e > a ? t[a] = "other_choose" : t[a] = "";
						return t
					}
					function c(e) {
						var t = $(".proshow_top .proshow_pic"), a = $(".proshow_top .prev"), i = $(".proshow_top .next"), n = $(".proshow .proshow_list"), r = t
								.find("li").length, s = t.find("button");
						t.find("[target=0]").addClass("active"), a
								.click(function() {
									var e = t.find(".active"), a = parseInt(e
											.attr("target"));
									a = 0 >= a ? 0 : a - 1, t.find("li")
											.removeClass("active"), t.find(
											"[target=" + a + "]").addClass(
											"active"), n.find("li")
											.removeClass("current"), n.find(
											"[target=" + a + "]").addClass(
											"current")
								}), i.click(function() {
							var e = t.find(".active"), a = parseInt(e
									.attr("target"));
							a = r - 1 > a ? a + 1 : r - 1, t.find("li")
									.removeClass("active"), t.find(
									"[target=" + a + "]").addClass("active"), n
									.find("li").removeClass("current"), n.find(
									"[target=" + a + "]").addClass("current")
						});
						for (var l = 0; r > l; l++)
							n
									.find("[target=" + l + "]")
									.click(
											function() {
												var e = parseInt($(this).attr(
														"target"));
														t
																.find("li")
																.removeClass(
																		"active"),
														t
																.find(
																		"[target="
																				+ e
																				+ "]")
																.addClass(
																		"active"),
														n
																.find("li")
																.removeClass(
																		"current"),
														n
																.find(
																		"[target="
																				+ e
																				+ "]")
																.addClass(
																		"current")
											});
						s.click(function() {
							$("#video").html(template(h, {
								video : e.data.media.videoUrl[0]
							})), $("#video .td_tcc_tit span").click(function() {
								$("#video").html("")
							})
						})
					}
					var p = e("detail_logo"), u = e("detail_bar"), f = e("detail_content"), h = e("video"), v = e("hashUtil"), m = e("choose"), g = e("appStoreFilter"), _ = e("detailCrumbs"), y = e("user"), w = v
							.queryFormat(), b = w.id, C = w.type;
					y.setHeadUserInfo(), t(b)
				}), seajs.use([ "index_main" ]);
