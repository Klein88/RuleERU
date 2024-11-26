//
//  EudeclarationofconformityRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/6.
//

import Foundation



//master
struct EudeclarationofconformityRequest : Codable  , Hashable
{
    var code : Int
    var data : EudeclarationofconformityRequestData
    var message : String
}

struct EudeclarationofconformityRequestData : Codable , Hashable
{
    var records : [Eudeclarationofconformityrecord]
}

struct Eudeclarationofconformityrecord : Codable  , Hashable
{
    var declarationid : Int!
    var manufacturername : String!
    var businessaddress : String!
    var authorizedrepresentative : String!
    var productserialnumber : String!
    var modelortypeidentification : String!
    var responsibilitystatement : String!
    var productidentification : String!
    var notifiedbodydetails : String!
    var legislationandstandards : String!
    var signatoryname : String!
    var declarationdate : String!
    var supplementaryinformation : String!
    var importerresponsibility : String!
    var translationrequirement : String!
    var signatorysignature : Data!
    var productimage : Data!
    var applicationid : Int!
}



//master
struct EudeclarationofconformityByApplicationIdRequest : Codable , Hashable
{
    var code  : Int
    var data : Eudeclarationofconformityrecord
    var message : String
}


//master

struct EudeclarationofconformitySuccessRequest : Codable , Hashable
{
    var code : Int
    var data : Int
    var message : String
}
