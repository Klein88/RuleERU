//
//  TaxPaymentView_List.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/2.
//

import SwiftUI
import Moya
struct TaxPaymentView_List: View {
    @State var TaxPaymentList : [TaxpaymentRequestrecord] = [TaxpaymentRequestrecord]()
    var body: some View {
        ScrollView
        {
            VStack
            {
                ForEach(TaxPaymentList , id: \.self)
                {
                    it in
                    TaxPaymentView_One(TaxPayment: it)
                }
            }
        }
        .onAppear{
            let provider = MoyaProvider<TaxpaymentRequestAPI>()
            
            
            provider.request(.pageList(pageSize: 1, pageNum: 1)) { result in
                switch result
                {
                case .success(let req):
                    do
                    {
                        let jsondata = req.data
                        let data = try JSONDecoder().decode(TaxpaymentRequest.self, from: jsondata)

                        self.TaxPaymentList = data.data.records
                        print(self.TaxPaymentList)
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
    TaxPaymentView_List()
}
