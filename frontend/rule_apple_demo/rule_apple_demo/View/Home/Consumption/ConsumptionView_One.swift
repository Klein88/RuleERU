//
//  ConsumptionView_One.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/12.
//

import SwiftUI

struct ConsumptionView_One: View {
    @State var complianceapplication : ComplianceapplicationRequestrecord
    @State var isToEdit : Bool = false
    var body: some View {
        VStack
        {
            HStack{
                VStack{
                    Text("\(complianceapplication.companyname)")
                        .font(.system(size: 30))
                        .fontWeight(.heavy)
                    Text("文件类型:\(complianceapplication.filetype)")
                    
                }
                .frame(width: UIScreen.main.bounds.width / 2  + 100)
                .padding(.leading , 20)
                Spacer()
                Button(action: {
                    self.isToEdit = true
                }, label: {
                    Image(systemName: "square.and.pencil")
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                        .foregroundColor(.blue)
                        .frame(width: 50)
                       
                    NavigationLink(destination: ConsumptionView_Edit(applicationid: self.complianceapplication.applicationid), isActive: $isToEdit ,label: {EmptyView()})
                
                })
                
                
                
                
            }
            Divider()
                .frame(width: UIScreen.main.bounds.width - 20 , height: 2)
            HStack
            {
                VStack
                {
                    Text("产品中文名称")
                        .font(.system(size: 13))
                        .fontWeight(.heavy)
                        .foregroundStyle(.gray)
                    Text("\(complianceapplication.productchinesename)")
                        .font(.system(size: 12))
                }
                Divider()
                    .frame( height: 30)
                    .padding(.leading , 2)
                    .padding(.trailing , 2)
                VStack{
                    Text("产品英文名称")
                        .font(.system(size: 13))
                        .fontWeight(.heavy)
                        .foregroundStyle(.gray)
                    Text("\(complianceapplication.productenglishname)")
                        .font(.system(size: 12))
                }
                Divider()
                    .frame( height: 30)
                    .padding(.leading , 5)
                    .padding(.trailing , 2)
                VStack{
                    Text("办理日期")
                        .font(.system(size: 13))
                        .fontWeight(.heavy)
                        .foregroundStyle(.gray)
                    Text("\(errorDateStringToTrueString(errorDate: complianceapplication.applicationdate))")
                        .font(.system(size: 12))
                }
            }
            
        }
    }
}

#Preview {
    HomeView()
}
