//
//  TaxrefundRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/31.
//

import Foundation


//master
struct TaxrefundRequest : Codable , Hashable
{
    var code : Int
    var data : TaxrefundRequestData
    var message : String
}


struct TaxrefundRequestData : Codable , Hashable
{
    var records : [TaxrefundRequestrecord]
}

struct TaxrefundRequestrecord : Codable , Hashable
{
    var taxrefundid : Int!
    var country : String!
    var vatnumber : String!
    var declarationtype : String!
    var declarationcycle : String!
    var declarationdate : String!
    var refundamount : Double!
    var operation : Int!
}


//master
struct TaxrefundByIdRequest : Codable , Hashable
{
    var code : Int
    var data : TaxrefundRequestrecord
    var message : String
}

//master
struct TaxrefundSuccessRequest : Codable , Hashable
{
    var code : Int
    var data : Int
    var message : String
}
