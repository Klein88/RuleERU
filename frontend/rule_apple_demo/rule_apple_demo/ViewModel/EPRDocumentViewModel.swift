//
//  EPRDocumentViewModel.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/14.
//




import Foundation
import SwiftUI
import UIKit


class EPRDocumentViewModel : ObservableObject
{
    @Published var GongsiYingYeZhiZhao : UIImage = UIImage()
    @Published var Legal_example_front : UIImage = UIImage()
    @Published var Legal_example_back : UIImage = UIImage()
    @Published var Legal_example_签字 : UIImage = UIImage()
    
    @Published var Eprservice : EprserviceRequestrecord = EprserviceRequestrecord()
    
}


