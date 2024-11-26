//
//  EPRdeclarationView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/31.
//

import SwiftUI

struct EPRdeclarationView: View {
    @Environment(\.presentationMode) var pre
    var body: some View {
        VStack
        {
            EPRdeclatationView_List()
        }
        .navigationTitle("申报")
    }
}
