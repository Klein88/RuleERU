//
//  VATDeclarationViewAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/19.
//

import Foundation



func ReturnDeclarationByCountry(country : String) -> [Double]
{
    var ListDeclaration : [Double] = []
    switch country{
        case "英国":
        ListDeclaration = [0.065 , 0.075 , 0.165 , 0.2]
        case "法国":
        ListDeclaration = [0.2]
        case "德国":
        ListDeclaration = [0.19]
        case "意大利":
        ListDeclaration = [0.22]
        case "西班牙":
        ListDeclaration = [0.21]
        case "波兰":
        ListDeclaration = [0.23]
        case "捷克":
        ListDeclaration = [0.21]
        case "荷兰":
        ListDeclaration = [0.21]
        case "奥地利":
        ListDeclaration = [0.2]
        default:
            break
    }
    return ListDeclaration
}



func ReturnDutyParagraphByCountry(country : String) -> String
{
    
    var DutyParagraph : String = ""
    switch country{
        case "英国":
        DutyParagraph = "GB"
        case "法国":
        DutyParagraph = "FR"
        case "德国":
        DutyParagraph = "DE"
        case "意大利":
        DutyParagraph = "IT"
        case "西班牙":
        DutyParagraph = "ES"
        case "波兰":
        DutyParagraph = "PL"
        case "捷克":
        DutyParagraph = "CZ"
        case "荷兰":
        DutyParagraph = "NL"
        case "奥地利":
        DutyParagraph = "AT"
        default:
            break
    }
    
    return DutyParagraph
}
