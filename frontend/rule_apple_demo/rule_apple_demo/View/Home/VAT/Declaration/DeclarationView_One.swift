//
//  DeclarationView_One.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/26.
//

import SwiftUI

struct DeclarationView_One: View {
    @State var taxdeclaration : TaxdeclarationRequestrecord
    @State var isshowDocument : Bool = false
    @State var country : String = "英国"
    @State var isToVATdeclarationView : Bool = false
    var body: some View {
        ZStack{
            Color.blue
            VStack
            {
                HStack
                {
                    Text("公司名称 : ")
                        .font(.system(size: 25))
                        .fontWeight(.heavy)
                        .foregroundColor(.blue)
                        .padding(.leading , 20)
                    Text("\(self.taxdeclaration.companyname)")
                        .font(.system(size: 20))
                        .fontWeight(.heavy)
                    Spacer()
                }
                
                Divider()
                    .frame(width: UIScreen.main.bounds.width - 50)
                HStack
                {
                    VStack{
                        Text("申报国家")
                            .font(.system(size: 25))
                            .fontWeight(.heavy)
                            .foregroundColor(.blue)
                        Text("\(self.country)")
                            .font(.system(size: 20))
                            .fontWeight(.heavy)
                    }
                    .padding(.leading , 50)
                    Spacer()
                    Divider()
                        .frame(height: 30)
                        .foregroundColor(.gray)
                    Spacer()
                    VStack
                    {
                        Text("税号")
                            .font(.system(size: 25))
                            .fontWeight(.heavy)
                            .foregroundColor(.blue)
                        Text("\(self.taxdeclaration.vatnumber)")
                            .font(.system(size: 20))
                            .fontWeight(.heavy)
                    }
                    .padding(.trailing , 50)
                    
                }
                Divider()
                    .frame(width: UIScreen.main.bounds.width - 50)
                
                HStack{
                    VStack{
                        Text("待申报期间")
                            .font(.system(size: 25))
                            .fontWeight(.heavy)
                            .foregroundColor(.blue)
                        Text("\(Calendar.current.component(.year, from: stringConvertDate(string: errorDateStringToTrueString(errorDate: self.taxdeclaration.lastreporteddate))))年\(Calendar.current.component(.month, from: stringConvertDate(string: errorDateStringToTrueString(errorDate: self.taxdeclaration.lastreporteddate))))月--\(Calendar.current.component(.year, from: stringConvertDate(string: errorDateStringToTrueString(errorDate: self.taxdeclaration.lastreporteddate))))年\(GetEndOfLastReportedDate(mouth:Calendar.current.component(.month, from: stringConvertDate(string: errorDateStringToTrueString(errorDate: self.taxdeclaration.lastreporteddate)))))月")
                    }
                    
                    VStack
                    {
                        Text("申报截止日期")
                            .font(.system(size: 25))
                            .fontWeight(.heavy)
                            .foregroundColor(.blue)
                        Text("\((Calendar.current.component(.year, from: stringConvertDate(string: errorDateStringToTrueString(errorDate: self.taxdeclaration.lastreporteddate))) + (Calendar.current.component(.month, from: stringConvertDate(string: errorDateStringToTrueString(errorDate: self.taxdeclaration.lastreporteddate))) + 4 ) / 12))年\((Calendar.current.component(.month, from: stringConvertDate(string: errorDateStringToTrueString(errorDate: self.taxdeclaration.lastreporteddate))) + 4) % 12 )月7日")
                    }
                    
                }
                HStack
                {
                    Spacer()
                    Button(action: {
                        self.isToVATdeclarationView = true
                    }, label: {
                        Text("发起申报")
                            .frame(width: UIScreen.main.bounds.width / 3 - 30 , height: 50)
                            .font(.system(size: 20))
                            .fontWeight(.heavy)
                            .foregroundColor(.white)
                            .background(.blue)
                            .cornerRadius(15)
                        NavigationLink(destination: VATDeclarationView( companyname: taxdeclaration.companyname),isActive: $isToVATdeclarationView ,label: {EmptyView()})
                    })
                    
                    Spacer()
                    
                    Button(action: {
                        
                    }, label: {
                        Text("跳过校验")
                            .frame(width: UIScreen.main.bounds.width / 3 - 30 , height: 50)
                            .font(.system(size: 20))
                            .fontWeight(.heavy)
                            .foregroundColor(.white)
                            .background(.blue)
                            .cornerRadius(15)
                    })
                    Spacer()
                    
                }
            }
            .frame(width: UIScreen.main.bounds.width - 10 , height: 350)
            .background(.white)
            .cornerRadius(40)
            .overlay(alignment: .topTrailing) {
                Button(action: {
                    self.isshowDocument = true
                }, label: {
                    Text("查看文件")
                    NavigationLink(destination: DeclarationView_Document(vatnumber: self.taxdeclaration.vatnumber),isActive: $isshowDocument  ,label: {EmptyView()})
                })
                
                .padding(.trailing , 20)
                .padding(.top , 20)
            }
        }
        .frame(width: UIScreen.main.bounds.width , height: 360)
        .cornerRadius(40)
    }
}

#Preview {
    DeclarationView_One(taxdeclaration: TaxdeclarationRequestrecord( vatnumber: "GB123456", taxrate: 0.2, taxnumbereffectivedate: "2023-10-22T16:00.00.00.00", lastdeclarationdate: "2023-10-22T16:00.00.00.00", gatewayid: "", gatewaypassword: "", lastreporteddate: "2023-11-30T", mtdusername: "", mtdpassword: "", companyregistrationlocation: "", companyname: "欧税通有限责任公司", businesslicensenumber: "", companyestablishmentdate: "2023-06-30T16:00.00.00.00", companyoperationaladdress: "", postalcode: "", companyphonenumber: "", companycontactemail: "", legalrepresentativename: "", mainsalesplatform: "", shopname: "", informationlink: "", shopbackendselleraddress: "", shopbackendcompanyname: "", mainbusinessscope: "", vatcertificate: Data(), vatdeclarationdocument: Data(), proxycommitmentdocumen: Data(), companyregistrationproof: Data(), idcardfront: Data(), idcardback: Data(), signature: Data()))
}
