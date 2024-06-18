function but_look(){
    var signal = {};
    if (from1.Mx.value) signal["Mx"] = parseFloat(from1.Mx.value);
    if (from1.Mi.value) signal["Mi"] = parseFloat(from1.Mi.value);
    if (from1.Ix.value) signal["Ix"] = parseFloat(from1.Ix.value);
    if (from1.Ii.value) signal["Ii"] = parseFloat(from1.Ii.value);

    var params={
        "carFrameId":from1.carFrameId.value,
        "ruleId":from1.ruleId.value,
        "signal": signal
    };
    var settings = {
        "url": "http://localhost:8081/api/warn",
        "method": "POST",
        "timeout": 0,
        "headers": {
            "Content-Type": "application/json;charset=UTF-8"
        },
        "data": JSON.stringify(params),
    };

    $.ajax(settings).done(function (response) {
        if (response.success) {
            var data = response.data;
            var resultDiv = document.getElementById('result');
            resultDiv.innerHTML = ''; // 清空resultDiv

            for (var i = 0; i < data.length; i++) {
                var item = data[i];
                var itemDiv = document.createElement('div');
                itemDiv.innerHTML =
                    '车架编号: ' + item.carFrameId + '<br>' +
                    '电池类型: ' + item.batteryType + '<br>' +
                    '规则名称: ' + item.ruleName + '<br>' +
                    '警报等级: ' + item.alertLevel + '<br>';
                resultDiv.appendChild(itemDiv);
            }
        } else {
            alert("请求失败：" + response.errorMsg);
        }
    });
    return false; // 阻止表单自动提交事件 return false
}
