//
//  ConsumptionView_Add.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/12.
//

import SwiftUI
import Moya

struct ConsumptionView_Add: View {
    @Binding var isshowAdd : Bool
    @State var complianceapplicationRequestrecord = ComplianceapplicationRequestrecord( filetype: "", companyname: "", productchinesename: "", productenglishname: "", trademark: "", applicationdate: "")
    @State var applicationdate : Date = Date()
    var body: some View {
        Form
        {
            
            Section(header: Text("公司名称").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                TextField("请输入公司名称", text: $complianceapplicationRequestrecord.companyname)
            }
            
            Section(header: Text("文件类型").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                
            }
            
            Section(header: Text("产品中文名字").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                TextField("请输入产品中文名字", text: $complianceapplicationRequestrecord.productchinesename)
            }
            Section(header: Text("产品英文名字").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)) {
                TextField("请输入产品英文名字", text: $complianceapplicationRequestrecord.productenglishname)
            }
            Section{
                VStack{
                    DatePicker("办理日期", selection: $applicationdate , displayedComponents: [.date])
                    Button(action: {
                        
                        let dateFormatter = DateFormatter()
                        dateFormatter.dateFormat = "yyyy-MM-dd"
                        self.complianceapplicationRequestrecord.applicationdate = dateFormatter.string(from: self.applicationdate)
                        let prodiver = MoyaProvider<ComplianceapplicationRequestAPI>()
                        
                        prodiver.request(.add(complianceapplicationrequestrecord: self.complianceapplicationRequestrecord)) { result in
                            switch result
                            {
                            case .success(_):
                                self.isshowAdd = false
                                
                            case .failure(_):
                                break
                            }
                        }
                        
                    }, label: {
                        Text("添加")
                            .font(.system(size: 25))
                            .fontWeight(.heavy)
                            .foregroundStyle(.white)
                            .frame(width: 150 , height: 60)
                            .background(.blue)
                            .cornerRadius(20)
                    })
                }
            }
            

                
                
            
            
        }
    }
}

#Preview {
    HomeView()
}
