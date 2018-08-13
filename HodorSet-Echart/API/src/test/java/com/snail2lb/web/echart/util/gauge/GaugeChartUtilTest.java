package com.snail2lb.web.echart.util.gauge;

import org.junit.Test;

import static org.junit.Assert.*;

public class GaugeChartUtilTest {

    @Test
    public void simpleGaugeChart() {
        String option = GaugeChartUtil.simpleGaugeChart("5月业务指标","完成率",80);
        System.out.println(option);
    }
}