//
//  CompanyinfoRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/14.
//

import Foundation

//master
struct CompanyinfoRequest : Codable , Hashable
{
    var code : Int
    var data : CompanyinfoData
    var message : String
}


struct CompanyinfoData : Codable , Hashable
{
    var records : [Companyinforecord]
}



struct Companyinforecord : Codable , Hashable
{
    var userid : Int
    var companyname : String
    var companytype : String
    var companyaddress : String
    var companytel : String
    var companyregister : String
    var companyphoto : String
    var companynumber : String
    var companystatue : String
}




//master
struct CompanyinfoByNameRequest : Codable , Hashable
{
    var code : Int
    var data : Companyinforecord
    var message : String  //"ok"
}
