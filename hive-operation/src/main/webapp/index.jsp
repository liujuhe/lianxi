<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme()+"://"+
            request.getServerName()+":"+
            request.getServerPort()+
            request.getContextPath()+"/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>hive-operation</title>

    <script type="text/javascript" src="echarts/echarts.min.js"></script>
    <script type="text/javascript" src="js/jquery-3.5.1.js"></script>

    <script type="text/javascript">
        $(function (){
            $("#userBtn").click(function (){
                $("#userBody").html("");
                userList();
            });
            $("#imgBtn").click(function (){
                imgShow();
            });
        });
        function imgShow(){
            $.ajax({
                url:"user/imgShow.do",
                type:"get",
                dataType:"json",
                success:function (data){
                    var chartDom = document.getElementById('main');
                    var myChart = echarts.init(chartDom);
                    var option;

                    option = {
                        xAxis: {
                            type: 'category',
                            data: data
                        },
                        yAxis: {
                            type: 'value'
                        },
                        series: [{
                            data: [120, {
                                value: 200,
                                itemStyle: {
                                    color: '#a90000'
                                }
                            }, 150, 80, 70, 110, 130],
                            type: 'bar'
                        }]
                    };
                    myChart.setOption(option);
                },
                error:function (){
                    alert("1111")
                }
            })
        }

        function userList(){
            $.ajax({
                url:"user/userList.do",
                type:"get",
                dataType:"json",
                success:function (data){
                    var html = "";
                    $.each(data,function (i,n){
                        html += '<tr>';
                        html += '<td>'+n.usercode+'</td>';
                        html += '<td>'+n.username+'</td>';
                        html += '<td>'+n.orgtype+'</td>';
                        html += '<td>'+n.regdate+'</td>';
                        html += '</tr>';
                    })
                    $("#userBody").html(html);
                },error:function (){
                    alert("!11")
                }
            })
        }
    </script>
</head>
<body>
    <div align="center">
        <div style="background-color: pink">
            <h1>显示用户信息</h1>
            <table border="2">
                <thead>
                    <tr>
                        <td>用户账号</td>
                        <td>用户姓名</td>
                        <td>职位</td>
                        <td>创建日期</td>
                    </tr>
                </thead>
                <tbody id="userBody">

                </tbody>
                <tr>
                    <td colspan="4" align="center"><input type="button" id="userBtn" value="查询"/></td>
                </tr>
            </table>
        </div>
        <div>
            <input type="button" value="点击显示图片" id="imgBtn">
        </div>
        <div id="main" style="width: 600px;height:400px;"></div>
    </div>
</body>
</html>
