//
//  TranslateView.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/1.
//

import SwiftUI
import Moya


struct TranslateView: View {
    @State var dst : String = ""
    @State var text : String = ""
    var body: some View {
        VStack
        {
            TranslateViewControllerToSwiftUI()
        }
        
    }
}

#Preview {
    TranslateView()
}
