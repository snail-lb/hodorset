package com.snail2lb.web.echart.util.pie;

import java.util.Map;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.code.RoseType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.code.Y;
import com.github.abel533.echarts.data.MapData;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Pie;
import com.github.abel533.echarts.series.Treemap;
import com.github.abel533.echarts.style.Breadcrumb;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.TextStyle;
import com.github.abel533.echarts.style.itemstyle.Emphasis;
import com.github.abel533.echarts.style.itemstyle.Normal;

/**
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-06 20:20
 */
public class PieChartUtil {

    /**
     * 普通饼图
     * @param title
     * @param series
     * @return
     */
    public static String simpleChartPie(String title, Map<String, Number> series){
        Option option = new Option();
        option.title(title);
        option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");
        option.legend().orient(Orient.vertical).left(X.right).top(Y.center);

        Pie pie = new Pie(title).roseType(RoseType.area).center("45%","55%");
        for(String name : series.keySet()){
            pie.data().add(new PieData(name, series.get(name)));
        }

        option.series(pie);
        return GsonUtil.format(option);
    }

    /**
     * 按半径画的普通饼图
     * @param title
     * @param series
     * @return
     */
    public static String radiusChartPiepie(String title, Map<String, Number> series){
        Option option = new Option();
        option.title(title);
        option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");
        option.legend().orient(Orient.vertical).left(X.right).top(Y.center);

        Pie pie = new Pie(title).roseType(RoseType.radius).center("45%","55%");
        for(String name : series.keySet()){
            pie.data().add(new PieData(name, series.get(name)));
        }

        option.series(pie);
        return GsonUtil.format(option);
    }

    /**
     * 环形饼图
     * @param title
     * @param series
     * @return
     */
    public static String doughnutChartPie(String title, Map<String, Number> series){
        Option option = new Option();
        option.title(title);
        option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");
        option.legend().orient(Orient.vertical).left(X.right).top(Y.center);

        ItemStyle itemStyle = new ItemStyle().normal(new Normal().show(false).position(Position.center))
                .emphasis(new Emphasis().show(true).textStyle(new TextStyle().fontSize(30).fontWeight("bold")));
        Pie pie = new Pie(title)
                .radius("40%","70%")
                .center("45%","55%")
                .label(itemStyle);

        for(String name : series.keySet()){
            pie.data().add(new PieData(name, series.get(name)));
        }

        option.series(pie);
        return GsonUtil.format(option);
    }

    /**
     * 环形半径饼图  玫瑰图
     * @param title
     * @param series
     * @return
     */
    public static String roseDiagramChartPie(String title, Map<String, Number> series){
        Option option = new Option();
        option.title(title);
        option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c} ({d}%)");
        option.legend().orient(Orient.vertical).left(X.right).top(Y.center);

        ItemStyle itemStyle = new ItemStyle().normal(new Normal().show(false).position(Position.center))
                .emphasis(new Emphasis().show(true).textStyle(new TextStyle().fontSize(30).fontWeight("bold")));
        Pie pie = new Pie(title)
                .radius("40%","70%")
                .roseType(RoseType.radius).center("45%","55%")
                .label(itemStyle);

        for(String name : series.keySet()){
            pie.data().add(new PieData(name, series.get(name)));
        }

        option.series(pie);
        return GsonUtil.format(option);
    }

    /**
     * 矩形图
     * @param title
     * @param series
     * @return
     */
    public static String rectangularEchartPie(String title, Map<String, Number> series) {
        Option option = new Option().title(title);
        option.tooltip();

        Treemap treemap = new Treemap().nodeClick(false).breadcrumb(new Breadcrumb(false));
        for(String name : series.keySet()){
            treemap.data().add(new MapData(name, series.get(name)));
        }
        option.series(treemap);
        return GsonUtil.format(option);
    }

}
