//
//  VATPaymentRefundView_List.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/24.
//

import SwiftUI
import Moya



struct VATPaymentRefundView_List: View {
    @State var TaxRefundList = [TaxrefundRequestrecord]()
    var body: some View {
        
            Form
            {
                ForEach(TaxRefundList  , id: \.self) { it in
                    Section{
                        
                        VATPaymentRefundView_One(VATRefund: it)
                        
                        
                    }
                }
            }
        
        .onAppear{
            let prodiver = MoyaProvider<TaxrefundRequestAPI>()
            prodiver.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case  .success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(TaxrefundRequest.self, from: jsondata)
                        self.TaxRefundList = data.data.records
                        for it in 0 ..< self.TaxRefundList.count
                        {
                            self.TaxRefundList[it].declarationdate = errorDateStringToTrueString(errorDate: self.TaxRefundList[it].declarationdate)
                        }
                        
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
    VATPaymentRefundView_List()
}
