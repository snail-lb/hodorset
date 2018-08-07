package com.snail2lb.web.echart.util.line;

import java.util.List;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Line;
import com.snail2lb.web.echart.util.OptionUtil;

/**
 * 折线图工具
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-06 16:16
 */
public class LineChartUtil {



    /**
     * 标准的折线图
     * @param title 图表的标题 -->未来一周气温变化
     * @param xAxis x轴的名称 --> ["周一", "周二", "周三", "周四", "周五", "周六", "周日"]
     * @param yAxis y轴的名称 --> ["最高气温", "最低气温"]
     * @param series
     * @return
     */
    public static String basicLineChart(String title, List<String> xAxis, List<String> yAxis, List<List<Object>> series){
        Option option = OptionUtil.createLineOption(title, xAxis);
        for (int i = 0; i < series.size(); i++) {
            Line line = new Line(yAxis.get(i))
                    .data(series.get(i).toArray());
            option.series().add(line);
        }
        return GsonUtil.format(option);
    }

    /**
     * 标准面积图
     * @param title 图表的标题 -->未来一周气温变化
     * @param xAxis x轴的名称 --> ["周一", "周二", "周三", "周四", "周五", "周六", "周日"]
     * @param yAxis y轴的名称 --> ["最高气温", "最低气温"]
     * @param series
     * @return
     */
    public static String basicAreaChart(String title, List<String> xAxis, List<String> yAxis, List<List<Object>> series){
        Option option = OptionUtil.createLineOption(title, xAxis);

        for (int i = 0; i < series.size(); i++) {
            Line line = new Line(yAxis.get(i))
                    .data(series.get(i).toArray());
            line.smooth(true).itemStyle().normal().areaStyle().typeDefault();
            option.series().add(line);
        }
        return GsonUtil.format(option);
    }

    /**
     * 平滑的曲线线图
     * @param title 图表的标题 -->未来一周气温变化
     * @param xAxis x轴的名称 --> ["周一", "周二", "周三", "周四", "周五", "周六", "周日"]
     * @param yAxis y轴的名称 --> ["最高气温", "最低气温"]
     * @param series
     * @return
     */
    public static String smoothedLineChart(String title, List<String> xAxis, List<String> yAxis, List<List<Object>> series){
        Option option = OptionUtil.createLineOption(title, xAxis);

        for (int i = 0; i < series.size(); i++) {
            Line line = new Line(yAxis.get(i))
                    .data(series.get(i).toArray());
            line.smooth(true);
            option.series().add(line);
        }
        return GsonUtil.format(option);
    }
    /**
     * 堆积面积图
     * @param title 图表的标题 -->未来一周气温变化
     * @param xAxis x轴的名称 --> ["周一", "周二", "周三", "周四", "周五", "周六", "周日"]
     * @param yAxis y轴的名称 --> ["最高气温", "最低气温"]
     * @param series
     * @return
     */
    public static String stackedAreaChart(String title, List<String> xAxis, List<String> yAxis, List<List<Object>> series){
        Option option = OptionUtil.createLineOption(title, xAxis);

        for (int i = 0; i < series.size(); i++) {
            Line line = new Line(yAxis.get(i))
                    .data(series.get(i).toArray());
            line.stack("总量");
            line.itemStyle().normal().areaStyle().typeDefault();
            option.series().add(line);
        }
        return GsonUtil.format(option);
    }
}
