//
//  ComplianceapplicationRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/6.
//

import Foundation


//master
struct ComplianceapplicationRequest : Codable   , Hashable
{
    var code : Int
    var data : ComplianceapplicationRequestData
    var message : String
}

struct ComplianceapplicationRequestData : Codable , Hashable
{
    var records : [ComplianceapplicationRequestrecord]
}

struct ComplianceapplicationRequestrecord : Codable , Hashable
{
    var applicationid : Int!
    var filetype : String!
    var companyname : String!
    var productchinesename : String!
    var productenglishname : String!
    var trademark : String!
    var applicationdate : String!  //date
}
