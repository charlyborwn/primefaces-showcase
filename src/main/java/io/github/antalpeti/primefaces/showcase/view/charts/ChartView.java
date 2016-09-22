package io.github.antalpeti.primefaces.showcase.view.charts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.MeterGaugeChartModel;
import org.primefaces.model.chart.PieChartModel;

@ManagedBean(name = "chartsChartView")
public class ChartView implements Serializable {

  private static final long serialVersionUID = 1L;

  private LineChartModel areaModel;

  @PostConstruct
  public void init() {
    createAreaModel();
    createBubbleModels();
    createLineModels();
    createMeterGaugeModels();
    createAnimatedModels();
    createBarModels();
    createPieModels();
    createCombinedModel();
    createDateModel();
  }

  public LineChartModel getAreaModel() {
    return areaModel;
  }

  private void createAreaModel() {
    areaModel = new LineChartModel();

    LineChartSeries boys = new LineChartSeries();
    boys.setFill(true);
    boys.setLabel("Boys");
    boys.set("2004", 120);
    boys.set("2005", 100);
    boys.set("2006", 44);
    boys.set("2007", 150);
    boys.set("2008", 25);

    LineChartSeries girls = new LineChartSeries();
    girls.setFill(true);
    girls.setLabel("Girls");
    girls.set("2004", 52);
    girls.set("2005", 60);
    girls.set("2006", 110);
    girls.set("2007", 90);
    girls.set("2008", 120);

    areaModel.addSeries(boys);
    areaModel.addSeries(girls);

    areaModel.setTitle("Area Chart");
    areaModel.setLegendPosition("ne");
    areaModel.setStacked(true);
    areaModel.setShowPointLabels(true);

    Axis xAxis = new CategoryAxis("Years");
    areaModel.getAxes().put(AxisType.X, xAxis);
    Axis yAxis = areaModel.getAxis(AxisType.Y);
    yAxis.setLabel("Births");
    yAxis.setMin(0);
    yAxis.setMax(300);
  }

  private BubbleChartModel bubbleModel1;
  private BubbleChartModel bubbleModel2;


  public BubbleChartModel getBubbleModel1() {
    return bubbleModel1;
  }

  public BubbleChartModel getBubbleModel2() {
    return bubbleModel2;
  }

  private void createBubbleModels() {
    bubbleModel1 = initBubbleModel();
    bubbleModel1.setTitle("Bubble Chart");
    bubbleModel1.getAxis(AxisType.X).setLabel("Price");
    Axis yAxis = bubbleModel1.getAxis(AxisType.Y);
    yAxis.setMin(0);
    yAxis.setMax(250);
    yAxis.setLabel("Labels");

    bubbleModel2 = initBubbleModel();
    bubbleModel2.setTitle("Custom Options");
    bubbleModel2.setShadow(false);
    bubbleModel2.setBubbleGradients(true);
    bubbleModel2.setBubbleAlpha(0.8);
    bubbleModel2.getAxis(AxisType.X).setTickAngle(-50);
    yAxis = bubbleModel2.getAxis(AxisType.Y);
    yAxis.setMin(0);
    yAxis.setMax(250);
    yAxis.setTickAngle(50);
  }

  private BubbleChartModel initBubbleModel() {
    BubbleChartModel model = new BubbleChartModel();

    model.add(new BubbleChartSeries("Acura", 70, 183, 55));
    model.add(new BubbleChartSeries("Alfa Romeo", 45, 92, 36));
    model.add(new BubbleChartSeries("AM General", 24, 104, 40));
    model.add(new BubbleChartSeries("Bugatti", 50, 123, 60));
    model.add(new BubbleChartSeries("BMW", 15, 89, 25));
    model.add(new BubbleChartSeries("Audi", 40, 180, 80));
    model.add(new BubbleChartSeries("Aston Martin", 70, 70, 48));

    return model;
  }

  private LineChartModel lineModel1;
  private LineChartModel lineModel2;


  public LineChartModel getLineModel1() {
    return lineModel1;
  }

  public LineChartModel getLineModel2() {
    return lineModel2;
  }

  private void createLineModels() {
    lineModel1 = initLinearModel();
    lineModel1.setTitle("Linear Chart");
    lineModel1.setLegendPosition("e");
    Axis yAxis = lineModel1.getAxis(AxisType.Y);
    yAxis.setMin(0);
    yAxis.setMax(10);

    lineModel2 = initCategoryModel();
    lineModel2.setTitle("Category Chart");
    lineModel2.setLegendPosition("e");
    lineModel2.setShowPointLabels(true);
    lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Years"));
    yAxis = lineModel2.getAxis(AxisType.Y);
    yAxis.setLabel("Births");
    yAxis.setMin(0);
    yAxis.setMax(200);
  }

