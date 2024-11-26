//
//  PackagingSummaryDeclarationView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/5.
//

import SwiftUI
import Moya
import SlideOverCard
struct PackagingSummaryDeclarationView: View {
    @State var RegNumber : String
    @State var PackagingDatas : [PackagingSummaryDeclarationRequestrecord] = [PackagingSummaryDeclarationRequestrecord]()
    @State var declarationyear : String  = ""
    @State var brandname : String = ""
    @State var isshowadd : Bool = false
    @Environment(\.presentationMode) var pre
    @State var packagingmaterial : String = ""
    @State var predeclaredweight : String = ""
    @State var actualpackagingweight : String = ""
    
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
                Button(action: {
                    let prodiver = MoyaProvider<PackagingSummaryDeclarationRequestAPI>()
                    for it in PackagingDatas
                    {
                        prodiver.request(.add(packagingsummarydeclarationrequestrecord: it)) { result in
                            switch result
                            {
                            case .success(_):
                                self.pre.wrappedValue.dismiss()
                            case .failure(_):
                                break
                            }
                        }
                    }
                    
                }, label: {
                    Text("提交")
                        .foregroundStyle(.white)
                        .font(.system(size: 40))
                        .fontWeight(.heavy)
                        .frame(width: 100 , height: 60)
                        .background(.blue)
                        .cornerRadius(20)
                    
                })
                .padding(.bottom , 80)
            }
            
        }
        .slideOverCard(isPresented: $isshowadd) {
            AddPackagingData()
        }
    }
    
    
    
    @ViewBuilder
    private func AddPackagingData() -> some View
    {
        VStack
        {
            HStack
            {
                Text("包装材料")
                TextField("请输入包装材料", text: $packagingmaterial)
            }
            
            HStack
            {
                Text("预估计重量")
                TextField("请输入预估计重量", text: $predeclaredweight)
            }
            HStack
            {
                Text("实际重量")
                TextField("请输入实际重量", text: $actualpackagingweight)
            }
            Button(action: {
                self.PackagingDatas.append(PackagingSummaryDeclarationRequestrecord( registrationcode: self.RegNumber, declarationyear: Int(self.declarationyear)!, brandname: self.brandname, declarationdataserialnumber: self.PackagingDatas.count + 1, packagingmaterial: self.packagingmaterial, predeclaredweight: Double(self.predeclaredweight)!, actualpackagingweight: Double(self.actualpackagingweight)!, eprdeclarationid: 1))
            }, label: {
                Text("添加")
                    .foregroundStyle(.white)
                    .font(.system(size: 40))
                    .fontWeight(.heavy)
                    .frame(width: 100 , height: 60)
                    .background(.blue)
                    .cornerRadius(20)
            })
        }
    }
    
    
    
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
            HStack
            {
                Spacer()
                Button(action: {
                    self.isshowadd = true
                   
                }, label: {
                    Image(systemName: "plus.circle")
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 40)
                        .padding(.trailing , 20)
                        .padding(.top , 20)
                })
            }
        }
    }
    
    
    
    
}

#Preview {
    PackagingSummaryDeclarationView(RegNumber: "Reg123456")
}
