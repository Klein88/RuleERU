//
//  EprregistrationRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/23.
//

import Foundation


//master
struct EprregistrationRequest : Codable , Hashable
{
    var code : Int
    var data : EprregistrationRequestData
    var message : String
}

struct EprregistrationRequestData : Codable , Hashable
{
    var records : [EprregistrationRequestrecord]
}

struct EprregistrationRequestrecord : Codable , Hashable
{
    var registrationid : Int!
    var companyname : String!
    var registrationnumber : String!
    var country : String!
    var servicetype : String!
    var registrationstatus : String!
    var serviceexpirydate : String!
}


//master
struct EprregistrationByIdRequest : Codable  , Hashable
{
    var code : Int
    var data : EprregistrationRequestrecord
    var message : String
}

//master
struct EprregistrationAddSuccessRequest : Codable  , Hashable
{
    var code : Int
    var data : Int
    var message : String
}

//master
struct EprregistrationUploadSuccessRequest : Codable  , Hashable
{
    var code : Int
    var data : Int
    var message : String
}

