//
//  VATDclarationView_Finish.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/20.
//

import SwiftUI

struct VATDclarationView_Finish: View {
    @Environment(\.presentationMode) var presentationMode
    var body: some View {
        VStack
        {
            
        }
        
        .navigationBarBackButtonHidden()
        .overlay(alignment: .topLeading) {
            Button(action: {
                self.presentationMode.wrappedValue.dismiss()
            }, label: {
                HStack{
                    Image(systemName: "arrow.left")
                    Text("重新编辑")
                }
                    
            })
        }
        
    }
}

#Preview {
    VATDclarationView_Finish()
}
