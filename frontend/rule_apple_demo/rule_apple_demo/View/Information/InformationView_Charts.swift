//
//  InformationView_Charts.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/17.
//

import SwiftUI
import SwiftUICharts
import Moya


struct InformationView_Charts: View {
    @State var FoodDatas : [ImportRequestrecord] = [ImportRequestrecord]()
    @State var FoodLineChartData : LineChartData = LineChartData(dataSets: LineDataSet(dataPoints: []))
    @State var FoodXiaoshouZengzhanglv : Double  = 0.0
    @State var FoodBarChartData : BarChartData = BarChartData(dataSets: BarDataSet(dataPoints: []))
    @State var FoodShichangzhanbi : Double = 0.0
    
    @State var JixieDatas : [ImportRequestrecord] = [ImportRequestrecord]()
    @State var JixieLineChartData : LineChartData = LineChartData(dataSets: LineDataSet(dataPoints: []))
    @State var JixieXiaoshouZengzhanglv : Double  = 0.0
    @State var JixieBarChartData : BarChartData = BarChartData(dataSets: BarDataSet(dataPoints: []))
    @State var JixieShichangzhanbi : Double = 0.0
    
    @State var HuaxuepinDatas : [ImportRequestrecord] = [ImportRequestrecord]()
    @State var HuaxuepinLineChartDatas : LineChartData = LineChartData(dataSets: LineDataSet(dataPoints: []))
    @State var HuaxuepinXiaoshouZengzhanglv : Double  = 0.0
    @State var HuaxuepinBarChartData : BarChartData = BarChartData(dataSets: BarDataSet(dataPoints: []))
    @State var HuaxuepinShichangzhanbi : Double = 0.0
    
    
    @State var YuancailiaoDatas : [ImportRequestrecord] = [ImportRequestrecord]()
    @State var YuancailiaoLineChartDatas : LineChartData = LineChartData(dataSets: LineDataSet(dataPoints: []))
    @State var YuancailiaoXiaoshouZengzhanglv : Double  = 0.0
    @State var YuancailiaoBarChartData : BarChartData = BarChartData(dataSets: BarDataSet(dataPoints: []))
    @State var YuancailiaoShichangzhanbi : Double = 0.0
    
    
    @State var chartsStyle : String = "折线图"
    @State var marketStyle : String = "食品、饮料、烟草"
    @State var shichangzonge : Double = 224813.1
    var body: some View {
        VStack
        {
            HStack
            {
                Text("样式选择：")
                    .font(.system(size: 25))
                    .fontWeight(.heavy)
                    .padding(.leading , 20)
                Menu{
                    Button(action: {
                        self.chartsStyle = "折线图"
                    }, label: {
                        Text("折线图")
                    })
                    Button(action: {
                        self.chartsStyle = "条形图"
                    }, label: {
                        Text("条形图")
                    })
                    Button(action: {
                        self.chartsStyle = "填充折线图"
                    }, label: {
                        Text("填充折线图")
                    })
                    
                }label: {
                    HStack{
                        Text("\(self.chartsStyle)")
                    }
                }
                Spacer()
                Text("市场:")
                    .font(.system(size: 25))
                    .fontWeight(.heavy)
                Menu{
                    Button(action: {
                        self.marketStyle = "食品、饮料、烟草"
                    }, label: {
                        Text("食品、饮料、烟草")
                    })
                    Button(action: {
                        self.marketStyle = "机械和运输设备"
                    }, label: {
                        Text("机械和运输设备")
                    })
                    Button(action: {
                        self.marketStyle = "化学品及相关产品"
                    }, label: {
                        Text("化学品及相关产品")
                    })
                    Button(action: {
                        self.marketStyle = "原材料"
                    }, label: {
                        Text("原材料")
                    })
                }label: {
                    HStack{
                        Text("\(self.marketStyle)")
                    }
                }
                .padding(.trailing , 20)
            }
            
            if self.chartsStyle == "折线图" && self.marketStyle == "食品、饮料、烟草"{
                ScrollView(.horizontal , showsIndicators: false) {
                    LineChart(chartData: self.FoodLineChartData)
                        .pointMarkers(chartData: FoodLineChartData)
                        .touchOverlay(chartData: FoodLineChartData, specifier: "%.0f")
                        .xAxisGrid(chartData: FoodLineChartData)
                        .yAxisGrid(chartData: FoodLineChartData)
                        .xAxisLabels(chartData: FoodLineChartData)
                        .yAxisLabels(chartData: FoodLineChartData)
                        .infoBox(chartData: FoodLineChartData)
                        .headerBox(chartData: FoodLineChartData)
                        .frame(width: UIScreen.main.bounds.width * 2 , height: UIScreen.main.bounds.height / 2)
                }
                .frame( height: UIScreen.main.bounds.height / 2)
                
                HStack
                {
                    Text("销售增长率")
                    
                    Text("\(self.FoodXiaoshouZengzhanglv)%")
                    
                    Text("    市场占比")
                    Text("\(self.FoodShichangzhanbi)%")
                }
                .padding(.top , 20)
                    
            }
            else if self.chartsStyle == "折线图" && self.marketStyle == "机械和运输设备"{
                ScrollView(.horizontal , showsIndicators: false) {
                    LineChart(chartData: self.JixieLineChartData)
                        .pointMarkers(chartData: JixieLineChartData)
                        .touchOverlay(chartData: JixieLineChartData, specifier: "%.0f")
                        .xAxisGrid(chartData: JixieLineChartData)
                        .yAxisGrid(chartData: JixieLineChartData)
                        .xAxisLabels(chartData: JixieLineChartData)
                        .yAxisLabels(chartData: JixieLineChartData)
                        .infoBox(chartData: JixieLineChartData)
                        .headerBox(chartData: JixieLineChartData)
                        .frame(width: UIScreen.main.bounds.width * 2 , height: UIScreen.main.bounds.height / 2)
                }
                .frame( height: UIScreen.main.bounds.height / 2)
                
                HStack
                {
                    Text("销售增长率")
                    Text("\(self.JixieXiaoshouZengzhanglv)%")
                    
                    Text("    市场占比")
                    Text("\(self.JixieShichangzhanbi)%")
                }
                .padding(.top , 20)
            }
            else if self.chartsStyle == "折线图" && self.marketStyle == "化学品及相关产品"{
                ScrollView(.horizontal , showsIndicators: false) {
                    LineChart(chartData: self.HuaxuepinLineChartDatas)
                        .pointMarkers(chartData: HuaxuepinLineChartDatas)
                        .touchOverlay(chartData: HuaxuepinLineChartDatas, specifier: "%.0f")
                        .xAxisGrid(chartData: HuaxuepinLineChartDatas)
                        .yAxisGrid(chartData: HuaxuepinLineChartDatas)
                        .xAxisLabels(chartData: HuaxuepinLineChartDatas)
                        .yAxisLabels(chartData: HuaxuepinLineChartDatas)
                        .infoBox(chartData: HuaxuepinLineChartDatas)
                        .headerBox(chartData: HuaxuepinLineChartDatas)
                        .frame(width: UIScreen.main.bounds.width * 2 , height: UIScreen.main.bounds.height / 2)
                }
                .frame( height: UIScreen.main.bounds.height / 2)
                
                HStack
                {
                    Text("销售增长率")
                    Text("\(self.HuaxuepinXiaoshouZengzhanglv)%")
                    Text("    市场占比")
                    Text("\(self.HuaxuepinShichangzhanbi)%")
                }
                .padding(.top , 20)
                
            }
            else if self.chartsStyle == "折线图" && self.marketStyle == "原材料"{
                ScrollView(.horizontal , showsIndicators: false) {
                    LineChart(chartData: self.YuancailiaoLineChartDatas)
                        .pointMarkers(chartData: YuancailiaoLineChartDatas)
                        .touchOverlay(chartData: YuancailiaoLineChartDatas, specifier: "%.0f")
                        .xAxisGrid(chartData: YuancailiaoLineChartDatas)
                        .yAxisGrid(chartData: YuancailiaoLineChartDatas)
                        .xAxisLabels(chartData: YuancailiaoLineChartDatas)
                        .yAxisLabels(chartData: YuancailiaoLineChartDatas)
                        .infoBox(chartData: YuancailiaoLineChartDatas)
                        .headerBox(chartData: YuancailiaoLineChartDatas)
                        .frame(width: UIScreen.main.bounds.width * 2 , height: UIScreen.main.bounds.height / 2)
                }
                .frame( height: UIScreen.main.bounds.height / 2)
                
                HStack
                {
                    Text("销售增长率")
                    Text("\(self.YuancailiaoXiaoshouZengzhanglv)%")
                    Text("    市场占比")
                    Text("\(self.YuancailiaoShichangzhanbi)%")
                }
                .padding(.top , 20)
            }
            else if self.chartsStyle == "条形图" && self.marketStyle == "食品、饮料、烟草"{
                ScrollView(.horizontal, showsIndicators: false){
                    BarChart(chartData: FoodBarChartData)
                        .extraLine(chartData: FoodBarChartData,
                                               legendTitle: "Test",
                                               datapoints: extraLineData,
                                               style: extraLineStyle)
                                    .touchOverlay(chartData: FoodBarChartData)
                                    .yAxisPOI(chartData: FoodBarChartData,
                                              markerName: "Step Count Aim",
                                              markerValue: 600,
                                              labelPosition: .center(specifier: "%.0f"),
                                              labelColour: Color.black,
                                              labelBackground: Color(red: 1.0, green: 0.75, blue: 0.25),
                                              lineColour: Color(red: 1.0, green: 0.75, blue: 0.25),
                                              strokeStyle: StrokeStyle(lineWidth: 3, dash: [5,10]))
                                    .yAxisPOI(chartData: FoodBarChartData,
                                              markerName: "Minimum Recommended",
                                              markerValue: 100,
                                              labelPosition: .center(specifier: "%.0f"),
                                              labelColour: Color.white,
                                              labelBackground: Color(red: 0.25, green: 0.75, blue: 1.0),
                                              lineColour: Color(red: 0.25, green: 0.75, blue: 1.0),
                                              strokeStyle: StrokeStyle(lineWidth: 3, dash: [5,10]))
                                    .averageLine(chartData: FoodBarChartData,
                                                 strokeStyle: StrokeStyle(lineWidth: 3, dash: [5,10]))
                                    .xAxisGrid(chartData: FoodBarChartData)
                                    .yAxisGrid(chartData: FoodBarChartData)
                                    .xAxisLabels(chartData: FoodBarChartData)
                                    .yAxisLabels(chartData: FoodBarChartData, colourIndicator: .custom(colour: ColourStyle(colour: .red), size: 12))
                                    .extraYAxisLabels(chartData: FoodBarChartData, colourIndicator: .style(size: 12))
                                    .headerBox(chartData: FoodBarChartData)
                                    .id(FoodBarChartData.id)
                        .frame(width: UIScreen.main.bounds.width * 3 , height: UIScreen.main.bounds.height / 2)
                }
                
                
                HStack
                {
                    Text("销售增长率")
                    Text("\(self.FoodXiaoshouZengzhanglv)%")
                    
                    Text("    市场占比")
                    Text("\(self.FoodShichangzhanbi)%")
                }
                .padding(.top , 20)
            }
            else if self.chartsStyle == "条形图" && self.marketStyle == "机械和运输设备"{
                ScrollView(.horizontal, showsIndicators: false){
                    BarChart(chartData: JixieBarChartData)
                        .extraLine(chartData: JixieBarChartData,
                                               legendTitle: "Test",
                                               datapoints: extraLineData,
                                               style: extraLineStyle)
                                    .touchOverlay(chartData: JixieBarChartData)
                                    .yAxisPOI(chartData: JixieBarChartData,
                                              markerName: "Step Count Aim",
                                              markerValue: 600,
                                              labelPosition: .center(specifier: "%.0f"),
                                              labelColour: Color.black,
                                              labelBackground: Color(red: 1.0, green: 0.75, blue: 0.25),
                                              lineColour: Color(red: 1.0, green: 0.75, blue: 0.25),
                                              strokeStyle: StrokeStyle(lineWidth: 3, dash: [5,10]))
                                    .yAxisPOI(chartData: JixieBarChartData,
                                              markerName: "Minimum Recommended",
                                              markerValue: 100,
                                              labelPosition: .center(specifier: "%.0f"),
                                              labelColour: Color.white,
                                              labelBackground: Color(red: 0.25, green: 0.75, blue: 1.0),
                                              lineColour: Color(red: 0.25, green: 0.75, blue: 1.0),
                                              strokeStyle: StrokeStyle(lineWidth: 3, dash: [5,10]))
                                    .averageLine(chartData: JixieBarChartData,
                                                 strokeStyle: StrokeStyle(lineWidth: 3, dash: [5,10]))
                                    .xAxisGrid(chartData: JixieBarChartData)
                                    .yAxisGrid(chartData: JixieBarChartData)
                                    .xAxisLabels(chartData: JixieBarChartData)
                                    .yAxisLabels(chartData: JixieBarChartData, colourIndicator: .custom(colour: ColourStyle(colour: .red), size: 12))
                                    .extraYAxisLabels(chartData: JixieBarChartData, colourIndicator: .style(size: 12))
                                    .headerBox(chartData: JixieBarChartData)
                                    .id(JixieBarChartData.id)
                        .frame(width: UIScreen.main.bounds.width * 3 , height: UIScreen.main.bounds.height / 2)
                }
                
                
                HStack
                {
                    Text("销售增长率")
                    Text("\(self.JixieXiaoshouZengzhanglv)%")
                    Text("    市场占比")
                    Text("\(self.JixieShichangzhanbi)%")
                }
                .padding(.top , 20)
            }
            else if self.chartsStyle == "条形图" && self.marketStyle == "化学品及相关产品"{
                ScrollView(.horizontal, showsIndicators: false){
                    BarChart(chartData: HuaxuepinBarChartData)
                        .extraLine(chartData: HuaxuepinBarChartData,
                                               legendTitle: "Test",
                                               datapoints: extraLineData,
                                               style: extraLineStyle)
                                    .touchOverlay(chartData: HuaxuepinBarChartData)
                                    .yAxisPOI(chartData: HuaxuepinBarChartData,
                                              markerName: "Step Count Aim",
                                              markerValue: 600,
                                              labelPosition: .center(specifier: "%.0f"),
                                              labelColour: Color.black,
                                              labelBackground: Color(red: 1.0, green: 0.75, blue: 0.25),
                                              lineColour: Color(red: 1.0, green: 0.75, blue: 0.25),
                                              strokeStyle: StrokeStyle(lineWidth: 3, dash: [5,10]))
                                    .yAxisPOI(chartData: HuaxuepinBarChartData,
                                              markerName: "Minimum Recommended",
                                              markerValue: 100,
                                              labelPosition: .center(specifier: "%.0f"),
                                              labelColour: Color.white,
                                              labelBackground: Color(red: 0.25, green: 0.75, blue: 1.0),
                                              lineColour: Color(red: 0.25, green: 0.75, blue: 1.0),
                                              strokeStyle: StrokeStyle(lineWidth: 3, dash: [5,10]))
                                    .averageLine(chartData: HuaxuepinBarChartData,
                                                 strokeStyle: StrokeStyle(lineWidth: 3, dash: [5,10]))
                                    .xAxisGrid(chartData: HuaxuepinBarChartData)
                                    .yAxisGrid(chartData:  HuaxuepinBarChartData)
                                    .xAxisLabels(chartData:  HuaxuepinBarChartData)
                                    .yAxisLabels(chartData: HuaxuepinBarChartData, colourIndicator: .custom(colour: ColourStyle(colour: .red), size: 12))
                                    .extraYAxisLabels(chartData: HuaxuepinBarChartData, colourIndicator: .style(size: 12))
                                    .headerBox(chartData: HuaxuepinBarChartData)
                                    .id(HuaxuepinBarChartData.id)
                        .frame(width: UIScreen.main.bounds.width * 3 , height: UIScreen.main.bounds.height / 2)
                }
                
                
                HStack
                {
                    Text("销售增长率")
                    Text("\(self.HuaxuepinXiaoshouZengzhanglv)%")
                    
                    Text("    市场占比")
                    Text("\(self.HuaxuepinShichangzhanbi)%")
                }
                .padding(.top , 20)
            }
            else if self.chartsStyle == "条形图" && self.marketStyle == "原材料"{
                ScrollView(.horizontal, showsIndicators: false){
                    BarChart(chartData: YuancailiaoBarChartData)
                        .extraLine(chartData: YuancailiaoBarChartData,
                                               legendTitle: "Test",
                                               datapoints: extraLineData,
                                               style: extraLineStyle)
                                    .touchOverlay(chartData: YuancailiaoBarChartData)
                                    .yAxisPOI(chartData: YuancailiaoBarChartData,
                                              markerName: "Step Count Aim",
                                              markerValue: 600,
                                              labelPosition: .center(specifier: "%.0f"),
                                              labelColour: Color.black,
                                              labelBackground: Color(red: 1.0, green: 0.75, blue: 0.25),
                                              lineColour: Color(red: 1.0, green: 0.75, blue: 0.25),
                                              strokeStyle: StrokeStyle(lineWidth: 3, dash: [5,10]))
                                    .yAxisPOI(chartData: YuancailiaoBarChartData,
                                              markerName: "Minimum Recommended",
                                              markerValue: 100,
                                              labelPosition: .center(specifier: "%.0f"),
                                              labelColour: Color.white,
                                              labelBackground: Color(red: 0.25, green: 0.75, blue: 1.0),
                                              lineColour: Color(red: 0.25, green: 0.75, blue: 1.0),
                                              strokeStyle: StrokeStyle(lineWidth: 3, dash: [5,10]))
                                    .averageLine(chartData: YuancailiaoBarChartData,
                                                 strokeStyle: StrokeStyle(lineWidth: 3, dash: [5,10]))
                                    .xAxisGrid(chartData: YuancailiaoBarChartData)
                                    .yAxisGrid(chartData:  YuancailiaoBarChartData)
                                    .xAxisLabels(chartData:  YuancailiaoBarChartData)
                                    .yAxisLabels(chartData: YuancailiaoBarChartData, colourIndicator: .custom(colour: ColourStyle(colour: .red), size: 12))
                                    .extraYAxisLabels(chartData: YuancailiaoBarChartData, colourIndicator: .style(size: 12))
                                    .headerBox(chartData: YuancailiaoBarChartData)
                                    .id(YuancailiaoBarChartData.id)
                        .frame(width: UIScreen.main.bounds.width * 3 , height: UIScreen.main.bounds.height / 2)
                }
                
                
                HStack
                {
                    Text("销售增长率")
                    Text("\(self.YuancailiaoXiaoshouZengzhanglv)%")
                    Text("    市场占比")
                    Text("\(self.YuancailiaoShichangzhanbi)%")
                }
                .padding(.top , 20)
            }
            //MARK: --Charts
            
            VStack
            {
                HStack
                {
                    Image(systemName: "heart.square")
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .foregroundColor(.red)
                        .frame(width: 40)
                        .padding(.leading , 10)
                    
                    Text("市场建议")
                        .font(.system(size: 30))
                        .fontWeight(.heavy)
                    
                    
                    Spacer()
                }
                .padding(.top , 20)
                Spacer()
                
                
                if self.marketStyle == "食品、饮料、烟草"{
                    Text("\(GiveSomeAdvice(Zenzhanglv : self.FoodXiaoshouZengzhanglv, Zhanbi : self.FoodShichangzhanbi))")
                        .padding(.bottom , 20)
                }
                else if self.marketStyle == "机械和运输设备"{
                    Text("\(GiveSomeAdvice(Zenzhanglv : self.JixieXiaoshouZengzhanglv, Zhanbi : self.JixieShichangzhanbi))")
                        .padding(.bottom , 20)
                }
                else if self.marketStyle == "化学品及相关产品"{
                    Text("\(GiveSomeAdvice(Zenzhanglv : self.HuaxuepinXiaoshouZengzhanglv, Zhanbi : self.HuaxuepinShichangzhanbi))")
                        .padding(.bottom , 20)
                }
                else if self.marketStyle == "原材料"{
                    Text("\(GiveSomeAdvice(Zenzhanglv : self.YuancailiaoXiaoshouZengzhanglv, Zhanbi : self.YuancailiaoShichangzhanbi))")
                        .padding(.bottom , 20)
                }
            }
            .frame(height: 150)
            .border(.blue, width: 4)
            
        }
        .navigationTitle("市场分析")
        .onAppear{
            
            
            let gridStyle  = GridStyle(numberOfLines: 7,
                                       lineColour   : Color(.lightGray).opacity(0.5),
                                       lineWidth    : 1,
                                       dash         : [8],
                                       dashPhase    : 0)
            
            let chartStyle = LineChartStyle(infoBoxPlacement    : .infoBox(isStatic: false),
                                            infoBoxBorderColour : Color.primary,
                                            infoBoxBorderStyle  : StrokeStyle(lineWidth: 1),
                                            
                                            markerType          : .vertical(attachment: .line(dot: .style(DotStyle()))),
                                            
                                            xAxisGridStyle      : gridStyle,
                                            xAxisLabelPosition  : .bottom,
                                            xAxisLabelColour    : Color.primary,
                                            xAxisLabelsFrom     : .dataPoint(rotation: .degrees(0)),
                                            
                                            yAxisGridStyle      : gridStyle,
                                            yAxisLabelPosition  : .leading,
                                            yAxisLabelColour    : Color.primary,
                                            yAxisNumberOfLabels : 7,
                                            
                                            baseline            : .minimumWithMaximum(of: 10000),
                                            topLine             : .maximum(of: 20000),
                                            
                                            globalAnimation     : .easeOut(duration: 1))
            
            
            let BarchartStyle = BarChartStyle(infoBoxPlacement: .header,
                                                   markerType: .bottomLeading(),
                                                   xAxisGridStyle: gridStyle,
                                                   xAxisLabelPosition: .bottom,
                                                   xAxisLabelsFrom: .dataPoint(rotation: .degrees(-90)),
                                                   xAxisTitle: "Categories",
                                                   yAxisGridStyle: gridStyle,
                                                   yAxisLabelPosition: .leading,
                                                   yAxisNumberOfLabels: 5,
                                                   yAxisTitle: "Units sold (x 1000)",
                                                   baseline: .zero,
                                                   topLine: .maximumValue)
            
            
            let prodiverFood = MoyaProvider<ImportByFoodAPI>()
            let prodiverJixie = MoyaProvider<ImportByJixieAPI>()
            let prodiverHuaxuepin = MoyaProvider<ImportByHuaxuepinAPI>()
            let prodiverYuancailiao = MoyaProvider<ImportByYuancailiaoAPI>()
            
            
            prodiverFood.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(ImportRequest.self, from: jsondata)
                        self.FoodDatas = data.data.records
                        print(FoodDatas)
                        var FoodLineDataSet = LineDataSet(dataPoints: [])
                        var FoodBarDataSet = BarDataSet(dataPoints: [])
                        for it in FoodDatas
                        {
                            FoodLineDataSet.dataPoints.append(LineChartDataPoint(value: Double(it.importamount)! , xAxisLabel: it.date , description: it.date))
                            
                            FoodBarDataSet.dataPoints.append(BarChartDataPoint(value: Double(it.importamount)! , xAxisLabel: it.date , description: it.date , colour: ColourStyle(colour: .blue.opacity(0.5))))
                        }
                        
                        
                        
                        self.FoodLineChartData.dataSets = FoodLineDataSet
                        self.FoodBarChartData.dataSets = FoodBarDataSet
                        
                        
                        self.FoodLineChartData.metadata = ChartMetadata(title: "食品、饮料、烟草", subtitle: "(亿欧元/月份)")
                        self.FoodBarChartData.metadata =  ChartMetadata(title: "食品、饮料、烟草", subtitle: "(亿欧元/月份)")
                        
                        self.FoodLineChartData.chartStyle = chartStyle
                        self.FoodBarChartData.chartStyle = BarchartStyle
                        self.FoodBarChartData.barStyle = BarStyle(barWidth: 0.5,
                                                                  cornerRadius: CornerRadius(top: 50, bottom: 0),
                                                                  colourFrom: .dataPoints,
                                                                  colour: ColourStyle(colour: .blue))
                        
                        self.FoodXiaoshouZengzhanglv = (Double(FoodDatas[FoodDatas.count - 1].importamount)! - Double(FoodDatas[FoodDatas.count - 2].importamount)!) / Double(FoodDatas[FoodDatas.count - 2].importamount)! * 100
                        
                        self.FoodShichangzhanbi = Double(FoodDatas[FoodDatas.count - 1].importamount)! / self.shichangzonge * 100
                       
                        
                        
                        print(FoodLineChartData.dataSets.dataPoints.count)
                    }catch let error
                    {
                        print(error)
                    }
                case .failure(_):
                    break
                }
            }
            
            prodiverJixie.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(ImportRequest.self, from: jsondata)
                        self.JixieDatas = data.data.records
                        
                        var JixieLineDataSet = LineDataSet(dataPoints: [])
                        var JixieBarDataSet = BarDataSet(dataPoints: [])
                        for it in JixieDatas
                        {
                            JixieLineDataSet.dataPoints.append(LineChartDataPoint(value: Double(it.importamount)! , xAxisLabel: it.date , description: it.date))
                            
                            JixieBarDataSet.dataPoints.append(BarChartDataPoint(value: Double(it.importamount)! , xAxisLabel: it.date , description: it.date , colour: ColourStyle(colour: .blue.opacity(0.5))))
                        }
                        self.JixieLineChartData.dataSets = JixieLineDataSet
                        self.JixieBarChartData.dataSets = JixieBarDataSet
                        
                        self.JixieLineChartData.metadata = ChartMetadata(title: "机械和运输设备", subtitle: "(亿欧元/月份)")
                        self.JixieBarChartData.metadata =  ChartMetadata(title: "机械和运输设备", subtitle: "(亿欧元/月份)")
                        
                        
                        self.JixieLineChartData.chartStyle = chartStyle
                        self.JixieBarChartData.chartStyle = BarchartStyle
                        self.JixieBarChartData.barStyle = BarStyle(barWidth: 0.5,
                                                                  cornerRadius: CornerRadius(top: 50, bottom: 0),
                                                                  colourFrom: .dataPoints,
                                                                  colour: ColourStyle(colour: .blue))
                        
                        
                        
                        self.JixieXiaoshouZengzhanglv = (Double(JixieDatas[JixieDatas.count - 1].importamount)! - Double(JixieDatas[JixieDatas.count - 2].importamount)!) / Double(JixieDatas[JixieDatas.count - 2].importamount)! * 100
                        
                        self.JixieShichangzhanbi = Double(JixieDatas[JixieDatas.count - 1].importamount)! / self.shichangzonge * 100
                        
                    }catch let error
                    {
                        print(error)
                    }
                case .failure(_):
                    break
                }
            }
            
            prodiverHuaxuepin.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(ImportRequest.self, from: jsondata)
                        self.HuaxuepinDatas = data.data.records
                        
                        var HuaxuepinLineDataSet = LineDataSet(dataPoints: [])
                        var HuaxuepinBarDataSet = BarDataSet(dataPoints: [])
                        for it in HuaxuepinDatas
                        {
                            HuaxuepinLineDataSet.dataPoints.append(LineChartDataPoint(value: Double(it.importamount)! , xAxisLabel: it.date , description: it.date))
                            
                            HuaxuepinBarDataSet.dataPoints.append(BarChartDataPoint(value: Double(it.importamount)! , xAxisLabel: it.date , description: it.date , colour: ColourStyle(colour: .blue.opacity(0.5))))
                        }
                        self.HuaxuepinLineChartDatas.dataSets = HuaxuepinLineDataSet
                        self.HuaxuepinBarChartData.dataSets = HuaxuepinBarDataSet
                        
                        
                        self.HuaxuepinLineChartDatas.metadata = ChartMetadata(title: "化学品及相关产品", subtitle: "(亿欧元/月份)")
                        self.HuaxuepinBarChartData.metadata =  ChartMetadata(title: "化学品及相关产品", subtitle: "(亿欧元/月份)")
                        
                        
                        
                        self.HuaxuepinLineChartDatas.chartStyle = chartStyle
                        self.HuaxuepinBarChartData.chartStyle = BarchartStyle
                        self.HuaxuepinBarChartData.barStyle = BarStyle(barWidth: 0.5,
                                                                  cornerRadius: CornerRadius(top: 50, bottom: 0),
                                                                  colourFrom: .dataPoints,
                                                                  colour: ColourStyle(colour: .blue))
                        
                        
                        self.HuaxuepinXiaoshouZengzhanglv = (Double(HuaxuepinDatas[HuaxuepinDatas.count - 1].importamount)! - Double(HuaxuepinDatas[HuaxuepinDatas.count - 2].importamount)!) / Double(HuaxuepinDatas[HuaxuepinDatas.count - 2].importamount)! * 100
                        
                        self.HuaxuepinShichangzhanbi = Double(HuaxuepinDatas[HuaxuepinDatas.count - 1].importamount)! / self.shichangzonge * 100
                        
                    }catch let error
                    {
                        print(error)
                    }
                case .failure(_):
                    break
                }
            }
            
            prodiverYuancailiao.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(ImportRequest.self, from: jsondata)
                        self.YuancailiaoDatas = data.data.records
                        
                        var YuancailiaoLineDataSet = LineDataSet(dataPoints: [])
                        var YuancailiaoBarDataSet = BarDataSet(dataPoints: [])
                        for it in YuancailiaoDatas
                        {
                            YuancailiaoLineDataSet.dataPoints.append(LineChartDataPoint(value: Double(it.importamount)! , xAxisLabel: it.date , description: it.date))
                            
                            YuancailiaoBarDataSet.dataPoints.append(BarChartDataPoint(value: Double(it.importamount)! , xAxisLabel: it.date , description: it.date , colour: ColourStyle(colour: .blue.opacity(0.5))))
                        }
                        self.YuancailiaoLineChartDatas.dataSets = YuancailiaoLineDataSet
                        self.YuancailiaoBarChartData.dataSets = YuancailiaoBarDataSet
                        
                        
                        self.YuancailiaoLineChartDatas.metadata = ChartMetadata(title: "原材料", subtitle: "(亿欧元/月份)")
                        self.YuancailiaoBarChartData.metadata =  ChartMetadata(title: "原材料", subtitle: "(亿欧元/月份)")
                        
                        
                        
                        self.YuancailiaoLineChartDatas.chartStyle = chartStyle
                        self.YuancailiaoBarChartData.chartStyle = BarchartStyle
                        self.YuancailiaoBarChartData.barStyle = BarStyle(barWidth: 0.5,
                                                                  cornerRadius: CornerRadius(top: 50, bottom: 0),
                                                                  colourFrom: .dataPoints,
                                                                  colour: ColourStyle(colour: .blue))
                        
                        
                        self.YuancailiaoXiaoshouZengzhanglv = (Double(YuancailiaoDatas[YuancailiaoDatas.count - 1].importamount)! - Double(YuancailiaoDatas[YuancailiaoDatas.count - 2].importamount)!) / Double(YuancailiaoDatas[YuancailiaoDatas.count - 2].importamount)! * 100
                        
                        self.YuancailiaoShichangzhanbi = Double(YuancailiaoDatas[YuancailiaoDatas.count - 1].importamount)! / self.shichangzonge * 100
                        
                    }catch let error
                    {
                        print(error)
                    }
                case .failure(_):
                    break
                }
            }
            
            
            
            
            
        }
    }
}



