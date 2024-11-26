//
//  VATPaymentRefundView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/5.
//

import SwiftUI
import Moya

struct VATPaymentRefundView: View {
    @State var TaxRefundList = [TaxrefundRequestrecord]()
    var body: some View {
        VATPaymentRefundView_List()
    }
}

#Preview {
    VATPaymentRefundView()
}
