//
//  InformationView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/26.
//

import SwiftUI
import Moya
import FloatingLabelTextFieldSwiftUI


struct InformationView: View {
    
    @State var Taxservices : [TaxServiceRequestrecord] = [TaxServiceRequestrecord]()
    
    @State var daitijiaoziliaos : [Int] = [0,0,0]
    @State var daishenbaos : [Int] = [0,0,0]
    @State var zhucezhongs : [Int] = [0,0,0]
    @State var EPRServices : [EprserviceRequestrecord] = [EprserviceRequestrecord]()
    
    
    var body: some View {
        ScrollView(showsIndicators: false){
            VStack
            {
                InformationView_Charts()
                    .padding(.leading , 10)
                
                
                Group{
                    HStack
                    {
                        Text("待办总览")
                            .font(.system(size : 30))
                            .fontWeight(.heavy)
                            .padding(.leading , 20)
                        
                        Spacer()
                    }
                    .padding(.top , 30)
                    
                    ExpandableView(thumbnail: ThumbnailView(content: {
                        VStack(alignment: .leading, spacing: 10)
                        {
                            Text("待提交资料 >")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.blue)
                                .fontWeight(.heavy)
                                .font(.custom("ArialRoundedMTBold", size: 20))
                            
                        }
                        .padding()
                    }), expanded: ExpandedView(content: {
                        VStack(alignment: .leading, spacing: 12)
                        {
                            
                            VStack
                            {
                                
                                HStack{
                                    Divider()
                                        .frame(width: 4,height: 30)
                                        .foregroundColor(.blue)
                                        .background(.blue)
                                        .padding(.leading ,20)
                                    
                                    Text("待提交资料")
                                        .foregroundStyle(.white)
                                        .fontWeight(.heavy)
                                    
                                    Spacer()
                                }
                                .padding(.top , 20)
                                Spacer()
                                HStack
                                {
                                    Spacer()
                                    VStack
                                    {
                                        Text("VAT")
                                            .foregroundStyle(.white)
                                            .font(.system(size: 30))
                                            .fontWeight(.heavy)
                                        Text("\(self.daitijiaoziliaos[0])")
                                    }
                                    Spacer()
                                    VStack
                                    {
                                        Text("EPR")
                                            .foregroundStyle(.white)
                                            .font(.system(size: 30))
                                            .fontWeight(.heavy)
                                        Text("\(self.daitijiaoziliaos[1])")
                                    }
                                    Spacer()
                                    VStack
                                    {
                                        Text("产品合规")
                                            .foregroundStyle(.white)
                                            .font(.system(size: 30))
                                            .fontWeight(.heavy)
                                        Text("4")
                                    }
                                    Spacer()
                                }
                                .padding(.bottom , 20)
                                
                            }
                            .frame(width: UIScreen.main.bounds.width - 10 , height: 200)
                            .background(.gray.opacity(0.1))
                            .cornerRadius(20)
                            Spacer()
                        }
                        .padding()
                    }))
                    
                    ExpandableView(thumbnail: ThumbnailView(content: {
                        VStack(alignment: .leading, spacing: 10)
                        {
                            Text("待申报 >")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.yellow)
                                .fontWeight(.heavy)
                                .font(.custom("ArialRoundedMTBold", size: 20))
                            
                        }
                        .padding()
                    }), expanded: ExpandedView(content: {
                        VStack(alignment: .leading, spacing: 12)
                        {
                            
                            
                            VStack
                            {
                                HStack{
                                    Divider()
                                        .frame(width: 4,height: 30)
                                        .foregroundColor(.yellow)
                                        .background(.yellow)
                                        .padding(.leading ,20)
                                    
                                    Text("待申报")
                                        .foregroundStyle(.white)
                                        .fontWeight(.heavy)
                                    
                                    Spacer()
                                }
                                .padding(.top , 20)
                                Spacer()
                                HStack
                                {
                                    Spacer()
                                    VStack
                                    {
                                        Text("VAT")
                                            .foregroundStyle(.white)
                                            .font(.system(size: 30))
                                            .fontWeight(.heavy)
                                        Text("\(daishenbaos[0])")
                                    }
                                    Spacer()
                                    VStack
                                    {
                                        Text("EPR")
                                            .foregroundStyle(.white)
                                            .font(.system(size: 30))
                                            .fontWeight(.heavy)
                                        Text("\(daishenbaos[1])")
                                    }
                                    Spacer()
                                    VStack
                                    {
                                        Text("产品合规")
                                            .foregroundStyle(.white)
                                            .font(.system(size: 30))
                                            .fontWeight(.heavy)
                                        Text("1")
                                    }
                                    Spacer()
                                }
                                .padding(.bottom , 20)
                                
                            }
                            .frame(width: UIScreen.main.bounds.width - 10 , height: 200)
                            .background(.gray.opacity(0.1))
                            .cornerRadius(20)
                            
                            Spacer()
                        }
                        .padding()
                    }))
                    
                    ExpandableView(thumbnail: ThumbnailView(content: {
                        VStack(alignment: .leading, spacing: 10)
                        {
                            Text("注册中 >")
                                .frame(maxWidth: .infinity, alignment: .leading)
                                .foregroundStyle(.green)
                                .fontWeight(.heavy)
                                .font(.custom("ArialRoundedMTBold", size: 20))
                            
                        }
                        .padding()
                    }), expanded: ExpandedView(content: {
                        VStack(alignment: .leading, spacing: 12)
                        {
                            
                            VStack
                            {
                                HStack{
                                    Divider()
                                        .frame(width: 4,height: 30)
                                        .foregroundColor(.green)
                                        .background(.green)
                                        .padding(.leading ,20)
                                    
                                    Text("注册中")
                                        .foregroundStyle(.white)
                                        .fontWeight(.heavy)
                                    
                                    Spacer()
                                }
                                .padding(.top , 20)
                                Spacer()
                                HStack
                                {
                                    Spacer()
                                    VStack
                                    {
                                        Text("VAT")
                                            .foregroundStyle(.white)
                                            .font(.system(size: 30))
                                            .fontWeight(.heavy)
                                        Text("\(zhucezhongs[0])")
                                    }
                                    Spacer()
                                    VStack
                                    {
                                        Text("EPR")
                                            .foregroundStyle(.white)
                                            .font(.system(size: 30))
                                            .fontWeight(.heavy)
                                        Text("\(zhucezhongs[1])")
                                    }
                                    Spacer()
                                    VStack
                                    {
                                        Text("产品合规")
                                            .foregroundStyle(.white)
                                            .font(.system(size: 30))
                                            .fontWeight(.heavy)
                                        Text("2")
                                    }
                                    Spacer()
                                }
                                .padding(.bottom , 20)
                                
                            }
                            .frame(width: UIScreen.main.bounds.width - 10 , height: 200)
                            .background(.gray.opacity(0.1))
                            .cornerRadius(20)
                            Spacer()
                        }
                        .padding()
                    }))
                }
                
                
                
                
            }
        }
        .onAppear{
            let prodiverTax = MoyaProvider<TaxServiceRequestAPI>()
            let prodiverEPR = MoyaProvider<EprserviceRequestAPI>()
            
            prodiverTax.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(TaxServiceRequest.self, from: jsondata)
                        
                        self.Taxservices = data.data.records
                        self.daitijiaoziliaos[0] = data.data.records.filter({ it in
                            it.serviceprogress == "待提交资料"
                        }).count
                        
                        self.daishenbaos[0] = data.data.records.filter({ it in
                            it.serviceprogress == "待申报"
                        }).count
                        self.zhucezhongs[0] = data.data.records.filter({ it in
                            it.serviceprogress == "注册中"
                        }).count
                    }catch let error
                    {
                        print(error)
                    }
                    
                case .failure(_):
                    break
                    
                    
                }
            }
            
            prodiverEPR.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(EprserviceRequest.self, from: jsondata)
                        
                        self.EPRServices = data.data.records
                        self.daitijiaoziliaos[1] = data.data.records.filter({ it in
                            it.servicesummit == 1
                        }).count
                        
                        self.daishenbaos[1] = data.data.records.filter({ it in
                            it.servicesummit == 2
                        }).count
                        self.zhucezhongs[1] = data.data.records.filter({ it in
                            it.servicesummit == 3
                        }).count
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

#Preview {
    InformationView()
}
