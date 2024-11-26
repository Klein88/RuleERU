//
//  PackagingSummaryDeclarationRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/23.
//

import Foundation


//master
struct PackagingSummaryDeclarationRequest : Codable , Hashable
{
    var code : Int
    var data : PackagingSummaryDeclarationRequestData
    var message : String
}


struct PackagingSummaryDeclarationRequestData : Codable , Hashable
{
    var records : [PackagingSummaryDeclarationRequestrecord]
}


struct PackagingSummaryDeclarationRequestrecord : Codable , Hashable
{
    var summaryid : Int!
    var registrationcode : String!
    var declarationyear : Int!
    var brandname : String!
    var declarationdataserialnumber : Int!
    var packagingmaterial : String!
    var predeclaredweight : Double!
    var actualpackagingweight  : Double!
    var eprdeclarationid : Int!
}



//master
struct PackagingSummaryDeclarationByIdRequest : Codable , Hashable
{
    var code : Int
    var data : PackagingSummaryDeclarationRequestrecord
    var message : String
}



//master
struct PackagingSummaryDeclarationAddSuccessRequest : Codable , Hashable
{
    var code : Int
    var data : Int
    var message : String
}


//master
struct PackagingSummaryDeclarationUploadSuccessRequest : Codable , Hashable
{
    var code : Int
    var data : Int
    var message : String
}
