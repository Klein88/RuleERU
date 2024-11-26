//
//  EprregistrationserviceRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/23.
//

import Foundation


//master
struct EprregistrationserviceRequest : Codable , Hashable
{
    
}//Bolishing

//master



struct EprregistrationserviceRequestrecord : Codable , Hashable
{
    var servicedataid : Int!
    var productquantity : Int!
    var productname : String!
}


//master
struct EprregistrationserviceAddSuccessRequest : Codable , Hashable
{
    var code : Int
    var data : Int
    var message : String
}

