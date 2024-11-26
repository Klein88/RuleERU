//
//  AgencyServiceInformationView_VAT.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/16.
//

import SwiftUI
import SlideOverCard
import Moya





struct AgencyServiceInformationView_VAT: View {
    @State var hadMTDAccount = ["是" , "否"]
    @State var selectionMDThave : Int = 0
    @Binding var TaxNumberEffectiveDate : Date
    @State var isshow_TaxNumberEffectiveDate_slider : Bool = false
    @State var isshow_LastDeclarationDate_slider : Bool = false
    @State var isshow_LastReportedDate_slider : Bool = false
    @Binding var LastDeclarationDate : Date
    @Binding var VATNumber : String
    @Binding var  LastReportedDate : Date
    @Binding var GatewayID : String
    @Binding var GatewayPassword : String
    @Binding var MTDUsername : String
    @Binding var MTDPassword : String
    @State var lastnumber : Int
    @Binding var isupload : Bool
    @EnvironmentObject var vatdocumentViewModel : VATDocumentViewModel
    var body: some View {
        ScrollView{
            VStack
            {
                HStack
                {
                    Text("填写VAT相关信息")
                        .font(.system(size: 30))
                        .fontWeight(.heavy)
                        .padding(.leading , 10)
                    Spacer()
                }
                HStack
                {
                    VStack
                    {
                        HStack
                        {
                            Text("VAT税号 :")
                                .frame(width: 100)
                                .padding(.leading , 10)
                            Spacer()
                            TextField("请输入VAT税号", text: $VATNumber)
                                .frame(width: UIScreen.main.bounds.width / 2 , height: 30)
                                .background(.white.opacity(0.9))
                                .cornerRadius(10)
                            Spacer()
                        }
                        .frame(width: UIScreen.main.bounds.width - 20 , height: 50)
                        .background(.gray.opacity(0.2))
                        .cornerRadius(10)
                        HStack
                        {
                            Text("税号生效日期 :")
                                .frame(width: 100)
                                .padding(.leading , 10)
                            Spacer()
                            Text("\(Calendar.current.component(.year, from: TaxNumberEffectiveDate))年\(Calendar.current.component(.month, from: TaxNumberEffectiveDate))月\(Calendar.current.component(.day, from: TaxNumberEffectiveDate))日")
                                .frame(width: UIScreen.main.bounds.width / 2 , height: 30)
                                .background(.white.opacity(0.9))
                                .cornerRadius(10)
                                .fontWeight(.heavy)
                                .onTapGesture {
                                    isshow_TaxNumberEffectiveDate_slider = true
                                }
                            Spacer()
                            Button(action: {
                                self.isshow_TaxNumberEffectiveDate_slider = true
                            }, label: {
                                Text("选择")
                                    .foregroundStyle(.white)
                            })
                            .frame(height: 20)
                            .background(.cyan)
                            .cornerRadius(5)
                            .padding(.trailing , 20)
                            
                        }
                        .frame(width: UIScreen.main.bounds.width - 20 , height: 50)
                        .background(.gray.opacity(0.2))
                        .cornerRadius(10)
                        //.border(.red)
                        HStack
                        {
                            Text("最后申报日期 :")
                                .frame(width: 100)
                                .padding(.leading , 10)
                            Spacer()
                            Text("\(Calendar.current.component(.year, from: LastDeclarationDate))年\(Calendar.current.component(.month, from: LastDeclarationDate))月\(Calendar.current.component(.day, from: LastDeclarationDate))日")
                                .frame(width: UIScreen.main.bounds.width / 2 , height: 30)
                                .background(.white.opacity(0.9))
                                .cornerRadius(10)
                                .fontWeight(.heavy)
                                .onTapGesture {
                                    isshow_LastDeclarationDate_slider = true
                                }
                            
                            Spacer()
                            Button(action: {
                                self.isshow_LastDeclarationDate_slider = true
                            }, label: {
                                Text("选择")
                                    .foregroundStyle(.white)
                            })
                            .frame(height: 20)
                            .background(.cyan)
                            .cornerRadius(5)
                            .padding(.trailing , 20)
                        }
                        .frame(width: UIScreen.main.bounds.width - 20 , height: 50)
                        .background(.gray.opacity(0.2))
                        .cornerRadius(10)
                        HStack
                        {
                            Text("下次申报开始日期 :")
                                .frame(width: 100)
                                .padding(.leading , 10)
                            Spacer()
                            Text("\(Calendar.current.component(.year, from: LastReportedDate))年\(Calendar.current.component(.month, from: LastReportedDate))月\(Calendar.current.component(.day, from: LastReportedDate))日")
                                .frame(width: UIScreen.main.bounds.width / 2 , height: 30)
                                .background(.white.opacity(0.9))
                                .cornerRadius(10)
                                .fontWeight(.heavy)
                                .onTapGesture {
                                    isshow_LastReportedDate_slider = true
                                }
                            
                            Spacer()
                            Button(action: {
                                self.isshow_LastReportedDate_slider = true
                            }, label: {
                                Text("选择")
                                    .foregroundStyle(.white)
                            })
                            .frame(height: 20)
                            .background(.cyan)
                            .cornerRadius(5)
                            .padding(.trailing , 20)
                        }
                        .frame(width: UIScreen.main.bounds.width - 20 , height: 50)
                        .background(.gray.opacity(0.2))
                        .cornerRadius(10)
                        HStack
                        {
                            Text("下次申报结束日期 :")
                                .frame(width: 100)
                                .padding(.leading , 10)
                            Spacer()
                            Text("\(Calendar.current.component(.year, from: LastReportedDate))年\(GetEndOfLastReportedDate(mouth:Calendar.current.component(.month, from: LastReportedDate)))月31日")
                                .frame(width: UIScreen.main.bounds.width / 2 , height: 30)
                                .cornerRadius(10)
                                .fontWeight(.heavy)
                            Spacer()
                        }
                        .frame(width: UIScreen.main.bounds.width - 20 , height: 50)
                        .background(.gray.opacity(0.2))
                        .cornerRadius(10)
                    }
                }
                .padding(.top , 20)
                
                HStack
                {
                    VStack
                    {
                        HStack
                        {
                            Text("GatewayID")
                                .padding(.leading , 10)
                            Spacer()
                        }
                        TextField("请输入GatewayID", text: $GatewayID)
                            .frame(height: 30)
                            .border(.gray.opacity(0.3),width : 5)
                            .padding(.leading , 10)
                    }
                    //.border(.red)
                    VStack
                    {
                        HStack
                        {
                            Text("Gateway Password")
                                .padding(.leading , 10)
                            Spacer()
                        }
                        TextField("请输入GatewayPassword", text: $GatewayPassword)
                            .frame(height: 30)
                            .border(.gray.opacity(0.3),width : 5)
                            .padding(.leading , 10)
                    }
                    //.border(.red)
                }
                .padding(.top , 20)
                Group{
                    VStack
                    {
                        HStack{
                            Text("是否已有MTD账号 :")
                            Picker(selection: $selectionMDThave) {
                                ForEach(0..<2)
                                {
                                    it in
                                    Text("\(hadMTDAccount[it])")
                                }
                            } label: {
                                ForEach(0..<2)
                                {
                                    it in
                                    Text("\(hadMTDAccount[it])")
                                }
                            }
                            .pickerStyle(.segmented)
                        }
                        
                        if selectionMDThave == 0
                        {
                            HStack
                            {
                                VStack
                                {
                                    HStack{
                                        Text("MTD账号")
                                            .padding(.leading , 10)
                                        Spacer()
                                    }
                                    TextField("请输入MTD账号" , text : $MTDUsername )
                                        .frame(height: 30)
                                        .border(.gray.opacity(0.3),width : 5)
                                        .padding(.leading , 10)
                                }
                                VStack
                                {
                                    HStack{
                                        Text("MTD账号密码")
                                            .padding(.leading , 10)
                                        Spacer()
                                    }
                                    TextField("请输入MTD账号密码", text: $MTDPassword) .frame(height: 30)
                                        .border(.gray.opacity(0.3),width : 5)
                                        .padding(.leading , 10)
                                }
                            }
                        }
                    }
                    .padding(.top , 10)
                    //.border(.red)
                }
                
                Group{
                    VStack
                    {
                        HStack
                        {
                            Text("VAT税号证书")
                                .font(.system(size: 20))
                                .fontWeight(.heavy)
                                .padding(.leading , 20)
                            Spacer()
                        }
                        DocumentUpView(uiimage: $vatdocumentViewModel.VATTaxZhengshu, imagename: "VAT税号证书" ,uploadname: String(self.lastnumber) + self.VATNumber + "VAT税号证书", isupload: $isupload)
                    }
                    .padding(.top , 20)
                    VStack
                    {
                        HStack
                        {
                            Text("最近三次VAT申报（最少上传一份）")
                                .font(.system(size: 20))
                                .fontWeight(.heavy)
                                .padding(.leading , 20)
                                
                            Spacer()
                        }
                        DocumentUpView(uiimage: $vatdocumentViewModel.VATDeclaration1,imagename: "最近三次VAT申报_示例1" ,uploadname: String(self.lastnumber) + self.VATNumber + "最近三次VAT申报1", isupload: $isupload)
                        DocumentUpView(uiimage: $vatdocumentViewModel.VATDeclaration2,imagename: "最近三次VAT申报_示例2" ,uploadname: String(self.lastnumber) + self.VATNumber + "最近三次VAT申报2", isupload: $isupload)
                        DocumentUpView(uiimage: $vatdocumentViewModel.VATDeclaration3,imagename: "最近三次VAT申报_示例3" ,uploadname: String(self.lastnumber) + self.VATNumber + "最近三次VAT申报3", isupload: $isupload)
                    }
                    .padding(.top , 20)
                    VStack
                    {
                        HStack
                        {
                            Text("转代理承诺书")
                                .font(.system(size: 20))
                                .fontWeight(.heavy)
                                .padding(.leading , 20)
                                
                            Spacer()
                        }
                        DocumentUpView(uiimage: $vatdocumentViewModel.ZhaunDailiChangNuoShu,imagename: "转代理承诺书" , uploadname: String(self.lastnumber) + self.VATNumber + "转代理承诺书", isupload: $isupload)
                    }
                    .padding(.top , 20)
                    Text("")
                        .frame(height : 50)
                }
                
            }
        }
        .navigationTitle("VAT信息")
        .slideOverCard(isPresented: $isshow_TaxNumberEffectiveDate_slider) {
            DatePicker("税号生效日期", selection: $TaxNumberEffectiveDate , displayedComponents: .date)
                .datePickerStyle(.graphical)
        }
        .slideOverCard(isPresented: $isshow_LastDeclarationDate_slider) {
            VStack{
                Text("最后一次申报周期结束日：例如：您的前代理最后一次帮你申报的是2020年1月份的VAT，则填写2020.1.31")
                DatePicker("最后申报日期", selection: $LastDeclarationDate , displayedComponents: .date)
                    .datePickerStyle(.graphical)
            }
        }
        .slideOverCard(isPresented: $isshow_LastReportedDate_slider) {
            VStack{
                Text("您使用app为税号首次申报的日期：比如购买app授权后，您首次需要申报2020年2月份的VAT，请填写2020.02.01")
                DatePicker("下次开始申报日期", selection: $LastReportedDate  , displayedComponents: .date)
                    .datePickerStyle(.graphical)
            }
        }
        
    }
}

