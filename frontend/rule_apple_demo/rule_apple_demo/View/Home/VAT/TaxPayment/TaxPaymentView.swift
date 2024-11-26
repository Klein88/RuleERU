//
//  TaxPaymentView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/2.
//

import SwiftUI

struct TaxPaymentView: View {
    var body: some View {
        VStack
        {
          TaxPaymentView_List()
        }
        .navigationTitle("VAT缴税")
    }
}

#Preview {
    TaxPaymentView()
}
