//
//  EPRdeclarationView_One.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/31.
//

import SwiftUI
import Moya

struct EPRdeclarationView_One: View {
    @State var EPRdeclaration : EprdeclarationRequest_1record
    
    @State var country : String = "英国"
    @State var isToPackagingSummaryDeclarationView : Bool = false
    @State var isToPackagingSummartDeclarationSearchView : Bool = false
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
                        Text("\(self.EPRdeclaration.companyname)")
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
                            Text("EPR注册号")
                                .font(.system(size: 25))
                                .fontWeight(.heavy)
                                .foregroundColor(.blue)
                            Text("\(self.EPRdeclaration.registrationnumber)")
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
                            Text("\(Calendar.current.component(.year, from: stringConvertDate(string: errorDateStringToTrueString(errorDate: self.EPRdeclaration.companyestablishmentdate))))年\(Calendar.current.component(.month, from: stringConvertDate(string: errorDateStringToTrueString(errorDate: self.EPRdeclaration.companyestablishmentdate))))月--\(Calendar.current.component(.year, from: stringConvertDate(string: errorDateStringToTrueString(errorDate: self.EPRdeclaration.companyestablishmentdate))))年\(GetEndOfLastReportedDate(mouth:Calendar.current.component(.month, from: stringConvertDate(string: errorDateStringToTrueString(errorDate: self.EPRdeclaration.companyestablishmentdate)))))月")
                        }
                        
                        VStack
                        {
                            Text("申报截止日期")
                                .font(.system(size: 25))
                                .fontWeight(.heavy)
                                .foregroundColor(.blue)
                            Text("\((Calendar.current.component(.year, from: stringConvertDate(string: errorDateStringToTrueString(errorDate: self.EPRdeclaration.companyestablishmentdate))) + (Calendar.current.component(.month, from: stringConvertDate(string: errorDateStringToTrueString(errorDate: self.EPRdeclaration.companyestablishmentdate))) + 4 ) / 12))年\((Calendar.current.component(.month, from: stringConvertDate(string: errorDateStringToTrueString(errorDate: self.EPRdeclaration.companyestablishmentdate))) + 4) % 12 )月7日")
                        }
                        
                    }
                    HStack
                    {
                        Spacer()
                        Button(action: {
                            self.isToPackagingSummaryDeclarationView = true
                        }, label: {
                            Text("发起申报")
                                .frame(width: UIScreen.main.bounds.width / 3 - 30 , height: 50)
                                .font(.system(size: 20))
                                .fontWeight(.heavy)
                                .foregroundColor(.white)
                                .background(.blue)
                                .cornerRadius(15)
                            NavigationLink(destination: PackagingSummaryDeclarationView(RegNumber: EPRdeclaration.registrationnumber), isActive: $isToPackagingSummaryDeclarationView,  label: {EmptyView()})
                        })
                        
                        Spacer()
                        
                        Button(action: {
                            self.isToPackagingSummartDeclarationSearchView = true
                        }, label: {
                            Text("查看申请")
                                .frame(width: UIScreen.main.bounds.width / 3 - 30 , height: 50)
                                .font(.system(size: 20))
                                .fontWeight(.heavy)
                                .foregroundColor(.white)
                                .background(.blue)
                                .cornerRadius(15)
                            NavigationLink(destination: packagingSummaryDeclarationSearchView(RegNumber: EPRdeclaration.registrationnumber), isActive: $isToPackagingSummartDeclarationSearchView,label: {EmptyView()})
                        })
                        Spacer()
                        
                    }
                }
                .frame(width: UIScreen.main.bounds.width - 10 , height: 270)
                .background(.white)
                .cornerRadius(20)
            
        }
        .frame(width: UIScreen.main.bounds.width , height: 280)
        .cornerRadius(20)
       
    }
    
    
    
    
    
    private func isToShowBlueOrGray() -> Bool
    {
        
        var TrueOrFalse : Bool = false
        let prodiver = MoyaProvider<PackagingSummaryDeclarationRequestAPI>()
        prodiver.request(.find(pageSize: 1, pageNum: 1)) { result in
            switch result
            {
            case .success(let req):
                do{
                    let jsondata = req.data
                    let data = try JSONDecoder().decode(PackagingSummaryDeclarationRequest.self, from: jsondata)
                    
                }catch let error
                {
                    print(error)
                }
                
            case .failure(_):
                break
            }
        }
        return TrueOrFalse
    }
    
    
    
    
}

#Preview {
    EPRdeclarationView_One(EPRdeclaration: EprdeclarationRequest_1record( companyregistrationlocation: "大陆公司", companyname: "欧税通有限公司", businesslicensenumber: "REG123456", companyestablishmentdate: "2023-10-23T", companyoperationaladdress: "杭州市XX区XX街道", postalcode: "323400", companyphonenumber: "+86 15557828205", companycontactemail: "1269814316@qq.com", legalrepresentativename: "邱文豪", mainsalesplatform: "亚马逊", shopname: "亚马逊销售店铺", informationlink: "www.baidu.com", shopbackendselleraddress: "杭州市XX区XX街道", shopbackendcompanyname: "欧税通有限公司", mainbusinessscope: "欧盟业务", brandcount: 5, brandenglishname: "llouvcey", companyregistrationproof: Data(), idcardfront: Data(), idcardback:Data() , signature: Data() , registrationnumber: "Reg123456"))
}
