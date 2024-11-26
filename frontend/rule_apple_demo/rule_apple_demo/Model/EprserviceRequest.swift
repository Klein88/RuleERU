//
//  EprseviceRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/29.
//

import Foundation



//master
struct EprserviceRequest : Codable , Hashable
{
    var code : Int
    var data : EprserviceRequestData
    var message : String
}

struct EprserviceRequestData : Codable , Hashable
{
    var records : [EprserviceRequestrecord]
}

struct EprserviceRequestrecord : Codable , Hashable
{
    var eprserviceid : Int!
    var companyname : String!
    var registrationnumber : String!
    var country : String!
    var servicetype : String!
    var servicesummit : Int!
}


//master
struct EprserviceByIdRequest : Codable , Hashable
{
    var code : Int
    var data : EprserviceRequestrecord
    var message : String
}

//master
struct EprserviceSuccessRequest : Codable , Hashable
{
    var code : Int
    var data : Int
    var message : String
}
