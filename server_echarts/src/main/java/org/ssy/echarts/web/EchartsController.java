package org.ssy.echarts.web;

import com.github.abel533.echarts.axis.Axis;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssy.echarts.core.Result;

@RequestMapping("/echarts")
@Controller
public class EchartsController {


  @RequestMapping("getSampleLine.json")
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
    series.setData(Arrays.asList(800,700 , 901, 934, 1290, 1330, 1320));
    option.setSeries(Arrays.asList(series));
    result.setData(option.toString());
    return result;
  }


}