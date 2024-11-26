//
//  AgencyServiceInformationAPI.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/16.
//

import Foundation



func GetEndOfLastReportedDate(mouth : Int) -> Int
{
    if mouth >= 1 && mouth <= 3
    {
        return 3
    }
    else if mouth >= 4 && mouth <= 6
    {
        return 6
    }
    else if mouth >= 7 && mouth <= 9
    {
        return 9
    }
    else
    {
        return 12
    }
}


func stringConvertDate(string:String, dateFormat:String="yyyy-MM-dd") -> Date {
        let dateFormatter = DateFormatter.init()
        dateFormatter.dateFormat = "yyyy-MM-dd"
        let date = dateFormatter.date(from: string)
        return date!
}

func errorDateStringToTrueString(errorDate : String) -> String{
    var trueDate = ""
    
    let TrueAndErrorList = errorDate.split(separator: "T")
    
    trueDate = String(TrueAndErrorList[0])
    
    return trueDate
}

