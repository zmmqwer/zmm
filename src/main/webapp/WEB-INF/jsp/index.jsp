<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/12 0012
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="/ssm01/js/jquery.js"></script>
    <script src="/ssm01/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/ssm01/bootstrap-3.3.7-dist/css/bootstrap.css" />
</head>
<body>
<table  class="table table-bordered table-striped" align="center" style="width: 850px
;height: 450px">
    <caption>
        <h1 style="text-align: center">模拟12306购票系统</h1>
    </caption>
    <tr>
        <td colspan="4">
            <h1>欢迎您:${user.uname}</h1>
            <button onclick="buy()" class="btn btn-success">购买</button>
            <button onclick="selectBuy()"  data-toggle="modal" data-target="#selectBuy" class="btn btn-danger">查看已购</button>
        </td>
        <td colspan="3">
            <form id="form" class="form-inline" action="/ssm01/index" method="post">
                <div class="form-group">
                    <select id="train" name="tid" class="form-control">
                        <option value="-1">车次</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">查询</button>
                <a href="/ssm01/loginOut">注销</a>
            </form>
        </td>
    </tr>
    <tr>
        <th>选择</th>
        <th>车次</th>
        <th>发车-到达</th>
        <th>发时-到时</th>
        <th>车型</th>
    </tr>
    <c:forEach items="${trainList}" var="train">
    <tr>
        <td>
            <div class="checkbox">
                <label>
                    <input class="son" type="checkbox" value="${train.tid}">
                </label>
            </div>
        </td>
        <td>${train.tnumber}</td>
        <td>${train.taddress}</td>
        <td>${train.ttime}</td>
        <td>${train.ttype}</td>
    </tr>
    </c:forEach>
</body>
<%--修改页面模态窗--%>
<div class="modal fade" id="selectBuy" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">已购信息</h4>
            </div>
            <div class="modal-body">
                <form id="" action="" method="post" class="form-horizontal">
                    <input type="hidden" name="fid" id="fid" />
                    <div class="form-group">
                        <label style="position: relative;top:25px" class="col-sm-2 control-label">车次</label>
                        <div class="col-sm-offset-2 col-sm-10">
                            <select id="selecT" name="cid" class="form-control">
                                <option value="-1">车次</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="subUpdate" type="button" class="btn btn-primary">关闭</button>
            </div>
        </div>
    </div>
</div>
<script>

    //异步查询车票信息
    $.ajax({
        url: "/ssm01/queryBytid",
        type: "get",
        dataType: "json",
        success: function (data) {
            for (var i = 0; i <data.length ; i++) {
                $('#train').append("<option value="+data[i].tid+">"+data[i].tnumber+"</option>");
            }
            //通过后台传递的cid和所有鲜花种类进行比较，相等的选中
            $('#train option').each(function () {
                //获取后台request域中的tid
                var tid='${train.tid}';
                if ($(this).val()==tid){
                    $(this).prop('selected',true);
                }
            })
        }
    });
    //选中车次查询对应种类下的所有车次
    $('#train').change(function () {
        //将表单序列化
        var formJson=$('#form').serialize();
        location.href="/ssm01/index?"+formJson;
    });
    //购买车票
    function buy() {
        //获取勾中的son
        if($('.son:checked').length==0){
            alert("最少选择一条数据!")
            return;
        }else {
            //定义一个数组
            var id=[];
            $('.son:checked').each(function () {
                id.push($(this).val())
            })

            confirm('确定购买本次车票吗');
            location.href="/ssm01/buyTrainOK?tid="+id.join()+"&uid=${user.uid}";
        }

    }
    //查看已购信息
    function selectBuy() {
        $.ajax({
            url : "/ssm01/selectBuy",
            data : {"uid":'${user.uid}'},
            type :"get",
            dataType : "json",
            success : function (data) {
                for (var i = 0; i < data.length; i++) {
                    $('#selecT').append("<option value=" + data[i].uname+ ">" + data[i].tnumber + "</option>");
                }
            }
        })
    }
</script>
</html>
