//
//  Taxpaymentnext.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/29.
//

import Foundation


//master
struct TaxpaymentnextRequest : Codable , Hashable
{
    var code : Int
    var data : TaxpaymentnextRequestData
    var message : String
}

struct TaxpaymentnextRequestData : Codable , Hashable
{
    var records : [TaxpaymentnextRequestrecord]
}

struct TaxpaymentnextRequestrecord : Codable , Hashable
{
    var taxpaymentnextid : Int!
    var vatnumber : String!
    var salesplatform : String!
    var taxablesales : Int!
    var taxrate : Double!
    var taxamount : Double!
}

//master
struct TaxpaymentnextByIdRequest : Codable , Hashable
{
    var code : Int
    var data : TaxpaymentnextRequestrecord
    var message : String
}




//master
struct TaxpaymentnextAddRequest : Codable , Hashable
{
    var code : Int
    var data : Int
    var message : String
}
