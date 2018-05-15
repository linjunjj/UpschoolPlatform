$(function () {
    let userId = getQueryString("userId");
    let url = '../order/list';
    if (userId) {
        url += '?userId=' + userId;
    }
    $("#jqGrid").jqGrid({
        url: url,
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', index: 'id', key: true, hidden: true},
            {label: '会员', name: 'username', index: 'username', width: 90},
            {label: '订单号', name: 'order_su', index: 'order_su', width: 100},
            {label: '订单类型', name: 'type', index: 'type', width: 100,
                formatter: function (value) {
                    if (value == '1') {
                        return '闲置订单';
                    } else if (value == '2') {
                        return '跑腿订单';
                    } else if (value == '3') {
                        return '技能订单';
                    }else if (value=='4'){
                        return '活动订单'
                    }
                    return value;
                }
            },
            {label: '订单总价', name: 'price', index: 'price', width: 100},
            {label: '发货状态', name: 'shipping_status', index: 'shipping_status', width: 100,
                formatter: function (value) {
                    if (value == '0') {
                        return '未发货';
                    } else if (value == '1') {
                        return '已发货';
                    } else if (value == '2') {
                        return '已收货';
                    } else if (value == '4') {
                        return '退货';
                    }
                    return value;
                }},
            {label: '支付状态', name: 'pay_status', index: 'pay_status', width: 100,
                formatter: function (value) {
                    if (value == '0') {
                        return '未付款';
                    } else if (value == '1') {
                        return '付款中';
                    } else if (value == '2') {
                        return '已付款';
                    }
                    return value;
                }},

            {label: '创建时间', name: 'create_time', index: 'create_time', width: 80,
                formatter: function (value) {
                    return transDate(value);
                }},
            {label: '支付时间', name: 'pay_time', index: 'pay_time', width: 80,
                formatter: function (value) {
                    return transDate(value);
                }},
            {label: '取消时间', name: 'cancel_time', index: 'cancel_time', width: 80,
                formatter: function (value) {
                    return transDate(value);
                }},
            {label: '发货时间', name: 'send_time', index: 'send_time', width: 80,
                formatter: function (value) {
                    return transDate(value);
                }},
            {label: '完成时间', name: 'comlete_time', index: 'comlete_time', width: 80,
                formatter: function (value) {
                    return transDate(value);
                }},

            {label: '快递公司', name: 'logistics', index: 'logistics', width: 80},
            {label: '快递单号', name: 'shippingNo', index: 'shipping_No', width: 80},
            {label: '发货状态', name: 'monSiginSum', index: 'monSiginSum', width: 100},
            {label: '收货人', name: 'consignee', index: 'consignee', width: 80},
            {label: '省', name: 'province', index: 'province', width: 20 },
            {label: '地市', name: 'city', index: 'city', width: 20 },
            {label: '区县', name: 'district', index: 'district', width: 20 },
            {label: '收货地址', name: 'address', index: 'address', width: 80},
            {label: '联系电话', name: 'mobile', index: 'mobile', width: 80},
            {label: '补充说明', name: 'postscript', index: 'postscript', width: 80 },
            {
                label: '操作', width: 160, align: 'center', sortable: false, formatter: function (value, col, row) {
                    return '<button class="btn btn-outline btn-info" onclick="vm.lookDetail(' + row.id + ')"><i class="fa fa-info-circle"></i>&nbsp;详情</button>' +
                        '<button class="btn btn-outline btn-primary" onclick="vm.printDetail(' + row.id + ')"><i class="fa fa-print"></i>&nbsp;打印</button>';
                }
            }
        ],
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
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        q: {
            userName: '',
        }
    },
    methods: {
        query: function () {
            vm.reload();
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {
                    'userName': vm.q.userName,
                },
                page: page
            }).trigger("reloadGrid");
        },
        lookDetail: function (rowId) { //第三步：定义编辑操作
            vm.detail = true;
            vm.title = "详情";
            $.get("../order/info/" + rowId, function (r) {
                vm.order = r.order;
            });
        },
        printDetail: function (rowId) {
            openWindow({
                type: 2,
                title: '<i class="fa fa-print"></i>打印票据',
                content: '../shop/orderPrint.html?orderId=' + rowId
            })
        },
        del: function (event) {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: "../order/delete",
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
        }
    }
});