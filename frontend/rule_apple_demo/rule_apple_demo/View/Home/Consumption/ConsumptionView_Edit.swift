//
//  ConsumptionView_Edit.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/12.
//

import SwiftUI
import Moya




struct ConsumptionView_Edit: View {
    @Environment(\.presentationMode) var pre
    @State var applicationid : Int
    @State var eudeclarationofconformityrecord : Eudeclarationofconformityrecord = Eudeclarationofconformityrecord( manufacturername: "", businessaddress: "", authorizedrepresentative: "", productserialnumber: "", modelortypeidentification: "", responsibilitystatement: "", productidentification: "", notifiedbodydetails: "", legislationandstandards: "", signatoryname: "", declarationdate: "", supplementaryinformation: "", importerresponsibility: "", translationrequirement: "", signatorysignature: Data(), productimage: Data(), applicationid: 1)
    @State var declarationdate : Date = Date()
    @State var isupload : Bool = false
    @EnvironmentObject var consumptionViewModel :  ConsumptionViewModel
    var body: some View {
        Form{
            Section(header: Text("制造商名称").font(.system(size: 30)).fontWeight(.heavy).foregroundStyle(.black)) {
                TextField("请输入制造商名称", text: $eudeclarationofconformityrecord.manufacturername)
            }
            Group{
                Section{
                    VStack{
                        
                        
                        HStack{
                            VStack
                            {
                                HStack{
                                    Text("公司地址")
                                        .font(.system(size: 30))
                                        .fontWeight(.heavy)
                                        .foregroundStyle(.black)
                                    
                                    Spacer()
                                }
                                TextField("请输入公司地址", text: $eudeclarationofconformityrecord.businessaddress)
                                
                            }
                            VStack{
                                HStack
                                {
                                    Text("授权代表")
                                        .font(.system(size: 30))
                                        .fontWeight(.heavy)
                                        .foregroundStyle(.black)
                                    
                                    Spacer()
                                    
                                }
                                TextField("请输入授权代表", text: $eudeclarationofconformityrecord.authorizedrepresentative)
                            }
                        }
                        
                        HStack{
                            
                            
                            VStack
                            {
                                HStack
                                {
                                    Text("产品序列号")
                                        .font(.system(size: 23))
                                        .fontWeight(.heavy)
                                        .foregroundStyle(.black)
                                    
                                    Spacer()
                                }
                                TextField("请输入产品序列号", text: $eudeclarationofconformityrecord.productserialnumber)
                            }
                            
                            VStack
                            {
                                HStack
                                {
                                    Text("型号或类型标识")
                                        .font(.system(size: 23))
                                        .fontWeight(.heavy)
                                        .foregroundStyle(.black)
                                    
                                    Spacer()
                                }
                                TextField("请输入型号或类型标识", text: $eudeclarationofconformityrecord.modelortypeidentification)
                            }
                            
                        }
                        .padding(.top, 20)
                        
                    }
                }
                
                Section(header: Text("责任声明").font(.system(size: 30)).fontWeight(.heavy).foregroundStyle(.black)) {
                    TextField("请填写责任声明", text: $eudeclarationofconformityrecord.responsibilitystatement)
                        .frame(height: 70)
                }
                
                Section(header: Text("产品识别手段").font(.system(size: 30)).fontWeight(.heavy).foregroundStyle(.black)) {
                    DocumentUpView(uiimage : $consumptionViewModel.ChanPingShiBieShouDuan ,imagename: "Product_Part_5_2" , uploadname : eudeclarationofconformityrecord.productserialnumber + "产品识别手段" , isupload : $isupload)
                        .scaleEffect(0.7)
                }
                
                Section{
                    HStack
                    {
                        Text("机构详细信息")
                            .font(.system(size: 30)).fontWeight(.heavy).foregroundStyle(.black)
                        Spacer()
                        
                    }
                    TextField("请填写机构详细信息", text: $eudeclarationofconformityrecord.notifiedbodydetails)
                    HStack{
                        Text("遵守的相关法律和标准")
                            .font(.system(size: 30)).fontWeight(.heavy).foregroundStyle(.black)
                        Spacer()
                        
                    }
                    .padding(.top , 20)
                    TextField("请填写所遵守法律和标准", text: $eudeclarationofconformityrecord.legislationandstandards)
                    
                }
            }
            Group{
                Section(header: Text("签名者信息").font(.system(size: 30)).fontWeight(.heavy).foregroundStyle(.black)) {
                    DocumentUpView(uiimage : $consumptionViewModel.Legal_example_签字 , imagename: "Legal_example_签字" , uploadname : eudeclarationofconformityrecord.productserialnumber + "签名者信息" , isupload : $isupload)
                        .scaleEffect(0.7)
                }
                Section {
                    DatePicker("声明签发日期", selection: $declarationdate , displayedComponents: [.date])
                }
                Section(header: Text("补充信息").font(.system(size: 30)).fontWeight(.heavy).foregroundStyle(.black)) {
                    TextField("请填写补充信息", text: $eudeclarationofconformityrecord.supplementaryinformation)
                        .frame(height : 70)
                }
                Section(header: Text("进口商责任").font(.system(size: 30)).fontWeight(.heavy).foregroundStyle(.black)) {
                    TextField("请填写进口商责任", text: $eudeclarationofconformityrecord.importerresponsibility)
                }
                Section(header: Text("翻译要求").font(.system(size: 30)).fontWeight(.heavy).foregroundStyle(.black)) {
                    TextField("请填写进口商责任", text: $eudeclarationofconformityrecord.translationrequirement)
                }
            }
            Section(header: Text("产品图片(可选)").font(.system(size: 30)).fontWeight(.heavy).foregroundStyle(.black)) {
                    DocumentUpView(uiimage : $consumptionViewModel.Baozhuang ,imagename: "包装" , uploadname : eudeclarationofconformityrecord.productserialnumber + "产品图片" , isupload : $isupload)
                        .scaleEffect(0.7)
            }
            Section{
                HStack{
                    Spacer()
                    Button(action: {
                        self.eudeclarationofconformityrecord.applicationid = self.applicationid
                        let dateFormatter = DateFormatter()
                        dateFormatter.dateFormat = "yyyy-MM-dd"
                        self.eudeclarationofconformityrecord.declarationdate = dateFormatter.string(from: self.declarationdate)
                        self.isupload = true
                        
                        let prodiver = MoyaProvider<EudeclarationofconformityRequestAPI>()
                        prodiver.request(.add(eudeclarationofconformityrecord: self.eudeclarationofconformityrecord)){
                            result in
                            switch result
                            {
                            case .success(_):
                                self.pre.wrappedValue.dismiss()
                            case .failure(_):
                                break
                            }
                        }
                        
                        
                    }, label: {
                        Text("添加")
                            .foregroundStyle(.white)
                            .font(.system(size : 20))
                            .fontWeight(.heavy)
                            .frame(width: 100, height: 60)
                            .background(.blue)
                            .cornerRadius(20)
                    })
                    Spacer()
                }
            }
            
            
        }
        .navigationTitle("服务资料填写")
    }
}

#Preview {
    ConsumptionView_Edit(applicationid: 1)
        .environmentObject(ConsumptionViewModel())
}
