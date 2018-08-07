package com.snail2lb.web.echart.util;

import java.util.List;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Magic;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.feature.MagicType;

/**
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-06 17:21
 */
public class OptionUtil {

    public static Option createLineOption(String title, List<String> xAxis){
        Option option = new Option();
        option.title(title);
        option.tooltip().trigger(Trigger.axis);
        option.legend();
        option.toolbox().show(true).feature(
                Tool.mark,
                Tool.dataView,
                new MagicType(Magic.line, Magic.bar, Magic.stack, Magic.tiled),
                Tool.restore,
                Tool.saveAsImage);
        option.calculable(true);

        option.xAxis(new CategoryAxis().boundaryGap(false).data(xAxis.toArray()));
        option.yAxis(new ValueAxis());
        return option;
    }

    public static Option createBarOption(String title, List<String> xAxis){
        Option option = new Option();
        option.title(title);
        option.tooltip().trigger(Trigger.axis);
        option.legend();
        option.toolbox().show(true).feature(
                Tool.mark,
                Tool.dataView,
                new MagicType(Magic.line, Magic.bar, Magic.stack, Magic.tiled),
                Tool.restore,
                Tool.saveAsImage);
        option.calculable(true);

        option.xAxis(new CategoryAxis().data(xAxis.toArray()));
        option.yAxis(new ValueAxis());
        return option;
    }

    /**
     * 交换X、Y轴位置
     * @param title
     * @param xAxis
     * @return
     */
    public static Option createBarLandscapeOption(String title, List<String> xAxis){
        Option option = new Option();
        option.title(title);
        option.tooltip().trigger(Trigger.axis);
        option.legend();
        option.toolbox().show(true).feature(
                Tool.mark,
                Tool.dataView,
                new MagicType(Magic.line, Magic.bar),
                Tool.restore,
                Tool.saveAsImage);
        option.calculable(true);

        option.yAxis(new CategoryAxis().data(xAxis.toArray()));
        option.xAxis(new ValueAxis());
        return option;
    }

    public static Option createPublicOption(String title){
        Option option = new Option();
        option.title(title);
        option.tooltip().trigger(Trigger.axis);
        option.legend();
        option.toolbox().show(true).feature(
                Tool.mark,
                Tool.dataView,
                new MagicType(Magic.line, Magic.bar, Magic.stack, Magic.tiled),
                Tool.restore,
                Tool.saveAsImage);
        option.calculable(true);
        return option;
    }
}
