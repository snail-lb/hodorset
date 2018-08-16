layui.define(['echarts', 'jquery', 'admin','config'], function(exports){
    var echarts = layui.echarts;
    var $ = layui.jquery;
    var admin = layui.admin;
    var config = layui.config;

    var echmodel = {
        //获取该组所有的option  $fatherNode：父节点
        getOptionByGroup: function($fatherNode, group){
            var url = "model/" + group;
            admin.req(url, {}, function(data){
                echmodel.draw($fatherNode, data.data);
            }, "GET");
        },

        //动态添加节点数据 $fatherNode：父节点  echartModel:需要渲染的数据结构，数组
        draw: function($fatherNode, echartModels){
            for (var i = 0, len = echartModels.length; i < len; i++) {
                var echartModel = echartModels[i];

                //动态设置节点
                var classAttr = "layui-col-md"+echartModel.layuiColMd
                    + " layui-col-md-offset" + echartModel.layuiColMdOffset;
                var $div_col = $("<div></div>")
                    .attr("class", classAttr);
                var $div_bg = $("<div class='layui-bg-gray'></div>");
                $div_bg.attr("style","height:" + echartModel.height + "px;");
                $div_bg.attr("id", echartModel.id);
                $div_col.append($div_bg);
                $fatherNode.append($div_col);

                var echart_bg = echarts.init($div_bg[0]);
                var option_data = JSON.parse(echartModel.option);

                echart_bg.setOption(option_data);
                //设置数据
                echmodel.setData(echart_bg,echartModel);
            }
        },

        //获取数据
        setData: function(echart_bg, echartModel){
            var interval = echartModel.interval;
            var url;
            if(echartModel.url == null || echartModel.url == config.base_server){
                url = config.base_server + echartModel.dataInterface;
            }else{
                url = echartModel.url + echartModel.dataInterface;
            }
            var requestMethod = echartModel.dataRequestMethod;
            var dataType = echartModel.dataType;

            if(interval <= 0){
                echmodel.setOption(url, requestMethod, echart_bg, dataType)
            }else{
                setInterval(function () {
                    echmodel.setOption(url, requestMethod, echart_bg, dataType);
                }, interval);
            }
        },

        setOption: function getOptionData(url,requestMethod, echart_bg, dataType){
        $.ajax({
            url: url,
            type: requestMethod,
            success: function (data) {
                //var dataset_data = JSON.parse(data.dataset);
                var dataset_data = data.dataset;
                if(dataType == "DATASET_ARRAY"){
                    echart_bg.setOption(dataset_data);
                }else if(dataType == "DATASET_MAP"){
                    echart_bg.setOption(dataset_data);
                }else{
                    //暂未实现
                    console.log("暂不支持该种数据结构");
                }
            }
        })
    }
    };

    //输出test接口
    exports('echmodel', echmodel);
});