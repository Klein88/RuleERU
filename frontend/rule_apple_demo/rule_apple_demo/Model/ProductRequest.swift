//
//  ProductRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/14.
//

import Foundation

//master
struct ProductRequest : Codable ,Hashable
{
    var code : Int
    var data : ProductRequestData
    var message : String
}



struct ProductRequestData : Codable , Hashable
{
    var records : [ProductRequestrecord]
}

struct ProductRequestrecord : Codable , Hashable
{
    var productid : Int
    var companyid : Int
    var productname : String
    var productdescription : String
    var productprice : Double
    var productcategory : String
    var productorigin : String
    var manufacturedate : String
    var expirydate : String
}


//master
struct ProductByIdRequest : Codable , Hashable
{
    var code : Int
    var data : ProductRequestrecord
    var message : String //“ok”
}

//master
struct ProductAddRequestReturn : Codable
{
    var code : Int
    var data : Int
    var message : String // "OK"
}


//master
struct ProductDeleteRequeseReturn : Codable
{
    var code : Int
    var data : Int
    var message : String // "OK"
}
