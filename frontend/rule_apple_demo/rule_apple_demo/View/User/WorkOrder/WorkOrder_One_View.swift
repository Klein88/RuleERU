//
//  WorkOrder_One_View.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/16.
//

import SwiftUI
import Moya
struct WorkOrder_One_View: View {
    @State var workorder : WorkorderRequestrecord
    @State var username : String = ""
    var body: some View {
        VStack
        {
            Text("")
            Text("")
            HStack{
                Text("用户编号 : \(workorder.userid)")
                    .fontWeight(.heavy)
                    .font(.system(size: 25))
                    .padding(.leading , 25)
                Spacer()
                Text("创造时间 : \(self.workorder.creationdate)")
                    .padding(.trailing , 10)
                Spacer()
                    
            }
            .padding(.top , 20)
            HStack
            {
                Text("问题 : ")
                    .font(.system(size: 25))
                    .fontWeight(.heavy)
                    .padding(.leading , 25)
                Text("\(workorder.workordertheme)")
                Spacer()
            }
            .padding(.top , 20)
            HStack{
                Text("详细信息 : ")
                    .fontWeight(.heavy)
                    .font(.system(size: 25))
                    .padding(.leading , 25)
                   Spacer()
            }
            .padding(.top , 20)
            Text("\(self.workorder.description)")
                .padding(.leading , 50)
        }
        .frame(width: UIScreen.main.bounds.width - 10 , height: 249)
        .background(LinearGradient(colors: [.gray , .white , .gray , .white , .white], startPoint: .topTrailing, endPoint: .bottomLeading).opacity(0.55))
        .cornerRadius(30)
        .overlay(alignment: .topTrailing, content: {
            Text("\(workorder.status)")
                .font(.system(size: 23))
                .fontWeight(.heavy)
                .foregroundStyle(.white)
                .frame(width: 100 , height: 45)
                .background(workorder.status == "处理中" ? .yellow : .green)
                .cornerRadius(10)
                .padding(.top , 20)
                .padding(.trailing , 20)
                
        })
        .overlay(alignment: .topLeading) {
            Text("工单编号 :\(workorder.workorderid)")
                .fontWeight(.heavy)
                .font(.system(size: 20))
                .padding(.trailing , 10)
                .padding(.top , 20)
                .padding(.leading , 20)

        }
    }
}

#Preview {
    WorkOrder_One_View(workorder: WorkorderRequestrecord(workorderid: 1, userid: 1, workordertheme: "工单A1", description: "关于产品A1的问题", status: "处理中", creationdate: "2023-10-01"))
}
