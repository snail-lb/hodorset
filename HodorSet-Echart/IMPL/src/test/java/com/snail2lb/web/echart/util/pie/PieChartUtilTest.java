package com.snail2lb.web.echart.util.pie;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class PieChartUtilTest {

    @Test
    public void customizedPie() {
        Map<String,Number> map = ImmutableMap.of("IE9",21,"Google",54,"Firefox",13,"IE8",11);
        String result = PieChartUtil.simpleChartPie("浏览器市场份额", map);
        System.out.println(result);
    }

    @Test
    public void radiusChartPiepie() {
        Map<String,Number> map = ImmutableMap.of("IE9",21,"Google",22,"Firefox",34,"IE8",36);
        String result = PieChartUtil.radiusChartPiepie("浏览器市场份额", map);
        System.out.println(result);
    }

    @Test
    public void doughnutChartPie() {
        Map<String,Number> map = ImmutableMap.of("IE9",21,"Google",22,"Firefox",34,"IE8",36);
        String result = PieChartUtil.doughnutChartPie("浏览器市场份额", map);
        System.out.println(result);
    }

    @Test
    public void roseDiagramChartPie() {
        Map<String,Number> map = ImmutableMap.of("IE9",21,"Google",22,"Firefox",34,"IE8",36);
        String result = PieChartUtil.roseDiagramChartPie("浏览器市场份额", map);
        System.out.println(result);
    }

    @Test
    public void rectangularEchartPie() {
        Map<String,Number> map = ImmutableMap.of("IE9",21,"Google",22,"Firefox",34,"IE8",36);
        String result = PieChartUtil.rectangularEchartPie("浏览器市场份额", map);
        System.out.println(result);
    }
}