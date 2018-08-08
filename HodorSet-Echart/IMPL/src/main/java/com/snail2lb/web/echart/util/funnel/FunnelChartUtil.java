/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2015 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.snail2lb.web.echart.util.funnel;

import java.util.Map;

import com.github.abel533.echarts.Label;
import com.github.abel533.echarts.LabelLine;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.code.LineType;
import com.github.abel533.echarts.code.Position;
import com.github.abel533.echarts.code.Sort;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.MapData;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Funnel;
import com.github.abel533.echarts.style.LineStyle;
import com.github.abel533.echarts.style.TextStyle;

/**
 * 漏斗图工具
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-06 16:16
 */
public class FunnelChartUtil {

    /**
     * 简单漏斗图
     * @param title
     * @param series
     * @return
     */
    public static String simpleChartFunnel(String title, Map<String, Number> series) {
        Option option = new Option();
        option.title().text(title);
        option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c}%");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, Tool.restore, Tool.saveAsImage);
        option.legend();
        option.calculable(true);

        Funnel funnel = new Funnel("漏斗图");
        funnel.x("10%").y(60).width("80%").
                min(0).max(100).
                minSize("0%").maxSize("100%").
                sort(Sort.descending).
                gap(10);
        funnel.itemStyle().normal().borderColor("#fff").borderWidth(1).
                label(new Label().show(true).position(Position.inside)).
                labelLine(new LabelLine().show(false).length(10).lineStyle(new LineStyle().width(1).type(LineType.solid)));
        funnel.itemStyle().emphasis().borderColor("red").borderWidth(5).
                label(new Label().show(true).formatter("{b}:{c}%").textStyle(new TextStyle().fontSize(20))).
                labelLine(new LabelLine().show(true));

        for(String name : series.keySet()){
            funnel.data().add(new MapData(name, series.get(name)));
        }

        option.series(funnel);
        return GsonUtil.format(option);
    }
}
