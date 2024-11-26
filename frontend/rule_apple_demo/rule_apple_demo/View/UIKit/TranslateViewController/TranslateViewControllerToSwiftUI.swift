//
//  TranslateViewControllerToSwiftUI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/1.
//

import Foundation
import SwiftUI


struct TranslateViewControllerToSwiftUI : UIViewControllerRepresentable
{
    func makeUIViewController(context: Context) -> TranslateViewController {
        var translateViewController = TranslateViewController()
        return translateViewController
    }
    
    func updateUIViewController(_ uiViewController: TranslateViewController, context: Context) {
        
    }
    
    typealias UIViewControllerType = TranslateViewController
    
}
