//
//  AgencyServiceInformationView_Company.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/17.
//

import SwiftUI

struct AgencyServiceInformationView_Company: View {
    @Binding var CompanyRegistrationLocation : String
    @Binding var CompanyName : String
    @State var CompanySelection : Int = 0
    @Binding var BusinessLicenseNumber : String
    @Binding var CompanyEstablishmentDate : Date
    @State var isshowCompanyEstablishmentDate : Bool = false
    @Binding var CompanyOperationalAddress : String
    @Binding var PostalCode : String
    @Binding var CompanyPhoneNumber : String
    @Binding var CompanyContactEmail : String
    @State var lastnumber : Int
    @Binding var isupload : Bool
    @Binding var VATNumber : String
    @EnvironmentObject var vatdocumentViewModel : VATDocumentViewModel
    var body: some View {
        ScrollView{
            VStack
            {
                Group{
                    HStack
                    {
                        Text("选择公司注册地")
                            .font(.system(size: 20))
                            .fontWeight(.bold)
                            .padding(.leading , 10)
                        Spacer()
                    }
                    HStack
                    {
                        Button(action: {
                            self.CompanyRegistrationLocation = "大陆公司"
                            self.CompanySelection = 0
                        }, label: {
                            Text("大陆公司")
                                .foregroundStyle(self.CompanySelection == 0 ? .blue : .black)
                                .frame(width: UIScreen.main.bounds.width / 3 - 10 , height: 40)
                                .border(self.CompanySelection == 0 ? .blue : .black)
                        })
                        Button(action: {
                            self.CompanyRegistrationLocation = "港台公司"
                            self.CompanySelection = 1
                        }, label: {
                            Text("港台公司")
                                .foregroundStyle(self.CompanySelection == 1 ? .blue : .black)
                                .frame(width: UIScreen.main.bounds.width / 3 - 10 , height: 40)
                                .border(self.CompanySelection == 1 ? .blue : .black)
                        })
                        Button(action: {
                            self.CompanyRegistrationLocation = "其他公司"
                            self.CompanySelection = 2
                        }, label: {
                            Text("其他公司")
                                .foregroundStyle(self.CompanySelection == 2 ? .blue : .black)
                                .frame(width: UIScreen.main.bounds.width / 3 - 10 , height: 40)
                                .border(self.CompanySelection == 2 ? .blue : .black)
                        })
                    }
                }
                Group
                {
                    VStack{
                        HStack
                        {
                            Text("填写公司名称并上传公司文件")
                                .font(.system(size: 20))
                                .fontWeight(.bold)
                                .padding(.leading , 10)
                            Spacer()
                        }
                        HStack
                        {
                            Text("公司名称")
                                .padding(.leading ,15)
                                .padding(.top , 10)
                            Spacer()
                        }
                        TextField("请填写公司名称", text: $CompanyName)
                            .frame(width: UIScreen.main.bounds.width - 30, height: 40)
                            .border(.gray)
                        
                        HStack
                        {
                            Text("上传公司营业执照")
                                .padding(.leading ,15)
                            Spacer()
                        }
                        .padding(.top , 10)
                        DocumentUpView(uiimage: $vatdocumentViewModel.GongsiYingYeZhiZao, imagename: "公司营业执照-示例" ,uploadname : String(self.lastnumber) + self.VATNumber + "公司营业执照" , isupload : $isupload)
                    }
                    .padding(.top , 15)
                }
                Group{
                    HStack
                    {
                        Text("填写公司营业信息")
                            .font(.system(size: 20))
                            .fontWeight(.bold)
                            .padding(.leading , 10)
                        Spacer()
                    }
                    HStack
                    {
                        VStack
                        {
                            HStack{
                                Text("营业执照号码/注册号")
                                    .padding(.leading , 10)
                                Spacer()
                            }
                            TextField("请输入营业执照号码/注册号", text: $BusinessLicenseNumber)
                                .frame(width: UIScreen.main.bounds.width / 2 - 10 , height : 30)
                                .border(.gray)
                                .padding(.leading , 10)
                        }
                        VStack
                        {
                            HStack
                            {
                                HStack{
                                    Text("公司成立日期")
                                        .padding(.leading , 10)
                                    Spacer()
                                }
                            }
                            Text("\(Calendar.current.component(.year, from: CompanyEstablishmentDate))年\(Calendar.current.component(.month, from: CompanyEstablishmentDate))月\(Calendar.current.component(.day, from: CompanyEstablishmentDate))日")
                                .frame(width: UIScreen.main.bounds.width / 2 - 10 , height : 30)
                                .border(.gray)
                                .onTapGesture {
                                    isshowCompanyEstablishmentDate = true
                                }
                        }
                    }
                    
                    HStack
                    {
                        VStack
                        {
                            HStack
                            {
                                Text("公司经营注册地址邮编")
                                    .padding(.leading , 10)
                                Spacer()
                            }
                            HStack
                            {
                                TextField("请输入所在地址", text: $CompanyOperationalAddress)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 85)
                                    .border(.gray)
                                    .padding(.leading , 10)
                                TextField("邮政编码", text: $PostalCode)
                                    .frame(width : 75)
                                    .border(.gray)
                                
                            }
                        }
                        VStack
                        {
                            HStack
                            {
                                Text("公司联系电话")
                                    .padding(.leading , 10)
                                Spacer()
                            }
                            HStack
                            {
                                TextField("公司联系电话", text: $CompanyPhoneNumber)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 10)
                                    .border(.gray)
                            }
                        }
                    }
                    HStack
                    {
                        VStack
                        {
                            HStack
                            {
                                Text("公司联系人邮箱")
                                    .padding(.leading , 10)
                                Spacer()
                                
                            }
                            HStack{
                                TextField("请输入公司联系人邮箱", text: $CompanyContactEmail)
                                    .frame(width: UIScreen.main.bounds.width - 50)
                                    .border(.gray)
                                    .padding(.leading , 10)
                                Spacer()
                            }
                        }
                        
                        Spacer()
                    }
                }//----
            }
        }
        .navigationTitle("公司信息")
        .slideOverCard(isPresented: $isshowCompanyEstablishmentDate){
            DatePicker("公司成立日期", selection: $CompanyEstablishmentDate, displayedComponents: .date)
                .datePickerStyle(.graphical)
        }
    }
}

