//
//  UserRequest.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/15.
//

import Foundation


//master
struct UserRequest : Codable , Hashable
{
    var code : Int!
    var data : UserRequestrecord!
    var message : String!
}


struct UserRequestrecord : Codable , Hashable
{
    var userid : Int!
    var username : String!
    var password : String!
    var avatar : String!
    var email : String!
    var usertype : String!   //业务人员&&从业人员
    var passwordchangedate : String!
    var lastlogindate : String!
}

struct Users : Codable , Hashable
{
    var username : String!
    var password : String!
}




//MARK: -----11月25i修改User获取token
struct NewUserRequest : Codable , Hashable
{
    var code : Int
    var data : String
    var message : String
}
