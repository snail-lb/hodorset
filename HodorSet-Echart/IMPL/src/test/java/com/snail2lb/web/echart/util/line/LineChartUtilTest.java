package com.snail2lb.web.echart.util.line;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class LineChartUtilTest {

    @Test
    public void basicLineChart() {
        List<Object> list1 = Lists.newArrayList(11, 11, 15, 13, 12, 13, 10);
        List<Object> list2 = Lists.newArrayList(1, -2, 2, 5, 3, 2, 0);
        List<List<Object>> series = Lists.newArrayList(list1, list2);

        String option = LineChartUtil.basicLineChart("未来一周气温变化",
                Lists.newArrayList("周一", "周二", "周三", "周四", "周五", "周六", "周日"),
                Lists.newArrayList("最高气温", "最低气温"),
                series);

        System.out.println(option);
    }

    @Test
    public void basicAreaChart() {
        List<Object> list1 = Lists.newArrayList(11, 11, 15, 13, 12, 13, 10);
        List<Object> list2 = Lists.newArrayList(1, 12, 2, 5, 3, 2, 0);
        List<List<Object>> series = Lists.newArrayList(list1, list2);

        String option = LineChartUtil.basicAreaChart("未来一周气温变化",
                Lists.newArrayList("周一", "周二", "周三", "周四", "周五", "周六", "周日"),
                Lists.newArrayList("最高气温", "最低气温"),
                series);
        System.out.println(option);
    }

    @Test
    public void smoothedLineChart() {
        List<Object> list1 = Lists.newArrayList(11, 11, 15, 13, 12, 13, 10);
        List<Object> list2 = Lists.newArrayList(1, 12, 2, 5, 3, 2, 0);
        List<List<Object>> series = Lists.newArrayList(list1, list2);

        String option = LineChartUtil.smoothedLineChart("未来一周气温变化",
                Lists.newArrayList("周一", "周二", "周三", "周四", "周五", "周六", "周日"),
                Lists.newArrayList("最高气温", "最低气温"),
                series);
        System.out.println(option);
    }

    @Test
    public void stackedAreaChart() {
        List<Object> list1 = Lists.newArrayList(11, 11, 15, 13, 12, 13, 10);
        List<Object> list2 = Lists.newArrayList(1, 22, 2, 5, 3, 2, 0);
        List<List<Object>> series = Lists.newArrayList(list1, list2);

        String option = LineChartUtil.stackedAreaChart("未来一周气温变化",
                Lists.newArrayList("周一", "周二", "周三", "周四", "周五", "周六", "周日"),
                Lists.newArrayList("最高气温", "最低气温"),
                series);
        System.out.println(option);
    }
}