extension InformationView_Charts
{
    
        private var extraLineData: [ExtraLineDataPoint] {
            [
                ExtraLineDataPoint(value: 200),
                ExtraLineDataPoint(value: 90),
                ExtraLineDataPoint(value: 700),
                ExtraLineDataPoint(value: 175),
                ExtraLineDataPoint(value: 60),
                ExtraLineDataPoint(value: 100),
                ExtraLineDataPoint(value: 600)
            ]
        }

        private var extraLineStyle: ExtraLineStyle {
            ExtraLineStyle(lineColour: ColourStyle(colour: .blue),
                           lineType: .curvedLine,
                           lineSpacing: .bar,
                           yAxisTitle: "Bob",
                           yAxisNumberOfLabels: 7,
                           animationType: .raise,
                           baseline: .zero)
        }
    
    
    private func GiveSomeAdvice(Zenzhanglv : Double , Zhanbi : Double) -> String
    {
        if Zenzhanglv < 0 && Zhanbi <= 10
        {
            return "销售增长率及市场占比情况不乐观，请慎重考虑！"
        }
        else if Zenzhanglv < 0 && Zhanbi >= 10
        {
            return "销售增长率在本月呈负增长状态，市场占比份额高，您的产品包括此类物品，请注意！"
        }
        else if Zenzhanglv > 0 && Zhanbi <= 10
        {
            return "此产品本月销售良好，可注意此产品."
        }
        else
        {
            return "此产品销售情况良好."
        }
        
    }
    
}


#Preview {
    InformationView()
}
