//
//  addVATServiceView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/24.
//

import SwiftUI
import Moya



struct addVATServiceView: View {
    @Binding var isshowaddView : Bool
    @State var selection : Int = 0
    @State var Tax : TaxServiceRequestrecord = TaxServiceRequestrecord(taxtype: "季度申报", country: "", servicetype: "VAT转申报", companyname: "", vatnumber: "", serviceprogress: "未提交资料", taxrate: 0, servicesummit: 0)
    var body: some View {
        ScrollView(showsIndicators: false){
            VStack{
                
                addVATServiceView_Step1(Tax: $Tax)
                
                addVATServiceView_Step2(Tax: $Tax)
                    .padding(.top , 30)
                
                
                Button(action: {
                    self.Tax.vatnumber = ReturnDutyParagraphByCountry(country: Tax.country) + Tax.vatnumber
                    let prodiver  = MoyaProvider<TaxServiceRequestAPI>()
                    prodiver.request(.add(taxtervicetequestrecord: Tax)) { result in
                        switch result
                        {
                        case.success(let req):
                            do
                            {
                                let jsondata = req.data
                                let data = try JSONDecoder().decode(TaxServiceAddSuccessRequest.self, from: jsondata)
                                if data.code == 20000
                                {
                                    
                                }
                            }catch let error
                            {
                                print(error)
                            }
                            
                        case.failure(_):
                            break
                        }
                    }
                    
                    self.isshowaddView = false
                }, label: {
                    Text("提交")
                        .foregroundColor(.white)
                        .font(.system(size: 30))
                        .fontWeight(.heavy)
                        .frame(width: 150 , height: 60)
                        .background(.blue)
                        .cornerRadius(20)
                })
                .padding(.top , 30)
                .padding(.bottom , 30)
                
            }
        }
        .navigationTitle("添加已有VAT税号")
    }
}

struct addVATServiceView_Step1 : View {
    let country : [String] = ["英国","德国","法国","意大利","西班牙"]
    @State var countrySelection : [Bool] = [false ,false ,false ,false ,false]
    @Binding var Tax : TaxServiceRequestrecord
    @State var selection : Int = 0
    var body: some View {
        VStack{
            Text("1")
                .font(.system(size: 60))
                .foregroundColor(.white)
                .fontWeight(.heavy)
                .frame(width: 100 , height: 100)
                .background(.blue)
                .cornerRadius(50)
            Text("选择国家")
            
            HStack{
                Text("公司名称 : ")
                    .font(.system(size: 30))
                    .fontWeight(.heavy)
                    
                TextField("请输入公司名称", text: $Tax.companyname)
                    .frame(height: 40)
                    .border(.gray,width: 2)
            }
            .padding(.leading , 20)
            HStack
            {
                Text("税号国家 : ")
                    .font(.system(size: 30))
                    .fontWeight(.heavy)
                ScrollView(.horizontal , showsIndicators: false){
                    HStack{
                        ForEach(0..<country.count) { it in
                            HStack{
                                Image(systemName: countrySelection[it] ? "checkmark" : "")
                                    .foregroundColor(.blue)
                                    .frame(width: 20 , height: 20)
                                    .border(countrySelection[it] ? .blue : .black)
                                    .onTapGesture {
                                        for itt in 0..<countrySelection.count
                                        {
                                            if itt == it
                                            {
                                                countrySelection[itt] = true
                                                Tax.country = country[itt]
                                            }
                                            else
                                            {
                                                countrySelection[itt] = false
                                            }
                                            
                                        }
                                        
                                    }
                            
                                Image(country[it])
                                    .resizable()
                                    .aspectRatio(contentMode: .fit)
                                    .frame(width: 20)
                                Text(country[it])
                            }
                            .padding(.leading , 20)
                        }
                    }
                }
            }
            .padding(.leading , 20)
            Text("提示 : 请勾选已注册VAT税号的国家,否则会影响VAT归属国的判定，进而导致VAT计算不准确")
                .foregroundColor(.red)
        }
    }
}


struct addVATServiceView_Step2 : View {
    @Binding var Tax : TaxServiceRequestrecord
    var body: some View {
        VStack{
            Text("2")
                .font(.system(size: 60))
                .foregroundColor(.white)
                .fontWeight(.heavy)
                .frame(width: 100 , height: 100)
                .background(.blue)
                .cornerRadius(50)
            Text("填写税号信息")
            
            HStack{
                Text("国家 : \(Tax.country)")
                    .font(.system(size: 30))
                    .fontWeight(.heavy)
                Image(Tax.country)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 40)
                Spacer()
            }
            .padding(.leading , 20)
            HStack
            {
                Text("税号 :")
                    .font(.system(size: 30))
                    .fontWeight(.heavy)
                HStack(spacing: 0){
                    Text("\(ReturnDutyParagraphByCountry(country:Tax.country))")
                        .frame(width: 40 , height: 40)
                        .border(.gray,width: 2)
                    
                    TextField("请输入不超过16位的税号", text : $Tax.vatnumber)
                        .frame(height: 40)
                        .border(.gray,width: 2)
                }
                Spacer()
            }
            .padding(.leading , 20)
            HStack{
                Text("税率 (%):")
                    .font(.system(size: 30))
                    .fontWeight(.heavy)
                
                Menu {
                    ForEach(ReturnDeclarationByCountry(country: Tax.country) , id : \.self){
                         it in
                        Button(action: {
                            Tax.taxrate = Double(it * 100.00)
                        }, label: {
                            Text("\(it * 100)")
                        })
                        
                    }
                } label: {
                    Text("\(Tax.taxrate)")
                        .frame(width: 100 , height: 40)
                        .border(.gray)
                        .shadow(radius: 10 , x : 5, y : 5)
                }

                Spacer()
            }
            .padding(.leading , 20)
            
            HStack{
                Text("申报规则 : 目的国")
                    .font(.system(size: 30))
                    .fontWeight(.heavy)
                Spacer()
            }
            .padding(.leading , 20)
            
            HStack
            {
                Text("申报周期 : 每个季度")
                    .font(.system(size: 30))
                    .fontWeight(.heavy)
                Spacer()
            }
            .padding(.leading , 20)
        }
    }
}

