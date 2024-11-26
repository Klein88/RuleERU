//
//  VatdeclarationdetailsRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/15.
//

import Foundation



//master
struct VatdeclarationdetailsRequest : Codable , Hashable
{
    var code : Int!
    var data : VatdeclarationdetailsRequestData!
    var message : String!
}


struct VatdeclarationdetailsRequestData : Codable , Hashable
{
    var records : [VatdeclarationdetailsRequestrecord]!
}

struct VatdeclarationdetailsRequestrecord : Codable , Hashable
{
    var declarationdetailid : Int!
    var declarationid : Int!
    var vatdeclarationnumber : String!
    var currentvatdeclarationperiod : String!
    var vatdeclarationcycle : String!
    var applicabletaxrate : Double!
    var taxpaymentdeadline : String!
    var salesreportuploadplatform : String!
}


struct VatdeclarationdetailsByIdRequest : Codable , Hashable
{
    var code : Int!
    var data : VatdeclarationdetailsRequestrecord!
    var message : String!
}


//master
struct VatdeclarationdetailsAddRequestReturn : Codable
{
    var code : Int!
    var data : Int!
    var message : String! // "OK"
}

//master
struct VatdeclarationdetailsDeleteRequeseReturn : Codable
{
    var code : Int
    var data : Int
    var message : String // "OK"
}
