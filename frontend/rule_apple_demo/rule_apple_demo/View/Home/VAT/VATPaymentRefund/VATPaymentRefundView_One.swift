//
//  VATPaymentRefundView_One.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/24.
//

import SwiftUI

struct VATPaymentRefundView_One: View {
    @State var VATRefund : TaxrefundRequestrecord
    
    var body: some View {
        VStack
        {
            HStack
            {
                Image(VATRefund.country)
                    .resizable()
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 40)
                Text("VAT税号 : ")
                    .font(.system(size: 20))
                    .fontWeight(.heavy)
                Text("\(self.VATRefund.vatnumber)")
                    .font(.system(size: 15))
                Text(VATRefund.operation == 1 ? "未退税" : "已退税")
                    .font(.system(size: 20))
                    .fontWeight(.heavy)
                    .foregroundStyle(.white)
                    .frame(width: 100 , height: 50)
                    .background(VATRefund.operation == 1 ? .yellow : .green)
                    .cornerRadius(20)
                    
            }
            Divider()
            
            HStack
            {
                VStack
                {
                    Text("申报类型")
                        .font(.system(size: 20))
                        .fontWeight(.heavy)
                    Text("\(VATRefund.declarationtype)")
                }
                Divider()
                    .frame(height: 30)
                VStack
                {
                    Text("申报日期")
                        .font(.system(size: 20))
                        .fontWeight(.heavy)
                    Text("\(VATRefund.declarationdate)")
                }
                Divider()
                    .frame(height: 30)
                VStack
                {
                    Text("退税金额")
                        .font(.system(size: 20))
                        .fontWeight(.heavy)
                    Text("\(VATRefund.refundamount)")
                        
                }
            }
            
            
            
        }
    }
}

#Preview {
    VATPaymentRefundView_One(VATRefund: TaxrefundRequestrecord( country: "英国", vatnumber: "GB123456", declarationtype: "季度申报", declarationcycle: "2023-01", declarationdate: "2023-03-29", refundamount: 2004.5, operation: 1))
}
