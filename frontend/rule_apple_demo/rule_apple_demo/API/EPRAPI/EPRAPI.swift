//
//  EPRAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/30.
//

import Foundation



func serviceSubmmitToString(EprSubmmit : Int) -> String
{
    if EprSubmmit == 0
    {
        return "未提交申报"
    }
    else
    {
        return "已提交申报"
    }
}
