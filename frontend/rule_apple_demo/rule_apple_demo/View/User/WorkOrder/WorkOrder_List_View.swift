//
//  WorkOrder_List_View.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/16.
//

import SwiftUI
import Moya

struct WorkOrder_List_View: View {
    @State var workorderdatas = [WorkorderRequestrecord]()
    @State var isloading = false
    @State var isshowfailAlert = false
    var body: some View {
        ScrollView(.vertical , showsIndicators: false) {
            VStack
            {
                ForEach(workorderdatas , id: \.self)
                {
                    it in
                    WorkOrder_One_View(workorder: it)
                }
            }
        }
        .onAppear{
            isloading = true
            let provider = MoyaProvider<WorkorderRequestAPI>()
            provider.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let req):
                    do
                    {
                        let jsondata  = req.data
                        let data = try JSONDecoder().decode(WorkorderRequest.self, from: jsondata)
                        self.workorderdatas = data.data.records
                        
                        for it in 0 ..< workorderdatas.count
                        {
                            workorderdatas[it].creationdate = errorDateStringToTrueString(errorDate: workorderdatas[it].creationdate)
                        }
                        
                        self.isloading = false
                    }catch let error
                    {
                        print(error)
                    }
                    
                case.failure(let error):
                    do
                    {
                        isloading = false
                        isshowfailAlert = true
                    }catch let error
                    {
                        print(error)
                    }
                }
            }
        }
        .overlay {
            if isloading
            {
                ProgressView("loading...正在加载表单")
                    .frame(width: UIScreen.main.bounds.width - 10)
            }
        }
        .alert(isPresented: $isshowfailAlert, content: {
          Alert(title: Text("加载失败"))
        })
    }
}

#Preview {
    WorkOrder_List_View()
}
