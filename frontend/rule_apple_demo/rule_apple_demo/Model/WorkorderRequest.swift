//
//  WorkorderRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/14.
//

import Foundation


//master
struct WorkorderRequest : Codable , Hashable
{
    var code : Int
    var data : WorkorderRequestData
    var message : String
}

struct WorkorderRequestData : Codable ,Hashable
{
    var records : [WorkorderRequestrecord]
}

struct WorkorderRequestrecord : Codable , Hashable
{
    var workorderid : Int!
    var userid : Int!
    var workordertheme : String!
    var description : String!
    var status : String!
    var creationdate : String!
}


//master
struct WorkorderRequestById : Codable , Hashable
{
    var code : Int
    var data : WorkorderRequestrecord
    var message : String
}


//master
struct WorkorderAddRequestReturn : Codable
{
    var code : Int
    var data : Int
    var message : String // "OK"
}

//master
struct WorkorderDeleteRequeseReturn : Codable
{
    var code : Int
    var data : Int
    var message : String // "OK"
}

