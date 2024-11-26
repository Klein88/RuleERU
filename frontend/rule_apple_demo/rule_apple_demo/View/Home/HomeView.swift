//
//  HomeView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/15.
//

import SwiftUI
import Moya


struct HomeView: View {
    @State var Taxservices : [TaxServiceRequestrecord] = [TaxServiceRequestrecord]()
    
    @State var daitijiaoziliaos : [Int] = [0,0,0]
    @State var daishenbaos : [Int] = [0,0,0]
    @State var zhucezhongs : [Int] = [0,0,0]
    @State var EPRServices : [EprserviceRequestrecord] = [EprserviceRequestrecord]()
    
    
    @State var text : String = ""
    @State var startAnimation : Bool  = false
    var body: some View {
        NavigationView{
            ScrollView(showsIndicators: false){
                VStack{
                    HStack
                    {
                        Image("APP-icon")
                            .resizable()
                            .aspectRatio(contentMode: .fit)
                            .frame(width: 75 , height: 75)
                            .foregroundColor(.blue)
                        Text("欧盟综服平台")
                            .font(.system(size: 30))
                            .fontWeight(.heavy)
                        Spacer()
                        
                        Image("客服")
                            .resizable()
                            .aspectRatio(contentMode: .fit)
                            .frame(width: 40 , height: 40)
                            .foregroundColor(.blue)
                            .padding(.trailing , 20)
                    }
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
                                                .font(.system(size: 35))
                                                .foregroundStyle(.white)
                                                .fontWeight(.heavy)
                                        }
                                        Spacer()
                                        VStack
                                        {
                                            Text("EPR")
                                                .foregroundStyle(.white)
                                                .font(.system(size: 30))
                                                .fontWeight(.heavy)
                                            Text("\(self.daitijiaoziliaos[1])")
                                                .font(.system(size: 35))
                                                .foregroundStyle(.white)
                                                .fontWeight(.heavy)
                                        }
                                        Spacer()
                                        VStack
                                        {
                                            Text("产品合规")
                                                .foregroundStyle(.white)
                                                .font(.system(size: 30))
                                                .fontWeight(.heavy)
                                            Text("4")
                                                .font(.system(size: 35))
                                                .foregroundStyle(.white)
                                                .fontWeight(.heavy)
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
                                                .font(.system(size: 35))
                                                .foregroundStyle(.white)
                                                .fontWeight(.heavy)
                                        }
                                        Spacer()
                                        VStack
                                        {
                                            Text("EPR")
                                                .foregroundStyle(.white)
                                                .font(.system(size: 30))
                                                .fontWeight(.heavy)
                                            Text("\(daishenbaos[1])")
                                                .font(.system(size: 35))
                                                .foregroundStyle(.white)
                                                .fontWeight(.heavy)
                                        }
                                        Spacer()
                                        VStack
                                        {
                                            Text("产品合规")
                                                .foregroundStyle(.white)
                                                .font(.system(size: 30))
                                                .fontWeight(.heavy)
                                            Text("1")
                                                .font(.system(size: 35))
                                                .foregroundStyle(.white)
                                                .fontWeight(.heavy)
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
                                                .font(.system(size: 35))
                                                .foregroundStyle(.white)
                                                .fontWeight(.heavy)
                                        }
                                        Spacer()
                                        VStack
                                        {
                                            Text("EPR")
                                                .foregroundStyle(.white)
                                                .font(.system(size: 30))
                                                .fontWeight(.heavy)
                                            Text("\(zhucezhongs[1])")
                                                .font(.system(size: 35))
                                                .foregroundStyle(.white)
                                                .fontWeight(.heavy)
                                        }
                                        Spacer()
                                        VStack
                                        {
                                            Text("产品合规")
                                                .foregroundStyle(.white)
                                                .font(.system(size: 30))
                                                .fontWeight(.heavy)
                                            Text("2")
                                                .font(.system(size: 35))
                                                .foregroundStyle(.white)
                                                .fontWeight(.heavy)
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
                    HStack
                    {
                        TextField("请输入您所要搜索的内容", text: $text)
                            .foregroundColor(.white)
                        Image(systemName: "magnifyingglass")
                            .padding(.trailing , 20)
                    }
                    .frame(width: UIScreen.main.bounds.width - 80 , height: 40)
                    .background(.blue.opacity(0.5))
                    .cornerRadius(10)
                    .padding(.top , 30)
                    .padding(.bottom , 30)
                    
                    Group{
                        HStack
                        {
                            NavigationLink(destination: VATView(), label: {Image("税务-2")})
                            NavigationLink(destination: PrivacyView(), label: { Image("隐私保护")})
                            
                        }
                        HStack
                        {
                            NavigationLink(destination: Consumption(), label: {Image("消费 (1)-2")})
                            
                            
                            NavigationLink(destination: EPRView(), label: {Image("分组 1-2")})
                            
                        }
                    }
                    Spacer()
                }
                
            }
            .background(MotionAnimationView(colorName: Color.blue.opacity(0.8)))
            
        }
        .frame(width: UIScreen.main.bounds.width , height: UIScreen.main.bounds.height)
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
    TabLayoutView()
        .environmentObject(UserViewModel())
        .environmentObject(VATDocumentViewModel())
        .environmentObject(EPRDocumentViewModel())
        .environmentObject(ConsumptionViewModel())
}
