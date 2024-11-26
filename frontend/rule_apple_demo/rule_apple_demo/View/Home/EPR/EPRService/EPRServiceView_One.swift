//
//  EPRServiceView_One.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/29.
//

import SwiftUI

struct EPRServiceView_One: View {
    @State var EPRservice : EprserviceRequestrecord
    @State var isToEPRServiceInformation : Bool = false
    @EnvironmentObject var eprDocumentViewModel : EPRDocumentViewModel
    var body: some View {
       HStack
        {
            Image(self.EPRservice.country)
                .resizable()
                .aspectRatio(contentMode: .fit)
                .frame(width: 40)
                .padding(.leading , 30)
            VStack
            {
                HStack
                {
                    Text("公司名称 :")
                        .font(.system(size: 25))
                        .fontWeight(.heavy)
                        
                        
                    Text("\(self.EPRservice.companyname)")
                        .font(.system(size: 20))
                        .fontWeight(.heavy)
                        
                    
                    
                }
                .frame(width: 300 , height: 40)
                
                Text("\(serviceSubmmitToString(EprSubmmit:self.EPRservice.servicesummit))")
                    .foregroundColor(.white)
                    .font(.system(size: 20))
                    .fontWeight(.heavy)
                    .frame(width: 150 , height: 25)
                    .background(self.EPRservice.servicesummit == 1 ? .yellow : .green)
                    .cornerRadius(20)
                Divider()
                    .frame(width: UIScreen.main.bounds.width - 200)
                HStack
                {
                    VStack{
                        Text("服务类型")
                            .fontWeight(.heavy)
                        Text("\(self.EPRservice.servicetype)")
                    }
                    .padding(.trailing , 20)
                    Divider()
                        .frame(height: 30)
                    VStack{
                        Text("注册号")
                            .fontWeight(.heavy)
                        Text("\(self.EPRservice.registrationnumber)")
                    }
                    .padding(.leading  , 20)
                    
                }
            }
            .frame(width: 300)
            
            Button(action: {
                self.eprDocumentViewModel.Eprservice = self.EPRservice
                self.isToEPRServiceInformation = true
            }, label: {
                Image(systemName: "square.and.pencil")
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 50)
                    .foregroundColor(.blue)
                NavigationLink(destination: EPRServiceInformationView(), isActive: $isToEPRServiceInformation,label: {EmptyView()})
            })
            .padding(.trailing , 30)
            
                
        }
        .frame(width: UIScreen.main.bounds.width - 10 , height: 150)
        
    }
}

#Preview {
    EPRServiceView_One(EPRservice: EprserviceRequestrecord( companyname: "欧税通有限公司", registrationnumber: "Reg12345", country: "英国", servicetype: "EPR转申报", servicesummit: 0))
        .environmentObject(EPRDocumentViewModel())
}
