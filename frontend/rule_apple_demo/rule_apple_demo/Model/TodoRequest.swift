//
//  TodoRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/14.
//

import Foundation



//master
struct TodoRequest : Codable , Hashable
{
    var code : Int
    var data : TodoRequestData
    var message : String
}


struct TodoRequestData : Codable , Hashable
{
    var records : [TodoRequestrecord]
}

struct TodoRequestrecord : Codable , Hashable
{
    var todoid : Int
    var userid : Int
    var description : String
    var status : String
    var duedate : String
}


//master
struct TodoRequestById : Codable , Hashable
{
    var code : Int
    var data : TodoRequestrecord
    var message : String
}


//master
struct TodoAddRequestReturn : Codable
{
    var code : Int
    var data : Int
    var message : String // "OK"
}

//master
struct TodoDeleteRequeseReturn : Codable
{
    var code : Int
    var data : Int
    var message : String // "OK"
}
