//
//  Random.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/10.
//

import Foundation



func randomIn( min: Int, max: Int) -> Int {
    return Int(arc4random()) % (max - min + 1) + min
}
