//
//  EprdeclarationRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/23.
//

import Foundation



//master
struct EprdeclarationRequest : Codable , Hashable
{
    var code : Int
    var data : EprdeclarationRequestData
    var message : String
}

struct EprdeclarationRequestData : Codable , Hashable
{
    var records : [EprdeclarationRequestrecord]
}

struct EprdeclarationRequestrecord : Codable , Hashable
{
    var declarationid : Int!
    var isrequiredtodeclare  : Int!
    var companyname : String!
    var registrationnumber  : String!
    var country : String!
    var servicetype : String!
    var declarationcycle : String!
    var currentdeclarationperiod  : String!
    var startdeclarationdate : String!
    var enddeclarationdate : String!
}


//master
struct EprdeclarationByIdRequest : Codable , Hashable
{
    var code : Int
    var data : EprdeclarationRequestrecord
    var message : String
}


//master
struct EprdeclarationSuccessRequest : Codable , Hashable
{
    var code : Int
    var data : Int
    var message : String
}
