//
//  UserViewModel.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/10/15.
//

import Foundation



class UserViewModel : ObservableObject
{
    @Published var islogin = false
    @Published var User_Details : UserRequestrecord = UserRequestrecord( username:"" , password: "", avatar: "", email:"" , usertype: "", passwordchangedate: "", lastlogindate: "")
    @Published var companyinfoAll : [Companyinforecord] = []
}
