//
//  LoginView_Regisiter.swift
//  rule_apple_demo
//
//  Created by 邱文豪 on 2023/11/14.
//

import SwiftUI
import FloatingLabelTextFieldSwiftUI
import Moya
struct LoginView_Regisiter: View {
    @State var username : String = ""
    @State var password : String = ""
    @State var secondpassword : String = ""
    @State var email : String = ""
    @State var nums : Int = 0
    @State var UserType : String = "管理员"
    let UserTypes : [String] = ["管理员","业务人员"]
    @Binding var isback : Bool
    var body: some View {
        VStack
        {
            Text("注册")
                .font(.system(size: 30))
                .fontWeight(.heavy)
                
            
                
                FloatingLabelTextField($username, placeholder: "请输入用户名", editingChanged: { (isChanged) in
                    
                }) {
                    
                }
                .titleColor(.green)
                .selectedLineColor(.blue)
                .selectedTextColor(.blue)
                .selectedTitleColor(.blue)
                .frame(height: 70)
            
            FloatingLabelTextField($password, placeholder: "请输入密码", editingChanged: { (isChanged) in
                        
                    }) {
                        
                    }
                    .titleColor(.green)
                    .selectedLineColor(.blue)
                    .selectedTextColor(.blue)
                    .selectedTitleColor(.blue)
                    .frame(height: 70)
            
            FloatingLabelTextField($secondpassword, placeholder: (secondpassword != "" && password != secondpassword ? "请输入正确的密码" : "请再次输入密码"), editingChanged: { (isChanged) in
                        
                    }) {
                        
                    }
                    .titleColor(secondpassword != "" && password != secondpassword ? .red : .green)
                    .selectedLineColor(.blue)
                    .selectedTextColor(.blue)
                    .selectedTitleColor(secondpassword != "" && password != secondpassword ? .red : .blue)
                    .frame(height: 70)
            
            FloatingLabelTextField($email, placeholder: "请输入邮箱", editingChanged: { (isChanged) in
                        
                    }) {
                        
                    }
                    .titleColor(.green)
                    .selectedLineColor(.blue)
                    .selectedTextColor(.blue)
                    .selectedTitleColor(.blue)
                    .frame(height: 70)
            Picker(selection: $nums) {
                ForEach(0 ..< 2 )
                {
                    it in
                    Text("\(UserTypes[it])")
                }
            } label: {
                ForEach(0 ..< 2 )
                {
                    it in
                    Text("\(UserTypes[it])")
                }
            }
            .pickerStyle(.segmented)

            Button(action: {
                let dateFormatter = DateFormatter()
                dateFormatter.dateFormat = "yyyy-MM-dd"
                if self.password == self.secondpassword && self.password != ""
                {
                    let prodiver = MoyaProvider<UserRequestAPI>()
                    prodiver.request(.register(userrequestrecord: UserRequestrecord( username: self.username, password: self.password, avatar: "avatar.jpg", email: self.email, usertype: self.UserTypes[self.nums], passwordchangedate: dateFormatter.string(from: Date()), lastlogindate: dateFormatter.string(from: Date())))) { result in
                        switch result
                        {
                        case .success(let req):
                            break
                        case .failure(_):
                            break
                        }
                    }
                    
                    self.isback = false
                }
            }, label: {
                Text("注册")
                    .font(.system(size : 25))
                    .fontWeight(.heavy)
                    .foregroundStyle(.white)
                    .frame(width: 100, height: 70)
                    .background(.blue)
                    .cornerRadius(20)
            })
        }
    }
}

#Preview {
    LoginView_Regisiter(isback: .constant(false))
}
