//
//  Tips.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/12.
//

import Foundation
import SwiftUI
import TipKit


struct VAT_Step_1_Tip : Tip
{
    var title: Text{
        Text("1.添加税号信息")
    }
    var message: Text?{
        Text("如果没有VAT税号需要前往欧盟相关税务局注册")
    }
    
    @Parameter static var whenToShowTip : Bool = false
    
    var rules: [Rule]{
        #Rule(Self.$whenToShowTip){ $0 == true }
    }
}

struct VAT_Step_2_Tip : Tip
{
    var title: Text
    
    
    
    
}
