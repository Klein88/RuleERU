//
//  ConsumptionView_List.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/12.
//

import SwiftUI
import Moya
struct ConsumptionView_List: View {
    @Binding var isshowadd : Bool
    @State var consumptionList : [ComplianceapplicationRequestrecord] = [ComplianceapplicationRequestrecord]()
    var body: some View {
        Form{
            ForEach(consumptionList , id: \.self) { it in
                Section{
                    ConsumptionView_One(complianceapplication: it)
                }
            }
        }
        .onAppear{
            let prodiver = MoyaProvider<ComplianceapplicationRequestAPI>()
            prodiver.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(ComplianceapplicationRequest.self, from: jsondata)
                        self.consumptionList = data.data.records
                    }catch let error
                    {
                        print(error)
                    }
                case .failure(_):
                    break
                }
            }
            
            
        }
        .onChange(of: isshowadd) { _ in
            let prodiver = MoyaProvider<ComplianceapplicationRequestAPI>()
            prodiver.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(ComplianceapplicationRequest.self, from: jsondata)
                        self.consumptionList = data.data.records
                    }catch let error
                    {
                        print(error)
                    }
                case .failure(_):
                    break
                }
            }
        }
    }
}

