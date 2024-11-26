//
//  EPRServiceView_List.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/29.
//

import SwiftUI
import Moya

struct EPRServiceView_List: View {
    @State var EprserviceList : [EprserviceRequestrecord] = [EprserviceRequestrecord]()
    @Binding var isshowaddEPRServiceView : Bool
    var body: some View {
        VStack
        {
            
                Form{
                    ForEach(EprserviceList  , id: \.self)
                    {
                        it in
                        Section{
                            EPRServiceView_One(EPRservice: it)
                        }
                            
                    }
                }
            
        }
        .onAppear{
            
            let prodiver = MoyaProvider<EprserviceRequestAPI>()
            
            prodiver.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let req) :
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(EprserviceRequest.self, from: jsondata)
                        EprserviceList = data.data.records
                    }catch let error
                    {
                        print(error)
                    }
                    
                case.failure(_):
                    break
                }
            }
            
            
            
        }
        .onChange(of: isshowaddEPRServiceView) {
            newvalue in
            let prodiver = MoyaProvider<EprserviceRequestAPI>()
            
            prodiver.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let req) :
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(EprserviceRequest.self, from: jsondata)
                        EprserviceList = data.data.records
                    }catch let error
                    {
                        print(error)
                    }
                    
                case.failure(_):
                    break
                }
            }
        }
    }
}
