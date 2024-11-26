//
//  AgencyServiceInformationView_Legal.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/17.
//

import SwiftUI

struct AgencyServiceInformationView_Legal: View {
    @State var selecton_legal_message : Int = 0
    @Binding var LegalRepresentativeName : String
    @State var lastnumber : Int
    @Binding var isupload : Bool
    @Binding var VATNumber : String
    @EnvironmentObject var vatdocumentViewModel : VATDocumentViewModel
    var body: some View {
        ScrollView{
            VStack
            {
                HStack
                {
                    Text("法人代表信息")
                        .font(.system(size: 30))
                        .fontWeight(.heavy)
                        .padding(.leading , 10)
                    Spacer()
                }
                HStack{
                    Text("上传法人代表证件信息:")
                        .padding(.leading , 15)
                    Text("法人身份证")
                        .frame(width: 100 , height: 40)
                        .foregroundStyle(self.selecton_legal_message == 0 ? .blue : .black)
                        .border(self.selecton_legal_message == 0 ? .blue : .black)
                        .onTapGesture {
                            self.selecton_legal_message = 0
                        }
                    Text("法人护照")
                        .frame(width: 100 , height: 40)
                        .foregroundStyle(self.selecton_legal_message == 1 ? .blue : .black)
                        .border(self.selecton_legal_message == 1 ? .blue : .black)
                        .padding(.leading , 5)
                        .padding(.trailing , 10)
                        .onTapGesture {
                            self.selecton_legal_message = 1
                        }
                }
                .padding(.top , 20)
                
                VStack{
                    HStack
                    {
                        Text("法人代表身份证（人像面）")
                            .padding(.leading , 10)
                        Spacer()
                    }
                    DocumentUpView(uiimage: $vatdocumentViewModel.Legal_example_front,imagename: "Legal_example_front" ,uploadname : String(self.lastnumber) + self.VATNumber + "Legal_example_front" , isupload : $isupload)
                    DocumentUpView(uiimage: $vatdocumentViewModel.Legal_example_back,imagename: "Legal_example_back"  ,uploadname : String(self.lastnumber) + self.VATNumber + "Legal_example_back" , isupload : $isupload)
                }
                Group{
                    HStack
                    {
                        Text("填写法人代表信息")
                            .padding(.leading, 10)
                        Spacer()
                    }
                    HStack
                    {
                        VStack
                        {
                            HStack
                            {
                                Text("法人代表中文名")
                                    .padding(.leading , 10)
                                Spacer()
                            }
                            HStack
                            {
                                TextField("请输入法人代表中文名", text: $LegalRepresentativeName)
                                    .frame(width: UIScreen.main.bounds.width / 2 - 10)
                                    .border(.gray)
                                    .padding(.leading , 10)
                                    
                            }
                        }
                        VStack
                        {
                            HStack
                            {
                                Text("法人代表出生日期")
                                    .padding(.leading , 10)
                                Spacer()
                            }
                            Text("2003年05月01日")
//                                .frame(width: UIScreen.main.bounds.width / 2 - 10)
//                                .border(.gray)
//                                .padding(.leading , 10)
                            
                        }
                    }
                }
                Group{
                    HStack
                    {
                        Text("扫码签名")
                            .padding(.leading , 10)
                        Spacer()
                    }
                    DocumentUpView(uiimage: $vatdocumentViewModel.Legal_example_签字,imagename: "Legal_example_签字" ,uploadname : String(self.lastnumber) + self.VATNumber + "Legal_example_签字" , isupload : $isupload)
                    Text("")
                        .frame(height : 80)
                }
            }
        }
        .navigationTitle("法人代表信息")
    }
}
