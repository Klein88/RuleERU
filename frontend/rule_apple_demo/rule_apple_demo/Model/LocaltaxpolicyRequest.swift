//
//  LocaltaxpolicyRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/15.
//

import Foundation



//master
struct LocaltaxpolicyRequest : Codable , Hashable
{
    var code : Int
    var data : LocaltaxpolicyRequestData
    var message : String
}

struct LocaltaxpolicyRequestData : Codable ,Hashable
{
    var records : [LocaltaxpolicyRequestrecord]
}

struct LocaltaxpolicyRequestrecord : Codable , Hashable
{
    var policyid : Int
    var region : String
    var taxpolicydescription : String
    var taxregulationdescription : String
    var effectivedate : String
    var expirydate : String! = ""
}


//master
struct LocaltaxpolicyByTaxPolicyDescriptionRequest : Codable , Hashable
{
    var code : Int
    var data : LocaltaxpolicyRequestrecord
    var message : String
}