  private LineChartModel initLinearModel() {
    LineChartModel model = new LineChartModel();

    LineChartSeries series1 = new LineChartSeries();
    series1.setLabel("Series 1");

    series1.set(1, 2);
    series1.set(2, 1);
    series1.set(3, 3);
    series1.set(4, 6);
    series1.set(5, 8);

    LineChartSeries series2 = new LineChartSeries();
    series2.setLabel("Series 2");

    series2.set(1, 6);
    series2.set(2, 3);
    series2.set(3, 2);
    series2.set(4, 7);
    series2.set(5, 9);

    model.addSeries(series1);
    model.addSeries(series2);

    return model;
  }

  private LineChartModel initCategoryModel() {
    LineChartModel model = new LineChartModel();

    ChartSeries boys = new ChartSeries();
    boys.setLabel("Boys");
    boys.set("2004", 120);
    boys.set("2005", 100);
    boys.set("2006", 44);
    boys.set("2007", 150);
    boys.set("2008", 25);

    ChartSeries girls = new ChartSeries();
    girls.setLabel("Girls");
    girls.set("2004", 52);
    girls.set("2005", 60);
    girls.set("2006", 110);
    girls.set("2007", 90);
    girls.set("2008", 120);

    model.addSeries(boys);
    model.addSeries(girls);

    return model;
  }

  private MeterGaugeChartModel meterGaugeModel1;
  private MeterGaugeChartModel meterGaugeModel2;

  public MeterGaugeChartModel getMeterGaugeModel1() {
    return meterGaugeModel1;
  }

  public MeterGaugeChartModel getMeterGaugeModel2() {
    return meterGaugeModel2;
  }

  @SuppressWarnings("serial")
  private MeterGaugeChartModel initMeterGaugeModel() {
    List<Number> intervals = new ArrayList<Number>() {
      {
        add(20);
        add(50);
        add(120);
        add(220);
      }
    };

    return new MeterGaugeChartModel(140, intervals);
  }

  private void createMeterGaugeModels() {
    meterGaugeModel1 = initMeterGaugeModel();
    meterGaugeModel1.setTitle("MeterGauge Chart");
    meterGaugeModel1.setGaugeLabel("km/h");

    meterGaugeModel2 = initMeterGaugeModel();
    meterGaugeModel2.setTitle("Custom Options");
    meterGaugeModel2.setSeriesColors("66cc66,93b75f,E7E658,cc6666");
    meterGaugeModel2.setGaugeLabel("km/h");
    meterGaugeModel2.setGaugeLabelPosition("bottom");
    meterGaugeModel2.setShowTickLabels(false);
    meterGaugeModel2.setLabelHeightAdjust(110);
    meterGaugeModel2.setIntervalOuterRadius(100);
  }

  private LineChartModel animatedModel1;
  private BarChartModel animatedModel2;


  public LineChartModel getAnimatedModel1() {
    return animatedModel1;
  }

  public BarChartModel getAnimatedModel2() {
    return animatedModel2;
  }

  private void createAnimatedModels() {
    animatedModel1 = initLinearModel();
    animatedModel1.setTitle("Line Chart");
    animatedModel1.setAnimate(true);
    animatedModel1.setLegendPosition("se");
    Axis yAxis = animatedModel1.getAxis(AxisType.Y);
    yAxis.setMin(0);
    yAxis.setMax(10);

    animatedModel2 = initBarModel();
    animatedModel2.setTitle("Bar Charts");
    animatedModel2.setAnimate(true);
    animatedModel2.setLegendPosition("ne");
    yAxis = animatedModel2.getAxis(AxisType.Y);
    yAxis.setMin(0);
    yAxis.setMax(200);
  }

  private BarChartModel initBarModel() {
    BarChartModel model = new BarChartModel();

    ChartSeries boys = new ChartSeries();
    boys.setLabel("Boys");
    boys.set("2004", 120);
    boys.set("2005", 100);
    boys.set("2006", 44);
    boys.set("2007", 150);
    boys.set("2008", 25);

    ChartSeries girls = new ChartSeries();
    girls.setLabel("Girls");
    girls.set("2004", 52);
    girls.set("2005", 60);
    girls.set("2006", 110);
    girls.set("2007", 135);
    girls.set("2008", 120);

    model.addSeries(boys);
    model.addSeries(girls);

    return model;
  }

  private BarChartModel barModel;
  private PieChartModel pieModel1;


  public BarChartModel getBarModel() {
    return barModel;
  }

  public PieChartModel getPieModel1() {
    return pieModel1;
  }

  private void createBarModels() {
    createBarModel();
    createHorizontalBarModel();
  }

