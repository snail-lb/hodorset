layui.define(['echarts', 'jquery', 'admin','config'], function(exports){
    var echarts = layui.echarts;
    var $ = layui.jquery;
    var admin = layui.admin;
    var config = layui.config;

    var echmodel = {
        //获取该组所有的option  $fatherNode：父节点
        setModelByGroup: function($fatherNode, group){
            var url = "v1/echartModel/all";
            var param = '{"group":"'+group+'"}';
            admin.req(url, param, function(data){
                echmodel.setModelDraw($fatherNode, data);
            }, "POST");
        },
        //动态添加节点数据 $fatherNode：父节点  echartModel:需要渲染的数据结构，数组
        setModelDraw: function($fatherNode, echartModels){
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
                echmodel.setModelData(echart_bg,echartModel);
            }
        },
        //获取数据
        setModelData: function(echart_bg, echartModel){
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

        setOption: function getOptionData(url, requestMethod, echart_bg, dataType){
            $.ajax({
                url: url,
                type: requestMethod,
                success: function (data) {
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
        },

        //默认的基本图形设置
        setCustomOption: function($fatherNode, type){
            var url = "v1/customOption/all";
            var param = '{}';
            if(null != type){
                param = '{"type":"'+type+'"}';
            }

            admin.req(url, param, function(data){
                var options = data;

                for (var i = 0, len = options.length; i < len; i++) {
                    var option = options[i];

                    //动态设置节点
                    var $div_col = $("<div class='layui-col-md4'></div>");
                    var $div_bg = $("<div class='layui-bg-gray' style='height:400px;'></div>");
                    $div_bg.attr("id", option.id);
                    $div_col.append($div_bg);
                    $fatherNode.append($div_col);

                    var echart_bg = echarts.init($div_bg[0]);
                    var option_data = JSON.parse(option.option);
                    echart_bg.setOption(option_data);
                    console.log("est");
                    var dataset_data = JSON.parse(option.dataset);
                    echart_bg.setOption(dataset_data);
                }

            }, "POST");
        }
    };
    //输出test接口
    exports('echmodel', echmodel);
});