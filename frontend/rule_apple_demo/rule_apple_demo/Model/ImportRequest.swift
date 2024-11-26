//
//  ImportRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/17.
//

import Foundation


//master
struct ImportRequest : Codable , Hashable
{
    var code : Int
    var data : ImportRequestData
    var message : String
}

struct ImportRequestData : Codable , Hashable
{
    var records : [ImportRequestrecord]
}

struct ImportRequestrecord : Codable , Hashable
{
    var id : Int!
    var date : String!
    var importamount : String!
}
