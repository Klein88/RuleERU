//
//  DocumentRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/24.
//

import Foundation



//master
struct DocumentRequest : Codable , Hashable
{
    var code : Int
    var data : DocumentRequestData
    var message : String
}


struct DocumentRequestData : Codable , Hashable
{
    var records : [DocumentRequestrecord]
}

struct DocumentRequestrecord : Codable , Hashable
{
    var documentid : Int!
    var documenttitle : String!
    var documentcontent : String!
    var documentcategory : String!
    var documentreadCount : Int!
    var documentcreated : String!
    var documentupdated : String!
}

//master
struct DocumentByIdRequest : Codable , Hashable
{
    var code : Int
    var data : DocumentRequestrecord
    var message : String
}
