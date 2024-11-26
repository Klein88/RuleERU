//
//  addEPRServiceView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/29.
//

import SwiftUI
import Moya
struct addEPRServiceView: View {
    @Binding var isshowaddEPRServiceView : Bool
    let country : [String] = ["英国","法国","德国","意大利","奥地利","波兰","捷克","西班牙","荷兰"]
    @State var EPRService : EprserviceRequestrecord = EprserviceRequestrecord( companyname: "", registrationnumber: "", country: "请选择国家", servicetype: "EPR转申报", servicesummit: 0)
    var body: some View {
        VStack
        {
            HStack
            {
                Text("公司名称:")
                    .font(.system(size: 25))
                    .fontWeight(.heavy)
                    .padding(.leading , 30)
                TextField("请输入公司名称", text:$EPRService.companyname)
                Spacer()
            }
            .frame(height: 50)
            
            HStack
            {
                Text("国家:")
                    .font(.system(size: 25))
                    .fontWeight(.heavy)
                    .padding(.leading , 30)
                Menu {
                    ForEach(0..<country.count)
                    {
                        it in
                        Button(action: {
                            self.EPRService.country = country[it]
                        }, label: {
                            Text("\(country[it])")
                        })
                    }
                } label: {
                    Text("\(self.EPRService.country)")
                        .frame(width: 100 , height: 30)
                }
                Spacer()
            }
            .frame(height: 50)
            HStack
            {
                Text("注册号:")
                    .font(.system(size: 25))
                    .fontWeight(.heavy)
                    .padding(.leading , 30)
                TextField("请输入注册号:", text: $EPRService.registrationnumber)
                Spacer()
            }
            .frame(height: 50)
            
            
            Button(action: {
                let prodiver = MoyaProvider<EprserviceRequestAPI>()
                prodiver.request(.add(eprservicerequestrecord: EPRService)) { result in
                    switch result{
                    case .success(let req) :
                        do
                        {
                            let jsondata = req.data
                            let data = try JSONDecoder().decode(EprserviceSuccessRequest.self, from: jsondata)
                            self.isshowaddEPRServiceView = false
                        }catch let error
                        {
                            print(error)
                        }
                    case.failure(_):
                        break
                    }
                }
                
            }, label: {
                Text("添加注册号")
                    .font(.system(size: 20))
                    .fontWeight(.heavy)
                    .foregroundStyle(.white)
                    .frame(width: 140 ,height: 50)
                    .background(.blue)
                    .cornerRadius(20)
            })
        }
        .padding(.bottom , 40)
    }
}

