//
//  CreateViewModifier.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/5.
//

import Foundation
import SwiftUI

struct TextFieldViewModifier : ViewModifier
{
    private var width : CGFloat
    
    init(width : CGFloat){
        self.width = width
    }
    
    func body(content: Content) -> some View {
        content
            .frame(width: self.width)
            .overlay(alignment: .bottom) {
                Text("")
                    .frame(width: self.width , height: 2)
                    .background(.black)
            }
    }
    
}




