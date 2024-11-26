//
//  ConpanyRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/14.
//

import Foundation


//master
struct Company : Encodable
{
    var companyid : Int
    var userid : Int
    var companyname : String
    var companyaddress : String
}



//master
struct CompanyRequest : Codable
{
    var code : Int
    var data : CompanyData
    var message : String
}


struct CompanyData : Codable
{
    var records : [record]
    var total : Int
    var size : Int
    var current : Int
    
}


struct record : Codable
{
    var companyid : Int
    var userid : Int
    var companyname : String
    var companyaddress : String
}




//master
struct CompanyById : Codable
{
    var code : Int
    var data : CompanyByIdData
    var message : String
}

struct CompanyByIdData : Codable
{
    var companyid : Int
    var userid : Int
    var companyname : String
    var companyaddress : String
}


//master
struct CompanyAddRequestReturn : Codable
{
    var code : Int
    var data : Int
    var message : String // "OK"
}

//master
struct CompanyDeleteRequeseReturn : Codable
{
    var code : Int
    var data : Int
    var message : String // "OK"
}
