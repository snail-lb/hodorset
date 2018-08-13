package com.snail2lb.web.echart.util.funnel;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class FunnelChartUtilTest {

    @Test
    public void simpleChartFunnel() {
        Map<String,Number> map = ImmutableMap.of("IE9",21,"Google",22,"Firefox",34,"IE8",36);
        String result = FunnelChartUtil.simpleChartFunnel("浏览器市场份额", map);
        System.out.println(result);
    }
}