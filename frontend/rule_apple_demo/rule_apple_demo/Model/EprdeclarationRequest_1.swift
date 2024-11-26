//
//  Eprdeclaration1Request.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/29.
//

import Foundation


//master
struct EprdeclarationRequest_1 : Codable , Hashable
{
    var code : Int
    var data : EprdeclarationRequest_1Data
    var message : String
}

struct EprdeclarationRequest_1Data : Codable , Hashable
{
    var records : [EprdeclarationRequest_1record]
}

struct EprdeclarationRequest_1record : Codable , Hashable
{
    var eprdeclarationid : Int!
    var companyregistrationlocation : String!
    var companyname : String!
    var businesslicensenumber  : String!
    var companyestablishmentdate : String!
    var companyoperationaladdress : String!
    var postalcode : String!
    var companyphonenumber : String!
    var companycontactemail : String!
    var legalrepresentativename : String!
    var mainsalesplatform : String!
    var shopname : String!
    var informationlink : String!
    var shopbackendselleraddress : String!
    var shopbackendcompanyname : String!
    var mainbusinessscope : String!
    var brandcount : Int!
    var brandenglishname : String!
    var companyregistrationproof : Data!
    var idcardfront : Data!
    var idcardback : Data!
    var signature : Data!
    var registrationnumber : String!
}


//master
struct EprdeclarationByIdRequest_1 : Codable , Hashable
{
    var code : Int
    var data : EprdeclarationRequest_1record
    var message : String
}


//master
struct EprdeclarationSuccessRequest_1 : Codable , Hashable
{
    var code : Int
    var data : Int
    var message : String
}
