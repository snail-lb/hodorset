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

package com.snail2lb.web.echart.util.gauge;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Gauge;
import com.github.abel533.echarts.series.gauge.Detail;

/**
 * 仪表盘工具
 * @autor: lvbiao
 * @version: 1.0
 * @descript:
 * @date: 2018-08-06 16:16
 */
public class GaugeChartUtil {

    public static String simpleGaugeChart(String title, String name, Number value) {
        Option option = new Option();
        option.title().text(title);
        option.tooltip().formatter("{a} <br/>{b} : {c}%");
        option.toolbox().show(true).feature(Tool.mark, Tool.restore, Tool.saveAsImage);
        option.series(new Gauge(title)
                .detail(new Detail().formatter("{value}%"))
                .data(new Data(name, value)));
        return GsonUtil.format(option);
    }
}
