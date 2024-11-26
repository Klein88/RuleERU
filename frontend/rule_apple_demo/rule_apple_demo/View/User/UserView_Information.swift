//
//  UserView_Information.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/13.
//

import SwiftUI

struct UserView_Information: View {
    @EnvironmentObject var userviewmodel : UserViewModel
    var body: some View {
        Form{
            Section{
                HStack{
                    Text("用户身份").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)
                    Spacer()
                    Text("\(userviewmodel.User_Details.usertype)")
                        .foregroundStyle(.gray)
                }
            }
            Section{
                HStack{
                    Text("邮箱地址").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)
                    Spacer()
                    Text("\(userviewmodel.User_Details.email)")
                        .foregroundStyle(.gray)
                }
            }
            
            Section{
                HStack{
                    Text("最后登录日期").font(.system(size: 25)).fontWeight(.heavy).foregroundStyle(.black)
                    Spacer()
                    Text("\(userviewmodel.User_Details.lastlogindate)")
                        .foregroundStyle(.gray)
                }
            }
            
        }
    }
}
