//
//  EPRdeclatationView_List.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/31.
//

import SwiftUI
import Moya
struct EPRdeclatationView_List: View {
    @State var EPRdeclarationList : [EprdeclarationRequest_1record] = [EprdeclarationRequest_1record]()
    var body: some View {
       VStack
        {
            ScrollView{
                VStack
                {
                    ForEach(self.EPRdeclarationList , id: \.self) { it in
                        EPRdeclarationView_One(EPRdeclaration: it)
                    }
                }
            }
        }
        .onAppear{
            let prodiver = MoyaProvider<EprdeclarationRequest_1API>()
            prodiver.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(EprdeclarationRequest_1.self, from: jsondata)
                        self.EPRdeclarationList = data.data.records
                        
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

