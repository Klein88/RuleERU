//
//  TaxdeclarationRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/15.
//

import Foundation

//master
struct TaxdeclarationRequest : Codable , Hashable
{
    var code : Int
    var data : TaxdeclarationRequestData
    var message : String
}

struct TaxdeclarationRequestData : Codable , Hashable
{
    var records : [TaxdeclarationRequestrecord]
}

struct TaxdeclarationRequestrecord : Codable , Hashable
{
    var declarationid : Int!
    var vatnumber : String!
    var taxrate : Double!
    var taxnumbereffectivedate : String!
    var lastdeclarationdate : String!
    var gatewayid : String!
    var gatewaypassword : String!
    var lastreporteddate : String!
    var mtdusername : String!
    var mtdpassword : String!
    var companyregistrationlocation : String!
    var companyname : String!
    var businesslicensenumber : String!
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
    var vatcertificate : Data! = Data()
    var vatdeclarationdocument : Data! = Data()
    var proxycommitmentdocumen : Data! = Data()
    var companyregistrationproof : Data! = Data()
    var idcardfront : Data! = Data()
    var idcardback : Data! = Data()
    var signature : Data! = Data()
}


//master
struct TaxdeclarationRequestByIdRequest : Codable , Hashable
{
    var code : Int
    var data : TaxdeclarationRequestrecord
    var message : String
}


//master
struct TaxdeclarationAddRequestReturn : Codable
{
    var code : Int
    var data : Int
    var message : String // "OK"
}

//master
struct TaxdeclarationDeleteRequeseReturn : Codable
{
    var code : Int
    var data : Int
    var message : String // "OK"
}
