package com.snail2lb.web.echart.util.bar;

import java.util.List;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Line;
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
    public static String barSimple(String title, List<String> xAxis, List<String> yAxis, List<List<Object>> series) {
        Option option = OptionUtil.createLineOption(title, xAxis);

        for (int i = 0; i < series.size(); i++) {
            Line line = new Line(yAxis.get(i))
                    .type(SeriesType.bar)
                    .data(series.get(i).toArray());
            line.smooth(true).itemStyle().normal().areaStyle().typeDefault();
            option.series().add(line);
        }
        return GsonUtil.format(option);
    }


}
