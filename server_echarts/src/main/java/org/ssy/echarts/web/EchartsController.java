package org.ssy.echarts.web;

import com.github.abel533.echarts.DataZoom;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.axis.Axis;
import com.github.abel533.echarts.axis.AxisLabel;
import com.github.abel533.echarts.axis.AxisLine;
import com.github.abel533.echarts.axis.AxisTick;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.DataZoomType;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Series;
import com.github.abel533.echarts.style.ItemStyle;
import com.github.abel533.echarts.style.TextStyle;
import com.github.abel533.echarts.style.itemstyle.Emphasis;
import com.github.abel533.echarts.style.itemstyle.Normal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssy.echarts.core.Result;

@RequestMapping("/echarts")
@Controller
public class EchartsController {


  @RequestMapping("getSimpleLine.json")
  @ResponseBody
  public Result getSampleLine() {
    Result result = new Result();
    GsonOption option = new GsonOption();
    Axis xAxis = new CategoryAxis();
    xAxis.setData(Arrays.asList("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"));
    option.setxAxis(Arrays.asList(xAxis));
    Axis yAxis = new ValueAxis();
    option.setyAxis(Arrays.asList(yAxis));
    Line series = new Line();
    series.setData(Arrays.asList(800, 700, 901, 934, 1290, 1330, 1320));
    option.setSeries(Arrays.asList(series));
    result.setData(option.toString());
    return result;
  }


  @RequestMapping("getSimpleBar.json")
  @ResponseBody
  public Result getSimpleBar() {
    Result result = new Result();
    Option option = new Option();
    Title title = new Title();
    title.setLeft("10%");
    title.setText("特性示例：渐变色 阴影 点击缩放");
    title.setSubtext("Feature Sample: Gradient Color, Shadow, Click Zoom");
    option.setTitle(title);
    Axis axis = new CategoryAxis();
    axis.setData(Arrays
        .asList('点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自',
            '动', '缩', '放'));
    AxisLabel axisLabel = new AxisLabel();
    TextStyle textStyle = new TextStyle();
    textStyle.setColor("#fff");
    axisLabel.setTextStyle(textStyle);
    axis.setAxisLabel(axisLabel);
    AxisTick axisTick = new AxisTick();
    axisTick.setShow(false);
    axis.setAxisTick(axisTick);
    axis.setZ(10);
    AxisLine axisLine = new AxisLine();
    axisLine.setShow(false);
    axis.setAxisLine(axisLine);
    option.setxAxis(Arrays.asList(axis));
    Axis yAxis = new CategoryAxis();
    AxisLabel axisLabel1 = new AxisLabel();
    TextStyle textStyle1 = new TextStyle();
    textStyle.setColor("#999");
    axisLabel1.setTextStyle(textStyle1);
    yAxis.setAxisLabel(axisLabel1);
    AxisLine yAxisLine = new AxisLine();
    yAxisLine.setShow(false);
    yAxis.setAxisLine(yAxisLine);
    AxisTick yAxisTick = new AxisTick();
    yAxisTick.setShow(false);
    yAxis.setAxisTick(yAxisTick);
    option.setyAxis(Arrays.asList(yAxis));
    DataZoom dataZoom = new DataZoom();
    dataZoom.setType(DataZoomType.inside);


    List<Series> seriesList=new ArrayList<>();

    Bar series1=new Bar();
    series1.setType(SeriesType.bar);

//    series.setData(Arrays.asList(220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220));

    ItemStyle itemStyle=new ItemStyle();
    Normal normal=new Normal();
    normal.setColor("rgba(0,0,0,0.05)");
    itemStyle.setNormal(normal);
    series1.setItemStyle(itemStyle);
    series1.setBarGap("-100%");
    series1.barCategoryGap("40%");

    List data1=new ArrayList();

    for (int i=0;i<20;i++){
      data1.add(500);
    }
    series1.setData(data1);


//    seriesList.add(series1);


    Bar series2=new Bar();
    series2.setType(SeriesType.bar);

//    series: [

//    {
//      type: 'bar',
//          itemStyle: {
//      normal: {
//        color:
//      },
//      emphasis: {
//        color: new echarts.graphic.LinearGradient(
//            0, 0, 0, 1,
//            [
//            {offset: 0, color: '#2378f7'},
//        {offset: 0.7, color: '#2378f7'},
//        {offset: 1, color: '#83bff6'}
//                        ]
//                    )
//      }
//    },
//      data: data
//    }

    ItemStyle itemStyle1=new ItemStyle();
    Normal normal1=new Normal();
    normal1.setColor("new echarts.graphic.LinearGradient( 0, 0, 0, 1, [ {offset: 0, color: '#83bff6'}, {offset: 0.5, color: '#188df0'},{offset: 1, color: '#188df0'}])");

    itemStyle1.setNormal(normal1);
    Emphasis emphasis=new Emphasis();

    emphasis.setColor("new echarts.graphic.LinearGradient( 0, 0, 0, 1, [ {offset: 0, color: '#2378f7'}, {offset: 0.7, color: '#2378f7'},{offset: 1, color: '#83bff6'}])");
    itemStyle1.setEmphasis(emphasis);
    series2.setItemStyle(itemStyle1);
    series2.setData(Arrays.asList(220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220));
    seriesList.add(series2);
    option.setSeries(seriesList);
    result.setData(option);
    return result;
  }

}