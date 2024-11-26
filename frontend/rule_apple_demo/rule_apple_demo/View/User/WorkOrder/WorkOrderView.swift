//
//  WorkOrderView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/16.
//

import SwiftUI
import Moya
import SlideOverCard


struct WorkOrderView: View {
    @Environment(\.presentationMode) var presentationMode
    @State var isshowaddView : Bool = false
    @State var questionText : String = ""
    var body: some View {
        VStack
        {
            HStack
            {
                Spacer()
                Button(action: {
                    self.isshowaddView = true
                }, label: {
                    Text("创建工单")
                        .fontWeight(.heavy)
                        .foregroundStyle(.white)
                        .font(.system(size: 30))
                        .frame(width: 150 , height: 70)
                        .background(.blue)
                        .cornerRadius(30)
                })
                .padding(.top , 20)
                .padding(.trailing , 20)
            }
            WorkOrder_List_View()
        }
        .navigationBarBackButtonHidden()
        .navigationBarItems(leading: Button(action: {
            self.presentationMode.wrappedValue.dismiss()
        }, label: {
            Image(systemName: "arrowshape.left.fill")
        })
        .padding(.top , 20)
        .padding(.leading , 20))
        .navigationTitle("我的工单")
        .toolbar(.hidden, for: .bottomBar)
        .slideOverCard(isPresented: $isshowaddView) {
            VStack{
                ZStack{
                    Color.blue
                    TextField("请输入问题", text: $questionText)
                        .frame(width: UIScreen.main.bounds.width - 10 , height: 60)
                        .background(.white)
                        .cornerRadius(20)
                }
                .frame(width: UIScreen.main.bounds.width - 20 , height: 50)
                .cornerRadius(20)
                
                Button(action: {
                    
                    let dateFormatter = DateFormatter()
                    dateFormatter.dateFormat = "yyyy-MM-dd"
                    
                    var workorderRecord = WorkorderRequestrecord(userid: 1, workordertheme: self.questionText, description: "", status: "处理中", creationdate: dateFormatter.string(from: Date()))
                    
                    let prodiver = MoyaProvider<WorkorderRequestAPI>()
                    prodiver.request(.add(workorderrequestrecord: workorderRecord)) { result in
                        switch result
                        {
                        case .success(let req):
                            break
                        case .failure(_):
                            break
                        }
                    }
                    
                    
                    
                    self.isshowaddView = false
                }, label: {
                    Text("添加")
                        .font(.system(size : 25))
                        .fontWeight(.heavy)
                        .foregroundStyle(.white)
                        .frame(width: 130 , height: 60)
                        .background(.blue)
                        .cornerRadius(20)
                })
                .padding(.bottom , 40)
            }
            
        }
    }
}

#Preview {
    WorkOrderView()
}
