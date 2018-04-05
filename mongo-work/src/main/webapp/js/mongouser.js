$(function () {
    $("#jqGrid").jqGrid({
        url: '../mongouser/list',
        datatype: "json",
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true},
			{label: '用户名', name: 'userName', index: 'user_name', width: 80},
			{label: '密码', name: 'password', index: 'password', width: 500},
			{label: '性别', name: 'gender', index: 'gender', width: 80},
			{label: '生日', name: 'birthday', index: 'birthday', width: 80},
			{label: '学校', name: 'school', index: 'school', width: 80},
			{label: '专业', name: 'major', index: 'major', width: 80},
			{label: '资料完整度', name: 'infofull', index: 'infoFull', width: 80},
			{label: '注册时间', name: 'registerTime', index: 'register_time', width: 80},
			{label: '最后登入时间', name: 'lastLoginTime', index: 'last_login_time', width: 80},
			{label: '最后登入ip地址', name: 'lastLoginIp', index: 'last_login_ip', width: 80},
			{label: '用户等级id', name: 'userLevelId', index: 'user_level_id', width: 80},
			{label: '用户昵称', name: 'nickname', index: 'nickname', width: 80},
			{label: '用户手机', name: 'mobile', index: 'mobile', width: 80},
			{label: '注册ip地址', name: 'registerIp', index: 'register_ip', width: 80},
			{label: '用户头像', name: 'avatar', index: 'avatar', width: 80},
			{label: '微信唯一标志', name: 'weixinOpenid', index: 'weixin_openid', width: 80},
			{label: '父级id', name: 'parentId', index: 'parent_id', width: 80}],
		viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

let vm = new Vue({
	el: '#rrapp',
	data: {
        showList: true,
        title: null,
		mongoUser: {},
		ruleValidate: {
			name: [
				{required: true, message: '名称不能为空', trigger: 'blur'}
			]
		},
		q: {
		    name: ''
		},

        message: 'Hello Vue.js!'
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function () {
			vm.showList = false;
			vm.title = "新增";
			vm.mongoUser = {};
		},
		update: function (event) {
            let id = getSelectedRow();
			if (id == null) {
				return;
			}
			vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
		},
        reverseMessage: function () {
            this.message = this.message.split('').reverse().join('')
        },
		saveOrUpdate: function (event) {
            let url = vm.mongoUser.id == null ? "../mongouser/save" : "../mongouser/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.mongoUser),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
			});
		},
		del: function (event) {
            let ids = getSelectedRows();
			if (ids == null){
				return;
			}

			confirm('确定要删除选中的记录？', function () {
				$.ajax({
					type: "POST",
				    url: "../mongouser/delete",
				    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function (r) {
						if (r.code == 0) {
							alert('操作成功', function (index) {
								$("#jqGrid").trigger("reloadGrid");
							});
						} else {
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get("../mongouser/info/"+id, function (r) {
                vm.mongoUser = r.mongoUser;
            });
		},
		reload: function (event) {
			vm.showList = true;
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
                postData: {'name': vm.q.name},
                page: page
            }).trigger("reloadGrid");
            vm.handleReset('formValidate');
		},
        handleSubmit: function (name) {
            handleSubmitValidate(this, name, function () {
                vm.saveOrUpdate()
            });
        },
        handleReset: function (name) {
            handleResetForm(this, name);
        }
	}
});