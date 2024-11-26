//
//  TestView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/15.
//

import SwiftUI
import Moya
import TipKit
import SwiftUICharts





struct PopoverTip: Tip {
    
    @Parameter
        static var hasViewedGetStartedTip: Bool = true
    var title: Text {
        Text("Add an Effect")
            .foregroundStyle(.indigo)
    }
    var message: Text? {
        Text("Touch and hold \(Image(systemName: "wand.and.stars")) to add an effect to your favorite image.")
    }
    
    var rules: [Rule]{
        #Rule(Self.$hasViewedGetStartedTip){ $0 == true}
    }
    
    
    var actions: [Action] {
            return [
                .init(id: "learn-more", title: "Learn more", perform: {
                    PopoverTip.hasViewedGetStartedTip = false
                    demoTip2.isshow = true
                }),
                .init(id: "enable-feature", title: "Enable magic feature", perform: {
                    PopoverTip.hasViewedGetStartedTip = false
                    demoTip2.isshow = true
                })
            ]
        }
}


struct demoTip2 : Tip{
    @Parameter
    static var isshow : Bool = true
    var title: Text{
        Text("1111111")
    }
    
    var message: Text?{
        Text("11111111111")
    }
    
   
    var rules: [Rule]{
        #Rule(Self.$isshow){
            $0 == true
        }
    }
    
    
}



struct TestView: View {
//    @State var image = UIImage()
//    @State var isshow : Bool = false
//    @State var num : Int = 0
//        var body: some View {
//          VStack
//            {
//                
//                
//                
//                Text("\(String(self.num))")
//                
//                
//            }
//            .onAppear{
//                
//                let prodiver = MoyaProvider<TaxdeclarationRequestAPI>()
//                prodiver.request(.pageList(pageSize: 1, pageNum: 1)) { result in
//                    switch result
//                    {
//                    case .success(let req):
//                        do
//                        {
//                            let jsondata = req.data
//                            let data = try JSONDecoder().decode(TaxdeclarationRequest.self, from: jsondata)
//                            
//                            self.num = data.data.records[data.data.records.count  - 1].declarationid
//                            
//                        }catch let error
//                        {
//                            print(error)
//                        }
//                        
//                        
//                    case .failure(_):
//                        break
//                        
//                    }
//                }
//                
//                
//            }
//        }
    let data : LineChartData = weekOfData()
        
        var body: some View {
            VStack {
                LineChart(chartData: data)
                    .pointMarkers(chartData: data)
                    .touchOverlay(chartData: data, specifier: "%.0f")
                    .yAxisPOI(chartData: data,
                              markerName: "Step Count Aim",
                              markerValue: 15_000,
                              labelPosition: .center(specifier: "%.0f"),
                              labelColour: Color.black,
                              labelBackground: Color(red: 1.0, green: 0.75, blue: 0.25),
                              lineColour: Color(red: 1.0, green: 0.75, blue: 0.25),
                              strokeStyle: StrokeStyle(lineWidth: 3, dash: [5,10]))
                    .yAxisPOI(chartData: data,
                              markerName: "Minimum Recommended",
                              markerValue: 10_000,
                              labelPosition: .center(specifier: "%.0f"),
                              labelColour: Color.white,
                              labelBackground: Color(red: 0.25, green: 0.75, blue: 1.0),
                              lineColour: Color(red: 0.25, green: 0.75, blue: 1.0),
                              strokeStyle: StrokeStyle(lineWidth: 3, dash: [5,10]))
                    .averageLine(chartData: data,
                                 strokeStyle: StrokeStyle(lineWidth: 3, dash: [5,10]))
                    .xAxisGrid(chartData: data)
                    .yAxisGrid(chartData: data)
                    .xAxisLabels(chartData: data)
                    .yAxisLabels(chartData: data)
                    .infoBox(chartData: data)
                    .headerBox(chartData: data)
                    .legends(chartData: data, columns: [GridItem(.flexible()), GridItem(.flexible())])
                    .id(data.id)
                    .frame(minWidth: 150, maxWidth: 900, minHeight: 150, idealHeight: 250, maxHeight: 400, alignment: .center)
            }
            .navigationTitle("Week of Data")
        }
        
        static func weekOfData() -> LineChartData {
            let data = LineDataSet(dataPoints: [
                LineChartDataPoint(value: 12000, xAxisLabel: "M", description: "Monday"),
                LineChartDataPoint(value: 10000, xAxisLabel: "T", description: "Tuesday"),
                LineChartDataPoint(value: 8000,  xAxisLabel: "W", description: "Wednesday"),
                LineChartDataPoint(value: 17500, xAxisLabel: "T", description: "Thursday"),
                LineChartDataPoint(value: 16000, xAxisLabel: "F", description: "Friday"),
                LineChartDataPoint(value: 11000, xAxisLabel: "S", description: "Saturday"),
                LineChartDataPoint(value: 9000,  xAxisLabel: "S", description: "Sunday"),
                LineChartDataPoint(value: 9000,  xAxisLabel: "S", description: "Sunday"),
                LineChartDataPoint(value: 9000,  xAxisLabel: "S", description: "Sunday"),
                LineChartDataPoint(value: 9000,  xAxisLabel: "S", description: "Sunday")
            ],
            legendTitle: "Steps",
            pointStyle: PointStyle(),
            style: LineStyle(lineColour: ColourStyle(colour: .red), lineType: .curvedLine))
            
            let metadata   = ChartMetadata(title: "Step Count", subtitle: "Over a Week")
            
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
                                            
                                            baseline            : .minimumWithMaximum(of: 5000),
                                            topLine             : .maximum(of: 20000),
                                            
                                            globalAnimation     : .easeOut(duration: 1))
            
            return LineChartData(dataSets       : data,
                                 metadata       : metadata,
                                 chartStyle     : chartStyle)
            
        }
}


struct TestView2 : View
{
    @Environment(\.presentationMode) var presentationMode
    @State var isnavigationtonextView : Bool = false
    @Binding var isback : Bool
    var body: some View{
        NavigationView{
            VStack
            {
                Button(action: {
                    self.isback = false
                }, label: {
                    Text("back")
                })
            }
        }
        .navigationBarBackButtonHidden()
    }
}

struct TestView3 : View {
    
    @Environment(\.presentationMode) var presentationMode
    
    var body: some View {
        NavigationView{
            VStack
            {
                Button(action: {
                    self.presentationMode.wrappedValue.dismiss()
                }, label: {
                    Text("222")
                })
            }
        }
        .navigationBarBackButtonHidden()
    }
}


#Preview {
    TestView()
//        .task {
//                    try? Tips.resetDatastore()
//                    
//                    try? Tips.configure([
//                        .displayFrequency(.immediate),
//                        .datastoreLocation(.applicationDefault)
//                    ])
//                }
}