  private void createBarModel() {
    barModel = initBarModel();

    barModel.setTitle("Bar Chart");
    barModel.setLegendPosition("ne");

    Axis xAxis = barModel.getAxis(AxisType.X);
    xAxis.setLabel("Gender");

    Axis yAxis = barModel.getAxis(AxisType.Y);
    yAxis.setLabel("Births");
    yAxis.setMin(0);
    yAxis.setMax(200);
  }

  private void createPieModels() {
    createPieModel1();
  }

  private void createPieModel1() {
    pieModel1 = new PieChartModel();

    pieModel1.set("Brand 1", 540);
    pieModel1.set("Brand 2", 325);
    pieModel1.set("Brand 3", 702);
    pieModel1.set("Brand 4", 421);

    pieModel1.setTitle("Simple Pie");
    pieModel1.setLegendPosition("w");
  }

  public void itemSelect(ItemSelectEvent event) {
    FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
        "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

    FacesContext.getCurrentInstance().addMessage(null, msg);
  }

  private CartesianChartModel combinedModel;

  public CartesianChartModel getCombinedModel() {
    return combinedModel;
  }

  private void createCombinedModel() {
    combinedModel = new BarChartModel();

    BarChartSeries boys = new BarChartSeries();
    boys.setLabel("Boys");

    boys.set("2004", 120);
    boys.set("2005", 100);
    boys.set("2006", 44);
    boys.set("2007", 150);
    boys.set("2008", 25);

    LineChartSeries girls = new LineChartSeries();
    girls.setLabel("Girls");

    girls.set("2004", 52);
    girls.set("2005", 60);
    girls.set("2006", 110);
    girls.set("2007", 135);
    girls.set("2008", 120);

    combinedModel.addSeries(boys);
    combinedModel.addSeries(girls);

    combinedModel.setTitle("Bar and Line");
    combinedModel.setLegendPosition("ne");
    combinedModel.setMouseoverHighlight(false);
    combinedModel.setShowDatatip(false);
    combinedModel.setShowPointLabels(true);
    Axis yAxis = combinedModel.getAxis(AxisType.Y);
    yAxis.setMin(0);
    yAxis.setMax(200);
  }

  private LineChartModel dateModel;


  public LineChartModel getDateModel() {
    return dateModel;
  }

  private void createDateModel() {
    dateModel = new LineChartModel();
    LineChartSeries series1 = new LineChartSeries();
    series1.setLabel("Series 1");

    series1.set("2014-01-01", 51);
    series1.set("2014-01-06", 22);
    series1.set("2014-01-12", 65);
    series1.set("2014-01-18", 74);
    series1.set("2014-01-24", 24);
    series1.set("2014-01-30", 51);

    LineChartSeries series2 = new LineChartSeries();
    series2.setLabel("Series 2");

    series2.set("2014-01-01", 32);
    series2.set("2014-01-06", 73);
    series2.set("2014-01-12", 24);
    series2.set("2014-01-18", 12);
    series2.set("2014-01-24", 74);
    series2.set("2014-01-30", 62);

    dateModel.addSeries(series1);
    dateModel.addSeries(series2);

    dateModel.setTitle("Zoom for Details");
    dateModel.setZoom(true);
    dateModel.getAxis(AxisType.Y).setLabel("Values");
    DateAxis axis = new DateAxis("Dates");
    axis.setTickAngle(-50);
    axis.setMax("2014-02-01");
    axis.setTickFormat("%b %#d, %y");

    dateModel.getAxes().put(AxisType.X, axis);
  }

  private HorizontalBarChartModel horizontalBarModel;

  public HorizontalBarChartModel getHorizontalBarModel() {
    return horizontalBarModel;
  }

  private void createHorizontalBarModel() {
    horizontalBarModel = new HorizontalBarChartModel();

    ChartSeries boys = new ChartSeries();
    boys.setLabel("Boys");
    boys.set("2004", 50);
    boys.set("2005", 96);
    boys.set("2006", 44);
    boys.set("2007", 55);
    boys.set("2008", 25);

    ChartSeries girls = new ChartSeries();
    girls.setLabel("Girls");
    girls.set("2004", 52);
    girls.set("2005", 60);
    girls.set("2006", 82);
    girls.set("2007", 35);
    girls.set("2008", 120);

    horizontalBarModel.addSeries(boys);
    horizontalBarModel.addSeries(girls);

    horizontalBarModel.setTitle("Horizontal and Stacked");
    horizontalBarModel.setLegendPosition("e");
    horizontalBarModel.setStacked(true);

    Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
    xAxis.setLabel("Births");
    xAxis.setMin(0);
    xAxis.setMax(200);

    Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
    yAxis.setLabel("Gender");
  }
}
