//
//  DeclarationView_List.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/26.
//

import SwiftUI
import Moya



struct DeclarationView_List: View {
    
    @State var taxdeclarationList : [TaxdeclarationRequestrecord] = [TaxdeclarationRequestrecord]()
    
    var body: some View {
        ScrollView{
            VStack
            {
                
                
                ForEach(taxdeclarationList , id: \.self)
                {
                    it in
                    DeclarationView_One(taxdeclaration: it)
                    
                }
                
                
                
            }
        }
        .onAppear{
            
            let provider = MoyaProvider<TaxdeclarationRequestAPI>()
            
            provider.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch  result
                {
                case .success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(TaxdeclarationRequest.self, from: jsondata)
                        
                        self.taxdeclarationList = data.data.records
                        print("taxdeclaration" , self.taxdeclarationList)
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

#Preview {
    DeclarationView_List()
}
