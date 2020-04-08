$('document').ready(function () {
    $("body").css('visibility', 'visible');
    var localData = [$('#teacher').val(), $('#start').val() + '/' + $('#end').val(), $('#leader').val()]
    localStorage.setItem("data", localData);

})

//先检验能不能运行起来，能不能连上，自动推送数据，先不做数据显示

//客户端就会与服务器进行连接

//本地启动改成localhost
//var webSocket = new WebSocket("ws://172.16.29.107:18080/websocket");
 var webSocket = new WebSocket("ws://localhost:18080/websocket");



webSocket.onerror = function (event) {

    makeDataOnWeb(" Connect Error");

};


//这里只是调试用

//连接成功时回调，真的会执行括号中的代码！

webSocket.onopen = function (event) {

    console.log("Connect Success");

};

//
webSocket.onmessage = function (event) {

    makeDataOnWeb(event.data);


};


//这里只是调试用

webSocket.onclose = function (event) {

    console.log("Connect Close");

};
//维护一个长度为LENGTH的数组，存储最近的消息
var messages = []
var LENGTH = 6

function updateTable(data) {

    if (messages.length == LENGTH) {
        //数组满了，把最旧de数据移除
        messages.shift();
    }
    //将后端传来的字符串转换为json
    var json = JSON.parse(data);
    messages.push(json);
    //提取报警信息
    var str = ""
    for (var i = 0; i < messages.length; i++) {
        var temp = "<tr>"
        temp += "<td>" + messages[i].fanNo + "</td>"
            + "<td>" + messages[i].alarmTime + "</td>"
            + "<td>" + messages[i].description + "</td>"
        temp += "</tr>";
        str += temp;

    }
    //提取分组结果
    var type = json.type;
    var res = json.groupByRes;
    var res_str = "";
    var i = 1;
    var type_values = [];
    var types = [];
    var pie_data=[]
    for (var key in res) {
        types.push(key);
        type_values.push(res[key]);
        pie_data.push({value:res[key],name:key});
        res_str += "<p style='color:#fafffb;font-weight:bold;'> NO." + (i) + " " + key + " ：" + res[key] + "条 </p>";
        i += 1;
    }
    //提取曲线图数据
    var keys = []
    var values = []
    var graph = json.graph;
    var GRAPH_NODE_NUM = 6;
    var len=Object.keys(graph).length

    for (var j = 0; j < len; j++) {
        var node = graph[j];
        for (var key in node) {
            keys.push(key);
            values.push(node[key]);
        }

    }


    document.getElementById("tList").innerHTML = str;
    document.getElementById("count").innerText = json.count;
    document.getElementById("top").innerHTML = res_str;
//绘制图表
    drawBar(types,type_values);
    drawPie(pie_data);
    drawGraph(keys, values);

}

function makeDataOnWeb(data) {
    //每次有新的信息就更新图表
    updateTable(data)

};

