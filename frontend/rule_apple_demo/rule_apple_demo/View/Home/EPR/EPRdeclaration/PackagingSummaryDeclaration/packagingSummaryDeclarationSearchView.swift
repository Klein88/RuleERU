//
//  packagingSummaryDeclarationSearchView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/5.
//

import SwiftUI
import Moya

struct packagingSummaryDeclarationSearchView: View {
    
    @State var RegNumber : String
    @State var PackagingDatas : [PackagingSummaryDeclarationRequestrecord] = [PackagingSummaryDeclarationRequestrecord]()
    @State var declarationyear : String  = ""
    @State var brandname : String = ""
    @State var isshowadd : Bool = false
    @Environment(\.presentationMode) var pre
    
    
    @ViewBuilder
    private func FormView() -> some View
    {
        VStack{
            VStack(spacing : 0)
            {
                HStack(spacing: 0){
                    Text("序号")
                        .font(.system(size: 20))
                        .fontWeight(.heavy)
                        .frame(width: 90 , height: 40)
                        .border(.black)
                    Text("包装材料")
                        .font(.system(size: 20))
                        .fontWeight(.heavy)
                        .frame(width: 90 , height: 40)
                        .border(.black)
                    Text("预申报重")
                        .font(.system(size: 20))
                        .fontWeight(.heavy)
                        .frame(width: 90 , height: 40)
                        .border(.black)
                    Text("实际重量")
                        .font(.system(size: 20))
                        .fontWeight(.heavy)
                        .frame(width: 90 , height: 40)
                        .border(.black)
                    
                }
                ForEach(0..<PackagingDatas.count , id: \.self){
                    it in
                    HStack(spacing: 0){
                        
                        Text("\(PackagingDatas[it].declarationdataserialnumber)")
                            .frame(width: 90 , height: 40)
                            .border(.black)
                      
                        Text("\(PackagingDatas[it].packagingmaterial)")
                            .frame(width: 90 , height: 40)
                            .border(.black)
                        Text("\(PackagingDatas[it].predeclaredweight)")
                            .frame(width: 90 , height: 40)
                            .border(.black)
                        Text("\(PackagingDatas[it].actualpackagingweight)")
                            .frame(width: 90 , height: 40)
                            .border(.black)
                    }
                }
            }
        }
    }
    
    var body: some View {
        ScrollView(showsIndicators: false){
            VStack{
                VStack
                {
                    HStack{
                        VStack
                        {
                            Text("注册号")
                                .font(.system(size: 30))
                                .fontWeight(.heavy)
                                .padding(.top ,5)
                            Spacer()
                            Text("\(self.RegNumber)")
                                .padding(.bottom , 20)
                        }
                        .frame(width: 150 , height: 100)
                        .border(.black)
                        VStack
                        {
                            Text("申报年份")
                                .font(.system(size: 30))
                                .fontWeight(.heavy)
                                .padding(.top ,5)
                            Spacer()
                            TextField("申报年份", text: $declarationyear)
                                .modifier(TextFieldViewModifier(width: 100))
                                .padding(.bottom , 20)
                        }
                        .frame(width: 150 , height: 100)
                        .border(.black)
                    }
                    
                    VStack
                    {
                        HStack
                        {
                            Text("品牌名称")
                                .font(.system(size: 30))
                                .fontWeight(.heavy)
                                .padding(.leading , 20)
                                .padding(.top , 5)
                            Spacer()
                        }
                        Spacer()
                        TextField("请输入品牌名称", text: $brandname)
                            .modifier(TextFieldViewModifier(width: 200))
                            .padding(.bottom , 20)
                    }
                    .frame(width: 308 , height: 80)
                    .border(.black)
                    
                    
                    HStack
                    {
                        Text("申报数据")
                            .font(.system(size: 40))
                            .fontWeight(.heavy)
                            .padding(.leading , 20)
                        Spacer()
                    }
                    
                    FormView()
                    
                }
                .frame(width: UIScreen.main.bounds.width - 50 , height: UIScreen.main.bounds.height - 150)
                .border(.black , width: 2)
            }
            
        }
        .onAppear{
            let prodiver = MoyaProvider<PackagingSummaryDeclarationRequestAPI>()
            prodiver.request(.find(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case.success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(PackagingSummaryDeclarationRequest.self, from: jsondata)
                        self.PackagingDatas = data.data.records.filter({ it in
                            it.registrationcode == self.RegNumber
                        })
                        self.brandname = self.PackagingDatas[0].brandname
                        self.declarationyear = String(self.PackagingDatas[0].declarationyear)
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
    packagingSummaryDeclarationSearchView(RegNumber: "Reg123456")
}
