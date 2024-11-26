//
//  TaxpaymentRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/2.
//

import Foundation



//master
struct TaxpaymentRequest : Codable , Hashable
{
    var code : Int
    var data : TaxpaymentRequestData
    var message : String
}

struct TaxpaymentRequestData : Codable , Hashable
{
    var records : [TaxpaymentRequestrecord]
}

struct TaxpaymentRequestrecord : Codable , Hashable
{
    var taxpaymentid : Int!
    var companyname : String!
    var country : String!
    var vatnumber : String!
    var declarationtype : String!
    var amountdue : Double!
    var currency : String!
    var declarationcycle : String!
    var declarationperiod : String!
    var duedate :  String!
    var paymentstatus : Int!
}


//master
struct TaxpaymentByOnesRequest : Codable , Hashable
{
    var code : Int
    var data : TaxpaymentRequestrecord
    var message : String
}

//master
struct TaxpaymentSuccessRequest : Codable , Hashable
{
    var code : Int
    var data : Int
    var message : String
}
