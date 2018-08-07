package com.snail2lb.web.echart.util.bar;

import java.util.List;
import java.util.Map;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.code.MarkType;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.data.MapData;
import com.github.abel533.echarts.data.PointData;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Treemap;
import com.github.abel533.echarts.style.Breadcrumb;
import com.snail2lb.web.echart.util.OptionUtil;

/**
 * 柱状图工具
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-06 16:16
 */
public class BarChartUtil {

    /**
     * 简单柱状图
     * @param title
     * @param xAxis
     * @param yAxis
     * @param series
     * @return
     */
    public static String simpleEchartBar(String title, List<String> xAxis, List<String> yAxis, List<List<Object>> series) {
        Option option = OptionUtil.createBarOption(title, xAxis);

        for (int i = 0; i < series.size(); i++) {
            Bar bar = new Bar(yAxis.get(i))
                    .data(series.get(i).toArray())
                    .barGap("0");
            bar.markPoint().data(new PointData().type(MarkType.max).name("最大值"), new PointData().type(MarkType.min).name("最小值"));
            bar.markLine().data(new PointData().type(MarkType.average).name("平均值"));
            option.series().add(bar);
        }
        return GsonUtil.format(option);
    }

    /**
     * 横向堆叠图
     * @param title
     * @param xAxis
     * @param yAxis
     * @param series
     * @return
     */
    public static String transverseEchartBar(String title, List<String> xAxis, List<String> yAxis, List<List<Object>> series) {
        Option option = OptionUtil.createBarLandscapeOption(title, xAxis);

        for (int i = 0; i < series.size(); i++) {
            Bar bar = new Bar(yAxis.get(i))
                    .data(series.get(i).toArray())
                    .barGap("0")
                    .stack("总量");
            bar.label().normal().show(true).position(Position.right);
            option.series().add(bar);
        }
        return GsonUtil.format(option);
    }



}
