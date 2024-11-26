//
//  TaxServiceRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/23.
//

import Foundation




//master
struct TaxServiceRequest : Codable , Hashable
{
    var code : Int
    var data : TaxServiceRequestData
    var message : String
}

struct TaxServiceRequestData : Codable , Hashable
{
    var records : [TaxServiceRequestrecord]
}

struct TaxServiceRequestrecord : Codable , Hashable
{
    var taxserviceid : Int!
    var taxtype : String!
    var country : String!
    var servicetype : String!
    var companyname : String!
    var vatnumber : String!
    var serviceprogress : String!
    var taxrate : Double!
    var servicesummit : Int! //0 or 1
}

//master
struct TaxServiceByIdRequest : Codable , Hashable
{
    var code : Int
    var data : TaxServiceRequestrecord
    var message : String
}

//master
struct TaxServiceAddSuccessRequest : Codable , Hashable
{
    var code : Int
    var data : Int
    var message : String
}


