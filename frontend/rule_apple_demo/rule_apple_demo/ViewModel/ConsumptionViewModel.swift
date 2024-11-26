//
//  ConsumptionViewModel.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/14.
//

import Foundation
import UIKit


class ConsumptionViewModel : ObservableObject
{
    @Published var ChanPingShiBieShouDuan  : UIImage = UIImage()
    
    @Published var Baozhuang : UIImage = UIImage()
    
    
    @Published var Legal_example_签字 : UIImage = UIImage()
}
