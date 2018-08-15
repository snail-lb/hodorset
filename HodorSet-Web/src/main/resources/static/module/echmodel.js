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
                var $div_col = $("<div></div>").attr("class", "layui-col-md"+echartModel.layuiColMd);
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
            //$fatherNode.append('<div class="layui-col-md4"><div class="layui-bg-gray" style="height:400px;" id="'+model_id+'"></div></div>');
        },

        //获取数据
        setData: function(echart_bg, echartModel){
            setInterval(
                function getOptionData(){
                    var url;
                    if(echartModel.url == null || echartModel.url == config.base_server){
                        url = config.base_server + echartModel.dataInterface;
                    }else{
                        url = echartModel.url + echartModel.dataInterface;
                    }

                    $.ajax({
                        url: url,
                        type: echartModel.dataRequestMethod,
                        success: function (data) {
                            //var dataset_data = JSON.parse(data.dataset);
                            var dataset_data = data.dataset;
                            if(echartModel.dataType == "DATASET_ARRAY"){
                                echart_bg.setOption(dataset_data);
                                /*echart_bg.setOption({
                                    dataset: {
                                        source: [
                                            ['product', '2015', '2016', '2017'],
                                            ['Matcha Latte', 43.3, 85.8, 93.7],
                                            ['Milk Tea', 83.1, 73.4, 55.1],
                                            ['Cheese Cocoa', 86.4, 65.2, 82.5],
                                            ['Walnut Brownie', 72.4, 53.9, 39.1]
                                        ]
                                    }
                                });*/
                            }else if(echartModel.dataType == "DATASET_MAP"){
                                echart_bg.setOption(dataset_data);
                                /*echart_bg.setOption({
                                    dataset: {
                                        dimensions: ['product', '2015', '2016', '2017'],
                                        source: [
                                            {product: 'Matcha Latte', '2015': 43.3, '2016': 85.8, '2017': 93.7},
                                            {product: 'Milk Tea', '2015': 83.1, '2016': 73.4, '2017': 55.1},
                                            {product: 'Cheese Cocoa', '2015': 86.4, '2016': 65.2, '2017': 82.5},
                                            {product: 'Walnut Brownie', '2015': 72.4, '2016': 53.9, '2017': 39.1}
                                        ]
                                    }
                                });*/
                            }else{
                                //暂未实现
                                console.log("暂不支持该种数据结构");
                            }
                        }
                    })
                },echartModel.interval);
        }
    };

    //输出test接口
    exports('echmodel', echmodel);
});